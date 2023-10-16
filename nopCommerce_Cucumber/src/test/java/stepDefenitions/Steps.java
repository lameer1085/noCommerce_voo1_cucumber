package stepDefenitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*; // "*"  is regular expression
import junit.framework.Assert;
import pageObject.LoginPage;
import pageObject.addCustomerPage;
import pageObject.searchCustomerPage;

public class Steps extends BaseClass {

	public String emailIdGenerated = randomString() + "@gmail.com";

	@Before // this is cucumber hook , this method will run before a this class
	public void setup() throws IOException {

		log = Logger.getLogger("noCommerce");
		PropertyConfigurator.configure("Log4j.properties");

		prop = new Properties();
		FileInputStream configProp = new FileInputStream("config.properties");
		prop.load(configProp);

		String br = prop.getProperty("browser");

		if (br.equals("chrome")) {
			// System.setProperty("webdrive.chrome.driver",
			// ".//Drivers//chromedriver.exe"/*System.getProperty("user.dir")+"//Drivers//chromedriver.exe"*/);
			System.setProperty("webdrive.chrome.driver", prop.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			// System.setProperty("webdrive.chrome.driver",
			// ".//Drivers//chromedriver.exe"/*System.getProperty("user.dir")+"//Drivers//chromedriver.exe"*/);
			System.setProperty("webdrive.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			// System.setProperty("webdrive.chrome.driver",
			// ".//Drivers//chromedriver.exe"/*System.getProperty("user.dir")+"//Drivers//chromedriver.exe"*/);
			System.setProperty("webdrive.ie.driver", prop.getProperty("iepath"));
			driver = new InternetExplorerDriver();
			
			log.info("******************* launching browser *********");
		}

	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		/*
		 * System.setProperty("webdrive.chrome.driver",
		 * ".//Drivers//chromedriver.exe"System.getProperty("user.dir")+
		 * "//Drivers//chromedriver.exe"); driver = new ChromeDriver();
		 * log.info("******************* launching browser *********");
		 */
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		log.info("******************* open browser *********");
		driver.manage().window().maximize();

	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String Email, String Password) {
		lp.setUserName(Email);
		lp.setPassword(Password);
		log.info("******************* provided login details *********");

	}

	@When("Click on login")
	public void click_on_login() {

		lp.clickLogin();
		log.info("******************* provided loging into the account *********");

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			Assert.assertTrue(false);
			log.info("******************* login failed *********");

		} else {
			Assert.assertEquals(string, driver.getTitle());
			log.info("******************* login pass *********");
		}
		// System.out.println("title veriicaton");

	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {

		lp.clickLogout();
		log.info("******************* log out successfully *********");
		// System.out.println("log out ");
	}

	@Then("Login Page Title should be {string}")
	public void Login_page_title_should_be(String string) {

		Assert.assertEquals(string, driver.getTitle());
		// System.out.println("title veriicaton 2");

	}

	@Then("Close the browser")
	public void close_the_browser() {

		driver.quit();
		// System.out.println("driver closed");

	}

	// Add new customer

	@Then("User csn view the dashboard")
	public void user_csn_view_the_dashboard() {
		custmPage = new addCustomerPage(driver);

		Assert.assertEquals("Dashboard / nopCommerce administration", custmPage.pageTitle());

	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(2000);
		custmPage.clickOnCustomerMenu();

	}

	@When("Click on customers menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		custmPage.clickOnCustomerItemInMenu();
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {

		custmPage.addNewCoustomerBtn();
		Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		Assert.assertEquals("Add a new customer / nopCommerce administration", custmPage.pageTitle());
		Thread.sleep(2000);
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {

		custmPage.enterEmail(emailIdGenerated);
		custmPage.enterPassword("ameer@123");
		custmPage.setFirstName("AMEER" + randomString());
		custmPage.setlastName("SALMAN" + randomString());
		custmPage.selectGender("male");
		custmPage.setCompanyName("myOwn");
		custmPage.setDOB("7/09/1998");
		/*
		 * Register is default we can't add "guest" and "register" on same time add
		 * customer role as "guest" or "register"
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//textArea[@id='AdminComment']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.xpath("//span[@class='k-select' and @title='delete']")).click();
		Thread.sleep(2000);
		custmPage.selectRole("Guests");
		Thread.sleep(2000);
		custmPage.setManagervendor("2");
		custmPage.setAdminContent("This is for testing purpose.....");

	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		custmPage.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmMassege) {

		String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		System.out.println("******* " + text + " ********");
		// Assert.assertTrue(text.contains("The new customer has been addded
		// successfully."));

	}

	// search by emailID
	@When("Enter customer Email")
	public void enter_customer_email() {

		searchCustomer = new searchCustomerPage(driver);
		System.out.println("***************" + emailIdGenerated + "**********");

		searchCustomer.enterEmail("victoria_victoria@nopCommerce.com");

	}

	@When("Clickon search button")
	public void clickon_search_button() throws InterruptedException {
		searchCustomer.clickSearchBtn();
		Thread.sleep(2000);

	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		// emailIdGenerated
		boolean status = searchCustomer.searchGivenEmailIdPrsentOrNot("victoria_victoria@nopCommerce.com");

		Assert.assertEquals(true, status);

	}

	// Search customer by name

	@When("Enter the customer firstName")
	public void enter_the_customer_first_name() {
		searchCustomer = new searchCustomerPage(driver);
		searchCustomer.enterFirstName("Victoria");

	}

	@When("Enter the customer lastName")
	public void enter_the_customer_last_name() {
		searchCustomer.enterLastName("Terces");

	}

	@Then("User should found name in seacrh table")
	public void user_should_found_name_in_seacrh_table() {
		boolean status = searchCustomer.searchGivenNameIsPrsentOrNot("Victoria Terces");

		Assert.assertEquals(true, status);

	}

}
