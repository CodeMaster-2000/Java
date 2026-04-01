// The "SLTest" class.
/*
Author: Swethan Sivasegaran
Date: December 13 2017
Purpose: To demonstrate the capability and understanding of LINKED LISTS that are accessed in one direction (SINGLE LINKED LISTS) and the manipulation of its nodes accordingly.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS SLTEST
/*
Author: Swethan Sivasegaran
Date: December 21 2017
Purpose: To showcase the capability of considerating each case scenario of the methods in the SINGLELINKEDLIST class

DATA FIELDS - None

METHODS

main - To test the functionality of each method in the SINGLELINKEDLIST class
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class SllTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: December 21 2017
    Purpose: To test the functionality of each method in the SINGLELINKEDLIST class
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs of each individual method via Console
    */
    static Console c;

    public static void main (String[] args) throws CloneNotSupportedException
    {
	c = new Console (40, 120);
	boolean found = false;
	int repeat = 1;
	String data = "";
	String firstData = "";
	String secondData = "";
	Node temp;
	while (repeat == 1)
	{
	    SingleLinkedList list = new SingleLinkedList ();
	    SingleLinkedList secondList = new SingleLinkedList ();
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Single Linked List Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a 1 (to insert STRING values) or any other INTEGER (to test on an EMPTY linked list): ");
	    repeat = c.readInt ();
	    while (repeat == 1)
	    {
		c.clear ();
		c.setTextColor (Color.red);
		c.println ("Insert + isEmpty Method Testing");
		c.setTextColor(Color.black);
		c.println("The Status of an Empty Linked List: " + list.isEmpty());
		c.setTextColor (Color.blue);
		c.print ("Please enter a STRING value within the Linked List to insert from: ");
		secondData = c.readString ();
		c.print ("Please enter a NEW STRING value to insert in that STRING's position: ");
		firstData = c.readString ();
		list.insert (firstData, secondData);
		c.setTextColor (Color.black);
		c.println (list.toString ());
		c.setTextColor (Color.blue);
		c.print ("\n\nPlease enter a 1 (to continue inserting STRING values) or any other INTEGER value to stop: ");
		repeat = c.readInt ();
	    }
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Find Method Testing");
	    c.setTextColor (Color.black);
	    c.println (list.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a STRING value to find within the Linked List: ");
	    data = c.readString ();
	    temp = list.find (data);
	    c.setTextColor (Color.black);
	    if (temp != null)
	    {
		if (temp.next != null)
		    c.println ("Node data BEFORE the Node found: " + temp.data);
		else
		    c.println ("DATA NOT FOUND");
	    }
	    else
	    {
		if (list.root != null)
		    c.println ("Node data BEFORE the Node found: NULL");
		else
		    c.println ("DATA NOT FOUND");
	    }
	    c.setTextColor (Color.red);
	    c.println ("\n\nDelete Method Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a STRING value to delete within the Linked List: ");
	    data = c.readString ();
	    c.setTextColor (Color.black);
	    c.println ("Before - " + list.toString ());
	    found = list.delete (data);
	    if (found == false)
		c.println ("String value was not found");
	    else
		c.println ("String value was found");
	    c.setTextColor (Color.black);
	    c.println ("After - " + list.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nSelfOrganizingSearch MethodTesting");
	    c.setTextColor (Color.black);
	    c.println ("Before - " + list.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("Please choose a STRING value within the Linked List to organize into the front: ");
	    data = c.readString ();
	    list.selfOrganizingSearch (data);
	    c.setTextColor (Color.black);
	    c.println ("After - " + list.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nConcatenate Method Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a 1 (to insert values into a new Linked List) or any other INTEGER to concatenate an EMPTY Linked List: ");
	    repeat = c.readInt ();
	    while (repeat == 1)
	    {
		c.clear ();
		c.setTextColor (Color.red);
		c.println ("Concatenate Method Testing");
		c.setTextColor (Color.blue);
		c.print ("Please enter a STRING value within the Linked List to insert from: ");
		secondData = c.readString ();
		c.print ("Please enter a NEW STRING value to insert in that STRING's position: ");
		firstData = c.readString ();
		secondList.insert (firstData, secondData);
		c.print ("\n\nPlease enter a 1 (to continue inserting STRING values) or any other INTEGER value to stop: ");
		repeat = c.readInt ();
	    }
	    c.setTextColor (Color.black);
	    c.println ("First -  " + list.toString ());
	    c.println ("Second - " + secondList.toString ());
	    list.concatenate (secondList);
	    c.println ("Combined - " + list.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\nClone Method Testing\n");
	    secondList = (SingleLinkedList) list.clone ();
	    c.setTextColor (Color.black);
	    c.println ("First -  " + list.toString ());
	    c.println ("First (CLONE) -  " + secondList.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter a STRING value within the Linked List to insert from: ");
	    secondData = c.readString ();
	    c.print ("Please enter a NEW STRING value to insert in that STRING's position: ");
	    firstData = c.readString ();
	    secondList.insert (firstData, secondData);
	    c.setTextColor (Color.black);
	    c.println ("\nFirst -  " + list.toString ());
	    c.println ("First (CLONE) -  " + secondList.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a 1 (to restart program) or any other INTEGER to end program: ");
	    repeat = c.readInt ();
	}




    }


    // ======================================================================================================
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
// CLASS SINGLELINKEDLIST
/*
Author: Swethan Sivasegaran
Date: December 21 2017
Purpose: To establish a SINGLELINKEDLIST class with the use of the NODE class (composition of classes) so that STRING data of each NODE can be accessed in such a fashion that NODES can ONLY be accessed their information in one direction
	 of pointers for each NODE (next) until a NULL is reached. The SINGLELINKEDLIST class should manipulate and provide variety of operation on the management of NODES.

DATA FIELDS

root (NODE) - A NODE type data field that is used as a STARTING REFRENCE of the SINGLELINKEDLIST class and is used to access other NODES from which the root uses its NODE type data field (next) to access through.

METHODS

Constructor (with ONE PARAMETERS) -  Given a STRING parameter value, sets the NODE type data field (root) to a new INSTANCE of a NODE with STRING data field (data) value set to the given parameter value.
				     Hence, creating a LINKED LIST with ONE NODE.

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the NODE type data field (root) to NULL essentially being an EMPTY LINKED LIST.

isEmpty - Based on the NODE type data field (root), returns a BOOLEAN value corresponding to the whether there is an EMPTY LINKED LIST or not.
	  - returns True if the NODE type data field (root) points to a NULL
	  - returns False otherwise

clone - Based on the NODE type data field (root), returns an OBJECT of the CURRENT SINGLELINKEDLIST by calling the OVERRIDEN CLONE method in the NODE class (see Method clone within NODE)
	and essentially creates a complete copy pointing to a different address in RAM that retains the EXACT SAME STRING information of the NODE type data field (root) and the NODE type data element
	pointers (next) STRING information that follow it until a NULL pointer is reached.

toString - BASED on the NODE type data field (root), return a STRING value that corresponds to the STRING information of all NODE type data element pointers (next) STRING information that the NODE type
	   data element (root) initially points to until a NULL pointer is reached. This is achieved by calling toString (see Method toString within NODE).

find - Given a STRING type parameter value, returns the NODE before the NODE containing the EXACT SAME STRING information given via parameters within the SINGLELINKEDLIST.
       - returns NULL if there is an EMPTY SINGLELINKEDLIST
       - returns NULL if the FIRST NODE has the same STRING type data field (data) as the given parameter
       - returns the LAST NODE if none of the NODES in the SINGLELINKEDLIST of Nodes pointing in one direction from the Node type data field (root).

insert -Given two STRING type parameter values, inserts a new NODE containing the FIRST STRING parameter value as its STRING type data field value before the NODE containing the SECOND STRING parameter value
	as its STRING type data field value within the SINGLELINKEDLIST. If there is no NODE containing the SECOND STRING parameter value, the new NODE is inserted at the very end (last node points to Null).
	The Search for the NODE containing the SECOND STRING PARAMETER value as its STRING data field value is achieved using find (see Method find within class).

delete - Given a STRING type parameter value, calls the method find (see Method find within class) to locate the NODE with the EXACT SAME STRING information as the STRING value given via parameters and
	 ensures it is removed from the LINKED LIST with the aid of the JVM and its Garbage Collector and the changing of NODE type data field pointers (next) of each Node - see Class Node. Returns a
	 BOOLEAN value that corresponds to whether a NODE with the right criteria was removed.
	 - if the Node was not found or the Linked List was empty, nothing occurs and FALSE is returned. Otherwise, a BOOLEAN value of TRUE is returned.
	 - editChecks for NULL pointer exceptions return from finding a NODE with SAME STRING data field value as the parameter value with using method find (see Method find within class).

printOdd - Based on the NODE data field (root), returns a STRING value that corresponds to the STRING data field (data) information of every other NODE starting from the FIRST NODE (root).

selfOrganizingSearch - Given a STRING parameter value, calls find (see Method find within class) to locate a NODE within the SINGLELINKEDLIST that contains the EXACT SAME STRING data field value as the given parameter and
		       shifts the Node onto the front of the SINGLELINKEDLIST. Hence, the NODE becomes the CURRENT SINGLELINKEDLIST's Node type data field (root) with the aid of insert and delete (see Method insert + delete
		       within class). This is used to help finding a repetitively used NODE faster. Returns the NODE if the NODE was successfully found. Otherwise, a NULL is returned.

concatenate - Given a SINGLELINKEDLIST parameter value, links the CURRENT SINGLELINKEDLIST's LAST NODE to the SINGLELINKEDLIST parameter value's NODE type data field (root) with the change of pointers from NULL to the
	      second SINGLELINKEDLIST's root value.
	      - editChecks for cases with EMPTY LINKEDLISTS

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class SingleLinkedList implements Cloneable
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
    public SingleLinkedList (String data)
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
    public SingleLinkedList ()
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
    // find

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given a STRING type parameter value, returns the NODE before the NODE containing the EXACT SAME STRING information given via parameters within the SINGLELINKEDLIST.
	     - returns NULL if there is an EMPTY SINGLELINKEDLIST
	     - returns NULL if the FIRST NODE has the same STRING type data field (data) as the given parameter
	     - returns the LAST NODE if none of the NODES in the SINGLELINKEDLIST of Nodes pointing in one direction from the Node type data field (root).
    Input: A STRING type parameter value
    Output: Returns a the NODE before the NODE containing the EXACT SAME STRING information given via parameters within the SINGLELINKEDLIST.
	    - returns NULL if there is an EMPTY SINGLELINKEDLIST
	    - returns NULL if the FIRST NODE has the same STRING type data field (data) as the given parameter
	    - returns the LAST NODE if none of the NODES in the SINGLELINKEDLIST of Nodes pointing in one direction from the Node type data field (root).
    */

    public Node find (String data)
    {
	Node temp = this.root;
	if (temp != null)
	{
	    if (temp.data.equals (data) == true)
		temp = null;
	    else
	    {
		while (temp.next != null && temp.next.data.equals (data) == false)
		    temp = temp.next;
	    }
	}
	return temp;

    }


    // ======================================================================================================

    // insert

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given two STRING type parameter values, inserts a new NODE containing the FIRST STRING parameter value as its STRING type data field value before the NODE containing the SECOND STRING parameter value
	     as its STRING type data field value within the SINGLELINKEDLIST. If there is no NODE containing the SECOND STRING parameter value, the new NODE is inserted at the very end (last node points to Null).
	     The Search for the NODE containing the SECOND STRING PARAMETER value as its STRING data field value is achieved using find (see Method find within class).
    Input: TWO STRING type parameter values
    Output: None - inserts a new NODE containing the FIRST STRING parameter value as its STRING type data field value before the NODE containing the SECOND STRING parameter value as its STRING type data field value
	    within the SINGLELINKEDLIST. If there is no NODE containing the SECOND STRING parameter value, the new NODE is inserted at the very end.
    */
    public void insert (String first, String second)
    {
	Node newNode = new Node (first);
	Node temp = this.find (second);
	if (this.root != null)
	{
	    if (temp == null)
	    {
		newNode.next = this.root;
		this.root = newNode;
	    }
	    else
	    {
		newNode.next = temp.next;
		temp.next = newNode;
	    }
	}
	else
	{

	    this.root = newNode;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // delete

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given a STRING type parameter value, calls the method find (see Method find within class) to locate the NODE with the EXACT SAME STRING information as the STRING value given via parameters and
	     ensures it is removed from the LINKED LIST with the aid of the JVM and its Garbage Collector and the changing of NODE type data field pointers (next) of each Node - see Class Node. Returns a
	     BOOLEAN value that corresponds to whether a NODE with the right criteria was removed.
	     - if the Node was not found or the Linked List was empty, nothing occurs and FALSE is returned. Otherwise, a BOOLEAN value of TRUE is returned.
	     - editChecks for NULL pointer exceptions return from finding a NODE with SAME STRING data field value as the parameter value with using method find (see Method find within class).
    Input: A STRING parameter value
    Output: Returns a BOOLEAN value that corresponds to whether a NODE with the right criteria was removed. Calls the method find (see Method find within class) to locate the NODE with the EXACT SAME STRING
	    information as the STRING value given via parameters and ensures it is removed from the LINKED LIST.
	    - if the Node was not found or the Linked List was empty, nothing occurs and FALSE is returned.
	    - Otherwise, a BOOLEAN value of TRUE is returned.
    */
    public boolean delete (String data)
    {
	boolean found = false;
	if (this.root != null)
	{
	    Node temp = this.find (data);
	    if (temp == null)
	    {
		this.root = this.root.next;
		found = true;
	    }
	    else
	    {
		if (temp.next != null)
		{
		    temp.next = temp.next.next;
		    found = true;
		}
	    }
	}
	return found;
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
    // selfOrganizationSearch

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given a STRING parameter value, calls find (see Method find within class) to locate a NODE within the SINGLELINKEDLIST that contains the EXACT SAME STRING data field value as the given parameter and
	     shifts the Node onto the front of the SINGLELINKEDLIST. Hence, the NODE becomes the CURRENT SINGLELINKEDLIST's Node type data field (root) with the aid of insert and delete (see Method insert + delete
	     within class). This is used to help finding a repetitively used NODE faster. Returns the NODE if the NODE was successfully found. Otherwise, a NULL is returned.
    Input: A STRING type parameter value
    Output: Returns a NODE value if a NODE if the same STRING data field value as the given parameter value was found and reinserts the NODE as the NODE type data field (root) of the SINGLELINKEDLIST class.
	    Otherwise, a NULL is returned and nothing happens.
    */
    public Node selfOrganizingSearch (String data)
    {
	boolean found = false;
	Node replaceNode = new Node (data);
	Node temp = this.root;
	found = this.delete (data);
	if (found == false)
	    replaceNode = null;
	else
	    this.insert (data, temp.data);
	return replaceNode;
    }


    // -------------------------------------------------------------------------------------------------------
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
    //test clone and isEmpty
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
