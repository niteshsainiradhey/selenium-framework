package com.logindemoproject.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting 
{
       public static void main(String[] args) throws Exception
       {
    	   XSSFWorkbook wb;
  		 XSSFSheet ws;
  		 String path="C:\\Users\\DELL\\Desktop\\data12.xlsx";
  		 FileInputStream fn=new FileInputStream(path);
  		 wb=new XSSFWorkbook(fn);
  		 ws= wb.getSheet("Sheet1");
  		 int row=ws.getLastRowNum()+1;
  		 int col=ws.getRow(0).getLastCellNum();
  		 for(int i=0;i<row;i++)
  		 {
  			 for(int j=0;j<col;j++)
  			 {//a[i][j]
  				 System.out.println(ws.getRow(i).getCell(j).toString());
  			 }
  		 }
	}
}
