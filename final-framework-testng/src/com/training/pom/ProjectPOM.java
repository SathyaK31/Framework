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

	// Webelement for clicking project icon
	@FindBy(xpath = "//img[@title='Projects']")
	WebElement projectIcon;

	public void ProjectClick() {
		this.projectIcon.click();
	}

//Webelement for create project
	// @FindBy(linkText="Create a new project")
	@FindBy(xpath = "//*[@id=\"content-section\"]/div/div[2]/a/img")
	WebElement createProject;

	public void CreateProject() {
		this.createProject.click();
	}

//Webelement for text title
	@FindBy(id = "add_blog_blog_name")
	WebElement title;

	public void AddTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}

//webelement for subtitle
	@FindBy(id = "add_blog_blog_subtitle")
	WebElement subTitle;

	public void AddSubTitle(String Subtitle) {
		this.subTitle.clear();
		this.subTitle.sendKeys(Subtitle);
	}

//web element for submit button
	@FindBy(id = "add_blog_submit")
	public WebElement submit;

	public void submit() {
		this.submit.click();
	}

//webelement for clicking project link
	@FindBy(xpath = "//a[contains(text(),'e-learning')]")
	WebElement projectLink;

	public void ClickProject() {
		this.projectLink.click();
	}

//Webelement for create new task
	@FindBy(xpath = "//img[@title='New task']")
	WebElement newTask;

	public void NewTask() {
		this.newTask.click();
	}

//webelement for posttitle
	@FindBy(id = "add_post_title")
	WebElement postTitle;

	public void PostTitle(String title) {
		this.postTitle.sendKeys(title);
	}

//webelement for save button
	@FindBy(id = "add_post_save")
	public WebElement save;

	public void save() {
		this.save.click();
	}

//Webe element for role management 
	@FindBy(xpath = "//*[@id=\"toolbar\"]/div/div/a[3]/img")
	WebElement roleManage;

	public void RoleManage() {
		this.roleManage.click();
	}

//webelement for add role to user
	@FindBy(xpath = "//a[contains(text(),'Add a new role')]")
	WebElement addRole;

	public void AddRole() {
		this.addRole.click();
	}

//webelement for adding role title field
	@FindBy(name = "task_name")
	WebElement roleTitle;

	public void Role(String role) {
		this.roleTitle.sendKeys(role);
	}

//Webelement for save submit button
	@FindBy(name = "Submit")
	public WebElement savesubmit;

	public void Savesubmit() {
		this.savesubmit.click();

	}

//webelement for role assignment
	@FindBy(xpath = "//a[contains(text(),'Assign roles')]")
	WebElement assignRole;

	public void AssignRole() {
		this.assignRole.click();
	}

//webelement for dropdown for user id
	@FindBy(id = "assign_task_task_user_id")
	WebElement DropdownCategory;

//method for selecting dropdown option
	public void category(int index) {
		Select option = new Select(DropdownCategory);
		option.selectByIndex(index);
	}

//webelement for task submit button
	@FindBy(id = "assign_task_submit")
	WebElement taskSubmit;

	public void TaskSubmit() {
		this.taskSubmit.click();
	}

//web element for click on user management
	@FindBy(xpath = "//img[@title='Users management']")
	WebElement userManagement;

	public void UserManagement() {
		this.userManagement.click();
	}

//webelement for checkbox select
	@FindBy(name = "user[]")
	WebElement checkBox;

	public void CheckBoxSelect() {
		this.checkBox.click();
	}

//Webelement to click on register
	@FindBy(xpath = "//tbody/tr[2]/td[5]/a")
	WebElement register;

	public void Register() {
		this.register.click();
	}

//webelement for display text
	@FindBy(xpath = "//*[@id=\"content-section\"]/div/div[2]/div/div[2]")
	public WebElement displayText;

	public String displayText() {
		return this.displayText.getText();

	}
}