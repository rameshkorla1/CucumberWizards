@CreateAccount
Feature: Create User Account 

Scenario: To create the user Account

Given user is on login page
When user enter the email address 
Then user enters the account information
Then user verify succesful message "Your account has been created."
