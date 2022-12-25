package com.FreeCRM.Page;

import org.openqa.selenium.support.PageFactory;

import com.BASE.Base;

public class SettingPage extends Base{
	
	public SettingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String page_title() {
		String title = driver.getTitle();
		return title;
	}

}
