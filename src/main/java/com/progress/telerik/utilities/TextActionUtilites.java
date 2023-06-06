package com.progress.telerik.utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextActionUtilites {
	protected final WebDriver driver;
	
	public TextActionUtilites(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendText(By locator, Object textOrKeys) {
        this.sendToField(this.findElementInternal(locator), textOrKeys);
    }
    
	private WebElement findElementInternal(By locator) {
        try {
        	new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedConditions.presenceOfElementLocated(locator)));
        } catch (TimeoutException exe) {
            System.out.print("Timed out waiting for element ");
        }
        return driver.findElement(locator);
        }
  
       
    private void sendToField(WebElement element, Object... keysOrString) {
                this.clear(element);
                Object[] var1 = keysOrString;

               for(int i = 0; i < keysOrString.length; ++i) {
                    Object value = var1[i];
                    if (value instanceof String) {
                        element.sendKeys(new CharSequence[]{(String)value});
                    } else {
                        if (!(value instanceof Keys)) {
                           System.out.print("SendText only accepts String or org.openqa.selenium.Keys. Provided: [null]");
                        element.sendKeys(new CharSequence[]{(Keys)value});
                    }
                }
               }

            }

    public void clear(WebElement element) {
    element.click();
    this.driver.switchTo().activeElement().sendKeys(new CharSequence[]{Keys.END});
    element.clear();
}

}
