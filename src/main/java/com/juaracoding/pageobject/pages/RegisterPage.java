package com.juaracoding.pageobject.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RegisterPage {

	private WebDriver driver;
	
	
	//SKENARIO REGISTER
	public RegisterPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement registUser;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement registEmail;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement registPass;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnRegist;
	
	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement msgError;


	public void register(String registuser, String registemail, String registpass){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		this.registUser.sendKeys(registuser);
		this.registEmail.sendKeys(registemail);
		this.registPass.sendKeys(registpass);
		btnRegist.click();
	}
	
	public String Getmsg() {
		return msgError.getText();
	}
	
	
}
