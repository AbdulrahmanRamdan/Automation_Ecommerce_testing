package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src\\main\\resources\\features"},
        glue = {"StepDefinition"},
        tags = "@SmokeTest",
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        dryRun = false

)

public class TestRunner extends AbstractTestNGCucumberTests {
}