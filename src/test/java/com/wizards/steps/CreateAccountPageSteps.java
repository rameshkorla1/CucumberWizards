package com.wizards.steps;

import org.junit.Assert;

import com.wizards.factory.DriverFactory;
import com.wizards.pages.CreateAccountPage;
import com.wizards.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountPageSteps {
	
	private CreateAccountPage accountPage = new CreateAccountPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	DriverFactory driverFactory;
	
	@When("user enter the email address")
	public void user_enter_the_email_address() throws InterruptedException {
	    loginPage.clickOnSignIn();
		loginPage.emailAddressWithDomain("aol.com");
		Thread.sleep(3000);
		loginPage.clickOnCreateAccount();
	}

	@Then("user enters the account information")
	public void user_enters_the_account_information() throws InterruptedException {
		
		accountPage.enterFristName();
		accountPage.enterLastName();
		accountPage.getPassword();
		accountPage.selectDays("12");
		accountPage.selectMonth("3");
		accountPage.selectYear("1980");
//		accountPage.Company("Vectramind");
//		accountPage.Address("Time square, Build 215, NewYork");
//		accountPage.City("New York");
//		Thread.sleep(3000);
//		accountPage.selectState("New York");
//		accountPage.PostalCode("20134");
//		accountPage.MobilePhone("15054544333");
//		accountPage.MyAddress("HomeAddress");
		accountPage.clickOnRegister();		
	}
	@Then("user verify succesful message {string}")
	public void user_verify_succesful_message(String expectedSuccessMessage) {
		String actualSuccMessg = accountPage.getSuccessMessg();
		System.out.println("Success Message is:" +actualSuccMessg);
		Assert.assertEquals(actualSuccMessg, expectedSuccessMessage);
	}

}
