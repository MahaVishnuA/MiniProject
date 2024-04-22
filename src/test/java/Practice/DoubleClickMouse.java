package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickMouse {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_onblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement f1 = driver.findElement(By.xpath("//input[@id='field1']"));
		f1.clear();
		f1.sendKeys("Welcome");
		//double click
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		
		WebElement f2 = driver.findElement(By.xpath("//input[@id='field2']"));
		//String copiedText = f2.getText();
		String copiedText = f2.getAttribute("value");
		if(copiedText.equals(f1.getAttribute("value"))) {
			System.out.println("True");
		}
		
		
		//difference between getText and getAttribute
		//getText() --- return inner text of the element
		//getAttribute() --- return value of any attributes 
		
		
		
	}

}
