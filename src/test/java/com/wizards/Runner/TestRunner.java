package com.wizards.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue= {"com.wizards.steps","com.wizards.AppHooks"},
		plugin= {"pretty", 
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		         "timeline:test-output-thread/",
		         "rerun:target/failedRerun.txt"
		 },
		tags="@CreateAccount"
		)
public class TestRunner {

}
