package testJavaBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingConfigFileAndPropConfigurator {

	//Define driver outside of method, so that it can be used in multiple methods()
	WebDriver driver;

	//Define FileInputSteam class to refer the ConfigFile to our script
	FileInputStream getFile;

	//Define Properties class to load and read the properties of ConfigFile
	Properties getFileProp;

	//Created object for Logger using Factory design pattern(without new Keyword)
	Logger getLog  = Logger.getLogger(UsingConfigFileAndPropConfigurator.class);

	@BeforeSuite
	public void OpenBrowser() throws IOException {

		getFile = new FileInputStream("ConfigFile.properties");

		getFileProp = new Properties();

		getFileProp.load(getFile);

		String getBrowser = 	getFileProp.getProperty("Browser");
		String getBrowProp = getFileProp.getProperty("BrowserProperty");
		String getBrowPath = getFileProp.getProperty("BrowserLocation");

		if(getBrowser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty(getBrowProp, getBrowPath);
			driver = new ChromeDriver();
		}

	}

	@Test
	public void OpenGoogleSite() throws InterruptedException {
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(1000);

		PropertyConfigurator.configure("FileLog.properties");

		getLog.info("Google Site has been Opened successfully");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();

		PropertyConfigurator.configure("FileLog.properties");

		getLog.info("Browser has been closed");
	}

}


