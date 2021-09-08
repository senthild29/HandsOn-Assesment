package seleniumInterviewQues;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ImplicitWaitEg {

	 FileInputStream ConfigFile;
	 Properties getFile;
	 WebDriver driver;
	
	 @Test
 public void OpenBrow() throws IOException {
	 
	 ConfigFile = new FileInputStream("ConfigFile.properties");
	 getFile = new Properties();
	 
	 getFile.load(ConfigFile);
	String BrowProp =  getFile.getProperty("BrowserProperty");
	String BrowLoc = getFile.getProperty("BrowserLocation");
	
	System.setProperty(BrowProp, BrowLoc);
	driver = new ChromeDriver();
	driver.navigate().to("https://www.seleniumeasy.com/test/");
	
	}
	 
	 @AfterTest
	 public void ImpWait() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement pop = driver.findElement(By.xpath("//a[text()='No, thanks!']"));
			pop.click();
	 }
	
}
