package com.training.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.trainig.starbucks.StarbucksHomePage;

public class BaseTest {

	
	MyDriver myDriver;
	
	private StarbucksHomePage homePage;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		
		myDriver=new MyDriver(browser);
		homePage=new StarbucksHomePage(myDriver.getDriver());
		
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public void afterSuite() {
		homePage.dispose();
	}
	
	public StarbucksHomePage getHomePage() {
		return homePage;
	}
}
