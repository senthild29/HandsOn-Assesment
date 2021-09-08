package seleniumInterviewQues;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RefreshBrowEg {

	@Test
	public void RefreBrow() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.in/");
		
		WebElement TxtBox = driver.findElement(By.id("twotabsearchtextbox"));
		TxtBox.sendKeys("samsung m31");
		
		//Method# 1 Using navigate().refresh()
		//driver.navigate().refresh();
		
		//Method# 2 Using driver.getCurrentURL();
	//	driver.get(driver.getCurrentUrl());
		
		//Method# 3 Using Robot Class
		/*
		 * Robot refr = new Robot(); refr.keyPress(KeyEvent.VK_F5);
		 * refr.keyRelease(KeyEvent.VK_F5);
		 */
		
		//Method# 4 Using JavaScript
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		exec.executeScript("location.reload()"); //history.go(0)
		
		
		
	}
	
	
}
