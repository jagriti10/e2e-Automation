package com.codprog.core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	public WebDriverFactory(String browser, Logger log) {
		this.browser = browser;
		this.log = log;
	}
	
	public WebDriver createDriver() {
		
		switch(browser) {
		case "chrome" : 
			log.info("Starting browser: "+ browser);
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless=new");
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
			break;
		
		case "safari" :
			log.info("Setting Safari Browser");
			
			driver.set(new SafariDriver());
			break;
		}
		return driver.get();
	}

}
