package Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MAIN {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		String file = "C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\Practice\\Demo.xlsx";
		int rows = XLUtils.getRowCount(file,"Sheet1");
		for(int i=0;i<rows;i++) {
			//read the data from excel
			String princi = XLUtils.getCellData(file, "Sheet1", i, 0);
			String roi = XLUtils.getCellData(file, "Sheet1", i, 1);
			String per1 = XLUtils.getCellData(file, "Sheet1", i, 2);
			String per2 = XLUtils.getCellData(file, "Sheet1", i, 3);
			String freq =XLUtils.getCellData(file, "Sheet1", i, 4);
			String exp = XLUtils.getCellData(file, "Sheet1", i, 5);
			
			//pass the data to application
			driver.findElement(By.id("principal")).sendKeys(princi);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			Select sel1 = new Select(driver.findElement(By.id("tenureperiod")));
			sel1.selectByVisibleText(per2);
			
			Select select = new Select(driver.findElement(By.id("frequency")));
			select.selectByVisibleText(freq);
			JavascriptExecutor js= (JavascriptExecutor)driver;
			
			WebElement calculateBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img"));
			js.executeScript("arguments[0].click()", calculateBtn);
			
			//validate and update the value
			String value = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
			
			if(Double.parseDouble(exp)==Double.parseDouble(value)) {
				System.out.println("Test passed");
				XLUtils.setCellData(file,"Sheet1", i, 7, "Passes");
			}
			else {
				System.out.println("Test Failed");
				XLUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				XLUtils.fillRedColor(file, "Sheet1", i, 7);
			}
			WebElement cancelBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img"));
			js.executeScript("arguments[0].click()", cancelBtn);
		
		}
		

	}

}
