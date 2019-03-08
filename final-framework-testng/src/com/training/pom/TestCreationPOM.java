package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCreationPOM {
	private WebDriver driver;

	public TestCreationPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Webelement to create new test
	@FindBy(xpath = "//img[@title='Create a new test']")
	WebElement CreateTest;

	public void createTest() {
		this.CreateTest.click();
	}

	// Webelement to Testname
	@FindBy(id = "exercise_title")
	WebElement title;

	public void TestTiltle(String Title) {
		this.title.sendKeys(Title);
	}
	// dynamically for fetching testtitle which we are passing
	public String Testname() {
		String test=this.title.getText();
		return test;
	}

	// WebElement for click on advanced settings
	@FindBy(id = "advanced_params")
	WebElement advancedSettings;

	public void AdvanceSetting() {
		this.advancedSettings.click();
	}

	// Web element for enter valid credentials in Give a context to the test textbox
	public void frameTest() {

		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("/html"));
		frame.sendKeys("Quiz");
		driver.switchTo().defaultContent();
	}
	

	// Web element Radio button

	@FindBy(id = "exerciseType_0")
	WebElement atEndRadioButton;

	public void AtEndRadio() {
		this.atEndRadioButton.click();
	}

	// web element start enable time
	@FindBy(name = "activate_start_date_check")
	WebElement enableStartTime;

	public void EnableStartTime() {
		this.enableStartTime.click();
	}
	
	// Identifying the frame
		@FindBy(xpath = "//iframe[@title='Rich Text Editor, exerciseDescription']")	
		private WebElement AddFrame;

		// Writing text inside the frame
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement AddFrame1;

		// click on Enable start time checkbox
		@FindBy(xpath = "//label[contains(text(),'Enable start time')]")
		private WebElement checkBox;

		// For selecting the datefield
		@FindBy(xpath = "//div[@class='input-group']/span/img[@title='Select date']")
		private WebElement dateImage;

		// Click on Now button
		@FindBy(xpath = "//div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']//div//following::div[8]/button[1]")
		private WebElement clickNow;

		// Click on Done button
		@FindBy(xpath = "//div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']//div//following::div[8]/button[2]")
		private WebElement clickDone;

	// Web element for pass percentage
	@FindBy(id = "pass_percentage")
	WebElement passPercentage;

	public void PassPercentage(String num) {
		this.passPercentage.sendKeys(num);
	}

	// Web element for proceed questions

	@FindBy(name = "submitExercise")
	WebElement proceedQuestions;

	public void Proceed() {
		this.proceedQuestions.click();
	}

	// Web element to click multiple choice
	@FindBy(xpath = "//img[@title='Multiple choice']")
	WebElement multipleChoice;

	public void MultipleChoice() {
		this.multipleChoice.click();
	}

	// web element for question name
	@FindBy(name = "questionName")
	WebElement question;

	public void question(String question) {
		this.question.sendKeys(question);
	}
	
	// Identifying the frame
		@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[1]']")
		private WebElement AddFramei;

		// Writing text inside the frame1
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement AddFramei1;

		// Identifying the frame2
		@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[2]']")
		private WebElement AddFrameii;

		// Writing text inside the frame2
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement AddFrameii2;

		// Identifying the frame3
		@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[3]']")
		private WebElement AddFrameiii;

		// Writing text inside the frame3
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement AddFrameii3;

		// Identifying the frame4
		@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[4]']")
		private WebElement AddFrameiiii;

		// Writing text inside the frame4
		@FindBy(xpath = "//body[@contenteditable='true']")
		private WebElement AddFrameii4;

		// Writing score inside the frame1 of quizQuestion 1st
		@FindBy(name = "weighting[1]")
		private WebElement Addscore1_1stQuestion;

		// Writing score beside frame2 of quizQuestion 1st
		@FindBy(name = "weighting[2]")
		private WebElement Addscore2_1stQuestion;

		// Writing score beside frame3 of quizQuestion 1st
		@FindBy(name = "weighting[3]")
		private WebElement Addscore3_1stQuestion;

		// Writing score beside frame4 of quizQuestion 1st
		@FindBy(name = "weighting[4]")
		private WebElement Addscore4_1stQuestion;
		public void Frame() {

			driver.switchTo().frame(AddFrame);
		}

		public void sendTestNameDesc(String AddFrame1) {
			this.AddFrame1.clear();
			this.AddFrame1.sendKeys(AddFrame1);
		}

		
		public void Frame2() {

			driver.switchTo().defaultContent();
		}

		public void clickCheckBox() {
			this.checkBox.click();
		}

		public void clickDateImage() {
			this.dateImage.click();
		}

		public void clickNow() {
			this.clickNow.click();
		}

		public void clickDone() {
			this.clickDone.click();
		}

	// Method for option 1 Iframe element
	/*public void frameOptions() {
		
		  List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		  driver.switchTo().frame(2); 
		  WebElement frame =driver.findElement(By.xpath("/html")); 
		  frame.sendKeys("Selenium");
		  driver.switchTo().frame(4); 
		  WebElement frame1 = driver.findElement(By.xpath("/html")); 
		  frame1.sendKeys("Java");
		  driver.switchTo().frame(6); 
		  WebElement frame2 =driver.findElement(By.xpath("/html"));
		  frame2.sendKeys("C");
		  driver.switchTo().frame(8); 
		  WebElement frame3 =driver.findElement(By.xpath("/html"));
		  frame3.sendKeys("Phyton");
		  driver.switchTo().defaultContent();
		 

	}

//Web element for option 1
	@FindBy(xpath = "//div[@id='cke_2_contents']//iframe")
	WebElement option1;

	public void option1(String option1) {
		this.option1.sendKeys(option1);
	}*/

/*	// Web element for option 2
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[2]']")
	WebElement option2;

	public void option2(String option2) {
		this.option2.sendKeys(option2);
	}

	// Web element for option 3
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[3]']")
	WebElement option3;

	public void option3(String option3) {
	this.option3.sendKeys(option3);
	}

	// Web element for option 4
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, answer[4]']")
	WebElement option4;

	public void option4(String option4) {
	this.option4.sendKeys(option4);
	}*/
	
	//web element for correct option
	@FindBy(name="correct")
	WebElement firstOptionCorrect;
	
	public void Correct() {
		this.firstOptionCorrect.click();
	}
	
	//web element for submit question
	@FindBy(id="submit-question")
	WebElement submit;
	
	public void SubmitQues() {
		this.submit.click();
	}
//Second correct option
	@FindBy(xpath="//tbody[1]/tr[2]/td[2]/input[1]")
	WebElement secondCorrectOption;
	
	public void SecondCorrect() {
		this.secondCorrectOption.click();
	}
	
	//For clicking preview button
	@FindBy(xpath=" //img[@title='Preview']")
	WebElement preview;
	
	public void Preview() {
		this.preview.click();
	}
	//LogOut
	@FindBy(xpath="//span[@class='caret']")
	WebElement logoutarrow;
	
	public void arrowclickForLogout() {
		this.logoutarrow.click();
	}
	
	//Click logout
	@FindBy(id="logout_button")
	WebElement logout;
	
	public void logout() {
		this.logout.click();
	}

public void Framei() {

	driver.switchTo().frame(AddFramei);
}

public void send1text(String AddFramei1) {
	this.AddFramei1.clear();
	this.AddFramei1.sendKeys(AddFramei1);
}


public void Frame1out() {

	driver.switchTo().defaultContent();
}

public void Framei2() {

	driver.switchTo().frame(AddFrameii);
}

public void send2text(String AddFrameii2) {
	this.AddFrameii2.clear();
	this.AddFrameii2.sendKeys(AddFrameii2);
}

public void Frame2out() {

	driver.switchTo().defaultContent();
}

public void Framei3() {

	driver.switchTo().frame(AddFrameiii);
}

public void send3text(String AddFrameii3) {
	this.AddFrameii3.clear();
	this.AddFrameii3.sendKeys(AddFrameii3);
}

// to come out of frame
public void Frame3out() {

	driver.switchTo().defaultContent();
}

public void Framei4() {

	driver.switchTo().frame(AddFrameiiii);
}

public void send4text(String AddFrameii4) {
	this.AddFrameii4.clear();
	this.AddFrameii4.sendKeys(AddFrameii4);
}


public void Frame4out() {

	driver.switchTo().defaultContent();
}

public void score1_1stQuestion(String Addscore1_1stQuestion) {
	this.Addscore1_1stQuestion.clear();
	this.Addscore1_1stQuestion.sendKeys(Addscore1_1stQuestion);
}

public void score2_1stQuestion(String Addscore2_1stQuestion) {
	this.Addscore2_1stQuestion.clear();
	this.Addscore2_1stQuestion.sendKeys(Addscore2_1stQuestion);
}

public void score3_1stQuestion(String Addscore3_1stQuestion) {
	this.Addscore3_1stQuestion.clear();
	this.Addscore3_1stQuestion.sendKeys(Addscore3_1stQuestion);
}

public void score4_1stQuestion(String Addscore4_1stQuestion) {
	this.Addscore4_1stQuestion.clear();
	this.Addscore4_1stQuestion.sendKeys(Addscore4_1stQuestion);
}
}