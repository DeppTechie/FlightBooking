import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;



public class Testclick {

	
	 static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			i_launch_the_shopping_page();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void i_launch_the_shopping_page() throws Throwable {
			
			System.setProperty("webdriver.chrome.driver", "/Users/satyadeep/Downloads/chromedriver");
	    	driver = new ChromeDriver();
	    	driver.manage().deleteAllCookies();
	    	driver.get("http://automationpractice.com/index.php");
	    	
	    	System.out.println("User Has Launched the Home Portal-1");
	    
	    	driver.manage().window().maximize();
	    	
	    	WebElement a= driver.findElement(By.xpath("//div/a/img[@alt='Faded Short Sleeve T-shirts']"));
	    	System.out.println("User Has Launched the Home Portal-2");
	    Actions action = new Actions(driver);
	    action.moveToElement(a).perform();
	    Thread.sleep(300);
	    driver.findElement(By.xpath("//div/a[@class='button ajax_add_to_cart_button btn btn-default']")).click();
	     
	    
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    
	    WebElement continueshopping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-container']/span[@class='continue btn btn-default button exclusive-medium']")));
	    continueshopping.click();
	    
	        
	    WebElement a1= driver.findElement(By.xpath("//div/a/img[@alt='Printed Dress']"));
	    System.out.println("User Has Launched the Home Portal-3");
	    Actions action1 = new Actions(driver);
	    action1.moveToElement(a1).perform();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@data-id-product='3']")).click();
	    
	
	   	 //Review Order Page
	   WebDriverWait wait1 = new WebDriverWait(driver,10);
	    WebElement checkout = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Proceed to checkout']")));
	    checkout.click();
	    
	   
	    driver.findElement(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']")).click();
	    
	   //EmailID Page 
	    
	    
	    driver.findElement(By.id("email_create")).sendKeys("Test76778668611@gmail.com");
	    driver.findElement(By.id("SubmitCreate")).click();
	    
	    //Personal Info Page
	   
	    WebDriverWait wait2 = new WebDriverWait(driver,10);
	    
	    WebElement  maleRadioBtn = wait2.until(ExpectedConditions.elementToBeClickable (By.id("id_gender1")));

	    maleRadioBtn.click();
	    
	    
	    driver.findElement(By.id("customer_firstname")).sendKeys("TestFName");
	    driver.findElement(By.id("customer_lastname")).sendKeys("TestLName");
	    driver.findElement(By.id("passwd")).sendKeys("Sydney@123");
	    driver.findElement(By.id("firstname")).sendKeys("FName");
	    driver.findElement(By.id("lastname")).sendKeys("LName");
	    driver.findElement(By.id("address1")).sendKeys("16/20 Vic Rd");
	    driver.findElement(By.id("city")).sendKeys("Parramatta");
	    Select dropdown= new Select(driver.findElement(By.id("id_state")));
	    dropdown.selectByIndex(2);
	    driver.findElement(By.id("postcode")).sendKeys("21501");
	    driver.findElement(By.id("phone_mobile")).sendKeys("0567653314");
	    driver.findElement(By.id("alias")).sendKeys("Vic Rd");
	    driver.findElement(By.id("submitAccount")).click();
	    
	    // ADDRESS PAGE
	    
	    driver.findElement(By.xpath("//*[@name='processAddress']")).click();
	    
//SHIPPING PAGE
	    driver.findElement(By.id("cgv")).click();
	   
	    driver.findElement(By.xpath("//*[@name='processCarrier']")).click();
	    
	   //PAYMENT PAGE	    
	    driver.findElement(By.className("bankwire")).click();
	    
	    //ORDER SUMMARY
	    
	    driver.findElement(By.xpath("//*[@class='button btn btn-default button-medium']")).click();
	    
	}



}
