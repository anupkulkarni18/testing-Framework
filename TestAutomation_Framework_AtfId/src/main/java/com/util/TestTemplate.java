package com.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestTemplate {
	
	@Parameters({"browser"})
	@BeforeTest
	public void start(String browser) {
		System.out.println("before test");
		BrowserDriver.startBrowser(browser);
		BrowserDriver.maximizeBrowser();
		BrowserDriver.accessUrl("enter URL");
	}
	
	@AfterTest
	public void close() {
		BrowserDriver.closeBrowser();
		System.out.println("aftre test");
	}

}
