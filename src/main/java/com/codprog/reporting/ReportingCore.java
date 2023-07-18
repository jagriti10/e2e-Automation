package com.codprog.reporting;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.FileUtils;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingCore extends Screenshot {
	
	public static void main(String args[]) throws Exception {
		
		ExtentReports extent = new ExtentReports(); 
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		String path = captureScreenshot(driver);
		
		extent.createTest("test 2")
		.pass("this is passed")
		.addScreenCaptureFromPath(path);
		
		extent.createTest("Test 1").fail("This is failed");
		extent.createTest("test 3").log(Status.FAIL, "this is logged as failed");
		
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Web test Run");
		
		extent.attachReporter(sparkReporter);
		extent.flush();
		
		
		Desktop.getDesktop().browse(new File("report.html").toURI());
		
		
	}
	

}
