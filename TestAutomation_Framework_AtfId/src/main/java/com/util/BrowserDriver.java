package com.util;


public class BrowserDriver {

	public static void startBrowser(String browserName) {
		GUIController.setWebDriver(browserName);
	}
	public static void maximizeBrowser() {
		GUIController.getWebDriver().manage().window().maximize();
	}
	public static void accessUrl(String Url) {
		GUIController.getWebDriver().get(Url);;
	}
	public static void closeBrowser() {
		GUIController.getWebDriver().close();
		
	}
	
	
}
