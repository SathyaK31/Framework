package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupPOM {

	private WebDriver driver;

	public GroupPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Webelement for group icon
	@FindBy(id = "toolimage_3054")
	WebElement groupIcon;

	public void groupIconClick() {
		this.groupIcon.click();
	}

	// Webelement for creategroup
	// @FindBy(linkText="Create new group(s)")
	@FindBy(xpath = "//*[@id=\"toolbar-groups\"]/div/div[1]/a[1]/img")
	WebElement createGroup;

	public void clickCreateGroup() {
		this.createGroup.click();
	}

	// Webelement for passing no of groups
	@FindBy(name = "number_of_groups")
	WebElement groupno;

	public void sendGroupNum(String i) {
		this.groupno.clear();
		this.groupno.sendKeys(i);
	}

//Webelement for proceed button
	@FindBy(id = "create_groups_submit")
	WebElement proceedBtn;

	public void Proceed() {
		this.proceedBtn.click();
	}

//webelement for groupname and sending keys
	@FindBy(name = "group_0_name")
	WebElement groupName;

	public void PassGroupName(String name) {
		this.groupName.clear();
		this.groupName.sendKeys(name);
	}

//Webelement for create groupbutton
	@FindBy(id = "create_groups_step2_submit")
	WebElement createGroupbtn;

	public void createGroup() {
		this.createGroupbtn.click();
	}

//Webelement for groupmember
	// @FindBy(linkText="Group members")
	@FindBy(xpath = "//tbody/tr[2]/td[5]/a[3]/img")
	WebElement groupMem;

	public void GroupMemClick() {
		this.groupMem.click();
	}

//web element for addding group member
	@FindBy(xpath = "//*[@id=\"group_members-f\"]/option[1]")
	WebElement addGroupMem;

	public void AddGroupMem() {
		this.addGroupMem.click();

	}

//Web element for add button
	@FindBy(name = "add")
	WebElement add;

	public void add() {
		this.add.click();
	}

//
	@FindBy(id = "group_edit_submit")
	WebElement saveSettings;

	public void SaveSettings() {
		this.saveSettings.click();
	}

	// @FindBy(linkText="Edit this group")
	// WebElement for edit option
	@FindBy(xpath = "//tbody/tr[2]/td[5]/a[1]/img")
	WebElement edit;

	public void edit() {
		this.edit.click();
	}

//Webelement for clicking checkbox
	@FindBy(name = "self_registration_allowed")
	WebElement selfCheckbox;

	public void CheckboxSelect() {
		this.selfCheckbox.click();
	}

//Webelement for unregister checkbox
	@FindBy(name = "self_unregistration_allowed")
	WebElement UnregisterCheck;

	public void ClickUnregister() {
		this.UnregisterCheck.click();
	}

//Webelement for final submit button
	@FindBy(id = "group_edit_submit")
	WebElement finalSubmit;

	public void FinalSubmit() {
		this.finalSubmit.click();
	}

//webelement for display text
	@FindBy(xpath = "//*[@id=\"content-section\"]/div/div[2]")
	public WebElement displayText;

	public String displayText() {
		return this.displayText.getText();

	}
}
