package com.qa.setp.test;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.setp.base.TestBase;
import com.qa.setp.data.DataProviderExcel;
import com.qa.setp.pages.SeleniumEasyHomePage;

public class SearchPageTest extends TestBase{
	
	SeleniumEasyHomePage seleniumEasyHomePage;
	DataProviderExcel dataProviderExcel;
		
	public SearchPageTest() {
	
		super();
//////////////////////////////////////////////
	}
	

	@BeforeMethod()
	public void setUp() throws IOException 
	{
		
				
		initialize();
		//searchPage = new SearchPage();
		 seleniumEasyHomePage = new SeleniumEasyHomePage();
		// dataProviderExcel = new DataProviderExcel();
		// log= Logger.getLogger(logs.GenerateLogs.class);
	}
	
	@Test(dataProvider = "getData")
	public void validateSearchData(String searchData) 
	{
		seleniumEasyHomePage.validateSearchTextBox(searchData);
		//log.info("SearchPage launched");
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='edit-basic']")));
//		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@id='edit-basic']")));
		//log.info("Scrolled into view");
	
		Assert.assertEquals(driver.getTitle(),"Search | Selenium Easy");
	}
	
	@AfterMethod
	public void tearDown() 
	{
		//log.info("driver going to quit");
		driver.quit();
	}
	
	
	
	@DataProvider
	public Iterator<String> getData() throws IOException
	{
		dataProviderExcel = new DataProviderExcel();
		
		Iterator<String> data = dataProviderExcel.getExcelData(prop.getProperty("exceldata")).iterator();

		return data;
		
	}
	

}
