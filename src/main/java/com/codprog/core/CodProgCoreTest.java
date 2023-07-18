package com.codprog.core;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.codprog.products.endpoints.CodprogEndPoints;
import com.codprog.reporting.ReportingCore;
import com.codprog.utilities.ClickActionUtilities;
import com.codprog.utilities.TextActionUtilites;


public class CodProgCoreTest {

	protected static WebDriver driver;
	protected TextActionUtilites textAction;
	protected ClickActionUtilities clickAction;
	protected CodprogEndPoints endpoint;
	protected String url;
	protected Logger log;
	protected ReportingCore reports;
	

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional("chrome") String browser, ITestContext ctx) {
	
		log = LogManager.getLogger(ctx.getName());
		WebDriverFactory factory = new WebDriverFactory(browser, log);
		driver = factory.createDriver();
		
		textAction = new TextActionUtilites(driver);
		clickAction = new ClickActionUtilities(driver);
		
		url = CodprogEndPoints.BASE_URL;
		driver.get(url);
		log.info("Home Page Opened " + url);
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
	@AfterTest(alwaysRun = true)
	public void tearDownDriver() {
	   driver.quit();
	}
	
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void generateExtentReports() {
		//reports.flush();
	}


	
}
