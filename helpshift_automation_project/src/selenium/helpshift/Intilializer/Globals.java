package selenium.helpshift.Intilializer;

/**
 * This class takes care of the some of the global variables used by the
 * classes.
 * 
 * @author nil
 * 
 */
public class Globals {

	private static String currentClassName;
	public static enum Bylocator{id,className,name,tagName,cssSelector,linkText,partialLinkText,xpath};
	
	/**
	 * set the value for currentClassName
	 * 
	 * @param className
	 *            Class Canonical Name
	 */
	public static void setCurrentClassNameAs(String className) {
		currentClassName = className;
	}

	/**
	 * returns the value of currentClassName
	 * 
	 * @return currentClassName
	 */
	public static String getCurrentClassName() {
		return currentClassName;
	}

}
