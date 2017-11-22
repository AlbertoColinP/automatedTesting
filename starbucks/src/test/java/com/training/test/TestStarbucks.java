package com.training.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trainig.starbucks.Coffee;
import com.trainig.starbucks.StarbucksHomePage;

public class TestStarbucks extends BaseTest{
	

	
	@Test(enabled=true)
	public void testMenu() {
		StarbucksHomePage page=getHomePage();
		page.validarMenu();
		
		Assert.assertEquals(page.getItems(),Arrays.asList("COFFEE","TEA","MENU","COFFEEHOUSE","SOCIAL IMPACT","CARD","BLOG"));
	}
	
	@Test(enabled=true)
	public void coffeeTest() {
		StarbucksHomePage page=getHomePage();
		Coffee c=page.menuCoffee();
		c.makeCoffee();
		Assert.assertEquals(c.getOptionsMenu(),Arrays.asList("Balanced and easy-going","A busy day","Cocoa","I love to try something new and different","House Blend"));
	}
	
	
}
