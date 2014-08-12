/**
 * 
 */
package selenium.helpshift.UIElements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;
import selenium.helpshift.Intilializer.AutomationConfigurations;
import selenium.helpshift.Intilializer.Globals;

/**This class contains methods which can be used for searching WeblEments.
 * @author nil
 * 
 */
public class UIFunctions {

	private Class<String> paramString;
	private Class<?> byClass;
	private final String byClassName = "org.openqa.selenium.By";
	private Method byMethod;
	public WebDriver driver = DriverFunctions.getCurrentDriver();
	private WebElement uiElementAfterWait = null;
	private WebElement uiElement = null;
	private List<WebElement> uiElements;
	private WebDriverWait wait;
	boolean debugEnabled = AutomationConfigurations.debugEnabled;

	/**Constructor for the class
	 * 
	 */
	public UIFunctions() {
		try {
			Globals.setCurrentClassNameAs(BrowserFunctions.class
					.getCanonicalName());
			paramString = String.class;
			byClass = Class.forName(byClassName);

		} catch (ClassNotFoundException e) {
			ResultsLogger.logError(byClassName + " class not found!!!");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}

	}

	/**Searches and returns object/WebElement based on ByLocator and locator values using the driver object
	 * 
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElement
	 */

	public WebElement searchElement(String byLocator, String locatorValue) {
		try {
			byMethod = byClass.getDeclaredMethod(byLocator, paramString);
			uiElement = driver.findElement((By) byMethod.invoke(byClass,
					locatorValue));

		} catch (NoSuchElementException e) {
			ResultsLogger.logError("WebElement having " + byLocator + " as "
					+ locatorValue + "not found...");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (NoSuchMethodException e) {
			ResultsLogger.logError(byLocator + " method not found in "
					+ byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (IllegalAccessException e) {
			ResultsLogger.logError("Unable to access method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (InvocationTargetException e) {
			ResultsLogger.logError("Unable to invoke method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (Exception e) {
			ResultsLogger.logError("Error while finding element having "
					+ byLocator + " as " + locatorValue);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		}

		return uiElement;

	}

	/**Searches and returns a list of objects/WebElements based on ByLocator and locator values using the driver object
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElements
	 */
	public List<WebElement> searchElements(String byLocator, String locatorValue) {
		try {
			byMethod = byClass.getDeclaredMethod(byLocator, paramString);
			uiElements = driver.findElements((By) byMethod.invoke(byClass,
					locatorValue));
		} catch (NoSuchElementException e) {
			ResultsLogger.logError("WebElement having " + byLocator + " as "
					+ locatorValue + "not found...");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} catch (NoSuchMethodException e) {
			ResultsLogger.logError(byLocator + " method not found in "
					+ byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (IllegalAccessException e) {
			ResultsLogger.logError("Unable to access method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (InvocationTargetException e) {
			ResultsLogger.logError("Unable to invoke method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (Exception e) {
			ResultsLogger.logError("Error while finding element having "
					+ byLocator + " as " + locatorValue);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}
		return uiElements;

	}

	/**Try to search and waits for specified time until the object/element is available. Returns the WebElement that is found.
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElementAfterWait
	 */
	public WebElement waitAndSearchElement(String byLocator, String locatorValue) {
		wait = new WebDriverWait(driver, AutomationConfigurations.waitTime);
		uiElementAfterWait = (WebElement) wait.until(ExpectedConditions
				.elementToBeClickable(searchElement(byLocator, locatorValue)));
		return uiElementAfterWait;

	}

	/** Searches the WebElement within the specified parent WebElement using the ByLocator and locator values     
	 * @param parentElement
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElement
	 */
	public WebElement searchElementInParentElement(WebElement parentElement,
			String byLocator, String locatorValue) {
		try {
			byMethod = byClass.getDeclaredMethod(byLocator, paramString);
			uiElement = parentElement.findElement((By) byMethod.invoke(byClass,
					locatorValue));

		} catch (NoSuchElementException e) {
			ResultsLogger.logError("WebElement having " + byLocator + " as "
					+ locatorValue + "not found...");
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} catch (NoSuchMethodException e) {
			ResultsLogger.logError(byLocator + " method not found in "
					+ byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (IllegalAccessException e) {
			ResultsLogger.logError("Unable to access method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());

		} catch (InvocationTargetException e) {
			ResultsLogger.logError("Unable to invoke method " + byLocator
					+ " from class " + byClass);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		} catch (Exception e) {
			ResultsLogger.logError("Error while finding element having "
					+ byLocator + " as " + locatorValue);
			if (debugEnabled)
				ResultsLogger.logError(e.getClass().toString());
		}

		return uiElement;

	}

}
