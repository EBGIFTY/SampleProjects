package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NegativeScenarioTesting {
	
	@FindBy(xpath="(//input[contains(@type,'submit')])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//em[contains(@id,'name.errors')]")
	private WebElement errMsg;

	public NegativeScenarioTesting(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void save()
	{
		saveBtn.click();
	}
	
	public void verifyErrMsg()
	{
		String str=errMsg.getText();
		if (str.equalsIgnoreCase("Please enter the product name!"))
		{
			System.out.println("Error Message Verified Successfully");
			System.out.println("Error Message: "+str);
		}
		
		else
		{
			System.out.println("Error Message Not Verified");
		}
		
	}
}
