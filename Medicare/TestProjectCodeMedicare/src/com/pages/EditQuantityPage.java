package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditQuantityPage {
	
	@FindBy(xpath="(//a[contains(@href,'/medicare/manage/1/product')])")
	private WebElement quantity;
	
	@FindBy(xpath="(//div[contains(@class,'col')])[4]/h6")
	private WebElement quantityBefore;
	
	@FindBy(xpath="(//input[contains(@id,'quantity')])")
	private WebElement quantitychange;
	
	@FindBy(xpath="(//input[contains(@name,'submit')])")
	private WebElement saveBtn;
	
	public EditQuantityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void quantityLeftBeforeEdit()
	{
		String s=quantityBefore.getText();
		System.out.println("Quantity before Admin updates: "+s);
	}
	
	public void clickEdit()
	{
		quantity.click();
	}	
	
	public void editValue()
	{
		quantitychange.clear();
		quantitychange.sendKeys("50");
		String sw=quantitychange.getText();
		System.out.println("Quantity after Admin updates: "+sw);
	}
	
	public void clickSave()
	{
		saveBtn.click();
		
	}
}
