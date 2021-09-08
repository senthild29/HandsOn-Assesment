package testknowledge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoPopulate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olx.in/");

		//Getting default text inside text box
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/div/div/div[2]/div/form/fieldset/div/input"));
		String gettext = searchbox.getAttribute("placeholder");
		System.out.println("Text inside the text box is : "+gettext);

		// Searching for Maruti
		searchbox.sendKeys("Maruti");
		Thread.sleep(3000);

		//Storing all the list of items for Maruti
		List<WebElement> listofitems = driver.findElements(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/div/div/div[2]/div/form/ul/li"));
		System.out.println("List of items in : "+listofitems.size());

		//Using for each loop to identify our item in the list and clicking the same
		for (WebElement webElement : listofitems) {
			if(webElement.getText().equals("maruti suzuki")) {
				webElement.click();
				break;
			}

		}

	}

}
