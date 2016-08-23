package util;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BrowserDriver {

	public static void startBrowser(String browserName){
		GUIController.setWebDriver(browserName);
	}
	
	public static void maximizeBrowser(){
		GUIController.getWebdriver().manage().window().maximize();
	}
	
	public static void accessUrl(String url) {
		GUIController.getWebdriver().get(url);
	}

	public static void closeBrowser() {
		GUIController.getWebdriver().close();
	}

	public static void QuitBrowser() {
		GUIController.getWebdriver().quit();
	}

	public static void openNewTab() {
		GUIController.getWebdriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,"t");
	}
	
	
	

}
