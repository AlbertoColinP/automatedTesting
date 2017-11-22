package com.trainig.starbucks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksHomePage extends BasePage {

	private static final String STARBUCKS_URL = "https://www.starbucks.com";
	private static final String MENU_ID = "nav";
	private static final String SUBMENU = "//*[@id=\"menu_coffee\"]/div[1]/ol/li[2]/p/a";
	private static final String COFFEE = "COFFEE";
	private static final String ELEMENTS = ".//a//strong";

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get(STARBUCKS_URL);

	}

	public List<String> getItems() {
		return items;
	}

	@FindBy(id = MENU_ID)
	private WebElement menu;

	@FindBy(linkText =COFFEE)
	private WebElement menu_coffee;



	private List<String> items = new ArrayList<String>();

	public void validarMenu() {

		List<WebElement> elemets = menu.findElements(By.xpath(ELEMENTS));

		for (WebElement webElement : elemets) {
			items.add(webElement.getText());
		}
	}

	public Coffee menuCoffee() {
		Actions action = new Actions(getDriver());
		action.moveToElement(menu_coffee).perform();
		WebElement subElement = getDriver().findElement(By.xpath(SUBMENU));
		getWait().until(ExpectedConditions.visibilityOf(subElement));
		subElement.click();
		return new Coffee(getDriver());

	}
}
