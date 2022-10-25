	package com.wizards.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.wizards.factory.DriverFactory;
import com.wizards.pages.ContactUsPage;
import com.wizards.pages.LoginPage;
import com.wizards.utility.ConfigFileReader;
import com.wizards.utility.ExcelReader;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	ConfigFileReader configFileReader;
	LoginPage loginPage;
	Scenario scenario;
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() throws InterruptedException {
		
		loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.navigateTo_HomePage();
		//scenario.log("Launch the App URL");
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");	
		contactUsPage.clickContactUs();
		//scenario.log("Click on the Contact Us page");
		Thread.sleep(5000);
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	     ExcelReader reader = new ExcelReader();
	     List<Map<String, String>> testData = reader.getData("./src/test/resources/config/contactusData.xlsx", SheetName);
	     String heading = testData.get(RowNumber).get("subjectheading");
	     String email = testData.get(RowNumber).get("email");
	     String orderRef = testData.get(RowNumber).get("orderref");
	     String message = testData.get(RowNumber).get("message");
		 
	     contactUsPage.fillContactUsForm(heading, email, orderRef, message);
		
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
		
	}

	@Then("it shows a succesful message {string}")
	public void it_shows_a_succesful_message(String expectedSuccessMessage) {
		String actualSuccMessg = contactUsPage.getSuccessMessg();
		
		Assert.assertEquals(actualSuccMessg, expectedSuccessMessage);
	}

}
