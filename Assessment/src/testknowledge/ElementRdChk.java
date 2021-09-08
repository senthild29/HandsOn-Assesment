package testknowledge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.RdChk;

public class ElementRdChk {

	@Test
	public void OpenBrowserRadioAndCheckBox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		PageFactory.initElements(driver, RdChk.class);

		//Radio Button Operations
		RdChk.RadioHome.click();

		boolean rd1  = RdChk.RdBtn1.isSelected();
		boolean rd2 = RdChk.RdBtn2.isSelected();

		System.out.println("Does Radio button 1 is checked by Default : "+rd1);
		System.out.println("Does Radio button 2 is checked by Default : "+rd2);

		driver.navigate().back();
		Thread.sleep(2000);

		//CheckBox Operations
		//Selecting languages known
		RdChk.ChkBoxHome.click();
		RdChk.Chkbk1.click();
		RdChk.Chkbk2.click();
		Thread.sleep(2000);

		//Finding Check box is selected by default
		boolean chk3 = RdChk.Chkbk3.isSelected();
		System.out.println("Does this check box is selected by Default : "+chk3);

		//De-selecting checked box
		if(RdChk.Chkbk4.isSelected()){
			RdChk.Chkbk4.click();
		}

		if(RdChk.Chkbk5.isSelected()) {
			RdChk.Chkbk5.click();
		}

		Thread.sleep(2000);

		driver.navigate().back();
		driver.quit();

	}

}
