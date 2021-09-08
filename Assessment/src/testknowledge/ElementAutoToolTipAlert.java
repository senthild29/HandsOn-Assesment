package testknowledge;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.AutoCompToolTip;

public class ElementAutoToolTipAlert {
	
	@Test
	public void OpenBrowserAutoToolTip() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, AutoCompToolTip.class);
		
		//Auto Completion 
		AutoCompToolTip.AutoCompleteHome.click();
		
		
		AutoCompToolTip.TextBox.sendKeys("a");
		Thread.sleep(2000);
		
		List<WebElement> iterableitems = AutoCompToolTip.ListofItems;
		
		for (WebElement iterable_element : iterableitems) {
			if(iterable_element.getText().equals("SOAP")) {
				iterable_element.click();
				break;
			}
			
		}				
		Thread.sleep(1000);
		driver.navigate().back();
		
		//Auto completion tool tip
		AutoCompToolTip.ToolTipHome.click();
		
		String tooltip = AutoCompToolTip.GetToolTip.getAttribute("title");
		System.out.println("Tool tip of text box is : "+tooltip);
		driver.navigate().back();
		
		//Alert Box Home
		AutoCompToolTip.AlertHome.click();
		
		//Alert Box Click
		AutoCompToolTip.AlertBox.click();
		Alert alertbox = driver.switchTo().alert();
		alertbox.accept();
		Thread.sleep(1000);
		
		//Confirm Box Click
		AutoCompToolTip.ConfirmBox.click();
		Alert ConfrmBox = driver.switchTo().alert();
		ConfrmBox.dismiss();
		Thread.sleep(1000);
		
		//Prompt Box Click
		AutoCompToolTip.PromptBox.click();
		Alert PrmptBox = driver.switchTo().alert();
		PrmptBox.sendKeys("Hello World");
		PrmptBox.accept();
		Thread.sleep(1000);
		
		driver.navigate().back();
		driver.quit();
	}

}
