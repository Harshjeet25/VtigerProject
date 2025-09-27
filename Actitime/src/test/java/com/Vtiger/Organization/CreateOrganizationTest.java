package com.Vtiger.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileUtils;
import com.Actitime.GenericLibrary.JavaUtility;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Vtiger.ObjectRepository.HomePage;
import com.Vtiger.ObjectRepository.OrganizationPage;

@Listeners(ListenerImplementation.class)

public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization(driver);
		OrganizationPage op = new OrganizationPage(driver);
		FileUtils f = new FileUtils();
		
		JavaUtility jutil = new JavaUtility();
		int ran = jutil.getRandom(25);
		
		String name = f.readDataFromExcel("Sheet1", 1, 1);
		op.createOrg(driver, name+" "+ran, "Engineering");
		
		Thread.sleep(5000);
				
	}
	
	@Test
	public void intentionalFail() {
		Assert.fail();
	}
	
	
	

}
