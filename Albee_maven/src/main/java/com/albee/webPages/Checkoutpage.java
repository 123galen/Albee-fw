package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage extends Basepage{
	
	@FindBy(xpath="//div[@id='ys_proceedContainer']//input[@class='ys_primary']")
	WebElement buttonCheckout;
	
	public Checkoutpage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void checkOut()  {
		buttonCheckout.click();
	}

}
