package com.qa.setp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.setp.base.TestBase;

public class SeleniumEasyHomePage extends TestBase{
	
	
	public SeleniumEasyHomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}

	//SeleniumEasyHomePage seleniumEasyHomePage;

	@FindBy(xpath="//a[contains(text(),'Demo Website!')]") 
	WebElement demoSiteLink;
	
	@FindBy(xpath="//input[@id='edit-search-block-form--2']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//span[@class='input-group-btn']") 
	WebElement searchButton;
	
	@FindBy(xpath="//a[contains(text(),'More.. ')]") 
	WebElement moreDropDownLink;
	
	
	@FindBy(xpath="//div[@id='logo']") 
	WebElement logoLink;
	
	@FindBy(id="site-name")
	WebElement siteName;	
	
	
	public void validateDemoWebSiteLink() throws IOException 
	{
		demoSiteLink.click();
		
		//return new SeleniumEasyDemoPage();
	}

	public void clickOnLogoLink() throws IOException {
		
		logoLink.click();
		
		//return new SeleniumEasyHomePage();
		
	}
	public void validateSearchTextBox(String searchData) 
	{
		searchTextBox.sendKeys(searchData);
		searchButton.click();
		
		//return new SearchPage();
	}
	
	
}
