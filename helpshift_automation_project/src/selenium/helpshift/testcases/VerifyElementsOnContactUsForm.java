package selenium.helpshift.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiElementLib.ContactUsForm;
import selenium.helpshift.uiElementLib.MainPage;
import selenium.helpshift.uiFunctions.BrowserFunctions;

/**
 * This test case verifies whether all the elements exists on the contact us
 * form.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class VerifyElementsOnContactUsForm {

	String browserToUse;
	WebDriver browserDriver;
	int loop;
	int loopCounter;
	Boolean testCaseStatus = false;
	BrowserFunctions browserFunctionsObj = new BrowserFunctions();

	/**
	 * Constructor for this class, to initialize value of the instance
	 * variables.
	 * 
	 * @param browserName
	 * @param iteration
	 */
	public VerifyElementsOnContactUsForm(String browserName, int iteration) {
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
		try {
			for (loopCounter = 0; loopCounter < loop; loopCounter++) {
				/*
				 * launch browser using the url specified in the
				 * AutomationConfiguration.properties file
				 */
				browserDriver = browserFunctionsObj.launchURLInBrowser(
						AutoConfigs.webApplicationURL, browserToUse);
				testCaseStatus = false;

				/* UI object creation comes here */
				mainPageObj = new MainPage(browserDriver);
				contactusFormObj = new ContactUsForm(browserDriver);

				/* Your teststeps will come here */

				// Click on Contact us button on the main page
				mainPageObj.getcontactUsButton().click();
				ResultsLogger.logInfo("Contact us button was clicked");

				// Check the Contact us text exists in the header of contact
				// form
				if ((contactusFormObj.getContactUsHeaderText().getText())
						.equalsIgnoreCase("CONTACT US")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("CONTACT US text was found in the header of the contact form");
				} else
					ResultsLogger
							.logFail("CONTACT US text was not found in the header of the contact form");

				// Check the Close(X) icon in the header of contact form
				if ((contactusFormObj.getContactUsFormCloseIcon().isDisplayed())) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Close(X) icon was found in the header of the contact form");
				} else
					ResultsLogger
							.logFail("Close(X) icon was not found in the header of the contact form");

				// Check the Name label exists on the contact form
				if ((contactusFormObj.getContactNameLabel().getText())
						.equalsIgnoreCase("Your Name (optional)")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Your Name (optional) label wasfound on the contact form");
				} else
					ResultsLogger
							.logFail("Your Name (optional) label was not found on the contact form");

				// Check the Name textbox exists on the contact form
				if ((contactusFormObj.getContactNameTextBox().isDisplayed())) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Your Name textbox was found on the contact form");
				} else
					ResultsLogger
							.logFail("Your Name textbox was not found on the contact form");

				// Check the Email label exists on the contact form
				if ((contactusFormObj.getContactEmailLabel().getText())
						.equalsIgnoreCase("Your email address")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Your email address label was found on the contact form");
				} else
					ResultsLogger
							.logFail("Your email address label was not found on the contact form");

				// Check the Email textbox exists on the contact form
				if ((contactusFormObj.getContactEmailTextBox().isDisplayed())) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("Your email address textbox was found on the contact form");
				} else
					ResultsLogger
							.logFail("Your email address textbox was not found on the contact form");

				// Check the label for Contact Issue exists on the contact form
				if ((contactusFormObj.getContactIssueDetailsLabel().getText())
						.equalsIgnoreCase("How can we help you?")) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("How can we help you? label was found on the contact form");
				} else
					ResultsLogger
							.logFail("How can we help you? label was not found on the contact form");

				// Check the Contact Issue textbox exists on the contact form
				if ((contactusFormObj.getContactIssueDetailsTextArea()
						.isDisplayed())) {
					testStepStatus.add(true);
					ResultsLogger
							.logPass("How can we help you? textarea was found on the contact form");
				} else
					ResultsLogger
							.logFail("How can we help you? textarea was not found on the contact form");

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
