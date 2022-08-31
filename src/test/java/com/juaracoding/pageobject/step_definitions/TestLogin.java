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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage = new LoginPage();
	
	public TestLogin() {
		driver = Hooks.driver;
	}
	
	
	@When("User go to login page")
	public void user_go_to_login_page() {
		driver.get(Constants.URLLogin);
	}
	
	//Invalid
	@And("User enter username password invalid")
	public void user_enter_username_password_invalid() {
		loginPage.login("faaiz13", "faaiz98");
	}
	
	@And("User click button login invalid")
	public void user_click_button_login_invalid() {
		loginPage.clickBtnlogin1();
		delay(3);
	}
	

//	@Then("User invalid credentials")
//	public void user_invalid_credentilas() {
//		String actual = loginPage.msgError();
//		assertTrue(actual.contains("Is incorrect"));
//	}
	
	
	//Valid
	@When("User delete username password")
	public void user_delete_username_password() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		delay(3);
		loginPage.deleteLogin();
	}
	
	
	@When("User enter username password valid")
	public void user_enter_username_password_valid() {
		loginPage.login("faaiz13", "faaiz99");
	}

	@And("User click button login valid")
	public void user_click_button_login_valid() {
		loginPage.clickBtnlogin2();
	}
	
//	@Then("User on menu homepage")
//	public void user_on_menu_homepage() {
//		String actual = loginPage.msgSucess();
//		assertTrue(actual.contains("My Account"));
//	}
	
	
	
	
	static void delay(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
