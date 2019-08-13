package com.flight.cucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


import cucumber.api.CucumberOptions;
	@SuppressWarnings("deprecation")
	@RunWith(Cucumber.class)
	@CucumberOptions(
			
			
			plugin = {"pretty", "html:target/test/"},
			features = "src/test/java/features/Flight2.feature",
			glue="com/flight/stepDefinations"
			
)	
	public class TestRunner
	
	{

}
	
                  
