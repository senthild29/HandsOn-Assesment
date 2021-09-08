package testknowledge;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();

		//Creating own x-path to get the values from Name column		
		List<WebElement> allnames = driver.findElements(By.xpath("//td[2]"));

		//CReating new object ArrayList to store the string values in variable "storenames"
		List<String> storenames = new ArrayList<String>();

		//Uisng for loop to itertate and get name list from Name column
		for (WebElement webElement : allnames) {
			String getnames = webElement.getText();
			storenames.add(getnames);		
		}

		System.out.println("Name List : "+storenames);

		Collections.sort(storenames);

		System.out.println("Names Sorted in Alphabet order :" +storenames);

		Thread.sleep(2000);
		//Identifying Name Column using x-path
		WebElement hdr = driver.findElement(By.xpath("//th[2]"));
		hdr.click();

		//Creating own x-path to get the values from name column
		List<WebElement> allnames2 = driver.findElements(By.xpath("//td[2]"));

		List<String> storenames2 = new ArrayList<String>();

		for (WebElement webElement : allnames2) {
			String getnames2 = webElement.getText();
			storenames2.add(getnames2);
		}
		System.out.println("Name After clikcing on Header Column :"+storenames2);

		/* Now we have taken the "Name" Column values, before and after clicking on header "Name"
    We yet to sort the values stored in "storenames" and "storenames2". It will be done shortly*/
		
		// On Apr-08, using assertions we have compared the values from both the list 

		Assert.assertEquals(storenames, storenames2);
		System.out.println("Values Matched");
		
		driver.close();
	}

}
