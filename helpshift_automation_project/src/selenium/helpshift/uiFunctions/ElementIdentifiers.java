package selenium.helpshift.uiFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.loggerFunctions.ResultsLogger;

/**
 * This class reads ElementIdentifiers.properties for the elements identifier
 * values and assigns them to the global variables having similar names.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class ElementIdentifiers {

	public static String contactFormId = null;
	public static String contactNameTextBoxId = null;
	public static String contactEmailTextBoxId = null;
	public static String contactIssueDetailsTextAreaId = null;
	public static String contactSubmitButtonClassName = null;
	public static String contactUsButtonId = null;
	public static String contactusMsgXpath = null;
	public static String validationMsgContactEmailXpath = null;
	public static String validationMsgContactIssueDetailsXpath = null;
	public static String contactUsHeaderTextXpath = null;
	public static String contactUsFormCloseIconXpath = null;
	public static String contactNameLabelClassName = null;
	public static String contactEmailLabelClassName = null;
	public static String contactIssueDetailsLabelClassName = null;

	static {
		loadElementIdentifierValues();
	}

	/**
	 * Reads the ElementIdentifiers.properties for the identifier values and
	 * stores in the specified variables
	 * 
	 */
	private static void loadElementIdentifierValues() {
		Properties prop = new Properties();
		InputStream elementIdentifiersFileInputStream = null;
		boolean debugEnabled = AutoConfigs.debugEnabled;
		String propertyValue = null;
		ElementIdentifiers obj = new ElementIdentifiers();
		try {

			elementIdentifiersFileInputStream = new FileInputStream(
					AutoConfigs.elementIdentifiersFilePath);
			prop.load(elementIdentifiersFileInputStream);

			Field[] elementIdentifiers = getDeclaredFieldsOfCurrentClass();

			for (Field elementIdentifier : elementIdentifiers) {
				propertyValue = prop.getProperty(elementIdentifier.getName());
				if (propertyValue != null) {
					elementIdentifier.setAccessible(true);
					elementIdentifier.set(obj, new String(propertyValue));
				} else
					ResultsLogger
							.logError(elementIdentifier
									+ "is null or was not found in ElementIdentifiers.properties file.");
			}
			ResultsLogger
					.logInfo("ElementIdentifiers.properties read successfully and values are now stored in the ElementIdentifiers class.");
		} catch (IOException e) {
			ResultsLogger
					.logError("Unable to read ElementIdentifiers.properties file.");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());

		} catch (IllegalArgumentException e) {
			ResultsLogger
					.logError("Unable to set field value due to IllegalArgumentException");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (IllegalAccessException e) {
			ResultsLogger
					.logError("Unable to set field value due to IllegalAccessException");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} finally {
			if (elementIdentifiersFileInputStream != null) {
				try {
					elementIdentifiersFileInputStream.close();
				} catch (IOException e) {
					ResultsLogger.logError("Unable to close properites file.");
					if (debugEnabled)
						ResultsLogger.logDebug(e.getClass().toString());
				}
			}

		}
	}

	/**
	 * Returns a list of class variables/fields for the current class
	 * 
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
