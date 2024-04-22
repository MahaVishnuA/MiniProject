package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;

public class POIdemo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\main\\java\\Practice\\Demo.xlsx");
		//or because of, if we change the location of the excel file then we can use the below format
		//FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Practice\\Demo.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//wb.getSheetAt(0);
		int totRows = sheet.getLastRowNum();
		int totCells = sheet.getRow(1).getLastCellNum();
		System.out.println("No of rows: "+totRows);//4
		System.out.println("No of columns: "+totCells);//4
		for(int i = 0;i<=totRows;i++) {
			XSSFRow row = sheet.getRow(i);
			
			for(int j = 0;j<totCells;j++) {
//				XSSFCell cell = row.getCell(j);
//				String value = cell.toString();
				
				String value = row.getCell(j).toString();
				System.out.print(value+"     ");
			}
			System.out.println();
		}
		wb.close();
		file.close();
		
		
		
	}

}
