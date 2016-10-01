package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUIController {
	private static WebDriver webDriver;
	static String driverPath="C:\\Users\\CHITTU\\Downloads\\chromedriver.exe";
	
	public static WebDriver getWebDriver(){
		if(webDriver == null){
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}
	
	public static void setWebDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath);
			webDriver = new ChromeDriver();
			break;
		case "firefox":
			webDriver = new FirefoxDriver();
			break;
		default:
			webDriver = new FirefoxDriver();
			break;
		}
	}
	
	public static WebElement getWebElement(String identifier) throws Exception {
		WebElement element = null;
		String locatorType = identifier.split("_TBR_")[0];
		String locatorValue = identifier.split("_TBR_")[1];
		
		switch (locatorType) {
		case "xpath":
			element = GUIController.getWebDriver().findElement(By.xpath(locatorValue));
			break;
		case "id":
			element=GUIController.getWebDriver().findElement(By.id(locatorValue));
			break;
		case "name":
			element=GUIController.getWebDriver().findElement(By.name(locatorValue));
			break;
		case "className":
			element=GUIController.getWebDriver().findElement(By.className(locatorValue));
			break;
		case "tagName":
			element=GUIController.getWebDriver().findElement(By.tagName(locatorValue));
			break;

		default:
			System.out.println("please provide valid locator like xpath,id,name,classname etc...");
			break;
		}
		return element;
	}

}
