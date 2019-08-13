package com.flight.coreframework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flight.dataProvider.ConfigFileReader;
import com.flight.helper.LoggerHelper;
import com.flight.stepDefinations.FlightInfo2;

public class CoreActions {	
	public static final Logger LOG = LoggerHelper.getLogger(FlightInfo2.class);
	public static WebDriver driver ;	
	public static ConfigFileReader configFileReader= new ConfigFileReader();
	//int counter=0;
	public static JavascriptExecutor jse;// = (JavascriptExecutor)driver;
	public static WebDriverWait wait1;// = new WebDriverWait(driver,10);

	
	public static void init() {		
		System.setProperty ("webdriver.chrome.driver", configFileReader.getValue("driverPath"));
		setWebdriver(); 
		jse = (JavascriptExecutor)driver;
		wait1 = new WebDriverWait(driver,10);
	}
	public void click(By by) {
		CoreActions.getWebDriver().findElement(by).click();		
	}	
	public static void setWebdriver() {
		
		 driver = new ChromeDriver(); 
	}
	
	public static WebDriver getWebDriver() {
		
		return driver;
	}

}
