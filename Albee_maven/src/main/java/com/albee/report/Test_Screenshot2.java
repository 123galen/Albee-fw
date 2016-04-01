//package com.albee.report;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.Augmenter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITestNGMethod;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
//
//public class Test_Screenshot2 {
//	
//
//	private final static Logger log = LoggerFactory.getLogger(TestUtils.class);
//
//	public static void takeDriverSnapShot(WebDriver driver, String screenSnapshotName) {
//	File browserFile = new File(System.getProperty("java.io.tmpdir") + File.separator +screenSnapshotName + ".png");
//	snapshotBrowser((TakesScreenshot) driver, screenSnapshotName, browserFile);
//	}
//
//	private static void snapshotBrowser(TakesScreenshot driver, String screenSnapshotName, File browserFile) {
//	try {
//
//	File scrFile = driver.getScreenshotAs(OutputType.FILE);
//	log.info("PNG browser snapshot file name: \"{}\"", browserFile.toURI().toString());
//
//	FileUtils.deleteQuietly(browserFile);
//	FileUtils.moveFile(scrFile, browserFile);
//	} catch (Exception e) {
//	log.error("Could not create browser snapshot: " + screenSnapshotName, e);
//	}
//	}
//
//	public static void main(String[] args){
//	WebDriver driver = new FirefoxDriver();
//	driver.get("http://google.com");
//
//	TestUtils.takeDriverSnapShot(driver, "google_com");
//	driver.close();
//	}
//	}
//
//	
//	@AfterMethod(alwaysRun = true)
//	public void afterMethod(ITestResult result) throws Exception {
//	if (!result.isSuccess())
//	takeScreenShoot(threadDriver, result.getMethod());
//
//	// Quit environment.
//	getDriver().close();
//	getDriver().quit();
//	}
//
//	public void takeScreenShoot(ThreadLocal threadDriver, ITestNGMethod testMethod) throws Exception {
//	WebDriver augmentedDriver = new Augmenter().augment(threadDriver.get());
//	File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//	String nameScreenshot = testMethod.getMethodName();
//	String path = getPath(nameScreenshot);
//	FileUtils.copyFile(screenshot, new File(path));
//	Reporter.log("<a href="file://&quot;" target="_blank">" + this.getFileName(nameScreenshot) + "</a>");
//	}
//
//	private String getFileName(String nameTest) throws IOException {
//	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
//	Date date = new Date();
//	return dateFormat.format(date) + "_" + nameTest + ".png";
//	}
//
//	private String getPath(String nameTest) throws IOException {
//	File directory = new File(".");
//	String newFileNamePath = directory.getCanonicalPath() + "/target/surefire-reports/screenShots/" + getFileName(nameTest);
//	return newFileNamePath;
//	}
//
//}
