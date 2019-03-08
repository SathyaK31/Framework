package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminAdduserPOM {
	private WebDriver driver;

	public AdminAdduserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Web element to click on adminstrator tab
	@FindBy(linkText="Administration")
	WebElement administrator;
	
	public void adminClick() {
		this.administrator.click();
	}
	
	//Add user click
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	WebElement addUser;
	
	public void AddUserClick() {
		this.addUser.click();
	}
	// for finding first name
	@FindBy(id="firstname")
	WebElement firstName;
	
	public String FirstName(String FirstName) {
		this.firstName.sendKeys(FirstName);
		return this.firstName.getAttribute("value");
	}
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	public String LastName(String LastName){
		this.lastName.sendKeys(LastName);
		return this.lastName.getAttribute("value");
	}
	//Email key
	@FindBy(id="email")
	WebElement email;
	
	public String EmailClick(String Email) {
		this.email.sendKeys(Email);
		return this.email.getAttribute("value");
		
	}
	
	//phone text
	@FindBy(id="phone")
	WebElement phoneNo;
	
	public String Phone(String num) {
		this.phoneNo.sendKeys(num);
		return this.phoneNo.getAttribute("value");
	}
	
	//login username field
	@FindBy(id="username")
	WebElement loginUsername;
	
	public String LoginUser(String login) {
		this.loginUsername.sendKeys(login);
		return this.loginUsername.getAttribute("value");
	}
	
	//entering password radio button
	@FindBy(name="password[password_auto]")
	WebElement passwordRadio;
	
	public void RadioPass() {
		this.passwordRadio.click();
	}
	
	//password field
	@FindBy(id="password")
	WebElement passwordKey;
	
	public String Password(String password) {
		this.passwordKey.sendKeys(password);
		return this.passwordKey.getAttribute("value");
		
	}
	
	//for fetching list of role
	@FindBy(xpath = " //button[@title='Learner']//span[@class='caret']") 
	private WebElement profileSelect; 

public void selectProfile() {
		this.profileSelect.click();
	}
//this for getting value from excel 

public String selectProfileDropdown(String profile) {
		String before = "//ul[@class='dropdown-menu inner']//li//a//span[contains(text(),'";
		String after = "')]";
		String classuser = before + profile + after;
		driver.findElement(By.xpath(classuser)).click();
		return profile;
	} 

	//add submit
	@FindBy(name="submit")
	WebElement add;
	
	public void AddSubmit() {
		this.add.click();
	}
@FindBy(xpath="//div[@class='alert alert-warning']")
	
	public
	WebElement displayText;
	
	public String displayText() {
		return this.displayText.getText();
		
	}

}

