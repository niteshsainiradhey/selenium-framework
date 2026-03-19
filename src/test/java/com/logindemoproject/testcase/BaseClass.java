package com.logindemoproject.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.logindemoproject.utilities.ReadConfiguration;

public class BaseClass 
{
	public static WebDriver driver;
	ReadConfiguration r=new ReadConfiguration();
	String url=r.getUrl();
	String browser=r.getBrowser();
	
	@BeforeTest
	void setUp()
	{
		switch(browser)
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver=null;
		}
	}
	public void screenshot() throws IOException
	{
		TakesScreenshot tsc=(TakesScreenshot)driver;	
		File a3=tsc.getScreenshotAs(OutputType.FILE);
		File a4=new File("C:\\Users\\DELL\\Desktop\\WorkShop\\Feb\\automation_testing_framework\\screenshot\\login.png");
		FileUtils.copyFile(a3, a4);
	}
	
}
