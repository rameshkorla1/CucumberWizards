package com.wizards.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;
import com.wizards.utility.ConfigFileReader;

public class LoginPage {
	
	public  WebDriver driver;
	Faker data = new Faker();
	ConfigFileReader configFileReader;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		configFileReader= new ConfigFileReader();
	}
	// 
	private By SignIn = By.xpath("//a[@class='login']");
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIbButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	private By emailAddress = By.xpath("//*[@id='email_create']");
	private By createAccount = By.cssSelector("button[id='SubmitCreate']");
	
  // page actions;
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnSignIn()
	{
		driver.findElement(SignIn).click();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnLogin()
	{
		driver.findElement(signIbButton).click();
	}
	
	public void navigateTo_HomePage() {
		driver.get(configFileReader.getApplicationUrl());
	}
	
	public AccountsPage doLogin(String username, String pwd)
	{
		driver.findElement(SignIn).click();
		System.out.println("login with: "+username+"and"+pwd);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIbButton).click();
		return new AccountsPage(driver);
	}
	
	public String emailAddress()
	{
	    data = new Faker();
		driver.findElement(emailAddress).click();
		String email = data.internet().emailAddress();
		driver.findElement(emailAddress).sendKeys(email);
		return email;
	}
	
	public String emailAddressWithDomain(String domain) {
        data = new Faker();
        driver.findElement(emailAddress).click();
        String email = data.internet().emailAddress();       
        // Append the desired domain to the generated email
        email = email.split("@")[0] + "@" + domain;
        driver.findElement(emailAddress).sendKeys(email);
        System.out.println("Email Address is:" +email);
        return email;
    }
	
	public void clickOnCreateAccount() throws InterruptedException
	{
		Actions actions = new Actions(driver); 
		WebElement element = driver.findElement(createAccount);
		actions.doubleClick(element).perform(); 
		element.click();
		Thread.sleep(10000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("argument[0].click();", element);
	}
	
	public void waitToTimeLoad(int seconds) {		
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
