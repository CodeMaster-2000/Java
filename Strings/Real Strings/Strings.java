// The "Strings" class.
/*
Author: Swethan Sivasegaran
Date: October 25 2017
Purpose: To showcase the capability of manipulating STRINGS via assignment
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS STRINGS
/*
Author: Swethan Sivasegaran
Date: October 25 2017
Purpose: To manipulate STRINGS efficiently to the user's convenience

DATA FIELDS - None

METHODS

main - To excessively test the functionality of each STRING manipulation method and its expansive potential for future use

replace - Given a STRING type parameter value (userInput), switches each OCCURENCE of the STRING type parameter value (keyTerm)
	  in the STRING type parameter value (userInput) with the STRING type parameter value (swapTerm) and
	  returns the altered STRING type value.
	  - returns the STRING type paramter value (userInput) as it is if there are no OCCURENCES of the STRING type paramter value
	    (keyTerm)

permuted - Given two STRING parameter values, compares both STRING values and returns a boolean value depending of if the
	   two STRING parameter values are permutations of each other.
	   - returns true if the STRING values are permutations of each other (same length and same unique character occurences)
	   - otherwise returns false
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class Strings
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 25 2017
    Purpose: To excessively test the functionality of each STRING manipulation method and its expansive potential for future use
    Input: None - inputs from the user via Console
    Output: None - the individual output of the methods tested for its functionality
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	
	//Initialization
	String userInput = "";
	String keyTerm = "";
	String swapTerm = "";
	String first = "";
	String second = "";
	int repeat = 0;
	
	//Process
	while (repeat == 0)
	{
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.print ("Strings Testing");
	    c.print ("\n\nREPLACE METHOD");
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a phrase: ");
	    userInput = c.readLine ();
	    c.print ("Please enter a term within the phrase to replace: ");
	    keyTerm = c.readString ();
	    c.print ("Please enter a term to replace the desired replace term: ");
	    swapTerm = c.readString ();
	    c.setTextColor (Color.black);
	    c.print ("\n\nOldString: " + userInput);
	    c.print ("\nNewString: " + replace (keyTerm, userInput, swapTerm));
	    c.setTextColor (Color.red);
	    c.print ("\n\nPERMUTED");
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter the first STRING to be compared: ");
	    first = c.readString ();
	    c.print ("Please enter the second String to be compared: ");
	    second = c.readString ();
	    c.setTextColor (Color.black);
	    c.print ("\n\nThe status of permuted is: " + permuted (first, second));
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a 0(to restart program) or any other key to end program: ");
	    repeat = c.readInt ();
	}



    }


    // ======================================================================================================

    // replace

    /*
    Author: Swethan Sivasegaran
    Date: October 25 2017
    Purpose: Given a STRING type parameter value (userInput), switches each OCCURENCE of the STRING type parameter value (keyTerm)
	     in the STRING type parameter value (userInput) with the STRING type parameter value (swapTerm) and
	     returns the altered STRING type value.
	     - returns the STRING type paramter value (userInput) as it is if there are no OCCURENCES of the STRING type paramter value
	       (keyTerm)
    Input: A STRING type parameter value (userInput) - the original STRING to manipulate
	   A STRING type parameter value (keyTerm)  - the desired substring within the original STRING to replace
	   A STRING type parameter value (swapTerm) - the desired STRING value to replace each occurence of the keyTerm
    Output: A STRING type value representing the altered original parameter STRING value (userInput) after replacing each OCCURENCE of the
	    desired substring(keyTerm) with the STRING value (swapTerm)
	    - returns the STRING type paramter value (userInput) as it is if there are no OCCURENCES of the STRING type paramter value
	      (keyTerm)
    */

    public static String replace (String keyTerm, String userInput, String swapTerm)
    {
	//Initialization
	int firstIndex = 0;
	int endIndex = userInput.indexOf (keyTerm, firstIndex);
	int keyLength = 0;
	String newString = "";
	
	//Process
	while (endIndex != -1)
	{
	    newString = newString + userInput.substring (firstIndex, endIndex) + swapTerm;
	    firstIndex = endIndex + keyTerm.length ();
	    endIndex = userInput.indexOf (keyTerm, firstIndex);
	}
	if (endIndex == -1)
	    newString = newString + userInput.substring (firstIndex);
	    
	return newString;
    }


    // -------------------------------------------------------------------------------------------------------

    // permuted

    /*
    Author: Swethan Sivasegaran
    Date: October 26 2017
    Purpose: Given two STRING parameter values, compares both STRING values and returns a boolean value depending of if the
	     two STRING parameter values are permutations of each other.
	     - returns true if the STRING values are permutations of each other (same length and same unique character occurences)
	     - otherwise returns false
    Input: TWO STRING parameter values - to compare permutations with each other
    Output: A BOOLEAN value depending on if the two STRING parameter values are permutations of each other
	    - returns true if the STRING values are permutations of each other (same length and same unique character occurences)
	    - otherwise returns false
    */
    public static boolean permuted (String strFirst, String strSecond)
    {
	//Initialization
	int count = 0;
	int count2 = 0;
	int secondCount = 0;
	int count3 = 0;
	boolean permuted = true;
	
	//Process
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


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
