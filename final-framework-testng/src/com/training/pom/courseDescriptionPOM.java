package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class courseDescriptionPOM {
private WebDriver driver; 
	
	public courseDescriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"page\"]/div/div[1]/div/div/div[1]/a/img")
	WebElement courseSelect;
	
	@FindBy(linkText="Course description")
	WebElement decrptionImage;
	
	//@FindBy(linkText="Description")
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a[1]/img")
	WebElement description;
	
	@FindBy(id="course_description_title")
	WebElement title;
	
	@FindBy(name="submit")
	WebElement Save;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]")
	public
	WebElement displayText;
	
	public void courseClick() {
		this.courseSelect.click(); 
	}
	
	public void descriptionImageClick() {
		this.decrptionImage.click();
	}
	
	public void descriptionClick() {
		this.description.click();
	}
	
	public void sendTitle(String title) {
		this.title.sendKeys(title);
	}
	
	public void save() {
		this.Save.click();
	}
	public String displayText() {
		return this.displayText.getText();
	}
	

	
}
