package com.albee.report;


import org.testng.ITestContext;
 
import org.testng.ITestListener;
 
import org.testng.ITestResult;

public class Test_report implements ITestListener {
	
	 

	 
	    public void onStart(ITestContext arg0) {
	 
	         System.out.println("Start Of Execution(TEST)->"+arg0.getName());
	 
	    }
	 
	    public void onTestStart(ITestResult arg0) {
	 
	        System.out.println("Test Started->"+arg0.getName());
	 
	    }
	 
	 
	    public void onTestSuccess(ITestResult arg0) {
	 
	        System.out.println("Test Pass->"+arg0.getName());
	 
	    }
	 
	 
	    public void onTestFailure(ITestResult arg0) {
	 
	        System.out.println("Test Failed->"+arg0.getName());
	 
	    }
	 
	 
	    public void onTestSkipped(ITestResult arg0) {
	 
	        System.out.println("Test Skipped->"+arg0.getName());
	 
	    }
	 
	 
	    public void onFinish(ITestContext arg0) {
	 
	System.out.println("END Of Execution(TEST)->"+arg0.getName());
	 
	    }
	 
	 
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	 
	        // TODO Auto-generated method stub
	 
	         
	 
	    }
	 
	     
	 
	}



