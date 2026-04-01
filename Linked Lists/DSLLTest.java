// The "DSLLTest" class.
/*
Author: Swethan Sivasegaran
Date: December 23 2017
Purpose: To demonstrate the capability of managing TWO SINGLE LINKED LIST under different criterias within a SINGLE LINKED LIST in addition to manipulating each NODE within the DOUBLE SORTED LINKED LIST.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS DSLLTEST
/*
Author: Swethan Sivasegaran
Date: December 23 2017
Purpose: To showcase the manipulation of nodes in each method of the DOUBLESORTEDLINKEDLIST class and its functionality in different case scenarios

DATA FIELDS - None

METHODS

main - To test the functionality of each method of the DOUBLESORTEDLINKEDLIST class
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class DSLLTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: To test the functionality of each method of the DOUBLESORTEDLINKEDLIST class
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs of each individual method
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (40,100);
	int repeat = 1;
	int value = 0;
	String data = "";
	Node temp;
	while (repeat == 1)
	{
	    DoubleSortedLinkedList list = new DoubleSortedLinkedList ();
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("DoubleSortedLinkedList Testing");
	    c.setTextColor (Color.blue);
	    c.println ("Please enter a 1 (to insert an INTEGER + STRING value) or any other INTEGER to use an EMPTY Linked List: ");
	    repeat = c.readInt ();
	    while (repeat == 1)
	    {
		c.clear ();
		c.setTextColor (Color.red);
		c.println ("Insert Method Testing");
		c.setTextColor (Color.blue);
		c.print ("Please enter a STRING value to insert into the Linked List: ");
		data = c.readString ();
		c.print ("Please enter an INTEGER value to insert into the Linked List: ");
		value = c.readInt ();
		list.insert (data, value);
		c.print ("Please enter a 1 (to continue inserting values) or any other INTEGER to stop: ");
		repeat = c.readInt ();
	    }
	    c.clear ();
	    c.setTextColor (Color.black);
	    c.println (list.byName ());
	    c.println (list.byNumber ());
	    c.setTextColor (Color.red);
	    c.println ("FindBefore STRING Method");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a STRING value within the Linked List to find: ");
	    data = c.readString ();
	    c.setTextColor (Color.black);
	    temp = list.findBefore (data);
	    if (temp != null)
		c.println ("The NODE before the NODE containing the STRING: " + temp.name);
	    else
	    {
		if (list.listName != null)
		    c.println ("The NODE before the NODE containig the STRING: NULL");
		else
		    c.println ("DATA NOT FOUND");
	    }
	    c.setTextColor (Color.red);
	    c.println ("FindBefore INTEGER Method");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter an INTEGER value within the Linked List to find: ");
	    value = c.readInt ();
	    c.setTextColor (Color.black);
	    temp = list.findBefore (value);
	    if (temp != null)
		c.println ("The NODE before the NODE containing the INTEGER: " + temp.number);
	    else
	    {
		if (list.listNumber != null)
		    c.println ("The NODE before the NODE containig the INTEGER: NULL");
		else
		    c.println ("DATA NOT FOUND");
	    }
	    c.setTextColor (Color.red);
	    c.println ("Find STRING Method");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a STRING value within the Linked List to find: ");
	    data = c.readString ();
	    temp = list.findBefore (data);
	    c.setTextColor (Color.black);
	    if (temp != null)
		c.println ("The NODE containing the STRING: " + temp.name);
	    else
		c.println ("DATA NOT FOUND");
	    c.setTextColor (Color.red);
	    c.println ("Find INTEGER Method");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter an INTEGER value within the Linked List to find: ");
	    value = c.readInt ();
	    c.setTextColor (Color.black);
	    temp = list.findBefore (value);
	    if (temp != null)
		c.println ("The NODE containing the INTEGER: " + temp.number);
	    else
		c.println ("DATA NOT FOUND");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a 1 (to restart program) or any other INTEGER to end program: ");
	    repeat = c.readInt ();
	}


    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS NODE
/*
Author: Swethan Sivasegaran
Date: December 23 2017
Purpose: To PROVIDE a sort of container class to store individual STRING data information (name) + INTEGER data information (number) within each NODE in addition to keeping track of TWO NODE pointers and their STRING data (name) +
	 INTEGER (data). These TWO NODE pointers are POINTERS to the NEXT NODE under the sorting criteria of TWO DIFFERENT concepts (ALPHABETICALLY or NUMERICALLY) and are defaulted to NULL.

DATA FIELDS

number (INT) - An INTEGER data field that represents the INTEGER aspect of the CURRENT NODE's holding of data information under a numerical criteria for a linked list
name (STRING) - A STRING data field that represents the STRING aspect of the CURRENT NODE's holding of data information under a STRING NAME criteria for a linked list.
nextName (NODE) - A NODE type data field that represents the CURRENT NODE's pointer to another NODE type object supposedly in such a fashion that the NODE linkages are based on an ALPHABETICAL of the NODE's STRING NAME
nextNumber (NODE) - A NODE type data field that represents the CURRENT NODE's pointer to another NODE type object supposedly in such a fashion that the NODE linkages are based on a NUMERICAL ASCENSION of the NODE'S INTEGER value

METHODS

Constructor (with TWO PARAMETERS) - Given a STRING type parameter value and an INTEGER type parameter value, sets the STRING type data field (name) + the INTEGER type data field (number) to their respective STRING and INTEGER
				    parameter value. In addition, the NODE type data fields (nextName + nextNumber) are both set to Null.

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the STRING type data field (name) to DEFAULT and the INTEGER type data field (number) to 0. In addition, the NODE type data fields (nextName + nextNumber) are both
				   set to Null with the aid of the Constructor (with TWO PARAMETES).

byName - Based on the STRING type data field (name), returns a STRING value that corresponds to the CURRENT STRING type data field (name) + the STRING type data field (name) of each consecutive NODE that points
	 to the next(nextName pathway) in a sorted fashion starting from the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing. The method achieves this in a recursive like manner.

byNumber - Based on the INTEGER type data field (number), returns a STRING value that corresponds to the CURRENT INTEGER type data field (number) + the INTEGER type data field (name) of each consecutive NODE that points
	   to the next(nextNumber pathway) in a sorted fashion starting from the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing. The method achieves this in a recursive like manner.
	   Note: This will print NOT the sum of all the INTEGER values but the INTEGER values all lined up so that it showcases which NODE INTEGER data field value points to which different NODE INTEGER value.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Node
{
    //DATA FIELDS
    protected int number = 0;
    protected String name = "";
    protected Node nextName;
    protected Node nextNumber;

    // Constructor (with TWO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given a STRING type parameter value and an INTEGER type parameter value, sets the STRING type data field (name) + the INTEGER type data field (number) to their respective STRING and INTEGER parameter value.
	     In addition, the NODE type data fields (nextName + nextNumber) are both set to Null.
    Input: A STRING type parameter value and an INTEGER type parameter value
    Output: None - initializes the STRING type data field (name) + the INTEGER type data field (number) to their respective STRING and INTEGER parameter value. In addition, the NODE type data fields (nextName + nextNumber)
	    are both set to Null.
    */
    public Node (String name, int number)
    {
	this.name = name;
	this.number = number;
	this.nextName = null;
	this.nextNumber = null;
    }


    // ======================================================================================================
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given NO PARAMETERS, sets the STRING type data field (name) to DEFAULT and the INTEGER type data field (number) to 0. In addition, the NODE type data fields (nextName + nextNumber) are both set to Null with the aid
	     of the Constructor (with TWO PARAMETES).
    Input: None
    Output: None - initializes the STRING type data field (name) to DEFAULT and the INTEGER type data field (number) to 0. In addition, the NODE type data fields (nextName + nextNumber) are both set to Null.
    */

    public Node ()
    {
	this ("DEFAULT", 0);
    }


    // -------------------------------------------------------------------------------------------------------
    // byName

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Based on the STRING type data field (name), returns a STRING value that corresponds to the CURRENT STRING type data field (name) + the STRING type data field (name) of each consecutive NODE that points
	     to the next(nextName pathway) in a sorted fashion starting from the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing. The method achieves this in a recursive like manner.
    Input: None
    Output: Returns a STRING value that corresponds to the CURRENT STRING type data field (name) + the STRING type data field (name) of each consecutive NODE that points to the next (nextName pathway) in a sorted fashion starting from
	    the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing.
    */
    public String byName ()
    {
	String name = this.name + " --> ";
	if (this.nextName != null)
	    name = name + this.nextName.byName ();
	else
	    name = name + "Null";
	return name;
    }


    // ======================================================================================================

    // byNumber

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Based on the INTEGER type data field (number), returns a STRING value that corresponds to the CURRENT INTEGER type data field (number) + the INTEGER type data field (name) of each consecutive NODE that points
	     to the next(nextNumber pathway) in a sorted fashion starting from the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing. The method achieves this in a recursive like manner.
	     Note: This will print NOT the sum of all the INTEGER values but the INTEGER values all lined up so that it showcases which NODE INTEGER data field value points to which different NODE INTEGER value.
    Input: None
    Output: Returns a STRING value that corresponds to the CURRENT INTEGER type data field (number) + the INTEGER type data field (number) of each consecutive NODE that points to the next (nextNumber pathway) in a sorted fashion
	    starting from the CURRENT NODE + a STRING value of NULL at the end to signify the last pointer points to nothing.
	    Note: This will print NOT the sum of all the INTEGER values but the INTEGER values all lined up so that it showcases which NODE INTEGER data field value points to which different NODE INTEGER value.
    */
    public String byNumber ()
    {
	String number = this.number + " --> ";
	if (this.nextNumber != null)
	    number = number + this.nextNumber.byNumber ();
	else
	    number = number + "Null";
	return number;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS DOUBLESORTEDLINKEDLIST
/*
Author: Swethan Sivasegaran
Date: December 23 2017
Purpose: To create a DOUBLESORTEDLINKEDLIST class that will manage Nodes with the help of the NODE class which has TWO NODE pointers allowing for the purpose of TWO SINGLE LINKED LISTS under TWO DIFFERENT CRITERIA (STRING name
	 + INTEGER number). Hence, the DOUBLESORTEDLINKEDLIST class should perform a variety of operations that should give full flexibility to the programmer in the management of different NODES for different criterias.

DATA FIELDS

listName (NODE) - A NODE type data field that acts as the STARTING REFRENCE for the NODES in the DOUBLESORTEDLINKEDLIST in such a way that it is the FIRST NODE based on an ALPHABETICAL SORTING fashion for a NODE's STRING NAME value
listNumber (NODE) - A NODE type data field that acts as the STARTING REFRENCE for the NODES in the DOUBLESORTEDLINKEDLIST in such a way that it is the FIRST NODE based on a NUMERICAL ASCENSION SORTING fashion for a NODE's INTEGER value

Note: The STARTING REFRENCE based on the STRING NAME value or the INTEGER value of a NODE (listName + listNumber) may be held on different NODES within the DOUBLESORTEDLINKEDLIST. Both are defaulted to NULL initially.

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the NODE type data fields (listName + listNumber) both to Null

byName - Based on the NODE type data field (listName), returns a STRING value that corresponds to the STRING data field values (name) of all the NODES that point to the next NODE(nextName pathway) starting from
	 the root/the NODE type data field (listName). The method calls the method byName (see Method byName within NODE class) to achieve this.
	 - returns NOTHING if NODE type data field (listName) is NULL.

byNumber - Based on the NODE type data field (listNumber), returns a STRING value that corresponds to the INTEGER data field values (number) of all the NODES that point to the next NODE(nextNumber pathway) starting from
	   the root/the NODE type data field (listNumber). The method calls the method byNumber (see Method byNumber within NODE class) to achieve this.
	   - returns NOTHING if NODE type data field (listNumber) is NULL.

findBefore [OVERLOADED CRITERIA: STRING VALUE NAME] - Given a STRING type parameter value (name), returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same STRING type data field (name) as the one
						      given via parameter.
						    - Returns NULL if the the FIRST NODE(listName) contained the same STRING value as the one given via parameter
						    - Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
						    - Returns NULL if there was NO NODE that fit the criteria given via parameter.

findBefore[OVERLOADED CRITERIA: INTEGER VALUE NUMBER] - Given an INTEGER type parameter value (number), returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same INTEGER type data field (number) as the one
							given via parameter.
							- Returns NULL if the the FIRST NODE(listNumber) contained the same INTEGER value as the one given via parameter
							- Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
							- Returns NULL if there was NO NODE that fit the criteria given via parameter.

insert - Given a STRING parameter value + an INTEGER parameter value, inserts a NEW NODE with the given conditions as its parameters into the DOUBLESORTEDLINKEDLIST in such a way that the two different LINKEDLIST
	 under two different criteria (name + number) are still in a sorted ascending fashion (ALPHABETICALLY for STRING name pathway + numerical value ascension for INTEGER number pathway) using the two pathways
	 (nextName + nextNumber). This includes the switching of the two NODE pathway pointers (nextName + nextNumber).

find [OVERLOADED CRITERIA: STRING VALUE NAME] - Given a STRING parameter value, returns a NODE value that has the SAME EXACT STRING type data field value (name) as the given STRING parameter value within the DOUBLESORTEDLINKEDLIST.
						- returns NULL if NOT FOUND or if the linked list is EMPTY

find [OVERLOADED CRITERIA: INTEGER VALUE NUMBER] - Given an INTEGER parameter value, returns a NODE value that has the SAME EXACT INTEGER type data field value (number) as the given INTEGER parameter value within the
						   DOUBLESORTEDLINKEDLIST.
						   - returns NULL if NOT FOUND or if the linked list is EMPTY
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class DoubleSortedLinkedList
{
    //DATA FIELDS
    protected Node listName;
    protected Node listNumber;

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given NO PARAMETERS, sets the NODE type data fields (listName + listNumber) both to Null
    Input: None
    Output: None - sets the NODE type data fields (listName + listNumber) to Null
    */
    public DoubleSortedLinkedList ()
    {
	this.listName = null;
	this.listNumber = null;
    }


    // ======================================================================================================
    // byName

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Based on the NODE type data field (listName), returns a STRING value that corresponds to the STRING data field values (name) of all the NODES that point to the next NODE(nextName pathway) starting from
	     the root/the NODE type data field (listName). The method calls the method byName (see Method byName within NODE class) to achieve this.
	     - returns NOTHING if NODE type data field (listName) is NULL.
    Input: None
    Output: Returns a STRING value that corresponds to the STRING data field values (name) of all the NODES that point to the next NODE(nextName pathway) starting from the root/the NODE type data field (listName).
	    - returns NOTHING if NODE type data field (listName) is NULL.
    */
    public String byName ()
    {
	String name = "";
	if (this.listName != null)
	    name = "Linked List[Name]: " + this.listName.byName ();
	else
	    name = "Linked List[Name]: Empty";
	return name;
    }


    // -------------------------------------------------------------------------------------------------------
    // byNumber

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Based on the NODE type data field (listNumber), returns a STRING value that corresponds to the INTEGER data field values (number) of all the NODES that point to the next NODE(nextNumber pathway) starting from
	     the root/the NODE type data field (listNumber). The method calls the method byNumber (see Method byNumber within NODE class) to achieve this.
	     - returns NOTHING if NODE type data field (listNumber) is NULL.
    Input: None
    Output: Returns a STRING value that corresponds to the INTEGER data field values (number) of all the NODES that point to the next NODE(nextNumber pathway) starting from the root/the NODE type data field (listNumber).
	    - returns NOTHING if NODE type data field (listNumber) is NULL.
    */
    public String byNumber ()
    {
	String number = "";
	if (this.listNumber != null)
	    number = "Linked List[Number]: " + this.listNumber.byNumber ();
	else
	    number = "Linked List[Number]: Empty";
	return number;
    }


    // ======================================================================================================
    // findBefore [OVERLOADED CRITERIA: STRING VALUE NAME]

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given a STRING type parameter value (name), returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same STRING type data field (name) as the one given via parameter.
	     - Returns NULL if the the FIRST NODE(listName) contained the same STRING value as the one given via parameter
	     - Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
	     - Returns NULL if there was NO NODE that fit the criteria given via parameter.
    Input: A STRING type parameter value
    Output: Returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same STRING type data field (name) as the one given via parameter.
	     - Returns NULL if the the FIRST NODE(listName) contained the same STRING value as the one given via parameter
	     - Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
	     - Returns NULL if there was NO NODE that fit the criteria given via parameter.
    */
    public Node findBefore (String name)
    {
	Node temp = this.listName;
	if (temp != null)
	{
	    while (temp.nextName != null && temp.nextName.name.equals (name) == false)
		temp = temp.nextName;
	    if (temp == this.listName || temp.nextName == null)
		temp = null;
	}
	return temp;

    }


    //string equal

    // -------------------------------------------------------------------------------------------------------

    // findBefore [OVERLOADED CRITERIA: INTEGER VALUE NUMBER]

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given an INTEGER type parameter value (number), returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same INTEGER type data field (number) as the one given via parameter.
	     - Returns NULL if the the FIRST NODE(listNumber) contained the same INTEGER value as the one given via parameter
	     - Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
	     - Returns NULL if there was NO NODE that fit the criteria given via parameter.
    Input: A STRING type parameter value
    Output: Returns the NODE value before the NODE within the DOUBLESORTEDLINKEDLIST with the same STRING type data fied (name) as the one given via parameter.
	     - Returns NULL if the the FIRST NODE(listNummber) contained the same INTEGER value as the one given via parameter
	     - Returns NULL if DOUBLESORTEDLINKEDLIST is EMPTY
	     - Returns NULL if there was NO NODE that fit the criteria given via parameter.
    */
    public Node findBefore (int number)
    {
	Node temp = this.listNumber;
	if (temp != null)
	{
	    while (temp.nextNumber != null && temp.nextNumber.number != number)
		temp = temp.nextNumber;
	    if (temp == this.listNumber || temp.nextNumber == null)
		temp = null;
	}
	return temp;
    }


    // ======================================================================================================
    // insert

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given a STRING parameter value + an INTEGER parameter value, inserts a NEW NODE with the given conditions as its parameters into the DOUBLESORTEDLINKEDLIST in such a way that the two different LINKEDLIST
	     under two different criteria (name + number) are still in a sorted ascending fashion (ALPHABETICALLY for STRING name pathway + numerical value ascension for INTEGER number pathway) using the two pathways
	     (nextName + nextNumber). This includes the switching of the two NODE pathway pointers (nextName + nextNumber).
    Input: A STRING parameter value + INTEGER parameter value.
    Output: None - inserts a NEW NODE with the given conditions as its parameters into the DOUBLESORTEDLINKEDLIST in such a way that the two different LINKEDLIST under two different criteria (name + number) are still
	    in a sorted ascending fashion (ALPHABETICALLY for STRING name pathway + numerical value ascension for INTEGER number pathway) using the two pathways(nextName + nextNumber).
    */
    public void insert (String name, int number)
    {
	Node node = new Node (name, number);
	if (this.listName == null || this.listName.name.compareTo (node.name) >= 0)
	{
	    node.nextName = this.listName;
	    this.listName = node;
	}
	else
	{
	    Node nameTemp = this.listName;
	    while (nameTemp.nextName != null && nameTemp.nextName.name.compareTo (node.name) <= 0)
		nameTemp = nameTemp.nextName;
	    node.nextName = nameTemp.nextName;
	    nameTemp.nextName = node;

	}
	if (this.listNumber == null || this.listNumber.number >= node.number)
	{
	    node.nextNumber = this.listNumber;
	    this.listNumber = node;
	}
	else
	{
	    Node numTemp = this.listNumber;
	    while (numTemp.nextNumber != null && numTemp.nextNumber.number <= node.number)
		numTemp = numTemp.nextNumber;
	    DSLLTest.c.println (numTemp.number);
	    node.nextNumber = numTemp.nextNumber;
	    numTemp.nextNumber = node;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // find [OVERLOADED CRITERIA: STRING VALUE NAME]

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given a STRING parameter value, returns a NODE value that has the SAME EXACT STRING type data field value (name) as the given STRING parameter value within the DOUBLESORTEDLINKEDLIST.
	     - returns NULL if NOT FOUND or if the linked list is EMPTY
    Input: A STRING parameter value
    Output: Returns a NODE value that has the SAME EXACT STRING type data field value (name) as the given STRING parameter value within the DOUBLESORTEDLINKEDLIST.
	     - returns NULL if NOT FOUND or if the linked list is EMPTY
    */
    public Node find (String name)
    {
	Node temp = this.listName;
	while (temp != null && temp.name.equals (name) == false)
	    temp = temp.nextName;
	return temp;
    }


    // ======================================================================================================

    // find [OVERLOADED CRITERIA: INTEGER VALUE NUMBER]

    /*
    Author: Swethan Sivasegaran
    Date: December 23 2017
    Purpose: Given an INTEGER parameter value, returns a NODE value that has the SAME EXACT INTEGER type data field value (number) as the given INTEGER parameter value within the DOUBLESORTEDLINKEDLIST.
	     - returns NULL if NOT FOUND or if the linked list is EMPTY
    Input: An INTEGER parameter value
    Output: Returns a NODE value that has the SAME EXACT INTEGER type data field value (number) as the given INTEGER parameter value within the DOUBLESORTEDLINKEDLIST.
	     - returns NULL if NOT FOUND or if the linked list is EMPTY
    */
    public Node find (int number)
    {
	Node temp = this.listNumber;
	while (temp != null && temp.number != number)
	    temp = temp.nextNumber;
	return temp;
    }


    // -------------------------------------------------------------------------------------------------------
    //comment added string changes
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
