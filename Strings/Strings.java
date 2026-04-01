// The "Strings" class.
import java.awt.*;
import hsa.Console;

public class Strings
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	c.println ("Please enter str1: ");
	String strFirst = c.readLine ();
	c.println ("Please enter str2: ");
	String strSecond = c.readLine ();
	c.println (permuted (strFirst, strSecond));
	c.println("Please enter keyterm: ");
	String keyTerm = c.readLine();
	c.println("Please enter userInput: ");
	String userInput = c.readLine();
	c.println("Please enter swapTerm: ");
	String swapTerm = c.readLine();
	c.println(replace(keyTerm,userInput,swapTerm));

    }


    public static String replace (String keyTerm, String userInput, String swapTerm)
    {
	int firstIndex = 0;
	int endIndex = userInput.indexOf(keyTerm,firstIndex);
	int keyLength = 0;
	String newString = "";
	while (endIndex != -1)
	{
	    newString = newString + userInput.substring(firstIndex,endIndex) + swapTerm;
	    firstIndex = endIndex + keyTerm.length();
	    endIndex = userInput.indexOf(keyTerm,firstIndex);
	    if (endIndex == -1)
		newString = newString + userInput.substring(firstIndex);
	}
	return newString;
    }
    public static boolean permuted (String strFirst, String strSecond)
    {
	int count = 0;
	int count2 = 0;
	int secondCount = 0;
	int count3 = 0;
	boolean permuted = true;
	if (strFirst.length () == strSecond.length ())
	{
	    while (count < strFirst.length () && permuted == true)
	    {
		while (strFirst.charAt (count) != strSecond.charAt (secondCount) && permuted == true)
		{
		    if (secondCount < strSecond.length () - 1)
			secondCount = secondCount + 1;
		    else
			permuted = false;
		}
		if (permuted == true)
		{
		    for (int i = 0 ; i < strFirst.length () ; i++)
		    {
			if (strFirst.charAt (count) == strFirst.charAt (i))
			    count2 = count2 + 1;
			if (strSecond.charAt (secondCount) == strSecond.charAt (i))
			    count3 = count3 + 1;
		    }
		    c.println ("count2: " + count2);
		    c.println ("count3:" + count3);
		    if (count2 != count3)
			permuted = false;
		    count2 = 0;
		    count3 = 0;
		    count = count + 1;
		    secondCount = 0;
		}
	    }
	}
	else
	    permuted = false;
	return permuted;
    }
}
