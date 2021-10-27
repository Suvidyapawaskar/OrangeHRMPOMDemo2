package com.orangehrm.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.orangehrm.pages.Homepage;
import com.orangehrm.pages.Loginpage;
import com.orangehrm.utility.CloseBrowser;

public class Login
{
	@Parameters({"usernm","passwd","timeoutsec2"})
	@Test
	public void executeLogin(String username,String password,int timeoutsec) throws InterruptedException  
	{
		Loginpage lg= new Loginpage();
		lg.loadLoginpage();
		lg.enterUsername(username);
		lg.enterPassword(password);
		lg.clickonLogin();
		
		Homepage hm= new Homepage();
		hm.loadHomepage();
		hm.clickonWelcome();
		hm.waittillLogout(15);
		hm.clickonLogout();
		
		CloseBrowser cb= new CloseBrowser();
		cb.closeBr();
	}
	

}
