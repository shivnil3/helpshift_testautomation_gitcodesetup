package selenium.temporary.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class HTML {
	public static String array2HTML(Object[][] array){
	StringBuilder html = new StringBuilder(
	"<table>");
	for(Object elem:array[0]){
	html.append("<th>" + elem.toString() + "</th>");
	}
	for(int i = 1; i < array.length; i++){
	Object[] row = array[i];
	html.append("<tr>");
	for(Object elem:row){
	html.append("<td>" + elem.toString() + "</td>");
	}
	html.append("</tr>");
	}
	html.append("</table>");
	return html.toString();
	}
	public static void main(String[] args){
		FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            //Creating a new FileWriter object with the file location
            fWriter = new FileWriter("C:/results/file.html");
            //creating a buffered writer for the file object
            writer = new BufferedWriter(fWriter);
            //Adding the initial HTML tags
            writer.write("<html><head><title>come2niks.com</title></head><body>");
            //Adding the data to be displayed in body
            writer.write("Name : <b>NIKHIL NAOGHARE</b>");
            writer.write("<br /><img src='imageSrc/image.jpg' />");
            //Closing the tags
            writer.write("</body></html>");
            //closing the writer object
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	}
