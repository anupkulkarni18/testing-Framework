package loginTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.BrowserDriver;
import com.util.GUIController;
import com.util.TestTemplate;
import com.util.XmlReader;

public class TC_Login extends TestTemplate{
	
	@Parameters({"browser"})
	@Test
	public void login(String browser){
		
		//System.out.println("browser "+browser);
		//BrowserDriver.startBrowser(browser);
		BrowserDriver.maximizeBrowser();
		BrowserDriver.accessUrl("https://platform-staging.ooyala.com");
		//BrowserDriver.closeBrowser();
		//System.out.println("cvhkjl;'");
	}
	
	@Test(dataProvider="empLogin")
	
	public void verifyLoginTest(String email,String pass) throws Exception{
//		System.out.println(">>> " +email);
//		System.out.println("?? "+pass);
		Map<String, String> objRepo = XmlReader.getObjectRepo("Login_Page");
		System.out.println(objRepo);
		String email_identifier = objRepo.get("emailId");
		String identifier_pass= objRepo.get("password");
		
		WebElement pass_ele= GUIController.getWebElement(identifier_pass);
		WebElement email_ele = GUIController.getWebElement(email_identifier);
		System.out.println();
		email_ele.sendKeys(email);
		pass_ele.sendKeys(pass);
		Thread.sleep(10000);
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException, IOException{
		Object[][] arrayObject = getExcelData();
		System.out.println(">"+arrayObject.length);
		
		return arrayObject;
		
	}

	@Test
	public String[][] getExcelData() throws BiffException, IOException{
	
		String[][] contentarray = null;
		FileInputStream fs = new FileInputStream("C:\\Users\\CHITTU\\Desktop\\testData.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		
		Sheet sh = wb.getSheet("Employee");
		System.out.println(sh.getColumns());
		System.out.println("row "+sh.getRows());
		contentarray= new String[sh.getRows()][sh.getColumns()];
		for (int i = 0; i < sh.getRows(); i++) {
			for (int j = 0; j < sh.getColumns(); j++) {
				//System.out.println(i+" "+j);
				//System.out.println("excel "+(i +","+ j)+" : "+sh.getCell(j, i).getContents());
				contentarray[i][j]=sh.getCell(j, i).getContents();
				
			}
			
		}
	//	System.out.println("content array "+contentarray.length);
		return contentarray;
}

}
