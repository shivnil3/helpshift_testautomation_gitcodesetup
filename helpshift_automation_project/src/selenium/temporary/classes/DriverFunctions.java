/**
 * 
 */
package selenium.temporary.classes;

import org.openqa.selenium.WebDriver;

import selenium.helpshift.uiFunctions.BrowserFunctions;

/**This class contains methods which set the values for current driver.
 * @author nil
 * 
 */
public class DriverFunctions {

	private static BrowserFunctions browser = new BrowserFunctions();
	private static WebDriver currentBrowser = browser.getCurrentDriver();

	/** Returns the current browser instance
	 * @return currentBrowser
	 */
	public static WebDriver getCurrentDriver() {
		return currentBrowser;
	}

}
