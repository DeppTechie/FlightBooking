package com.flight.pageObjects;

import org.openqa.selenium.By;
public class FlightObject {
	
public static By Destination = By.id("typeahead-input-to");
public static By JourneyType = By.id("oneway");
public static By MyCalendar = By.id("datepicker-input-departureDate");
public static By SearchFlights = By.xpath("//button[contains(text(),'SEARCH FLIGHTS')]");
public static By WidgetAmtBeforeAdding = By.cssSelector(".text-right.amount");
public static By AddRedDeal = By.xpath("//*[@class='fare-cell fare_AUAURED1JQ idx_0 not-selected with-sep']/label/div/span/div/span/span/span[starts-with(text(),'$')]/../../..");
public static By AddTrip = By.xpath(".//span[text()='Add to Trip']");
public static By TotalDealCost = By.cssSelector(".amount.e2e-cash");
public static By TotalFinalCost = By.cssSelector(".text-right.amount");

//public static By TotalFinalCost = By.cssSelector(".price-row.e2e-cash-amount.ng-star-inserted");
public static By FirstContinue =By.id("btn-continue");
public static By SecondContinue =By.id("btn-continue");
public static By AcceptFareTerms =By.id("btn-accept");
public static By ScrollDown =By.cssSelector(".add-seat.trigger-modal");
public static By BaggingOptions =By.xpath("//button/span[text()= 'Add bags']");
public static By AddLuggage =By.cssSelector(".btn.right");

}
