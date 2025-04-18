package in.swiggy.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	
	WebDriverWait wait;
	
	@FindBy(xpath="//div[contains(@class,'B5DgV')]")
	private WebElement checkOutMsg;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public String checkCheckOutMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(checkOutMsg));
		return checkOutMsg.getText();
		
	}

	
}
