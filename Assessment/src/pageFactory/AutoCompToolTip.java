package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompToolTip {
	
	@FindBy(xpath = "//*[text()='Auto Complete']/following-sibling::*")
	public static WebElement AutoCompleteHome;
	
	@FindBy(id = "tags")
	public static WebElement TextBox;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li")
	public static List<WebElement> ListofItems;
	
	@FindBy(xpath = "//*[text()='Tool Tip']/following-sibling::*")
	public static WebElement ToolTipHome;
	
	@FindBy(id="age")
	public static WebElement GetToolTip;
	
	@FindBy(xpath = "//*[text()='Alert']/following-sibling::*")
	public static WebElement AlertHome;
	
	@FindBy(xpath = "//*[text()='Alert Box']")
	public static WebElement AlertBox;
	
	@FindBy(xpath = "//*[text()='Confirm Box']")
	public static WebElement ConfirmBox;
	
	@FindBy(xpath = "//*[text()='Prompt Box']")
	public static WebElement PromptBox;
	
}
