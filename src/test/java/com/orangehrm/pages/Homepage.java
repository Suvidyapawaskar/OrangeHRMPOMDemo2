package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.config.Config;
import com.orangehrm.utility.LaunchApp;

public class Homepage 
{
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
	WebElement objWelcome;
	
	@FindBy(how=How.LINK_TEXT,using="Logout")
	WebElement objLogout;
	
	public void loadHomepage()
	{
		System.out.println("In loadHomepage method");
		PageFactory.initElements(Config.driver, this);
	}

	public void clickonWelcome() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("In clickonWelcome method under Homepage");
		objWelcome.click();
	}
	
	public void waittillLogout(int timeoutsec)
	{
		System.out.println("In waitLogout method under Homepage");
		WebDriverWait wait= new WebDriverWait(Config.driver,timeoutsec);
		wait.until(ExpectedConditions.visibilityOf(objLogout));
	}
	
	public void clickonLogout()
	{
		System.out.println("In clickonLogout method under Homepage");
		objLogout.click();
		System.out.println("User has logged out from Homepage successfully");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.enterApplicationURL();
		lc.maximizeBrowser();
		lc.waittillLoginpageLoaded(15);
		
		Loginpage lg= new Loginpage();
		lg.loadLoginpage();
		lg.enterUsername("Admin");
		lg.enterPassword("admin123");
		lg.clickonLogin();
		
		Homepage hm= new Homepage();
		hm.loadHomepage();
		hm.clickonWelcome();
		hm.waittillLogout(15);
		hm.clickonLogout();
		
		
	}
	
}
