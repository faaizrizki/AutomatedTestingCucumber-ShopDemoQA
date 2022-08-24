package com.juaracoding.pageobject.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginPage {

	private WebDriver driver;

	
	//SKENARIO LOGIN
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement msgError;
	
	
	public void login(String username,String password) {
	this.username.sendKeys(username);
	this.password.sendKeys(password);
	btnLogin.click();
}
	//Actual
	public String Getmsg() {
		return msgError.getText();
	}
	
}
	

