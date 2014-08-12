package selenium.helpshift.UILib;

import org.openqa.selenium.WebElement;

import selenium.helpshift.Intilializer.Globals;
import selenium.helpshift.UIElements.UIFunctions;

/**This class serves the purpose of a repository of the Main Page elements. It reads the identifiers from ElementIdentifiers class
 * file, searches the elements based on the specified identifier and maintains the information of all the elements/objects available on the 
 * Main Page.
 * @author nil
 *
 */
public class MainPage {
	static UIFunctions uiObj=new UIFunctions();

	public static WebElement contactUsButton = null;
	public static WebElement successMsgForContactusForm=null;
	
	static
	{
		findMainPageElements();
	}
	
	/** Searches the web elements on the Main Page, based on the specified identifier and stores its information in the WebElements variables.
	 * 
	 */
	private static void findMainPageElements()
	{
		contactUsButton=uiObj.searchElement(Globals.Bylocator.id.name(), ElementIdentifiers.contactUsButtonId);
		successMsgForContactusForm=uiObj.searchElement(Globals.Bylocator.xpath.name(), ElementIdentifiers.ContactusMsgXpath);
	}
}
