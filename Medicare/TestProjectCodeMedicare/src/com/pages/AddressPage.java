package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	

	@FindBy(linkText="Select")
	private WebElement address;
	
	public AddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectAddress() {
		address.click();
	}

}
