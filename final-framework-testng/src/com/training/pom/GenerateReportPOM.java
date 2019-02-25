package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateReportPOM {

	private WebDriver driver; 
	public GenerateReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Reporting")
	WebElement Reporttab;
	
	public void Reportclick() {
		this.Reporttab.click();
	}
	
	@FindBy(linkText="Followed students")
	WebElement studentLink;
	
	public void FollowedStudentClick() {
		this.studentLink.click();
	}
	@FindBy(id="search_user_keyword")
	WebElement keyword;
	
	public void keyword(String student) {
		this.keyword.clear();
		this.keyword.sendKeys(student);
	}
	
	@FindBy(id="search_user_submit")
	WebElement search;
	
	public void searchbtn() {
		this.search.click();
	}
	
	@FindBy(xpath="//tbody/tr[2]/td[5]/a/img")
	public
	WebElement arrow;
	
	public void arrowClick() {
		this.arrow.click();
	}
	
	@FindBy(xpath="//div/div[4]/table/tbody/tr[4]/td[7]/a/img")
	public
	WebElement courseArrow;
	
	public void CourseClick() {
		this.courseArrow.click();
	}
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[4]/table/tbody/tr[5]/td[5]/a/img")
	WebElement quizIcon;
	
	public void QuicIcon() {
		this.quizIcon.click();
	}
	
	@FindBy(name="send_notification")
	WebElement sendNotification;
	
	public void SendEmail() {
		this.sendNotification.click();
	}
	
	@FindBy(id="myform_submit")
	WebElement corrrectTest;
	
	public void CorrectTest() {
		this.corrrectTest.click();
	}
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]")
	
	public
	WebElement displayText;
	
	public String displayText() {
		return this.displayText.getText();
		
	}
}
