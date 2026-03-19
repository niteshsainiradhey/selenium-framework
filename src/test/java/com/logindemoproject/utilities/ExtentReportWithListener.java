package com.logindemoproject.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.logindemoproject.testcase.BaseClass;

public class ExtentReportWithListener extends BaseClass implements ITestListener
{
	ExtentSparkReporter createreport;
	ExtentReports addtest;
	ExtentTest addlogs;
	
	void reports()
	{
		
		createreport=new ExtentSparkReporter("mydemo.html");
		addtest=new ExtentReports();
		addtest.attachReporter(createreport);
		
		//Set Environment
		addtest.setSystemInfo("Operating_System", "Window");
		addtest.setSystemInfo("Browser", "Chrome");
		addtest.setSystemInfo("Browser_Version", "122.34.33.02");
		addtest.setSystemInfo("Environment", "QA");
		addtest.setSystemInfo("User", "Ravi Kumar");
		//Set Configuration

		createreport.config().setReportName("MyClass10am");
		createreport.config().setDocumentTitle("Mynewreports");
		createreport.config().setTheme(Theme.DARK);
		
	}
	 public void onStart(ITestContext Result) 
	 { 
		 reports();
	 } 
	 public void onTestSuccess(ITestResult Result) 
	 { 
	    addlogs=addtest.createTest(Result.getName());
		addlogs.log(Status.PASS,MarkupHelper.createLabel("Test case Pass", ExtentColor.GREEN));
	 } 
	 public void onTestFailure(ITestResult Result) 
	 { 
		 try {
			screenshot();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 String path="C:\\Users\\DELL\\Desktop\\WorkShop\\Feb\\automation_testing_framework\\screenshot\\login.png";
		addlogs=addtest.createTest(Result.getName());
		addlogs.log(Status.FAIL,MarkupHelper.createLabel("Test case Fail", ExtentColor.RED));
		addlogs.fail("MyFailTestCase:-"+addlogs.addScreenCaptureFromPath(path));
	 } 
	 public void onTestSkipped(ITestResult Result) 
	 { 
		addlogs=addtest.createTest(Result.getName());
		addlogs.log(Status.SKIP,MarkupHelper.createLabel("Test case skipped", ExtentColor.YELLOW));
	 }  
	 public void onFinish(ITestContext Result) 
	 { 
		 addtest.flush();
	 } 
}
