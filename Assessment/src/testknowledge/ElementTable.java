package testknowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageFactory.DynamicTables;

public class ElementTable {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowserTable() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();
		
	}

	@Test
	public void DynamicTable() throws InterruptedException {
		
		PageFactory.initElements(driver, DynamicTables.class);

		//Table Home
		DynamicTables.TableHome.click();

		//Calculating no of cols in table
		System.out.println("No of Columns in this table : "+DynamicTables.ColCount.size());

		//Calculating no of rows in table
		System.out.println("No of Rows in this table : "+DynamicTables.RowCount.size());

		//Getting Progress value of interact elements
		System.out.println("Progress Valu of Learn to interact with Elements : "+DynamicTables.ProgValue.getText());

		//Getting all values under Progress Column as Integer
		List<Integer> AllValues = new ArrayList<Integer>();

		for (WebElement WebElement : DynamicTables.ProgAllValues) {
			String getString = WebElement.getText().replace("%", "");
			AllValues.add(Integer.parseInt(getString));				
		}
		System.out.println("List of Values under Progress Column : "+AllValues);

		int smallvalue = Collections.min(AllValues);

		System.out.println("Minimum value under Progress Column is : "+smallvalue);

		String ConvertIntegerToString = Integer.toString(smallvalue)+"%";

		// Xpath we need to write in code //*[text()='30%']/following::input[1]
		String findXPath = "//*[text()='"+ConvertIntegerToString+"']/following::input[1]";

		System.out.println(findXPath);

		DynamicTables.ClickCheckbox.click();
       Thread.sleep(2000);
       
       driver.navigate().back();

	}
	
	//Creating new method to interact with dynamic table and sort data
	//@Test(dependsOnMethods = "DynamicTable")
	@AfterTest
	public void SortTableData() {
		//Clicking home page of Dynamic table
		DynamicTables.SortTableHome.click();
		
		//Getting all values and storing in List<WebElement>
		List<String> ActualOrder = new ArrayList<String>();
		
		for (WebElement WebElement : DynamicTables.NameDefaultOrder) {
			String getNameColValues = WebElement.getText();
			ActualOrder.add(getNameColValues);			
		}
		
		Collections.sort(ActualOrder);
		System.out.println("Name Column Values Before Sorting : "+ActualOrder);
		
		DynamicTables.NameCol.click();
		
		List<String> AsecOrder = new ArrayList<String>();
		
		for (WebElement WebElement : DynamicTables.NameAsecOrder) {
			String AsecOrdList = WebElement.getText();
			AsecOrder.add(AsecOrdList);
					}
		System.out.println("Name Column Values after Sorting : "+AsecOrder);
	  Assert.assertEquals(ActualOrder, AsecOrder);
	  System.out.println("Both values are matched");
	  driver.quit();
	
	}
	}
