package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPOM {
	private WebDriver driver;

	public StudentPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web element for course subscription
	@FindBy(xpath = "//a[@title='Subscribe']")
	WebElement subscribe;

	public void Subscribe() {
		this.subscribe.click();
	}

	// For clicking my course link
	@FindBy(linkText = "My courses")
	WebElement myCourse;

	public void myCourseLink() {
		this.myCourse.click();
	}

	// Course click dynamically

	public void CourseClick(String course) {
		String before = "//a[contains(text(),'";
		String after = "')]";
		String courseclick = before + course + after;
		driver.findElement(By.xpath(courseclick)).click();
	}

	public void ClickTest(String course) {
		String before = "//section[@id='content-section']//a[contains(text(),";

		String after = "')]/../a/img";
		String testclick = before + course + after;
	}

	// a[contains(text(),'1em')]
	// For selecting Test dynamically

	public void testNameClick(String test) {
		String before = "//a[contains(text(),'";
		String after = "')]";
		String testclick = before + test + after;
	}
	//Clicking start test 
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	WebElement startTest;
	
	public void StartTest() {
		this.startTest.click();
	}
	
	// for radio button answer the question.
	@FindBy(name="choice[138]")
	WebElement ansClick;
	
	public void AnsSelect() {
		this.ansClick.click();
	}
	
	//save and move to next question
	@FindBy(name="save_now")
	WebElement nextQuestion;
	
	public void ClicknextQues() {
		this.nextQuestion.click();
		
	
	}
	@FindBy(name="choice[139]")
	WebElement ansClick2;
	
	public void AnsSelect2() {
		this.ansClick.click();
	}
	
	

}
