package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextInjection {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup(); // TODO Use env vars
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // TODO Set dimension
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}

	@AfterStep
	public void capture(Scenario scenario) {
		byte[] imgBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(imgBytes, "image/png");
	}

}
