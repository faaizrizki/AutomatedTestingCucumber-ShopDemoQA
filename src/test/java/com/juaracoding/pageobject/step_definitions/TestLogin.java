package com.juaracoding.pageobject.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestLogin {

	public static WebDriver driver;
	public static ExtentTest extentTest;
	private LoginPage loginPage = new LoginPage();
	
	public TestLogin() {
		driver = Hooks.driver;
		extentTest = Hooks.extentTest;
	}
	
	
	@When("User go to login page")
	public void user_go_to_login_page() {
		driver.get(Constants.URLLogin);
		extentTest.log(LogStatus.PASS, "User go to login page");
	}
	
	//Invalid
	@And("User enter username password invalid")
	public void user_enter_username_password_invalid() {
		loginPage.login("faaiz13", "faaiz98");
		extentTest.log(LogStatus.PASS, "User enter username password invalid");
	}
	
	
	@And("User click button login invalid")
	public void user_click_button_login_invalid() {
		loginPage.clickBtnlogin1();
		Hooks.delay(3);
		extentTest.log(LogStatus.PASS, "User click button login invalid");
	}
	

	@Then("User invalid credentials")
	public void user_invalid_credentilas() {
		String actual = loginPage.msgError();
		assertTrue(actual.contains("Is incorrect"));
		extentTest.log(LogStatus.PASS, "User invalid credentials");
	}
	
	
	//Valid
	@When("User delete username password")
	public void user_delete_username_password() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)");
		Hooks.scroll(500);
		Hooks.delay(3);
		loginPage.deleteLogin();
		extentTest.log(LogStatus.PASS, "User delete username password");
	}
	
	
	@When("User enter username password valid")
	public void user_enter_username_password_valid() {
		loginPage.login("faaiz13", "faaiz99");
		extentTest.log(LogStatus.PASS, "User enter username password valid");
	}

	@And("User click button login valid")
	public void user_click_button_login_valid() {
		loginPage.clickBtnlogin2();
		String actual = loginPage.msgSucess();
		assertTrue(actual.contains(""));		
		extentTest.log(LogStatus.PASS, "User click button login valid");
	}
	
	@Then("User on menu homepage")
	public void user_on_menu_homepage() {
		String actual = loginPage.msgSucess();
		assertTrue(actual.contains("My Account"));
		extentTest.log(LogStatus.PASS, "User on menu homepage");
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
	
