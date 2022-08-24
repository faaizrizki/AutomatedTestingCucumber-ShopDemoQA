package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.PlaceOrder;
import com.juaracoding.pageobject.pages.SearchShop;
import com.juaracoding.pageobject.drivers.DriverSingleton;

public class TestPlaceOrder {

	public static WebDriver driver;
	private LoginPage loginPage;
	private PlaceOrder placeOrder;
	private SearchShop searchShop;
	
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
		placeOrder = new PlaceOrder();
		searchShop = new SearchShop();
	}
	
	@Test (priority = 1)
	public void validOrder() {
		loginPage.login("faaizrizki13", "faaiz99");
		searchShop.search("SHIRT");
		placeOrder.inputorder();
		placeOrder.checkout();
		placeOrder.inputbilling();
		placeOrder.clickterms();
		placeOrder.clickplaceorder();
		
		String actual = placeOrder.getmsgSucess();
		assertTrue(actual.contains("Your order has"));
	}
	
	@Test (priority = 2)
	public void invalidOrder() {
		loginPage.login("faaizrizki13", "faaiz99");
		searchShop.search("SHIRT");
		placeOrder.inputorder();
		placeOrder.checkout();
		placeOrder.inputbilling();
		
		String actual = placeOrder.getmsgTermError();
		assertTrue(actual.contains("Is a rquired field"));
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
