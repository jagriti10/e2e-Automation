package com.codProg.web.tests;

import org.testng.annotations.Test;


import com.codprog.core.CodProgCoreTest;
import com.codprog.core.TestCaseSummary;
import com.codprog.products.screens.HomePage;
import static com.codprog.reporting.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;

public class HomePageTests extends CodProgCoreTest {
	


	@TestCaseSummary("Verify the CodProg logo functionality")
    @Test(priority =1)
    public void testCodProgLogo(Method method) {
		startTest(method.getName(), "The logo is displayed");
       Assert.assertTrue((driver.findElement(HomePage.LOGO)).isDisplayed());
       Assert.assertTrue((driver.findElement(HomePage.LOGO)).isEnabled());
    }
    
    @TestCaseSummary("Verify the contents on the HomePage")
    @Test(priority =2)
    public void testHomePageContents(Method method) {
    	startTest(method.getName(), "The buttons are displayed");
    	Assert.assertTrue((driver.findElement(HomePage.VIEW_COURSE_BUTTON)).isDisplayed());
    	Assert.assertTrue((driver.findElement(HomePage.BUY_NOW_BUTTON)).isDisplayed());
    	Assert.assertFalse((driver.findElement(HomePage.BUY_NOW_BUTTON)).isEnabled(),"Verify the buy now button is disabled");
    
    }

}
