 package selenium.temporary.classes;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opera.core.systems.OperaDesktopDriver;
import com.opera.core.systems.OperaDriver;

//import com.opera.core.systems.OperaDriver;

import selenium.helpshift.globals.Globals;
import selenium.helpshift.loggerFunctions.ResultsLogger;
import selenium.helpshift.uiElementLib.ContactUsForm;
import selenium.helpshift.uiFunctions.ElementIdentifiers;
import selenium.helpshift.uiFunctions.UIFunctions;

public class mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Globals.setCurrentClassNameAs(mytest.class.getCanonicalName());
		//ResultsLogger.logInfo("First Message");
			
		WebDriver driver=new OperaDriver();
		driver.get("http://test.helpshift.com");
		
		//driver.manage().window().maximize();
		//DriverFunctions.setCurrentDriver(driver);
		
		WebElement contactbutton=driver.findElement(By.id("new-issue"));
		contactbutton.click();
		//WebDriverWait wait=new WebDriverWait(driver,5);
		//WebElement contactform=wait.until(ExpectedConditions.elementToBeClickable(By.id("report-issue-modal")));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element .= (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("report-issue-modal")));
		WebElement contactForm = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#report-issue-modal")));
		contactForm.click();
		//WebDriver parentDriver= (WebDriver)contactForm;
		//ContactUsForm.contactNameTextBox.sendKeys("nil");
	
		WebElement contactSubmitbutton=contactForm.findElement(By.className("label-name"));
		System.out.println(contactSubmitbutton.getText());
	//	WebElement contactSubmitbutton=contactForm.findElement(By.className("label-name"));
		
	
	/*	WebElement contactName=driver.findElement(By.id("user-name"));
		contactName.clear();
		contactName.sendKeys("NILESH");
		
		WebElement contactEmail=contactForm.findElement(By.id("user-email"));
		contactEmail.clear();
		contactEmail.sendKeys("shivnil2@gmail.com");
		
		WebElement contactIssueDetails=contactForm.findElement(By.id("user-issue"));
		contactIssueDetails.clear();
		contactIssueDetails.sendKeys("test comments");
	
		WebElement contactSubmitbutton=contactForm.findElement(By.cssSelector("button.modal-submit-button"));
		contactSubmitbutton.submit();
	
		Boolean message=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("message-wrapper"),"Thanks for contacting us. Your message was received."));
		
		if(message)
		{
			System.out.println("successful");
		}
	
		if((message.getText()).equals("Thanks for contacting us. Your message was received."))
			System.out.println("pass");
		else 
			System.out.println("fail");
		
		driver.quit();
*/
	}

}
