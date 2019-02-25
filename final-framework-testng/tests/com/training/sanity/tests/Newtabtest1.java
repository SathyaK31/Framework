package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GenerateReportPOM;
import com.training.pom.LoginPOM;
import com.training.pom.newtabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class Newtabtest1 {

private WebDriver driver;
private String baseUrl;
private newtabPOM loginPOM;
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
	//baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver);
	// open the browser
	driver.get("http://realestate.upskills.in/my-profile/");
	loginPOM = new newtabPOM(driver);
	
	
}

	@Test
	public void testnewTab() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//screenShot.captureScreenShot("TesctCase9_1");
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER); 
    	driver.findElement(By.id("wp-admin-bar-site-name")).sendKeys(selectLinkOpeninNewTab);
	}
	

}