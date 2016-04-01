package com.albee.testpage;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.albee.DataBeans.LoginData;
import com.albee.DataBeans.ShippingData;
import com.albee.webPages.Basepage;
import com.albee.webPages.Categorypage;
import com.albee.webPages.Checkoutpage;
import com.albee.webPages.Homepage;
import com.albee.webPages.Loginpage;
import com.albee.webPages.Paymentpage;
import com.albee.webPages.Productpage;
import com.albee.report.*;


import com.albee.DataBeans.DbconInMemory;
//@Listeners(Test_report.class)

@Listeners(value=Test_report_ireport.class)
public class Test_login extends Basepage{



	@Test
	public void Login() throws InterruptedException, SQLException{
	//	WebDriver driver=new FirefoxDriver();
		
		WebDriver driver=new HtmlUnitDriver();
		
	//System.setProperty("webdriver.chrome.driver","C://Users/Nisumite/Desktop/Macys/Quality Analyst/chrome driver/chromedriver_win32/chromedriver.exe");
	
		//WebDriver driver = new ChromeDriver();
		String appUrl= "http://albeebaby.com";
		
		driver.get(appUrl);
		DbconInMemory dbconin = new DbconInMemory();
		//dbconin.getLoginData();

		//	Dbcon dbcon = new Dbcon();



		//	LoginData ld = new LoginData();

		LoginData ldt  = dbconin.getLoginData();


		//	ld.setEmail();
		//	ld.setEmail("abcxyz@gmail.com");
		//	ld.setPassword("abc123xyz");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(">>>" +ldt.getEmail());
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		//	ShippingData sd = new ShippingData();
		ShippingData sdt = dbconin.getShippingData();
		System.out.println(">>>" +sdt.getFname());
		//sd.setEmail("");
		/*sd.setFname("abc");
	sd.setLname("xyz");
	sd.setCompany("Delta corporation");
	sd.setStAdd1("100 north point");
	sd.setStAdd2("suite 100");
	sd.setCity("San Francisco");
	sd.setState("California");
	sd.setZipCode("94133");
	sd.setPhone("4156234356");*/

		Homepage hp = new Homepage(driver);
		Thread.sleep(5000);
		hp.navAccount();	

		Loginpage lp = new Loginpage(driver);
		lp.userAccountLogin(ldt);

		hp.navCarSeat();

		Categorypage ct = new Categorypage(driver);
		ct.navCarSeatSale();
		ct.navProducts();

		Productpage pdp = new Productpage(driver);
		pdp.addtoCart();

		Checkoutpage cop = new Checkoutpage(driver);
		cop.checkOut();

		Paymentpage pp = new Paymentpage(driver);
		pp.userEmail(sdt);
		pp.specialOfferCheck();
		pp.userShippingDetails(sdt);

		driver.quit();

	}





}
