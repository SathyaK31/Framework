package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentCorrectionPOM {

	private WebDriver driver;

	public AssignmentCorrectionPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//WebElement for click on course
	@FindBy(xpath = "//*[@id=\"page\"]/div/div[2]/div/div/div[2]/h4/a[1]")
	WebElement clickCourse;

	public void courseClick() {
		this.clickCourse.click();
	}
//WebElement for test icon
	@FindBy(linkText = "Tests")
	WebElement test;

	public void TestLink() {
		this.test.click();
	}
//WebElement for click results and feedback
	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[3]/a[3]/img[1]")
	// *[@id="exercise_list_135"]/td[3]/a[3]/img
	// @FindBy(linkText="Results and feedback")
	WebElement results;

	public void Result() {
		this.results.click();
	}
// Webelement for click on grade icon
	@FindBy(xpath = "//img[@title='Grade activity']")
	WebElement grade;

	public void grade() {
		this.grade.click();
	}
// WebElement for checkbox notification
	@FindBy(name = "send_notification")
	WebElement notification;

	public void SendNotification() {
		this.notification.click();
	}
//WebElement Submit correctTest
	@FindBy(name = "submit")
	WebElement correctTest;

	public void Submit() {
		this.correctTest.click();
	}
//WebElement for display message
	@FindBy(xpath = " //div[@class='alert alert-info']")
	WebElement verifyMsg;

	public String Verify() {
		return this.verifyMsg.getText();
	}
}
