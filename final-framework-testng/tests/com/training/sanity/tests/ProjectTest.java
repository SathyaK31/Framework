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
import com.training.pom.LoginPOM;
import com.training.pom.ProjectPOM;
import com.training.pom.ReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//objective is to registering to project ,select project and update project details
public class ProjectTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReportPOM reportPOM;
	private ProjectPOM projectPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	//Fetching properties form property file
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	//initialize driver and object creation for POM
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM = new LoginPOM(driver);
		reportPOM = new ReportPOM(driver);
		projectPOM = new ProjectPOM(driver);

	}

	@Test(priority = 1)
	public void Login() {
		// Login method and passing parameter for username and password
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase10_1");
		reportPOM.courseClick();
		screenShot.captureScreenShot("Testcase10_2");

	}
// this method is to select project and update project details
	@Test(priority = 1)
	public void project() {
		projectPOM.ProjectClick();
		projectPOM.CreateProject();
		projectPOM.AddTitle("e-learning");
		projectPOM.AddSubTitle("e-learning Project");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",projectPOM.submit);
		projectPOM.submit();
		screenShot.captureScreenShot("Testcase10_3");
		projectPOM.ClickProject();
		projectPOM.NewTask();
		projectPOM.PostTitle("Design");
		js.executeScript("arguments[0].scrollIntoView();",projectPOM.save);
		projectPOM.save();
		screenShot.captureScreenShot("Testcase10_4");
		projectPOM.RoleManage();
		projectPOM.AddRole();
		projectPOM.Role("Developer");
		js.executeScript("arguments[0].scrollIntoView();",projectPOM.savesubmit);
		projectPOM.Savesubmit();
		screenShot.captureScreenShot("Testcase10_5");
		projectPOM.AssignRole();
		projectPOM.category(0);
		projectPOM.TaskSubmit();
		screenShot.captureScreenShot("Testcase10_6");
		projectPOM.UserManagement();
		projectPOM.CheckBoxSelect();
		projectPOM.Register();
		screenShot.captureScreenShot("Testcase10_7");
		
	}
	// method for verification
	@Test(priority=2)
	public void assertion() {
		try {
			projectPOM.displayText.isDisplayed();
			String actual = projectPOM.displayText();
			String expected = "The user has been registered";
			Assert.assertEquals(actual, expected);

			System.out.println("The user has been registered");
		} catch (Exception e) {
			System.out.println("The user has not been registered");
		}

	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
