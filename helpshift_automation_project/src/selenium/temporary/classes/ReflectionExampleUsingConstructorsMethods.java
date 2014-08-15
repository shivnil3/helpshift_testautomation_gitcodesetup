package selenium.temporary.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.gargoylesoftware.htmlunit.StorageHolder.Type;

import selenium.helpshift.globals.Globals;
import selenium.helpshift.loggerFunctions.ResultsLogger;

public class ReflectionExampleUsingConstructorsMethods {
	
	@SuppressWarnings("unchecked")
	public static void main(String... s)
	{
		int num;
		
			try {
				String myid=Globals.Bylocator.id.name();
				System.out.println(myid);
				Class<?> currentClass = Class.forName("selenium.temporary.classes.Parent");
				//Object testObj=urrentClass.newInstance("hello");
				System.out.println(currentClass.getCanonicalName());
				Class[] paramString = {String.class,Integer.TYPE};
				Class[] paramString1 = {String.class,String.class};
				Constructor myconst=currentClass.getConstructor(paramString);
				Object testObj=myconst.newInstance("Nilse",10);
				Method mymethod=currentClass.getMethod("setmsg2",paramString1);
				mymethod.invoke(testObj,"dilli","billi");
				Method mymethod1=currentClass.getMethod("display");
				mymethod1.invoke(testObj);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			}

}
