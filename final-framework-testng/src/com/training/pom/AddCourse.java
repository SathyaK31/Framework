package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCourse {
private WebDriver driver; 
	
	public AddCourse(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Webelement for finding create course
	@FindBy(linkText="Create a course")
	WebElement CreateCourse;
	
	//Webelement for courseTitle
	@FindBy(id="title")
	WebElement CourseTitle;
	
	//Webelement for finding Advance Settings
	@FindBy(id="advanced_params")
	WebElement AdvanceSettings;
	
	//WebElement for fetch Dropdown
	@FindBy(id="add_course_category_code")
	WebElement DropdownCategory;
	
	//Webelement for course code
	@FindBy(id="add_course_wanted_code")
	WebElement CourseCode;
	
	//Webelement for course language
	@FindBy(id="add_course_course_language")
	WebElement CourseLang;
	
	//Webelement for click Template
	@FindBy(id="select2-add_course_course_template-container")
	WebElement Template;
	
	
	//Webelement for add course
	@FindBy(id="add_course_submit")
	WebElement addCourse;
	
	//Webelement for add introduction Text
	@FindBy(xpath="//*[@id=\"course_tools\"]/div[1]/div/div[1]/a")
	//@FindBy(className="btn btn-default")
	WebElement courseIntro;
	
	//Webelement for html editor
	@FindBy(xpath="/html")
	WebElement Editor;
	
	//Webelement for Display text
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div/div")
	public
	WebElement displayText;
	
	//Webelement for click on save
	@FindBy(id="introduction_text_intro_cmdUpdate")
	WebElement saveText;
	
	
	public void clickCreateCourse() {
		this.CreateCourse.click(); 
	}
	
	public void sendCourseTitle(String CourseTitle) {
		this.CourseTitle.sendKeys(CourseTitle);
	}
	
	public void clickAdvancedSettings() {
		this.AdvanceSettings.click();
	}
	
	public void category(int index) {
		Select option=new Select(DropdownCategory);
		option.selectByIndex(index);
		
	}
	public void CourseCode(String code) {
		this.CourseCode.sendKeys(code);
	}
	
	public void CourseLang(String lang) {
		Select option=new Select(CourseLang);
		option.selectByValue(lang);
		
	}
	
	public void addCourseClick() {
		this.addCourse.click();
	}
	public void courseIntro() {
		this.courseIntro.click();
	}
	
	public void editClick() {
		this.Editor.click();
		
	}
	public void saveText() {
		this.saveText.click();
	}
	public String displayText() {
		return this.displayText.getText();
	}
}
