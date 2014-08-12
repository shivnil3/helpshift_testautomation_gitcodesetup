package myselenium.helpshift.testcases;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.helpfshift.LoggerFunctions.ResultsLogger;

public class testReflectionBy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Class[] paramString=new Class[1];
		paramString[0]=String.class;
		
try{

		Class myclass=Class.forName("org.openqa.selenium.By");
		//new Instance won't work as By is  an abstract class
		//Object obj=myclass.newInstance();
		
		Method mymethod=myclass.getDeclaredMethod("iddd",paramString);
		System.out.println(mymethod.getName());

		WebDriver driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
		driver.manage().window().maximize();
		
		/*WebElement contactbutton=driver.findElement((By)mymethod.invoke(myclass,"new-issue"));
		contactbutton.click();
*/
	
	
	
}
catch(NoSuchMethodException e)
{
	ResultsLogger.logError(e.getStackTrace().toString());
	ResultsLogger.logError(e.getMessage());
	ResultsLogger.logError(e.getClass().toString());
	
	
	//System.out.println(e.getStackTrace());
	//e.printStackTrace();
}
catch(ClassNotFoundException e)
{
	ResultsLogger.logError(e.getCause().toString());
	//System.out.println(e.getStackTrace());
	//e.printStackTrace();
}

	}

}
