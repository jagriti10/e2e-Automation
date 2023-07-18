package com.codprog.products.screens;

import org.openqa.selenium.By;

public class HomePage {
	
    private HomePage() {
    }
    
    public static final By LOGO = By.xpath("//div[@class='App']/div/nav/div/a");
    public static final By BANNER = By.xpath("//p[contains(@class,'bannerPara')]");
    public static final By VIEW_COURSE_BUTTON = By.xpath("//button/span[contains(text(),'View Course')]");
    public static final By BUY_NOW_BUTTON = By.xpath("//button[contains(text(),'Buy Now')]");




}
