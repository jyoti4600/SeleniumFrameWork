package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// ctrl shift o - import short cut key

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ReportPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.pages.UserPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TasksPage taskPage;
	ReportPage reportPage;
	UserPage userPage;
	
     public HomePageTest()
     {
    	 super();
     }
     
    @BeforeMethod
 	public void setUp() throws InterruptedException
 	{
 		initialization();
 		loginPage = new LoginPage();
 		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
 	}
    
    @Test(groups= {"smoke"})
    public void verifyHomePageTitleTest() throws InterruptedException
    {
    	String homePageTitle = homePage.verifyHomePageTitle();
    	Assert.assertEquals(homePageTitle,"actiTIME - Enter Time-Track","Home page title not matched");
    	Thread.sleep(2000);
     }
    
    @Test(groups= {"smoke"})
    public void verifyUserNameTest() throws InterruptedException
    {
    	Assert.assertTrue(homePage.verifyCorrectUserName());
    	Thread.sleep(2000);
    }
    
    @Test(groups= {"functional"})
    public void TasksPage() throws InterruptedException
    {
    	taskPage = homePage.clickOnTasksLink();	
    	Thread.sleep(1000);
    }
    
    @Test(groups= {"functional"})
    public void ReportPage() throws InterruptedException
    {
    	reportPage = homePage.clickOnReportLink();
    	Thread.sleep(1000);
    }
    
    @Test(groups= {"functional"})
    public void UserPage() throws InterruptedException
    {
    	userPage =homePage.clickOnUserLink();
    	Thread.sleep(1000);
    }
    
    @AfterMethod()
    public void tearDown()
    {
    	driver.quit();
    }
    
    
     
     
   
        



}



