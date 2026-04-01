// The "StackTest" class.
import java.awt.*;
import hsa.*;

public class StackTest
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	// Place your program here.  'c' is the output console
    } // main method
} // StackTest class
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
Purpose:

DATA FIELDS

root (NODE) - A NODE type data field that is used as a STARTING REFRENCE of the SINGLELINKEDLIST class and is used to access other NODES from which the root uses its NODE type data field (next) to access through.

METHODS

isEmpty - Based on the NODE type data field (root), returns a BOOLEAN value corresponding to the whether there is an EMPTY LINKED LIST or not.
	  - returns True if the NODE type data field (root) points to a NULL
	  - returns False otherwise

clone - Based on the NODE type data field (root), returns an OBJECT of the CURRENT SINGLELINKEDLIST by calling the OVERRIDEN CLONE method in the NODE class (see Method clone within NODE)
	and essentially creates a complete copy pointing to a different address in RAM that retains the EXACT SAME STRING information of the NODE type data field (root) and the NODE type data element
	pointers (next) STRING information that follow it until a NULL pointer is reached.

toString - BASED on the NODE type data field (root), return a STRING value that corresponds to the STRING information of all NODE type data element pointers (next) STRING information that the NODE type
	   data element (root) initially points to until a NULL pointer is reached. This is achieved by calling toString (see Method toString within NODE).

printOdd - Based on the NODE data field (root), returns a STRING value that corresponds to the STRING data field (data) information of every other NODE starting from the FIRST NODE (root).

concatenate - Given a SINGLELINKEDLIST parameter value, links the CURRENT SINGLELINKEDLIST's LAST NODE to the SINGLELINKEDLIST parameter value's NODE type data field (root) with the change of pointers from NULL to the
	      second SINGLELINKEDLIST's root value.
	      - editChecks for cases with EMPTY LINKEDLISTS

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
	SingleLinkedList object = (SingleLinkedList) super.clone ();
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
    // printOdd

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Based on the NODE data field (root), returns a STRING value that corresponds to the STRING data field (data) information of every other NODE starting from the FIRST NODE (root).
    Input: None
    Output: Returns a STRING value that corresponds to the STRING data field (data) information of every other NODE starting from the FIRST NODE (root).
    */
    public String printOdd ()
    {
	int count = 1;
	String oddData = "";
	Node temp = this.root;
	while (temp != null)
	{
	    if (count % 2 == 1)
		oddData = oddData + temp.data + " ";
	    temp = temp.next;
	    count = count + 1;
	}
	return oddData;
    }


    // ======================================================================================================
    // concatenate

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given a SINGLELINKEDLIST parameter value, links the CURRENT SINGLELINKEDLIST's LAST NODE to the SINGLELINKEDLIST parameter value's NODE type data field (root) with the change of pointers from NULL to the
	     second SINGLELINKEDLIST's root value.
	     - editChecks for cases with EMPTY LINKEDLISTS
    Input: A SINGLELINKEDLIST parameter value
    Output: None - links the CURRENT SINGLELINKEDLIST's LAST NODE to the SINGLELINKEDLIST parameter value's NODE type data field (root) with the change of pointers from NULL to the second SINGLELINKEDLIST's root value.
    */
    public void concatenate (SingleLinkedList secondList)
    {
	if (this.root != null)
	{
	    Node temp = this.root;
	    while (temp.next != null)
		temp = temp.next;
	    temp.next = secondList.root;
	}
	else
	    this.root = secondList.root;
    }


    // ======================================================================================================
    // push

    /*
    Author: Swethan Sivasegaran
    Date:
    Purpose:
    Input:
    Output:
    */
    public void push (String data)
    {
	Node newNode = new Node (data);
	if (this.root != null)
	{
	    newNode.next = this.root.next;
	    this.root = newNode;
	}
	else
	{
	    this.root = newNode;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // pop

    /*
    Author: Swethan Sivasegaran
    Date:
    Purpose:
    Input:
    Output:
    */
    public void pop ()
    {
	if (this.root != null)
	    this.root = this.root.next;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Parenthesis
{
    protected String data = "";
    protected Stack list;
    public Parenthesis ()
    {
    }


    public void getString ()
    {
    }


    public String bracketCheck (String line)
    {
	int curveIndex = 0;
	int squareIndex = 0;
	int circleIndex = 0;
	String info = line;
	String message = "";
	//do not need to consider pushing extra open brackets because only one line
	//the way brackets work is ({[come first ALWAYS then in that same order backwards (firstIn Last Out)
	//Mismatched occurs when ({[ is matched with }])
	//Also, if popping empty list should occur - too many close brackets
	//Otherwise - too many open brackets
	//close bracket b4 open bracket?
    }


    public String readFromFile (String fileName)
    {
	int lineCount = 0;
	String line = "";
	String message = "";
	//read Each line
	//check for the entire file
	//how to check each line?
	TextInputFile file = new TextInputFile (fileName);
	while (!file.eof ())
	{
	    
	}
	return message;
    }
}
