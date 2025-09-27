package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.GenericLibrary.SeleniumUtility;

public class OrganizationPage {
	
	// Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusicon;
	
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(name = "industry")
	private WebElement industry;
	
	@FindBy(name = "accounttype")
	private WebElement typeaddress;
	
	@FindBy (name = "assigntype")
	private WebElement typeassign;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@value = '  Cancel  ']")
	private WebElement cancelbtn;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	//business logic
	
	public WebElement getPlusicon() {
		return plusicon;
	}



	public WebElement getOrgname() {
		return orgname;
	}



	public WebElement getIndustry() {
		return industry;
	}



	public WebElement getTypeaddress() {
		return typeaddress;
	}



	public WebElement getTypeassign() {
		return typeassign;
	}



	public WebElement getSavebtn() {
		return savebtn;
	}



	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	// business logic

	public void createOrg(WebDriver driver, String name, String value) {
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getPlusicon().click();
		op.getOrgname().sendKeys(name);
		WebElement address1 = op.getIndustry();
		SeleniumUtility sutil = new SeleniumUtility();
		sutil.selectOptionByValue(address1, value);
		
		
		
		
		
	}
	
	
	
	
	

}
