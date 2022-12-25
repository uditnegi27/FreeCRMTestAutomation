package com.FreeCRM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class NewContactPage extends Base{
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement create_contact_button;
	
	@FindBy(name = "first_name")
	WebElement first_name_section;
	
	@FindBy(name = "last_name")
	WebElement last_name_section;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement save_button;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void create_new_contact(String first_name, String last_name ) {
		first_name_section.sendKeys(first_name);
		last_name_section.sendKeys(last_name);
		save_button.click();
	}
}
