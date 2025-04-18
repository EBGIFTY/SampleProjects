package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy(xpath="(//a[contains(@class,'btn')])[2]")
	private WebElement view;
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickViewParacetamol() {
		view.click();
	}
}
