package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		//1. driver.switchTo().frame(name/id)
		//in this website, 3 iframes are there,
		//by name; 1. packageListFrame, 2. packageFrame, 3. classFrame
		//so we need to change the frames while clicking the options. then we put these methods...
		//click chrome
				driver.switchTo().frame("packageListFrame");
				driver.findElement(By.linkText("org.openqa.selenium.chrome")).click();
				
				driver.switchTo().defaultContent();//if we dont use this , we can get the NoSuchFrameException .
				
				//click ChromeDriverService
				driver.switchTo().frame("packageFrame");
				driver.findElement(By.linkText("ChromeDriverService")).click();
				
				driver.switchTo().defaultContent();
				
				//click 
				driver.switchTo().frame("classFrame");
				driver.findElement(By.linkText("CHROME_DRIVER_DISABLE_BUILD_CHECK")).click();
		
				//2.driver.switchTo().frame(WebElement)
		
		//3.driver.swithTo().frame(index)
		
		
		
		
		
		
	}

}
