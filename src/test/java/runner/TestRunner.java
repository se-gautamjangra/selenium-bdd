package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@automationTest", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/cucumber.json"}, glue = "com.gautam.stepDefinitions",
        dryRun = false,
        features = "src/test/resources/features/")
public class TestRunner {

}
