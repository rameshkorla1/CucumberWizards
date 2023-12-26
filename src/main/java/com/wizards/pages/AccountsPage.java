package com.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSections = By.cssSelector("div[id='center_column'] span");
	
	
	// constructor
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	public int getAccountsSectionCount()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(accountSections));
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList()
	{
		List<String>accountsList  = new ArrayList<>();
		List<WebElement>accountsHeaderList = driver.findElements(accountSections);
		for(WebElement e: accountsHeaderList)
		{
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}
	

}
