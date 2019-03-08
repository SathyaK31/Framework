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
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminAdduserPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
// This is for the test case to check whether the data stored in database 
//is same as per our input 

public class NewUserDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminAdduserPOM adminPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static GenericMethods genericMethods;

	// to load properties from property file
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
  
	//creating object for POM
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		adminPOM = new AdminAdduserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver);
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {

		String username = loginPOM.sendUserName("admin");

		String passWord = loginPOM.sendPassword("admin@1234");
		loginPOM.clickLoginBtn();
		Assert.assertEquals(username, userName);
		Assert.assertEquals(passWord, password);
		screenShot.captureScreenShot(userName);

	}
// fetching db inputs using data provider
	@Test(dataProvider = "db-user-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String firstname, String lastname, String email, String phone, String login,
			String password, String profile) {
		adminPOM.adminClick();
		adminPOM.AddUserClick();
		String Firstname = adminPOM.FirstName("Manzoor");
		String Lastname = adminPOM.LastName("mehadi");
		String Email = adminPOM.EmailClick("manzoor@gmail.com");
		String Phone = adminPOM.Phone("9878998989");
		String Login = adminPOM.LoginUser("manzoor");
		adminPOM.RadioPass();
		String Password = adminPOM.Password("manzoor");
		adminPOM.selectProfile();
		String Profile = adminPOM.selectProfileDropdown("Trainer");
		adminPOM.AddSubmit();
		screenShot.captureScreenShot("sucessful adduser" + firstname);
//Assertion for db values with inputs
		Assert.assertEquals(firstname, Firstname);
		Assert.assertEquals(lastname, Lastname);
		Assert.assertEquals(email, Email);
		Assert.assertEquals(phone, Phone);
		Assert.assertEquals(login, Login);
		Assert.assertEquals(password, Password);
		Assert.assertEquals(profile, Profile);

	}
}
