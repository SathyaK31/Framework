package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminAdduserPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//To verify whether application displays error message upon 
//entering invalid details while creating new user by admin 
public class CheckInvalidUserData {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminAdduserPOM adminPOM;
	private static Properties properties;
	private ScreenShot screenShot;
//Loading properties from property file
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
// creating object for pom files and initializing driver
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		adminPOM = new AdminAdduserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
// login to application
	@Test(priority = 1, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void login(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);

	}
//passing invalid data from excel and checking 
	@Test(priority = 2, dataProvider = "excel-inputs-invaliduser", dataProviderClass = LoginDataProviders.class)
	public void AddUser(String FirstName, String LastName, String Email, String num, String login, String password) {
		adminPOM.adminClick();
		adminPOM.AddUserClick();
		adminPOM.FirstName(FirstName);
		adminPOM.LastName(LastName);
		adminPOM.EmailClick(Email);
		adminPOM.Phone(num);
		adminPOM.LoginUser(login);
		adminPOM.RadioPass();
		adminPOM.Password(password);
		adminPOM.selectProfile();
		adminPOM.selectProfileDropdown("Trainer");
		adminPOM.AddSubmit();

	}

	@Test(priority = 3)
	public void assertion() {
		try {
			adminPOM.displayText.isDisplayed();
			String actual = adminPOM.displayText();
			String expected = "The email address is not complete or contains some invalid characters";
			Assert.assertEquals(actual, expected);

			System.out.println("The email address is not complete or contains some invalid characters ");
		} catch (Exception e) {
			System.out.println("The email address is not complete or contains some invalid characters");
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
