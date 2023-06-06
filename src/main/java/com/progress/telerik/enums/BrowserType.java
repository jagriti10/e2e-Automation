package com.progress.telerik.enums;

public enum BrowserType {
    FIREFOX("Firefox"),
    CHROME("Chrome"),
    EDGE("Edge"),
    SAFARI("Safari");
	
	private String browserType;

	BrowserType(String browserType) {
        this.browserType = browserType;
    }

    @Override
    public String toString() {
        return browserType;
    }
}
