package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extbase.extbase;

public class extcartpage extends extbase{
	
	@FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x")
	WebElement carticon;
	
	@FindBy(className="inventory_item_name")
	WebElement inventory;
	
	@FindBy(xpath="//a[normalize-space()='CHECKOUT']")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement fname;
	
	public extcartpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validatinginventory() throws InterruptedException
	{
		Thread.sleep(2000);
		carticon.click();
		
		if(inventory.isDisplayed())
		{
			String itemname=inventory.getText();
			System.out.println("Item exist in the inventory " +itemname);
			test.pass("Item added in the inventory");
			
		}
		else
		{
			System.out.println("Item is not added in the cart");
			test.pass("Item notfound in the inventory");
		}
		
		checkout.click();
		
		if(fname.isDisplayed())
		{
			test.pass("First name detected :: Able to navigate to checkout page");
		}
		else
		{
			test.fail("Failed somewhere above");
		}
		
	}

}
