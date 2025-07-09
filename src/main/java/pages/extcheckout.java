package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extbase.extbase;

public class extcheckout extends extbase{
	@FindBy(id="first-name")
	WebElement fname;
	
	@FindBy(id="last-name")
	WebElement lname;
	
	@FindBy(id="postal-code")
	WebElement postcode;
	
	@FindBy(xpath="//input[@type='submit' and @value='CONTINUE']")
	WebElement continuebutton;
	
	
	@FindBy(xpath="//a[normalize-space()='FINISH']")
	WebElement finishbutton;
	
	
	public extcheckout()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkingout()
	{
		
		fname.sendKeys(prop.getProperty("fname"));
		test.pass("Entered First Name");
		lname.sendKeys(prop.getProperty("lname"));
		test.pass("Entered Last Name");
		postcode.sendKeys("47075");
		test.pass("Entered Zip Number");
		
		
		continuebutton.click();
		finishbutton.click();
	}

}
