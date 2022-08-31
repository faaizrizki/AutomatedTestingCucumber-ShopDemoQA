package com.juaracoding.pageobject.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.PlaceOrder;
import com.juaracoding.pageobject.pages.SearchShop;
import com.juaracoding.pageobject.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class TestPlaceOrder {

	public static WebDriver driver;
	public static ExtentTest extentTest;
	
	private LoginPage loginPage = new LoginPage();
	private PlaceOrder placeOrder = new PlaceOrder();
	private SearchShop searchShop = new SearchShop();
	
	public TestPlaceOrder() {
		driver = Hooks.driver;
		extentTest = Hooks.extentTest;
	}
	
	
	@When("User go to web page")
	public void user_go_to_web_page() {
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User go to web page");
	}
	
	@When("User search product1")
	public void user_search_product1() {
		searchShop.search("Shirt");
		extentTest.log(LogStatus.PASS, "User search product1");
	}
	
	@And("User add to cart1")
	public void user_add_to_cart1() {
		placeOrder.inputorder1();
		extentTest.log(LogStatus.PASS, "User add to cart1");
	}
	
	@When("User search product2")
	public void user_search_product2() {
		searchShop.search("Shirt");
		extentTest.log(LogStatus.PASS, "User search product2");
	}
	
	@And("User add to cart2")
	public void user_add_to_cart2() {
		placeOrder.inputorder2();
		extentTest.log(LogStatus.PASS, "User add to cart2");
	}
	
	@And("User click checkout")
	public void user_click_checkout() {
		placeOrder.checkout();
		extentTest.log(LogStatus.PASS, "User click checkout");
	}
	
	@When("User fill billing")
	public void user_fill_billing() {
		placeOrder.inputbilling();
		extentTest.log(LogStatus.PASS, "User fill billing");
	}
	
	@And("User click terms")
	public void user_click_terms() {
		placeOrder.clickterms();
		extentTest.log(LogStatus.PASS, "User click terms");
	}
	
	@And("User click place order")
	public void user_click_place_order() {
		placeOrder.clickplaceorder();
		extentTest.log(LogStatus.PASS, "User click place order");
	}
	
	@Then("User sucess order")
	public void user_sucess_order() {
		String actual = placeOrder.getmsgSucess();
		assertTrue(actual.contains("Thank you"));
		extentTest.log(LogStatus.PASS, "User sucess order");
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
