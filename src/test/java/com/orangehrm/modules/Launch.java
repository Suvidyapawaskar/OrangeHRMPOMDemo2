package com.orangehrm.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.utility.LaunchApp;

public class Launch 
{
	@Parameters({"browser","timeoutsec1"})
	@Test
	public void executeLaunch(String browsernm, int timeout) throws IOException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser(browsernm);
		lc.enterApplicationURL();
		lc.maximizeBrowser();
		lc.waittillLoginpageLoaded(timeout);		
		
		
		
	}

}
