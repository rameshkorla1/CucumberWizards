package com.wizards.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.wizards.factory.DriverFactory;

import io.cucumber.java.Scenario;

public class Utility {
	public static Scenario message;    

	public static void takeScreenShotAfterEveryStep() {
	        byte[] screenshot = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	        message.attach(screenshot, "image/png", "");
	}
}