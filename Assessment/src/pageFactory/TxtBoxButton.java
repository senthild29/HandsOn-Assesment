package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TxtBoxButton {
	
	@FindBy(xpath = "//*[text()='Edit']/following-sibling::*")
	public static WebElement EditHome;
	
	@FindBy(xpath = "//input[@type = 'text'][@disabled = 'true']")
	public static WebElement ChkEnabled;
	
	@FindBy(xpath = "//*[text()='Button']/following-sibling::*")
	public static WebElement BtnHome;
	
	@FindBy(xpath = "//*[text()='Get Position']")
	public static WebElement BtnPos;
	
	@FindBy(id = "size")
	public static WebElement BtnSize;
	
	}
