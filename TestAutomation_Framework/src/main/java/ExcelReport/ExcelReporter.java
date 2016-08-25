package ExcelReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ExcelReporter implements IReporter{

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
		generateExcelReport(suites, outputDirectory);
	}

	public void generateExcelReport(List<ISuite> suites,String outputDirectory){

		//Creating Excel Document
		HSSFWorkbook workbook = new HSSFWorkbook();

		//Creating sheet within Excel Document
		Sheet sheet = workbook.createSheet("Result");
		
		//Creating header row
		Row headerRow=sheet.createRow(0);

		List <String> headers =Arrays.asList("Sr.no.","StartTime","EndTime","Testscript Name","Status");

		int cellNum=0;
		// setting the column name in excel sheet
		for(String colName: headers){
			Cell headerCell=headerRow.createCell(cellNum++);
			headerCell.setCellValue(colName);
		}
		
		/* getting the value from suite mention in regrression.xml or testng.xml for each 
		 * test i.e <class></class>
		*/
		int i = 0;
		for (ISuite suite : suites){
			i++;
			System.out.println("Isuite name "+i+" : "+suite.getName());
			// getting suite result i.e. Pass fail or skipped using ISuiteResult
			Map <String,ISuiteResult> suiteResult=suite.getResults();
			
			System.out.println(suiteResult.keySet());
			System.out.println("suiteResult.size() : "+suiteResult.size());
			
			
			System.out.println("suiteResult values"+suiteResult.values());
			
			// now getting the value of each test 
			Collection<ISuiteResult> r= suiteResult.values();
			
			for (ISuiteResult result : r){
				System.out.println("IsuiteResult 1: "+result);
				System.out.println("IsuiteResult: "+result.getTestContext());
				
				ITestContext context=  result.getTestContext();
				
				System.out.println("content: "+context.getPassedTests());
				
				// writing the test status, path of excel sheet by default it is in test-output folder 
				sheet= buildExcelRows(context.getPassedTests(),outputDirectory,"PASS",sheet);
				System.out.println("calling failed");
				sheet= buildExcelRows(context.getFailedTests(),outputDirectory,"FAIL",sheet);
				System.out.println("calling skipped");
				sheet= buildExcelRows(context.getSkippedTests(),outputDirectory,"SKIPPED",sheet);
			}
		}

		try {
			workbook.write(new FileOutputStream(outputDirectory+File.separator+"ExcelReport.xls"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Sheet buildExcelRows(IResultMap resultMap,String outDir,String status,Sheet sheet){
		Sheet workingSheet =sheet;

		Set<ITestResult> testResult = 	resultMap.getAllResults();
		
		System.out.println(sheet.getFirstRowNum());
		
		int rowNum=sheet.getLastRowNum()+1;
		
		System.out.println("las row count "+rowNum);
		
		for(ITestResult result : testResult){
			int cellNum=0;
		//	System.out.println("rsule of map in me "+result);
			
			Row contentRow=sheet.createRow(rowNum++);
			
			Cell testConuter=contentRow.createCell(cellNum++);
			testConuter.setCellValue(rowNum-1);
			
		//	System.out.println("testConuter "+cellNum);
			
			Cell startTime=contentRow.createCell(cellNum++);
			startTime.setCellValue(ConvertMilliSecondsToFormattedDate(result.getStartMillis()));
		//	System.out.println("startTime "+cellNum);
			
			Cell endTimeTime=contentRow.createCell(cellNum++);
			endTimeTime.setCellValue(ConvertMilliSecondsToFormattedDate(result.getEndMillis()));
		//	System.out.println("endTimeTime "+cellNum);
			
			Cell testName=contentRow.createCell(cellNum++);
			testName.setCellValue(result.getMethod().getMethodName());
		//	System.out.println("testName "+cellNum);
			
			Cell testStatus=contentRow.createCell(cellNum++);
			testStatus.setCellValue(status);
		//	System.out.println("testStatus "+cellNum);
		}

		return workingSheet;
	}



	public String ConvertMilliSecondsToFormattedDate(Long milliSeconds){
		String dateFormat = "dd-MM-yyyy hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return simpleDateFormat.format(calendar.getTime());
	}
}

