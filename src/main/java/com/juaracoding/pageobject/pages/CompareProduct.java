package com.juaracoding.pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class CompareProduct {
private WebDriver driver;
	
	public CompareProduct() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[@class='noo-search']")
	private WebElement searchbtn;
	
	@FindBy (xpath = "//input[@name='s']")
	private WebElement typesearch;
	
	@FindBy (xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/a]")
	private WebElement compare1;
	
	@FindBy(xpath = "//p[@class='woocommerce-info']")
	private WebElement msgError;

	
	
	
	public void search(String typesearch) {
		searchbtn.click();
		this.typesearch.sendKeys(typesearch);
		this.typesearch.sendKeys(Keys.ENTER);
		compare1.click();
	}
	
	public String Getmsg() {
		return msgError.getText();
	}
	
}

