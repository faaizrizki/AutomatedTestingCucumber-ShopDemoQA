package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.RegisterPage;


public class TestRegister{

	public static WebDriver driver;
	private RegisterPage registerPage;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		registerPage = new RegisterPage();
	}
	
	@Test (priority = 1)
	public void validRegister() {
		registerPage.register("faaizrizki13", "faaizrizki13@gmail.com" ,"faaiz99");
	}
	
	@Test (priority = 2)
	public void invalidRegister() {
		registerPage.register("faaizrizki13", "faaizrizki13@gmail.com", "faaiz99");
		String actual = registerPage.Getmsg();
		assertTrue(actual.contains("Already registered"));
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
	
