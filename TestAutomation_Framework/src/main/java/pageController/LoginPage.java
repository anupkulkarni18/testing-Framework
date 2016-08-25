package pageController;


import util.GUIController;

public class LoginPage extends BasePageController{
	
	public static void login(String userName,String password) {
		GUIController.getWebElement(getObjectMap().get("userName")).sendKeys(userName);
		GUIController.getWebElement(getObjectMap().get("password")).sendKeys(password);
		GUIController.getWebElement(getObjectMap().get("signIn")).click();
	}
}
