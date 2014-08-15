package selenium.helpshift.ioFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import selenium.helpshift.loggerFunctions.ResultsLogger;

/**
 * Class to handle file IO operations
 * 
 * @author Nilesh Awasthey
 * 
 */
public class ReadFiles {

	/**
	 * Reads the data from a csv file and returns of a String array list of rows
	 * 
	 * @param fileName
	 * @return Arraylist of rows
	 */
	public ArrayList<String> readCSVFile(String fileName) {
		ArrayList<String> csvRow = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				csvRow.add(scanner.nextLine().toString());
			}
			ResultsLogger.logInfo(fileName + " was read successfully.");
		} catch (FileNotFoundException e) {
			ResultsLogger.logError(fileName + " not found..");
		} finally {
			scanner.close();
		}
		return csvRow;
	}

}
