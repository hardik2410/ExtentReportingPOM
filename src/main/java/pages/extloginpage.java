package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extbase.extbase;

public class extloginpage extends extbase{
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	
	public extloginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loggingin()
	{
		username.sendKeys(prop.getProperty("uname"));
		test.info("Entered username").addScreenCaptureFromPath(captureScreenshot("step1_enter_username"));;
		password.sendKeys(prop.getProperty("password"));
		test.info("Entered password").addScreenCaptureFromPath(captureScreenshot("step2_enter_password"));
		loginbutton.click();
		test.info("Clicked login button");
		

	}

}
