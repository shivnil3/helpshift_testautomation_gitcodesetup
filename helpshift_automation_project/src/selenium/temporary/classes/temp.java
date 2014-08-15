package selenium.helpshift.uilib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.globals.Globals;
import selenium.helpshift.uiFunctions.UIFunctions;

/**
 * This class serves the purpose of a repository of the Main Page elements. It
 * reads the identifiers from ElementIdentifiers class file, searches the
 * elements based on the specified identifier and maintains the information of
 * all the elements/objects available on the Main Page.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class MainPage {

	UIFunctions uiObj;
	public WebElement contactUsButton = null;
	public WebElement successMsgForContactusForm = null;

	public MainPage(WebDriver driver) {
		uiObj = new UIFunctions(driver);
		findMainPageElements();
	}

	/**
	 * Tries to search and waits for specified time until the object/element is
	 * available. Returns the WebElement that is found.
	 * 
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElementAfterWait
	 */
	public WebElement waitAndSearchElement(String byLocator, String locatorValue) {
		wait = new WebDriverWait(browserDriver, AutoConfigs.waitTime);
		uiElementAfterWait = (WebElement) wait.until(ExpectedConditions.
				visibilityOf(searchElement(byLocator, locatorValue)));
		return uiElementAfterWait;

	}

	/**
	 * Searches the web elements on the Main Page, based on the specified
	 * identifier and stores its information in the WebElements variables.
	 * 
	 */
	private void findMainPageElements() {
		contactUsButton = uiObj.searchElement(Globals.Bylocator.id.name(),
				ElementIdentifiers.contactUsButtonId);
		successMsgForContactusForm = uiObj.searchElement(
				Globals.Bylocator.xpath.name(),
				ElementIdentifiers.ContactusMsgXpath);
	}
	
	public WebElement getcontactUsButton()
	{
		
	}
}
