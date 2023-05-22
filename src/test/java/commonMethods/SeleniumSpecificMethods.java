package commonMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hooks.Hooks;
import utility.GetLog;
import utility.HighLighter;
import utility.DriverManager;

public class SeleniumSpecificMethods {


	//public static WebDriver driver=DriverManager.getDriver();
	//for logging 
	public static final Logger LOGGER=LogManager.getLogger(SeleniumSpecificMethods.class);
	//-----------------------------Windows related-----------------------------------

	/***
	 * @author Krishna Mohan
	 * to get the current browser. It will call static property utility.InvokeBrowser.driver
	 * @return WebDriver
	 */

	/*public static WebDriver getDriver() {
		return DriverManager.driver;
	}	*/

	/***
	 * to maximize the window
	 * @author Krishna Mohan
	 */
	public static void windowMaximize() {
		DriverManager.getDriver().manage().window().maximize();

		LOGGER.info("Window maximized");

	}






	public static void validate_PageTitle(String expectedPageTitle) {

		Assert.assertEquals("window title "+expectedPageTitle+" doesnot match",expectedPageTitle, DriverManager.getDriver().getTitle());

		LOGGER.info("page title validated");

	}





	//-----------------------shifting window focus--------------------------------------

	/***
	 * @author Krishna Mohan
	 * to get all the window handles.
	 * @return Object[]
	 */

	public static Object[] getAllWindowHandles() {
		Set<String> windowHandles=DriverManager.getDriver().getWindowHandles();
		Object[] arrayOfWindows=windowHandles.toArray();

		return arrayOfWindows;

	}
	/***
	 * for switching to last window
	 * @author Krishna Mohan
	 */
	public static void switch_To_Last_Window() {
		Set<String> windowHandles=DriverManager.getDriver().getWindowHandles();

		//converting Set<String> to Object array, so that it can be used to navigate to specific page through index
		//Object[] arrayOfWindows=windowHandles.toArray();

		for (String windowHandle : windowHandles) {
			DriverManager.getDriver().switchTo().window(windowHandle);
		}

		LOGGER.info("focus shifted to last window");

		SeleniumSpecificMethods.windowMaximize();

	}

	/***
	 * to shift the focus to respective window
	 * @param windows
	 * @param pageIndexNumber
	 */
	public static void switch_To_Specific_Window(Object[] windows,int pageIndexNumber) {

		DriverManager.getDriver().switchTo().window((String)windows[pageIndexNumber]);

		LOGGER.info("focus shifted to "+pageIndexNumber+" window");

	}





	//------------------------------webelement actions related--------------------------


	/***
	 * @author Krishna Mohan
	 * To click on webelement
	 * @param link
	 */
	public static void click(WebElement link ) {
		

		String text_Link=link.getText();

		//HighLighter.elementHighLighter(link);

		link.click();

		LOGGER.info("clicked on the link "+text_Link);

	}

	/***
	 * To enter data in text field
	 * @author Krishna Mohan
	 * @param textBox
	 * @param dataToEnter
	 */
	public static void enterText_TextField(WebElement textBox,String dataToEnter) {


		//HighLighter.elementHighLighter(textBox);

		textBox.sendKeys(dataToEnter);

		if(textBox.getText().equals(dataToEnter)) {

			LOGGER.info(dataToEnter+" entered ");
		}
	}

	/***
	 * to check the text in a page
	 * @author Krishna Mohan
	 * @param element
	 * @param expectedText
	 */
	public static void check_Text(WebElement element,String expectedText) {

		//HighLighter.elementHighLighter(element);

		Assert.assertEquals("expected page not opened",expectedText, element.getText());

	}

	//--------------------------------lable------------------------------------


	public static String getText_lable(WebElement element) {

		//HighLighter.elementHighLighter(element);

		return element.getText();
	}



	//---------------------------------Dropdown----------------------------------

	public static void selectFromDropDown(WebElement element_Dropdown,String howTo,String value) {

		Select select=new Select(element_Dropdown);
		switch(howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);
			break;

		case "text":
			select.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("please provide valid selection option");
			break;
		}


	}

	public static void selectFromDropDownByIndex(WebElement element_Dropdown,int index) {

		Select select=new Select(element_Dropdown);
		select.selectByIndex(index);

	}

	public static void selectFromDropDownByValue(WebElement element_Dropdown,String value) {

		Select select=new Select(element_Dropdown);
		select.selectByValue(value);;

	}

	public static void selectFromDropDownByVisibleText(WebElement element_Dropdown,String value) {

		Select select=new Select(element_Dropdown);
		select.selectByVisibleText(value);

	}

	public static void selectMultipleOptionsFromDropdown(WebElement element_Dropdown,String howTo,List<String> values) {

		Select select=new Select(element_Dropdown);
		switch(howTo) {
		case "index":
			for (String value : values) {
				select.selectByIndex(Integer.parseInt(value));	
			}

			break;

		case "value":
			for (String value : values) {
				select.selectByValue(value);	
			}
			break;

		case "text":
			for (String value : values) {
				select.selectByVisibleText(value);
			}
			break;

		default:
			LOGGER.info("please provide valid selection option");
			break;
		}
	}


	public static void selectMultipleOptionsFromDropdownByIndex(WebElement element_Dropdown,List<String> indexs) {

		Select select=new Select(element_Dropdown);

		for (String index : indexs) {
			select.selectByIndex(Integer.parseInt(index));	
		}
	}

	public static void selectMultipleOptionsFromDropdownByValue(WebElement element_Dropdown,List<String> values) {

		Select select=new Select(element_Dropdown);

		for (String value : values) {
			select.selectByValue(value);	
		}

	}


	public static void selectMultipleOptionsFromDropdownByVisibleText(WebElement element_Dropdown,List<String> values) {

		Select select=new Select(element_Dropdown);

		for (String value : values) {
			select.selectByVisibleText(value);	
		}

	}

}