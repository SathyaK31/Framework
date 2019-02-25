package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectPOM {

	private WebDriver driver; 
	public ProjectPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Projects']")
	WebElement projectIcon;
	
	public void ProjectClick() {
		this.projectIcon.click();
	}
	
	//@FindBy(linkText="Create a new project")
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a/img")
	WebElement createProject;
	
	public void CreateProject() {
		this.createProject.click();
	}
	
	@FindBy(id="add_blog_blog_name")
	WebElement title;
	
	public void AddTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	@FindBy(id="add_blog_blog_subtitle")
	WebElement subTitle;
	
	public void AddSubTitle(String Subtitle) {
		this.subTitle.clear();
		this.subTitle.sendKeys(Subtitle);
	}
	@FindBy(id="add_blog_submit")
	public
	WebElement submit;
	
	public void submit() {
		this.submit.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'e-learning')]")
	WebElement projectLink;
	
	public void ClickProject() {
		this.projectLink.click();
	}
	
	@FindBy(xpath="//img[@title='New task']")
	WebElement newTask;
	
	public void NewTask() {
		this.newTask.click();
	}
	
	@FindBy(id="add_post_title")
	WebElement postTitle;
	
	public void PostTitle(String title) {
		this.postTitle.sendKeys(title);
	}
	
	@FindBy(id="add_post_save")
	public
	WebElement save;
	
	public void save() {
		this.save.click();
	}
	
	@FindBy(xpath="//*[@id=\"toolbar\"]/div/div/a[3]/img")
	WebElement roleManage;
	
	public void RoleManage() {
		this.roleManage.click();
	}
	@FindBy(xpath="//a[contains(text(),'Add a new role')]")
	WebElement addRole;
	
	public void AddRole() {
		this.addRole.click();
	}
	
	@FindBy(name="task_name")
	WebElement roleTitle;
	
	public void Role(String role) {
	this.roleTitle.sendKeys(role);
	}
	@FindBy(name="Submit")
	public
	WebElement savesubmit;
	
	public void Savesubmit() {
		this.savesubmit.click();
		
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Assign roles')]")
	WebElement assignRole;
	
	public void AssignRole() {
		this.assignRole.click();
	}
	
	@FindBy(id="assign_task_task_user_id")
	//@FindBy(xpath="//*[@id=\"assign_task\"]/fieldset/div[1]/div[1]/div/button/span[2]/span")
	WebElement DropdownCategory;
	
	
	public void category(int index) {
		Select option=new Select(DropdownCategory);
		option.selectByIndex(index);
}
	
	@FindBy(id="assign_task_submit")
	WebElement taskSubmit;
	
	public void TaskSubmit() {
		this.taskSubmit.click();
	}
	@FindBy(xpath="//img[@title='Users management']")
	WebElement userManagement;
	
	public void UserManagement() {
		this.userManagement.click();
	}
	
	@FindBy(name="user[]")
	WebElement checkBox;
	
	public void CheckBoxSelect() {
		this.checkBox.click();
	}
	@FindBy(xpath="//tbody/tr[2]/td[5]/a")
	WebElement register;
	
	public void Register() {
		this.register.click();
	}
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div/div[2]")
	public
	WebElement displayText;
	
	public String displayText() {
		return this.displayText.getText();
		
	}
}