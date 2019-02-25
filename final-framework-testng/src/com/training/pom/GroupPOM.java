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
	
	@FindBy(id="toolimage_3054")
	WebElement groupIcon;
	
	public void groupIconClick() {
		this.groupIcon.click();
	}
	
	
	//@FindBy(linkText="Create new group(s)")
	@FindBy(xpath="//*[@id=\"toolbar-groups\"]/div/div[1]/a[1]/img")
	WebElement createGroup;
	
	public void clickCreateGroup() {
		this.createGroup.click();
	}
	
	@FindBy(name="number_of_groups")
	WebElement groupno;


	public void sendGroupNum(String i) {
		this.groupno.clear();
		this.groupno.sendKeys(i);
	}
@FindBy(id="create_groups_submit")
WebElement proceedBtn;

public void Proceed() {
	this.proceedBtn.click();
}
	@FindBy(name="group_0_name")
	WebElement groupName;
	
	public void PassGroupName(String name) {
		this.groupName.clear();
		this.groupName.sendKeys(name);
	}
	@FindBy(id="create_groups_step2_submit")
	WebElement createGroupbtn;
	
	public void createGroup() {
		this.createGroupbtn.click();
	}
	
	//@FindBy(linkText="Group members")
	@FindBy(xpath="//tbody/tr[2]/td[5]/a[3]/img")
	WebElement groupMem;
	
	public void GroupMemClick() {
		this.groupMem.click();
	}
	
	@FindBy(xpath="//*[@id=\"group_members-f\"]/option[1]")
	WebElement addGroupMem;
	
	public void AddGroupMem() {
		this.addGroupMem.click();
		
	}
	
	@FindBy(name="add")
	WebElement add;
	
	public void add() {
		this.add.click();
	}
	
	@FindBy(id="group_edit_submit")
	WebElement saveSettings;
	
	public void SaveSettings() {
		this.saveSettings.click();
	}
	//@FindBy(linkText="Edit this group")
	@FindBy(xpath="//tbody/tr[2]/td[5]/a[1]/img")
	//@FindBy(xpath="//tbody/tr[2]/td[4]/a[3]/img")
	WebElement edit;
	
	public void edit() {
		this.edit.click();
	}
	@FindBy(name="self_registration_allowed")
	WebElement selfCheckbox;
	
	public void CheckboxSelect() {
		this.selfCheckbox.click();
	}
	
	@FindBy(name="self_unregistration_allowed")
	WebElement UnregisterCheck;
	
	public void ClickUnregister() {
		this.UnregisterCheck.click();
	}
	@FindBy(id="group_edit_submit")
	WebElement finalSubmit;
	
	public void FinalSubmit() {
		this.finalSubmit.click();
	}
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]")
	public
	WebElement displayText;
	
	public String displayText() {
		return this.displayText.getText();
	
}
}
