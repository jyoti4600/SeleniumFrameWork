
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

// global variable
public	static WebDriver driver;
public	static Properties prop;       
	
//1	creating constructor of class - reading the properties and initializing the variable
	public TestBase()
	{
		try {
			
			FileInputStream ip =new FileInputStream("D:\\Eclipes\\Workspace\\FrreCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	// 
	public static void initialization()
	{
	   String browserName = prop.getProperty("browser");	
	   if(browserName.equals("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver","D:/Eclipes/Seleniumproject/chromedriver.exe");
		   driver= new ChromeDriver();
	   }
	   else	if(browserName.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver","D:/Eclipes/Seleniumproject/chromedriver.exe");
		        driver= new FirefoxDriver();
		    }
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   // TestUtil is class from from TestUtil.java class- not giving direct value
	   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	   driver.get(prop.getProperty("url"));
	}

}
