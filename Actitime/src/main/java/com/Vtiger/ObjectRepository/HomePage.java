package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.GenericLibrary.SeleniumUtility;

public class HomePage {
	
	// Declaration
	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement imgaddress;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgelement;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactelement;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunnitiesElement;
	
	
	// Initialization
	public HomePage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);		
		
	}
	
	
	// Utilization
	public WebElement getImgaddress() {
		return imgaddress;
	}

	public WebElement getSignout() {
		return signout;
	}	
	
	public WebElement getOrgelement() {
		return orgelement;
	}

	public WebElement getContactelement() {
		return contactelement;
	}

	public WebElement getOpportunnitiesElement() {
		return opportunnitiesElement;
	}
	
	

	// Business Logic	
	public void logout(WebDriver driver) {
		
		HomePage hp = new HomePage(driver);
		WebElement element = hp.getImgaddress();
		SeleniumUtility s = new SeleniumUtility();
		s.mouseHover(driver, element);
		hp.getSignout().click();
		
		
	}
	
	public void clickOnOrganization(WebDriver driver) {
		
		HomePage hp = new HomePage(driver);
		hp.orgelement.click();
		
		
		
	}
	
	
	
	
	
	

}
