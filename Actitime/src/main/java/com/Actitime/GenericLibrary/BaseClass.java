package com.Actitime.GenericLibrary;


import java.io.IOException;
import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Vtiger.ObjectRepository.HomePage;
import com.Vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	SeleniumUtility sutil = new SeleniumUtility();
	FileUtils f = new FileUtils();
	
	
	
	@BeforeSuite
	public void databaseConnection() {		
		System.out.println("Connected to database Successfully");		
	}
	
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver = new ChromeDriver();
		sutil.maximizeBrowser(driver);
		sutil.implicitWait(driver);
		
		
		String URL = f.readDataFromProperty("url");		
		sutil.navigateToUrl(driver, URL);
		
		Reporter.log("Browser Launched Successfully", true);
		
		
		
	}
	
	@BeforeMethod
	public void loginToVtiger() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String un = f.readDataFromProperty("username");
		String pw = f.readDataFromProperty("password");
		
		lp.login(driver, un, pw);
		Reporter.log("logged in Successfully", true);
		
		
		
		
	}
	
	@AfterMethod
	public void logoutFromVtiger() {
		
		HomePage hp = new HomePage(driver);		
		hp.logout(driver);		
		Reporter.log("logged out successfully", true);
		
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		sutil.closeBrowser(driver);
		Reporter.log("browser closed successfully", true);
		
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected", true);
	}
	
	
	
	
	
	
	
	

}
