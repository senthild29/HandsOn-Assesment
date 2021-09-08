package seleniumInterviewQues;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileHandlerFileUtilsScreenShotEg {
	
	WebDriver driver;

	@Test
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.leafground.com/pages/table.html");
		
		
		}
	
	@AfterMethod
	public void ScreenShot() throws IOException {
		TakesScreenshot Screen = (TakesScreenshot) driver;
		File GetScreenShot = Screen.getScreenshotAs(OutputType.FILE);
		
		File PasteScreenShot = new File("C:\\Users\\Senthil\\Downloads\\FileUtils.jpg");
	//	FileHandler.copy(GetScreenShot, PasteScreenShot);
		FileUtils.copyFile(GetScreenShot, PasteScreenShot);
	}
	
@AfterTest
	public void CloseBrow() {
		driver.quit();
	}
}
