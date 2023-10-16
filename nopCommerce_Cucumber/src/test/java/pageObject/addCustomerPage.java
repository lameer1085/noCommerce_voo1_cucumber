package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addCustomerPage {

	public WebDriver ldriver;
	
	public addCustomerPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	By lnkCustomerMenu = By.xpath("//p[text()=' Customers']//ancestor::ul/parent::li/a/p");   /* "//a[@href='#']/span[contains(text(),'Customers')]" */
	By linkCustomersMentItem= By.xpath("//a[@href='/Admin/Customer/List']/p");
	
	By bttnAddnew = By.xpath("//a[@href='/Admin/Customer/Create']");
	
	By txtEmail = By.id("Email");
	By txtPassword= By.id("Password");
	
	By txtCustomerRoles= By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
	
	By listItemAdministrators= By.xpath("//li[contains(text(),'Administrators')]");
	By listitemRegistered= By.xpath("//li[contains(text(),'Registered')]");
	By listitemGuests= By.xpath("(//*[text()='Guests'])[2]");
	By listitemVendors= By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpdwnManagerForVendor= By.xpath("//*[@id='VendorId']");
	By genderMale = By.id("Gender_Male");
	By genderFemale = By.id("Gender_Female");
	
	By txtFirstName = By.id("FirstName");
	By txtLastName= By.id("LastName");
	
	By txtDOB= By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName= By.xpath("//input[@id='Company']");
	
	By txtAdminContent= By.xpath("//textArea[@id='AdminComment']");
	
	By btnSave= By.xpath("//button[@name='save']");
	
	//Action methods
	public String pageTitle() {		
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomerMenu).click();
	}
	
	public void clickOnCustomerItemInMenu() {
		ldriver.findElement(linkCustomersMentItem).click();
	}
	
	public void addNewCoustomerBtn() {
		ldriver.findElement(bttnAddnew).click();
	}
	
	public void enterEmail(String Email) {
		ldriver.findElement(txtEmail).clear();
		ldriver.findElement(txtEmail).sendKeys(Email);
	}
	
	public void enterPassword(String passWord) {
		ldriver.findElement(txtPassword).clear();
		ldriver.findElement(txtPassword).sendKeys(passWord);
	}

	public void selectRole(String role){
		
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listItem;
		
		if(role.equals("Administrators")) {
			listItem = ldriver.findElement(listItemAdministrators);
		
		}else if (role.equals("Guests")) {
			listItem = ldriver.findElement(listitemGuests);
			
		}else if (role.equals("Registered")) {
			listItem = ldriver.findElement(listitemRegistered);
			
		}
		else if (role.equals("Vendors")) {
			listItem = ldriver.findElement(listitemVendors);
			
		}
		else  {
			listItem = ldriver.findElement(listitemGuests);
			
		}
		
		//listItem.click();
		System.out.println(listItem);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", listItem);
		
	}
	 public void setManagervendor(String mngr) {
		 Select sel = new Select(ldriver.findElement(drpdwnManagerForVendor));
		 sel.selectByValue(mngr);
	 }
	
	 public void selectGender(String gender) {
		 
		 
		 if (gender.equals("male")) {
			  ldriver.findElement(genderMale).click();
				
			}else if (gender.equals("female")) {
				ldriver.findElement(genderFemale).click();
				
			}else  {
				 ldriver.findElement(genderMale).click();
			}
	 }
	 
	 public void setFirstName(String firstName) {
		 ldriver.findElement(txtFirstName).sendKeys(firstName);
	 }
	 
	 public void setlastName(String lastName) {
		 ldriver.findElement(txtLastName).sendKeys(lastName);
	 }
	 
	 public void setDOB(String DOB) {
		 ldriver.findElement(txtDOB).sendKeys(DOB);
	 }
	 
	 public void setCompanyName(String CompanyName) {
		 ldriver.findElement(txtCompanyName).sendKeys(CompanyName);
	 }
	 
	 public void setAdminContent(String AdminContent) {
		 ldriver.findElement(txtAdminContent).sendKeys(AdminContent);
	 }
	 
	 public void clickOnSave() {
		 ldriver.findElement(btnSave).click();;
	 }
}
