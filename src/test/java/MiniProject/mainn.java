package MiniProject;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class mainn {
	//static WebDriver driver;
	static WebElement element;
	//static Select select;
	static WebDriver driver;
	Excelclass exc = new Excelclass();
	
	//get the getWebDriver method
	public WebDriver setDriver() {
		driver = Driversetup.getWebDriver();
        driver.manage().window().maximize();
		return driver;
	}
	public List<String> countLinks() {
		//Count the number of links in the google page
		List<WebElement> list1 = new ArrayList<WebElement>();
		list1 = driver.findElements(By.tagName("a"));
		String links = "The no of links present in the google: "+list1.size();
		List<String> linkStr = new ArrayList<String>();
		linkStr.add(links);
		for(WebElement el:list1) {
			linkStr.add(el.getText());
		}
		return linkStr;
	}

	public List<String> getSuggestions() throws IOException{
		//count the suggestions after entering cognizant
		//locating the element
		exc.dataExtract();
		driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys(exc.search);
		List<WebElement> list2 = new ArrayList<WebElement>();
		list2 =driver.findElements(By.xpath("//ul[@role='listbox']/li/div[1]/div[2]/div[1]/div[1]/span"));
		List<String> listStr  = new ArrayList<String>();
		String ss = "The no of search options in the google when entering the Cognizant: "+list2.size();
		listStr.add(ss);
		for(WebElement ex:list2) {
			listStr.add(ex.getText());
		}
		//take a screenshot
		try{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1,new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\ScreenShots\\SearchOptionsScreenShot.png"));
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listStr;
	}
	
	public void clickGoogleSearchButton() {
		//click the google search button
		driver.findElement(By.cssSelector("div.lJ9FBc:nth-child(16) > center:nth-child(2) > input:nth-child(1)")).click();
	}
	public String findResults() {
			//finding the search options displayed as "About XXXXX results"
			String noOfResults = driver.findElement(By.cssSelector("div#result-stats")).getText();
			String[] str = noOfResults.split(" ");
			//take a screenshot
			try{
				File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshot2,new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\ScreenShots\\OptionsScreenShot.png"));
				}
			catch(Exception e) {
				System.out.println(e);
			}
 		
		   return "No of Search options: "+ str[1];
		
	}

	public String newsClick() {
		//Click 'News' in Google
		driver.findElement(By.linkText("News")).click();
		//Count in the console 
		String noOfNews = driver.findElement(By.cssSelector("div#result-stats")).getText();
		String[] str2 = noOfNews.split(" ");
		//take a screenshot
		try{
			File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot3,new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\ScreenShots\\News.png"));
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return "No of Search News options: "+ str2[1];
	}
	public void imagesClick() {
		//Click 'Images' in Google 
		driver.findElement(By.linkText("Images")).click();
		//take a screenshot
		try{
			File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot4,new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\ScreenShots\\Images.png"));
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public String videosClick() {
		//Click 'Videos' in Google
		driver.findElement(By.linkText("Videos")).click();
		String noOfVideos = driver.findElement(By.cssSelector("div#result-stats")).getText();
		String[] str3 = noOfVideos.split(" ");
		//take a screenshot
		try{
			File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot5,new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\ScreenShots\\Videos.png"));
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return "No of Search Videos options: "+ str3[1];
	}
	public void closeBrowser() {
		System.out.println("The code is Executed!!!");
		driver.quit();
	}

	public static void main(String[] args) throws IOException {
		//create an object for Main class
        mainn m = new mainn();
        
        //call setDriver() method
		m.setDriver();
		
		//call countLinks() method
		List<String> linkS = m.countLinks();
		for(String ed:linkS) {
			System.out.println(ed);
		}
		
		//call takeScreenShots() method
		List<String> suggestions = m.getSuggestions();
		for(String ee:suggestions) {
			System.out.println(ee);
		}
		
		//call clickSearchButton() method
		m.clickGoogleSearchButton();
		
		//call findResults() method
		String results = m.findResults();
		System.out.println(results);
		
		//call newsClick() method
		String newS = m.newsClick();
		System.out.println(newS);
		
		//call imagesClick() method
		m.imagesClick();
		
		//call videosClick() method
		String videoS = m.videosClick();
		System.out.println(videoS);
		//write output in a result text file which are in the console using printStream
		try {
			PrintStream ps =new PrintStream(new File("C:\\Users\\2318459\\eclipse-workspace\\Vishnu\\src\\test\\java\\MiniProject\\result.txt"));
			System.setOut(ps);
			for(String ed:linkS) {
				ps.print(ed);
				System.out.println();
			}
			System.out.println();
			for(String ee:suggestions) {
				ps.print(ee);
				System.out.println();
			}
			ps.print(results);
			System.out.println();	
			ps.print(newS);
			System.out.println();
			ps.print(videoS);
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
		m.closeBrowser();
	}
}