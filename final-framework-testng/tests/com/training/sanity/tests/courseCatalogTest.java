package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.courseCatalogPOM;
import com.training.pom.unSubscriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
// Objectve is to add Course in course catalog
public class courseCatalogTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private courseCatalogPOM courseCatalog;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	// to load properties 
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	// iniatialize driver object creation for POM
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@BeforeMethod
	//object creation for POM
	public void CreatingObjects() {
		loginPOM = new LoginPOM(driver);
		// addCourse = new AddCourse(driver);
		// courseDescription = new courseDescriptionPOM(driver);
		courseCatalog = new courseCatalogPOM(driver);
	}

	@Test(priority = 1)
	//login method
	public void Login() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase5_1");

	}

	@Test(priority = 2)
	//method to course catalog
	public void courseCatalog() {
		courseCatalog.clickCourseCatalog();
		courseCatalog.searchKey("Selenium");
		screenShot.captureScreenShot("Testcase5_2");
		courseCatalog.search();
		screenShot.captureScreenShot("Testcase5_3");
		try {
			courseCatalog.searchResult.isDisplayed();
			String actual = courseCatalog.searchResult();
			String expected = "Search results for: Selenium";
			Assert.assertEquals(actual, expected);
			System.out.println("Search results for: Selenium is displayed");
		} catch (Exception e) {
			System.out.println("Search results for: Selenium is not displayed");
		}
		screenShot.captureScreenShot("Testcase4_4");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
