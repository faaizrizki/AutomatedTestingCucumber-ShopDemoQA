package com.juaracoding.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.Logout;
import com.juaracoding.pageobject.pages.PlaceOrder;
import com.juaracoding.pageobject.pages.SearchShop;

public class TestLogout {

	public static WebDriver driver;
	private LoginPage loginPage;
	private Logout logout;
	
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
		logout = new Logout();
	}

	@Test (priority = 1)
	public void logOut() {
		loginPage.login("faaizrizki13", "faaiz99");
		logout.logout();
		System.out.println("Logout sucess");
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

	
