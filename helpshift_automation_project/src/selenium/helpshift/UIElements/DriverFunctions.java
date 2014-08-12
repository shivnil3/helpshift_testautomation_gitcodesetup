/**
 * 
 */
package selenium.helpshift.UIElements;

import org.openqa.selenium.WebDriver;

/**This class contains methods which set the values for current driver.
 * @author nil
 * 
 */
public class DriverFunctions {

	private static BrowserFunctions browser = new BrowserFunctions();
	private static WebDriver currentDriver = browser.getDriver();

	/** Set the driver parameter as current driver.
	 * @param driver
	 */
	public static void setCurrentDriver(WebDriver driver) {
		currentDriver = driver;
	}

	/** Returns the current driver instance
	 * @return currentDriver
	 */
	public static WebDriver getCurrentDriver() {
		return currentDriver;
	}

}
