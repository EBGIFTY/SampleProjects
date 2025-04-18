package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUser {
	
	@FindBy(linkText="Login")
	private WebElement loginBtn;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//input[contains(@value,'Login')]")
	private WebElement loginBtnUser;	
	
	public LoginPageUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginButton()
	{
		loginBtn.click();
	}
	
	public void enterUsername()
	{
		username.sendKeys("kn@gmail.com");
	}

	public void enterPassword()
	{
		password.sendKeys("12345");
	}
	
	public void loginSuccessful()
	{
		loginBtnUser.click();
	}
	
	

}
