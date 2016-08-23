package pageController;

import java.util.Map;

import util.GUIController;
import util.XmlReader;

public class LoginPage {
	String file = this.getClass().getSimpleName();
	
	public void login(String userName,String password) {
		System.out.println("File Name : "+file);
		
		Map <String,String> loginMap= XmlReader.getObjectRepo(file);
		
		GUIController.getWebElement(loginMap.get("userName")).sendKeys(userName);
		GUIController.getWebElement(loginMap.get("password")).sendKeys(password);
		GUIController.getWebElement(loginMap.get("signIn")).click();
	}
}
