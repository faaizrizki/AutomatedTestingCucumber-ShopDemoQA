package com.juaracoding.pageobject.pages;

import java.security.PublicKey;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	private WebElement btnLogin1;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin2;
	
	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement msgError;
	
	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement msgSucess;
	
	@FindBy(xpath = "//a[normalize-space()='My Account']")
	private WebElement myacc;
	
	
	
	public void login(String username,String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
	}
	
	public void deleteLogin() {
		username.sendKeys(Keys.CONTROL+"A");
		username.sendKeys(Keys.BACK_SPACE);
		password.sendKeys(Keys.CONTROL+"A");
		password.sendKeys(Keys.BACK_SPACE);
	}
	
	
	public void clickBtnlogin1() {
		btnLogin1.click();
}
	
	public void clickBtnlogin2() {
		btnLogin2.click();
}
	
	
	public void clickmyAcc() {
		myacc.click();
	}
	
	public String msgSucess() {
		return msgSucess.getText(); 
	}
	
	
	public String msgError() {
		return msgError.getText();
	}
	
}
	

