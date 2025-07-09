package Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extbase.extbase;
import pages.extloginpage;

public class logintestcase extends extbase{
	extloginpage lp;
	
	
	@BeforeTest
	public void settingup()
	{
		initializeExtent();
		initialisation();
		lp=new extloginpage();
		test = extent.createTest("Login Test");
	}
	
	@Test
	public  void loggingin()
	{
		
		lp.loggingin();
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		if(ActualTitle.equalsIgnoreCase(ExpectedTitle))
		{
			
			test.pass("You have landed on the correct page "+ActualTitle);
		}
		else
		{
			test.fail("You have landed on incorrect page");
		}
				
	}
	@AfterTest
	public void teardown()
	{
	  extent.flush();	
	}

}
