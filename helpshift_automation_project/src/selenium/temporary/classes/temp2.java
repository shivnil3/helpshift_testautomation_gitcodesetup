package selenium.helpshift.uilib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.helpshift.globals.Globals;
import selenium.helpshift.uiFunctions.UIFunctions;

/**
 * This class serves the purpose of a repository of the Contact us form
 * elements. It reads the identifiers from ElementIdentifiers class file,
 * searches the elements based on the specified identifier and maintains the
 * information of all the elements/objects available on the Contact us form.
 * 
 * @author Nilesh Awasthey
 * 
 */

public class ContactUsForm {

	static UIFunctions uiObj;
	
	public WebElement contactForm = null;
	public WebElement contactNameTextBox = null;
	public WebElement contactEmailTextBox = null;
	public WebElement contactIssueDetailsTextArea = null;
	public WebElement contactSubmitbutton = null;
	public WebElement validationMsgcontactEmailTextBox = null;
	public WebElement validationMsgcontactIssueTextArea = null;

	/** constructor for this class
	 * @param driver
	 */
	public ContactUsForm(WebDriver driver){
		uiObj=new UIFunctions(driver); 
		findContactFormElements();
	}

	/**
	 * Searches the web elements on the Contact us form, based on the specified
	 * identifier and stores its information in the WebElements variables.
	 * 
	 */
	private void findContactFormElements() {
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
