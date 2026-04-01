// The "StackTest" class.
/*
Author: Swethan Sivasegaran
Date: January 8 2018
Purpose: To demonstrate an understanding and capability of the ABSTRACT DATA type - STACKS - and its practical applications in many problems such as BRACKET CHECKING
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.*;
// CLASS STACKTEST
/*
Author: Swethan Sivasegaran
Date: January 8 2018
Purpose: To test the functionality of each method in the PARENTHESIS class and its demonstration of stacks in practical applications

DATA FIELDS - None

METHODS

main - To test the functionality of the PARENTHESIS class and its application of Stacks
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class StackTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: To test the functionality of the PARENTHESIS class and its application of Stacks
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs yielded from each method of the PARENTHESIS class via Console
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	int repeat = 1;
	String fileName = "";
	Parenthesis parenthesis = new Parenthesis();
	while (repeat == 1)
	{
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Parenthesis Testing\n");
	    parenthesis.getString(c);
	    c.setTextColor(Color.black);
	    c.println("\n\nParenthesis Evaluation: " + parenthesis.bracketCheck());
	    c.setTextColor(Color.blue);
	    c.print("\nPlease enter a file name including extension (Ex. txt): ");
	    fileName = c.readString();
	    c.setTextColor(Color.black);
	    c.println("\n\nParenthesis Text File Evaluation\n" + parenthesis.readFromFile(fileName));
	    c.setTextColor(Color.blue);
	    c.print("\n\nPlease enter a 1 (to restart program) or any other key to end program: ");
	    repeat = c.readInt();
	}


    }
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS NODE
/*
Author: Swethan Sivasegaran
Date: December 21 2017
Purpose: To PROVIDE a sort of container class to store individual STRING data information in addition to keeping check on the data of ANOTHER NODE and its following NODES such that it can be used in a LINKED LIST. In addition, the
	 basic manipulation of the data or NODE tracking should be managed. The NODE pointer is defaulted to NULL.

DATA FIELDS

data (STRING) - A STRING type data field that represents the CURRENT NODE's holding of STRING DATA information.
next (NODE) - A NODE type data field that points to another NODE type Object for the purpose of using LINKED LISTS to STORE data

METHODS

Constructor (with ONE PARAMETER) - Given a STRING type parameter value (data), sets the STRING type data field (data) to its respective parameter value and the NODE type data field pointer (next) to NULL. Hence there is no established
				   link created in the Constructor.

Constructor (with NO PARAMETERS) - Given NO PARAMETER values, sets the STRING type data field (data) to STRING value of DEFAULT and the NODE type data field (next) to NULL by calling the Constructor (with ONE PARAMTER)

clone - Based on the STRING type data field (data) and the NODE type data field (next), returns an OBJECT that points to a different address but contains the EXACT SAME information as the CURRENT
	NODE object including its NODE type data field (next) STRING type data field (data) information.

toString - Based on the STRING type data field (data), returns a STRING value corresponding to the CURRENT NODE's STRING type data field (data) and the NODE type data field (next)'s STRING type data field (data) and its
	   NODE type data field (next)'s STRING information in a recursive like manner until a NODE type data field (next) points to a NULL in which the STRING value will contain a NULL at the end.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Node implements Cloneable
{
    //DATA FIELDS
    protected String data = "";
    protected Node next;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Given a STRING type parameter value (data), sets the STRING type data field (data) to its respective parameter value and the NODE type data field pointer (next) to NULL. Hence there is no established
	     link created in the Constructor.
    Input: A STRING type parameter value
    Output: None - initializes the STRING type data field (data) to the given STRING parameter value and the NODE type data field pointer (next) to NULL
    */
    public Node (String data)
    {
	this.data = data;
	this.next = null;
    }


    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Given NO PARAMETER values, sets the STRING type data field (data) to STRING value of DEFAULT and the NODE type data field (next) to NULL by calling the Constructor (with ONE PARAMTER)
    Input: None
    Output: None - initializes the STRING type data field (data) to DEFAULT and the NODE type data field pointer (next) to NULL
    */
    public Node ()
    {
	this ("DEFAULT");
    }


    // -------------------------------------------------------------------------------------------------------

    // clone

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Based on the STRING type data field (data) and the NODE type data field (next), returns an OBJECT that points to a different address but contains the EXACT SAME information as the CURRENT
	     NODE object including its NODE type data field (next) STRING type data field (data) information.
    Input: None
    Output: Returns an OBJECT that points to a different address but contains the EXACT SAME information as the CURRENT NODE object including its NODE type data field (next) STRING type data field (data) information.
    */
    public Object clone () throws CloneNotSupportedException
    {
	Node object = (Node) super.clone ();
	if (this.next != null)
	    object.next = (Node) this.next.clone ();
	else
	    object.next = null;
	return object;
    }


    // ======================================================================================================

    // toString

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Based on the STRING type data field (data), returns a STRING value corresponding to the CURRENT NODE's STRING type data field (data) and the NODE type data field (next)'s STRING type data field (data) and its
	     NODE type data field (next)'s STRING information in a recursive like manner until a NODE type data field (next) points to a NULL in which the STRING value will contain a NULL at the end.
    Input: None
    Output: A STRING value corresponding to the CURRENT NODE's STRING type data field (data) and the NODE type data field (next)'s STRING type data field (data) and its NODE type data field (next)'s STRING information in a
	    recursive like manner until a NODE type data field (next) points to a NULL in which the STRING value will contain a NULL at the end.
    */
    public String toString ()
    {
	String result = this.data + " --> ";
	if (this.next != null)
	    result = result + this.next.toString ();
	else
	    result = result + " Null ";
	return result;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS STACK
/*
Author: Swethan Sivasegaran
Date: January 8 2017
Purpose: Based on a SINGLYLINKEDLIST concept, the STACK class implements the concept of STACKS into this data strcuture to demonstrate an understanding of abstract data structures for specific purposes

DATA FIELDS

root (NODE) - A NODE type data field that is used as a STARTING REFRENCE of the STACK class and is used to access other NODES from which the root uses its NODE type data field (next) to access through.

METHODS

isEmpty - Based on the NODE type data field (root), returns a BOOLEAN value corresponding to the whether there is an EMPTY LINKED LIST or not.
	  - returns True if the NODE type data field (root) points to a NULL
	  - returns False otherwise

clone - Based on the NODE type data field (root), returns an OBJECT of the CURRENT SINGLELINKEDLIST by calling the OVERRIDEN CLONE method in the NODE class (see Method clone within NODE)
	and essentially creates a complete copy pointing to a different address in RAM that retains the EXACT SAME STRING information of the NODE type data field (root) and the NODE type data element
	pointers (next) STRING information that follow it until a NULL pointer is reached.

toString - BASED on the NODE type data field (root), return a STRING value that corresponds to the STRING information of all NODE type data element pointers (next) STRING information that the NODE type
	   data element (root) initially points to until a NULL pointer is reached. This is achieved by calling toString (see Method toString within NODE).

push - Given a STRING parameter value (data), creates a NEW INSTANCE of a NODE and inserts it into the beginning of the SINGLY LINKED LIST such that the FIRST NODE originally is shifted to the NEW NODE's NODE type data field
       next pointer (see NODE class). Essentially, the NEW NODE becomes the NODE type data field (ROOT).

pop - Based on the NODE type data field (ROOT), returns a STRING value that corresponds to the NODE type data field (ROOT)'s STRING data field value (data) or rather its STRING data information that it holds. In addition, the
      method deletes the NODE from the SINGLY LINKED LIST and ensures the NODE that the ORIGINAL ROOT's NODE type data field (next) - see NODE class - becomes the NODE type data field (ROOT).
      Note: The method performs nothing and returns nothing if the SINGLY LINKED LIST is empty.

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Stack implements Cloneable
{
    //DATA FIELDS
    protected Node root;


    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Given a STRING parameter value, sets the NODE type data field (root) to a new INSTANCE of a NODE with STRING data field (data) value set to the given parameter value. Hence, creating a LINKED LIST with ONE NODE.
    Input: None
    Output: None - initializes the NODE type data field (root) to new INSTANCE of a NODE with the STRING parameter value as its STRING data element.
    */
    public Stack (String data)
    {
	this.root = new Node (data);
    }


    // -------------------------------------------------------------------------------------------------------
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Given NO PARAMETERS, sets the NODE type data field (root) to NULL essentially being an EMPTY LINKED LIST.
    Input: None
    Output: None - initializes the NODE type data field (root) to NULL
    */
    public Stack ()
    {
	this.root = null;
    }


    // ======================================================================================================

    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Based on the NODE type data field (root), returns a BOOLEAN value corresponding to the whether there is an EMPTY LINKED LIST or not.
	     - returns True if the NODE type data field (root) points to a NULL
	     - returns False otherwise
    Input: None
    Output: Returns a BOOLEAN value corresponding to the whether there is an EMPTY LINKED LIST or not.
	    - returns True if the NODE type data field (root) points to a NULL
	    - returns False otherwise
    */
    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.root == null)
	    empty = true;
	return empty;

    }


    // -------------------------------------------------------------------------------------------------------

    // clone

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: Based on the NODE type data field (root), returns an OBJECT of the CURRENT SINGLELINKEDLIST by calling the OVERRIDEN CLONE method in the NODE class (see Method clone within NODE)
	     and essentially creates a complete copy pointing to a different address in RAM that retains the EXACT SAME STRING information of the NODE type data field (root) and the NODE type data element
	     pointers (next) STRING information that follow it until a NULL pointer is reached.
    Input: None
    Output: Returns an OBJECT of the CURRENT SINGLELINKEDLIST pointing to a different address in RAM that retains the EXACT SAME STRING information of the NODE type data field (root) and the NODE type
	    data element pointers (next) STRING information that follow it until a NULL pointer is reached.
    */
    public Object clone () throws CloneNotSupportedException
    {
	Stack object = (Stack) super.clone ();
	if (this.root == null)
	    object.root = null;
	else
	    object.root = (Node) this.root.clone ();
	return object;
    }


    // ======================================================================================================
    // toString

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: BASED on the NODE type data field (root), return a STRING value that corresponds to the STRING information of all NODE type data element pointers (next) STRING information that the NODE type
	     data element (root) initially points to until a NULL pointer is reached. This is achieved by calling toString (see Method toString within NODE).
    Input: None
    Output: A STRING value that corresponds to the STRING information of all NODE type data element pointers (next) STRING information that the NODE type
	    data element (root) initially points to until a NULL pointer is reached
    */
    public String toString ()
    {
	String result = "";
	if (this.root != null)
	    result = "Linked List: " + this.root.toString ();
	else
	    result = "Linked List: Empty";
	return result;
    }


    // -------------------------------------------------------------------------------------------------------
    // push

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Given a STRING parameter value (data), creates a NEW INSTANCE of a NODE and inserts it into the beginning of the SINGLY LINKED LIST such that the FIRST NODE originally is shifted to the NEW NODE's NODE type data field
	     next pointer (see NODE class). Essentially, the NEW NODE becomes the NODE type data field (ROOT).
    Input: A STRING type parameter value
    Output: None - creates a NEW INSTANCE of a NODE and inserts it into the beginning of the SINGLY LINKED LIST such that the FIRST NODE originally is shifted to the NEW NODE's NODE type data field next pointer (see NODE class).
	    Essentially, the NEW NODE becomes the NODE type data field (ROOT).
    */
    public void push (String data)
    {
	Node newNode = new Node (data);
	if (this.root != null)
	{
	    newNode.next = this.root;
	    this.root = newNode;
	}
	else
	    this.root = newNode;
    }


    // -------------------------------------------------------------------------------------------------------
    // pop

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Based on the NODE type data field (ROOT), returns a STRING value that corresponds to the NODE type data field (ROOT)'s STRING data field value (data) or rather its STRING data information that it holds. In addition, the
	     method deletes the NODE from the SINGLY LINKED LIST and ensures the NODE that the ORIGINAL ROOT's NODE type data field (next) - see NODE class - becomes the NODE type data field (ROOT).
	     Note: The method performs nothing and returns nothing if the SINGLY LINKED LIST is empty.
    Input: None
    Output: Returns a STRING value that corresponds to the NODE type data field (ROOT)'s STRING data field value (data) or rather its STRING data information that it holds. In addition, the
	    method deletes the NODE from the SINGLY LINKED LIST and ensures the NODE that the ORIGINAL ROOT's NODE type data field (next) - see NODE class - becomes the NODE type data field (ROOT).
	    Note: The method performs nothing and returns nothing if the SINGLY LINKED LIST is empty.
    */
    public String pop ()
    {
	String result = "";
	if (this.root != null)
	{
	    result = this.root.data;
	    this.root = this.root.next;
	}
	return result;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS PARENTHESIS
/*
Author: Swethan Sivasegaran
Date: January 8 2018
Purpose: To demonstrate the use of STACKS in practical applications such as BRACKET CHECKING and provide the class with the full capability of demonstrating this usage with STRINGS in different formats including TEXT FILES or
	 given STRINGS that are given directly.

DATA FIELDS
data (STRING) - a STRING type data field that represents the STRING value that is tested on for proper use of PARENTHESIS or BRACKETS
list (STACK) - a STACK type data field that uses the ABSTRACT DATA STORAGE concept of STACKS containing a SINGLY LINKED LIST which is used throuhgout the class to determine the proper use of PARENTHESIS

METHODS

Constructor (with ONE PARAMETER) - Given a STRING parameter value (data), sets the STRING type data field (data) to the given parameter value and creates a NEW INSTANCE of a STACK class which contains an EMPTY SINGLY LINKED LIST (see Method Constructor
				   with NO PARAMETERS within the STACK CLASS).

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the STRING type data field (data) to DEFAULT and creates a NEW INSTANCE of a STACK class containing an EMPTY SINGLY LINKED LIST using the Constructor (with ONE PARAMETER) - see Method Constructor
				   (with ONE PARAMETER) within the class.

getString - Given a CONSOLE type parameter value, interacts and recieves a STRING value from the user via CONSOLE in which it sets the STRING type data field (data) to the set value.

bracketCheck - Based on the STRING type data field (data), reads through the entire STRING type data field (data) for each ASCII character and returns a STRING value that corresponds to whether the STRING type data field (data)
	       followed the rules of bracket usage. If there is an error, the location of that error will be indicated. To achieve such an action, the method calls push and pop (see Method push and pop WITHIN the STACK class)
	       using a STACK application in which opening brackets are inserted into a linked list while closing brackets are remove the opening brackets within the linked list in such an order that it should follow the rules for
	       bracket usage.
	       - returns GOOD STRUCTURE if there are no problems
	       - returns MISMATCHED BRACKETS if an opening bracket ends with the wrong corresponding closing bracket type
	       - returns TOO MANY CLOSE BRACKETS if the number of closing brackets exceeds the number of opening brackets initiated
	       - returns TOO MANY OPENING BRACKETS if some of the opening brackets were left unchecked at the end of the STRING type data field (data)

readFromFile - Given a STRING parameter value (fileName) corresponding to a given file, reads each ASCII value in each LINE of the given file's STRING TEXT value and returns a STRING value corresponding to whether the TEXT FILE
	       correctly used brackets within the file. If there is an error, the LINE NUMBER and the POSITION number are outputted. To perform this, the method calls the methods push and pop (see Method push and pop WITHIN
	       the STACK CLASS). Hence, in this way, opening brackets are inserted into a SINGLY LINKED LIST while closing brackets remove these opening brackets to determine whether there is an error or not.
	       - returns GOOD STRUCTURE if the TEXT FILE uses brackets properly
	       - returns MISMATCHED BRACKETS if the TEXT FILE has an opening bracket that ends with a closing bracket that does not match in bracket type
	       - returns TOO MANY CLOSE BRACKETS if the TEXT FILE has too many close brackets in relation to the number of opening brackets initiated
	       - returns TOO MANY OPEN BRACKETS if the TEXT FILE has too many open brackets that have gone unchecked at the end of the TEXT FILE
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Parenthesis
{
    //DATA FIELDS
    protected String data = "";
    protected Stack list;
    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Given a STRING parameter value (data), sets the STRING type data field (data) to the given parameter value and creates a NEW INSTANCE of a STACK class which contains an EMPTY SINGLY LINKED LIST (see Method Constructor
	     with NO PARAMETERS within the STACK CLASS).
    Input: None
    Output: None - initializes the STRING type data field (data) to the given parameter value and creates a new INSTANCE of a STACK class which contains an EMPTY SINGLY LINKED LIST (see Method Constructor with NO PARAMETERS within
	    the STACK CLASS).
    */
    public Parenthesis (String data)
    {
	this.data = data;
	this.list = new Stack ();
    }


    // ======================================================================================================
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Given NO PARAMETERS, sets the STRING type data field (data) to DEFAULT and creates a NEW INSTANCE of a STACK class containing an EMPTY SINGLY LINKED LIST using the Constructor (with ONE PARAMETER) - see Method Constructor
	     (with ONE PARAMETER) within the class.
    Input: None
    Output: None - sets the STRING type data field (data) to DEFAULT and creates a NEW INSTANCE of a STACK class containing an EMPTY SINGLY LINKED LIST using the Constructor (with ONE PARAMETER) - see Method Constructor (with ONE
	    PARAMETER) within the class.
    */
    public Parenthesis ()
    {
	this ("DEFAULT");
    }


    // -------------------------------------------------------------------------------------------------------
    // getString

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Given a CONSOLE type parameter value, interacts and recieves a STRING value from the user via CONSOLE in which it sets the STRING type data field (data) to the set value.
    Input: A CONSOLE type parameter value
    Output: None - interacts and recieves a STRING value from the user via CONSOLE in which it sets the STRING type data field (data) to the set value.
    */
    public void getString (Console c)
    {
	c.setTextColor(Color.blue);
	c.print ("Please enter a STRING value to bracket check and evaluate: ");
	this.data = c.readString ();
    }


    // ======================================================================================================
    // bracketCheck

    /*
    Author: Swethan Sivasegaran
    Date: January 8 2018
    Purpose: Based on the STRING type data field (data), reads through the entire STRING type data field (data) for each ASCII character and returns a STRING value that corresponds to whether the STRING type data field (data)
	     followed the rules of bracket usage. If there is an error, the location of that error will be indicated. To achieve such an action, the method calls push and pop (see Method push and pop WITHIN the STACK class)
	     using a STACK application in which opening brackets are inserted into a linked list while closing brackets are remove the opening brackets within the linked list in such an order that it should follow the rules for
	     bracket usage.
	     - returns GOOD STRUCTURE if there are no problems
	     - returns MISMATCHED BRACKETS if an opening bracket ends with the wrong corresponding closing bracket type
	     - returns TOO MANY CLOSE BRACKETS if the number of closing brackets exceeds the number of opening brackets initiated
	     - returns TOO MANY OPENING BRACKETS if some of the opening brackets were left unchecked at the end of the STRING type data field (data)
    Input: None
    Output: Returns a STRING value that corresponds to whether the STRING type data field (data) followed the rules of bracket usage. If there is an error, the location of that error will be indicated.
	     - returns GOOD STRUCTURE if there are no problems
	     - returns MISMATCHED BRACKETS if an opening bracket ends with the wrong corresponding closing bracket type
	     - returns TOO MANY CLOSE BRACKETS if the number of closing brackets exceeds the number of opening brackets initiated
	     - returns TOO MANY OPENING BRACKETS if some of the opening brackets were left unchecked at the end of the STRING type data field (data)
    */

    public String bracketCheck ()
    {
	int index = 0;
	boolean error = false;
	String bracket = "";
	String message = "";
	while (error == false && index != this.data.length ())
	{
	    if (this.data.charAt (index) == 40 || this.data.charAt (index) == 91 || this.data.charAt (index) == 123)
		this.list.push (this.data.charAt (index) + "");
	    else if (this.data.charAt (index) == 41 || this.data.charAt (index) == 93 || this.data.charAt (index) == 125)
	    {
		if (this.list.root != null)
		{
		    bracket = this.list.pop ();
		    if (bracket.equals ((char) (this.data.charAt (index) - 1) + "") == false && bracket.equals ((char) (this.data.charAt (index) - 2) + "") == false)
		    {
			error = true;
			message = "Mismatched brackets at position " + index;
		    }
		}
		else
		{
		    error = true;
		    message = "Too many close brackets at position " + index;
		}

	    }
	    index = index + 1;
	}
	if (this.list.root != null)
	{
	    error = true;
	    message = "Too Many Open Brackets at position " + index;
	}
	if (error == false)
	    message = "Good Structure";
	return message;
    }


    // -------------------------------------------------------------------------------------------------------
    // readFromFile

    /*
    Author: Swethan Sivasegaran
    Date: January 10 2018
    Purpose: Given a STRING parameter value (fileName) corresponding to a given file, reads each ASCII value in each LINE of the given file's STRING TEXT value and returns a STRING value corresponding to whether the TEXT FILE
	     correctly used brackets within the file. If there is an error, the LINE NUMBER and the POSITION number are outputted. To perform this, the method calls the methods push and pop (see Method push and pop WITHIN
	     the STACK CLASS). Hence, in this way, opening brackets are inserted into a SINGLY LINKED LIST while closing brackets remove these opening brackets to determine whether there is an error or not.
	     - returns GOOD STRUCTURE if the TEXT FILE uses brackets properly
	     - returns MISMATCHED BRACKETS if the TEXT FILE has an opening bracket that ends with a closing bracket that does not match in bracket type
	     - returns TOO MANY CLOSE BRACKETS if the TEXT FILE has too many close brackets in relation to the number of opening brackets initiated
	     - returns TOO MANY OPEN BRACKETS if the TEXT FILE has too many open brackets that have gone unchecked at the end of the TEXT FILE
    Input: A STRING parameter value (fileName) that corresponds to a file name
    Output: Returns a STRING value corresponding to whether the TEXT FILE correctly used brackets within the file. If there is an error, the LINE NUMBER and the POSITION number are outputted. To perform this, the method
	    calls the methods push and pop (see Method push and pop WITHIN the STACK CLASS). Hence, in this way, opening brackets are inserted into a SINGLY LINKED LIST while closing brackets remove these opening brackets
	    to determine whether there is an error or not.
	     - returns GOOD STRUCTURE if the TEXT FILE uses brackets properly
	     - returns MISMATCHED BRACKETS if the TEXT FILE has an opening bracket that ends with a closing bracket that does not match in bracket type
	     - returns TOO MANY CLOSE BRACKETS if the TEXT FILE has too many close brackets in relation to the number of opening brackets initiated
	     - returns TOO MANY OPEN BRACKETS if the TEXT FILE has too many open brackets that have gone unchecked at the end of the TEXT FILE
    */
    public String readFromFile (String fileName)
    {
	int index = 0;
	int count = 1;
	String data = "";
	String line = "";
	String message = "";
	TextInputFile file = new TextInputFile (fileName);
	while (!file.eof ())
	{
	    line = file.readLine ();
	    while (index < line.length ())
	    {
		if (line.charAt (index) == 40 || line.charAt (index) == 91 || line.charAt (index) == 123)
		    this.list.push (line.charAt (index) + "");
		else if (line.charAt (index) == 41 || line.charAt (index) == 93 || line.charAt (index) == 125)
		{
		    if (this.list.root != null)
		    {
			data = this.list.pop ();
			if (data.equals ((char) (line.charAt (index) - 1) + "") == false && data.equals ((char) (line.charAt (index) - 2) + "") == false)
			    message = message + "Mismatched brackets at position " + index + " on line " + count + "\n";
		    }
		    else
			message = message + "Too many close brackets at position " + index + " on line " + count + "\n";

		}
		index = index + 1;
	    }
	    count = count + 1;
	    index = 0;

	}
	if (this.list.root != null)
	    message = message + "Too Many Open Brackets at position " + index + " on line " + count;
	if (message == "")
	    message = "Good Structure";
	return message;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
