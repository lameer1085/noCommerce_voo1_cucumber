package stepDefenitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import pageObject.addCustomerPage;
import pageObject.searchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public addCustomerPage custmPage;
	public searchCustomerPage	searchCustomer;
	public static Properties prop;
	
	public static Logger log;
	
	public String randomString() {
		
		String str= RandomStringUtils.randomAlphabetic(5);
		
		return str;
	}
}
