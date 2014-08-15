package selenium.helpshift.loggerFunctions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import selenium.helpshift.config.AutoConfigs;

/**
 * This class is custom logger which writes the output to html file specified in
 * the log4j.properties file
 * 
 * @author Nilesh Awasthey
 * 
 */
public class ResultsLogger {

	private static ArrayList<String> htmlLogText = new ArrayList<String>();

	/**
	 * Logs the message to the output file with log level as 'Debug'
	 * 
	 * @param message
	 */
	public static void logDebug(String message) {
		writeLogText("DEBUG", message, "Debugging");
	}

	/**
	 * Logs the message to the output file with log level as 'Info'
	 * 
	 * @param message
	 */
	public static void logInfo(String message) {
		writeLogText("INFO", message, "Step Completed");
	}

	/**
	 * Logs the message to the output file with log level as 'Error'
	 * 
	 * @param message
	 */
	public static void logError(String message) {
		writeLogText("ERROR", message, "Error Encountered");
	}

	public static void logPass(String message) {
		writeLogText("STATUS", message, "Step Passed");
	}

	public static void logFail(String message) {
		writeLogText("STATUS", message, "Step Failed");
	}

	/**
	 * Conslidate the logs in an array list which is used for generating the
	 * results html
	 * 
	 * @param msgLevel
	 * @param message
	 * @param status
	 */
	private static void writeLogText(String msgLevel, String message,
			String status) {
		htmlLogText.add("<tr>");

		if (msgLevel.equalsIgnoreCase("ERROR")) {
			htmlLogText.add("<td style=\"color:red;text-align:center\">"
					+ msgLevel + "</td>");
			htmlLogText.add("<td style=\"color:red;text-align:left\">"
					+ message + "</td>");
			htmlLogText.add("<td style=\"color:red;text-align:center\">"
					+ status + "</td>");
		} else if (msgLevel.equalsIgnoreCase("DEBUG")) {
			htmlLogText.add("<td style=\"color:blue;text-align:center\">"
					+ msgLevel + "</td>");
			htmlLogText.add("<td style=\"color:blue;text-align:left\">"
					+ message + "</td>");
			htmlLogText.add("<td style=\"color:blue;text-align:center\">"
					+ status + "</td>");
		} else {
			htmlLogText.add("<td style=\"text-align:center\">" + msgLevel
					+ "</td>");
			htmlLogText.add("<td style=\"text-align:left\">" + message
					+ "</td>");
			htmlLogText.add("<td style=\"text-align:center\">" + status
					+ "</td>");
		}

		htmlLogText.add("</tr>");
	}

	/**
	 * Generates the test case execution results html file in the path specified
	 * in the autoconfigs.properties file
	 * 
	 * @param testCase
	 * @param browser
	 * @param status
	 */
	public static void generateTestcaseResultsHTML(String testCase,
			String browser, Boolean status) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		String testcaseExectionStatus;
		String resultsHtmlFilename = testCase + "_" + browser + "_"
				+ System.currentTimeMillis() + ".html";

		if (status)
			testcaseExectionStatus = "Passed";
		else
			testcaseExectionStatus = "Failed";

		try {
			resultsHtmlFilename = testCase + "_" + browser + "_"
			+ System.currentTimeMillis()+"_" +testcaseExectionStatus+ ".html";
			
			// Creating a new FileWriter object with the file location

			fWriter = new FileWriter(AutoConfigs.resultsFolder + "/"
					+ resultsHtmlFilename);

			// creating a buffered writer for the file object
			writer = new BufferedWriter(fWriter);

			// Adding the initial HTML tags
			writer.write("<!DOCTYPE html>");
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<style>");
			writer.write("table,th,td");
			writer.write("{");
			writer.write("border:1px solid black;");
			writer.write("border-collapse: collapse;");
			writer.write("}");
			writer.write("</style>");
			writer.write("</head>");
			writer.write("<body>");
			writer.write("<table style=\"width:96%;\">");
			writer.write("<tr>");
			writer
					.write("<td style=\"background-color:LightGoldenRodYellow\">");
			writer
					.write("<h1 style=\"margin:0;text-align:center\">Execution Results</h1>");
			writer.write("</td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</p>");
			writer.write("<p style=\"font-size:15px;text-align:center;width:96%\">"+(new Date())+"</p>");					
			writer.write("</p>");
			writer.write("<table style=\"width:40%;font-size:15px;\">");
			writer.write("<tr>");
			writer
					.write("<td style=\"background-color:LightGoldenRodYellow;width:20%;\"><b>TestCase Name</b></td>");
			writer.write("<td>" + testCase + "</td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer
					.write("<td style=\"background-color:LightGoldenRodYellow;width:25%;\"><b>Browser</b></td>");
			writer.write("<td>" + browser + "</td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer
					.write("<td style=\"background-color:LightGoldenRodYellow;width:25%;\"><b>Testcase Status</b></td>");
			writer.write("<td>" + testcaseExectionStatus + "</td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</p></p></p></p></p></p>");
			writer.write("<table style=\"width:96%;font-size:15px\">");
			writer
					.write("<tr style=\"background-color:LightGoldenRodYellow\">");
			writer.write("<th style=\"width:15%\">Level</th>");
			writer.write("<th>Message</th>");
			writer.write("<th style=\"width:15%\">Status</th>");
			writer.write("</tr>");

			// Adding the data to be shown under the Level, Message and Status
			// columns
			for (String htmlLine : htmlLogText) {
				writer.write(htmlLine);
			}

			// Closing tags
			writer.write("</table>");
			writer.write("</body></html>");

			htmlLogText.clear();

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}