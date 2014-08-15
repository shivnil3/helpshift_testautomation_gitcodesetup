package selenium.helpshift.uiElementLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.globals.Globals;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiFunctions.ElementIdentifiers;
import selenium.helpshift.uiFunctions.UIFunctions;

/**
 * This class retrieves information of the Main Page elements. It reads the
 * identifiers from ElementIdentifiers class file, searches the elements based
 * on the specified identifier and returns to the calling testcase classes.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class MainPage {

	UIFunctions uiObj;
	private WebElement contactUsButton = null;
	private WebElement successMsgForContactusForm = null;
	private Boolean debugEnabled = AutoConfigs.debugEnabled;
	private String ById = Globals.Bylocator.id.name();
	private String ByCssSelector = Globals.Bylocator.cssSelector.name();
	private String ByClassName = Globals.Bylocator.className.name();
	private String ByLinkText = Globals.Bylocator.linkText.name();
	private String ByPartialLinkText = Globals.Bylocator.partialLinkText.name();
	private String ByName = Globals.Bylocator.name.name();
	private String ByXpath = Globals.Bylocator.xpath.name();
	private String ByTagName = Globals.Bylocator.tagName.name();

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public MainPage(WebDriver driver) {
		uiObj = new UIFunctions(driver);
	}

	/**
	 * Finds and returns the element for Contact us button on the main page
	 * 
	 * @return contactUsButton
	 */
	public WebElement getcontactUsButton() {
		contactUsButton = uiObj.searchElement(ById,
				ElementIdentifiers.contactUsButtonId);
		if (contactUsButton != null) {
			ResultsLogger.logInfo("contactUsButton form was found.");
			if (debugEnabled)
				ResultsLogger.logDebug("contactUsButton found using locator "
						+ ById + " = " + ElementIdentifiers.contactUsButtonId);
		} else
			ResultsLogger.logError("contactUsButton was not found.");

		return contactUsButton;
	}

	/**
	 * Finds and returns the element for confirmation message that appears after
	 * submitting the contact us form.
	 * 
	 * @return successMsgForContactusForm
	 */
	public WebElement getsuccessMsgForContactusForm() {
		successMsgForContactusForm = uiObj.searchElement(ByXpath,
				ElementIdentifiers.contactusMsgXpath);
		if (successMsgForContactusForm != null) {
			ResultsLogger.logInfo("successMsgForContactusForm was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("successMsgForContactusForm found using locator "
								+ ByXpath
								+ " = "
								+ ElementIdentifiers.contactusMsgXpath);
		} else
			ResultsLogger.logError("successMsgForContactusForm was not found.");

		return successMsgForContactusForm;

	}
}
