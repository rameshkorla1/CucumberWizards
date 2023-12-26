package com.wizards.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class CreateAccountPage {
	
	private WebDriver driver;
	Faker data = new Faker();
	
	public By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	public By Password = By.id("passwd");
	private By Days = By.id("days");
	private By Months = By.id("months");
	private By Years = By.id("years");
	
	private By FirstName = By.id("firstname");
	private By LastName = By.id("lastname");
	private By Company = By.id("company");
	private By Address = By.id("address1");
	
	private By City = By.id("city");
	private By State = By.id("id_state");
	private By PostalCode = By.id("postcode");
	private By MobilePhone = By.id("phone_mobile");
	private By AliasAddress =  By.id("alias");
	
	private By Register = By.cssSelector("button[id='submitAccount']");
	private By successMessg = By.xpath("//*[@id='center_column']//p[1]");
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String enterFristName()
	{
		data = new Faker();
		String fristname = data.name().firstName();
		driver.findElement(firstName).sendKeys(fristname);
		return fristname;
	}
	
	public String enterLastName()
	{
		data = new Faker();
		String lastname = data.name().lastName();
		driver.findElement(lastName).sendKeys(lastname);
		return lastname;
	}
	
	public String getPassword()
	{
		data = new Faker();
		String Pswd = data.internet().password();
		driver.findElement(Password).sendKeys(Pswd);
		System.out.println("Password is:" + Pswd);
		return Pswd;
	}

	
	public void selectDays(String text)
	{
		WebElement day = driver.findElement(Days);
		day.click();
		Select dayDrp = new Select(day);
		dayDrp.selectByValue(text);
	}
	
	public void selectMonth(String text)
	{
		WebElement month = driver.findElement(Months);
		month.click();
		Select dayDrp = new Select(month);
		dayDrp.selectByValue(text);
	}
	
	public void selectYear(String text)
	{
		WebElement year = driver.findElement(Years);
		year.click();
		Select dayDrp = new Select(year);
		dayDrp.selectByValue(text);
	}
	
	public void enterAddressFirstName()
	{
		String text = enterFristName();
		driver.findElement(FirstName).sendKeys(text);
	}

	public void enterAddressLastName()
	{
		String text = enterLastName();
		driver.findElement(LastName).sendKeys(text);
	}

    public void Company(String text)
    {
    	driver.findElement(Company).sendKeys(text);
    }
    
    public void Address(String text)
    {
    	driver.findElement(Address).sendKeys(text);
    }
    
    public void City(String text)
    {
    	driver.findElement(City).sendKeys(text);
    }
    
    public void selectState(String text)
    {
    	WebElement state = driver.findElement(State);
    	state.click();
    	Select statedrp = new Select(state);
    	statedrp.selectByVisibleText(text);
    }
    
    public void PostalCode(String text)
    {
    	driver.findElement(PostalCode).sendKeys(text);
    	//MobilePhone
    }
    
    public void MobilePhone(String text)
    {
    	driver.findElement(MobilePhone).sendKeys(text);
    }
    
    public void MyAddress(String text)
    {
    	driver.findElement(AliasAddress).clear();
    	driver.findElement(AliasAddress).sendKeys(text);
    }
    
    public void clickOnRegister()
    {
    	driver.findElement(Register).click();
    }
    public String getSuccessMessg()
	{
		return driver.findElement(successMessg).getText().trim();
	}
	
}
