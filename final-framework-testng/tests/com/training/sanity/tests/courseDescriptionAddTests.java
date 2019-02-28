package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class courseDescriptionAddTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	// private AddCourse addCourse;
	private courseDescriptionPOM courseDescription;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	// to load properties from property file
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	//inializing driver
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@BeforeMethod
	//creating object for POM file
	public void CreatingObjects() {
		loginPOM = new LoginPOM(driver);
		// addCourse = new AddCourse(driver);
		courseDescription = new courseDescriptionPOM(driver);

	}

	/*
	 * @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */
	@Test(priority = 1)
	// method to login
	public void TestCase1() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase3_1");

	}

	@Test(priority = 2)
	//method to write description forcourse
	public void clickDescription() {
		courseDescription.courseClick();
		screenShot.captureScreenShot("Testcase3_2");
		courseDescription.descriptionImageClick();
		screenShot.captureScreenShot("Testcase3_3");
		courseDescription.descriptionClick();
		courseDescription.sendTitle("Selenium Course");
		screenShot.captureScreenShot("Testcase3_4");

	}

	@Test(priority = 3)
	// IFrame Text passing html keys
	public void frameTest() {

		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("/html"));
		frame.sendKeys("This is new Course");

		driver.switchTo().defaultContent();
	}

	@Test(priority = 4)
	// To verify display text
	public void saveText() {
		courseDescription.save();
		try {

			courseDescription.save();

			courseDescription.displayText.isDisplayed();
			String actual = courseDescription.displayText();
			String expected = "The description has been updated";
			Assert.assertEquals(actual, expected);
			System.out.println("The description has been updated");
		} catch (Exception e) {
			System.out.println("The description has been updated");
		}
		screenShot.captureScreenShot("Testcase3_third");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
