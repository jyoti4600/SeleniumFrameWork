package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

// 3 to do -Login page class child of TestBase class so extends  - all page classes are child of TestBase class 
public class LoginPage extends TestBase
{
	// defining or declaration elements- page factory -OR (object repository): it uses @FindBy annotation

    @FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//a[@id='loginButton']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//div[@class='atLogoImg']")
	WebElement crmLogo;

	// initialise the Page object (elements)
	// how will you intialize your pagefactory by using initElement(). above all variables initailize with driver..
	// "this" keyword is current class object-its pointing to current class object/ we can write class name also.
	// create constructor for this class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions:differnt feature of login page - Utilization here
	public String ValidateLoginPage()
	{
		return driver.getTitle();
	}
	public boolean ValidatePageImage()
	{
		return crmLogo.isDisplayed();
	}
	
	// this method is returning home page
	public HomePage login(String un, String pw) throws InterruptedException
	{
		username.sendKeys(un);
		Thread.sleep(1000);
		password.sendKeys(pw);
		Thread.sleep(1000);
		LoginBtn.click();
		Thread.sleep(2000);
		return new HomePage();
	}
}
	