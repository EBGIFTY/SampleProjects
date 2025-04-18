package in.swiggy.testscripts;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyFoodSteps extends Driver {

	@Given("A user is on the landing page of Swiggy")
	public void a_user_is_on_the_landing_page_of_swiggy() {
	Assert.assertTrue(driver.getTitle().equals("Order food online from India's best food delivery service. Order from restaurants near you"));	
	}
	
	@When("He enters the city in search box as {string}")
	public void he_enters_the_city_in_search_box_as(String string) {
		landingPage.enterLocation(string);
	}
	@When("He clicks on Go button")
	public void he_clicks_on_go_button() {
		landingPage.clickGoBtn();
	}
	@When("He clicks on the first restaurant on the next page")
	public void he_clicks_on_the_first_restaurant_on_the_next_page() {
		landingPage.clickFirstRestaurant();

	}
	@When("He clicks on the Add button on the first item of the restaurant page")
	public void he_clicks_on_the_add_button_on_the_first_item_of_the_restaurant_page() {
		firstRestaurant.clickAddBtn();
	}
	@When("He clicks Checkout button")
	public void he_clicks_checkout_button() {
		firstRestaurant.checkoutBtn();
	}
	@Then("He should verify that he is on the Checkout page by verifying the text SECURE CHECKOUT")
	public void he_should_verify_that_he_is_on_the_checkout_page_by_verifying_the_text_secure_checkout(){
		String expectedText="SECURE CHECKOUT";
		String actualText=checkOutPage.checkCheckOutMsg();
		Assert.assertEquals(actualText,expectedText);
	}



}
