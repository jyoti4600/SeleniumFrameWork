package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase 
{
   @FindBy(xpath="//a[@class='userProfileLink username']")
   WebElement userNameLabel;
   
   @FindBy(xpath="//div[@id=\"container_tasks\"]")
   WebElement tasksLink;
   
   @FindBy(xpath="//div[@id=\"container_reports\"]")
   WebElement reportsLink;
   
   @FindBy(xpath="//div[@id=\"container_users\"]")
   WebElement usersLink;
   
   public HomePage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public String verifyHomePageTitle()
   {
	   return driver.getTitle();
   }
   
   public boolean verifyCorrectUserName()
   {
	 return userNameLabel.isDisplayed();
   }
   
   
   // clickOnTasksLink()  method return TasksPage so created object and all remaing method are same like this.
   public TasksPage clickOnTasksLink() 
   	{
   		tasksLink.click();
   	    return new TasksPage();
   	}
   	public ReportPage clickOnReportLink()
   	{
   		reportsLink.click();
   	    return new ReportPage();
   	}
   	public UserPage clickOnUserLink()
   	{
   		usersLink.click();
   	    return new UserPage();
   	}
   	
   	
   	
   	
   	
   
   
}  