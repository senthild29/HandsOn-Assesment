package testknowledge;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.DragDropSelect;

public class ElementDragSelectSort {

	@Test
	public void OpenBrowserDragSelectSort() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");		
		driver.manage().window().maximize();
		Thread.sleep(2000);

		PageFactory.initElements(driver, DragDropSelect.class);

		//Drag and Drop
		DragDropSelect.DragDropHome.click();

		// Created new action class to perform actions using keyboard or Mouse	
		Actions dd = new Actions(driver);

		dd.dragAndDrop(DragDropSelect.Drag, DragDropSelect.Drop).build().perform();

		Thread.sleep(1000);

		driver.navigate().back();

		//Selectable or multi select
		DragDropSelect.SelectableHome.click();

		//Created new actions class
		Actions multilselect = new Actions(driver);


		multilselect.clickAndHold(DragDropSelect.SelectableList.get(0));
		multilselect.clickAndHold(DragDropSelect.SelectableList.get(1));
		multilselect.clickAndHold(DragDropSelect.SelectableList.get(2)).build().perform();


		Thread.sleep(1000);

		driver.navigate().back();

		//Sortable
		DragDropSelect.SortableHome.click();
		Thread.sleep(2000);
		
		//Created new actions class
		Actions SortData = new Actions(driver);
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(0)).build().perform();
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(1)).build().perform();
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(2)).build().perform();
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(3)).build().perform();
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(4)).build().perform();
	SortData.dragAndDrop(DragDropSelect.SortValues.get(6), DragDropSelect.SortValues.get(5)).build().perform();
		


		//SortData.clickAndHold(DragDropSelect.SortValues.get(0)).moveToElement(DragDropSelect.SortValues.get(6)).
	//	release(DragDropSelect.SortValues.get(0)).build().perform();
		Thread.sleep(2000);

		driver.navigate().back();
		driver.quit();

	}

}
