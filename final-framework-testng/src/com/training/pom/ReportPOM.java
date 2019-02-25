package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPOM {
	private WebDriver driver; 
	public ReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"page\"]/div/div[2]/div/div/div[2]/h4/a[1]")

	WebElement clickCourse;
	
	public void courseClick() {
		this.clickCourse.click(); 
	}
	
	@FindBy(xpath="//img[@id='toolimage_3065']")
	WebElement ReportIcon;
	
	public void reportClick() {
		this.ReportIcon.click();
		
	}
	//@FindBy(linkText="2rightarrow.png")
	@FindBy(xpath="//table[1]/tbody[1]/tr[4]/td[16]/center[1]/a[1]/img[1]")
	
	//@FindBy(xpath="//table[1]/tbody[1]/tr[4]/td[16]/center[1]/a[1]//img[@title='2rightarrow.png']")
	public
		WebElement studentSelect;
	
	public void StudentSelect() {
		this.studentSelect.click();
	}
	
	@FindBy(xpath="//img[@title='quiz.png']")
	WebElement quizIcon;
	
	public void quizCick() {
		this.quizIcon.click();
	}
	
	
	@FindBy(name="send_notification")
	WebElement sendMail;
	
	public void selectNotification() {
		this.sendMail.click();
		
	}
	@FindBy(name="submit")
	WebElement CorrectTest;
	
	public void Submit() {
		this.CorrectTest.click();
	}
	
	@FindBy(xpath=" //div[@class='alert alert-info']")
	WebElement verifyMsg;
	
	public String Verify() {
		return this.verifyMsg.getText();
	}
	
	@FindBy(xpath="//a[contains(text(),'Selenium')]")
	WebElement courseLink;
	
	public void clickCourseLink() {
		this.courseLink.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Selenium')]")
	WebElement mainpage;
	
	public String mainPage() {
		return this.mainpage.getText();
		
	}
}
