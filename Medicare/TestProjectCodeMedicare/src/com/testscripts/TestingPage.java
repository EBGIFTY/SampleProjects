package com.testscripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.pages.*;


public class TestingPage extends BaseTest{
	
	@Test (priority=0)
	public void positiveScenarioUser() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		LoginPageUser login=new LoginPageUser(driver);
		LandingPage landingPage=new LandingPage(driver);
		AddToCart addCart=new AddToCart(driver);
		CheckoutPage ck=new CheckoutPage(driver);
		AddressPage ap=new AddressPage(driver);
		PaymentDetails payment=new PaymentDetails(driver);
		OrderConfirmationPage ob=new OrderConfirmationPage(driver);
		VerifyRemainingQuantity vq= new VerifyRemainingQuantity(driver);
		
		//User Login	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		login.loginButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		login.enterUsername();
		login.enterPassword();
		login.loginSuccessful();
		Thread.sleep(3000);
		
		//Click View of Paracetamol Medicine on Landing Page
		landingPage.clickViewParacetamol();
		Thread.sleep(3000);		
		
		//Add the medicine to Cart
		addCart.verifyQuantityBefore();
		addCart.addToCart();
		Thread.sleep(3000);
		
		//Update Quantity and refresh the Amount
		ck.provideQuantity();
		ck.refreshButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout")));
		ck.CheckOutButton();
		Thread.sleep(3000);
		
		//Select Address for Delivery
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Select")));
		ap.selectAddress();
		Thread.sleep(3000);
		
		//Payment Details provided
		payment.cardNumberDetails();
		payment.expiryMonthDetails();
		payment.expiryYearDetails();
		payment.cvvNumberDetails();
		payment.PayBtn();
		Thread.sleep(3000);
		
		//Order Confirmation Page
		String actualText=ob.getSuccessMessage();
		String expectedText="Your Order is Confirmed!!";
		if(actualText.equals(expectedText))
		{
			System.out.println("Success Message Verified");
		}
		
		else
		{
			System.out.println("Invalid Success Message");
		}
		
		System.out.println("Proceeding to Continue Shopping Page");
		ob.continueShoppingBtn();
		
		//Verifying remaining Quantity
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		vq.HomePage();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'btn')])[2]")));
		landingPage.clickViewParacetamol();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'col')])[4]/h6")));
		vq.verifyQuantityAfter();
		
		
	}
		@Test (priority=1)
		public void positiveScenarioAdmin() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			LogoutPage lp=new LogoutPage(driver);
			LoginPageAdmin lpa=new LoginPageAdmin(driver);
			EditQuantityPage eqp=new EditQuantityPage(driver);
			LandingPage lp1=new LandingPage(driver);
			VerifyAdminChanges vac=new VerifyAdminChanges(driver);
			VerifyRemainingQuantity vq1= new VerifyRemainingQuantity(driver);
			
			//Logout Page for User
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@id,'dropdownMenu1')])")));
			lp.logoutUser();
			Thread.sleep(3000);
			//Enter Admin Details
			lpa.enterUsername();
			lpa.enterPassword();
			lpa.loginSuccessful();
			Thread.sleep(3000);
			
			//Click Paracetamol View Button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'btn')])[2]")));
			lp1.clickViewParacetamol();
			Thread.sleep(3000);
			
			//Edit Quantity by Admin
			eqp.quantityLeftBeforeEdit();
			eqp.clickEdit();
			eqp.editValue();
			Thread.sleep(3000);
			eqp.clickSave();
			Thread.sleep(3000);
			
			//Verify the changes made by Admin
			vac.homePage();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'btn')])[2]")));
			lp1.clickViewParacetamol();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'col')])[4]/h6")));
			vq1.verifyQuantityAfter();
		}
		
		@Test (priority=2)
		public void addCategoryValidationUItoDB() throws InterruptedException
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		AddNewCategory anc=new AddNewCategory(driver);
		anc.manageProductButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@type,'button')])[2]")));
		anc.addCategoryButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@id,'name')])[2]")));
		anc.categoryDetails();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'navbar-brand')]")));
		anc.verifyNewCategory();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@id,'a_Cold Medicines')]")));
		anc.validateNewCategory();
	}
		
		@Test (priority=3)
		public void addCategoryValidationDBtoUI() throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			VerifyCategories vc=new VerifyCategories(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@id,'a_Cough Medicines')]")));
			vc.validateCategory();
		}
		
		@Test (priority=4)
		public void NegativeScenarioTesting() throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			NegativeScenarioTesting nst=new NegativeScenarioTesting(driver);
			AddNewCategory anc1=new AddNewCategory(driver);
			anc1.manageProductButton();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@type,'submit')])[1]")));
			nst.save();
			nst.verifyErrMsg();
			
		}
	
	
}
