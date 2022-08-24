package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;


public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		loginPage = new LoginPage();
	}
	
	@Test (priority = 1)
	public void validLogin() {
		loginPage.login("faaizrizki13", "faaiz99");
	}
	
	@Test (priority = 2)
	public void invalidUsername() {
		loginPage.login("faaizrizki12", "faaiz99");
		String actual = loginPage.Getmsg();
		assertTrue(actual.contains("Is incorrect"));
	}
	

	@Test (priority = 3)
	public void invalidPassword() {
		loginPage.login("faaizrizki13", "wawkaw");
		String actual = loginPage.Getmsg();
		assertTrue(actual.contains("Is incorrect"));
	}
	

	@Test (priority = 4)
	public void usernameNull() {
		loginPage.login("", "faaiz99");
		String actual = loginPage.Getmsg();
		assertTrue(actual.contains("Is required"));
	}
	
	

	@Test (priority = 5)
	public void passwordNull() {
		loginPage.login("faaizrizki13", "");
		String actual = loginPage.Getmsg();
		assertTrue(actual.contains("Field is empty"));
	}
	
	
	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}
	
	static void delay(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
