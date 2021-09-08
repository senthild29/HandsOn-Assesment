package testknowledge;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutopopFrames { //Swithing to new windows and Frames

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		driver.get("https://www.icc-cricket.com/media-releases/2061926");
		
		// Storing mainwindow using getWindowHandle()
		String mainwindow = driver.getWindowHandle();
		Thread.sleep(3000);
		/* Identifying total no of frames present in the page
		List<WebElement> noofframes = driver.findElements(By.tagName("iframe"));
		System.out.println("No of Frames in this websipage is : "+noofframes.size());*/

		// Switching to Frame 3, from native browser
		driver.switchTo().frame(3);
		
		// Identifying our web element and clicking on the same to open a new window
		WebElement icclink = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ol/li[2]/div/div[3]/div/a/div/span[1]/span[1]"));
		icclink.click();

		// Storing newly opened and old windows using getWindowHandles()
		Set<String> newwindow = driver.getWindowHandles();

		// Using for each loop moving to new window and closing the same
		for (String popupwindow : newwindow) 
		{
			driver.switchTo().window(popupwindow);
		}

		Thread.sleep(2000);
		driver.close();
		
		// Now switching to main/oldwindow and closing the same
		driver.switchTo().window(mainwindow);
		driver.close();


	}

}
