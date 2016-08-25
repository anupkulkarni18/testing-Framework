package testcases;

import org.testng.annotations.Test;
import pageController.LoginPage;

public class TC_Login extends TestTemplate {

	@Test
	public static void testLogin() {
		LoginPage.login(testdataMap.get("userName"),testdataMap.get("password"));
	}
}
