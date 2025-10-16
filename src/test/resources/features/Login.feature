@Regression
@Login
Feature: LoginPage Feature

Background: 
Given user is on application page

Scenario: Login Page Title

When user clicks on SignIn tab
And user gets the title of the page 
Then page title should be "My Shop"

Scenario: Forgot Password link

#Given user is on login page
When user clicks on SignIn tab
Then forgot your password link should be displayed

Scenario: Login with Correct credentials 

When user clicks on SignIn tab
And user enter the username "ramesh.korla@outlook.com"
And  user enter the password "Tester@123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Shop"
