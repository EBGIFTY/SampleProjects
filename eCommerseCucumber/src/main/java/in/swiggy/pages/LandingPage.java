package in.swiggy.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	WebDriverWait wait;
	
	@FindBy(id="location")
	private WebElement city;
	
	@FindBy(xpath="//span[contains(@class,'_2W-T9')]")
	private WebElement goBtn;
	
	@FindBy(xpath="(//div[contains(@class,'_3XX_A')])[1]")
	private WebElement firstRestaurant;

	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public void enterLocation(String str)
	{
		city.sendKeys(str);
	}
	
	public void clickGoBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(goBtn));
		goBtn.click();
	}
	
	public void clickFirstRestaurant()
	{
		wait.until(ExpectedConditions.visibilityOf(firstRestaurant));
		firstRestaurant.click();
	}
}
