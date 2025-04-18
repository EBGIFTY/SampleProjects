package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyCategories {
	
	@FindBy(xpath="//a[contains(@id,'a_Cough Medicines')]")
	private WebElement newCategoryab;
	
	@FindBy(xpath="//a[contains(@id,'a_Cold Medicines')]")
	private WebElement newCategoryaq;

	public VerifyCategories(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCategory()
	{
		String sw=newCategoryab.getText();
		String sq=newCategoryaq.getText();
		System.out.println("New Category added as per UI: "+sq);
		System.out.println("New Category added as per DB: "+sw);
	}
}
