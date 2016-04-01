package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categorypage extends Basepage {
		
	@FindBy(xpath="//div[@class='link']//a[text()='Car Seat Sale']")
	WebElement linkCarSeatSale;
	
	@FindBy(xpath="//div[@class='pdpaging-name']//a[text()='Chicco NextFit Convertible Car Seat - Intrigue']")
	WebElement linkProduct;
	
	public Categorypage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCategories(String category)
	{
		return "//div[@class='pdnav-container']";
	}
	
	public void navCarSeatSale() {
		linkCarSeatSale.click();
	}
	
	public void navProducts() {
		linkProduct.click();
	}
	
	
	

}
