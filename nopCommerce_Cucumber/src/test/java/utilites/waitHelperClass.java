package utilites;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelperClass {

	public WebDriver driver;
	
	public waitHelperClass(WebDriver rdriver) {
		this.driver=rdriver;
	}
	
	
	public void waitForCondition(WebElement element, long timesInSeconds) {
		WebDriverWait wait =new WebDriverWait(driver, timesInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
