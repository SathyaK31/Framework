package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Webelement for sending username
	@FindBy(id="login")
	private WebElement userName; 
	
	
	//Webelement for sending password
	@FindBy(id="password")
	private WebElement password;
	
	
	//Webelement for clickon login submit 
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	//Webelement for welcome screen text
	@FindBy(xpath="//*[@id=\"homepage-course\"]/div/p[1]")
	public WebElement WelcomeScreen;
	

	public String sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		return this.userName.getAttribute("value");
	}
	
	public String sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		return this.password.getAttribute("value");
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
