package stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Exports;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Screenshot;

public class Hooks {

	public static WebDriver driver;
	
	
	public static ExtentReports report = new ExtentReports("target/Reports/ExtentReport.html", false);
	
	//static String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	//public static ExtentReports report = new ExtentReports("target/Reports/ExtentReport_" + timestamp + ".html", false);
	public static ExtentTest test;

	@Before("@ChromeBrowser")
	public void Setup(Scenario scenario) {

		test = report.startTest(scenario.getName());

		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After("@ChromeBrowser")
	public void TearDown(Scenario scenario) {
		
		try {
			if (scenario.isFailed())
			{
				test.log(LogStatus.FAIL, "Test Failed: " + scenario.getName());

				try 
				{
					String screenshotPath = Screenshot.takeScreenshot(driver, scenario.getName());
					test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
				} 
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
			} 
			else if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) { 
				test.log(LogStatus.PASS, "Test Passed: " + scenario.getName());
			} 
			else
			{
				test.log(LogStatus.SKIP, "Test Skipped: " + scenario.getName());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		
		finally

		{
            report.endTest(test);
			report.flush();

			if (driver != null)
			{
				driver.quit();
			}
		}
		// report.close();
	}

	@Before("@FireFoxBrowser")
	public void SetupFireFox(Scenario scenario) {

		test = report.startTest(scenario.getName());

		WebDriverManager.firefoxdriver().clearDriverCache().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@After("@FireFoxBrowser")
	public void TearDownFireFox(Scenario scenario) {

		if (scenario.isFailed()) {
			test.log(LogStatus.FAIL, "Test Failed: " + scenario.getName());

			try {
				String screenshotPath = Screenshot.takeScreenshot(driver, scenario.getName());
				test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) { 
			test.log(LogStatus.PASS, "Test Passed: " + scenario.getName());
		} else {
			test.log(LogStatus.SKIP, "Test Skipped: " + scenario.getName());
		}

		report.endTest(test);
		report.flush();

		if (driver != null) {
			driver.quit();
		}
		// report.close();
	}

}
