package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighLighter {
	
	public static void elementHighLighter(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("arguments[0],setAttribute('style','border:3px solid blue');",element);
				
	}

}
