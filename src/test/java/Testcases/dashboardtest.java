package Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extbase.extbase;
import pages.extdashboard;
import pages.extloginpage;

public class dashboardtest extends extbase{
	extloginpage lp;
	extdashboard dp;
	
	@BeforeTest
	public void settingup()
	{
		initializeExtent();
		initialisation();
		lp=new extloginpage();
		dp=new extdashboard();
		
		test = extent.createTest("Login Test");
		lp.loggingin();
	}
	
	
	@Test
	public void dashboard()
	{
		dp.dashboarddd();
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}

}
