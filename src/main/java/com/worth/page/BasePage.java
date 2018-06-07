package com.worth.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public Wait<WebDriver> wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);

	}

	public WebElement getElement(By selector) {
		return driver.findElement(selector);
	}

	
	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}
		
	public void WaitUntilElementIsPresent(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void waitUntilElementToBeClickable(By selector) {
		wait.until(ExpectedConditions.elementToBeClickable(selector));
	}
	

	public void clickToNthOfElement(By selector, int num) { 		
		List<WebElement> elements = driver.findElements(selector); 	       
		System.out.println("Test1 number of elements: " + elements.size());  	        	        	 
	    elements.get(num).click(); 	        	    	           
	}
	

	
}
