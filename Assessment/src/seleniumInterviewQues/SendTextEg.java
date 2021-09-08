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

public class SendTextEg {
	
	@Test
	public void InputText() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");

		WebElement TxtBox = driver.findElement(By.name("q"));
		
		//Using Javascript Executor
		// Method# 1
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		//exec.executeScript("arguments[0].value='chennai' ", TxtBox);
		
		//Method# 2
		//exec.executeScript("document.getElementsByName('q')[0].value='chennai' ");
		
		// Using Robot Class
		driver.switchTo().activeElement();
		Robot act = new Robot();
		act.keyPress(KeyEvent.VK_H);
		act.keyRelease(KeyEvent.VK_H);
		act.keyPress(KeyEvent.VK_I);
		act.keyRelease(KeyEvent.VK_I);
	}

}
