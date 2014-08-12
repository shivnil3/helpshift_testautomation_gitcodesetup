package myselenium.helpshift.testcases;

import java.lang.reflect.*;

import selenium.helpshift.Intilializer.Globals;
import selenium.helpshift.UILib.ElementIdentifiers;

public class testReflection extends ElementIdentifiers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-111 generated method stub
		
		Class[] paramString=new Class[1];
		paramString[0]=String.class;
		
try{
/*		Class testClass=Class.forName("myselenium.helpshift.testcases.MyTestClass");
		Object testObj=testClass.newInstance();

		Field myfields[]=testClass.getDeclaredFields();
 		for (Field f:myfields) 		
 		{
 			System.out.println(f.getName());		
 		}
 		
 		Method mymethod=testClass.getDeclaredMethod("display",paramString);
 		System.out.println(mymethod.getName());
 		mymethod.invoke(testObj,"Hellow nilesh");
 		*/
	//ElementIdentifiers obj=new ElementIdentifiers();
	System.out.println(Globals.Bylocator.id.name());
	 		
 		//getmyclass();
 	
	}
catch(Exception e)
{
	System.out.println(e.getStackTrace());
	e.printStackTrace();
}
	}

	public static void getmyclass()
	{
		String myclass=testReflection.class.getCanonicalName();
		System.out.println(myclass);
	}
}
