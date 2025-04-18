package in.swiggy.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstRestaurant {
	
	WebDriverWait wait;
	
	@FindBy(xpath="(//div[contains(@class,'_3L1X9 F8dpS')])[1]")
	private WebElement clickAddBtn;
	
	@FindBy(xpath="//button[contains(@class,'_1gPB7')]")
	private WebElement checkOutBtn;
	
	public FirstRestaurant(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public void clickAddBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(clickAddBtn));
		clickAddBtn.click();

	}
	
	public void checkoutBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(checkOutBtn));
		checkOutBtn.click();
	}
	
	
}
