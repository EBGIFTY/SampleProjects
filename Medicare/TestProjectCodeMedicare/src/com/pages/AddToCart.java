package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddToCart {
	
	@FindBy(xpath="(//div[contains(@class,'col')])[4]/h6")
	private WebElement quantityAvailableBeforePurchase;
	
	@FindBy(xpath="(//a[contains(@class,'btn')])[2]")
	private WebElement addCart;
	
	public AddToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		addCart.click();
	}
	
	public void verifyQuantityBefore()
	{
		String quantity=quantityAvailableBeforePurchase.getText();
		System.out.println("Quantity Available before purchase: "+quantity);
	}

}
