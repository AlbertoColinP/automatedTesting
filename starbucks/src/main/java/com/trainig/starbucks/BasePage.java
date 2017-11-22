package com.trainig.starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 100);
		
		this.driver=driver;
		
	}
	
	public WebDriverWait getWait() {
		return wait;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	public void dispose() {
		
		if (driver!=null) {
			driver.quit();
		}
	}
}

