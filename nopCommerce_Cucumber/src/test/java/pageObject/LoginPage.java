package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) { //Constructor
		
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);    // pageFactory= initializing elements, it is a  initializing elements
			//initElement = method to initialize the element
			//this = refers current instance of the class
	}
	@FindBy(id="Email")    //FindBy and FindAll = used to identify WebElements in Page Objects. 	
	@CacheLookup		//CacheLookup = aids in managing when to cache and when not to cache a WebElement.instructs Selenium to keep a cache of the WebElement instead of searching for the WebElement every time from the WebPage. This helps us save a lot of time
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//*[text()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String name) {
		txtEmail.clear();
		txtEmail.sendKeys(name);
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() {
		lnkLogout.click();
	}
	
}
