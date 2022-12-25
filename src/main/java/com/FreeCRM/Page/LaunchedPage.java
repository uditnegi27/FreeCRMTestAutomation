package com.FreeCRM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class LaunchedPage extends Base{
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement Login_button;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SingUp_button;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement Pricing_button;
	
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement Features_button;
	
	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement Customers_button;
	
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement Contact_button;
	
	public LaunchedPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String page_title() {
		String title = driver.getTitle();
		return title;
	}
	
	public LoginPage click_on_Login() {
		Login_button.click();
		return new LoginPage();
	}
	
	public SignUpPage click_on_SignUp() {
		SingUp_button.click();
		return new SignUpPage();
	}
	
	
	
	
}
