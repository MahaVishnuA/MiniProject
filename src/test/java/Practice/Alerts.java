package Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.get("https://demoqa.com/alerts");
//        driver.manage().window().maximize();
//        Thread.sleep(4000);
//        //1. using alert only
//        driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
//        //Alert alertWindow = driver.
//        Alert alertWindow = driver.switchTo().alert();
//        		//myWait.until(ExpectedConditions.alertIsPresent());
//        System.out.println(alertWindow.getText());
//        
//        //alertWindow.accept();
//        
//        alertWindow.dismiss();
//        WebElement element = driver.findElement(By.cssSelector("#confirmResult"));
//        System.out.println(element.getText());
//       //2. Using explicit wait
//        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.get("https://demoqa.com/alerts");
//        driver.manage().window().maximize();
//        
//        driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
//        //Alert alertWindow = driver.
//        Alert alertWindow = myWait.until(ExpectedConditions.alertIsPresent());
//        System.out.println(alertWindow.getText());
//        
//        alertWindow.accept();
//        
//        //alertWindow.dismiss();
//        WebElement element = driver.findElement(By.cssSelector("#confirmResult"));
//        System.out.println(element.getText());
//          driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
//          Alert windowAlert = driver.switchTo().alert();
//          System.out.println(windowAlert.getText());
//          
//          windowAlert.sendKeys("Maha Vishnu A");
//          windowAlert.accept();
//          
//          String act = driver.findElement(By.xpath("//*[@id=\"promptResult\"]")).getText();
//          String expect = "You entered hello";
//          if(act.equals(expect)){
//        	  System.out.println("True");
//          }
//          else {
//        	  System.out.println("False");
//          }
        
        //Authenticating pop-up/alert
		//original url = http://the-internet.herokuapp.com/basic_auth
		//afetr injecting username and password: 
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        String text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
        if(text.contains("Congratulations")) {
        	System.out.println("Login successfull");
        }
        else {
        	System.out.println("Login failed");
        }
        
	}

}
