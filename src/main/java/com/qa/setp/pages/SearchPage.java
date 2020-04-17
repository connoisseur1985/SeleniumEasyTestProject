package com.qa.setp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.setp.base.TestBase;

public class SearchPage extends TestBase{
	
	public SearchPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ol[@class='search-results node-results']") 
	WebElement searchResult;
	
	
	public List<WebElement> searchResults() throws NullPointerException, InterruptedException  
	{
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,500);");
		
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ol[@class='search-results node-results']/li"))	;	
		
		
		
		return list;
			
	}
	

}
