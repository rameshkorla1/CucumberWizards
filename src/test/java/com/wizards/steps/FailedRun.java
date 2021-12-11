package com.wizards.steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failedRerun.txt",
		glue= {"com.wizards.steps","com.wizards.AppHooks"},
		plugin= {"pretty", 
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		         "timeline:test-output-thread/",
		         "rerun:target/failedRerun.txt"
		 },
		tags="@Login"
		)
public class FailedRun {

}
