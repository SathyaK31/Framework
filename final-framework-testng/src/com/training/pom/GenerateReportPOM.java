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
	// Element of reporting tab
	@FindBy(linkText="Reporting")
	WebElement Reporttab;
	
	public void Reportclick() {
		this.Reporttab.click();
	}
	// Element for click followed students
	@FindBy(linkText="Followed students")
	WebElement studentLink;
	
	public void FollowedStudentClick() {
		this.studentLink.click();
	}
	
	// Element for followed Teacher
	@FindBy(linkText="Followed teachers")
	WebElement TeacherLink;
	
	public void TeacherClick() {
		this.TeacherLink.click();
	}
	//ELement for search keyword
	@FindBy(id="search_user_keyword")
	WebElement keyword;
	
	public void keyword(String student) {
		this.keyword.clear();
		this.keyword.sendKeys(student);
	}
	//Element for search submit button
	@FindBy(id="search_user_submit")
	WebElement search;
	
	public void searchbtn() {
		this.search.click();
	}
	//Element for clicking arrow
	@FindBy(xpath="//tbody/tr[2]/td[5]/a/img")
	public
	WebElement arrow;
	
	public void arrowClick() {
		this.arrow.click();
	}
	// Element for click course
	@FindBy(xpath="//div/div[4]/table/tbody/tr[4]/td[7]/a/img")
	public
	WebElement courseArrow;
	
	public void CourseClick() {
		this.courseArrow.click();
	}
	// Element to click on quiz Icon
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[4]/table/tbody/tr[5]/td[5]/a/img")
	WebElement quizIcon;
	
	public void QuicIcon() {
		this.quizIcon.click();
	}
	//Element for click send notification
	@FindBy(name="send_notification")
	WebElement sendNotification;
	
	public void SendEmail() {
		this.sendNotification.click();
	}
	//Element for correct test button
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
