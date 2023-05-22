package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.SeleniumSpecificMethods;
import utility.ExcelReader;

public class ExecuteAutomationPage {

	private static WebDriver driver;
	public ExecuteAutomationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy( xpath ="//select[@id='TitleId']" )
	private WebElement select_Title ;

	@FindBy(xpath =  "//input[@id='Initial']")
	private WebElement  textbox_Intial;
	
	
	@FindBy(xpath = "//input[@id='FirstName']" )
	private WebElement textbox_Firstname;
	
	
	@FindBy(xpath = "//input[@id='MiddleName']")
	private WebElement textbox_Middlename;
	
	
	//***************related methods*******************
	
	//form validation
	
	


}
