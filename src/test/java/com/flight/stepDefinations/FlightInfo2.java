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
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flight.coreframework.*;
import com.flight.dataProvider.ConfigFileReader;
import com.flight.helper.LoggerHelper;
import com.flight.implementation.flightImplementation;
import com.flight.pageObjects.FlightObject;

import java.util.*;
import java.util.Calendar;


@RunWith(Cucumber.class)

public class FlightInfo2 extends flightImplementation {
	
	int users;

	@Given("^I launch the Qantas Website for an user for (.+) time$")
	
	public void i_launch_the_qantas_website_for_an_user_for_time(String users1) throws Throwable {	
			
		
	int counter = Integer.parseInt(users1);
	users = counter;
		for(int i=1;i<=counter;i++) {
		    CoreActions.init();
			i_launch_the_qantas_website_for_an_user2(); 
			i_choose_the_right_destination2();
			i_choose_the_right_dates2();
			i_do_initial_price_check2();
			i_add_the_favorite_red_deal2();
			i_do_the_update_price_check2();
			i_add_luggage_based_on_number_of2(i);
			quit();

		}
     }

	public void i_launch_the_qantas_website_for_an_user2() throws Throwable {
		launchQantasSite();
			
	}  

	public  void i_choose_the_right_destination2() throws Throwable {
		//	LoggerHelper.getLogger(LoggerHelper.class);

		 ChooseDestination();		
	}	

	public void i_choose_the_right_dates2() throws Throwable {

		ChooseDates ();
	}

	public void i_do_initial_price_check2() throws Throwable {	
		// Cart Total before adding  
		InitialCartValue();
		//System.out.println(CoreActions.getWebDriver().findElement(WidgetAmtBeforeAdding).getText());		
	}
		//	
	
	public void i_add_the_favorite_red_deal2() throws Throwable {
		// Add the Red e-Deal 
		AddDeal();
	}

	public void i_do_the_update_price_check2() throws Throwable {
		NewPriceCheck();
	}
	//Addition of bags
	public void i_add_luggage_based_on_number_of2(int users) throws Throwable {

		LuggageAddition(users);
		//driver.quit();	
	} 


	
}

