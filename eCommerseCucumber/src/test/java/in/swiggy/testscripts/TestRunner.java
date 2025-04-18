package in.swiggy.testscripts;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

		@CucumberOptions(features="Features"
						 ,glue="in.swiggy.testscripts"
						 ,plugin={"progress","html:target/Cucumber.html"}
						 ,tags="@Swiggy"
						 //,dryRun=true
						 )

public class TestRunner extends AbstractTestNGCucumberTests {

}
