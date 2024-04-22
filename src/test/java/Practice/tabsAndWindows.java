package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tabsAndWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']/div/div[2]")).click();
//		String name = driver.findElement(By.id("mectrl_currentAccount_primary")).getText();
//		String email = driver.findElement(By.id("mectrl_currentAccount_secondary")).getText();
//		WebElement viewAccount = driver.findElement(By.id("mectrl_viewAccount"));
		
		
		
//		driver.get("https://text-compare.com/");
//		
//		//open new Tab
//		//driver.switchTo().newWindow(WindowType.TAB);
//		//open another window
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.get("https://www.google.com/");
		
		
		
		//driver.manage().window().maximize();

	}

}
