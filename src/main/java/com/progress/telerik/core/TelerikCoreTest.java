package com.progress.telerik.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.progress.telerik.products.endpoints.TelerikEndPoints;
import com.progress.telerik.utilities.ClickActionUtilities;
import com.progress.telerik.utilities.TextActionUtilites;


public class TelerikCoreTest {

	protected WebDriver driver;
	protected TextActionUtilites textAction;
	protected ClickActionUtilities clickAction;
	protected TelerikEndPoints endpoint;
	protected String url;
	protected Logger log;
	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browser, ITestContext ctx) {
	
		log = LogManager.getLogger(ctx.getName());
		WebDriverFactory factory = new WebDriverFactory(browser, log);
		driver = factory.createDriver();
		
		textAction = new TextActionUtilites(driver);
		clickAction = new ClickActionUtilities(driver);
		
		url = TelerikEndPoints.BASE_URL;
		driver.get(url );
		log.info("Home Page Opened " + url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Closing all browser windows and ending the WebDriver session");
		driver.close();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDownDriver() {
	   driver.quit();
	}


	
}
