package com.progress.telerik.products.screens;

import org.openqa.selenium.By;

public class HomePage {
	
    private HomePage() {
    }
    
    public static final By SEARCH_ICON = By.xpath("//a[@title='Search']");
    public static final By SEARCH_BOX_INPUT = By.xpath("//input[@type='search']");
}
