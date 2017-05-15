package com.cpsbank.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Excel {
	
	FileInputStream file;
	public int rowc;
	Row r;

	public XSSFWorkbook wbo;
	public XSSFSheet wso;
	public void excelSheet(String xlin,String shname) throws Exception{
	 file=new FileInputStream(xlin);
	wbo=new XSSFWorkbook(file);
	wso=wbo.getSheet(shname);
	 rowc=wso.getLastRowNum();
	
		 
		
	}

}
