package steps;

import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

	protected WebDriver driver;

	public BaseSteps(ContextInjection contextInjection) {
		this.driver = contextInjection.getDriver();
	}

}
