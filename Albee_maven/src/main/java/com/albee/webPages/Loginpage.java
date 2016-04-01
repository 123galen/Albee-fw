package com.albee.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.albee.DataBeans.LoginData;

public class Loginpage extends Basepage{
	
	public Loginpage(WebDriver driver) throws InterruptedException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='landingReturningCustomersEmail']")
	WebElement fieldUsername;
	
	@FindBy(xpath="//input[@id='landingReturningCustomersPassword']")
	WebElement fieldPassword;
	
	@FindBy(xpath="//a[@class='landingForgotPassword']")
	WebElement linkForgotPassword;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement buttonGo;
	

	public void userAccountLogin(LoginData loginData) {
	
		fieldUsername.sendKeys(loginData.getEmail());
		fieldPassword.sendKeys(loginData.getPassword());
		buttonGo.click();
		
	}

	
	

}
