package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.Delayed;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SearchShop;

public class TestSearch{

	public static WebDriver driver;
	private SearchShop searchShop;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
	
	@BeforeMethod
	public void pageObject() {
		 searchShop = new SearchShop();
	}
	
	@Test (priority = 1)
	public void testsearch() {
		searchShop.search("Shirt");
	}
	
	@Test (priority = 2)
	public void searcherror() {
		searchShop.search("Sepatu");
		String actual = searchShop.Getmsg();
		assertTrue(actual.contains("No products"));
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}

static void delay(int detik) {
	try {
		Thread.sleep(1000*detik);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		
static void scroll(int vertical) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0,"+vertical+")");
		}
	}
	
	
