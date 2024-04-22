package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hadlingSliderElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		//min slider
		WebElement min = driver.findElement(By.xpath("//span[1]"));
		System.out.println(min.getLocation());//current Location of the element
		//WebElement max = driver.findElement(By.xpath(""));
		act.dragAndDropBy(min, 125, 125).perform();
		System.out.println(min.getLocation());//after moving
		
		
		//max slider
		WebElement max = driver.findElement(By.xpath("//span[2]"));
		System.out.println(max.getLocation());//current Location of the element
		//WebElement max = driver.findElement(By.xpath(""));
		act.dragAndDropBy(max, -125, 125).perform();
		System.out.println(max.getLocation());//after moving
		
		
	}

}
