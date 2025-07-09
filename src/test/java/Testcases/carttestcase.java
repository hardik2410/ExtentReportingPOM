package Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extbase.extbase;
import pages.extcartpage;
import pages.extdashboard;
import pages.extloginpage;

public class carttestcase extends extbase{
	extloginpage lp;
	extdashboard dp;
	extcartpage cp;
	
	@BeforeTest
	public void settingup()
	{
		initialisation();
		initializeExtent();
		lp=new extloginpage();
		dp=new extdashboard();
		cp=new extcartpage();
		test = extent.createTest("Login Test");
		lp.loggingin();
		dp.dashboarddd();
	}
	
	@Test
	public void cartcases() throws InterruptedException
	{
		cp.validatinginventory();
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}

}
