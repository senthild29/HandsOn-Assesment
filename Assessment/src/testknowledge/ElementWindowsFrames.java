package testknowledge;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageFactory.WindowsAndFrames;

public class ElementWindowsFrames {

	WebDriver driver;

	@Test
	public void OpenBrowserWindowsAndFrames() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();

		PageFactory.initElements(driver, WindowsAndFrames.class);

		//Frames
		WindowsAndFrames.FramesHome.click();

		//Switching to Frame
		driver.switchTo().frame(0);

		//Clicking button inside frame1
		WindowsAndFrames.Frame1.click();

		//Coming out of frame
		driver.switchTo().defaultContent();

		//Swithcing to Frame
		driver.switchTo().frame(1);
		//Switching to Frame 2
		driver.switchTo().frame("frame2");

		//Clicking button inside frame2
		WindowsAndFrames.Frame2.click();

		//Coming out of frame
		driver.switchTo().defaultContent();

		//Getting no of Frames in a webpage
		System.out.println("No of Frames in this page : "+WindowsAndFrames.NoofFrames.size());

		driver.navigate().back();
		Thread.sleep(2000);
	}

	@AfterTest
	public void OpenWindows() throws InterruptedException {


		//Windows Pop up Home page
		WindowsAndFrames.WindowsHome.click();
		String OldWindow = driver.getWindowHandle();

		//Click button to open home page pop-up
		WindowsAndFrames.HomePgBtn.click();
		Set<String> NewWindow = driver.getWindowHandles();

		for (String Popup : NewWindow) {
			driver.switchTo().window(Popup);			
		}
		driver.close();

		//Switching to Old window
		driver.switchTo().window(OldWindow);

		//Clicking on button to open multiple windows and closing newly opened window
		WindowsAndFrames.MultiPgBtn.click();
		Set<String> popupWindow = driver.getWindowHandles();		
		System.out.println("No of Pop up Windows Opened : "+popupWindow.size());
		
		for (String popWindow : popupWindow) {
			if(!popWindow.equals(OldWindow)) {
				driver.switchTo().window(popWindow);
				driver.close();
			}

		}
		driver.switchTo().window(OldWindow);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.quit();

	}

}
