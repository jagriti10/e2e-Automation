package com.progress.telerik.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickActionUtilities {
	protected final WebDriver driver;
	
	public ClickActionUtilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(String xpath) {
        this.click(By.xpath(xpath));
    }
	
    public void click(By locator) {
    	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(locator));
    	driver.findElement(locator).click();
    }

}
