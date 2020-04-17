package com.qa.setp.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.setp.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import logs.GenerateLogs;

public class OnTest  extends TestBase implements ITestListener {

	ExtentReports report;
	ExtentTest logger;
	//public static Logger log;
	
	public void onStart(ITestContext context) {

		//log = Logger.getLogger(GenerateLogs.class);
		report = new ExtentReports("C:\\Users\\Dell\\eclipse-workspace\\SeleniumEasyTestProject\\src\\main\\java\\com.qa.setp.testoutput\\extent.html");
	
		logger = report.startTest("Selenium Easy Test");
	}
	
	public void onTestSuccess(ITestResult result) {
		
		logger.log(LogStatus.PASS, "Test Case Passed");
	}
	
	public void onTestSkipped(ITestResult result) {
		logger.log(LogStatus.SKIP, "Test Case Skipped due to some error");
	}
	
	
	
	public void onFinish(ITestContext context) {
		
		//report.endTest(logger);
		report.flush();
		
		
	}
	public void onTestFailure(ITestResult result) {

		logger.log(LogStatus.FAIL, "Test Case Failed By Your Negligence");
		
		try {
		Utilities.getScreenshot();
		
		driver.quit();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
	
	
	
}
