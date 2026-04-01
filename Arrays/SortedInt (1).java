// The "SortedInt" class.
/*
Author: Swethan Sivasegaran
Date: September 30 2017
Purpose: To demonstrate the ability to use composition of classes under the aspect of the game Scrabble
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS SCRABBLE
/*
Author: Swethan Sivasegaran
Date: September 30 2017
Purpose: To create a mini Scrabble demonstration using the concept of composition of classes (Tile + ScrabbleHand)

DATA FIELDS - none

METHODS

main - To test in a re-executable loop the functionality of all the methods in Tile and ScrabbleHand class
       through a mini ScrabbleHand demonstration
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class SortedInt
{
    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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
// CLASS SCRABBLE
/*
Author: Swethan Sivasegaran
Date: September 30 2017
Purpose: To create a mini Scrabble demonstration using the concept of composition of classes (Tile + ScrabbleHand)

DATA FIELDS - none

METHODS

main - To test in a re-executable loop the functionality of all the methods in Tile and ScrabbleHand class
       through a mini ScrabbleHand demonstration
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class SortedIntGroup
{
    protected int[] intArray;
    protected int size = 0;
    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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

    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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
	this.size = this.intArray.length;
    }


    // -------------------------------------------------------------------------------------------------------


    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
    */

    public SortedIntGroup ()
    {
	this (0);
    }


    // ======================================================================================================


    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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


    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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

    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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


    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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

    // ScrabbleHand(Constructor with Parameters)

    /*
    Author: Swethan Sivasegaran
    Date: October 1 2017
    Purpose: Given 5 CHAR type parameter letter values, sets 5 TILE type data fields to each of the 5 CHAR type letter parameter
	     values and editchecks for valid values for each - see TILE class constructor method with parameter values for return
	     values in its editchecking
    Input: 5 CHAR type letter parameter values
    Output: None
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
// CLASS SCRABBLE
/*
Author: Swethan Sivasegaran
Date: September 30 2017
Purpose: To create a mini Scrabble demonstration using the concept of composition of classes (Tile + ScrabbleHand)

DATA FIELDS - none

METHODS

main - To test in a re-executable loop the functionality of all the methods in Tile and ScrabbleHand class
       through a mini ScrabbleHand demonstration
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
