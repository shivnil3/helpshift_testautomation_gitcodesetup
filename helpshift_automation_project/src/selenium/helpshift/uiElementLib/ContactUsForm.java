package selenium.helpshift.uiElementLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.globals.Globals;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiFunctions.ElementIdentifiers;
import selenium.helpshift.uiFunctions.UIFunctions;

/**
 * This class retrieves the Contact us form elements at runtime. It reads the
 * identifiers from ElementIdentifiers class file, searches the elements based
 * on the specified identifier and returns the element to the calling test case
 * class.
 * 
 * @author Nilesh Awasthey
 * 
 */

public class ContactUsForm {

	UIFunctions uiObj;
	private Boolean debugEnabled = AutoConfigs.debugEnabled;
	private WebElement contactForm = null;
	private WebElement contactNameTextBox = null;
	private WebElement contactEmailTextBox = null;
	private WebElement contactIssueDetailsTextArea = null;
	private WebElement contactSubmitbutton = null;
	private WebElement requiredMsgcontactEmailTextBox = null;
	private WebElement requiredMsgcontactIssueTextArea = null;
	private WebElement validationMsgcontactEmailTextBox = null;

	private WebElement contactUsFormCloseIcon = null;
	private WebElement contactNameLabel = null;
	private WebElement contactEmailLabel = null;
	private WebElement contactIssueDetailsLabel = null;
	private WebElement contactUsHeaderText = null;

	private String ById = Globals.Bylocator.id.name();
	private String ByCssSelector = Globals.Bylocator.cssSelector.name();
	private String ByClassName = Globals.Bylocator.className.name();
	private String ByLinkText = Globals.Bylocator.linkText.name();
	private String ByPartialLinkText = Globals.Bylocator.partialLinkText.name();
	private String ByName = Globals.Bylocator.name.name();
	private String ByXpath = Globals.Bylocator.xpath.name();
	private String ByTagName = Globals.Bylocator.tagName.name();

	/**
	 * constructor for this class
	 * 
	 * @param driver
	 */
	public ContactUsForm(WebDriver driver) {
		uiObj = new UIFunctions(driver);
	}

	/**
	 * Finds and returns the element for the Contact us form
	 * 
	 * @return the contactForm
	 */
	public WebElement getContactForm() {
		contactForm = uiObj.searchElement(ById,
				ElementIdentifiers.contactFormId);
		if (contactForm != null) {
			ResultsLogger.logInfo("Contactus form was found.");
			if (debugEnabled)
				ResultsLogger.logDebug("Contactus form found using locator "
						+ ById + " = " + ElementIdentifiers.contactFormId);
		} else
			ResultsLogger.logError("Contactus form was not found.");
		return contactForm;
	}

	/**
	 * Finds and returns the element for the Name textbox on the Contact us
	 * form.
	 * 
	 * @return the contactNameTextBox
	 */
	public WebElement getContactNameTextBox() {
		contactNameTextBox = uiObj
				.searchElementInParentElement(getContactForm(), ById,
						ElementIdentifiers.contactNameTextBoxId);
		if (contactNameTextBox != null) {
			ResultsLogger.logInfo("ContactNameTextBox was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("ContactNameTextBox found using locator "
								+ ById + " = "
								+ ElementIdentifiers.contactNameTextBoxId);
		} else
			ResultsLogger.logError("ContactNameTextBox was not found.");

		return contactNameTextBox;
	}

	/**
	 * Finds and returns the element for the Email textbox on the Contact us
	 * form.
	 * 
	 * @return the contactEmailTextBox
	 */
	public WebElement getContactEmailTextBox() {
		contactEmailTextBox = uiObj.searchElementInParentElement(
				getContactForm(), ById,
				ElementIdentifiers.contactEmailTextBoxId);
		if (contactEmailTextBox != null) {
			ResultsLogger.logInfo("contactEmailTextBox was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("contactEmailTextBox found using locator "
								+ ById + " = "
								+ ElementIdentifiers.contactEmailTextBoxId);
		} else
			ResultsLogger.logError("contactEmailTextBox was not found.");

		return contactEmailTextBox;
	}

	/**
	 * Finds and returns the element for the IssueDetails textbox on the Contact
	 * us form.
	 * 
	 * @return the contactIssueDetailsTextArea
	 */
	public WebElement getContactIssueDetailsTextArea() {
		contactIssueDetailsTextArea = uiObj.searchElementInParentElement(
				getContactForm(), ById,
				ElementIdentifiers.contactIssueDetailsTextAreaId);
		if (contactIssueDetailsTextArea != null) {
			ResultsLogger.logInfo("contactIssueDetailsTextArea was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("contactIssueDetailsTextArea found using locator "
								+ ById
								+ " = "
								+ ElementIdentifiers.contactIssueDetailsTextAreaId);
		} else
			ResultsLogger
					.logError("contactIssueDetailsTextArea was not found.");

		return contactIssueDetailsTextArea;
	}

	/**
	 * Finds and returns the element for the Submit button on the Contact us
	 * form.
	 * 
	 * @return the contactSubmitbutton
	 */
	public WebElement getContactSubmitbutton() {
		contactSubmitbutton = uiObj.searchElementInParentElement(
				getContactForm(), ByClassName,
				ElementIdentifiers.contactSubmitButtonClassName);
		if (contactSubmitbutton != null) {
			ResultsLogger.logInfo("ContactSubmitbutton was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("ContactSubmitbutton found using locator "
								+ ByClassName
								+ " = "
								+ ElementIdentifiers.contactSubmitButtonClassName);
		} else
			ResultsLogger.logError("ContactSubmitbutton was not found.");

		return contactSubmitbutton;
	}

	/**
	 * Finds and returns the element for the required message for the Email text
	 * box on the Contact us form.
	 * 
	 * @return the requiredMsgcontactEmailTextBox
	 */
	public WebElement getRequiredMsgcontactEmailTextBox() {
		requiredMsgcontactEmailTextBox = uiObj.searchElementInParentElement(
				getContactForm(), ByXpath,
				ElementIdentifiers.requiredMsgContactEmailXpath);
		if (requiredMsgcontactEmailTextBox != null) {
			ResultsLogger.logInfo("requiredMsgcontactEmailTextBox was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("requiredMsgcontactEmailTextBox found using locator "
								+ ByXpath
								+ " = "
								+ ElementIdentifiers.requiredMsgContactEmailXpath);
		} else
			ResultsLogger
					.logError("requiredMsgcontactEmailTextBox was not found.");

		return requiredMsgcontactEmailTextBox;
	}

	/**
	 * Finds and returns the element for the validation message for the Email
	 * text box on the Contact us form.
	 * 
	 * @return the validationMsgcontactEmailTextBox
	 */
	public WebElement getValidationMsgcontactEmailTextBox() {
		validationMsgcontactEmailTextBox = uiObj.searchElementInParentElement(
				getContactForm(), ByXpath,
				ElementIdentifiers.validationMsgContactEmailXpath);
		if (validationMsgcontactEmailTextBox != null) {
			ResultsLogger
					.logInfo("validationMsgcontactEmailTextBox was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("validationMsgcontactEmailTextBox found using locator "
								+ ByXpath
								+ " = "
								+ ElementIdentifiers.validationMsgContactEmailXpath);
		} else
			ResultsLogger
					.logError("validationMsgcontactEmailTextBox was not found.");

		return validationMsgcontactEmailTextBox;
	}

	/**
	 * Finds and returns the element for the required message for the Contact
	 * issue text area on the Contact us form.
	 * 
	 * @return the requiredMsgcontactIssueTextArea
	 */
	public WebElement getRequiredMsgcontactIssueTextArea() {
		requiredMsgcontactIssueTextArea = uiObj.searchElementInParentElement(
				getContactForm(), ByXpath,
				ElementIdentifiers.requiredMsgContactIssueDetailsXpath);
		if (requiredMsgcontactIssueTextArea != null) {
			ResultsLogger.logInfo("requiredMsgcontactIssueTextArea was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("requiredMsgcontactIssueTextArea found using locator "
								+ ByXpath
								+ " = "
								+ ElementIdentifiers.requiredMsgContactIssueDetailsXpath);
		} else
			ResultsLogger
					.logError("requiredMsgcontactIssueTextArea was not found.");

		return requiredMsgcontactIssueTextArea;
	}

	/**
	 * Finds and returns the element for Header text of the Contact us form.
	 * 
	 * @return the contactUsHeaderText
	 */
	public WebElement getContactUsHeaderText() {
		contactUsHeaderText = uiObj.searchElementInParentElement(
				getContactForm(), ByXpath,
				ElementIdentifiers.contactUsHeaderTextXpath);
		if (contactUsHeaderText != null) {
			ResultsLogger.logInfo("contactUsHeaderText was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("contactUsHeaderText found using locator "
								+ ByXpath + " = "
								+ ElementIdentifiers.contactUsHeaderTextXpath);
		} else
			ResultsLogger.logError("contactUsHeaderText was not found.");

		return contactUsHeaderText;
	}

	/**
	 * Finds and returns the element for Close icon on the Contact us form.
	 * 
	 * @return the contactUsFormCloseIcon
	 */
	public WebElement getContactUsFormCloseIcon() {
		contactUsFormCloseIcon = uiObj.searchElementInParentElement(
				getContactForm(), ByXpath,
				ElementIdentifiers.contactUsFormCloseIconXpath);
		if (contactUsFormCloseIcon != null) {
			ResultsLogger.logInfo("contactUsFormCloseIcon was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("contactUsFormCloseIcon found using locator "
								+ ByXpath
								+ " = "
								+ ElementIdentifiers.contactUsFormCloseIconXpath);
		} else
			ResultsLogger.logError("contactUsFormCloseIcon was not found.");

		return contactUsFormCloseIcon;
	}

	/**
	 * Finds and returns the element for the Name label on the Contact us form.
	 * 
	 * @return the contactNameLabel
	 */
	public WebElement getContactNameLabel() {
		contactNameLabel = uiObj.searchElementInParentElement(getContactForm(),
				ByClassName, ElementIdentifiers.contactNameLabelClassName);
		if (contactNameLabel != null) {
			ResultsLogger.logInfo("contactNameLabel was found.");
			if (debugEnabled)
				ResultsLogger.logDebug("contactNameLabel found using locator "
						+ ByClassName + " = "
						+ ElementIdentifiers.contactNameLabelClassName);
		} else
			ResultsLogger.logError("contactNameLabel was not found.");

		return contactNameLabel;
	}

	/**
	 * Finds and returns the element for the Email label on the Contact us form.
	 * 
	 * @return the contactEmailLabel
	 */
	public WebElement getContactEmailLabel() {
		contactEmailLabel = uiObj.searchElementInParentElement(
				getContactForm(), ByClassName,
				ElementIdentifiers.contactEmailLabelClassName);
		if (contactEmailLabel != null) {
			ResultsLogger.logInfo("contactEmailLabel was found.");
			if (debugEnabled)
				ResultsLogger.logDebug("contactEmailLabel found using locator "
						+ ByClassName + " = "
						+ ElementIdentifiers.contactEmailLabelClassName);
		} else
			ResultsLogger.logError("contactEmailLabel was not found.");

		return contactEmailLabel;
	}

	/**
	 * Finds and returns the element for the Issue details label on the Contact
	 * us form.
	 * 
	 * @return the contactIssueDetailsLabel
	 */
	public WebElement getContactIssueDetailsLabel() {
		contactIssueDetailsLabel = uiObj.searchElementInParentElement(
				getContactForm(), ByClassName,
				ElementIdentifiers.contactIssueDetailsLabelClassName);
		if (contactIssueDetailsLabel != null) {
			ResultsLogger.logInfo("contactIssueDetailsLabel was found.");
			if (debugEnabled)
				ResultsLogger
						.logDebug("contactIssueDetailsLabel found using locator "
								+ ByClassName
								+ " = "
								+ ElementIdentifiers.contactIssueDetailsLabelClassName);
		} else
			ResultsLogger.logError("contactIssueDetailsLabel was not found.");

		return contactIssueDetailsLabel;
	}

}
