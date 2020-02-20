package steps;

import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import model.app.pages.HomePage;
import model.app.pages.ViewCartPage;
import model.app.ui.AddToCartOverlay;
import model.app.ui.ProductTile;
import model.datatable.Product;

public class CheckoutSteps extends BaseSteps {

	public CheckoutSteps(ContextInjection contextInjection) {
		super(contextInjection);
	}

	@Given("I Am At Page: {string}")
	public void I_Am_At_Page(String url) {
		driver.get(url);
	}

	@When("I Add Items To Cart")
	public void I_Add_Items_To_Cart(DataTable dataTable) {
		List<Product> products = dataTable.asList(Product.class);
		products.forEach(p -> System.out.println(p));

		HomePage homePage = new HomePage(driver);
		List<ProductTile> productTiles = homePage.getProductTiles(pt -> true);
		productTiles.forEach(pt -> System.out.println(pt));

		ProductTile productTile = homePage.getProductTile(pt -> products.get(0).getName().equals(pt.getName()));
		productTile.addToCart();
	}

	@Then("I Should See Total Cost: {double}")
	public void I_Should_See_Total_Cost(double expected) {
		AddToCartOverlay addToCartOverlay = new AddToCartOverlay(driver);
		ViewCartPage viewCartPage = addToCartOverlay.viewCart();
		Assert.assertEquals(viewCartPage.getTotalCost(), expected);
	}

}
