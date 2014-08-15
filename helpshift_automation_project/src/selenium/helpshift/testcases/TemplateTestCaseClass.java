package selenium.helpshift.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiElementLib.ContactUsForm;
import selenium.helpshift.uiElementLib.MainPage;
import selenium.helpshift.uiFunctions.BrowserFunctions;

/**
 * This is template testcase class for reference. Create a copy of this class
 * and modify the test steps as per your testcase.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class TemplateTestCaseClass {

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
	public TemplateTestCaseClass(String browserName, int iteration) {
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
		String confirmationMsg = "XYZ";

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

				/*
				 * Sample Test Case code snippet
				 * 
				 * 
				 * // Click on Contact us button on the main page
				 * mainPageObj.getcontactUsButton().click();
				 * ResultsLogger.logInfo("Contact us button clicked.");
				 * 
				 * // Set Name field value
				 * contactusFormObj.getContactNameTextBox().clear();
				 * contactusFormObj
				 * .getContactNameTextBox().sendKeys(nameTestString);
				 * ResultsLogger
				 * .logInfo("Name Textbox value is set to "+nameTestString);
				 * 
				 * // Set Email field value
				 * contactusFormObj.getContactEmailTextBox().clear();
				 * contactusFormObj
				 * .getContactEmailTextBox().sendKeys(emailTestString);
				 * ResultsLogger
				 * .logInfo("Email Textbox value is set to "+emailTestString);
				 * 
				 * // Set Issue details field value
				 * contactusFormObj.getContactIssueDetailsTextArea().clear();
				 * contactusFormObj
				 * .getContactIssueDetailsTextArea().sendKeys(issueDetailsTestString
				 * );
				 * ResultsLogger.logInfo("Issue details Textarea value is set to "
				 * +emailTestString);
				 * 
				 * 
				 * // Click on Submit button
				 * contactusFormObj.getContactSubmitbutton().click();
				 * ResultsLogger.logInfo("Submit button clicked.");
				 * 
				 * // Check the confirmation message. If it exists, the testcase
				 * // has passed if
				 * ((mainPageObj.getsuccessMsgForContactusForm().getText())
				 * .equalsIgnoreCase(confirmationMsg)) testCaseStatus = true;
				 */

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
