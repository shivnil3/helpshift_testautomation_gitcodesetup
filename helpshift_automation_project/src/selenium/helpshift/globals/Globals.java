package selenium.helpshift.globals;

/**
 * This class takes care of the some of the global variables used by the
 * classes.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class Globals {

	public static enum Bylocator {
		id, className, name, tagName, cssSelector, linkText, partialLinkText, xpath
	};

	public static enum browser {
		InternetExplorer, Firefox, Safari, Chrome, Opera
	};

	/**
	 * Check whether the browserName is valid supported browser name and exists
	 * in the browser enum.
	 * 
	 * @param browserName
	 * @return browserFound
	 */
	public static Boolean checkInSupportedBrowserList(String browserName) {
		Boolean browserFound = false;

		for (browser bEnum : browser.values()) {
			if (bEnum.name().equalsIgnoreCase(browserName)) {
				browserFound = true;
			}
		}
		return browserFound;
	}

	/**
	 * Check whether the byLocatorName is valid supported bylocator and exists
	 * in the bylocator enum.
	 * 
	 * @param byLocatorName
	 * @return byLocatorFound
	 */
	public static Boolean checkInSupportedByLocatorList(String byLocatorName) {
		Boolean byLocatorFound = false;

		for (Bylocator bEnum : Bylocator.values()) {
			if (bEnum.name().equalsIgnoreCase(byLocatorName)) {
				byLocatorFound = true;
			}
		}
		return byLocatorFound;
	}

}
