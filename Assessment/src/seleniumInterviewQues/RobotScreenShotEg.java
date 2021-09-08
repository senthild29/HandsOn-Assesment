package seleniumInterviewQues;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RobotScreenShotEg {
	
	WebDriver driver;
	
	@Test
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://www.leafground.com/pages/table.html");
				
	}
	
	@AfterMethod
	public void RobotClassEg() throws AWTException, IOException {
		
		Robot screen = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage getScreenShot = screen.createScreenCapture(rect);
		
		File PasteScreenShot = new File("C:\\Users\\Senthil\\Downloads\\RobotScreenShot.jpg");
		ImageIO.write(getScreenShot, "jpg", PasteScreenShot);
	}
	
	@AfterTest
	public void CloseBrow() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

}
