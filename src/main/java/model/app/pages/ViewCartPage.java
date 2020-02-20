package model.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends BasePage {

	public ViewCartPage(WebDriver driver) {
		super(driver);
	}

	public double getTotalCost() {
		return Double.parseDouble(getNumericValue(By.id("body_2_FullCartControl_TotalCost")));
	}

	private String getNumericValue(By by) {
		return driver.findElement(by).getText().replaceAll("[^\\d\\.]", "");
	}

}
