Feature: Buy food on Swiggy

@Swiggy
Scenario: A user should be able to purchase and order food on Swiggy
Given A user is on the landing page of Swiggy
When He enters the city in search box as 'Bangalore,Karnataka,India'
And He clicks on Go button
And He clicks on the first restaurant on the next page
And He clicks on the Add button on the first item of the restaurant page
And He clicks Checkout button
Then He should verify that he is on the Checkout page by verifying the text SECURE CHECKOUT


