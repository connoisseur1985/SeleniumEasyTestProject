package com.qa.setp.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.setp.base.TestBase;
import com.qa.setp.data.DataProviderExcel;
import com.qa.setp.pages.SearchPage;
import com.qa.setp.pages.SeleniumEasyDemoPage;
import com.qa.setp.pages.SeleniumEasyHomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class SeleniumEasyHomePageTest extends TestBase{

	
	SeleniumEasyHomePage seleniumEasyHomePage;
	SeleniumEasyDemoPage seleniumEasyDemoPage;
	SearchPage searchPage;
	DataProviderExcel dataProviderExcel;
	ExtentReports report;
	ExtentTest logger;
	SoftAssert sassert;
	
	public SeleniumEasyHomePageTest() throws IOException {
	
		super();
		
	}

	
	@DataProvider
	public Iterator<String> getData() throws IOException
	{
		dataProviderExcel = new DataProviderExcel();
		
		Iterator<String> data = dataProviderExcel.getExcelData(prop.getProperty("exceldata")).iterator();

		return data;
		
	}
	@BeforeMethod
	public void setup() throws IOException 
	{
		
		initialize();
		seleniumEasyHomePage = new SeleniumEasyHomePage();
		searchPage = new SearchPage();
		sassert = new SoftAssert();
		
		
	
		
		
		
	}
	@Test(priority=1,enabled=true)
	public void verifyLogoLink() throws IOException 
	{
		seleniumEasyHomePage.clickOnLogoLink();
		//OnTest.log.info("LogoLink clicked");
		sassert.assertEquals(driver.getCurrentUrl(), "https://www.seleniumeasy.com/");

	}
	
	@Test(priority = 2 ,enabled=true)
	public void verifyDemoLink() throws IOException 
	{
		seleniumEasyHomePage.validateDemoWebSiteLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.seleniumeasy.com/test/");
	}
	
	@Test(priority =0, dataProvider ="getData", enabled=false)
	public void verifySearchTextBox(String searchData) throws InterruptedException 
	{
		seleniumEasyHomePage.validateSearchTextBox(searchData);

		
		List<WebElement> list = searchPage.searchResults();
		
			System.out.println(searchData);
			
			Iterator<WebElement> it = list.iterator();
			while(it.hasNext()) 
			{
				
				System.out.println(it.next().getText().toString());
			}
		
			
		
	}
	@AfterMethod
	public void tearDown() 
	{
		
		sassert.assertAll();
		driver.quit();
	}
}
