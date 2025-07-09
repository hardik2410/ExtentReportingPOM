package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import extbase.extbase;

public class extdashboard extends extbase{
	@FindBy(className="product_sort_container")
	WebElement dropdown;
	
	@FindBy(xpath="(//button[normalize-space()='ADD TO CART'])[3]")
	WebElement addtocart;
	
	public extdashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void dashboarddd()
	{
		String expectedTitle="Swag Labs";
		String actualTitle=driver.getTitle();		
		Assert.assertEquals(actualTitle, expectedTitle);
		test.pass("Navigated to dashboard successfully");
		
		
		
		Select sel=new Select(dropdown);
		sel.selectByValue("za");
		
		addtocart.click();
		test.info("clicked on add to cart button");
		
	}

}
