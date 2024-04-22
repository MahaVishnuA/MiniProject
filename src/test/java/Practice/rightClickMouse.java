package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rightClickMouse {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		
		WebElement element = driver.findElement(By.xpath("//span[@class = 'context-menu-one btn btn-neutral']"));
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}

}
