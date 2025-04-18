package in.swiggy.testscripts;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeAfter extends Tools {
	
	@Before
	public void setup(Scenario scenario)
	{
		Driver.init();
		driver.manage().window().maximize();
		driver.get("https://swiggy.in");		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}

