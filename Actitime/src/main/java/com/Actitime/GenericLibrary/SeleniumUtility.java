package com.Actitime.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtility {
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void navigateToUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();	
		
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
		
	}

	public void selectOptionByValue(WebElement element, String value) {		
		Select s = new Select(element);
		s.selectByValue(value);
				
	}
	
	public void selectOptionByVisibleText(WebElement element, String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	
	

}
