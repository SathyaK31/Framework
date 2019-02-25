package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentCorrectionPOM {

	private WebDriver driver; 
	public AssignmentCorrectionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);}
	
		@FindBy(xpath="//*[@id=\"page\"]/div/div[2]/div/div/div[2]/h4/a[1]")
		WebElement clickCourse;
		
		public void courseClick() {
			this.clickCourse.click(); 
		}
	@FindBy(linkText="Tests")
	WebElement test;
	
	public void TestLink() {
		this.test.click();
	}
	@FindBy(xpath="//table[1]/tbody[1]/tr[1]/td[3]/a[3]/img[1]")
	//*[@id="exercise_list_135"]/td[3]/a[3]/img
	//@FindBy(linkText="Results and feedback")
	WebElement results;
	
	public void Result() {
		this.results.click();
	}
@FindBy(xpath="//img[@title='Grade activity']")
WebElement grade;

public void grade() {
	this.grade.click();
}

@FindBy(name="send_notification")
WebElement notification;

public void SendNotification() {
	this.notification.click();
}
@FindBy(name="submit")
WebElement correctTest;

public void Submit() {
	this.correctTest.click();
}
@FindBy(xpath=" //div[@class='alert alert-info']")
WebElement verifyMsg;

public String Verify() {
	return this.verifyMsg.getText();
}
}


