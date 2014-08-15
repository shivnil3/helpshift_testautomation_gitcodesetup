package selenium.helpshift.uiFunctions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriver;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.loggerFunctions.ResultsLogger;

import com.opera.core.systems.OperaDriver;

/**
 * This class contains functions to launch different browsers using different
 * browser drivers.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class BrowserFunctions {

	private static WebDriver currentDriver = null;
	boolean debugEnabled = AutoConfigs.debugEnabled;

	public WebDriver launchURLInBrowser(String url, String browser) {
		WebDriver browserDriver = null;
		if (browser == null) {
			ResultsLogger.logError("Invalid browser value");
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			browserDriver = launchIEBrowser();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			browserDriver = launchFirefoxBrowser();
		} else if (browser.equalsIgnoreCase("Safari")) {
			browserDriver = launchSafariBrowser();
		} else if (browser.equalsIgnoreCase("Opera")) {
			browserDriver = launchOperaBrowser();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			browserDriver = launchChromeBrowser();
		} else
			ResultsLogger.logError("Invalid browser parameter passed.");

		if ((browserDriver != null)) {
			try {
				browserDriver.get(url);
				setCurrentDriver(browserDriver);
				ResultsLogger.logInfo("The specified url - " + url
						+ " was launched succesfully in " + browser
						+ " browser.");
			} catch (Exception e) {
				ResultsLogger.logError("Unable to launch the url in " + browser
						+ " browser");
			}
		} else {
			ResultsLogger.logError("Unable to launch " + browser
					+ "using the respective driver.");
		}

		return browserDriver;

	}

	/**
	 * Launch Internet Explorer using InternetExplorerDriver
	 * 
	 * @return ieDriver
	 */
	private WebDriver launchIEBrowser() {
		WebDriver ieDriver = null;
		try {
			System.setProperty("webdriver.ie.driver",
					AutoConfigs.ieDriverExePath);
			ieDriver = new InternetExplorerDriver();
			ieDriver.manage().window().maximize();
		} catch (IllegalStateException e) {
			ResultsLogger
					.logError("The path to the IE driver executable is not set correctly.");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Internet Explorer");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}
		return ieDriver;
	}

	/**
	 * Launch Firefox browser using FirefoxDriver
	 * 
	 * @return firefoxDriver
	 */
	private WebDriver launchFirefoxBrowser() {
		WebDriver firefoxDriver = null;
		try {
			firefoxDriver = new FirefoxDriver();
			firefoxDriver.manage().window().maximize();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Firefox browser");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}
		return firefoxDriver;
	}

	/**
	 * Launch Chrome browser using Chromedriver
	 * 
	 * @return chromeDriver
	 */
	private WebDriver launchChromeBrowser() {
		WebDriver chromeDriver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
					AutoConfigs.chromeDriverExePath);
			chromeDriver = new ChromeDriver();
			chromeDriver.manage().window().maximize();
		} catch (Exception e) {
			ResultsLogger
					.logError("Unable to launch the Chrome browser.There could be multiple reasons for the failure. Chromedriver does not support the version above Opera 12, please install the appopriate versions (preferably using the 32 bit installer)");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}
		return chromeDriver;
	}

	/**
	 * Launch Safari browser using SafariDriver
	 * 
	 * @return safariDriver
	 */
	private WebDriver launchSafariBrowser() {
		WebDriver safariDriver = null;
		try {
			safariDriver = new SafariDriver();
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Safari browser");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}
		return safariDriver;
	}

	/**
	 * Launch Opera browser using OperaDriver
	 * 
	 * @return operaDriver
	 */
	private WebDriver launchOperaBrowser() {
		WebDriver operaDriver = null;
		try {
			operaDriver = new OperaDriver();			
		} catch (Exception e) {
			ResultsLogger.logError("Unable to launch the Opera browser");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}
		return operaDriver;
	}

	/**
	 * Returns the current driver
	 * 
	 * @return
	 */
	public static WebDriver getCurrentDriver() {
		return currentDriver;
	}

	/**
	 * Sets the current driver
	 * 
	 * @param driver
	 */
	private void setCurrentDriver(WebDriver driver) {
		currentDriver = driver;
	}

	/**
	 * Close the browser
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}
