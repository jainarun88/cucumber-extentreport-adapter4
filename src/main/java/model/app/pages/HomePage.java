package model.app.pages;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.app.ui.ProductTile;

public class HomePage extends BasePage {

	private By productTileBy = By.className("product-tile-wrapper");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ProductTile getProductTile(Predicate<ProductTile> condition) {
		return driver.findElements(productTileBy).stream().map(ProductTile::new).filter(condition).findFirst()
				.orElseThrow(() -> new RuntimeException("Product not found!"));
	}

	public List<ProductTile> getProductTiles(Predicate<ProductTile> condition) {
		return driver.findElements(productTileBy).stream().map(ProductTile::new).filter(condition)
				.collect(Collectors.toList());
	}

}
