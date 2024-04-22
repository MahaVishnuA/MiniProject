package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement source1 = driver.findElement(By.xpath("//*[@id=\"box6\"]"));
		WebElement dest1 = driver.findElement(By.xpath("//*[@id=\"box106\"]"));
		act.dragAndDrop(source1, dest1).perform();
		WebElement source2 = driver.findElement(By.xpath("//*[@id=\"box3\"]"));
		WebElement dest2 = driver.findElement(By.xpath("//*[@id=\"box103\"]"));
		
		act.dragAndDrop(source2, dest2).perform();
		
		
	}

}
