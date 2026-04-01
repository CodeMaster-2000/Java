// The "SortedInt" class.
/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: 
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS SORTEDINT

/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: 

DATA FIELDS

Console - 

METHODS

main - 

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class SortedInt
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: 
    Input: 
    Output: 
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	int[] array = {2, 3, 3, 3, 8, 8, 9, 10, 12, 12};
	int[] array1 = {1, 4, 7, 9, 10, 12, 24};
	int[] array2 = {2, 4, 6, 9};
	SortedIntGroup intGroup = new SortedIntGroup (array);
	SortedIntGroup intGroup1 = new SortedIntGroup (array1);
	SortedIntGroup intGroup2 = new SortedIntGroup (array2);
	intGroup.dropDups ();
	c.println (intGroup.toString ());
	c.println (intGroup1.toString ());
	c.println (intGroup2.toString ());
	c.println (intGroup2.merge (intGroup1).toString ());

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS SORTEDINTGROUP

/*
Author: Swethan Sivasegaran
Date: October 9 2017
Purpose: 

DATA FIELDS 

intArray - 
size - 

METHODS

SortedIntGroup (Constructor with One INTEGER parameter) - 
SortedIntGroup (Constructor with One INTEGER ARRAY parameter) - 
SortedIntGroup (Constructor without parameters) - 
toString
sorted
merge
longestRun

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class SortedIntGroup
{
    protected int[] intArray;
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
	int count = 0;
	if (size >= 0)
	    this.intArray = new int [size];
	else
	    this.intArray = new int [0];
	while (count < this.intArray.length)
	{
	    this.intArray [count] = count + 1;
	    count = count + 1;
	}
	this.size = this.intArray.length;
    }

    // ======================================================================================================
    // SortedIntGroup (Constructor with one INTEGER ARRAY parameter)

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: Given an INTEGER ARRAY type parameter value, sets the INTEGER ARRAY type data element to the INTEGER values in each
	     element of the given INTEGER ARRAY type parameter value ONLY if the given INTEGER ARRAY type parameter value is sorted
	     - returns the INTEGER ARRAY type data element to an empty array or null ONLY if the given INTEGER ARRAY type parameter 
	       value is not sorted
	     - sets the INTEGER type size data element to the INTEGER ARRAY type data element length
    Input: An INTEGER ARRAY type parameter value
    Output: None - sets the INTEGER ARRAY type data element to the INTEGER ARRAY 
    */

    public SortedIntGroup (int[] newArray)
    {
	int count = 0;
	this.intArray = new int [newArray.length];
	while (count < this.intArray.length)
	{
	    this.intArray [count] = newArray [count];
	    count = count + 1;
	}
	if (this.sorted () == false)
	    this.intArray = new int [0];
	//if it is sorted
	this.size = this.intArray.length;
    }


    // -------------------------------------------------------------------------------------------------------
    // SortedIntGroup (Constructor without parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 9 2017
    Purpose: 
    Input:
    Output: 
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
    Purpose: 
    Input: 
    Output: 
    */
    public String toString ()
    {
	int count = 0;
	String list = "";
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
    Purpose: 
    Input: 
    Output: 
    */
    private boolean sorted ()
    {
	//Array should be set as null?
	boolean sorted = true;
	int count = 0;
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
    Purpose: 
    Input: 
    Output:
    */
    public void dropDups ()
    {
	int count = 0;
	int count2 = 0;
	int[] newArray = new int [this.size];
	for (int i = 0 ; i < this.intArray.length - 1 ; i++)
	{
	    for (int a = i + 1 ; a < this.intArray.length ; a++)
	    {
		if (this.intArray [i] == this.intArray [a])
		{
		    count = count + 1;
		}
	    }
	    newArray = new int [this.size - count];
	    if (count > 0)
	    {
		for (int c = 0 ; c < this.intArray.length ; c++)
		{
		    if (c == i)
		    {
			newArray [count2] = this.intArray [i];
			count2 = count2 + 1;
		    }
		    else if (this.intArray [c] != this.intArray [i])
		    {
			newArray [count2] = this.intArray [c];
			count2 = count2 + 1;
		    }
		}
		this.size = newArray.length;
		this.intArray = newArray;
	    }
	    count2 = 0;
	    count = 0;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // merge

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: 
    Input: 
    Output:
    */
    public SortedIntGroup merge (SortedIntGroup secondList)
    {
	int firstCount = 0;
	int secondCount = 0;
	int count = 0;
	boolean finish = false;
	SortedIntGroup newList;
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
	    // once an array is finished if it is lower than the rest it continues
	}
	else
	    newList = new SortedIntGroup ();
	return newList;
    }


    // ======================================================================================================
    // longestRun

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: 
    Input: 
    Output:
    */
    public Run longestRun ()
    {
	int start = 0;
	int length = 0;
	Run longestRun = new Run ();
	for (int i = 0 ; i < this.intArray.length - 1 ; i++)
	{
	    while (i < this.intArray.length - 1 && this.intArray [i + 1] - this.intArray [i] == 1)
	    {
		length = length + 1;
		i = i + 1;
	    }
	    i = i - length;
	    if (length > longestRun.length)
	    {
		longestRun.length = length + 1;
		// include the number itself?
		longestRun.start = i;
	    }
	    length = 0;
	}
	return longestRun;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS RUN
/*
Author: Swethan Sivasegaran
Date: October 12 2017
Purpose: 

DATA FIELDS

start
length

METHODS - None

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class Run
{
    public int start = 0;
    public int length = 0;
}
// ======================================================================================================
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
//checking for sorted and exceptions
//polishing (efficiency and naming)
//comments
