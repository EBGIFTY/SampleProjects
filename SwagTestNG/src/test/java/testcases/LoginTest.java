package testcases;

import org.testng.annotations.Test;

import pages. homepage;
import pages.loginpage;

public class LoginTest extends Baseclass{

	@Test
	public void TC01_LoginSuccessTest() {
		loginpage lp = new loginpage();
		 homepage hp = new homepage();
		lp.loginToSwagLabs("standard_user", "secret_sauce");
		hp.verifyHomePage();
	}


	@Test
	public void TC02_LoginFailureTest() {
		loginpage lp = new loginpage();
		lp.loginToSwagLabs("standard_user", "secret");
		lp.verifyErrorText("Epic sadface: Username and password do not match any user in this service");
	}


	@Test
	public void TC03_LockedUserTest() {
		loginpage lp = new loginpage();
		lp.loginToSwagLabs("locked_out_user", "secret_sauce");
		lp.verifyErrorText("Epic sadface: Sorry, this user has been locked out.");
	}


}