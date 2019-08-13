package com.flight.implementation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flight.coreframework.CoreActions;
import com.flight.dataProvider.ConfigFileReader;
import com.flight.helper.LoggerHelper;
import com.flight.pageObjects.FlightObject;
import com.flight.stepDefinations.FlightInfo2;

public class flightImplementation extends FlightObject{
	public static final Logger LOG = LoggerHelper.getLogger(flightImplementation.class);
	
	CoreActions coreActions = new CoreActions();

//	WebDriverWait wait = new WebDriverWait(CoreActions.getWebDriver(), 20);
	
/*	public static final Logger LOG = LoggerHelper.getLogger(FlightInfo2.class);
	public static WebDriver driver ;	
	public static ConfigFileReader configFileReader= new ConfigFileReader();
	//int counter=0;
	public static JavascriptExecutor jse;// = (JavascriptExecutor)driver;
	public static WebDriverWait wait1;// = new WebDriverWait(driver,10);*/


	
public void launchQantasSite() {
	
	System.setProperty ("webdriver.chrome.driver", CoreActions.configFileReader.getValue("driverPath"));
	CoreActions.getWebDriver().get(ConfigFileReader.getValue("url"));
	CoreActions.getWebDriver().manage().window().maximize();
	CoreActions.getWebDriver().manage().deleteAllCookies();
	System.out.println("Website Launched");
	CoreActions.getWebDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	
}

public void ChooseDestination() {
	CoreActions.jse.executeScript("window.scrollBy(0,250)");
	CoreActions.getWebDriver().findElement(Destination).click();
    CoreActions.getWebDriver().findElement(Destination).sendKeys("Brisb");
	CoreActions.getWebDriver().findElement(Destination).sendKeys(Keys.ENTER);

	//--------CLICK ONE WAY-------------
	WebElement w= CoreActions.getWebDriver().findElement(JourneyType);      
	CoreActions.jse.executeScript("arguments[0].click();", w);	
}
public void ChooseDates ()

{
	WebElement datepicker =  CoreActions.getWebDriver().findElement(MyCalendar); 
	datepicker.click(); 
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	


		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	int currentMonth = cal.get(Calendar.MONTH);
	System.out.println("Current Date: "+sdf.format(cal.getTime()));
	//Adding 15 Day to the current date
	cal.add(Calendar.DAY_OF_MONTH, 15);  
	//Get date part
	int datepart = cal.get(Calendar.DATE);
	List<WebElement> elementName = CoreActions.getWebDriver().findElements(By.xpath(".//span[text()='"+datepart+"']"));
	elementName.get(cal.get(Calendar.MONTH)-currentMonth).click();    		
	
	
WebElement button = CoreActions.getWebDriver().findElement(By.xpath("//button[contains(text(),'SEARCH FLIGHTS')]"));   
	
	button.click();	
	
	CoreActions.getWebDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	

}

public void InitialCartValue()

{try{
	
	Assert.assertEquals("$0", CoreActions.driver.findElement(WidgetAmtBeforeAdding).getText());
//	Assert.assertEquals("$0", WidgetAmtBeforeAdding);
	LOG.info("Everything Looks good till Pre-selction");
}catch(AssertionError e)
{
	LOG.info("Sorry!! Cart not Empty,Please check");
}
}

public void AddDeal()
{	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	CoreActions.jse.executeScript("window.scrollBy(0,750)");  	
	CoreActions.getWebDriver().findElement
	(AddRedDeal).click();
	CoreActions.getWebDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	WebElement Deal = new WebDriverWait(CoreActions.getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(AddTrip));
	//CoreActions.getWebDriver().findElement(AddTrip).click();
	Deal.click();
}

public void NewPriceCheck()

{
	//Check the new Price
			CoreActions.getWebDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
			try{
				Assert.assertEquals(CoreActions.getWebDriver().findElement(TotalDealCost).getText().trim(),
						(CoreActions.getWebDriver().findElement(TotalFinalCost).getText().trim()));
				LOG.info("DEALS LOOK CORRECT");
				}
				catch (AssertionError e)
				{ LOG.info("Updated Prices Donot Match-Please check again!!");
				
				} 
		
			CoreActions.getWebDriver().findElement(FirstContinue).click();

			//WebElement element=new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-continue")));
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
//WebElement elementSecond = CoreActions.wait1.until(ExpectedConditions.presenceOfElementLocated(SecondContinue));	

			
WebElement element = CoreActions.wait1.until(ExpectedConditions.elementToBeClickable(SecondContinue));
			if (element.isEnabled()) {
				element.click();
			}
			// Accept the Fare Conditions
		
			
			WebElement Accept = CoreActions.wait1.until(ExpectedConditions.elementToBeClickable(AcceptFareTerms));
			Accept.click();
		//	CoreActions.getWebDriver().manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//	CoreActions.getWebDriver().findElement(AcceptFareTerms).click();
}


public void LuggageAddition(int users)

{

	WebElement Seats = CoreActions.wait1.until(ExpectedConditions.elementToBeClickable(ScrollDown));	
	
	
//	WebElement element1 = CoreActions.getWebDriver().findElement(ScrollDown);
	CoreActions.jse.executeScript("arguments[0].scrollIntoView();",Seats);

	CoreActions.getWebDriver().findElement(BaggingOptions).click();

	//Incrementing the Bag Count

	
	WebElement rightButton = CoreActions.wait1.until(ExpectedConditions.elementToBeClickable(AddLuggage));
//	WebElement rightButton= CoreActions.getWebDriver().findElement(AddLuggage);
	for (int j=1;j<users;j++) 
	
	{
		rightButton.click();	 
	}
}


public void quit() throws Throwable

{ CoreActions.driver.quit();}
}
