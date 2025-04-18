package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyAdminChanges {
	
	@FindBy(xpath="(//a[contains(@class,'navbar-brand')])")
	private WebElement medicareBtn;

	public VerifyAdminChanges(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void homePage()
	{
		medicareBtn.click();
	}
}
