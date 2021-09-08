package testknowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.LinkImage;
import pageFactory.TxtBoxButton;

public class ElementTxtBtnLnkImg {

	@Test
	public void OpenBrowserTxtBtnLnkImg() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");		
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Passing driver by initiating PageFactory and initElements
		PageFactory.initElements(driver, TxtBoxButton.class);

		//Performing actions on textbox
		TxtBoxButton.EditHome.click();
		boolean txtboxenabled = 	TxtBoxButton.ChkEnabled.isEnabled();
		System.out.println("Does Text Box is enabled : "+txtboxenabled);

		//Coming back to home page
		driver.navigate().back();
		Thread.sleep(2000);

		//Performing actions on Buttons
		TxtBoxButton.BtnHome.click();
		Point btnloc =  TxtBoxButton.BtnPos.getLocation();
		int x =  btnloc.getX();
		int y =  btnloc.getY();
		System.out.println("Coordinates of button is : "+x +" and " +y);

		int h = TxtBoxButton.BtnSize.getSize().getHeight();
		int w = TxtBoxButton.BtnSize.getSize().getWidth();
		System.out.println("Height of the Button is : "+h);
		System.out.println("Width of the Button is : "+w);

		//Coming back to home page
		driver.navigate().back();
		Thread.sleep(2000);

		//Passing driver by initiating PageFactory and initElements
		PageFactory.initElements(driver, LinkImage.class);

		//Performing actions on HyperLinks
		LinkImage.LinkHome.click();
		LinkImage.VerifyLink.click();       
		String title = driver.getTitle();
		if(title.contains("404")) {
			System.out.println("Web Page is Broken Getting : "+title);
		}

		//Coming back to hyperlink home page
		driver.navigate().back();

		//Coming back to  home page
		driver.navigate().back();
		Thread.sleep(2000);

		LinkImage.ImageHome.click();
		LinkImage.BrokenImage.getCssValue("naturalWidth").equals(0);

		System.out.println("Image is Broken");


		//Coming back to hyperlink home page
		driver.navigate().back();
		Thread.sleep(2000);

		//Closing browser
		driver.quit();
	}

}
