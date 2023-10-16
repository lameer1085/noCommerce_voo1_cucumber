package pageObject;

import org.openqa.selenium.WebDriver;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import utilites.waitHelperClass;

public class searchCustomerPage {

	public WebDriver ldriver;
	
	public waitHelperClass wait;
	public searchCustomerPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		wait = new waitHelperClass(ldriver); // here we create the object for wait, so when the searchCustomerPage call this constructor invoke and create object for this class
		
		
	}

	@FindBy(how = How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.ID, using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how = How.ID, using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how = How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how = How.XPATH, using="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRole;
	
	@FindBy(how = How.XPATH, using="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement listAdministrators;
	
	
	@FindBy(how = How.XPATH, using="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listRegistered;
	
	@FindBy(how = How.XPATH, using="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listGuests;
	
	@FindBy(how = How.XPATH, using="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listVendors;
	
	@FindBy(how = How.ID, using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement>  tableRows;
	
	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement>  tableColumns;
	
	public void enterEmail(String email) {
		
		wait.waitForCondition(txtEmail, 10);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void enterFirstName(String fName) {
		
		wait.waitForCondition(txtFirstName, 10);
		txtFirstName.clear();
		txtFirstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
	
		wait.waitForCondition(txtLastName, 10);
		txtLastName.clear();
		txtLastName.sendKeys(lName);
	}
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
	
	public int noOfRows() {
		return tableRows.size();
	}
	
	public int noOfColumns() {
		return tableColumns.size();
	}
	
	public boolean searchGivenEmailIdPrsentOrNot(String email) {
		
		boolean flag=false;
		for(int i=0; i<noOfRows(); i++ ) {
			
			String actulaMail= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
			if (actulaMail.equals(email)) {
				flag=true;
			}	
		}
		
		return flag;
	}
	
	public boolean searchGivenNameIsPrsentOrNot(String Name) {
		
		boolean flag=false;
		
		for(int i=0; i<noOfRows(); i++ ) {
			
			String name= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
			String names[] = name.split(" ");
			
			if (names[0].equals("Victoria") && names[1].equals("Terces") ) {
				flag=true;
			}	
		}
		
		return flag;
	}
	
	
	
	
}
