package com.progress.telerik.reporting;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
	
	// public void captureScreenshot() throws Exception {
	public static void main(String args[]) throws Exception {
		TakesScreenshot  takesScreenshot = TakesScreenshot (driver);
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		
	}
}
