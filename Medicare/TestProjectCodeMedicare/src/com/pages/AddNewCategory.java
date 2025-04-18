package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategory {
	
	@FindBy(xpath="//a[contains(@href,'/medicare/manage/product')]")
	private WebElement manageProdBtn;
	
	@FindBy(xpath="(//button[contains(@type,'button')])[2]")
	private WebElement addCategoryBtn;
	
	@FindBy(xpath="(//input[contains(@id,'name')])[2]")
	private WebElement nameBox;
	
	@FindBy(xpath="(//textarea[contains(@id,'description')])[2]")
	private WebElement descriptionBox;
	
	@FindBy(xpath="(//input[contains(@type,'submit')])[2]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(@class,'navbar-brand')]")
	private WebElement medicareBtn;
	
	@FindBy(xpath="//a[contains(@id,'a_Cold Medicines')]")
	private WebElement newCategory;
	
	public AddNewCategory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void manageProductButton() throws InterruptedException {
		Thread.sleep(3000);
		manageProdBtn.click();
	}
	
	public void addCategoryButton() throws InterruptedException {
		Thread.sleep(3000);
		addCategoryBtn.click();
	}
	
	public void categoryDetails() throws InterruptedException {
		Thread.sleep(3000);
		nameBox.sendKeys("Cold Medicines");
		descriptionBox.sendKeys("Medicines for Cold");
		submitBtn.click();
		Thread.sleep(3000);
		
	}
	
	public void verifyNewCategory()
	{
		medicareBtn.click();
	}
	
	public void validateNewCategory()
	{
		String s=newCategory.getText();
		if (s.equalsIgnoreCase("Cold Medicines"))
		{
			System.out.println("New Category Added Successfully");
		}
		else
		{
			System.out.println("Failed to Identify New Category");
		}
	}

}
