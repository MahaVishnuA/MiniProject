package MiniProject;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driversetup {
	static WebDriver driver;
	static Excelclass ex = new Excelclass();
	static Properties p =new Properties();
	public static WebDriver getWebDriver() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the browser:\n1. Chrome\n2. Firefox\n3. Edge");
		String browser = sc.next(); 
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\mini.properties");
			p.load(fis);
			fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("baseUrl"));;
			return driver;
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("baseUrl"));
			return driver;
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("baseUrl"));
			return driver;
		}
		else {
			System.out.println("No browser found");
			return driver;
		}
	}
}
