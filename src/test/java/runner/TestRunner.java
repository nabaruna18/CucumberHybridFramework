package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
				glue = { "stepdefinitions", "hooks" },
				publish =true,
				plugin={"pretty","html:target/CucumberReports/CucumberReports.html"})
public class TestRunner {

}
