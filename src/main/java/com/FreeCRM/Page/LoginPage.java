package com.FreeCRM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class LoginPage extends Base{
	
	@FindBy(name = "email")
	WebElement email_section;
	
	@FindBy(name = "password")
	WebElement password_section;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement login_button;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgot_password_section;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signup_button;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginWithValidCredentials() {
		email_section.sendKeys(prop.getProperty("userEmail"));
		password_section.sendKeys(prop.getProperty("password"));
		login_button.click();
		return new HomePage();
	}
	
	public String page_title() {
		String title = driver.getTitle();
		return title;
	}

}
