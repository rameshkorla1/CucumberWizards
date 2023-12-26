package com.wizards.steps;

import java.util.Properties;

import org.junit.Assert;

import com.wizards.factory.DriverFactory;
import com.wizards.pages.LoginPage;
import com.wizards.utility.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	//ConfigFileReader configFileReader;
	
	
    static String title;
	@Given("user is on application page")
	public void user_is_on_application_page() {
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");	
		loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.navigateTo_HomePage();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
	    title =loginPage.getLoginPageTitle();
		System.out.println("login page title is:" +title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	   Assert.assertTrue(title.contains(string));
	}

//	@Given("user is on the Login page")
//	public void user_is_on_the_login_page() {
//		
//	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		  Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@When("user clicks on SignIn tab")
	public void user_clicks_on_SignIn_tab()
	{
		loginPage.clickOnSignIn();
	}

	@When("user enter the username {string}")
	public void user_enter_the_username(String username) {
		loginPage.waitToTimeLoad(4);
	    loginPage.enterUserName(username);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
		loginPage.waitToTimeLoad(2);
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

//	@Then("user gets title of the page")
//	public void user_gets_title_of_the_page() {
//	   
//	}

}
