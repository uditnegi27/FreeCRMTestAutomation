package com.BASE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.FreeCRM.Utils.Utils;

public class Base {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public Base() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("/Users/honasa/Desktop/SeleniumSeesion/FreeCRMTest/src/main/java/com/FreeCRM/configuration/configuration.properties");
			prop.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialiation() {
		String browser_name = prop.getProperty("browser");
		if(browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/honasa/Downloads/chromedriver");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(prop.getProperty("url"));
			
			driver.manage().timeouts().pageLoadTimeout(Utils.pageLoadTimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utils.implicitTimeout, TimeUnit.SECONDS);
			
		}
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/honasa/Downloads/chromedriver");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(prop.getProperty(browser_name));
			
			driver.manage().timeouts().pageLoadTimeout(Utils.pageLoadTimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utils.implicitTimeout, TimeUnit.SECONDS);
		}
		
	}

}
