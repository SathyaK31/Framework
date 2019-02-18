package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class courseCatalogPOM {
private WebDriver driver; 
	
	public courseCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Course catalog")
	WebElement courseCatalog;
	
	@FindBy(name="search_term")
	WebElement searchKey;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div[1]/div/div/div[1]/form/div/div/button")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div[2]/div/p/strong")
	public WebElement searchResult;
	
	public void clickCourseCatalog() {
		this.courseCatalog.click();
	}
	
	public void searchKey(String course) {
		this.searchKey.sendKeys(course);
	}
	
	public void search() {
		this.search.click();
	}
	
	public String searchResult() {
		return this.searchResult.getText();
	}
}