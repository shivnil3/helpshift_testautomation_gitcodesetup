package selenium.helpshift.uiFunctions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.globals.Globals;
import selenium.helpshift.loggerFunctions.ResultsLogger;

/**
 * This class contains methods which can be used for searching WeblEments.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class UIFunctions {

	private Class<String> paramString;
	private Class<?> byClass;
	private final String byClassName = "org.openqa.selenium.By";
	private Method byMethod;
	private WebDriver browserDriver;
	private WebElement uiElement = null;
	private List<WebElement> uiElements;
	private WebDriverWait wait;
	boolean debugEnabled = AutoConfigs.debugEnabled;

	/**
	 * Constructor for the class
	 * 
	 */
	public UIFunctions(WebDriver driver) {
		try {
			browserDriver = driver;
			byClass = Class.forName(byClassName);
			paramString = String.class;

		} catch (ClassNotFoundException e) {
			ResultsLogger.logError(byClassName + " class not found!!!");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		}

	}

	/**
	 * Searches and returns object/WebElement based on ByLocator and locator
	 * values using the driver object
	 * 
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElement
	 */

	public WebElement searchElement(String byLocator, String locatorValue) {
		wait = new WebDriverWait(browserDriver, AutoConfigs.waitTime);
		if (Globals.checkInSupportedByLocatorList(byLocator)) {
			try {
				byMethod = byClass.getDeclaredMethod(byLocator, paramString);
				uiElement=wait.until(ExpectedConditions.visibilityOfElementLocated((By) byMethod.invoke(byClass, locatorValue)));
			} catch (NoSuchElementException e) {
				ResultsLogger.logError("WebElement having " + byLocator
						+ " as " + locatorValue + "not found...");
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (NoSuchMethodException e) {
				ResultsLogger.logError(byLocator + " method not found in "
						+ byClass);
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (IllegalAccessException e) {
				ResultsLogger.logError("Unable to access method " + byLocator
						+ " from class " + byClass);
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (InvocationTargetException e) {
				ResultsLogger.logError("Unable to invoke method " + byLocator
						+ " from class " + byClass);
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} 
			catch(TimeoutException e)
			{	ResultsLogger.logError("Timeout!! Unable to find element in specified time using "
						+ byLocator + " as " + locatorValue);
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
				
			}
			catch (Exception e) {
				ResultsLogger.logError("Error while finding element having "
						+ byLocator + " as " + locatorValue);
				uiElement=null;
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			}

		} else
			ResultsLogger
					.logError("The ByLocator value passed to searchElement() method is not supported or invalid");
		return uiElement;

	}

	/**
	 * Searches and returns a list of objects/WebElements based on ByLocator and
	 * locator values using the driver object
	 * 
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElements
	 */
	public List<WebElement> searchElements(String byLocator, String locatorValue) {
		if (Globals.checkInSupportedByLocatorList(byLocator)) {
			try {
				byMethod = byClass.getDeclaredMethod(byLocator, paramString);
				uiElements = browserDriver.findElements((By) byMethod.invoke(
						byClass, locatorValue));
			} catch (NoSuchElementException e) {
				ResultsLogger.logError("WebElement having " + byLocator
						+ " as " + locatorValue + "not found...");
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			} catch (NoSuchMethodException e) {
				ResultsLogger.logError(byLocator + " method not found in "
						+ byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (IllegalAccessException e) {
				ResultsLogger.logError("Unable to access method " + byLocator
						+ " from class " + byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (InvocationTargetException e) {
				ResultsLogger.logError("Unable to invoke method " + byLocator
						+ " from class " + byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (Exception e) {
				ResultsLogger.logError("Error while finding element having "
						+ byLocator + " as " + locatorValue);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			}
		} else
			ResultsLogger
					.logError("The ByLocator value passed to searchElements() method is not supported or invalid");

		return uiElements;

	}


	/**
	 * Searches the WebElement within the specified parent WebElement using the
	 * ByLocator and locator values
	 * 
	 * @param parentElement
	 * @param byLocator
	 * @param locatorValue
	 * @return uiElement
	 */
	public WebElement searchElementInParentElement(WebElement parentElement,
			String byLocator, String locatorValue) {
		if (Globals.checkInSupportedByLocatorList(byLocator)) {
			try {
				byMethod = byClass.getDeclaredMethod(byLocator, paramString);
				uiElement = parentElement.findElement((By) byMethod.invoke(
						byClass, locatorValue));
			} catch (NoSuchElementException e) {
				ResultsLogger.logError("WebElement having " + byLocator
						+ " as " + locatorValue + "not found...");
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			} catch (NoSuchMethodException e) {
				ResultsLogger.logError(byLocator + " method not found in "
						+ byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (IllegalAccessException e) {
				ResultsLogger.logError("Unable to access method " + byLocator
						+ " from class " + byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());

			} catch (InvocationTargetException e) {
				ResultsLogger.logError("Unable to invoke method " + byLocator
						+ " from class " + byClass);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			} catch (Exception e) {
				ResultsLogger.logError("Error while finding element having "
						+ byLocator + " as " + locatorValue);
				if (debugEnabled)
					ResultsLogger.logDebug(e.getClass().toString());
			}
		} else
			ResultsLogger
					.logError("The ByLocator value passed to searchElementInParentElement() method is not supported or invalid.");
		return uiElement;

	}

	
}
