package MiniProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelclass {
	
	public static XSSFCell c1 ;
	public static String search;
	
	public  void dataExtract() throws IOException
	{
		//Reading the Excel File
		File excelFile = new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow r = sheet.getRow(1);
		//Storing data from ExcelSheet into variables
	        c1 = r.getCell(0);
		 search = String.valueOf(c1);
		//Close FileInputStream
		wb.close();
	}
}

