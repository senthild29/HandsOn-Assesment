package testknowledge;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement button1 = driver.findElement(By.className("btnMouse"));
		//button1.

		//Performing MouseHover using acions class
		Actions hover = new Actions(driver);
		hover.moveToElement(button1).build().perform();
		Thread.sleep(2000);

		//Creating Alert Interface to handle alert pop-up



		//Identifying the list of elements in the dropdown
		List<WebElement> listall = driver.findElements(By.xpath("//*[@id=\"wrapper\"]/div/div[5]/ul/li/ul/li"));
		System.out.println("No of Items in the list :"+listall.size());

		//Creating new object ArrayList to store the items retrieved using for loop
		List<String> names = new ArrayList<String>();

		//Using for loop iterating the items and storing it to variable "names"
		for (WebElement webElement : listall) {
			String getnames = webElement.getText();
			names.add(getnames);
		}
		System.out.println("Item name in the list :"+names);
          
		//Using for loop to click on RPA and handle alert
		for (WebElement webElement : listall) {
			if(webElement.getText().equals("RPA")) {
				webElement.click();
				Alert popup = driver.switchTo().alert();
				popup.accept();
				break;

			}
		}
	}


}


