Feature: Login with valid Credentials

@sanity
Scenario: Successful login with valid credentials
Given User launch the browser
And Opens URL "https://www.saucedemo.com/"
When User enter valid Username as "standard_user"
And User enter the valid Password as "secret_sauce"
And User click on Login button
Then User navigates to Main page