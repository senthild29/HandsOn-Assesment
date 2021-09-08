package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class DragDropSelect {
	
	@FindBy(xpath = "//*[text()='Droppable']/following-sibling::*")
	public static WebElement DragDropHome;

	@FindBy(xpath = "//div[@id='draggable']")
	public static WebElement Drag;
	
	@FindBy(xpath = "//div[@id='droppable']")
	public static WebElement Drop;
	
	@FindBy(xpath = "//*[text()='Selectable']/following::img[1]")
	public static WebElement SelectableHome;
	
	@FindBy(xpath = "//ol[@id='selectable']/li")
	public static List<WebElement> SelectableList;
	
	@FindBy(xpath = "//*[text()='Sortable']/following-sibling::*")
	public static WebElement SortableHome;	
	
	@FindBy(xpath = "//*[@id='sortable']/li")
	public static List<WebElement> SortValues;
	
}
