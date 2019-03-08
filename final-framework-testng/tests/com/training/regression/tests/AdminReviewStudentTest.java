package com.training.regression.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminReviewStudentTestPOM;
import com.training.pom.AssignmentCorrectionPOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentPOM;
import com.training.pom.courseCatalogPOM;
import com.training.pom.courseDescriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AdminReviewStudentTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminReviewStudentTestPOM reviewPOM;
	private LoginPOM loginPOM;
	private static AssignmentCorrectionPOM assignmentCorrection;
	private courseCatalogPOM courseCatalog;
	private StudentPOM studentPOM;
	private courseDescriptionPOM courseDescription;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		reviewPOM = new AdminReviewStudentTestPOM(driver); 
		loginPOM=new LoginPOM(driver);
		assignmentCorrection = new AssignmentCorrectionPOM(driver);
		courseCatalog = new courseCatalogPOM(driver);
		studentPOM = new StudentPOM(driver);
		courseDescription = new courseDescriptionPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
  
  
  //Teacher should be able to login to elearning home page
  @Test(priority=1)
   public void studentLogin()
   {
	    loginPOM.sendUserName("Sathya");
	    loginPOM.sendPassword("Sathya");
	    loginPOM.clickLoginBtn(); 
	    String expected = "Profile";
	    String actual = driver.findElement(By.linkText("Profile")).getText();
	    assertEquals(actual, expected);
   }
  
//Teacher should be able to click on particular course and create test
  @Test(priority=2, dependsOnMethods="studentLogin")
   public void teacherCreateTest()
   {    reviewPOM.clickOnCourses();
        reviewPOM.sendSearchCourse("SELENIUM COMPLEX");
        reviewPOM.clickSearchBtn();
        reviewPOM.clickCourseLink();
        reviewPOM.clickOnTests();
        reviewPOM.clickCreateTest();
        reviewPOM.clickLogout();
	    
   }
  
  
  
//Student login
	@Test(priority = 3)
	public void StudentLogin() {
		loginPOM.sendUserName("sathya_s");
		loginPOM.sendPassword("student");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Login Student");

	}

	// Student register for test
	@Test(priority = 4)
	public void CourseTest() {

		courseCatalog.clickCourseCatalog();
		courseCatalog.searchKey("Selenium by Sathya");
		courseCatalog.CourseName();
		screenShot.captureScreenShot("*****");
		courseCatalog.search();
		screenShot.captureScreenShot("******");
		studentPOM.Subscribe();
		// using the select course using course description pom since we wrote already
		// course name is returning from the course catalog which we pass in search key
		studentPOM.CourseClick(courseCatalog.CourseName());
		// using the test link which we created already in assignment correction POM
		studentPOM.ClickTest(courseCatalog.CourseName());
		// dynamically passing test name which trainer created
		studentPOM.testNameClick(reviewPOM.Testname());
		reviewPOM.clickOnTestLink();
        reviewPOM.clickOnStartTest();
        reviewPOM.selectFirstAns();
        reviewPOM.clickNextButton();
        reviewPOM.selectSecondAns();
        reviewPOM.clickOnEndTest();
	    screenShot.captureScreenShot("StudentTest");
	    reviewPOM.clickLogout();
	}

//login as teacher
	@Test(priority = 5)
	public void AdminLogin() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("login");

	}

//test correction
	@Test(priority = 6)
	public void TestCorrection() {
		studentPOM.CourseClick(courseCatalog.CourseName());
		assignmentCorrection.TestLink();
		studentPOM.ClickTest(courseCatalog.CourseName());
		assignmentCorrection.Result();
		assignmentCorrection.grade();
		assignmentCorrection.SendNotification();
		screenShot.captureScreenShot("Testcase6_3");
		assignmentCorrection.Submit();

	}

	// For assertion
	@Test(priority = 7)
	public static void assertion() {
		try {

			String actual = assignmentCorrection.Verify();
			String expected = "Message Sent";
			Assert.assertEquals(actual, expected);
			System.out.println("Mail report sent");
		} catch (Exception e) {
			System.out.println("Mail report not sent");
		}

	}

	/*
	 * @AfterClass public void tearDown() throws Exception { driver.quit(); }
	 */

}
