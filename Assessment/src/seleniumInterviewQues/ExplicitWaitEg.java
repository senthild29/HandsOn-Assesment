package seleniumInterviewQues;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExplicitWaitEg {

	FileInputStream ConfigFile;
	 Properties getFile;
	 WebDriver driver;
	 
	 @Test
	 public void OpenBrowser() throws IOException {
		 ConfigFile = new FileInputStream("ConfigFile.properties");
		 getFile = new Properties();
		 
		 getFile.load(ConfigFile);
		String BrowProp =  getFile.getProperty("BrowserProperty");
		String BrowLoc = getFile.getProperty("BrowserLocation");
		
		System.setProperty(BrowProp, BrowLoc);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		
		WebElement AlertWait = driver.findElement(By.xpath("//*[text()='Wait for Text Change']"));
		AlertWait.click();
		
	 }
	 
	 @AfterTest
	 public void ExpWait() {
		 WebDriverWait ExpWait = new WebDriverWait(driver, 10);
			WebElement WaitforIt = ExpWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Click ME!']")));
			WaitforIt.click();
			
			Alert handle = driver.switchTo().alert();
			handle.accept();
			
	 }
}
