package com.Actitime.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementation extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		String mehtodname = result.getName();
		test = report.createTest(mehtodname);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname = result.getName();
		test.log(Status.PASS, methodname+"--->passes");
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+name+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, name+"--->failed" );
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String name = result.getName();
		test.log(Status.SKIP, name+"skipped");
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
		JavaUtility jutil = new JavaUtility(); 
		String dateandTime = jutil.getDateandTime("dd-MM-yyyy hh-mm-ss");
		
		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/report"+dateandTime+".html");
		reporter.config().setDocumentTitle("Vtiger Report");
		reporter.config().setReportName("Execution Document ");
		reporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Url", "http://localhost:8888");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("TestEnginneeer", "Ali Sir");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		
		
		
	}
	
	
	

}
