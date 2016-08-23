package testcases;

import org.testng.annotations.Test;
import pageController.LoginPage;

public class TC_Login extends TestTemplate {

	@Test
	public static void testLogin() {
		LoginPage loginPage = new LoginPage();
		loginPage.login(testdataMap.get("userName"),testdataMap.get("password"));
	}
}
