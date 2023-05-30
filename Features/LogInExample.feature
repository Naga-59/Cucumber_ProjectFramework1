Feature: login with valid credential and example keyword

@sanity
Scenario Outline: Successful login with valid credential by using example keyword
Given User launch the browser
And Opens URL "https://www.saucedemo.com/"
When User enter valid Username as "<username>"
And User enter the valid Password as "<password>"
And User click on Login button
Then User navigates to Main page

Examples:
|   username                  |   password    |
|   standard_user             |   secret_sauce|
|   locked_out_user           |   secret_sauce|
|   problem_user              |   secret_sauce|
|   performance_glitch_user   |   secret_sauce|