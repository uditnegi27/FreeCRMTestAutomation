package com.FreeCRM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class SignUpPage extends Base{
	
	@FindBy(id = "email")
	WebElement email_section;
	
	@FindBy(id = "phone_number")
	WebElement phone_section;
	
	@FindBy(id = "terms")
	WebElement terms_section;
	
	@FindBy(xpath = "//div[contains(@class,'recaptcha-checkbox-border')][1]")
	WebElement captcha_section;
	
	@FindBy(name = "action")
	WebElement submit_button;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage signUpWithValidCredentials() {
		email_section.sendKeys(prop.getProperty("userEmail"));
		phone_section.sendKeys(prop.getProperty("phoneNumber"));
		terms_section.click();
		captcha_section.click();
		submit_button.click();
		return new HomePage();
	}

}
