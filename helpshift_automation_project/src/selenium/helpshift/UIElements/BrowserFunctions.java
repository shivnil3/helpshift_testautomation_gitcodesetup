package selenium.helpshift.UIElements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriver;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;
import selenium.helpshift.Intilializer.AutomationConfigurations;
import selenium.helpshift.Intilializer.Globals;

import com.opera.core.systems.OperaDriver;

/** This class contains functions to launch different browsers using different browser drivers.
 * @author nil
 * 
 */
public class BrowserFunctions {

	WebDriver driver = null;
	boolean debugEnabled = AutomationConfigurations.debugEnabled;
	static{
		Globals.setCurrentClassNameAs(BrowserFunctions.class.getCanonicalName());	
	}
	
	
	/** Launch Internet Explorer using InternetExplorerDriver
	 * @return driver
	 */
	public WebDriver launchIEBrowser() {
		try {
			System
					.setProperty(
							"webdriver.ie.driver",
							AutomationConfigurations.IEDriverExePath);
			driver = new InternetExplorerDriver();			
		} catch (IllegalStateException e) {
			ResultsLogger.logError("The path to the IE driver executable is not set correctly.");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Internet Explorer");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return driver;
	}

	/**Launch Firefox browser using FirefoxDriver
	 * @return driver
	 */
	public WebDriver launchFirefoxBrowser() {
		try {
			driver = new FirefoxDriver();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Firefox browser");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return driver;
	}

	/**Launch Chrome browser using Chromedriver
	 * @return driver
	 */
	public WebDriver launchChromeBrowser() {
		try {
			System
			.setProperty(
					"webdriver.chrome.driver",
					AutomationConfigurations.ChromeDriverExePath);
			driver = new ChromeDriver();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Chrome browser.There could be multiple reasons for the failure. Chromedriver does not support the version above Opera 12, please install the appopriate versions (preferably using the 32 bit installer)");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return driver;
	}

	/**Launch Safari browser using SafariDriver
	 * @return driver
	 */
	public WebDriver launchSafariBrowser() {
		try {
			driver = new SafariDriver();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Safari browser");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return driver;
	}

	/**Launch Opera browser using OperaDriver
	 * @return driver
	 */
	public WebDriver launchOperaBrowser() {
		try {
			driver = new OperaDriver();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Opera browser");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
