package selenium.temporary.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScannerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Get scanner instance
        Scanner scanner = new Scanner(new File("C:/results/SampleCSVFile.csv"));
        
        ArrayList<String> tasks = new ArrayList<String>();
        List<ArrayList<String>> jobs = new LinkedList<ArrayList<String>>();
        //Set the delimiter used in file
        scanner.useDelimiter(",");
         
        //Get all tokens and store them in some data structure
        //I am just printing them
        String testString="testcase";
        int i=1;
        
        while (scanner.hasNext())
        {
        	//System.out.println(i++ + " " +scanner.nextLine().toString());
           tasks.add(scanner.nextLine().toString());
        }
         
        for (String e:tasks)
        {
        	System.out.println(e);
        }
        
       /* for (ArrayList<String> e:jobs)
        {
        	System.out.println(e.toString());
        }
       */ 	
        //Do not forget to close the scanner 
        scanner.close();

	}

}
