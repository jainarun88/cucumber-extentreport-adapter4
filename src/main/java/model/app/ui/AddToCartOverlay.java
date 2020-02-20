package model.app.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.app.pages.ViewCartPage;

public class AddToCartOverlay {

	private WebDriver driver;
	private WebElement root;

	public AddToCartOverlay(WebDriver driver) {
		this.driver = driver;
		this.root = new WebDriverWait(driver, 60).until(r -> r.findElement(By.className("addToCartOverlay")));
	}

	public ViewCartPage viewCart() {
		new Actions(driver).moveToElement(root.findElement(By.className("btn"))).click().build().perform();
		return new ViewCartPage(driver);
	}

}
