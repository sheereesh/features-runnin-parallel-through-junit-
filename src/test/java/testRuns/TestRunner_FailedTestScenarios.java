package testRuns;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)



@CucumberOptions(

//to run the failed test cases which is generated in the below text file
		features="@target/failedRerun.txt",


		glue = {"stepDefinations","hooks"},

		plugin = {"pretty",


				//for exten reports
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		
		//for running failed testcases
		"rerun:target/failedRerun.txt"},
		
		dryRun = false,
		monochrome = true
		)


public class TestRunner_FailedTestScenarios {
	
	

}
