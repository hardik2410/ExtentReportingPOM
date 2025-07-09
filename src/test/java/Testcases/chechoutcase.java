package Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extbase.extbase;
import pages.extcartpage;
import pages.extcheckout;
import pages.extdashboard;
import pages.extloginpage;

public class chechoutcase extends extbase{
	extloginpage lp;
	extdashboard db;
	extcartpage cp;
	extcheckout co;
	
	@BeforeTest
	public void settingup() throws InterruptedException
	{
		initialisation();
		initializeExtent(); 
		lp=new extloginpage();
		db=new extdashboard();
		cp=new extcartpage();
		co=new extcheckout();
		test = extent.createTest("Login Test");
		lp.loggingin();
		db.dashboarddd();
		cp.validatinginventory();
	}
	
	@Test
	public void checkingout()
	{
		co.checkingout();
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}

}
