package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase
{
	 @FindBy(xpath="//span[text()='Task']")
	 WebElement taskNameLabel;
	 
	 public TasksPage()
	   {
		   PageFactory.initElements(driver, this);
	   }
	 
	 public boolean verifyTasksLabel()
	 {
		 return taskNameLabel.isDisplayed();
      }
	 
	 public void selectTasksByName(String task)
	 {
		 driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div")).click();
	 }
	 
	 

}
