package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AssignmentCorrectionPOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentPOM;
import com.training.pom.TestCreationPOM;
import com.training.pom.courseCatalogPOM;
import com.training.pom.courseDescriptionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Objective is To verify whether application 
//allows teacher to author a test for a course, student to take the test & teacher to review 
//& send the response
public class TestCreationCorrectionTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TestCreationPOM testPOM;
	private static AssignmentCorrectionPOM assignmentCorrection;
	private courseCatalogPOM courseCatalog;
	private StudentPOM studentPOM;
	private courseDescriptionPOM courseDescription;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

// For object creation and initializing driver as well
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		testPOM = new TestCreationPOM(driver);
		assignmentCorrection = new AssignmentCorrectionPOM(driver);
		courseCatalog = new courseCatalogPOM(driver);
		studentPOM = new StudentPOM(driver);
		courseDescription = new courseDescriptionPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		/*
		 * LoginExcelTest loginSteps=new LoginExcelTest();
		 * loginSteps.loginDBTest(userName, password);
		 */

	}

//login as teacher
	@Test(priority = 1)
	public void loginDBTest() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("LoginTeacher");

	}

	@Test(priority = 2)
	// For creating Test as a trainer
	public void createTest() {
		assignmentCorrection.courseClick();
		assignmentCorrection.TestLink();
		testPOM.createTest();
		testPOM.TestTiltle("SeleniumTest");

		testPOM.AdvanceSetting();
		testPOM.Frame();

		// Write something in Name Desc text box
		testPOM.sendTestNameDesc("Quiz3");

		// Click on the frame
		testPOM.Frame2();

		// Click on Checkbox
		testPOM.clickCheckBox();

		// Click on date Image
		testPOM.clickDateImage();

		// Click on Now button
		testPOM.clickNow();

		// Click on Done button
		testPOM.clickDone();
		testPOM.AtEndRadio();
		testPOM.EnableStartTime();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", testPOM.datePicker); //
		 * for click on date from calendar testPOM.DatePicker();
		 * 
		 * testPOM.Month("Mar"); testPOM.Year("2019"); testPOM.date("1");
		 */
		testPOM.PassPercentage("50");
		testPOM.Proceed();
		testPOM.MultipleChoice();
		// 1st set of question
		testPOM.question("which course your learning");
		testPOM.Framei();

		// Write textin frame
		testPOM.send1text("Selenium");

		// come out of frmae
		testPOM.Frame1out();

		// Click on frame2
		testPOM.Framei2();

		// Write text java in frame2
		testPOM.send2text("Java");

		// come out of frame2
		testPOM.Frame2out();

		// Click on frame3
		testPOM.Framei3();

		// Send text C in frame3
		testPOM.send3text("C");

		// come out of frame3
		testPOM.Frame3out();

		// Click on frame4
		testPOM.Framei4();

		// Send text C# in frame4
		testPOM.send4text("C#");

		// come out of frame4
		testPOM.Frame4out();

		// Enter text 1 in score
		testPOM.score1_1stQuestion("1");

		// Enter text 1 in score
		testPOM.score2_1stQuestion("1");

		// Enter text 1 in score
		testPOM.score3_1stQuestion("1");

		// Enter text 1 in score
		testPOM.score4_1stQuestion("1");

		/*
		 * testPOM.option1("Selenium"); testPOM.option2("Java"); testPOM.option3("C");
		 * testPOM.option4("C#");
		 */
		testPOM.Correct();
		testPOM.SubmitQues();

		// Second set of questions

		testPOM.MultipleChoice();
		testPOM.question("which language are you using in selenium");
		testPOM.Framei();

		// Write textin frame
		testPOM.send1text("Selenium");

		// come out of frmae
		testPOM.Frame1out();

		// Click on frame2
		testPOM.Framei2();

		// Write text java in frame2
		testPOM.send2text("Java");

		// come out of frame2
		testPOM.Frame2out();

		// Click on frame3
		testPOM.Framei3();

		// Send text C in frame3
		testPOM.send3text("C");

		// come out of frame3
		testPOM.Frame3out();

		// Click on frame4
		testPOM.Framei4();

		// Send text C# in frame4
		testPOM.send4text("C#");

		// come out of frame4
		testPOM.Frame4out();

		/*
		 * testPOM.option1("Selenium"); testPOM.option2("Java"); testPOM.option3("C");
		 * testPOM.option4("C#");
		 */
		// Second option radio button click
		testPOM.SecondCorrect();
		testPOM.SubmitQues();
		testPOM.Preview();
		testPOM.arrowclickForLogout();
		testPOM.logout();
	}

	// Student login
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
		studentPOM.testNameClick(testPOM.Testname());
		studentPOM.StartTest();

		studentPOM.AnsSelect();
		studentPOM.ClicknextQues();
		studentPOM.AnsSelect2();
		studentPOM.ClicknextQues();
		testPOM.arrowclickForLogout();
		testPOM.logout();
	}

// login as teacher
	@Test(priority = 5)
	public void AdminLogin(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);

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
