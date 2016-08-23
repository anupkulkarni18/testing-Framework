package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUIController {

	private static WebDriver webDriver;

	public static WebDriver getWebdriver() {

		return webDriver;

	}

	public static void setWebDriver(String browserName) {
		switch (browserName) {
		case "firefox":
			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/lib/chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			break;
		default:
			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			break;
		}

	}
	
	
public static WebElement getWebElement(String identifier) {
		
		String locatorType=identifier.split("_TBR_")[0];
		String locatorValue=identifier.split("_TBR_")[1];
		WebElement element=null;
		
		switch (locatorType) {
		case "xpath":
			element=GUIController.getWebdriver().findElement(By.xpath(locatorValue));
			break;
		case "id":
			element=GUIController.getWebdriver().findElement(By.id(locatorValue));
			break;
		case "class":
			element=GUIController.getWebdriver().findElement(By.className(locatorValue));
			break;
		case "name":
			element=GUIController.getWebdriver().findElement(By.name(locatorValue));
			break;
			
		default:
			System.out.println("Invalid locator type found.. Please enter valid locator type like xpath,id etc");
			break;
		}
		
		return element;

	}

	

	/*public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + "/lib/chromedriver.exe");
		GUIController.setWebDriver("chrome");
		BrowserDriver.openNewTab();
	}*/

}
