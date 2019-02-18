package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCourse_test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCourse addCourse;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
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
	}

	@BeforeMethod
	public void PreTestCondition() {
		loginPOM = new LoginPOM(driver);
		addCourse = new AddCourse(driver);

	}

	/*
	 * @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */
	@Test(priority = 1)
	public void TestCase2() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		addCourse.clickCreateCourse();
		addCourse.sendCourseTitle("Selenium");
		addCourse.clickAdvancedSettings();
		addCourse.category(2);
		addCourse.CourseCode("Selenium5");
		addCourse.CourseLang("english");
		addCourse.addCourseClick();
		addCourse.courseIntro();
	}

	@Test(priority = 2)
	public void frameTest() {

		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("/html"));
		frame.sendKeys("This is new Course");

		driver.switchTo().defaultContent();
	}

	@Test(priority = 3)
	public void saveText() {
		addCourse.saveText();
		try {
			addCourse.displayText.isDisplayed();
			String actual = addCourse.displayText();
			String expected = "Intro was updated";
			Assert.assertEquals(actual, expected);

			System.out.println("Intro was updated");
		} catch (Exception e) {
			System.out.println("Intro was not updated");
		}

	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
