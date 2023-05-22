package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.SeleniumSpecificMethods;
import utility.DriverManager;


public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*public static HomePage getInstance() {
		return new HomePage(DriverManager.getDriver());
	}*/
	
	@FindBy(name = "Login")
	private WebElement button_Login;
	
	
	public void click_Login() {
		SeleniumSpecificMethods.click(button_Login);
	}
	
}
