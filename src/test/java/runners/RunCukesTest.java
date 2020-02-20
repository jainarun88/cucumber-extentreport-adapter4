package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/resources/features" }, glue = { "steps" }, tags = { "not @ignore" }, plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"html:target/cucumber-html-default", "json:target/cucumber-report.json",
		"junit:target/cucumber-report.xml" }, snippets = SnippetType.UNDERSCORE, strict = true, monochrome = true, dryRun = false)
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
