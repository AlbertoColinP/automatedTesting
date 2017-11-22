package com.trainig.starbucks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Coffee extends BasePage{

	@FindBy(xpath="//*[@id=\"question1\"]/button[2]")
	private WebElement beg;
	
	@FindBy(xpath="//*[@id=\"questions-container\"]/div[2]/div[1]/div[1]/div/div/h4")
	private WebElement begSelected;
	//////////////
	@FindBy(xpath="//*[@id=\"question2\"]/button[3]")
	private WebElement abd;
	
	@FindBy(xpath="//*[@id=\"questions-container\"]/div[2]/div[2]/div[1]/div/div/h4")
	private WebElement abdSelected;
	//////////////
	@FindBy(xpath="//*[@id=\"medium-questions\"]/button[3]")
	private WebElement cocoa;
	
	@FindBy(xpath="//*[@id=\"question3\"]/div/div[2]/div[1]/div/div/h4")
	private WebElement cocoaSelected;
	/////////////
	@FindBy(xpath="//*[@id=\"question4\"]/button[3]")
	private WebElement diff;
	
	@FindBy(xpath="//*[@id=\"questions-container\"]/div[2]/div[4]/div[1]/div/div/h4")
	private WebElement difSelected;
	////////////
	
	@FindBy(id="find-my-coffee")
	private WebElement findYC;
	
	
	@FindBy(xpath="//*[@id=\"featured-coffees-stack\"]/div/div/div[2]/div/article[5]/div[2]/div[1]/div[1]/div/h3")
	private WebElement res;
	
	private List<String>optionsMenu=new ArrayList();
	
	public Coffee(WebDriver driver) {
		super(driver);
	}
	
	public List<String> getOptionsMenu() {
		return optionsMenu;
	}
	
	public void makeCoffee() {
		
//		getDriver().manage().window().maximize();
		
		beg.click();
		optionsMenu.add(begSelected.getText());
		
		abd.click();
		optionsMenu.add(abdSelected.getText());
		
		cocoa.click();
		optionsMenu.add(cocoaSelected.getText());
		
		diff.click();
		optionsMenu.add(difSelected.getText());		
		
		getWait().until(ExpectedConditions.visibilityOf(findYC));
		
//		new Actions(getDriver()).moveToElement(findYC).perform();  
//		Actions actions = new Actions(getDriver());
//		actions.moveToElement(findYC).click().build().perform();
		((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0,"+findYC.getLocation().y+")");
		findYC.click();
		
		getWait().until(ExpectedConditions.visibilityOf(res));
		optionsMenu.add(res.getText());
		
	}

	
	
}
