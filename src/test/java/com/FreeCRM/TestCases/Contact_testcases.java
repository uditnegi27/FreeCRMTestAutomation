package com.FreeCRM.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BASE.Base;
import com.FreeCRM.Page.ContactPage;
import com.FreeCRM.Page.HomePage;
import com.FreeCRM.Page.LaunchedPage;
import com.FreeCRM.Page.LoginPage;
import com.FreeCRM.Page.NewContactPage;
import com.FreeCRM.Page.SettingPage;
import com.FreeCRM.Utils.Utils;

public class Contact_testcases extends Base{
	
	LaunchedPage launch;
	LoginPage login;
	HomePage home;
	SettingPage setting;
	ContactPage contact;
	NewContactPage newContact;
	String sheetName = "contact";
	
	public Contact_testcases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialiation();
		launch = new LaunchedPage();
		login = launch.click_on_Login();
		home = login.loginWithValidCredentials();
		
	}
	
	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = Utils.getContactNameFromSheet(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getContactData")
	public void create_new_contact(String firstName, String lastName) {
		contact = home.clickOnContactButton();
		newContact = contact.open_create_new_contact();
		newContact.create_new_contact(firstName, lastName);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
