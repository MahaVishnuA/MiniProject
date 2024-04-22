package Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleBrowserWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		//approach 1 - get window ids
		Set<String> ids = driver.getWindowHandles();
		/*List<String> winIds = new ArrayList<String>(ids);
		String parentId = winIds.get(0);
		String childId = winIds.get(1);
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//div[@class='d-flex web-mwnu-btn']//li[1]//a[1]")).click();*/
		
		//approach 2-looping statement
		for(String winid:ids) {
			String title = driver.switchTo().window(winid).getTitle();
			if(title.equals("OrangeHRM")){
				//driver.findElement(By.xpath("//div[@class='d-flex web-mwnu-btn']//li[1]//a[1]")).click();
				driver.close();
			}
		}
		//closing specific browser windows based on the ids
		//1st = x, 2 -y, 3-z, 4-a, 5-b
//		for(String winid:ids) {
//			String title = driver.switchTo().window(winid).getTitle();
//			if(title.equals("x")||title.equals("a")) {
//				driver.close();
//			}
//		}
		
	}

}
