package com.codprog.reporting;



import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.codprog.core.CodProgCoreTest;

public class Screenshot extends CodProgCoreTest {
	
	public static String captureScreenshot(WebDriver driver) throws Exception {
		TakesScreenshot  takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/image_"+ getTimeStamp() + ".png");
		try {
		FileUtils.copyFile(sourceFile, destFile );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}
	
	private static String getTimeStamp() {
	      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	      return timestamp.toString();   
	}
}
