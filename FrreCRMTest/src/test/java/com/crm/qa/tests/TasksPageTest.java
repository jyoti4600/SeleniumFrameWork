package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class TasksPageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	TasksPage taskPage;
	
	public TasksPageTest()
    {
   	 super();
    }
	
	@BeforeMethod
 	public void setUp() throws InterruptedException
 	{
 		initialization();
 		loginPage = new LoginPage();
 		taskPage = new TasksPage();
 		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
 		taskPage = homePage.clickOnTasksLink();
 	}
	
	@Test(groups= {"smoke"})
	public void verifyTasksPage() throws InterruptedException
	{
		Assert.assertTrue(taskPage.verifyTasksLabel(),"Task lable is missing");
		Thread.sleep(1000);
	}
	
	@Test(groups= {"functional"})
	public void selectTasksTest() throws InterruptedException
	{
	   taskPage.selectTasksByName("select multiple tasks for bulk actions");	
	   Thread.sleep(1000);
	}
	
	 @AfterMethod()
	 public void tearDown()
	 {
	    	driver.quit();
	 }
	    
}
