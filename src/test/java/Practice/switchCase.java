package Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class switchCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.id("O365_MainLink_Me")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("O365_MainLink_Me")).click();
		
		WebElement nam = driver.findElement(By.id("mectrl_currentAccount_primary"));
		myWait.until(ExpectedConditions.visibilityOf(nam));

		String name = nam.getText();
		WebElement ema = driver.findElement(By.id("mectrl_currentAccount_secondary"));
		myWait.until(ExpectedConditions.visibilityOf(ema));
		String email = ema.getText();
		System.out.println(name+"   "+email);
		//Validate the Around cognizant news sections is displayed or not
		Actions act  = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0\"]/div/div/div/p/span/strong"));
	   // myWait.until(ExpectedConditions.visibilityOf(ele2));
	    if(ele2.getText().equals("Around Cognizant")) {
	    	System.out.println("Test Passed");
	    }
	    else {
	    	System.out.println("Test Failed");
	    }
	    
	    //driver.findElement(By.xpath("//*[@id='c24ff0ed-b166-42e5-b7d5-57c9a9e573cb']/div/div/div/p/a")).click();
	    Thread.sleep(5000);
	    //WebDriverWait myWait  = new WebDriverWait(driver, Duration.ofSeconds(10));
	    List<WebElement> list = myWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='news_text_title']")));
	    //List<WebElement> list = driver.findElements(By.xpath("//*[@id='news_text_title']"));
		//List<String> listStr = new ArrayList<String>();
	    
		for(WebElement e : list) {
			//listStr.add(e.getText());
			myWait.until(ExpectedConditions.visibilityOf(e));
			
			js.executeScript("arguments[0].scrollIntoView()",e);
			Thread.sleep(3000);
			String header = e.getText();
			System.out.println("The Header is: "+header);
			String toolTip = e.getAttribute("title");
			System.out.println("   and Tool Tip is: "+toolTip);
			
		}

        List<WebElement> el  = driver.findElements(By.xpath("//*[@id=\"spPageChromeAppDiv\"]/div/div[2]/div[3]/section/article/div//div[2]//div[3]/div[3]//div[2]/div[2]/div/div[1]/span[2]"));

		driver.close();
		
		}

	}