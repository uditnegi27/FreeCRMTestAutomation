package com.FreeCRM.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class HomePage extends Base{
	
	
	@FindBy(xpath = "//b[contains(text(),'Mobikasa')]")
	WebElement company_name;
	
	@FindBy(xpath = "//span[contains(text(),'Udit Negi')]")
	WebElement user_name;
	
	@FindBy(xpath = "//div[@class='ui basic button floating item dropdown']")
	WebElement setting_button;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contact_button;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String page_title() {
		String title = driver.getTitle();
		return title;
	}
	
	public String company_name_title() {
		return company_name.getText();
	}
	
	public String user_name_title() {
		return user_name.getText();
	}
	
	public SettingPage click_on_setting_button() {
		setting_button.click();
		return new SettingPage();
	}
	
	public LoginPage select_logout() {
		setting_button.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='menu transition visible']/a"));
		list.get(4).click();
		return new LoginPage();
		
	}
	
	public ContactPage clickOnContactButton() {
		contact_button.click();
		return new ContactPage();
	}

}
