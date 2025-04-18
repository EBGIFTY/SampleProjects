package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath="(//a[contains(@id,'dropdownMenu1')])")
	private WebElement dropdown;
	
	@FindBy(linkText="Logout")
	private WebElement logoutBtn;
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logoutUser() throws InterruptedException
	{
		dropdown.click();
		Thread.sleep(2000);
		logoutBtn.click();
	}
}
