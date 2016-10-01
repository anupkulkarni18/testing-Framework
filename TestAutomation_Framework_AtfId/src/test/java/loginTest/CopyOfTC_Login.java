package loginTest;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.BrowserDriver;
import com.util.TestTemplate;

public class CopyOfTC_Login extends TestTemplate{
	
	@Parameters({ "browser" , "name"})
	@Test
	public void testCaseOne(String browser,String name) {
		System.out.println("browser passed as :- " + browser);
		System.out.println("name passed as :- " + name);
	}
	
	@Parameters({"option_test"})
	@Test
	public void testOptional(@Optional("two optionl") String option_test_1 ){
		//System.out.println("optional parameter test: "+option_test_1 );
		
	}
	
	@Parameters("param two")
	@Test
	public void testOptionParamTwo(@Optional("two") String paramTwo) {

		//System.out.println("Optional value passed ::" + paramTwo);
	}
	
	@Parameters({"browser"})
	@Test
	public void login(String browser){
		
		//System.out.println("browser "+browser);
		//BrowserDriver.startBrowser(browser);
		BrowserDriver.maximizeBrowser();
		BrowserDriver.accessUrl("url");
		//BrowserDriver.closeBrowser();
		//System.out.println("cvhkjl;'");
	}
	
	@Test(dataProvider="empLogin")
	
	public void verifyLoginTest(String email,String password){
		System.out.println(">>> " +email);
		System.out.println(password);
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException, IOException{
		Object[][] arrayObject = getExcelData();
		System.out.println(">"+arrayObject.length);
		System.out.println(arrayObject[0][0]);
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
				System.out.println(i+" "+j);
				System.out.println("excel "+(i +","+ j)+" : "+sh.getCell(i, j).getContents());
				contentarray[i][j]=sh.getCell(j, i).getContents();
				
			}
			
		}
		System.out.println("content array "+contentarray.length);
		return contentarray;
}

}
