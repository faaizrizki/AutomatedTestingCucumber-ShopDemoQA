package com.juaracoding.pageobject.step_definitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		driver = DriverSingleton.getDriver();
	}
	
	@AfterAll
	public static void closeBrowser() {
		delay(2);
		DriverSingleton.closeObjectInstance();
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

