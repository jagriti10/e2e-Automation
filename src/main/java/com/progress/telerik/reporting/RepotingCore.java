package com.progress.telerik.reporting;

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

public class RepotingCore {
	
	public static void main(String args[]) throws IOException {
		//String fileAddress = "/Users/jagriti.sharma/eclipse-workspace/progress-telerik/com.progress.telerik/src/main/resource";
		ExtentReports extent = new ExtentReports(); 
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		extent.createTest("test 2").pass("this is passed");
		extent.createTest("Test 1").fail("This is failed");
		extent.createTest("test 3").log(Status.FAIL, "this is logged as failed");
		
		
//		sparkReporter.config().setTheme(Theme.DARK);
//		sparkReporter.config().setDocumentTitle("Automation Report");
//		sparkReporter.config().setReportName("Web test Run");
		
		extent.attachReporter(sparkReporter);
		extent.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());
		
		
	}
	

}
