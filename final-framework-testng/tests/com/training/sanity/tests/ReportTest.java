package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
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
import com.training.pom.ReportPOM;
import com.training.pom.courseDescriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
// Objective is to send report to the followed students by the trainer
public class ReportTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReportPOM reportPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	//Loading properties from property file
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	//Initializing web driver 
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		//Creating objects for POM
		loginPOM = new LoginPOM(driver);
		reportPOM=new ReportPOM(driver);
	}


	@BeforeMethod
	//Login using credentials
	public void Login() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase7_1");
		reportPOM.courseClick();
		screenShot.captureScreenShot("Testcase7_2");
		
	}
@Test
//Test to generate report
public void Reporting() throws InterruptedException {
	reportPOM.reportClick();
	screenShot.captureScreenShot("Testcase7_3");
	// using java script executor for scrolling the window 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", reportPOM.studentSelect);
	reportPOM.StudentSelect();
	reportPOM.quizCick();
	reportPOM.selectNotification();
	screenShot.captureScreenShot("Testcase7_4");
	reportPOM.Submit();
	Thread.sleep(2000);
	// steps to verify dislay message
	String actual=reportPOM.Verify();
	String expected="Message Sent";
	Assert.assertEquals(actual, expected);
	reportPOM.clickCourseLink();
	screenShot.captureScreenShot("Testcase7_5");
	String actual1=reportPOM.mainPage();
	String expected1="Selenium";
	Assert.assertEquals(actual1, expected1);
}
@AfterClass
public void tearDown() throws Exception {
	Thread.sleep(1000);
	driver.quit();
}

}
