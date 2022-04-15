package com.wizards.AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.wizards.factory.DriverFactory;
import com.wizards.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@AfterStep
	public void stepScreenshot(Scenario scenario) throws IOException
	{
		//String screenshotName =scenario.getName().replaceAll(" ", "_");
		//scenario.attach(Screenshot.getByteScreenshot(driver), "image/png", "");
		 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	     scenario.attach(screenshot, "image/png", "image"); 
	}
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screenshot
			String screenshotName =scenario.getName().replaceAll("", "_");
			byte[] sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(sourcepath, "image/png", screenshotName);
		}		
	}
}
