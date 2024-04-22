package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingPageJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		JavascriptExecutor js = driver;
		//scroll page by pixel
//		js.executeScript("window.scrollBy(0,3000)", "");
//		System.out.println(js.executeScript("return window.pageYOffset;"));//3000
//		
		//scroll down the page till the element  is present
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[1]/tbody/tr[35]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView()", element1);
		System.out.println(js.executeScript("return window.pageYOffset;"));
//		
		//scroll down end of the page
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		System.out.println(js.executeScript("return window.pageYOffset;"));
		//Thread.sleep(3000);
		//from bottom go back to the initial position
		//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
	}

}
