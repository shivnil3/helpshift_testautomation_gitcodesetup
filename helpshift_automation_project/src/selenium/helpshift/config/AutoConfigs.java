package selenium.helpshift.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import selenium.helpshift.loggerFunctions.ResultsLogger;

/**
 * This class reads AutoConfigs.properties for the configuration values and
 * assigns them to global variables having similar names.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class AutoConfigs {

	private final static String userHome = System.getProperty("user.home");
	private final static String autoConfigFileName = "AutoConfigs.properties";
	private static final String autoConfigFilePath = userHome + "/"
			+ autoConfigFileName;
	public static String ieDriverExePath = null;
	public static String chromeDriverExePath = null;
	public static String elementIdentifiersFilePath = null;
	public static String webApplicationURL = null;
	public static Boolean debugEnabled = false;
	public static String resultsFolder = null;
	public static int waitTime;
	public static int minWaitTime;
	public static int maxWaitTime;
	public static String testSuiteFile = null;

	static {
		loadConfigurations();
	}

	/**
	 * Reads the AutoConfigs.properties and loads the required configurations
	 * 
	 */
	private static void loadConfigurations() {
		Properties prop = new Properties();
		InputStream automationConfigFileInputStream = null;

		try {
			automationConfigFileInputStream = new FileInputStream(
					autoConfigFilePath);
			prop.load(automationConfigFileInputStream);

			if (prop.getProperty("testSuiteFile") != null)
				testSuiteFile = prop.getProperty("testSuiteFile");
			else
				ResultsLogger
						.logError("testSuiteFile value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("waitTime") != null)
				waitTime = Integer.parseInt(prop.getProperty("waitTime"));
			else
				ResultsLogger
						.logError("waitTime value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("minWaitTime") != null)
				minWaitTime = Integer.parseInt(prop.getProperty("minWaitTime"));
			else
				ResultsLogger
						.logError("minWaitTime value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("maxWaitTime") != null)
				maxWaitTime = Integer.parseInt(prop.getProperty("maxWaitTime"));
			else
				ResultsLogger
						.logError("maxWaitTime value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("ieDriverExePath") != null)
				ieDriverExePath = prop.getProperty("ieDriverExePath");
			else
				ResultsLogger
						.logError("ieDriverExePath value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("chromeDriverExePath") != null)
				chromeDriverExePath = prop.getProperty("chromeDriverExePath");
			else
				ResultsLogger
						.logError("chromeDriverExePath value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("elementIdentifiersFilePath") != null)
				elementIdentifiersFilePath = prop
						.getProperty("elementIdentifiersFilePath");
			else
				ResultsLogger
						.logError("elementIdentifiersFilePath value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("webApplicationURL") != null)
				webApplicationURL = prop.getProperty("webApplicationURL");
			else
				ResultsLogger
						.logError("webApplicationURL value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("debugEnabled") != null)
				debugEnabled = Boolean
						.valueOf(prop.getProperty("debugEnabled"));
			else
				ResultsLogger
						.logError("debugEnabled value is null or was not found in AutoConfigs.properites file");

			if (prop.getProperty("resultsFolder") != null)
				resultsFolder = prop.getProperty("resultsFolder");
			else
				ResultsLogger
						.logError("resultsFolder value is null or was not found in AutoConfigs.properites file");
			ResultsLogger.logInfo(autoConfigFilePath + " was read successfully and the values are stored int he AutoConfig.class");
		}

		catch (IOException e) {
			ResultsLogger
					.logError("Unable to read AutoConfigs.properites file.");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());

		} finally {
			if (automationConfigFileInputStream != null) {
				try {
					automationConfigFileInputStream.close();
				} catch (IOException e) {
					ResultsLogger
							.logError("Unable to close AutoConfigs.properites file.");
					if (debugEnabled)
						ResultsLogger.logDebug(e.getClass().toString());
				}
			}

		}

	}

}
