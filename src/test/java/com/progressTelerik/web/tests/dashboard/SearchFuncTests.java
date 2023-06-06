package com.progressTelerik.web.tests.dashboard;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.progress.telerik.core.TelerikCoreTest;
import com.progress.telerik.core.TestCaseSummary;
import com.progress.telerik.products.endpoints.TelerikEndPoints;
import com.progress.telerik.products.screens.HomePage;

public class SearchFuncTests extends TelerikCoreTest {
	


	@TestCaseSummary("Verify that the search option is displayed")
    @Test
    public void testSearchIcon() {
       Assert.assertTrue((driver.findElement(HomePage.SEARCH_ICON)).isDisplayed());
    }
    
    @TestCaseSummary("Verify that the search sends ")
    @Test
    public void testSearchResults() {
    	driver.get(super.url + TelerikEndPoints.SEARCH);
    	clickAction.click(HomePage.SEARCH_ICON);
    	textAction.sendText(HomePage.SEARCH_BOX_INPUT,"Load Testing");
    
    }

}
