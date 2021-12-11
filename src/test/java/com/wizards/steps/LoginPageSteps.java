package com.wizards.steps;

import org.junit.Assert;

import com.wizards.factory.DriverFactory;
import com.wizards.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    static String title;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");		
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

	@When("user enter the username {string}")
	public void user_enter_the_username(String username) {
	    loginPage.enterUserName(username);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
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
