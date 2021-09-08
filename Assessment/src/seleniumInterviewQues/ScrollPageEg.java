package seleniumInterviewQues;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollPageEg {

	@Test
	public void ScrollEg() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		
		//Scenario# 3 Scroll down to specific element 
		WebElement news = driver.findElement(By.linkText("Wikinews"));
		
		//Using JavascriptExecutor
		//Scenario# 1 Scroll down to random position and scroll up 
		JavascriptExecutor exect = (JavascriptExecutor)driver;
		exect.executeScript("arguments[0].scrollIntoView(true)", news);
		/*
		 * exect.executeScript("window.scroll(0, 490)"); Thread.sleep(2000);
		 * exect.executeScript("window.scroll(0, -490)");
		 */
		
		//Scenario# 2 Scroll down to bottom of page and scroll up to top
		/*
		 * exect.executeScript("window.scroll(0,document.body.scrollHeight)");
		 * Thread.sleep(2000); exect.executeScript("window.scroll(0,0)");
		 */
		

		
		
	}
	
}
