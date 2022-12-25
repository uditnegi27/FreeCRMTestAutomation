package com.FreeCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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


public class LogIn_testcases extends Base{
	
	LaunchedPage launch;
	LoginPage login;
	HomePage home;
	SettingPage setting;
	ContactPage contact;
	NewContactPage newContact;
	String sheetName = "contact";
	
	public LogIn_testcases() {
		super();
	}
	
	
	@BeforeClass
	public void setup() {
		initialiation();
		launch = new LaunchedPage();
	}
	
	@Test(priority=1)
	public void verify_the_launchedPage_title() {
		String title = launch.page_title();
		Assert.assertEquals(title, "Free CRM with Free calling and auto dialing features");
	}
	
	@Test(priority=2)
	public void open_login_page() {
		login = launch.click_on_Login();
		String title = login.page_title();
		Assert.assertEquals(title, "Free CRM with Free calling and auto dialing features");
	}
	
	@Test(priority=3)
	public void successful_login_in_application() {
		home = login.loginWithValidCredentials();
		String title = home.page_title();
		Assert.assertEquals(title, "Free CRM with Free calling and auto dialing features");
	}
	
	@Test(priority=4)
	public void validate_company_name() {
		Assert.assertEquals(home.company_name_title(), "Mobikasa");
	}
	
	@Test(priority=5)
	public void validate_user_name() {
		Assert.assertEquals(home.user_name_title(), "Udit Negi");
	}
	@Test(priority=6)
	public void logout_application() {
		login = home.select_logout();
		Assert.assertEquals(login.page_title(),  "Cogmento CRM");
	}
	
	@Test(priority=7)
	public void unsuccessful_login_in_application() {
		home = login.loginWithValidCredentials();
		String title = home.page_title();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = Utils.getContactNameFromSheet(sheetName);
		return data;
	}
	
//	@Test(priority=8, dataProvider = "getContactData")
//	public void create_new_contact(String firstName, String lastName) {
//		contact = home.clickOnContactButton();
//		newContact = contact.open_create_new_contact();
//		newContact.create_new_contact(firstName, lastName);
//	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
