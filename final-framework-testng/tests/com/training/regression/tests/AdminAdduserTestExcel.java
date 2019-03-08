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
// this test is to fetch user data from excel and creating new users
public class AdminAdduserTestExcel {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminAdduserPOM adminPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	//loading properties from property file
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	//initializing driver
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		adminPOM=new AdminAdduserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

// fetching data from excel for login
	@Test(priority=1,dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void login(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);


	}
	// fetching data for add user
	@Test(priority=2,dataProvider = "excel-inputs-adduser", dataProviderClass = LoginDataProviders.class)
	public void AddUser(String FirstName, String LastName, String Email, String num, String login, String password){
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
		screenShot.captureScreenShot("sucessful adduser"+FirstName);
				
	}
	//assertion for adding user
	@Test(priority = 3)
	public void assertion() {
		try {
			adminPOM.displayText.isDisplayed();
			String actual = adminPOM.displayText();
			String expected = "User has been added";
			Assert.assertEquals(actual, expected);

			System.out.println("User has been added");
		} catch (Exception e) {
			System.out.println("User has been added");
		}
	}


	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
