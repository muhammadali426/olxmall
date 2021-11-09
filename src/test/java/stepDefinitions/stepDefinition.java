package stepDefinitions;





import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.base;

public class stepDefinition extends base  {

	
	@Given("^Navigate to\"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = intializeDriver();	
		driver.get(arg1);
	}
	
	

	@Given("^Navigate to All Categories -> Mobiles & Tablets -> Mobiles$")
	public void navigate_to_All() throws Throwable {
	   
		driver.findElement(By.xpath("//img[@alt='Dropdown arrow']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Mobiles']")).click();
		
	}

	@When("^Filter Listings by PRICE between (\\d+) - (\\d+)$")
	public void filterPRICE(int arg1, int arg2) throws Throwable {
	   	

		 
	
		
		Thread.sleep(3000);
		

		driver.findElement(By.xpath("//input[@placeholder='Min']")).sendKeys(Keys.ARROW_LEFT);
		
			
		driver.findElement(By.xpath("//input[@placeholder='Min']")).sendKeys(""+arg1);
		
		
	    
		
		Thread.sleep(3000);
		
		String value =driver.findElement(By.xpath("//input[@placeholder='Max']")).getText();
		
		
		
		
		
	
		
    	
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(""+arg2);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).click();
		
		
	
	}

	@Then("^Validate the first ten results to ensure search results that they are from Mobile category and in given price range$")
	public void validate_the_first_ten_results() throws Throwable {
	   
	List<Integer> prices = new ArrayList<>();
	
		
	String category =	driver.findElement(By.xpath("//h1[@class='_888f7099']")).getText();
	
	
	assertEquals(category,"Mobiles");
		
	for (int i=1;i<=6;i++ ) {
		
		String prices1 =driver.findElement(By.xpath("//*[@id='body-wrapper']/div[1]/div[3]/div[2]/div[2]/div/ul/li["+i+"]/article/div[3]/div[3]/div[1]/span")).getText();
		
	    String prices2= prices1.substring(3);
	   
	    String prices3 = prices2.replace(",", "");
	    
	    
	    
		int intPrices = Integer.valueOf(prices3);
		
		
        prices.add(intPrices);
    }
	

	for (int i=8;i<=11;i++ ) {
        
		
		String prices1 =driver.findElement(By.xpath("//*[@id='body-wrapper']/div[1]/div[3]/div[2]/div[2]/div/ul/li["+i+"]/article/div[3]/div[2]/div[1]/span")).getText();
    
			
		String prices2= prices1.substring(3);
		      
    String prices3 = prices2.replace(",", "");
    
    
	int intPrices = Integer.valueOf(prices3);
	
		
	prices.add(intPrices);
	}
	
	for(int i=0;i<prices.size();i++)
	{
		System.out.println(prices.get(i));
		

		assertTrue(prices.get(i) >= 40000 && prices.get(i) <= 120000);
		
	}
	
	
	
	
	}

	@Then("^Please note that the to validate the category you will need to 'visit' the details page by tapping on the result$")
	public void validate_the_category() throws Throwable {
	
	    
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id='body-wrapper']/div[1]/div[3]/div[2]/div[2]/div/ul/li[1]/article"))).click();
		
		
	}
	
	
}
