// The "SortedInt" class.
/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: To demonstrate the capibility of using Arrays through BASIC integer array tampering.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS SORTEDINT
/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: To demonstrate the functionality via Console of the SORTEDINTGROUP CLASS

DATA FIELDS - None

METHODS

main - To test each method of SORTEDINTGROUP class functionality and its potential typechecking via Console.

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class SortedInt
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: To test each method of SORTEDINTGROUP class functionality and its potential typechecking via Console.
    Input: None
    Output: None - the outputs of each Method in SORTEDINTGROUP CLASS via Console to the user
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (40, 80);

	//Initialization
	int repeat = 0;
	int[] firstArray = null;
	int[] secondArray = null;
	SortedIntGroup intFirstList;
	SortedIntGroup intSecondList;

	//Process
	while (repeat == 0)
	{
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.print ("======SORTED INT GROUP TESTING======\n\n");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter an INTEGER size value for the FIRST integer array: ");
	    intFirstList = new SortedIntGroup (c.readInt ());
	    c.setTextColor (Color.black);
	    c.println ("The FIRST integer array: " + intFirstList.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter an INTEGER size value for the SECOND integer array: ");
	    intSecondList = new SortedIntGroup (c.readInt ());
	    c.setTextColor (Color.black);
	    c.println ("The SECOND integer array: " + intSecondList.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nChanging the Integer Array");
	    c.setTextColor (Color.black);
	    c.print ("\nPlease enter an INTEGER size value for the FIRST integer array: ");
	    firstArray = new int [c.readInt ()];
	    c.println ("\n");
	    c.setTextColor (Color.blue);
	    for (int i = 0 ; i < firstArray.length ; i++)
	    {
		c.print ("Please enter an INTEGER value to add into the array: ");
		firstArray [i] = c.readInt ();
	    }
	    intFirstList = new SortedIntGroup (firstArray);
	    c.setTextColor (Color.black);
	    c.println ("\nThe FIRST integer array: " + intFirstList.toString ());
	    c.print ("\nPlease enter an INTEGER size value for the SECOND integer array: ");
	    secondArray = new int [c.readInt ()];
	    c.println ("\n");
	    c.setTextColor (Color.blue);
	    for (int i = 0 ; i < secondArray.length ; i++)
	    {
		c.print ("Please enter an INTEGER value to add into the array: ");
		secondArray [i] = c.readInt ();
	    }
	    c.setTextColor (Color.black);
	    intSecondList = new SortedIntGroup (secondArray);
	    c.println ("\nThe SECOND integer array: " + intSecondList.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\nRemoving Duplicate Values");
	    c.setTextColor (Color.blue);
	    intFirstList.dropDups ();
	    intSecondList.dropDups ();
	    c.println ("The FIRST integer array (removed duplicates): " + intFirstList.toString ());
	    c.println ("The SECOND integer array (removed duplicates): " + intSecondList.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nMERGING ARRAYS");
	    c.setTextColor (Color.blue);
	    c.println ("The FIRST integer array: " + intFirstList.toString ());
	    c.println ("The SECOND integer array: " + intSecondList.toString ());
	    c.println ("The MERGED integer array: " + intFirstList.merge (intSecondList).toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nFind Longest Run");
	    c.setTextColor (Color.blue);
	    c.println ("First Integer Array (longestRun): " + intFirstList.longestRun ().length + " elements after the index " + intFirstList.longestRun ().start);
	    c.println ("Second Integer Array (longestRun): " + intSecondList.longestRun ().length + " elements after the index " + intSecondList.longestRun ().start);
	    c.println ("Merged Integer Array (longestRun): " + intFirstList.merge (intSecondList).longestRun ().length + " elements after the index " + intFirstList.merge (intSecondList).longestRun ().start);
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter a 0 (to restart program) or any other key (to end program): ");
	    repeat = c.readInt ();
	}

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS SORTEDINTGROUP

/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: To showcase the ability to manipulate an array (INTEGER type in this case) through many actions performed by
	 its methods

DATA FIELDS

intArray (INT ARRAY) - an INTEGER type Array that contains all the INTEGER VALUES as ELEMENTES to be manipulated via methods
size (INT)- - an INTEGER type variable that represents the size of the INTEGER type Array or rather the number of elements

METHODS

SortedIntGroup (Constructor with One INTEGER parameter) -  Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the given size and fills each
							   element to consecutive values starting from 1 (1,2,3,4,...) until the last index. Sets the INTEGER size data element to
							   the the INTEGER ARRAY type data element length.

SortedIntGroup (Constructor with One INTEGER ARRAY parameter) -  Given an INTEGER ARRAY type parameter value, sets the INTEGER ARRAY type data element to the INTEGER values in each
								 element of the given INTEGER ARRAY type parameter value ONLY if the given INTEGER ARRAY type parameter value is sorted
								 - sets the INTEGER ARRAY type data element to an EMPTY ARRAY ONLY if the given INTEGER ARRAY type parameter
								   value is not sorted
								 - sets the INTEGER type size data element to the INTEGER ARRAY type data element length

SortedIntGroup (Constructor without parameters) - Given NO PARAMETERS, sets the INTEGER ARRAY type data element to an EMPTY ARRAY and sets the INTEGER TYPE size data element to 0

toString -  Based on the INTEGER ARRAY type data element, returns a STRING type representation of all the elements in the INTEGER ARRAY
	    + the respective INTEGER type size data element with it.

sorted -  Based on the INTEGER ARRAY type data element, returns a BOOLEAN type variable based on if the INTEGER ARRAY type
	  data element is sorted or not (returns TRUE if sorted, otherwise returns FALSE if not sorted)

dropDups -  Based on the INTEGER ARRAY type data element, removes ALL DUPLICATE values in a SORTED INTEGER ARRAY type data
	    element and sets the INTEGER ARRAY type data element to its new respective change

merge -  Given a SORTEDINTGROUP object, provided that the two INTEGER ARRAY type data elements are SORTED, combines the ELEMENTS
	 of the current INTEGER ARRAY type data element with the INTEGER ARRAY type data element of the given SORTEDINTGROUP object
	 in ASCENDING order into a NEW SORTEDINTGROUP object containing a SORTED INTEGER ARRAY type data element with elements of
	 both INTEGER ARRAY type data elements.
	 - initializes an EMPTY INTEGER ARRAY type data element of the NEW SORTEDINTGROUP object if either INTEGER ARRAY type data elements
	   are not sorted

longestRun - Based on the INTEGER ARRAY type data element, returns a RUN type OBJECT containing an INTEGER type data elements
	     (START and LENGTH) which will be altered respectively to the longest CONSECUTIVE continuation of INTEGER values seperated by
	     a value of 1 ( Ex. 3, 4, 5...). The INTEGER type data element START corresponds to the INDEX of the element in which the
	     CONSECUTIVE continuationn starts and the INTEGER type data element LENGTH corresponds to the length (# of elements) in which the
	     RUN goes on for
	     - returns 0 for both INTEGER type data elements (START and LENGTH) if no CONSECUTIVE RUN is found

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class SortedIntGroup
{

    // DATA FIELDS
    protected int[] intArray = null;
    protected int size = 0;

    // SortedIntGroup(Constructor with one INTEGER parameter)

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the given size and fills each
	     element to consecutive values starting from 1 (1,2,3,4,...) until the last index. Sets the INTEGER size data element to
	     the the INTEGER ARRAY type data element length.
    Input: An INTEGER size parameter value
    Output: None - sets the INTEGER type size data element to the given INTEGER type size value and fills the INTEGER ARRAY type data
	    element to consecutive values from 1 (1,2,3,4,...) until the last index.
    */
    public SortedIntGroup (int size)
    {
	//Initialization
	int count = 0;

	//EditChecking
	if (size >= 0)
	    this.intArray = new int [size];
	else
	    this.intArray = new int [0];
	this.size = this.intArray.length;
	
	//Process
	while (count < this.intArray.length)
	{
	    this.intArray [count] = count + 1;
	    count = count + 1;
	}
    }
    // ======================================================================================================
    // SortedIntGroup (Constructor with one INTEGER ARRAY parameter)

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: Given an INTEGER ARRAY type parameter value, sets the INTEGER ARRAY type data element to the INTEGER values in each
	     element of the given INTEGER ARRAY type parameter value ONLY if the given INTEGER ARRAY type parameter value is sorted
	     - sets the INTEGER ARRAY type data element to an EMPTY ARRAY ONLY if the given INTEGER ARRAY type parameter
	       value is not sorted
	     - sets the INTEGER type size data element to the INTEGER ARRAY type data element length
    Input: An INTEGER ARRAY type parameter value
    Output: None - sets the INTEGER ARRAY type data element to the elements of the INTEGER ARRAY type parameter value ONLY if the array is
	    sorted. Otherwise, INTEGER ARRAY type data element is set as an EMPTY ARRAY. INTEGER type size data element is set the INTEGER ARRAY
	    type data element length.
    */

    public SortedIntGroup (int[] newArray)
    {
	//Initialization
	int count = 0;
	this.intArray = newArray;
	this.size = this.intArray.length;
	
	//EditChecking
	if (this.sorted () == false)
	    this.intArray = new int [0];
    }
    // -------------------------------------------------------------------------------------------------------
    // SortedIntGroup(Constructor with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: Given NO PARAMETERS, sets the INTEGER ARRAY type data element to an EMPTY ARRAY and sets the INTEGER TYPE size data element to 0
    Input: None
    Output: None - sets initial DATA ELEMENTS(intArray and size) to an EMPTY ARRAY and 0 respectively.
    */

    public SortedIntGroup ()
    {
	this (0);
    }
    // ======================================================================================================
    // toString

    /*
    Author: Swethan Sivasegaran
    Date: October 10 2017
    Purpose: Based on the INTEGER ARRAY type data element, returns a STRING type representation of all the elements in the INTEGER ARRAY
	     + the respective INTEGER type size data element with it.
    Input: None - based on the INTEGER ARRAY type data element
    Output: A STRING type representation of the elements in the INTEGER ARRAY type data element + the INTEGER type size respective to the
	    integer array.
    */
    public String toString ()
    {
	//Initialization
	int count = 0;
	String list = "";

	//Process
	while (count < this.intArray.length)
	{
	    if (count == (this.intArray.length - 1))
		list = list + this.intArray [count] + " (" + this.intArray.length + ")";
	    else
	    {
		list = list + this.intArray [count] + ", ";
	    }
	    count = count + 1;
	}
	return list;
    }
    // -------------------------------------------------------------------------------------------------------
    // sorted

    /*
    Author: Swethan Sivasegaran
    Date: October 10 2017
    Purpose: Based on the INTEGER ARRAY type data element, returns a BOOLEAN type variable based on if the INTEGER ARRAY type
	     data element is sorted or not (returns TRUE if sorted, otherwise returns FALSE if not sorted)
    Input: None - based on INTEGER ARRAY type data element
    Output: A BOOLEAN type variable corresponding to if the INTEGER ARRAY type data element is sorted or not
	    - returns true if INTEGER ARRAY type data element is sorted
	    - returns false if INTEGER ARRAY type data element is not sorted
    */
    private boolean sorted ()
    {
	//Initialization
	int count = 0;
	boolean sorted = true;

	//Process
	while (count < this.intArray.length - 1 && sorted == true)
	{
	    if (this.intArray [count] <= this.intArray [count + 1])
		sorted = true;
	    else
		sorted = false;
	    count = count + 1;
	}
	return sorted;
    }
    // ======================================================================================================
    // dropDups

    /*
    Author: Swethan Sivasegaran
    Date: October 11 2017
    Purpose: Based on the INTEGER ARRAY type data element, removes ALL DUPLICATE values in a SORTED INTEGER ARRAY type data
	     element and sets the INTEGER ARRAY type data element to its new respective change
    Input: None - based on INTEGER ARRAY type data element
    Output: None - changes the INTEGER ARRAY type data element to a NEW SORTED INTEGER ARRAY with NO DUPLICATE element values
    */
    public void dropDups ()
    {
	//Initialization
	int sizeCount = 0;
	int index = 0;
	int [] newArray = null;

	//Process
	newArray = new int [this.size];
	for (int i = 0 ; i < this.intArray.length - 1 ; i++)
	{
	    for (int a = i + 1 ; a < this.intArray.length ; a++)
	    {
		if (this.intArray [i] == this.intArray [a])
		{
		    sizeCount = sizeCount + 1;
		}
	    }
	    if (sizeCount > 0)
	    {
		newArray = new int [this.size - sizeCount];
		for (int c = 0 ; c < this.intArray.length ; c++)
		{
		    if (c == i)
		    {
			newArray [index] = this.intArray [i];
			index = index + 1;
		    }
		    else if (this.intArray [c] != this.intArray [i])
		    {
			newArray [index] = this.intArray [c];
			index = index + 1;
		    }
		}
		this.size = newArray.length;
		this.intArray = newArray;
	    }
	    index = 0;
	    sizeCount = 0;
	}
    }
    // -------------------------------------------------------------------------------------------------------
    // merge

    /*
    Author: Swethan Sivasegaran
    Date: October 11 2017
    Purpose: Given a SORTEDINTGROUP object, provided that the two INTEGER ARRAY type data elements are SORTED, combines the ELEMENTS
	     of the current INTEGER ARRAY type data element with the INTEGER ARRAY type data element of the given SORTEDINTGROUP object
	     in ASCENDING order into a NEW SORTEDINTGROUP object containing a SORTED INTEGER ARRAY type data element with elements of
	     both INTEGER ARRAY type data elements.
	     - initializes an EMPTY INTEGER ARRAY type data element of the NEW SORTEDINTGROUP object if either INTEGER ARRAY type data elements
	       are not sorted
    Input: A SORTEDINTGROUP object
    Output: A NEW SORTEDINTGROUP object containing the data elements of the current INTEGER ARRAY type data element and the GIVEN SORTEDINTGROUP
	    object INTEGER ARRAY type data element, provided that the two INTEGER ARRAY type data elements are sorted
	    - sets the NEW SORTEDINTGROUP object INTEGER ARRAY type data element to an EMPTY ARRAY if either of the two INTEGER ARRAY type data elements
	      are not sorted
    */
    public SortedIntGroup merge (SortedIntGroup secondList)
    {
	//Initialization
	int firstCount = 0;
	int secondCount = 0;
	int count = 0;
	boolean finish = false;
	SortedIntGroup newList = null;

	//Process
	if (this.sorted () == true && secondList.sorted () == true)
	{
	    newList = new SortedIntGroup (this.intArray.length + secondList.intArray.length);
	    while (count < newList.intArray.length)
	    {
		if (firstCount <= this.intArray.length - 1 && secondCount <= secondList.intArray.length - 1)
		{
		    if (this.intArray [firstCount] <= secondList.intArray [secondCount])
		    {
			newList.intArray [count] = this.intArray [firstCount];
			firstCount = firstCount + 1;
		    }
		    else if (this.intArray [firstCount] > secondList.intArray [secondCount])
		    {
			newList.intArray [count] = secondList.intArray [secondCount];
			secondCount = secondCount + 1;
		    }
		}
		else if (firstCount <= this.intArray.length - 1)
		{
		    newList.intArray [count] = this.intArray [firstCount];
		    firstCount = firstCount + 1;
		}
		else if (secondCount <= secondList.intArray.length - 1)
		{
		    newList.intArray [count] = secondList.intArray [secondCount];
		    secondCount = secondCount + 1;
		}
		count = count + 1;
	    }
	}
	else
	    newList = new SortedIntGroup ();
	return newList;
    }
    // ======================================================================================================
    // longestRun

    /*
    Author: Swethan Sivasegaran
    Date: October 11 2017
    Purpose: Based on the INTEGER ARRAY type data element, returns a RUN type OBJECT containing an INTEGER type data elements
	     (START and LENGTH) which will be altered respectively to the longest CONSECUTIVE continuation of INTEGER values seperated by
	     a value of 1 ( Ex. 3, 4, 5...). The INTEGER type data element START corresponds to the INDEX of the element in which the
	     CONSECUTIVE continuationn starts and the INTEGER type data element LENGTH corresponds to the length (# of elements) in which the
	     RUN goes on for
	     - returns 0 for both INTEGER type data elements (START and LENGTH) if no CONSECUTIVE RUN is found
    Input: None - based on the INTEGER ARRAY type data elements
    Output: returns a RUN type OBJECT containing the INTEGER type data elements START and LENGTH which corresponds to the INDEX in which the LONGEST CONSECUTIVE
	    RUN takes place (each element in the run differs by 1) and the # of ELEMENTS in the continuation of INTEGER values respectively
	    - default values for INTEGER type data elements of RUN type object (START and LENGTH) if no RUN is found
    */
    public Run longestRun ()
    {
	//Initialization
	int start = 0;
	int length = 0;
	Run longestRun = new Run ();

	//Process
	for (int i = 0 ; i < this.intArray.length - 1 ; i++)
	{
	    while (i < this.intArray.length - 1 && this.intArray [i + 1] - this.intArray [i] == 1)
	    {
		length = length + 1;
		i = i + 1;
	    }
	    i = i - length;
	    if (length >= longestRun.length)
	    {
		longestRun.length = length + 1;
		longestRun.start = i;
	    }
	    length = 0;
	}
	return longestRun;
    }
    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS Run
/*
Author: Swethan Sivasegaran
Date: October 11 2017
Purpose: To serve as a CONTAINER CLASS for the longestRun method in SORTEDINTGROUP CLASS to extract two values from the object
	 returned (START and LENGTH) corresponding to the INDEX and LENGTH of the LONGEST CONSECUTIVE RUN in an INTEGER ARRAY type
	 data element of SORTEDINTGROUP CLASS.

DATA FIELDS

start (INT) - an INTEGER type data element that is PUBLIC to the program that represents the INDEX of the LONGEST CONSECUTIVE RUN
length (INT) - an INTEGER type data element that is PUBLIC to the program that represents the length of the LONGEST CONSECUTIVE RUN
	       meaning the number of ELEMENTS after the given START INDEX (inclusive).

METHODS - None
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class Run
{
    //Container Values
    public int start = 0;
    public int length = 0;
}
// ======================================================================================================
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
//testing
//dont use length - use size
