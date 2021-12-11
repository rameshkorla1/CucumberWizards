Feature: Create User Account 
@CreateAccount
Scenario: To create the user Account

Given user is on login page
When user enter the email address 
Then user enters the account information
Then user verify succesful message "Welcome to your account. Here you can manage all of your personal information and orders."
