package model.app.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class ProductTile {

	private WebElement root;

	public ProductTile(WebElement root) {
		this.root = root;
	}

	public String getName() {
		return root.findElement(By.className("product-tile-brand")).getText();
	}

	public BigDecimal getPrice() {
		return new BigDecimal(getNumericValue(By.className("price"))).setScale(2, RoundingMode.HALF_UP);
	}

	public int getQty() {
		return Integer.parseInt(root.findElement(By.className("quantityinput")).getAttribute("value"));
	}

	public AddToCartOverlay addToCart() {
		root.findElement(By.tagName("button")).click();
		return new AddToCartOverlay(((WrapsDriver) root).getWrappedDriver());
	}

	@Override
	public String toString() {
		return "ProductTile [name=" + getName() + ", price=" + getPrice() + ", qty=" + getQty() + "]";
	}

	private String getNumericValue(By by) {
		return root.findElement(by).getText().replaceAll("[^\\d\\.]", "");
	}

}
