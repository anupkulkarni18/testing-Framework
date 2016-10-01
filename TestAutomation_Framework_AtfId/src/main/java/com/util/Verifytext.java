package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Verifytext {
	
	public static void main(String[] args) throws Exception {
		//WebDriver d = new FirefoxDriver();
		 String driverPath="C:\\Users\\CHITTU\\Downloads\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", driverPath);
		 WebDriver d = new ChromeDriver();
		 d.get("http://google.com");
		 Thread.sleep(10000);
		Assert.assertEquals(d.findElement(By.id("hplogo")).getAttribute("title"),"gmail");
		System.out.println("verification fails");
	}
}
