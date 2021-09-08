package seleniumInterviewQues;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DiffWaysEnterKeys {

	@Test
	public void InputEnterKey() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");

		WebElement TxtBox = driver.findElement(By.name("q"));

		//Method# 1 Using sendKeys.
		TxtBox.sendKeys("chennai city"+Keys.ENTER);
		

		//Method# 2 Using Submit()
		TxtBox.sendKeys("chennai city");
		TxtBox.submit();

		//Method# 3 Using \n
		TxtBox.sendKeys("Chennai City \n");

		//MEthod# 4 Using Robot Class
		TxtBox.sendKeys("Chennai City");
		Robot ent = new Robot();

		ent.keyPress(KeyEvent.VK_ENTER);
		ent.keyRelease(KeyEvent.VK_ENTER);
	}

}
