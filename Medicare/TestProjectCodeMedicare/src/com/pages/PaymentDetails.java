package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetails {
	
	@FindBy(xpath="//input[contains(@id,'cardNumber')]")
	private WebElement cardNbr;
	
	@FindBy(xpath="//input[contains(@id,'expityMonth')]")
	private WebElement expMnth;
	
	@FindBy(xpath="//input[contains(@id,'expityYear')]")
	private WebElement expYr;
	
	@FindBy(xpath="//input[contains(@id,'cvCode')]")
	private WebElement cvvNbr;
	
	@FindBy(linkText="Pay")
	private WebElement payBtn;
	
	public PaymentDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cardNumberDetails() 
	{
		cardNbr.sendKeys("1234567890");
	}
	
	public void expiryMonthDetails() 
	{
		expMnth.sendKeys("08");
	}
	
	public void expiryYearDetails() 
	{
		expYr.sendKeys("2022");
	}
	
	public void cvvNumberDetails() 
	{
		cvvNbr.sendKeys("1234");
	}
	
	public void PayBtn() 
	{
		payBtn.click();
	}
}
