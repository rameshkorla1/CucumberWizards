package com.wizards.Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		stepNotifications = true,
		features = "src/test/resources/features",
		glue= {"com.wizards.steps","com.wizards.AppHooks"},
		plugin= {"pretty", 
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		         "timeline:test-output-thread/",
		         "rerun:target/failedRerun.txt",
		         "json:cucumber-reports/Cucumber.json",
		         "junit:target/test-results/cucumber-resutls.xml"
		 }, monochrome = true
		)
public class TestRunner {
	
//	@DataProvider(parallel = true)
//    public Object[][] scenarios() 
//	{
//         return super.scenarios();
//    }

}
