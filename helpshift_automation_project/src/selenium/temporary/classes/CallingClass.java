package selenium.temporary.classes;

import org.openqa.selenium.WebDriver;

import selenium.helpshift.uiElementLib.MainPage;
import selenium.helpshift.uiFunctions.BrowserFunctions;


public class CallingClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver browser=null;
		
		
		BrowserFunctions browserObj=new BrowserFunctions();
		browserObj.launchURLInBrowser("http://test.helpshift.com", "Firefox");
		MainPage mpg=new MainPage(browser);
		mpg.contactUsButton.clear();
		
	}

}
