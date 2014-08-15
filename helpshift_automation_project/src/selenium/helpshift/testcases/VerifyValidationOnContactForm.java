package selenium.helpshift.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiElementLib.ContactUsForm;
import selenium.helpshift.uiElementLib.MainPage;
import selenium.helpshift.uiFunctions.BrowserFunctions;

/**
 * Verify the validation messages on the contact us form.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class VerifyValidationOnContactForm {

	String browserToUse;
	WebDriver browserDriver;
	int loop;
	int loopCounter;
	Boolean testCaseStatus = false;
	BrowserFunctions browserFunctionsObj = new BrowserFunctions();
	WebDriverWait wait;

	/**
	 * Constructor for this class, to initialize value of the instance
	 * variables.
	 * 
	 * @param browserName
	 * @param iteration
	 */
	public VerifyValidationOnContactForm(String browserName, int iteration) {
		loop = iteration;
		browserToUse = browserName;
	}

	/**
	 *Main method for this class which has the test stes.
	 */
	public void runTestcase() {
		/* Provide all declarations come here */
		MainPage mainPageObj = null;
		ContactUsForm contactusFormObj = null;
		ArrayList<Boolean> testStepStatus = new ArrayList<Boolean>();
		String confirmationMsg = "Thanks for contacting us. Your message was received.";
		String validEmailTestString = "shivnil2@gmail.com";
		String invalidEmailTestString = "shivnil2gmail.com";
		String nameTestString = "Nilesh";
		String issueDetailsTestString = "test comments through testsuite";

		try {
			for (loopCounter = 0; loopCounter < loop; loopCounter++) {
				/*
				 * launch browser using the url specified in the
				 * AutomationConfiguration.properties file
				 */
				browserDriver = browserFunctionsObj.launchURLInBrowser(
						AutoConfigs.webApplicationURL, browserToUse);
				wait = new WebDriverWait(browserDriver, AutoConfigs.waitTime);
				testCaseStatus = false;

				/* UI object creation comes here */
				mainPageObj = new MainPage(browserDriver);
				contactusFormObj = new ContactUsForm(browserDriver);

				/* Your teststeps will come here */

				/* TESTCASE - Verify the Close Icon closes the contact us form */

				ResultsLogger
						.logInfo("TESTCASE - Verify the Close Icon closes the contact us form ");
				// Click on Contact us button on the main page
				mainPageObj.getcontactUsButton().click();
				ResultsLogger.logInfo("CONTACT US button is clicked.");

				// Verify the Contact us form exists
				if (contactusFormObj.getContactForm().isDisplayed()) {
					testStepStatus.add(true);
					ResultsLogger.logInfo("CONTACT US form is displayed");
				}

				// Click on the Close(X)icon to close the Contactus form
				contactusFormObj.getContactUsFormCloseIcon().click();
				ResultsLogger.logInfo("Close(X)icon was clicked");

				// Verify the Contact us form exists
				if ((contactusFormObj.getContactForm()) == null) {
					testStepStatus.add(true);
					ResultsLogger.logPass("CONTACT US form is not displayed");
				} else
					ResultsLogger
							.logFail("CONTACT US form is still displayed. It seems Close(X)icon was not clicked");

				/*
				 * TESTCASE - Confirm that the Email and Text area fields are
				 * mandatory and appropriate message is displayed for blank
				 * values for these fields
				 */

				ResultsLogger
						.logInfo("TESTCASE - Confirm that the Email and Text area fields are mandatory and appropriate message is displayed for blank values for these fields");
				// Click on Contact us button on the main page
				mainPageObj.getcontactUsButton().click();
				ResultsLogger.logInfo("Contact us button was clicked");

				// Click on Submit button
				contactusFormObj.getContactSubmitbutton().click();
				ResultsLogger
						.logInfo("Submit button clicked on the Contact us form.");

				// Checked the required field message is displayed for email and
				// issue details
				if ((contactusFormObj.getValidationMsgcontactEmailTextBox()
						.getText())
						.equalsIgnoreCase("Email is a required field")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Email is a required field - message is displayed");
				} else
					ResultsLogger
							.logFail("Email is a required field - message is not displayed");

				if ((contactusFormObj.getValidationMsgcontactIssueTextArea()
						.getText())
						.equalsIgnoreCase("Problem description is a required field")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Problem description is a required field - message is displayed");
				} else
					ResultsLogger
							.logFail("Problem description is a required field - message is not displayed");

				// TESTCASE - Set value for name and issue details field only
				// and check
				// whether required field message appears for email field
				ResultsLogger
						.logInfo("TESTCASE - Set value for name and issue details field only and check whether required field message appears for email field");
				contactusFormObj.getContactNameTextBox().clear();
				contactusFormObj.getContactNameTextBox().sendKeys(
						nameTestString);
				ResultsLogger.logInfo("Name text box set to - "
						+ nameTestString);
				contactusFormObj.getContactIssueDetailsTextArea().clear();
				contactusFormObj.getContactIssueDetailsTextArea().sendKeys(
						issueDetailsTestString);
				ResultsLogger.logInfo("Issue details text area set to - "
						+ issueDetailsTestString);
				contactusFormObj.getContactSubmitbutton().click();
				ResultsLogger.logInfo("Submit button was clicked");

				if ((contactusFormObj.getValidationMsgcontactEmailTextBox()
						.getText())
						.equalsIgnoreCase("Email is a required field")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Email is a required field - message is displayed");
				} else
					ResultsLogger
							.logFail("Email is a required field - message is not displayed");

				/*
				 * TESTCASE - Enter invalid email address and check for the
				 * validation message
				 */
				ResultsLogger
						.logInfo("TESTCASE - Enter invalid email address and check for the validation message");
				contactusFormObj.getContactEmailTextBox().clear();
				contactusFormObj.getContactEmailTextBox().sendKeys(
						invalidEmailTestString);
				ResultsLogger.logInfo("Email text box set to - "
						+ invalidEmailTestString);
				contactusFormObj.getContactSubmitbutton().click();
				ResultsLogger.logInfo("Submit button was clicked");
				if ((contactusFormObj.getValidationMsgcontactEmailTextBox()
						.getText())
						.equalsIgnoreCase("Please enter a valid email")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Please enter a valid email - message is displayed");
				} else
					ResultsLogger
							.logFail("Please enter a valid email - message is not displayed");

				/*
				 * TESTCASE - Enter valid email address and submit the form. It
				 * should be submitted successfully.
				 */
				ResultsLogger
						.logInfo("TESTCASE - Enter valid email address and submit the form. It should be submitted successfully.");
				contactusFormObj.getContactEmailTextBox().clear();
				contactusFormObj.getContactEmailTextBox().sendKeys(
						"validEmailTestString");
				ResultsLogger.logInfo("Email text box set to - "
						+ validEmailTestString);
				contactusFormObj.getContactSubmitbutton().click();
				ResultsLogger.logInfo("Submit button was clicked");

				// Check the confirmation message. If it exists, the testcase
				// has passed
				if ((mainPageObj.getsuccessMsgForContactusForm().getText())
						.equalsIgnoreCase(confirmationMsg)) {
					testStepStatus.add(true);
					ResultsLogger.logPass(confirmationMsg
							+ " - message is displayed");
				} else
					ResultsLogger.logFail(confirmationMsg
							+ " - message was not displayed");

				/* Close the browser */
				browserFunctionsObj.closeBrowser(browserDriver);

			}
			// temporarily setting test case status as true
			testCaseStatus = true;
			for (Boolean status : testStepStatus) {
				if (!status)
					testCaseStatus = false;
			}

			if (testCaseStatus)
				ResultsLogger.logPass("Execution for testcase "
						+ this.getClass().getName()
						+ " completed successfully.");
			else
				ResultsLogger.logFail("Execution for testcase "
						+ this.getClass().getName() + " failed.");

		} catch (Exception e) {
			ResultsLogger.logError("Execution for testcase "
					+ this.getClass().getName() + " failed.");
		} finally {
			/* Close the browser, in case, it is still open */
			browserFunctionsObj.closeBrowser(browserDriver);

			/* Set testcase status */
			ResultsLogger.generateTestcaseResultsHTML(this.getClass()
					.getSimpleName(), browserToUse, testCaseStatus);

		}

	}

}
