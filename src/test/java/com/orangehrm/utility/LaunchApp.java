package com.orangehrm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.orangehrm.config.Config;

public class LaunchApp 
{
	Properties prop= new Properties();
	public void openBrowser(String browsernm) throws IOException
	{
		FileInputStream fis = new FileInputStream("F:\\Suvidya_data\\Java_Selenium\\OrangeHRMPOMDemo1\\src\\test\\resources\\config.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.out.println("In chrome browser");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeexepath"));
			Config.driver = new ChromeDriver();
			System.out.println("Chrome browser is opened succesfully");
			
		}else if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.out.println("In IE browser");
			System.setProperty("webdriver.ie.driver",prop.getProperty("ieexepath"));
			Config.driver= new InternetExplorerDriver();
			System.out.println("IE browser is opended successfully");
			
		}else
		{
			System.out.println("In Firefox browser");
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxexepath"));
			Config.driver = new FirefoxDriver();
			System.out.println("Firefox browser is opened successfully");
		}
	}
	
	public void enterApplicationURL()
	{
		System.out.println("In enterApplicationURL method");
		Config.driver.get(prop.getProperty("url"));
		System.out.println("Application URL is entered successfully");
	}
	
	public void waittillLoginpageLoaded(int timeout)
	{
		System.out.println("In waittillLoginpageLoaded method");
		Config.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
	}
	
	public void maximizeBrowser()
	{
		System.out.println("In maximizeBrowser method");
		Config.driver.manage().window().maximize();
	}
	
	public static void main(String[] args) throws IOException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.enterApplicationURL();
		lc.waittillLoginpageLoaded(15);
		lc.maximizeBrowser();
		
	}
	
	

}
