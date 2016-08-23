package testcases;

import java.io.File;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.BrowserDriver;
import util.ReadPropertyFile;

public class TestTemplate {
	static Map<String, String> testdataMap;

	@BeforeTest
	public void initialize(){
		BrowserDriver.startBrowser("chrome");
		try {
			String fileName =this.getClass().getSimpleName();
			System.out.println("File Name : "+fileName);
			testdataMap = ReadPropertyFile.getTestDataInMap(System.getProperty("user.dir")+File.separator+this.getClass().getSimpleName()+".prop");
			BrowserDriver.accessUrl(testdataMap.get("url"));
			BrowserDriver.maximizeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void terminate(){
		BrowserDriver.QuitBrowser();
	}


}
