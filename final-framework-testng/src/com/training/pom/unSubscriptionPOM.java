package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unSubscriptionPOM {
private WebDriver driver; 
	
	public unSubscriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Webelement for selecting course
	@FindBy(xpath="//*[@id=\"page\"]/div/div[1]/div/div/div[1]/a/img")
	WebElement courseSelect;
	
	//Webelement for click on user image
	@FindBy(linkText="Users")
	WebElement UsersImage;
	
	//Webelement for select learner 
	@FindBy(name="user[]")
	WebElement selectLearner;
	
	//Webelement to click unsubscribe link
	@FindBy(linkText="Unsubscribe")
	WebElement unsubscribe;
	
	//Webelement to check display text
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]")
	public
	WebElement displayText;
	
	public void courseClick() {
		this.courseSelect.click(); 
	}
	
	public void userImageClick() {
		this.UsersImage.click();
	}
	public void selectLearner() {
		this.selectLearner.click();
	}
	public void toUnsubscribe() {
		this.unsubscribe.click();
	}
	public String displayText() {
		return this.displayText.getText();
	}
}
