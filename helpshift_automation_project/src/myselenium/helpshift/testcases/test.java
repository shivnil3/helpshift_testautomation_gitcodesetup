package myselenium.helpshift.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import selenium.helpshift.UIElements.BrowserFunctions;

import com.opera.core.systems.OperaDriver;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		BrowserFunctions bf=new BrowserFunctions();
		
		driver=bf.launchIEBrowser();
		driver.get("http://test.helpshift.com");
		driver.close();
		
		driver=bf.launchFirefoxBrowser();
		driver.get("http://test.helpshift.com");
		driver.close();
		
		driver=bf.launchChromeBrowser();
		driver.get("http://test.helpshift.com");
		driver.close();

		driver=bf.launchOperaBrowser();
		driver.get("http://test.helpshift.com");
		driver.close();

		driver=bf.launchSafariBrowser();
		driver.get("http://test.helpshift.com");
		driver.close();
		
		
	}

}
