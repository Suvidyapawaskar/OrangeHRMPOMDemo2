package com.orangehrm.utility;

import com.orangehrm.config.Config;

public class CloseBrowser 
{
	public void closeBr()
	{
		Config.driver.close();
	}

}
