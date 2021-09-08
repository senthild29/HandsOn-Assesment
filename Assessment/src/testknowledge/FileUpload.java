package testknowledge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://easyupload.io/");
		
		Thread.sleep(3000);
		
		WebElement clickupload = driver.findElement(By.className("dz-button"));
				//xpath("//*[@id=\"dropzone\"]/div/button"));
		clickupload.click();
		
		//F:\Senthil\Testing\TestNG_XML.txt
		
		StringSelection convtext = new StringSelection("F:\\Senthil\\Testing\\TestNG_XML.txt");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(convtext, null);
		
		Thread.sleep(3000);
		Robot actionrobot = new Robot();
		
		actionrobot.keyPress(KeyEvent.VK_CONTROL);
		actionrobot.keyPress(KeyEvent.VK_V);
		
		actionrobot.keyRelease(KeyEvent.VK_V);
		actionrobot.keyRelease(KeyEvent.VK_CONTROL);
		
		
	}

}
