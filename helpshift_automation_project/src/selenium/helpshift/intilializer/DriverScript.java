package selenium.helpshift.intilializer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import selenium.helpshift.config.AutoConfigs;
import selenium.helpshift.globals.Globals;
import selenium.helpshift.ioFunctions.ReadFiles;
import selenium.helpshift.loggerFunctions.ResultsLogger;

/**
 * This class acts as the driver script and is the starting point of the test
 * suite execution. It picks the test cases names from TestSuite csv file and
 * invokes them based on the specified parameters.
 * 
 * @author Nilesh Awasthey
 * 
 */
public class DriverScript {

	public static void main(String[] args) {
		String testCaseSuiteFile = AutoConfigs.testSuiteFile;
		ArrayList<String> rowData = new ArrayList<String>();
		ReadFiles readFilesObj = new ReadFiles();
		String values[];
		String testcase;
		String browserName;
		int loop;

		try {
			rowData = readFilesObj.readCSVFile(testCaseSuiteFile);

			if (rowData != null) {
				ResultsLogger.logInfo("List of test cases successfully retrieved from TestSuite file-"+testCaseSuiteFile);
				for (String row : rowData) {
					if (!(row.startsWith("#") || row.isEmpty())) {
						values = row.split(",");
						// check testcase value is not empty or null
						if (values[0].isEmpty() || values[0] == null)
							testcase = "";
						else
							testcase = values[0];

						// check browser value is not empty or null
						if (values[1].isEmpty() || values[1] == null)
							browserName = "";
						else
							browserName = values[1];

						// check iterations value is not empty or null
						if (values[2].isEmpty() || values[2] == null)
							loop = 1;
						else
							loop = Integer.parseInt(values[2]);

						// invoke the testcase
						if (!testcase.equals("") && !browserName.equals("")) {
							ResultsLogger.logInfo("Starting with the execution of the test suite");
							if (Globals
									.checkInSupportedBrowserList(browserName)) {
								System.out.println("TestCase - " + testcase +"  Browsername - "+browserName);
								invokeTestCase(testcase, browserName, loop);

							} else {
								ResultsLogger
										.logError("Invalid browser name specified in TestSuite csv file.");
							}
						} else {
							ResultsLogger
									.logError("Testcase name or browser name not specified in TestSuite csv file.");
						}

					}

				}
			} else
				ResultsLogger
						.logError("Couldn't retrieve the test cases from the Testsuite file");

		} catch (Exception e) {
			ResultsLogger
					.logError("Unable to run the testcases in the test suite due to the exception - "
								+ e.getClass().toString());
		}

	}

	/**
	 * Pass the parameters to the specified class constructor and invoke the
	 * runTestCase() method
	 * 
	 * @param testClass
	 * @param browser
	 * @param iterations
	 */
	private static void invokeTestCase(String testClass, String browser,
			int iterations) {
		Boolean debugEnabled = AutoConfigs.debugEnabled;
		String scriptClassCannonicalName = "selenium.helpshift.testcases."
				+ testClass;
		Class<?> currentClass;
		Constructor testClassConstructor;
		Object classObj;
		Class[] constructorParamString = { String.class, Integer.TYPE };
		Method runMethod;
		try {

			currentClass = Class.forName(scriptClassCannonicalName);
			testClassConstructor = currentClass
					.getConstructor(constructorParamString);
			classObj = testClassConstructor.newInstance(browser, iterations);
			runMethod = currentClass.getDeclaredMethod("runTestcase");
			ResultsLogger.logInfo("Starting with the execution of the testcase - "+ testClass);
			runMethod.invoke(classObj);

		} catch (ClassNotFoundException e) {
			ResultsLogger.logError(scriptClassCannonicalName
					+ " class not found..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());

		} catch (NoSuchMethodException e) {
			ResultsLogger.logError("runTestcase() method not found..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (SecurityException e) {
			ResultsLogger.logError("Unable to access method or constructor..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (InstantiationException e) {
			ResultsLogger.logError("Unable to instantiate the class "
					+ scriptClassCannonicalName);
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (IllegalAccessException e) {
			ResultsLogger
					.logError("Unable to access the method or constructor..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());
		} catch (IllegalArgumentException e) {
			ResultsLogger
					.logError("Invalid parameters passed to constructor and method..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());

		} catch (InvocationTargetException e) {
			ResultsLogger.logError("Unable to invoke runTestCase() method..");
			if (debugEnabled)
				ResultsLogger.logDebug(e.getClass().toString());

		}

	}

}
