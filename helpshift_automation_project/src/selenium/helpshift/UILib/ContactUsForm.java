/**
 * 
 */
package selenium.helpshift.UILib;

import org.openqa.selenium.WebElement;

import selenium.helpshift.Intilializer.Globals;
import selenium.helpshift.UIElements.UIFunctions;

/**
 * This class serves the purpose of a repository of the Contact us form
 * elements. It reads the identifiers from ElementIdentifiers class file,
 * searches the elements based on the specified identifier and maintains the
 * information of all the elements/objects available on the Contact us form.
 * 
 * @author nil
 * 
 */

public class ContactUsForm {

	static UIFunctions uiObj = new UIFunctions();

	public static WebElement contactForm = null;
	public static WebElement contactNameTextBox = null;
	public static WebElement contactEmailTextBox = null;
	public static WebElement contactIssueDetailsTextArea = null;
	public static WebElement contactSubmitbutton = null;
	public static WebElement validationMsgcontactEmailTextBox = null;
	public static WebElement validationMsgcontactIssueTextArea = null;

	static {
		findContactFormElements();
	}

	/**
	 * Searches the web elements on the Contact us form, based on the specified
	 * identifier and stores its information in the WebElements variables.
	 * 
	 */
	private static void findContactFormElements() {
		contactForm = uiObj.waitAndSearchElement(Globals.Bylocator.cssSelector
				.name(), ElementIdentifiers.contactFormCssSelector);
		contactNameTextBox = uiObj.searchElementInParentElement(contactForm,
				Globals.Bylocator.cssSelector.name(),
				ElementIdentifiers.contactNameTextBoxCssSelector);
		contactEmailTextBox = uiObj.searchElementInParentElement(contactForm,
				Globals.Bylocator.cssSelector.name(),
				ElementIdentifiers.contactEmailTextBoxCssSelector);
		contactIssueDetailsTextArea = uiObj.searchElementInParentElement(
				contactForm, Globals.Bylocator.cssSelector.name(),
				ElementIdentifiers.contactIssueDetailsTextAreaCssSelector);
		contactSubmitbutton = uiObj.searchElementInParentElement(contactForm,
				Globals.Bylocator.cssSelector.name(),
				ElementIdentifiers.contactSubmitButtonCssSelector);
		validationMsgcontactEmailTextBox = uiObj.searchElementInParentElement(
				contactForm, Globals.Bylocator.xpath.name(),
				ElementIdentifiers.validationMsgContactEmailXpath);
		validationMsgcontactIssueTextArea = uiObj.searchElementInParentElement(
				contactForm, Globals.Bylocator.xpath.name(),
				ElementIdentifiers.validationMsgContactIssueDetailsXpath);
	}
}
