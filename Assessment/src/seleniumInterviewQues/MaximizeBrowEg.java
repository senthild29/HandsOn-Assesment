package seleniumInterviewQues;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class MaximizeBrowEg {

	@Test
	public void maxbrow() throws AWTException  {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");

		// Method# 1 Using ChromeOptions
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		//WebDriver driver = new ChromeDriver(option);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.google.co.in/");

		// Method# 2 driver.manage().window().maximize();

		// Method# 3 using dimension class 
		Dimension dimen = new Dimension(1920,1080); 
		driver.manage().window().setSize(dimen);

		// Method# 4 Using Robot Class 
		Robot act = new Robot();
		act.keyPress(KeyEvent.VK_ALT); act.keyPress(KeyEvent.VK_SPACE);
		act.keyPress(KeyEvent.VK_X); act.keyRelease(KeyEvent.VK_X);
		act.keyRelease(KeyEvent.VK_SPACE); act.keyRelease(KeyEvent.VK_ALT);

	}

}
