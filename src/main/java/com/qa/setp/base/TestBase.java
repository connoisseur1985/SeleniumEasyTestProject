package com.qa.setp.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()
	{
	
		FileInputStream fin;
		try {
			fin = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumEasyTestProject\\src\\main\\java\\com\\qa\\setp\\config\\config.properties");
	
			prop = new Properties();
		
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
	
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\eclipse-workspace\\geckodriver.exe");
		
		driver = new FirefoxDriver();
	}
	else if(prop.getProperty("browser").equalsIgnoreCase("IE")) 
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Dell\\eclipse-workspace\\IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();
	} 
	else if(prop.getProperty("browser").equalsIgnoreCase("opera")) 
	{
		System.setProperty("webdriver.opera.driver", "C:\\Users\\Dell\\eclipse-workspace\\operadriver.exe");
		
		driver = new OperaDriver();
	}
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("IMPLICIT_WAIT")),TimeUnit.SECONDS);
	
	}
	
	

}
