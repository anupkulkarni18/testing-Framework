package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadXml {
	
	public static void main(String[] args) throws BiffException, IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\CHITTU\\Desktop\\testData.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		String[][] ca = null ;
		Sheet sh = wb.getSheet("Employee");
		System.out.println(sh.getColumns());
		System.out.println("row "+sh.getRows());
		for (int i = 0; i < sh.getRows(); i++) {
			for (int j = 0; j < sh.getColumns(); j++) {
				System.out.println(i +","+ j);
				System.out.println((i +","+ j)+" : "+sh.getCell(j, i).getContents());
				//System.out.println(ca[0][0]);
				//ca[i][j]=sh.getCell(i,j).getContents();
			//	System.out.println(ca.length);
				
			}
			
		}
		
		/*int [][] twoDim = new int[5][5];

		int a = (twoDim.length);//5
		int b = (twoDim[0].length);//5

		for(int i = 0; i < a; i++){ // 1 2 3 4 5
		    for(int j = 0; j <b; j++) { // 1 2 3 4 5
		        int x = (i+1)*(j+1);
		        twoDim[i][j] = x;
		        if (x<10) {
		            System.out.print(" " + x + " ");
		        } else {
		            System.out.print(x + " ");
		        }
		    }//end of for J
		    System.out.println();
		}//end of for i*/
	}

}
