package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class OrangeHRMSteps {
	
	WebDriver driver;
	
	@Given("I launch the chrome browser")
	public void i_launch_the_chrome_browser() {
		String currentDirectory = System.getProperty(null);
	    System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium\\LocalEclipse\\Cucumber\\chromedriver.exe");
	    driver= new ChromeDriver();
	    	    
	}

	@When("open the orangehrm home page")
	public void open_the_orangehrm_home_page() {
	    
		driver.get("https://www.orangehrm.com/en/orangehrm-starter-open-source-software");

	}

	@And("I verfy logo present on the home page")
	public void i_verfy_logo_present_on_the_home_page() {
	 boolean status = driver.findElement(By.xpath("(//img[@alt='OrangeHRM Logo'])[1]")).isDisplayed();
	
	 Assert.assertEquals(true, status);
	
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
}
