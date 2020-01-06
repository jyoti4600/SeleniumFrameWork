package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage; 
	
	// call super keyword-will come inside class and will call "super class constructor(testbase class)" and will come setup method
	public LoginPageTest()
	{
		super();
	}
	// super will come to setup method and initialize- before come it should call super class.
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(groups= {"Smoke"})
	public void loginPageTitleTest() throws InterruptedException
	{
		String title = loginPage.ValidateLoginPage();
		Assert.assertEquals(title,"actiTIME - Login");
	    Thread.sleep(2000);
	}
	@Test(groups= {"smoke"})
	public void crmLogoImageTest() throws InterruptedException
	{
		    
		 boolean flag = loginPage.ValidatePageImage();
		 Assert.assertTrue(flag); 
		 Thread.sleep(2000);
	}
	
	@Test(groups= {"Functiona"})	
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(2000);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
		
	

    
}

