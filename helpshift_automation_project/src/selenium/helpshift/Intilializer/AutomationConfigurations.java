/**
 * 
 */
package selenium.helpshift.Intilializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;

/** This class reads AutomationConfigurations.properties for the configuration values
 *  and assigns them to global variables having similar names. 
 * 
 * @author nil
 * 
 */
public class AutomationConfigurations {

	private static final String AutomatinConfigPropertyFile="C:/helpshift_assigment_codebase/helpshift_testautomation_gitcodesetup/helpshift_automation_project/src/Properties_files/AutomationConfigurations.properties";
	public static String IEDriverExePath = null;
	public static String ChromeDriverExePath = null;
	public static String ElementIdentifiersFilePath = null;
	public static String WebApplicationURL = null;
	public static Boolean debugEnabled = false;
	public static String ResultsFolder = null;
	public static String log4jPropertyFilePath = null;
	public static int waitTime;
	public static int minWaitTime;
	public static int maxWaitTime;

	static { 
		Globals.setCurrentClassNameAs(AutomationConfigurations.class
				.getCanonicalName());
		loadConfigurations();
	}

	/** Reads the AutomationConfigurations.properties and loads the required configurations
	 * 
	 */
	private static void loadConfigurations() {
		Properties prop = new Properties();
		InputStream automationConfigFileInputStream = null;

		try {
			automationConfigFileInputStream = new FileInputStream(AutomatinConfigPropertyFile);
			prop.load(automationConfigFileInputStream);

			if (prop.getProperty("waitTime") != null)
				waitTime =Integer.parseInt(prop
						.getProperty("waitTime"));
			else
				ResultsLogger
						.logError("waitTime value is null or was not found in AutomationConfigurations.properites file");
			
			if (prop.getProperty("minWaitTime") != null)
				minWaitTime =Integer.parseInt(prop
						.getProperty("minWaitTime"));
			else
				ResultsLogger
						.logError("minWaitTime value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("maxWaitTime") != null)
				maxWaitTime =Integer.parseInt(prop
						.getProperty("maxWaitTime"));
			else
				ResultsLogger
						.logError("maxWaitTime value is null or was not found in AutomationConfigurations.properites file");

			
			if (prop.getProperty("log4jPropertyFilePath") != null)
				log4jPropertyFilePath = prop
						.getProperty("log4jPropertyFilePath");
			else
				ResultsLogger
						.logError("log4jPropertyFilePath value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("IEDriverExePath") != null)
				IEDriverExePath = prop.getProperty("IEDriverExePath");
			else
				ResultsLogger
						.logError("IEDriverExePath value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("ChromeDriverExePath") != null)
				ChromeDriverExePath = prop.getProperty("ChromeDriverExePath");
			else
				ResultsLogger
						.logError("ChromeDriverExePath value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("ElementIdentifiersFilePath") != null)
				ElementIdentifiersFilePath = prop
						.getProperty("ElementIdentifiersFilePath");
			else
				ResultsLogger
						.logError("ElementIdentifiersFilePath value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("WebApplicationURL") != null)
				WebApplicationURL = prop.getProperty("WebApplicationURL");
			else
				ResultsLogger
						.logError("WebApplicationURL value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("debugEnabled") != null)
				debugEnabled = Boolean
						.valueOf(prop.getProperty("debugEnabled"));
			else
				ResultsLogger
						.logError("debugEnabled value is null or was not found in AutomationConfigurations.properites file");

			if (prop.getProperty("ResultsFolder") != null)
				ResultsFolder = prop.getProperty("ResultsFolder");
			else
				ResultsLogger
						.logError("ResultsFolder value is null or was not found in AutomationConfigurations.properites file");
		}

		catch (IOException e) {
			ResultsLogger
					.logError("Unable to read AutomationConfigurations.properites file.");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} finally {
			if (automationConfigFileInputStream != null) {
				try {
					automationConfigFileInputStream.close();
				} catch (IOException e) {
					ResultsLogger
							.logError("Unable to close AutomationConfigurations.properites file.");
					if (debugEnabled)
						ResultsLogger.logError(e.getClass().toString());
				}
			}

		}

	}

}
