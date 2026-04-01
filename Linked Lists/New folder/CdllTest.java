// The "CDLTest" class.
/*
Author: Swethan Sivasegaran
Date: December 22 2017
Purpose: To demonstrate the capability and understanding of CIRCULAR DOUBLY LINKED LISTS and the consideration of TWO NODE POINTERS in addition to the manipulation of NODES within the linked lists with the help of a HEADER NODE.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;
// CLASS CDLTest
/*
Author: Swethan Sivasegaran
Date: December 22 2017
Purpose: To showcase the capability of considerating each case scenario of the methods in the CIRCULARDOUBLYLINKEDLIST class and the management of NODES within a functioning CIRCULAR DOUBLY LINKED LIST

DATA FIELDS - None

METHODS

main - To test the functionality of each method from the CIRCUALRDOUBLYLINKEDLIST class and its case consideration as well as management of individual NODES.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class CdllTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: To test the functionality of each method from the CIRCUALRDOUBLYLINKEDLIST class and its case consideration as well as management of individual NODES.
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs from each individual method of the CIRCULARDOUBLYLINKEDLIST
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (40, 100);
	int firstData = 0;
	int secondData = 0;
	int data = 0;
	int repeat = 1;
	while (repeat == 1)
	{
	    CircularDoublyLinkedList list = new CircularDoublyLinkedList ();
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("CircularDoublyLinkedList Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a 1 (to insert INTEGER values) or any other INTEGER (to test on an EMPTY linked list): ");
	    repeat = c.readInt ();
	    while (repeat == 1)
	    {
		c.clear ();
		c.setTextColor (Color.red);
		c.println ("Insert Method Testing");
		c.setTextColor (Color.blue);
		c.print ("\nPlease enter an INTEGER value within the Linked List to insert from: ");
		firstData = c.readInt ();
		c.print ("Please enter a NEW INTEGER value to insert into the Linked List: \n");
		secondData = c.readInt ();
		list.insertLeft (firstData, secondData);
		c.setTextColor (Color.black);
		c.println (list.toStringLeft ());
		c.println (list.toStringRight ());
		c.print ("\n\nPlease enter a 1 (to continue inserting INTEGER values) or any other INTEGER value to stop: ");
		repeat = c.readInt ();
	    }
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Linked List Result");
	    c.setTextColor (Color.black);
	    c.println (list.toStringLeft ());
	    c.println (list.toStringRight ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nDelete Method Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter an INTEGER value within the Linked List to delete: ");
	    data = c.readInt ();
	    list.delete (data);
	    c.setTextColor (Color.black);
	    c.println (list.toStringLeft ());
	    c.println (list.toStringRight ());
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
Date: December 22 2017
Purpose: To PROVIDE a sort of container class to store individual INTEGER data values in addition to keeping track of TWO NODE pointers and their INTEGER data information so that the NODE class can be used in DOUBLY LINKED LISTS.
	 Hence, Linked Lists that use this NODE class can achieve the act of accessing NODE information in two direction. Both NODE pointers are defaulted to NULL.

DATA FIELDS

data (INT) - An INTEGER type data field that represent the CURRENT NODE's holding of its respective INTEGER data information
next (NODE) - A NODE type data field that represents the CURRENT NODE's pointer to another NODE type object supposdely in such a fashion that it points to the NEXT NODE to it in a LINKED LIST, hence the name next
prev (NODE) - A NODE type data field that represents the CURRENT NODE's pointer to another NODE type object supposedly in such a fashion that it points to the NODE previous to it in a LINKED LIST, hence the name prev

METHODS

Constructor (with ONE PARAMETER) - Given an INTEGER parameter value, sets the INTEGER type data field to its respective parameter value. In addition, sets the two NODE type data fields (next + prev) to NULL.

Constructor (with NO PARAMETERS) - Given NO PARMAETER VALUES, calls the Constructor (with ONE PARAMETER) and defaults the INTEGER type data field to 0. In addition, the two NODE type data fields (next + prev) are
				   set to NULL.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Node
{
    //DATA FIELDS
    protected int data = 0;
    protected Node next;
    protected Node prev;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given an INTEGER parameter value, sets the INTEGER type data field to its respective parameter value. In addition, sets the two NODE type data fields (next + prev) to NULL.
    Input: An INTEGER type parameter value
    Output: None - initializes the INTEGER type data field to its respective parameter value. In addition, sets the two NODE type data fields (next + prev) to NULL.
    */
    public Node (int data)
    {
	this.data = data;
	this.next = null;
	this.prev = null;
    }


    // ======================================================================================================
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given NO PARMAETER VALUES, calls the Constructor (with ONE PARAMETER) and defaults the INTEGER type data field to 0. In addition, the two NODE type data fields (next + prev) are
	     set to NULL.
    Input: None
    Output: None - initializes the INTEGER type data field to 0, the NODE type data field (next) to NULL and the NODE type data field (prev) to NULL.
    */
    public Node ()
    {
	this (0);
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS CIRCULARDOUBLYLINKEDLIST
/*
Author: Swethan Sivasegaran
Date: December 22 2017
Purpose: To create a CIRCULARDOUBLYLINKEDLIST with the use of the NODE class that have the capability of tracking TWO NODE pointers such that a LINKED LIST can go in two directions of accessing INTEGER information. In addition, the
	 CIRCULARDOUBLYLINKEDLIST should manage and perform a variety of operations on the NODES within the LINKEDLIST with the aid of the HEADER NODE such that the LINKED LIST is now classified as a CIRCULAR DOUBLY LINKED LIST since
	 all the NODES eventually lead back to each other as there is no NULL POINTER.

DATA FIELDS

header (NODE) - A NODE type data field that acts as the REFRENCE NODE in the CIRCULARDOUBLYLINKEDLIST that holds the number of NODES in the list as its INTEGER data element. In addition, it serves as the STARTING or ENDING REFRENCE in
		the LINKED LIST when accessing other NODES to determine whether the LINKEDLIST has looped back. The HEADER NODE is the ONLY CONCRETE REFRENCE that the programmer has in the CIRCUALRDOUBLYLINKEDLIST to access it from.

METHODS

Constructor (with ONE PARAMETER) - Given an INTEGER type parameter value, sets the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field value set to the given parameter value. In addition, the
				   NODE type data fields of the header (next + prev) are both set to itself since the class is a CIRCULAR DOUBLY LINKED LIST + header Node.

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, calls the Constructor (with ONE PARAMETER) to initialize the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field set to 0. In addtion, the
				   NODE type data fields of the header (next + prev) are both set to itself since the class is a CIRCULAR DOUBLY LINKED LIST with HEADER NODE.

numNodes - Based on the NODE type data field (header), returns an INTEGER value corresponding to the the INTEGER information stored in the INTEGER data field of the header node.

insertLeft - Given TWO INTEGER parameter values, inserts a new NODE containing the EXACT SAME INTEGER data field value as the FIRST INTEGER parameter value into the CIRCULAR DOUBLY LINKED LIST before the NODE within the Linked
	     List containing the SAME INTEGER data field value as the SECOND INTEGER parameter value. If a NODE with the criteria of the SECOND INTEGER parameter value was not found, the new NODE is inserted to the left of the
	     NODE type data field (header) or essentially the end of the CIRCULAR DOUBLY LINKED LIST. The NODE type data fields of the Header Node (next + prev) are taken into consideration during insertion.

delete - Given an INTEGER parameter value, locates a NODE within the CIRCULAR DOUBLY LINKED LIST of nodes that has an INTEGER data field valuematching the given parameter and ensures the NODE is removed from the
	 Linked List with the switching of NODE pointers (next + prev) to its respective NODE over the desired NODE to be removed. If the desired NODE is not found or the CIRCULAR DOUBLY LINKED LIST is EMPTY,
	 nothing will occur

toStringRight - Based on the INTEGER data field values of each NODE within the CIRCULAR DOUBLY LINKED LIST including the NODE type data field (header), returns a STRING value that corresponds to all INTEGER values starting from
		the NODE type data field (header) and going in the right direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning that the STRING value is arranged such that the INTEGER data field of
		each NODE is lined up starting from the HEADER NODE to the NEXT NODE that the NODE type data field of the HEADER NODE (next) points to until it loops back to the beginning.  This can ONLY be achieved since the
		CIRCULARDOUBLYLINKEDLIST class has the property of moving in two directios with the aid of two NODE type data fields of the HEADER NODE (next + prev).

toStringLeft - Based on the INTEGER data field values of each NODE within the CIRCULAR DOUBLY LINKED LIST including the NODE type data field (header), returns a STRING value that corresponds to all INTEGER values starting from
	       the NODE type data field (header) and going in the left direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning that the STRING value is arranged such that the INTEGER data field of
	       each NODE is lined up starting from the HEADER NODE to the PREVIOUS NODE that the NODE type data field of the HEADER NODE (prev) points to until it loops back to the beginning.  This can ONLY be achieved since the
	       CIRCULARDOUBLYLINKEDLIST class has the property of moving in two directios with the aid of two NODE type data fields of the HEADER NODE (next + prev).
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class CircularDoublyLinkedList
{
    //DATA FIELDS
    protected Node header;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given an INTEGER type parameter value, sets the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field value set to the given parameter value. In addition, the
	     NODE type data fields of the header (next + prev) are both set to itself since the class is a CIRCULAR DOUBLY LINKED LIST + header Node.
    Input: An INTEGER type parameter value
    Output: None - initializes the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field value set to the given parameter value. In addition, the NODE type data fields of the
	    header (next + prev) are both set to itself.
    */
    public CircularDoublyLinkedList (int data)
    {
	this.header = new Node (data);
	this.header.next = this.header;
	this.header.prev = this.header;
    }


    // ======================================================================================================
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given NO PARAMETERS, calls the Constructor (with ONE PARAMETER) to initialize the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field set to 0. In addtion, the
	     NODE type data fields of the header (next + prev) are both set to itself since the class is a CIRCULAR DOUBLY LINKED LIST with HEADER NODE.
    Input: None
    Output: None - initializes the NODE type data field (header) to a new INSTANCE of a NODE with INTEGER type data field value set to 0, the NODE type data field (header)'s Node data field (next + prev) both pointing
	    to itself.
    */
    public CircularDoublyLinkedList ()
    {
	this (0);
    }


    // -------------------------------------------------------------------------------------------------------
    // numNodes

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Based on the NODE type data field (header), returns an INTEGER value corresponding to the the INTEGER information stored in the INTEGER data field of the header node.
    Input: None
    Output: Returns an INTEGER value corresponding to the the INTEGER information stored in the INTEGER data field of the header node.
    */
    public int numNodes ()
    {
	return this.header.data;
    }


    // ======================================================================================================
    // insertLeft

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given TWO INTEGER parameter values, inserts a new NODE containing the EXACT SAME INTEGER data field value as the FIRST INTEGER parameter value into the CIRCULAR DOUBLY LINKED LIST before the NODE within the Linked
	     List containing the SAME INTEGER data field value as the SECOND INTEGER parameter value. If a NODE with the criteria of the SECOND INTEGER parameter value was not found, the new NODE is inserted to the left of the
	     NODE type data field (header) or essentially the end of the CIRCULAR DOUBLY LINKED LIST. The NODE type data fields of the Header Node (next + prev) are taken into consideration during insertion.
    Input: TWO INTEGER PARAMETER VALUES
    Output: None - inserts a new NODE containing the EXACT SAME INTEGER data field value as the FIRST INTEGER parameter value into the CIRCULAR DOUBLY LINKED LIST before the NODE within the Linked List containing the SAME INTEGER
	    data field value as the SECOND INTEGER parameter value. If a NODE with the criteria of the SECOND INTEGER parameter value was not found, the new NODE is inserted to the left of the NODE type data field (header) or
	    essentially the end of the CIRCULAR DOUBLY LINKED LIST.
    */
    public void insertLeft (int value, int key)
    {
	Node node = new Node (value);
	Node temp = this.header.next;
	while (temp.next != this.header && temp.data != key)
	    temp = temp.next;
	if (temp.data != key)
	{
	    node.next = this.header;
	    temp.next = node;
	    node.prev = temp;
	    this.header.prev = node;
	}
	else
	{
	    node.prev = temp.prev;
	    temp.prev = node;
	    node.next = temp;
	    node.prev.next = node;
	}
	this.header.data++;
    }


    // -------------------------------------------------------------------------------------------------------
    // delete

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Given an INTEGER parameter value, locates a NODE within the CIRCULAR DOUBLY LINKED LIST of nodes that has an INTEGER data field valuematching the given parameter and ensures the NODE is removed from the
	     Linked List with the switching of NODE pointers (next + prev) to its respective NODE over the desired NODE to be removed. If the desired NODE is not found or the CIRCULAR DOUBLY LINKED LIST is EMPTY,
	     nothing will occur
    Input: An INTEGER parameter value
    Output: None - locates a NODE within the CIRCULAR DOUBLY LINKED LIST of nodes that has an INTEGER data field valuematching the given parameter and ensures the NODE is removed from the Linked List. If the desired
	    NODE is not found or the CIRCULAR DOUBLY LINKED LIST is EMPTY, nothing will occur
    */
    public void delete (int data)
    {
	if (this.header.next != header)
	{
	    Node temp = this.header.next;
	    while (temp.next != this.header && temp.data != data)
		temp = temp.next;
	    if (temp.data == data)
	    {
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		this.header.data--;
	    }
	}
    }


    // ======================================================================================================
    // toStringRight

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Based on the INTEGER data field values of each NODE within the CIRCULAR DOUBLY LINKED LIST including the NODE type data field (header), returns a STRING value that corresponds to all INTEGER values starting from
	     the NODE type data field (header) and going in the right direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning that the STRING value is arranged such that the INTEGER data field of
	     each NODE is lined up starting from the HEADER NODE to the NEXT NODE that the NODE type data field of the HEADER NODE (next) points to until it loops back to the beginning.  This can ONLY be achieved since the
	     CIRCULARDOUBLYLINKEDLIST class has the property of moving in two directios with the aid of two NODE type data fields of the HEADER NODE (next + prev).
    Input: None
    Output: Returns a STRING value that corresponds to all INTEGER values starting from the NODE type data field (header) and going in the right direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning
	    that the STRING value is arranged such that the INTEGER data field of each NODE is lined up starting from the HEADER NODE to the NEXT NODE that the NODE type data field of the HEADER NODE (next) points to until it
	    loops back to the beginning.
    */
    public String toStringRight ()
    {
	String result = "Circular Doubly Linked List(R): Header[" + this.header.data + "] <--> ";
	Node temp = this.header;
	while (temp.next != header)
	{
	    temp = temp.next;
	    if (temp.next != header)
		result = result + temp.data + " <--> ";
	    else
		result = result + temp.data;
	}
	return result;
    }


    // -------------------------------------------------------------------------------------------------------
    // toStringLeft

    /*
    Author: Swethan Sivasegaran
    Date: December 22 2017
    Purpose: Based on the INTEGER data field values of each NODE within the CIRCULAR DOUBLY LINKED LIST including the NODE type data field (header), returns a STRING value that corresponds to all INTEGER values starting from
	     the NODE type data field (header) and going in the left direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning that the STRING value is arranged such that the INTEGER data field of
	     each NODE is lined up starting from the HEADER NODE to the PREVIOUS NODE that the NODE type data field of the HEADER NODE (prev) points to until it loops back to the beginning.  This can ONLY be achieved since the
	     CIRCULARDOUBLYLINKEDLIST class has the property of moving in two directios with the aid of two NODE type data fields of the HEADER NODE (next + prev).
    Input: None
    Output: Returns a STRING value that corresponds to all INTEGER values starting from the NODE type data field (header) and going in the left direction of the HEADER NODE until it reaches back to the HEADER NODE. This meaning
	    that the STRING value is arranged such that the INTEGER data field of each NODE is lined up starting from the HEADER NODE to the PREVIOUS NODE that the NODE type data field of the HEADER NODE (prev) points to until it
	    loops back to the beginning.
    */
    public String toStringLeft ()
    {
	String result = "Circular Doubly Linked List(L): Header[" + this.header.data + "] <--> ";
	Node temp = this.header;
	while (temp.prev != header)
	{
	    temp = temp.prev;
	    if (temp.prev != header)
		result = result + temp.data + " <--> ";
	    else
		result = result + temp.data;
	}
	return result;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
