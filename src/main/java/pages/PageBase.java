package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver; 
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	//constructor
	public PageBase (WebDriver driver) 

	{
		PageFactory.initElements(driver, this); 
	}


	public static void ClickButton(WebElement button) {
		button.click();
	}

	public static void ClearElement(WebElement text) {
		text.clear();
	}

	public static void SetText(WebElement text, String value) {
		text.sendKeys(value);
	}

	public static void selectvalue(WebElement text, String value) {

		Select Options = new Select(text);
		Options.selectByValue(value);
	}
	
	public void scrolToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}

}
