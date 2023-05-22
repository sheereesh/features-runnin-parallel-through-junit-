package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonMethods.SeleniumSpecificMethods;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utility.DriverManager;
import utility.ScreenShot;

public class Hooks {


	private static WebDriver driver=null;
	
	public static DriverManager obj_DriverManager;
	//private static Scenario scenario;
	
	//for logging 
	public static final Logger LOGGER=LogManager.getLogger(Hooks.class);
	

	//to open browser and url
	
	//geting instance of this class
	public static Hooks getInstance() {
		return new Hooks();
	}
	
	@Before
	public void openBrowserAndUrl() {
		
		obj_DriverManager=new DriverManager();
	
		LOGGER.info("Invoking the browser");
		
		if (DriverManager.getDriver()==null) {
			
			driver=obj_DriverManager.openUrl(obj_DriverManager.launchBrowser());
			LOGGER.info("url opened");
		}
		
		else
			LOGGER.error("Driver is not null");
		
		
	}
	
	/**
	 * @author Krishna Mohan
	 * to get the scenario name
	 * @return String 
	 */
	
	/*@Before(order=1)
	public String getScenarioName(Scenario scenario) {
		
		return scenario.getName().replace(" ", "_");
	}*/

	/*@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) SeleniumSpecificMethods.getDriver()).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}*/
	
	
	@After(order = 2)
	public void takeAndAttachScreenshotToReports(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
	try {
		//taking screenshot for the failed testcase
		ScreenShot.takeScreenshotForFailTestCase(scenario);
		
		
	} catch (IOException e) {
		System.out.println("please check the screen shot output");
	}

		}
	}
/*
	//to close browser
	@After(order = 1)
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
*/
}
