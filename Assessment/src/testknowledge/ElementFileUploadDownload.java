package testknowledge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.FileUploadDownload;

public class ElementFileUploadDownload {

	@Test
	public void FileUploadAndDowload() throws InterruptedException, AWTException{
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, FileUploadDownload.class);
		
		//File Upload home
		FileUploadDownload.FileUploadHome.click();
		
		//Clicking File Upload button
		Actions clickbtn = new Actions(driver);
		clickbtn.moveToElement(FileUploadDownload.ClickUpload).click().build().perform();
		Thread.sleep(3000);
		
		//Converting the file available URL to string 
		StringSelection urlpath = new StringSelection("C:\\Users\\Senthil\\Downloads\\testleaf.xlsx");
		
		//Using Toolkit copying the content stored in string selection to be pasted in windows pop-up
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(urlpath, null);
		

		//Switching control from web page to Windows pop-up using Robot class
		Robot handlewindow = new Robot();
		
		//Pasting the copied url to windows pop-up
		handlewindow.keyPress(KeyEvent.VK_CONTROL);
		handlewindow.keyPress(KeyEvent.VK_V);
		
		handlewindow.keyRelease(KeyEvent.VK_V);
		handlewindow.keyRelease(KeyEvent.VK_CONTROL);
		
		handlewindow.keyPress(KeyEvent.VK_ENTER);
		handlewindow.keyRelease(KeyEvent.VK_ENTER);
		
		//Coming back to main window
		driver.navigate().back();
		Thread.sleep(1000);
		
		//Clicking on FileDownload home
		FileUploadDownload.FileDownloadHome.click();
		
		
		//Clicking  link to download text file
		FileUploadDownload.DownloadTxtFile.click();
		Thread.sleep(2000);
		
		//Switching control to windows from web application
		//Creating new object file to locate the download location
		File fileloc = new File("C:\\Users\\Senthil\\Downloads");
		File[] getAllFiles = fileloc.listFiles();
		
		for (File filename : getAllFiles) {
			if(filename.getName().equals("testleaf (1).xlsx")) {
				System.out.println("Your Excel file has been downloaded successfully");
			}
			
		}
		
	driver.quit();
	
	}
	
}
