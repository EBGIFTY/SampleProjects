package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(xpath="//input[contains(@id,'count_44')]")
	private WebElement quantity;
	
	@FindBy(xpath="(//button[contains(@type,'button')])[2]")
	private WebElement refreshBTN;
	
	@FindBy(linkText="Checkout")
	private WebElement checkoutBTN;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void provideQuantity()
	{
		quantity.clear();
		quantity.sendKeys("2");
	}
	
	public void refreshButton()
	{
		refreshBTN.click();
	}
	
	public void CheckOutButton() throws InterruptedException
	{
		Thread.sleep(3000);
		checkoutBTN.click();
	}
	
	
	

}
