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
import com.training.pom.AddCourse;
import com.training.pom.LoginPOM;
import com.training.pom.courseDescriptionPOM;
import com.training.pom.unSubscriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
// Objective is to unsubscribe the user from the course
public class unSubscriptionTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	// private AddCourse addCourse;
	// private courseDescriptionPOM courseDescription;
	private unSubscriptionPOM unSubscribe;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	// To load properties 
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	//driver initializing
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@BeforeMethod
	//Creating objects for POM files
	public void CreatingObjects() {
		loginPOM = new LoginPOM(driver);
		// addCourse = new AddCourse(driver);
		// courseDescription = new courseDescriptionPOM(driver);
		unSubscribe = new unSubscriptionPOM(driver);
	}

	/*
	 * @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */
	@Test(priority = 1)
	//login steps 
	public void TestCase1() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase4_First");

	}

	@Test(priority = 2)
	//method for unsubscription
	public void clickUser() {
		unSubscribe.courseClick();
		screenShot.captureScreenShot("Testcase4_second");
		unSubscribe.userImageClick();
		unSubscribe.selectLearner();
		unSubscribe.toUnsubscribe();
		screenShot.captureScreenShot("Testcase4_3");
		driver.switchTo().alert().accept();
// verifying the text displayed
		try {
			unSubscribe.displayText.isDisplayed();
			String actual = unSubscribe.displayText();
			String expected = "User is now unsubscribed";
			Assert.assertEquals(actual, expected);
			System.out.println("User is now unsubscribed");
		} catch (Exception e) {
			System.out.println("User is not unsubscribed");
		}
		screenShot.captureScreenShot("Testcase4_4");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}