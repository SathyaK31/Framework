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
import com.training.pom.AssignmentCorrectionPOM;
import com.training.pom.LoginPOM;
import com.training.pom.courseCatalogPOM;
import com.training.pom.courseDescriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AssignmentCorrectionTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private courseDescriptionPOM courseDescription;
	private AssignmentCorrectionPOM assignmentCorrection;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	//Loading properties form property file
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	//initialize driver and url
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	//Creating objects for POM
		loginPOM = new LoginPOM(driver);
		courseDescription = new courseDescriptionPOM(driver);
		assignmentCorrection=new AssignmentCorrectionPOM(driver);
	}
// Login using credentials
	@Test(priority = 1)
	public void Login() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase6_1");
		assignmentCorrection.courseClick();
		screenShot.captureScreenShot("Testcase6_2");
	}

	
@Test(priority=2)
//This method is to correct the assignment and verify assert statement
public void assignmentCorect() throws InterruptedException {
	assignmentCorrection.TestLink();
	
	Thread.sleep(2000);
	assignmentCorrection.Result();
	assignmentCorrection.grade();
	assignmentCorrection.SendNotification();
	screenShot.captureScreenShot("Testcase6_3");
	assignmentCorrection.Submit();
	// for assertion of display text
	String actual=assignmentCorrection.Verify();
	String expected="Message Sent";
	Assert.assertEquals(actual, expected);
	screenShot.captureScreenShot("Testcase6_4");
}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
