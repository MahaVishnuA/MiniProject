package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.toolsqa.com/selenium-training/#enroll-form");
		//select tag
		//I.DropDown having select tag in DOM
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"country\"]"));
//		Select drop = new Select(element);
		//1.selecting the option from the dropdown
		//drop.selectByVisibleText("India");
		//drop.selectByValue("34");//use of a value attribute
		//drop.selectByIndex(3);//use of the index position of the list
		
		//2.find total options 
//		 List<WebElement>options  = drop.getOptions();
//		 System.out.println("Total no of options in the list: "+options.size());
//		 
		 //3.print all webElements
//		 for(WebElement dropf:options) {
//			 System.out.println(dropf.getText());
//		 }
		
		 //III. Auto suggest dropdown (dynamic)
		 
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li"));
		
		
		
	}

}
