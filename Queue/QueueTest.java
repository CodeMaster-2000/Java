// The "QueueTest" class.
/*
Author: Swethan Sivasegaran
Date: January 11 2018
Purpose: To demonstrate the ability to provide different implementations of a QUEUE with the QUEUE class and its subclasses
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;
// CLASS QUEUETEST
/*
Author: Swethan Sivasegaran
Date: January 11 2018
Purpose: To demonstrate the capability and understanding of implementing different variations of a QUEUE using the QUEUE class and its subclasses

DATA FIELDS

METHODS

main - To test the functionality of the QUEUE class and its subclasses and its various sub class implementations
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class QueueTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: To test the functionality of the QUEUE class and its various sub class implementations
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs printed for each method via Console
    */
    static Console c;
    static Console restart;

    public static void main (String[] args)
    {
	c = new Console (40, 100);
	restart = new Console ();
	boolean full = false;
	boolean empty = false;
	int repeat = 1;
	int queueType = 0;
	int option = 0;
	while (repeat == 1)
	{
	    StraightLineArray lineArray = new StraightLineArray ();
	    CircularArray circleArray = new CircularArray ();
	    AddShiftArray addArray = new AddShiftArray ();
	    RemoveShiftArray removeArray = new RemoveShiftArray ();
	    SinglyLinkedList list = new SinglyLinkedList ();
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Queue Variation Testing");
	    c.setTextColor (Color.blue);
	    c.println ("\nEnter 1 to test with Straight Line Array\nEnter 2 to test with Circular Array\nEnter 3 to test with Shifting After Adding Array\nEnter 4 to test with Shifting After Removing Array\nEnter 5 to test with Linked List");
	    c.print ("\n\nPlease enter an INTEGER value according to the options provided above: ");
	    queueType = c.readInt ();
	    c.clear ();
	    while (repeat == 1)
	    {
		restart.clear ();
		c.clear ();
		c.setTextColor (Color.red);
		c.println ("Method Testing - add + remove + reset");
		c.setTextColor (Color.blue);
		c.println ("Enter 1 to test add method\nEnter 2 to test remove method\nEnter 3 to test reset method");
		c.print ("\nPlease enter an INTEGER value according to the options provided: ");
		option = c.readInt ();
		if (queueType == 1)
		{
		    if (option == 1)
			lineArray.add ();
		    if (option == 2)
			lineArray.remove ();
		    if (option == 3)
			lineArray.reset ();
		}
		else if (queueType == 2)
		{
		    if (option == 1)
			circleArray.add ();
		    else if (option == 2)
			circleArray.remove ();
		    else if (option == 3)
			circleArray.reset ();
		}
		else if (queueType == 3)
		{
		    if (option == 1)
			addArray.add ();
		    else if (option == 2)
			addArray.remove ();
		    else if (option == 3)
			addArray.reset ();
		}
		else if (queueType == 4)
		{
		    if (option == 1)
			removeArray.add ();
		    else if (option == 2)
			removeArray.remove ();
		    else if (option == 3)
			removeArray.reset ();
		}
		else if (queueType == 5)
		{
		    if (option == 1)
			list.add ();
		    else if (option == 2)
			list.remove ();
		    else if (option == 3)
			list.reset ();
		}
		restart.clear ();
		restart.println ("Result");
		if (queueType == 1)
		{
		    full = lineArray.isFull();
		    empty = lineArray.isEmpty();
		    lineArray.display (restart, 15, 20);
		}
		else if (queueType == 2)
		{
		    full = circleArray.isFull();
		    empty = circleArray.isEmpty();
		    circleArray.display (restart, 15, 20);
		}
		else if (queueType == 3)
		{
		    full = addArray.isFull();
		    empty = addArray.isEmpty();
		    addArray.display (restart, 15, 20);
		}
		else if (queueType == 4)
		{
		    full = removeArray.isFull();
		    empty = removeArray.isEmpty();
		    removeArray.display (restart, 15, 20);
		}
		else if (queueType == 5)
		{
		    full = false;
		    empty = list.isEmpty();
		    list.display (restart, 15, 20);
		}
		c.setTextColor(Color.black);
		c.println("The status of full: " + full);
		c.println("The status of empty: " + empty);
		c.setTextColor (Color.blue);
		c.print ("\n\n\nPlease enter a 1 (to continue testing methods) or any other key to end program: ");
		repeat = c.readInt ();
	    }
	    restart.clear ();
	    c.clear ();
	    c.print ("Please enter a 1 (to restart program) or any other key to end program: ");
	    repeat = c.readInt ();
	}

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// ABSTRACT CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 11 2018
Purpose: To provide restrictions on any IMPLEMENTATIONS of a QUEUE structure such that the subclasses of this QUEUE must have a method to display it (display), a method to add values (add), a method to remove values (remove) and a
	 method to reset everything (reset).

DATA FIELDS - None

ABSTRACT METHODS

display - Given a CONSOLE type parameter value, and two INTEGER parameter values (x and y co-ordinate value, the method should print the QUEUE implemntation to display the data and how it is stored into the database including
	  the location of the FRONT and BACK of the QUEUE

add - Given NO PARAMETERS, the method should add the necessary DATA information onto the QUEUE and store it accordingly such that it follows the First In First Out concept

remove - Given NO PARAMETERS, the method should remove the FIRST DATA information that the QUEUE contains such that it follows the First In First Out concept

reset - Given NO PARAMETERS, the method should reset the FRONT + BACK indexes and any other necessary variables such that the QUEUE is EMPTY or at the state at which it began

CONCRETE METHODS - None

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
abstract class Queue
{
    // display [ABSTRACT]

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given a CONSOLE type parameter value, and two INTEGER parameter values (x and y co-ordinate value, the method should print the QUEUE implemntation to display the data and how it is stored into the database including
	     the location of the FRONT and BACK of the QUEUE
    Input: None
    Output: None - The method should print the QUEUE implemntation to display the data and how it is stored into the database including the location of the FRONT and BACK of the QUEUE
    */
    abstract public void display (Console c, int xValue, int yValue);
    // ======================================================================================================
    // add [ABSTRACT]

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given NO PARAMETERS, the method should add the necessary DATA information onto the QUEUE and store it accordingly such that it follows the First In First Out concept
    Input: None
    Output: None - The method should add the necessary DATA information onto the QUEUE and store it accordingly such that it follows the First In First Out concept
    */
    abstract public void add ();
    // -------------------------------------------------------------------------------------------------------
    // remove [ABSTRACT]

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given NO PARAMETERS, the method should remove the FIRST DATA information that the QUEUE contains such that it follows the First In First Out concept
    Input: None
    Output: None - The method should remove the FIRST DATA information that the QUEUE contains such that it follows the First In First Out concept
    */
    abstract public void remove ();
    // ======================================================================================================
    // reset [ABSTRACT]

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given NO PARAMETERS, the method should reset the FRONT + BACK indexes and any other necessary variables such that the QUEUE is EMPTY or at the state at which it began
    Input: None
    Output: None - The method should reset the FRONT + BACK indexes and any other necessary variables such that the QUEUE is EMPTY or at the state at which it began
    */
    abstract public void reset ();
    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS STRAIGHTLINEARRAY --> inherited from CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 11 2018
Purpose: To demonstrate the full capability of a QUEUE in the form of an ARRAY data structure with the FULL IMPLEMENTATION of the required methods from the CLASS QUEUE from which this class inherits from. In this form of a QUEUE, the
	 STRAIGHTLINEARRAY will add INTEGER values until it reaches the end of the QUEUE which would be the last index. Hence, since this method has no way of working around it, it will stop doing anything afterwards.

DATA FIELDS

front (INT) - An INTEGER type data field that keeps refrence to the FIRST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
back (INT) -  An INTEGER type data field that keeps refrence to the LAST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
size (INT) - An INTEGER type data field that corresponds to the INTEGER [] data field (intArray) size or rather the maximum capacity for the number of INTEGER information the QUEUE can hold (DEFAULT 10)
intArray (INTEGER []) - An INTEGER [] type data field that holds all the INTEGER data information of the STRAIGHTLINEARRAY implementation of the QUEUE (DEFAULT SIZE 10)

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER type data fields (front + back) to 0 meaning they both point to the firstIndex of the INTEGER [] type data field (intArray) which is created at a set size
				   of 10 initially and it cannot be changed. The INTEGER type data field (size) is set equal to this value (10).

isEmpty - Based on the TWO INTEGER type data fields (front + back), returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is empty or not.
	  - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back) meaning that the two INTEGER index refrences to the INTEGER [] type data field (intArray) are the same
	  - returns FALSE otherwise.

isFull - Based on the TWO INTEGER data fields (front + back) returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is full or not.
	 - returns TRUE if the INTEGER data field (back) reaches the end of the INTEGER [] data field (intArray) last index value
	 - returns FALSE otherwise

display - Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	  referall and the INTEGER data field (back) referall are noted. The display is in the form of an array.

add - Based on the INTEGER type data field (back), changes the INTEGER value on the represented next index value within the INTEGER [] data field (intArray) to INTEGER values from 1 to 10. This INTEGER value replaces
      the default 0 value or any other previous value depending on where the INTEGER data field (back) lies within the INTEGER [] data field (intArray) filled with indexes. Initially the INTEGER value added or
      inserted is 1 and increases by 1 every time until the value of 10 is reached at which point the array will become full as this is a STRAIGHTLINEARRAY implementation of the QUEUE. In addition, the INTEGER data
      field value (back) is increased by 1 each time the method is called.

remove - Based on the INTEGER type data field (front), increases the INTEGER data field (front) by 1 each time the method is called. In this way, the index represented by the INTEGER data field (front) within the INTEGER []
	 data field (intArray) now refrences the next index such that the value in the previous index is now forgotten or in other words removed. The INTEGER data field (front) only increases until its reached the last index.

reset - The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	refrences are pointing to the first Index which indicates an EMPTY QUEUE.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class StraightLineArray extends Queue
{
    //DATA FIELDS
    protected int front = 0;
    protected int back = 0;
    protected int size = 0;
    protected int[] intArray;
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given NO PARAMETERS, sets the INTEGER type data fields (front + back) to 0 meaning they both point to the firstIndex of the INTEGER [] type data field (intArray) which is created at a set size of 10 initially
	     and it cannot be changed. The INTEGER type data field (size) is set equal to this value (10).
    Input: None
    Output: None - sets the INTEGER type data fields (front + back) to 0 meaning they both point to the firstIndex of the INTEGER [] type data field (intArray) which is created at a set size of 10 initially and it cannot be
	    changed. The INTEGER type data field (size) is set equal to this value (10).
    */
    public StraightLineArray ()
    {
	this.front = 0;
	this.back = 0;
	this.intArray = new int [10];
	this.size = this.intArray.length;
    }


    // ======================================================================================================

    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Based on the TWO INTEGER type data fields (front + back), returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is empty or not.
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back) meaning that the two INTEGER index refrences to the INTEGER [] type data field (intArray) are the same
	     - returns FALSE otherwise.
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is empty or not.
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back) meaning that the two INTEGER index refrences to the INTEGER [] type data field (intArray) are the same
	     - returns FALSE otherwise.
    */
    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }


    // -------------------------------------------------------------------------------------------------------
    // isFull

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Based on the TWO INTEGER data fields (front + back) returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is full or not.
	     - returns TRUE if the INTEGER data field (back) reaches the end of the INTEGER [] data field (intArray) last index value
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the STRAIGHTLINEARRAY implementation of a QUEUE is full or not.
	     - returns TRUE if the INTEGER data field (back) reaches the end of the INTEGER [] data field (intArray) last index value
	     - returns FALSE otherwise
    */

    public boolean isFull ()
    {
	boolean full = false;
	if (this.back == this.size - 1)
	    full = true;
	return full;
    }


    // ======================================================================================================
    // display

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	     referall and the INTEGER data field (back) referall are noted. The display is in the form of an array and it will be printed on the x and y co-ordinate given via parameter on the Console given via parameter.
    Input: Console type parameter value + two INTEGER parameter value
    Output: None - prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index referall and the INTEGER data field (back) referall are noted. The display is in
	    the form of an array.
    */
    public void display (Console c, int xValue, int yValue)
    {
	int index = 0;
	while (index < this.size)
	{
	    c.drawRect (xValue, yValue, 40, 40);
	    c.drawString (this.intArray [index] + "", xValue + 18, yValue + 24);
	    if (index == this.front)
		c.drawString ("Front", xValue + 7, yValue + 12);
	    if (index == this.back)
		c.drawString ("Back", xValue + 7, yValue + 36);
	    xValue = xValue + 40;
	    index = index + 1;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // add

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Based on the INTEGER type data field (back), changes the INTEGER value on the represented next index value within the INTEGER [] data field (intArray) to INTEGER values from 1 to 10. This INTEGER value replaces
	     the default 0 value or any other previous value depending on where the INTEGER data field (back) lies within the INTEGER [] data field (intArray) filled with indexes. Initially the INTEGER value added or
	     inserted is 1 and increases by 1 every time until the value of 10 is reached at which point the array will become full as this is a STRAIGHTLINEARRAY implementation of the QUEUE. In addition, the INTEGER data
	     field value (back) is increased by 1 each time the method is called.
    Input: None
    Output: None - changes the INTEGER value on the represented next index value within the INTEGER [] data field (intArray) to INTEGER values from 1 to 10. This INTEGER value replaces
	    the default 0 value or any other previous value depending on where the INTEGER data field (back) lies within the INTEGER [] data field (intArray) filled with indexes. Initially the INTEGER value added or
	    inserted is 1 and increases by 1 every time until the value of 10 is reached at which point the array will become full as this is a STRAIGHTLINEARRAY implementation of the QUEUE. In addition, the INTEGER data
	    field value (back) is increased by 1 each time the method is called.
    */
    public void add ()
    {
	this.intArray [this.back] = this.back + 1;
	if (this.back < this.size - 1)
	    this.back++;
    }


    // ======================================================================================================

    // remove

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: Based on the INTEGER type data field (front), increases the INTEGER data field (front) by 1 each time the method is called. In this way, the index represented by the INTEGER data field (front) within the INTEGER []
	     data field (intArray) now refrences the next index such that the value in the previous index is now forgotten or in other words removed. The INTEGER data field (front) only increases until its reached the last index.
    Input: None
    Output: None - increases the INTEGER data field (front) by 1 each time the method is called. In this way, the index represented by the INTEGER data field (front) within the INTEGER [] data field (intArray) now refrences the
	    next index such that the value in the previous index is now forgotten or in other words removed. The INTEGER data field (front) only increases until its reached the last index.
    */
    public void remove ()
    {
	if (this.front < this.back)
	    this.front++;
    }


    // -------------------------------------------------------------------------------------------------------
    // reset

    /*
    Author: Swethan Sivasegaran
    Date: January 11 2018
    Purpose: The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	     refrences are pointing to the first Index which indicates an EMPTY QUEUE.
    Input: None
    Output: None - The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1
    */

    public void reset ()
    {
	this.front = 0;
	this.back = 0;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS CIRCULARARRAY --> inherited from CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 12 2018
Purpose: To demonstrate the full capability of a QUEUE in the form of an ARRAY data structure with the FULL IMPLEMENTATION of the required methods from the CLASS QUEUE from which this class inherits from. In this form of a QUEUE, the
	 CIRCULARARRAY will add INTEGER values in such a way that once the LAST INTEGER value reaches the LAST INDEX it will loop back around and rewrite on top of the FIRST INDEX value so that the ARRAY is essentially circular in a
	 sense. However, the CIRCULAR ARRAY is full when the back index is one less than the front index for sanity purposes and the CIRCULAR ARRAY is empty when the back and front index are both the same.

DATA FIELDS

counter (INT) - An INTEGER type data field that represents the value that must be added per turn (DEFAULT 1). This value increases by 1 each time the QUEUE increases. Hence, a QUEUE will hold consecutive integers.
front (INT) - An INTEGER type data field that keeps refrence to the FIRST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
back (INT) -  An INTEGER type data field that keeps refrence to the LAST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
intArray (INTEGER []) - An INTEGER [] type data field that holds all the INTEGER data information of the STRAIGHTLINEARRAY implementation of the QUEUE (DEFAULT SIZE 10)

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER data
				   field (counter) is set to 1.

isEmpty - Based on the INTEGER data fields (front + back), returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is empty or not.
	  - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	  - returns TRUE if the INTEGER data field (back) is at the end index value and the INTEGER data field (front) value is 0
	  - returns FALSE otherwise

isFull - Based on the INTEGER data fields (front + back), returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is full or not.
	 - returns TRUE if the INTEGER data field (back) is 1 less than the INTEGER data field (front) value.
	 - returns FALSE otherwise

display - Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	  referall and the INTEGER data field (back) referall are noted. The display is in the form of an array.

add - Based on the INTEGER data fields (back + counter), changes the value at the index represented by the INTEGER data field (back) to the INTEGER value of the INTEGER data field (counter). In addition, the INTEGER data
      fields (back + counter) are increased by 1. However, once the INTEGER data field (back) reaches the value equivalent to the end index value of the INTEGER [] type data field value (intArray), its value loops back around
      and is set back to 0.
      Note: The method perforsm nothing if the QUEUE is full which it calls isFull to determine (see Method isFull WITHIN class)

remove - Based on the INTEGER data field (front), the method increases its value by 1 each time until the INTEGER data field (front) reaches a value equivalent to the last index value within the INTEGER [] data field (intArray).
	 In this case, the INTEGER data field (front) loops back and is set back to 0 to fulfill the implementation of a CIRCULARARRAY version of a QUEUE.
	 Note: This method only performs an action if the QUEUE is not empty by calling the method isEmpty (see Method isEmpty WITHIN class)

reset - The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	refrences are pointing to the first Index which indicates an EMPTY QUEUE.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class CircularArray extends Queue
{
    //DATA FIELDS
    protected int counter = 1;
    protected int front = 0;
    protected int back = 0;
    protected int[] intArray;
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given NO PARAMETERS, sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER data
	     field (counter) is set to 1.
    Input: None
    Output: None - sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER data field (counter)
	    is set to 1.
    */
    public CircularArray ()
    {
	this.front = 0;
	this.back = 0;
	this.counter = 1;
	this.intArray = new int [10];
    }


    // ======================================================================================================

    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (front + back), returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is empty or not.
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is empty or not.
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	     - returns FALSE otherwise
    */
    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }


    // -------------------------------------------------------------------------------------------------------
    // isFull

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (front + back), returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is full or not.
	     - returns TRUE if the INTEGER data field (back) is 1 less than the INTEGER data field (front) value.
	     - returns TRUE if the INTEGER data field (back) is at the end index value and the INTEGER data field (front) value is 0
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the CIRCULARARRAY implementation of a QUEUE is full or not.
	    - returns TRUE if the INTEGER data field (back) is 1 less than the INTEGER data field (front) value.
	    - returns FALSE otherwise
    */
    public boolean isFull ()
    {
	boolean full = false;
	if (this.back + 1 == this.front || this.back == this.intArray.length - 1 && this.front == 0)
	    full = true;
	return full;
    }


    // ======================================================================================================
    // display

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	     referall and the INTEGER data field (back) referall are noted. The display is in the form of an array and it will be printed on the x and y co-ordinate given via parameter on the Console given via parameter.
    Input: Console type parameter value + two INTEGER parameter value
    Output: None - prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index referall and the INTEGER data field (back) referall are noted. The display is in
	    the form of an array.
    */
    public void display (Console c, int xValue, int yValue)
    {
	int index = 0;
	while (index < this.intArray.length)
	{
	    c.drawRect (xValue, yValue, 40, 40);
	    c.drawString (this.intArray [index] + "", xValue + 18, yValue + 24);
	    if (index == this.front)
		c.drawString ("Front", xValue + 7, yValue + 12);
	    if (index == this.back)
		c.drawString ("Back", xValue + 7, yValue + 36);
	    xValue = xValue + 40;
	    index = index + 1;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // add
    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (back + counter), changes the value at the index represented by the INTEGER data field (back) to the INTEGER value of the INTEGER data field (counter). In addition, the INTEGER data
	     fields (back + counter) are increased by 1. However, once the INTEGER data field (back) reaches the value equivalent to the end index value of the INTEGER [] type data field value (intArray), its value loops back around
	     and is set back to 0.
	     Note: The method perforsm nothing if the QUEUE is full which it calls isFull to determine (see Method isFull WITHIN class)
    Input: None
    Output: None - changes the value at the index represented by the INTEGER data field (back) to the INTEGER value of the INTEGER data field (counter). In addition, the INTEGER data fields (back + counter) are increased by 1.
	    However, once the INTEGER data field (back) reaches the value equivalent to the end index value of the INTEGER [] type data field value (intArray), its value loops back around and is set back to 0.
	    Note: The method perforsm nothing if the QUEUE is full which it calls isFull to determine (see Method isFull WITHIN class)
    */
    public void add ()
    {
	if (!this.isFull ())
	{
	    this.intArray [this.back] = this.counter;
	    if (this.back == this.intArray.length - 1)
		this.back = 0;
	    else
		this.back++;
	    this.counter++;
	}
    }


    // ======================================================================================================

    // remove

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data field (front), the method increases its value by 1 each time until the INTEGER data field (front) reaches a value equivalent to the last index value within the INTEGER [] data field (intArray).
	     In this case, the INTEGER data field (front) loops back and is set back to 0 to fulfill the implementation of a CIRCULARARRAY version of a QUEUE.
	     Note: This method only performs an action if the QUEUE is not empty by calling the method isEmpty (see Method isEmpty WITHIN class)
    Input: None
    Output: None -  the method increases its value by 1 each time until the INTEGER data field (front) reaches a value equivalent to the last index value within the INTEGER [] data field (intArray). In this case, the INTEGER data
	    field (front) loops back and is set back to 0 to fulfill the implementation of a CIRCULARARRAY version of a QUEUE.
	    Note: This method only performs an action if the QUEUE is not empty by calling the method isEmpty (see Method isEmpty WITHIN class)
    */
    public void remove ()
    {
	if (!this.isEmpty ())
	{
	    if (this.front == this.intArray.length - 1)
		this.front = 0;
	    else
		this.front++;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // reset

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	     refrences are pointing to the first Index which indicates an EMPTY QUEUE.
    Input: None
    Output: None -  The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1
    */
    public void reset ()
    {
	this.front = 0;
	this.back = 0;
	this.counter = 1;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS ADDSHIFTARRAY --> inherited from CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 12 2018
Purpose: To demonstrate the full capability of a QUEUE in the form of an ARRAY data structure with the FULL IMPLEMENTATION of the required methods from the CLASS QUEUE from which this class inherits from. In this form of a QUEUE, the
	 ADDSHIFT method will shift the QUEUE so that it starts at index 0 everytime the QUEUE's last value is at the last index of the ARRAY data structure and the QUEUE is not full.

DATA FIELDS

counter (INT) - An INTEGER type data field that represents the value that must be added per turn (DEFAULT 1). This value increases by 1 each time the QUEUE increases. Hence, a QUEUE will hold consecutive integers.
front (INT) - An INTEGER type data field that keeps refrence to the FIRST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
back (INT) -  An INTEGER type data field that keeps refrence to the LAST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
intArray (INTEGER []) - An INTEGER [] type data field that holds all the INTEGER data information of the STRAIGHTLINEARRAY implementation of the QUEUE (DEFAULT SIZE 10)

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
				   data field (counter) is set to 1.

isEmpty - Based on the INTEGER data fields (front + back), returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is empty or not
	  - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	  - returns false otherwise

isFull - Based on the INTEGER data fields (front + back), returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is full or nto
	 - returns TRUE if the INTEGER data field (front) is 0 and the INTEGER data field (back) is equal to the end index value of the INTEGER [] data field (intArray)
	 - returns false otherwise

display - Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	  referall and the INTEGER data field (back) referall are noted. The display is in the form of an array.

shift - Based on the INTEGER data fields (back + front), shifts all the values in the INTEGER [] data field (intArray) starting from the index represented by the INTEGER data field (front) to the index represented by the INTEGER
	data field (back) all the way to the beginning of the INTEGER [] data field (intArray). Hence, the first value at the index represented by the INTEGER data field (front) would now be at index 0 and on forth until the last
	value that the index represented by the INTEGER data field (back) holds onto. The INTEGER data field (front) is set to 0 and the INTEGER data field (back) is set to a value equivalent to its value subtracted by the front
	index value.

add - Based on the INTEGER data fields (back + front), shifts all the values in the INTEGER [] data field (intArray) starting from the index represented by the INTEGER data field (front) to the index represented by the INTEGER
      data field (back) all the way to the beginning of the INTEGER [] data field (intArray). Hence, the first value at the index represented by the INTEGER data field (front) would now be at index 0 and on forth until the last
      value that the index represented by the INTEGER data field (back) holds onto. The INTEGER data field (front) is set to 0 and the INTEGER data field (back) is set to a value equivalent to its value subtracted by the front
      index value.

remove - Based on the INTEGER data fields (front + back), increases the INTEGER data field (front) by 1 at every call for this method until it is greater than or equal to the INTEGER data field (back). Essentially, it moves the
	 index represented by the INTEGER data field (front) such that its previous index value is forgotten and lost. Hence, the QUEUE gets shorter after the method is called.

reset - The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	refrences are pointing to the first Index which indicates an EMPTY QUEUE.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class AddShiftArray extends Queue
{
    //DATA FIELDS
    protected int counter = 1;
    protected int front = 0;
    protected int back = 0;
    protected int[] intArray;
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given NO PARAMETERS, sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
	     data field (counter) is set to 1.
    Input: None
    Output: None - sets the INTEGER data fields (front + back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
	    data field (counter) is set to 1.
    */
    public AddShiftArray ()
    {
	this.front = 0;
	this.back = 0;
	this.counter = 1;
	this.intArray = new int [10];
    }


    // ======================================================================================================

    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (front + back), returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is empty or not
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	     - returns false otherwise
    Input: None
    Output: Returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is empty or not
	     - returns TRUE if the INTEGER data field (front) is equal to the INTEGER data field (back)
	     - returns false otherwise
    */
    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }


    // -------------------------------------------------------------------------------------------------------
    // isFull

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (front + back), returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is full or nto
	     - returns TRUE if the INTEGER data field (front) is 0 and the INTEGER data field (back) is equal to the end index value of the INTEGER [] data field (intArray)
	     - returns false otherwise
    Input: None
    Output: Returns a BOOLEAN value according to whether the ADDSHIFTARRAY implementation of a QUEUE is full or nto
	     - returns TRUE if the INTEGER data field (front) is 0 and the INTEGER data field (back) is equal to the end index value of the INTEGER [] data field (intArray)
	     - returns false otherwise
    */
    public boolean isFull ()
    {
	boolean full = false;
	if (this.back == this.intArray.length - 1 && this.front == 0)
	    full = true;
	return full;
    }


    // ======================================================================================================
    // display

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	     referall and the INTEGER data field (back) referall are noted. The display is in the form of an array and it will be printed on the x and y co-ordinate given via parameter on the Console given via parameter.
    Input: Console type parameter value + two INTEGER parameter value
    Output: None - prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index referall and the INTEGER data field (back) referall are noted. The display is in
	    the form of an array.
    */
    public void display (Console c, int xValue, int yValue)
    {
	int index = 0;
	while (index < this.intArray.length)
	{
	    c.drawRect (xValue, yValue, 40, 40);
	    c.drawString (this.intArray [index] + "", xValue + 18, yValue + 24);
	    if (index == this.front)
		c.drawString ("Front", xValue + 7, yValue + 12);
	    if (index == this.back)
		c.drawString ("Back", xValue + 7, yValue + 36);
	    xValue = xValue + 40;
	    index = index + 1;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // shift

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (back + front), shifts all the values in the INTEGER [] data field (intArray) starting from the index represented by the INTEGER data field (front) to the index represented by the INTEGER
	     data field (back) all the way to the beginning of the INTEGER [] data field (intArray). Hence, the first value at the index represented by the INTEGER data field (front) would now be at index 0 and on forth until the last
	     value that the index represented by the INTEGER data field (back) holds onto. The INTEGER data field (front) is set to 0 and the INTEGER data field (back) is set to a value equivalent to its value subtracted by the front
	     index value.
    Input: None
    Output: None - shifts all the values in the INTEGER [] data field (intArray) starting from the index represented by the INTEGER data field (front) to the index represented by the INTEGER data field (back) all the way to the
	    beginning of the INTEGER [] data field (intArray). Hence, the first value at the index represented by the INTEGER data field (front) would now be at index 0 and on forth until the last value that the index represented
	    by the INTEGER data field (back) holds onto. The INTEGER data field (front) is set to 0 and the INTEGER data field (back) is set to a value equivalent to its value subtracted by the front
    */
    public void shift ()
    {
	int count = 0;
	while (count < this.back - this.front)
	{
	    this.intArray [count] = this.intArray [this.front + count];
	    count = count + 1;
	}
	this.back = this.back - this.front;
	this.front = 0;
    }


    // ======================================================================================================

    // add

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data field (back + counter), the method shifts all the INTEGER values within the INTEGER [] data field (intArray) down by calling the method shift (see Method shift WITHIN class). Essentially, the
	     method ensures that the FIRST INTEGER value in the ADDSHIFTARRAY implementation of a QUEUE is at index 0 if it was not before. In addition, the INTEGER data field (back + counter) are increased by 1.
    Input: None
    Output: None - The method shifts all the INTEGER values within the INTEGER [] data field (intArray) down by calling the method shift (see Method shift WITHIN class). Essentially, the method ensures that the FIRST INTEGER value
	    in the ADDSHIFTARRAY implementation of a QUEUE is at index 0 if it was not before. In addition, the INTEGER data field (back + counter) are increased by 1.
    */
    public void add ()
    {
	if (this.back == this.intArray.length - 1 && this.front != 0)
	    this.shift ();
	this.intArray [this.back] = this.counter;
	if (this.back < this.intArray.length - 1)
	{
	    this.back++;
	    this.counter++;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // remove

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (front + back), increases the INTEGER data field (front) by 1 at every call for this method until it is greater than or equal to the INTEGER data field (back). Essentially, it moves the
	     index represented by the INTEGER data field (front) such that its previous index value is forgotten and lost. Hence, the QUEUE gets shorter after the method is called.
    Input: None
    Output: None - increases the INTEGER data field (front) by 1 at every call for this method until it is greater than or equal to the INTEGER data field (back). Essentially, it moves the index represented by the INTEGER data
	    field (front) such that its previous index value is forgotten and lost. Hence, the QUEUE gets shorter after the method is called.
    */
    public void remove ()
    {
	if (this.front < this.back)
	    this.front++;
    }


    // ======================================================================================================

    // reset

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1. Although the previous INTEGER values in the INTEGER [] data field (intArray) are intact, the index INTEGER
	     refrences are pointing to the first Index which indicates an EMPTY QUEUE.
    Input: None
    Output: None - The INTEGER data fields (front + back) are reset to 0 and the INTEGER data field (counter) is reset to 1
    */
    public void reset ()
    {
	this.front = 0;
	this.back = 0;
	this.counter = 1;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS REMOVESHIFTARRAY --> inherited from CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 12 2018
Purpose: To demonstrate the full capability of a QUEUE in the form of an ARRAY data structure with the FULL IMPLEMENTATION of the required methods from the CLASS QUEUE from which this class inherits from. In this form of a QUEUE, the
	 REMOVESHIFT method will shift the QUEUE so that it starts at index 0 everytime the class removes an INTEGER value from the QUEUE.

DATA FIELDS

counter (INT) - An INTEGER type data field that represents the value that must be added per turn (DEFAULT 1). This value increases by 1 each time the QUEUE increases. Hence, a QUEUE will hold consecutive integers.
back (INT) -  An INTEGER type data field that keeps refrence to the LAST INDEX of the QUEUE in a STRAIGHTLINEARRAY implementation of it (DEFAULT 0)
intArray (INTEGER []) - An INTEGER [] type data field that holds all the INTEGER data information of the STRAIGHTLINEARRAY implementation of the QUEUE (DEFAULT SIZE 10)

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER data fields (back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
	     data field (counter) is set to 1.

isEmpty - Based on the INTEGER data field (back), returns a BOOLEAN value corresponding to whether the REMOVESHIFTARRAY implementation of a QUEUE is empty or not
	  - returns TRUE if the INTEGER data field (back) is equal to 0
	  - returns FALSE otherwise

isFull - Based on the INTEGER data field (back), returns a BOOLEAN value corresponding to whether the REMOVESHIFTARRAY implementation of a QUEUE is empty or not
	 - returns TRUE if the INTEGER data field (back) is equal to 0
	 - returns FALSE otherwise

display - Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	  referall and the INTEGER data field (back) referall are noted. The display is in the form of an array.

add - Based on the INTEGER data fields (back + counter), adds or rather changes the INTEGER value at the index represented by the INTEGER data field (back) into a value equivalent to the INTEGER data field (counter). In addition,
      the INTEGER data field (back + counter) are increased by 1.

remove - Based on the INTEGER data field (back), removes the FIRST INTEGER value in the INTEGER [] data field (intArray) from the REMOVESHIFTARRAY implementation of a QUEUE data set which would lie on index 0. This is achieved by
	 shifting ALL INTEGER values within the QUEUE back one index such that the FIRST INTEGER VALUE on index 0 is replaced by the SECOND INTEGER value on index 1 and so forth.
	 Note: The method performs nothing if the QUEUE is empty which it calls isEmpty to determine it (see Method isEmpty WITHIN class)

reset - The INTEGER data field (back) is reset to 0 and the INTEGER data field (counter) is reset to 1. Although previous values in the INTEGER [] data field (intArray) are intact, the index INTEGER refrence exists at 0 meaning
	it is an EMPTY QUEUE.

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class RemoveShiftArray extends Queue
{
    //DATA FIELDS
    protected int counter = 1;
    protected int back = 0;
    protected int[] intArray;
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given NO PARAMETERS, sets the INTEGER data fields (back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
	     data field (counter) is set to 1.
    Input: None
    Output: None - sets the INTEGER data fields (back) to 0 and the INTEGER [] type data field (intArray) is initialized to a new INSTANCE of an INTEGER [] with a fixed size of 10. In addition, the INTEGER
	    data field (counter) is set to 1.
    */
    public RemoveShiftArray ()
    {
	this.counter = 1;
	this.back = 0;
	this.intArray = new int [10];
    }


    // ======================================================================================================
    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data field (back), returns a BOOLEAN value corresponding to whether the REMOVESHIFTARRAY implementation of a QUEUE is empty or not
	     - returns TRUE if the INTEGER data field (back) is equal to 0
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value corresponding to whether the REMOVESHIFTARRAY implementation of a QUEUE is empty or not
	    - returns TRUE if the INTEGER data field (back) is equal to 0
	    - returns FALSE otherwise
    */

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.back == 0)
	    empty = true;
	return empty;
    }


    // -------------------------------------------------------------------------------------------------------
    // isFull

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data field (back), returns a BOOLEAN value that corresponds to whether the REMOVESHIFTARRAY implementation of a QUEUE is full or not
	     - returns TRUE if the INTEGER data field (back) is equal to the last index in the INTEGER [] data field (intArray)
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the REMOVESHIFTARRAY implementation of a QUEUE is full or not
	    - returns TRUE if the INTEGER data field (back) is equal to the last index in the INTEGER [] data field (intArray)
	    - returns FALSE otherwise
    */
    public boolean isFull ()
    {
	boolean full = false;
	if (this.back == this.intArray.length - 1)
	    full = true;
	return full;
    }


    // ======================================================================================================
    // display

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Given a CONSOLE type parameter value, and two INTEGER parameter value (xValue + yValue), prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index
	     referall and the INTEGER data field (back) referall are noted. The display is in the form of an array and it will be printed on the x and y co-ordinate given via parameter on the Console given via parameter.
    Input: Console type parameter value + two INTEGER parameter value
    Output: None - prints the STRAIGHTLINEARRAY implementation of a QUEUE's INTEGER information in such a way that the INTEGER data field (front) index referall and the INTEGER data field (back) referall are noted. The display is in
	    the form of an array.
    */
    public void display (Console c, int xValue, int yValue)
    {
	int index = 0;
	while (index < this.intArray.length)
	{
	    c.drawRect (xValue, yValue, 40, 40);
	    c.drawString (this.intArray [index] + "", xValue + 18, yValue + 24);
	    if (index == 0)
		c.drawString ("Front", xValue + 7, yValue + 12);
	    if (index == this.back)
		c.drawString ("Back", xValue + 7, yValue + 36);
	    xValue = xValue + 40;
	    index = index + 1;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // add

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data fields (back + counter), adds or rather changes the INTEGER value at the index represented by the INTEGER data field (back) into a value equivalent to the INTEGER data field (counter). In addition,
	     the INTEGER data field (back + counter) are increased by 1.
    Input: None
    Output: None - adds or rather changes the INTEGER value at the index represented by the INTEGER data field (back) into a value equivalent to the INTEGER data field (counter). In addition, the INTEGER data field (back + counter)
	    are increased by 1.
    */

    public void add ()
    {
	this.intArray [this.back] = this.counter;
	if (this.back < this.intArray.length - 1)
	{
	    this.counter++;
	    this.back++;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // remove

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: Based on the INTEGER data field (back), removes the FIRST INTEGER value in the INTEGER [] data field (intArray) from the REMOVESHIFTARRAY implementation of a QUEUE data set which would lie on index 0. This is achieved by
	     shifting ALL INTEGER values within the QUEUE back one index such that the FIRST INTEGER VALUE on index 0 is replaced by the SECOND INTEGER value on index 1 and so forth.
	     Note: The method performs nothing if the QUEUE is empty which it calls isEmpty to determine it (see Method isEmpty WITHIN class)
    Input: None
    Output: None -  removes the FIRST INTEGER value in the INTEGER [] data field (intArray) from the REMOVESHIFTARRAY implementation of a QUEUE data set which would lie on index 0. This is achieved by shifting ALL INTEGER values within
	    the QUEUE back one index such that the FIRST INTEGER VALUE on index 0 is replaced by the SECOND INTEGER value on index 1 and so forth.
	    Note: The method performs nothing if the QUEUE is empty which it calls isEmpty to determine it (see Method isEmpty WITHIN class)
    */

    public void remove ()
    {
	if (!this.isEmpty ())
	{
	    int count = 0;
	    while (count < this.back)
	    {
		this.intArray [count] = this.intArray [count + 1];
		count = count + 1;
	    }
	    this.back--;
	}
    }


    // ======================================================================================================

    // reset

    /*
    Author: Swethan Sivasegaran
    Date: January 12 2018
    Purpose: The INTEGER data field (back) is reset to 0 and the INTEGER data field (counter) is reset to 1. Although previous values in the INTEGER [] data field (intArray) are intact, the index INTEGER refrence exists at 0 meaning
	     it is an EMPTY QUEUE.
    Input: None
    Output: None - The INTEGER data field (back) is reset to 0 and the INTEGER data field (counter) is reset to 1
    */
    public void reset ()
    {
	this.back = 0;
	this.counter = 1;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS NODE
/*
Author: Swethan Sivasegaran
Date: January 13 2018
Purpose: To PROVIDE a sort of container class to store individual INTEGER data information in addition to keeping check on the data of ANOTHER NODE and its following NODES such that it can be used in a LINKED LIST. In addition, the
	 basic manipulation of the data or NODE tracking should be managed. The NODE pointer is defaulted to NULL.

DATA FIELDS

data (INT) - An INTEGER type data field that represents the CURRENT NODE's holding of INTEGER DATA information - Defaulted to 0.
next (NODE) - A NODE type data field that points to another NODE type Object for the purpose of using LINKED LISTS to STORE data

METHODS

Constructor (with ONE PARAMETER) - Given an INTEGER type parameter value (data), sets the INTEGER type data field (data) to its respective parameter value and the NODE type data field pointer (next) to NULL. Hence there is no
				   established link created in the Constructor.

Constructor (with NO PARAMETERS) - Given NO PARAMETER values, sets the INTEGER type data field (data) to 0 and the NODE type data field (next) to NULL by calling the Constructor (with ONE PARAMTER)
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Node
{
    //DATA FIELDS
    protected int data = 0;
    protected Node next;
    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Given an INTEGER type parameter value (data), sets the INTEGER type data field (data) to its respective parameter value and the NODE type data field pointer (next) to NULL. Hence there is no
	     established link created in the Constructor.
    Input: An INTEGER type parameter value
    Output: None - sets the INTEGER type data field (data) to its respective parameter value and the NODE type data field pointer (next) to NULL. Hence there is no established link created in the Constructor.
    */
    public Node (int data)
    {
	this.data = data;
	this.next = null;
    }


    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Given NO PARAMETER values, sets the INTEGER type data field (data) to 0 and the NODE type data field (next) to NULL by calling the Constructor (with ONE PARAMTER)
    Input: None
    Output: None - sets the INTEGER type data field (data) to 0 and the NODE type data field (next) to NULL by calling the Constructor (with ONE PARAMTER)
    */
    public Node ()
    {
	this (0);
    }
}
// -------------------------------------------------------------------------------------------------------
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS SINGLYLINKEDLIST --> inherited from CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: January 13 2018
Purpose: To demonstrate the full capability of a QUEUE in the form of a SINGLY LINKED LIST data structure with the FULL IMPLEMENTATION of the required methods from the CLASS QUEUE from which this class inherits from.

DATA FIELDS

counter (INT) - An INTEGER type data field that represents the value in the NODE that must be addded per turn (DEFAULT 1). This value increases by 1 each time the QUEUE increases. Hence, a QUEUE will hold a LINKED LIST of NODES with
		consecutive INTEGER values.
front (NODE) - A NODE type data field that represents the FIRST NODE or rather the root of the SINGLY LINKED LIST (DEFAULT NULL)
back (NODE) - A NODE type data field that represents the LAST NODE of the SINGLY LINKED LIST (DEFAULT NULL)

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the NODE type data fields (front + back) to NULL, thus creating an EMPTY SINGLY LINKED LIST initially.

display - Given a CONSOLE type parameter value and two INTEGER parameter values (xValue + yValue), prints the QUEUE's INTEGER values within the NODES of the Linked List such that the Front and Back are marked and shown
	  accordingly onto the x and y co-ordinate value of the console given via parameters.

isEmpty - Based on the NODE data field (front), returns a BOOLEAN value corresponding to whether the LINKED LIST is empty or not
	  - returns TRUE if the NODE data field (front) is equal to NULL
	  - returns FALSE otherwise

add - Based on the NODE data fields (front + back), creates a NEW INSTANCE of a NODE containing an INTEGER value equivalent to the CURRENT INTEGER data field (counter) and inserts the NEW NODE into the back of the SINGLY
      LINKED LIST. In addition, the INTEGER data field (counter) is increased by 1 at every call of this method.
      - In CASE 1, where there the FIRST NODE is inserted, both the NODE data fields (front + back) point to the FIRST NODE

remove - Based on the NODE type data field (front), deletes the FIRST NODE or rather the NODE that the NODE type data field (front) was pointing to with the help of the JVM Garbage Collector. Hence, the ORIGINAL FIRST NODE's
	 NODE type data field (next) pointer would become the FIRST NODE and the NODE type data field (front) will point to that.
	 Note: The Method will not perform anything if the SINGLY LINKED LIST is empty whihc it achieves with the call of the method isEmpty (see Method isEmpty WITHIN class)

reset - The INTEGER data field (counter) is reset to a value of 1 and both the NODE type data fields (front + back) are set to NULL. Hence, all previous NODE's containing INTEGER data information are deleted
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class SinglyLinkedList extends Queue
{
    //DATA FIELDS
    protected int counter = 1;
    protected Node front;
    protected Node back;
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Given NO PARAMETERS, sets the NODE type data fields (front + back) to NULL, thus creating an EMPTY SINGLY LINKED LIST initially.
    Input: None
    Output: None - sets the NODE type data fields (front + back) to NULL, thus creating an EMPTY SINGLY LINKED LIST initially.
    */
    public SinglyLinkedList ()
    {
	this.front = null;
	this.back = null;
    }


    // ======================================================================================================
    // display

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Given a CONSOLE type parameter value and two INTEGER parameter values (xValue + yValue), prints the QUEUE's INTEGER values within the NODES of the Linked List such that the Front and Back are marked and shown
	     accordingly onto the x and y co-ordinate value of the console given via parameters.
    Input: A CONSOLE type parameter value + two INTEGER parameter values
    Output: None - prints the QUEUE's INTEGER values within the NODES of the Linked List such that the Front and Back are marked and shown accordingly onto the x and y co-ordinate value of the console given via parameters.
    */

    public void display (Console c, int xValue, int yValue)
    {
	Node temp = this.front;
	int initial = xValue;
	while (temp != null)
	{
	    c.drawRect (xValue, yValue, 40, 40);
	    c.drawString (temp.data + "", xValue + 18, yValue + 24);
	    if (xValue == initial)
		c.drawString ("Front", xValue + 7, yValue + 12);
	    if (temp.next == null)
		c.drawString ("Back", xValue + 7, yValue + 36);
	    xValue = xValue + 40;
	    temp = temp.next;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // isEmpty

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Based on the NODE data field (front), returns a BOOLEAN value corresponding to whether the LINKED LIST is empty or not
	     - returns TRUE if the NODE data field (front) is equal to NULL
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value corresponding to whether the LINKED LIST is empty or not
	    - returns TRUE if the NODE data field (front) is equal to NULL
	    - returns FALSE otherwise
    */

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == null)
	    empty = true;
	return empty;
    }


    // ======================================================================================================

    // add

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Based on the NODE data fields (front + back), creates a NEW INSTANCE of a NODE containing an INTEGER value equivalent to the CURRENT INTEGER data field (counter) and inserts the NEW NODE into the back of the SINGLY
	     LINKED LIST. In addition, the INTEGER data field (counter) is increased by 1 at every call of this method.
	     - In CASE 1, where there the FIRST NODE is inserted, both the NODE data fields (front + back) point to the FIRST NODE
    Input: None
    Output: None - creates a NEW INSTANCE of a NODE containing an INTEGER value equivalent to the CURRENT INTEGER data field (counter) and inserts the NEW NODE into the back of the SINGLY LINKED LIST. In addition, the INTEGER
	    data field (counter) is increased by 1 at every call of this method.
	    - In CASE 1, where there the FIRST NODE is inserted, both the NODE data fields (front + back) point to the FIRST NODE
    */
    public void add ()
    {
	if (this.front == null)
	{
	    Node newNode = new Node (this.counter);
	    this.front = newNode;
	    this.back = newNode;
	}
	else
	{
	    this.back.next = new Node (this.counter);
	    this.back = this.back.next;
	}
	this.counter++;
    }


    // -------------------------------------------------------------------------------------------------------
    // remove

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: Based on the NODE type data field (front), deletes the FIRST NODE or rather the NODE that the NODE type data field (front) was pointing to with the help of the JVM Garbage Collector. Hence, the ORIGINAL FIRST NODE's
	     NODE type data field (next) pointer would become the FIRST NODE and the NODE type data field (front) will point to that.
	     Note: The Method will not perform anything if the SINGLY LINKED LIST is empty whihc it achieves with the call of the method isEmpty (see Method isEmpty WITHIN class)
    Input: None
    Output: None - deletes the FIRST NODE or rather the NODE that the NODE type data field (front) was pointing to with the help of the JVM Garbage Collector. Hence, the ORIGINAL FIRST NODE's NODE type data field (next) pointer
	    would become the FIRST NODE and the NODE type data field (front) will point to that.
	    Note: The Method will not perform anything if the SINGLY LINKED LIST is empty whihc it achieves with the call of the method isEmpty (see Method isEmpty WITHIN class)
    */
    public void remove ()
    {
	if (this.isEmpty () != true)
	{
	    this.front = this.front.next;
	    if (this.front == null)
		this.back = null;
	}
    }


    // ======================================================================================================

    // reset

    /*
    Author: Swethan Sivasegaran
    Date: January 13 2018
    Purpose: The INTEGER data field (counter) is reset to a value of 1 and both the NODE type data fields (front + back) are set to NULL. Hence, all previous NODE's containing INTEGER data information are deleted
    Input: None
    Output: None - The INTEGER data field (counter) is reset to a value of 1 and both the NODE type data fields (front + back) are set to NULL.
    */
    public void reset ()
    {
	this.front = null;
	this.back = null;
	this.counter = 1;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
