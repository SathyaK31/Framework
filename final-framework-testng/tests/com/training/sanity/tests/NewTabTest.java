package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GenerateReportPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
 
public class NewTabTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private GenerateReportPOM generatereportPOM;
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
		generatereportPOM=new GenerateReportPOM(driver);
		
	}


	@BeforeMethod
	public void Login() {
		loginPOM.sendUserName("Sathya");
		loginPOM.sendPassword("Sathya");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TesctCase9_1");
	}
		@Test
    public void method1() {
    	
    	
    	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
    	driver.findElement(By.xpath("//*[@id=\"menuone\"]/ul[1]/li[4]/a")).sendKeys(selectLinkOpeninNewTab);
    
    	String LinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
    	driver.findElement(By.xpath("//*[@id=\"menuone\"]/ul/li/a")).sendKeys(LinkOpeninNewTab);
}
}