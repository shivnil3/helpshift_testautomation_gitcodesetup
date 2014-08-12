/**
 * 
 */
package selenium.helpfshift.LoggerFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.*;
import selenium.helpshift.Intilializer.AutomationConfigurations;
import selenium.helpshift.Intilializer.Globals;

/** This class is custom logger which writes the output to html file specified in the log4j.properties file
 * @author nil
 * 
 */
public class ResultsLogger {

	static final Logger logger = Logger.getLogger(ResultsLogger.class);
	static final String log4JPropertyFile =AutomationConfigurations.log4jPropertyFilePath;
	static final Boolean debugEnabled=AutomationConfigurations.debugEnabled;
	
	/** Logs the message to the output file with log level as 'Debug'
	 * @param message
	 */
	public static void logDebug(String message) {
		logger.debug(message);
	}

	/**Logs the message to the output file with log level as 'Info'
	 * @param message
	 */
	public static void logInfo(String message) {
		logger.debug(message);
	}

	/**Logs the message to the output file with log level as 'Error'
	 * @param message
	 */
	public static void logError(String message) {
		logger.error(message);
	}

	static {
		Globals.setCurrentClassNameAs(ResultsLogger.class.getCanonicalName());
		setLoggerProperties();
		configureLogger();
				
	}

	/** Reads the values from log4j.properties file and configures the Logger
	 * 
	 */
	private static void configureLogger() {
		Properties prop = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(log4JPropertyFile);
			prop.load(fis);
			PropertyConfigurator.configure(prop);
			fis.close();
		} catch (IOException e) {
			ResultsLogger.logError("Unable to read log4j property file");
			if(debugEnabled)
			ResultsLogger.logError(e.getClass().toString());

		}

	}

	/** Modifies few properties in the log4j.properties
	 * 
	 */
	private static void setLoggerProperties() {
		Properties prop = new Properties();

		OutputStream fos = null;
		FileInputStream fis = null;
		String outputFileName = "ExecutionResults" + System.currentTimeMillis()
				+ ".html";
		File resultsFolder = new File(AutomationConfigurations.ResultsFolder);
		if (!resultsFolder.exists())
			resultsFolder.mkdirs();

		try {
			fis = new FileInputStream(log4JPropertyFile);
			prop.load(fis);
			fis.close();

			fos = new FileOutputStream(log4JPropertyFile);
			prop.setProperty("log", AutomationConfigurations.ResultsFolder);
			prop.setProperty("log4j.appender.FILE.File", "${log}/"
					+ outputFileName);
			prop.store(fos, null);

		} catch (IOException io) {
			ResultsLogger.logError("Unable to read log4j property file");
			if(debugEnabled)
			ResultsLogger.logError(io.getClass().toString());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					ResultsLogger.logError("Unable to read log4j property file");
					if(debugEnabled)
					ResultsLogger.logError(e.getClass().toString());
				}
			}
		}

	}

}