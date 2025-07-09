package extbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extbase {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
    public static ExtentTest test;
	
	
	public extbase()
	{
		prop = new Properties(); 
		try {
			FileInputStream ip= new FileInputStream("D:\\Selenium\\ExtentreportinPOM\\src\\main\\java\\creds\\creds.txt");
			prop.load(ip);
		
			
		} catch(FileNotFoundException e)
		 {
				e.printStackTrace();
		 }
		catch(IOException e)
		{
			e.printStackTrace();
		}				
		
	}
	
	public static void initializeExtent() {
	    extent = new ExtentReports();
	    ExtentSparkReporter spark = new ExtentSparkReporter("D:\\reports\\Spark.html");
	    extent.attachReporter(spark);
	}
	
	public void initialisation()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--Incognito");
			driver=new ChromeDriver(opt);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
	}
	
	
	// Most probably I'll delete this code
	public String captureScreenshot(String stepName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    String path = "D:\\reports\\screenshots\\" + stepName + ".png";

	    try {
	        File dest = new File(path);
	        dest.getParentFile().mkdirs(); // Create folder if it doesn't exist
	        Files.copy(src.toPath(), dest.toPath());
	        return path;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
