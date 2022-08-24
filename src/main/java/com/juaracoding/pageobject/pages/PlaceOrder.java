package com.juaracoding.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;



public class PlaceOrder {

private WebDriver driver;
	
	public PlaceOrder() {
		this.driver= DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
	private WebElement clickProduct;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement btnAddtoCart;
	
	@FindBy(xpath = "//i[@class='icon_bag_alt']")
	private WebElement btnCart;
	
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement btnCheckout;
	
	@FindBy(xpath ="//input[@id='billing_first_name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='billing_last_name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//span[@id='select2-billing_country-container']")
	private WebElement selectCountry;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputCountry;
	
	
	@FindBy(xpath = "//input[@id='billing_address_1']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='billing_city']")
	private WebElement city;
	
	@FindBy(xpath= "//span[@id='select2-billing_state-container']")
	private WebElement selectProvince;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputProvince;
	
	@FindBy(xpath = "//input[@id='billing_postcode']")
	private WebElement postcode;
	
	@FindBy(xpath = "//input[@id='billing_phone'")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@id='billing_email'")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"terms\"]")
	private WebElement terms;
	
	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement placeorderBtn;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement msgSucess;
	
	@FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
	private WebElement msgTermError;
	


	public void inputorder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		clickProduct.click();
		Select colorSelect = new Select(driver.findElement(By.id("pa_color")));
		Select sizeSelect = new Select(driver.findElement(By.id("pa_size")));
		js.executeScript("window.scrollBy(0,600)");
		colorSelect.selectByValue("pink");
		colorSelect.selectByValue("36");
		delay(2);
		btnAddtoCart.click();
	}
		
	public void checkout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnCart.click();
		js.executeScript("window.scrollBy(0,600)");
		btnCheckout.click();
	}
	
	public void inputbilling() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		firstName.sendKeys("Faiz");
		lastName.sendKeys("Rizki");
		selectCountry.click();
		inputCountry.sendKeys("Indonesia",Keys.ENTER);
		address.sendKeys("Ciledug");
		city.sendKeys("Tangerang");
		selectProvince.click();
		inputProvince.sendKeys("Banten", Keys.ENTER);
		postcode.sendKeys("15155");
		phone.sendKeys("081234567");
		email.sendKeys("faiz.keren@gmail.com");
	}
	
	public void clickterms() {
		terms.click();
	}
	
	public void clickplaceorder() {
		placeorderBtn.click();
	}
	
	public String getmsgSucess() {
		return msgSucess.getText();
	}
	
	
	public String getmsgTermError() {
		return msgTermError.getText();
	}
	
		
		static void delay(int seconds) {
			try {
				Thread.sleep(seconds*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
