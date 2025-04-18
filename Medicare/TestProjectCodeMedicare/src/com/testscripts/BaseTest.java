package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
			//Launch the Browser
			System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			
			//Maximize the Window
			driver.manage().window().maximize();
			
			//Navigate to the Application
			driver.get("http://localhost:8080/medicare/home");
	 }
	
	@AfterTest
	public void closeBrowser()
	{
		//Close the Browser
		driver.quit();

	}

}
