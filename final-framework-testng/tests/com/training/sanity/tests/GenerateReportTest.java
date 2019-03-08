package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GenerateReportPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
// Objective is to click on report tab and generate report for the student
public class GenerateReportTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private GenerateReportPOM generatereportPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	// Loading properties from property file
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM = new LoginPOM(driver);
		generatereportPOM = new GenerateReportPOM(driver);

	}

	@Test(priority=1)
	// login test and passing credentials
	public void Login() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase9_1");

	}

	@Test(priority = 2)
	//this method is to generate report
	public void Reporting() throws InterruptedException {
		generatereportPOM.Reportclick();
		screenShot.captureScreenShot("Testcase9_3");
		generatereportPOM.FollowedStudentClick();
		generatereportPOM.keyword("sathya");
		generatereportPOM.searchbtn();
		// need to scroll page to view the element . hence using javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", generatereportPOM.arrow);
		generatereportPOM.arrowClick();
		js.executeScript("arguments[0].scrollIntoView();", generatereportPOM.courseArrow);
		generatereportPOM.CourseClick();
		generatereportPOM.QuicIcon();
		//For sending mail and click on submit
		generatereportPOM.SendEmail();
		generatereportPOM.CorrectTest();
	}
// This method is to verify the display text
	@Test(priority = 3)
	public void assertion() {
		try {
			generatereportPOM.displayText.isDisplayed();
			String actual = generatereportPOM.displayText();
			String expected = "Message Sent";
			Assert.assertEquals(actual, expected);

			System.out.println("Message Sent");
		} catch (Exception e) {
			System.out.println("Message not Sent");
		}

	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


}