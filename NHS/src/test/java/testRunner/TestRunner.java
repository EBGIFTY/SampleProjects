package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		monochrome = true,
		plugin={"pretty", "html:target/Reports/cucumber-reports.html",
				"json:target/Reports/cucumber-reports.json",
				"junit:target/Reports/cucumber-reports.xml"},
		features= "src/test/java/features/nhs_JobSearch.feature",
		glue= "stepDefs",
		tags= "@NegativeTests"
		
		)
public class TestRunner {

	
}
