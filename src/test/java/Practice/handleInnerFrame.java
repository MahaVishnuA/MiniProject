package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleInnerFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		//frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("33333");
		//innerFrame
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div#i5>div.vd3tt:nth-child(3)>div.AB7Lab")).click();
		driver.switchTo().defaultContent();//when we are in the inner frame this method use to go to the main web page
		
		
		
	}

}
