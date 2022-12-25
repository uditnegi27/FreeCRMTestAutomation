package com.FreeCRM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class ContactPage extends Base{
	
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement create_contact_button;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public NewContactPage open_create_new_contact() {
		create_contact_button.click();
		return new NewContactPage();
	}
}
