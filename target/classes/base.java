package resources;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties pro;

	public WebDriver intializeDriver() throws IOException {
	    pro = new Properties();
	    
	    // System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		pro.load(fis);
		
		
        //through  data property 
	String browserName = pro.getProperty("browser");

		
		// through mvn command select browser
	//	String browserName =System.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "‪‪D:\\selenium\\New folder\\95\\chromedriver.exe");
			
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver","D:\\selenium\\New folder\\firefoxDriver\\geckodriver.exe");
			driver= new FirefoxDriver();	
			
			
			// firefox code
		}

		else if (browserName.equals("IE")) {
   
			// IE code
			
			System.setProperty("webdriver.ie.driver","D:\\selenium\\New folder\\internetexplorer\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); 
		String destinationFile =  System.getProperty("user.dir")+"\\report\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
}
