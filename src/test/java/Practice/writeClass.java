package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class writeClass {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\main\\java\\Practice\\Demo.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        //XSSFCell cell = sheet.createRow(0).createCell(1);
//        XSSFRow row = sheet.createRow(5);
//        row.createCell(1).setCellValue("Welcome");
//		//cell.setCellValue("Welcome");
//        row.createCell(2).setCellValue("2765387");
//        row.createCell(3).setCellValue("BH@gmail.com");
//        row.createCell(1).setCellValue("Hai");
//        row.createCell(2).setCellValue("8763398");
//        row.createCell(3).setCellValue("BK@gmail.com");
        Scanner sc = new Scanner(System.in);
        for(int r=0;r<=5;r++) {
        	XSSFRow currentRow = sheet.createRow(r);
        	for(int c=0;c<3;c++) {
        		//currentRow.createCell(c).setCellValue("Welcome");
        		System.out.println("Enter a value: ");
        		String value = sc.next();
        		currentRow.createCell(c).setCellValue(value);
        		
        	}
        }
        
        
	}

}
