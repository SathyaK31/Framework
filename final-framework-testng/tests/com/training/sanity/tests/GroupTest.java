package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GroupPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class GroupTest {
	private static final TimeUnit TimeUnit = null;
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReportPOM reportPOM;
	private GroupPOM groupPOM;
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
		loginPOM = new LoginPOM(driver);
		reportPOM=new ReportPOM(driver);
		groupPOM=new GroupPOM(driver);
	}


	@Test(priority=1)
	public void Login() {
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase8_1");
		reportPOM.courseClick();
		screenShot.captureScreenShot("Testcase8_2");
}
	@Test(priority=2)
	public void GroupCreation() {
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		groupPOM.groupIconClick();
		groupPOM.clickCreateGroup();
		groupPOM.sendGroupNum("1");
		groupPOM.Proceed();
		groupPOM.PassGroupName("Rockers");
		groupPOM.createGroup();
		groupPOM.GroupMemClick();
		groupPOM.AddGroupMem();
		groupPOM.add();
		groupPOM.SaveSettings();
		groupPOM.edit();
		groupPOM.CheckboxSelect();
		groupPOM.ClickUnregister();
		groupPOM.FinalSubmit();
		
		
	}
	@Test(priority = 3)
	public void saveText() {
		groupPOM.displayText();
		try {
			groupPOM.displayText.isDisplayed();
			String actual = groupPOM.displayText();
			String expected = "Group settings modified";
			Assert.assertEquals(actual, expected);

			System.out.println("Group settings modified");
		} catch (Exception e) {
			System.out.println("Group settings not modified");
		}
	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
