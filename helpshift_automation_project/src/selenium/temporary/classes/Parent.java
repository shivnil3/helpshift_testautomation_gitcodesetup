package selenium.temporary.classes;

public class Parent {
int i;
String msg, msg2, msg3;
int msg1;
public Parent(String text,int text1)
{
	msg=text;
	msg1=text1;
}

public void setmsg2(String text,String text1)
{
	msg2=text;
	msg3=text1;
}

public void display()
{
	System.out.println(msg + msg1+msg2+msg3);
}

}
