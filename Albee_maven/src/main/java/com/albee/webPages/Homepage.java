package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {
	
	@FindBy(xpath="//div[@class='links']//a[text()='My Account']")
	WebElement linkMyAccount;

	@FindBy(xpath="//div[@class='pdnav-container']//a[text()='Car Seats']")
	WebElement menuCarSeat;
	
	public Homepage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navAccount() {
		linkMyAccount.click();
	}
	
	public void navCarSeat() {
		menuCarSeat.click();
	}
	
	/*public void navCategory(category) {
		menuCategory.click();
	}*/
	
	
}
