package utility;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {


	private static WebDriver driver=null;


	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}



	public static WebDriver getDriver() {
		return driver;
	}

	private static Properties getPropertiesFromPropertyReader;

	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);

	public WebDriver launchBrowser() {

		//creating the object of PropertyReader by passing the property file name
		//PropertyReader obj_PropertyReader=new PropertyReader(Constants.getBrowser_Url_PropertiesFileName());
		//to get the property values
		getPropertiesFromPropertyReader=PropertyReader.getProperties(Constants.getBrowser_Url_PropertiesFileName());

		System.out.println(getPropertiesFromPropertyReader);

		try {


			switch(getPropertiesFromPropertyReader.getProperty("browser")) {
			case "chrome":
				
				ChromeOptions obj_chromeoOptions=new ChromeOptions();
				obj_chromeoOptions.addArguments("InCognito");
				obj_chromeoOptions.addArguments("start-maximized");
				
				

				WebDriverManager.chromedriver().setup();
				
				DriverManager.setDriver(new ChromeDriver(obj_chromeoOptions));
				//driver=new ChromeDriver(obj_chromeoOptions);

				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();

				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();

				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();

				break;

			default:
				ChromeOptions obj_chromeoOptions1=new ChromeOptions();
				obj_chromeoOptions1.addArguments("InCognito");
				obj_chromeoOptions1.addArguments("start-maximized");

				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(obj_chromeoOptions1);

				break;


			}


		}catch(Exception e) {
			LOGGER.info(e);
		}


		/*
		if(getPropertiesFromPropertyReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions obj_chromeoOptions=new ChromeOptions();
			obj_chromeoOptions.addArguments("InCognito");
			obj_chromeoOptions.addArguments("start-maximized");

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(obj_chromeoOptions);
		}
		 */		

		return driver;
	}





	//to open url

	public WebDriver openUrl(WebDriver driver) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get(getPropertiesFromPropertyReader.getProperty("url"));

		return driver;
	}



	//to close browser
	public static void browserClose(WebDriver diriver) {
		driver.close();
	}


}
