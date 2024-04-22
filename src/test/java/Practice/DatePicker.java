package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);//switch to frame
		
		//approach 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/15/2022");//mm/dd/yyyy
		
		//approach 2 for future date and past date
		
		String year = "2022";
		String month = "March";
		String date = "23";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//select month and year
		while(true) {
			String mon = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			
		}
		//select date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt:allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		//different type of date picker
		
		
		
	}

}
