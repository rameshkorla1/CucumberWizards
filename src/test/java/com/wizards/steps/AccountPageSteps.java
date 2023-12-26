package com.wizards.steps;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.wizards.factory.DriverFactory;
import com.wizards.pages.AccountsPage;
import com.wizards.pages.LoginPage;
import com.wizards.utility.ConfigFileReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	ConfigFileReader configFileReader;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		List<Map<String, String>>credList = dataTable.asMaps();
		String username =credList.get(0).get("username");
		String password =credList.get(0).get("password");
		loginPage.navigateTo_HomePage();
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage =loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {		
		String title =accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: "+title);
	}
	
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> expectedAccountSectionList = sectionsTable.asList();
		System.out.println("Expected accounts section list: "+ expectedAccountSectionList);
		List<String> actualAccountSectionList = accountsPage.getAccountsSectionList();
		System.out.println("Actual accounts section list: "+actualAccountSectionList);
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}
	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {

		Assert.assertTrue(accountsPage.getAccountsSectionCount()== expectedSectionCount);
	}
	
}
