package com.codprog.utilities;



import org.apache.commons.lang3.StringUtils;

import com.codprog.core.CodProgCoreTest;

public class TestUtilities extends CodProgCoreTest {

/*
 * This class would have methods that a few classes will use
 * Core Test class will have methods that all classes would use 	
 */
	
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/* Methods to assert strings */
	
    protected boolean assertStringMatchesIgnoreCase(String expected, String discovered) {
        return StringUtils.equalsIgnoreCase(expected.trim(), discovered.trim());
    }
    
    protected boolean assertSoftStringMatch(String expected, String discovered) {
        return StringUtils.deleteWhitespace(expected).equalsIgnoreCase(StringUtils.deleteWhitespace(discovered));
    }
    
    protected boolean assertSoftStringContains(String fullText, String subString) {
        return StringUtils.containsIgnoreCase(StringUtils.deleteWhitespace(fullText), StringUtils.deleteWhitespace(subString));
    }
   
}
