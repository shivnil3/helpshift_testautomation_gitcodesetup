 package myselenium.helpshift.testcases;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;
import selenium.helpshift.Intilializer.Globals;
import selenium.helpshift.UIElements.DriverFunctions;
import selenium.helpshift.UIElements.UIFunctions;
import selenium.helpshift.UILib.ContactUsForm;
import selenium.helpshift.UILib.ElementIdentifiers;

public class mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Globals.setCurrentClassNameAs(mytest.class.getCanonicalName());
		//ResultsLogger.logInfo("First Message");
			
		WebDriver driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
		
		driver.manage().window().maximize();
		DriverFunctions.setCurrentDriver(driver);
		
		WebElement contactbutton=driver.findElement(By.id("new-issue"));
		contactbutton.click();
		//WebDriverWait wait=new WebDriverWait(driver,5);
		//WebElement contactform=wait.until(ExpectedConditions.elementToBeClickable(By.id("report-issue-modal")));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element .= (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("report-issue-modal")));
		WebElement contactForm = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#report-issue-modal")));
		contactForm.click();
		//WebDriver parentDriver= (WebDriver)contactForm;
		ContactUsForm.contactNameTextBox.sendKeys("nil");
	
		WebElement contactName=driver.findElement(By.cssSelector("input#user-name"));
		contactName.sendKeys("NILESH");
		
		WebElement contactEmail=contactForm.findElement(By.cssSelector("input#user-email"));
		contactEmail.sendKeys("shivnil2@gmail.com");
		
		WebElement contactIssueDetails=contactForm.findElement(By.cssSelector("textarea#user-issue"));
		contactIssueDetails.sendKeys("test comments");
	
		WebElement contactSubmitbutton=contactForm.findElement(By.cssSelector("button.modal-submit-button"));
		contactSubmitbutton.submit();
	
		Boolean message=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("message-wrapper"),"Thanks for contacting us. Your message was received."));
		
		if(message)
		{
			System.out.println("successful");
		}
	
		/*if((message.getText()).equals("Thanks for contacting us. Your message was received."))
			System.out.println("pass");
		else 
			System.out.println("fail");
		*/
		//driver.close();

	}

}
