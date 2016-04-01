package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage extends Basepage {
	
	@FindBy(xpath="//div[@class='pditem-orderbox']//input[@value='ADD TO CART']")
	WebElement buttonAddtoCart;
	
	public Productpage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addtoCart()  {
		buttonAddtoCart.click();	
	}
	
	
	
	

}
