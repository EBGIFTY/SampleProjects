package in.swiggy.testscripts;

import org.openqa.selenium.chrome.ChromeDriver;

import in.swiggy.pages.CheckOutPage;
import in.swiggy.pages.FirstRestaurant;
import in.swiggy.pages.LandingPage;

public class Driver extends Tools {

	protected static LandingPage landingPage;
	protected static FirstRestaurant firstRestaurant;
	protected static CheckOutPage checkOutPage;
	
	public static void init()
	{
		System.setProperty("webDriver.chrome.driver", "Resources//chromedriver.exe");
		driver=new ChromeDriver();
		landingPage=new LandingPage(driver);
		firstRestaurant=new FirstRestaurant(driver);
		checkOutPage=new CheckOutPage(driver);
		
	}
}
