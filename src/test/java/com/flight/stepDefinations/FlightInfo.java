package com.flight.stepDefinations;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flight.dataProvider.ConfigFileReader;
import com.flight.helper.LoggerHelper;
import com.flight.pageObjects.FlightObject;

import java.util.*;
import java.util.Calendar;


@RunWith(Cucumber.class)

public class FlightInfo extends FlightObject {
	
	WebDriver driver ;	
	ConfigFileReader configFileReader= new ConfigFileReader();
	//int counter=0;
	JavascriptExecutor jse;// = (JavascriptExecutor)driver;
	WebDriverWait wait1;// = new WebDriverWait(driver,10);
	
	public FlightInfo() {
		System.setProperty ("webdriver.chrome.driver", configFileReader.getValue("driverPath"));
		driver = new ChromeDriver();  	
		jse = (JavascriptExecutor)driver;
		wait1 = new WebDriverWait(driver,10);
		
		
	}
	
	@Given("^I launch the Qantas Website for an user$")
    public void i_launch_the_qantas_website_for_an_user() throws Throwable {
		System.out.println("Hello WORLD");
    	//for(int i=0;i<=4;i++) {
    	//	counter=i;
    		System.setProperty ("webdriver.chrome.driver", configFileReader.getValue("driverPath"));
    		
    		//driver = new ChromeDriver();  	
        	driver.get(configFileReader.getValue("url"));
        	driver.manage().window().maximize();
        	driver.manage().deleteAllCookies();
        	System.out.println("Website Launched");
        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	//}
    }  
    
    @And("^I choose the right destination$")
    public void i_choose_the_right_destination() throws Throwable {
 //	LoggerHelper.getLogger(LoggerHelper.class);
    	
    	jse.executeScript("window.scrollBy(0,250)");
    	driver.findElement(Destination).click();
    	driver.findElement(Destination).sendKeys("Brisb");
    	driver.findElement(Destination).sendKeys(Keys.ENTER);
 
//--------CLICK ONE WAY-------------
    	WebElement w= driver.findElement(JourneyType);
    	jse.executeScript("arguments[0].click();", w);	
    	
    }	

        @And("^I choose the right dates$")
        public void i_choose_the_right_dates() throws Throwable {
    	
  WebElement datepicker =  driver.findElement(MyCalendar); 
  datepicker.click(); 
  Thread.sleep(5000);
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	System.out.println("Current Date: "+sdf.format(cal.getTime()));
	//Adding 15 Day to the current date
	cal.add(Calendar.DAY_OF_MONTH, 15);  
	//Get date part
	int datepart = cal.get(Calendar.DATE);
	List<WebElement> elementName = driver.findElements(By.xpath(".//span[text()='"+datepart+"']"));
	   elementName.get(0).click();    		
    	WebElement button = driver.findElement(By.xpath("//button[contains(text(),'SEARCH FLIGHTS')]"));   
    	button.click();	
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	
    	try {
    	driver.switchTo().alert().dismiss();
    	} catch (Exception e) {}
    	
        }
 	
    		@Then("^I do initial price check$")
    	    public void i_do_initial_price_check() throws Throwable {	
    		  // Cart Total before adding  		
    	System.out.println(driver.findElement(WidgetAmtBeforeAdding).getText());
    	
    		}
    	
    		@Then("^I add the favorite Red Deal$")
    	    public void i_add_the_favorite_red_deal() throws Throwable {
    	// Add the Red e-Deal 
    			Thread.sleep(10000);
    	    	jse.executeScript("window.scrollBy(0,750)");  	
driver.findElement
(AddRedDeal).click();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

driver.findElement(AddTrip).click();
    		}

@Then("^I do the Update Price Check$")
public void i_do_the_update_price_check() throws Throwable {
//Check the new Price
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
System.out.println(driver.findElement(TotalDealCost).getText());
System.out.println(driver.findElement(TotalFinalCost).getText());
// Click On Continue
driver.findElement(FirstContinue).click();

//WebElement element=new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-continue")));
Thread.sleep(8000);
WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(SecondContinue));
if (element.isEnabled()) {
	element.click();
}
// Accept the Fare Conditions

Thread.sleep(3000);

driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
driver.findElement(AcceptFareTerms).click();
}
//Addition of bags
@Then("^I Add Luggage based on number of (.+)$")
public void i_add_luggage_based_on_number_of(String users) throws Throwable {

Thread.sleep(1000);

WebElement element1 = driver.findElement(ScrollDown);
jse.executeScript("arguments[0].scrollIntoView();",element1);

driver.findElement(BaggingOptions).click();

//Incrementing the Bag Count
Thread.sleep(2000);
    		
	WebElement rightButton= driver.findElement(AddLuggage);
	int userCount = Integer.parseInt(users);
	 for (int j=1;j<=userCount;j++) {
	rightButton.click();	 
	 }
 driver.quit();	
    } 


}
	
