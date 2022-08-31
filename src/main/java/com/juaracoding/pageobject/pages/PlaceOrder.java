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
	private WebElement clickProduct1;
	
	@FindBy(xpath = "//a[normalize-space()='black lux graphic t-shirt']")
	private WebElement clickProduct2;
	
	
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
	
	@FindBy(id="billing_postcode")
	private WebElement postcode;
	
	@FindBy(id="billing_phone")
	private WebElement phone;
	
	@FindBy(id="billing_email")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"terms\"]")
	private WebElement terms;
	
	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement placeorderBtn;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement msgSucess;
	
	@FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
	private WebElement msgTermError;
	
	@FindBy (xpath = "//a[@class='noo-search']")
	private WebElement searchbtn;
	
	@FindBy (xpath = "//input[@name='s']")
	private WebElement typesearch;


	public void inputorder1() {
		
		// Product 1
		JavascriptExecutor js = (JavascriptExecutor) driver;
		clickProduct1.click();
		js.executeScript("window.scrollBy(0,600)");
		Select colorSelect1 = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		Select sizeSelect1 = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));
		colorSelect1.selectByIndex(1);
		sizeSelect1.selectByIndex(1);
		btnAddtoCart.click();
		delay(2);
	}
		
	public void inputorder2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		clickProduct2.click();
		js.executeScript("window.scrollBy(0,600)");
		Select colorSelect2 = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		Select sizeSelect2 = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));
		colorSelect2.selectByIndex(1);
		sizeSelect2.selectByIndex(1);
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
		this.firstName.sendKeys("Faiz");
		this.lastName.sendKeys("Rizki");
		selectCountry.click();
		this.inputCountry.sendKeys("Indonesia",Keys.ENTER);
		this.address.sendKeys("Ciledug");
		this.city.sendKeys("Tangerang");
		selectProvince.click();
		this.inputProvince.sendKeys("Banten", Keys.ENTER);
		this.postcode.sendKeys("15125");
		this.phone.sendKeys("089737381127");
		this.email.sendKeys("faiz.keren@gmail.com");
		js.executeScript("window.scrollBy(0,-300)");
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
