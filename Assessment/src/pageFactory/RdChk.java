package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class RdChk {
	
	@FindBy(xpath = "//*[text()='Radio Button']/following-sibling::*")
	public static WebElement RadioHome;
	
	@FindBy(xpath = "//*[@for='Unchecked']/child::*")
	public static WebElement RdBtn1;
	
	@FindBy(xpath = "//*[@for='Checked']/child::*")
	public static WebElement RdBtn2;
	
	@FindBy(xpath = "//*[text()='Checkbox']/following-sibling::*")
	public static WebElement ChkBoxHome;
	
	@FindBy(xpath = "//*[text()='Select the languages that you know?']/following::input[1]")
	public static WebElement Chkbk1;
	
	@FindBy(xpath = "//*[text()='Select the languages that you know?']/following::input[3]")
	public static WebElement Chkbk2;
	
	@FindBy(xpath = "//*[text()='Confirm Selenium is checked']/following::input[1]")
	public static WebElement Chkbk3;
	
	@FindBy(xpath = "//*[text()='DeSelect only checked']/following::input[1]")
	public static WebElement Chkbk4;
	
	@FindBy(xpath = "//*[text()='DeSelect only checked']/following::input[2]")
	public static WebElement Chkbk5;
	
	
	
	

}
