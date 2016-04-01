package com.albee.report;

import java.io.File;
 
import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.annotations.Test;

public class Test_Screenshot {
	
	 
	    @Test
	 
	    public void testTakeScreenShot() throws Exception{
	 
	        WebDriver driver = new FirefoxDriver();
	 
	        //goto url
	 
	        driver.get("http://albeebaby.com");
	 
	        //Call take screenshot function
	 
	        this.takeSnapShot(driver, "/Users/NIS1631-mbpr/Documents/eclipse_workspace/Albee_J/test-output/Screenshot/") ;
	 
	         
	 
	    }
	 
	       
	 
	     
	 
	    /**
	 
	     * This function will take screenshot
	 
	     * @param webdriver
	 
	     * @param fileWithPath
	 
	     * @throws Exception
	 
	     */
	 
	    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	 
	        //Convert web driver object to TakeScreenshot
	 
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	 
	        //Call getScreenshotAs method to create image file
	 
	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 
	            //Move image file to new destination
	 
	                File DestFile=new File(fileWithPath);
	 
	                //Copy file at destination
	 
	                FileUtils.copyFile(SrcFile, DestFile);
	 
	             
	 
	    }
	 
	}

