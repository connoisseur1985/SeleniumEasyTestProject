package com.qa.setp.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

//import java.io.File;
//import java.text.SimpleDateFormat;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.qa.setp.base.TestBase;

public class Utilities extends TestBase{
	
	

public static void getScreenshot() throws IOException 
{
	String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(java.util.Calendar.getInstance().getTime());
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Files.copy(src, new File("C:\\Users\\Dell\\eclipse-workspace\\SeleniumEasyTestProject\\src\\main\\java\\com.qa.setp.testoutput\\"+timestamp+".png"));
	
}

}
