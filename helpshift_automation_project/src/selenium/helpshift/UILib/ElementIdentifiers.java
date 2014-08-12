package selenium.helpshift.UILib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;
import selenium.helpshift.Intilializer.AutomationConfigurations;
import selenium.helpshift.Intilializer.Globals;
import selenium.helpshift.UIElements.BrowserFunctions;

/**This class reads ElementIdentifiers.properties for the elements identifier values
 * and assigns them to the global variables having similar names.
 * @author nil
 *
 */
public class ElementIdentifiers {

	public static String contactFormCssSelector = null;
	public static String contactNameTextBoxCssSelector = null;
	public static String contactEmailTextBoxCssSelector = null;
	public static String contactIssueDetailsTextAreaCssSelector = null;
	public static String contactSubmitButtonCssSelector = null;
	public static String contactUsButtonId=null;
	public static String ContactusMsgXpath=null;
	public static String validationMsgContactEmailXpath=null;
	public static String validationMsgContactIssueDetailsXpath=null;

	static {
		Globals.setCurrentClassNameAs(BrowserFunctions.class
				.getCanonicalName());
		loadElementIdentifierValues();
	}

	/**Reads the ElementIdentifiers.properties for the identifier values and stores in the specified variables 
	 * 
	 */
	private static void loadElementIdentifierValues() {
		Properties prop = new Properties();
		InputStream elementIdentifiersFileInputStream = null;
		boolean debugEnabled = AutomationConfigurations.debugEnabled;
		String propertyValue = null;
		ElementIdentifiers obj = new ElementIdentifiers();
		try {

			elementIdentifiersFileInputStream = new FileInputStream(
					AutomationConfigurations.ElementIdentifiersFilePath);
			prop.load(elementIdentifiersFileInputStream);

			Field[] elementIdentifiers = getDeclaredFieldsOfCurrentClass();

			for (Field elementIdentifier : elementIdentifiers) {
				propertyValue = prop.getProperty(elementIdentifier.getName());
				if (propertyValue != null) {
					elementIdentifier.setAccessible(true);
					elementIdentifier.set(obj, new String(propertyValue));

				} else
					ResultsLogger.logError(elementIdentifier + "is null or was not found in ElementIdentifiers.properties file.");
			}

		} catch (IOException e) {
			ResultsLogger.logError("Unable to read ElementIdentifiers.properties file.");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (IllegalArgumentException e) {
			ResultsLogger.logError("Unable to set field value due to IllegalArgumentException");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} catch (IllegalAccessException e) {
			ResultsLogger.logError("Unable to set field value due to IllegalAccessException");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} finally {
			if (elementIdentifiersFileInputStream != null) {
				try {
					elementIdentifiersFileInputStream.close();
				} catch (IOException e) {
					ResultsLogger.logError("Unable to close properites file.");
					if (debugEnabled)
						ResultsLogger.logError(e.getClass().toString());
				}
			}

		}
	}

	/** Returns a list of class variables/fields for the current class  
	 * @return declaredFields
	 */
	private static Field[] getDeclaredFieldsOfCurrentClass() {
		final String className = ElementIdentifiers.class.getCanonicalName();

		try {
			Class<?> currentClass = Class.forName(className);
			Field declaredFields[] = currentClass.getDeclaredFields();
			return declaredFields;
		} catch (ClassNotFoundException e) {
			ResultsLogger.logError(className + " class not found!!!");
			return null;
		}

	}
}
