package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyRemainingQuantity {

	@FindBy(xpath="(//div[contains(@class,'col')])[4]/h6")
	private WebElement quantityAvailableAfterPurchase;
	
	@FindBy(linkText="Home")
	private WebElement homePage;
	
	
	public VerifyRemainingQuantity(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void HomePage()
	{
		homePage.click();
	}
	
	public void verifyQuantityAfter()
	{
		String quant=quantityAvailableAfterPurchase.getText();
		System.out.println("Quantity Available available for purchase: "+quant);
	}
}
