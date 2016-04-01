package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.albee.DataBeans.ShippingData;

public class Paymentpage extends Basepage{
	
	public Paymentpage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='ys_subSection']//input[@id='billing-email']")
	WebElement fieldEmail;
	
	@FindBy(xpath="//input[@id='subscribe-gmk']")
	WebElement checkBoxSendMeSpecialOffers;
	
	@FindBy(xpath="//input[@id='ratings']")
	WebElement checkBoxWouldYouLikeAabaco;
	
	@FindBy(xpath="//input[@id='shipping-first-name']")
	WebElement fieldFName;
	
	@FindBy(xpath="//input[@id='shipping-last-name']")
	WebElement fieldLName;

	@FindBy(xpath="//input[@id='shipping-company']")
	WebElement fieldCompany;
	
	@FindBy(xpath="//input[@id='shipping-address1']")
	WebElement fieldStrAdd1;
	
	@FindBy(xpath="//input[@id='shipping-address2']")
	WebElement fieldStrAdd2;
	
	@FindBy(xpath="//input[@id='shipping-city']")
	WebElement fieldCity;
	
	@FindBy(xpath="//input[@id='shipping-state']")
	WebElement fieldState;
	
	@FindBy(xpath="//input[@id='shipping-zip']")
	WebElement fieldZipCode;

	@FindBy(xpath="//input[@id='shipping-phone']")
	WebElement fieldPhone;

	@FindBy(xpath="//input[@id='shipping-country']")
	WebElement dropDownCountry;

	public void userEmail(ShippingData sd) {
		fieldEmail.sendKeys(sd.getEmail());	
	}
	
	public void specialOfferCheck() {
		
		if(checkBoxSendMeSpecialOffers.isEnabled())
			checkBoxSendMeSpecialOffers.click();	
	    else
			System.out.println("Send me Special Offers not Enabled");
	}
	
	public void wouldLikeToRate() {
		if(checkBoxWouldYouLikeAabaco.isEnabled())
			checkBoxWouldYouLikeAabaco.click();
		else
			System.out.println("Send me Special Offers not Enabled");
	}
	
	public void userShippingDetails(ShippingData sd)
	{
		fieldFName.sendKeys(sd.getFname());
		fieldLName.sendKeys(sd.getLname());
		fieldCompany.sendKeys(sd.getCompany());
		fieldStrAdd1.sendKeys(sd.getStAdd1());
		fieldStrAdd2.sendKeys(sd.getStAdd2());
		fieldCity.sendKeys(sd.getCity());
		fieldState.sendKeys(sd.getState());
		fieldZipCode.sendKeys(sd.getZipCode());
		fieldPhone.sendKeys(sd.getPhone());
		
	}
	
}
