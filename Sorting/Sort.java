// The "Sort" class.
/*
Author: Swethan Sivasegaran
Date: November 26 2017
Purpose: To demonstrate an understanding of the manipulation and the situational efficiencies of different sorting algorithms with different
	 amounts of data sets with the use of INTEGER ARRAYS.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS SORT
/*
Author: Swethan Sivasegaran
Date: November 26 2017
Purpose: To demonstrate an understanding of different sorting algorithm and their situational efficiencies with different amounts
	 of data sets with the use of INTEGER ARRAYS.

DATA FIELDS - None

METHODS
main - To demonstrate the functionality of each method in SORTED METHODS to showcase the capability of different sorting algorithms
       and its respective efficiency to each other with large amounts of data.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class Sort
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: November 26 2017
    Purpose: To demonstrate the functionality of each method in SORTED METHODS to showcase the capability of different sorting algorithms
	     and its respective efficiency to each other with large amounts of data.
    Input: None - the inputs recieved from the user via Console to display each method in SORTED METHODS
    Output: None - the outputs from each method in SORTED METHODS
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (45, 100);
	SortMethods test = new SortMethods (100);
	c.println("ORIGINAL: " + test.toString());
	test.comb();
	c.print(test.toString());
	/*boolean valid = false;
	int repeat = 0;
	int sortType = 0;
	int count = 0;
	long start = 0;
	long stop = 0;
	long timeTaken = 0;
	String spaces = "";
	String result = "";
	SortMethods intList;
	while (repeat == 0)
	{
	    c.clear ();
	    intList = new SortMethods (0);
	    c.setTextColor (Color.red);
	    c.print ("Sorting Algorithm Testing Part 1");
	    c.setTextColor (Color.black);
	    c.print ("\n\nOriginal List: " + intList.toString ());
	    valid = false;
	    while (valid == false)
	    {
		c.setTextColor (Color.magenta);
		c.print ("\nSort Options\nEnter 1 for Bubble Sort \nEnter 2 for Selection Sort\nEnter 3 for Insertion Sort\nEnter 4 for Quick Sort\nEnter 5 for Merge Sort\nEnter 6 for Shaker Sort.");
		c.setTextColor (Color.blue);
		c.print ("\nPlease enter an INTEGER value according to the OPTIONS above to sort INTEGER list: ");
		sortType = c.readInt ();
		if (sortType == 1)
		{
		    intList.bubble ();
		    c.print ("\n\nBubble Sort: " + intList.toString ());
		    valid = true;
		}
		else if (sortType == 2)
		{
		    intList.selection ();
		    c.print ("\n\nSelection Sort: " + intList.toString ());
		    valid = true;
		}
		else if (sortType == 3)
		{
		    intList.insertion ();
		    c.print ("\n\nInsertion Sort: " + intList.toString ());
		    valid = true;
		}
		else if (sortType == 4)
		{
		    intList.quick ();
		    c.print ("\n\nQuick Sort: " + intList.toString ());
		    valid = true;
		}
		else if (sortType == 5)
		{
		    // intList.mergeSort();
		    c.print ("\n\nMerge Sort: " + intList.toString ());
		    valid = true;
		}
		else if (sortType == 6)
		{
		    intList.shaker ();
		    c.print ("\n\nShaker Sort: " + intList.toString ());
		    valid = true;
		}
	    }
	    c.setTextColor (Color.green);
	    c.print ("\n\nPlease enter a 0 (to restart program) or any other key to end program: ");
	    repeat = c.readInt ();
	}
	c.clear ();
	c.setTextColor (Color.red);
	c.print ("Sorting Algorithm Testing Part 2");
	c.setTextColor (Color.blue);
	spaces = "       ";
	c.print ("\n\nSize" + spaces + "Bubble" + spaces + "Selection" + spaces + "Insertion" + spaces + "Quick" + spaces + "Merge" + spaces + "Shaker");
	int i = 50;
	while (i < 51200)
	{
	    intList = new SortMethods (i);
	    result = result + i + spaces + "    ";
	    while (count < 6)
	    {
		if (count == 0)
		{
		    start = System.currentTimeMillis ();
		    intList.bubble ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;

		}
		if (count == 1)
		{
		    start = System.currentTimeMillis ();
		    intList.selection ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;
		}
		if (count == 2)
		{
		    start = System.currentTimeMillis ();
		    intList.insertion ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;
		}
		if (count == 3)
		{
		    start = System.currentTimeMillis ();
		    intList.quick ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;
		}
		if (count == 4)
		{
		    start = System.currentTimeMillis();
		    intList.mergeSort();
		    stop = System.currentTimeMillis();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;
		}
		if (count == 5)
		{
		    start = System.currentTimeMillis ();
		    intList.shaker ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    if (timeTaken > 10000)
			result = result + "N/A" + spaces;
		    else
			result = result + timeTaken + spaces;
		}
		count = count + 1;
	    }
	    count = 0;
	    c.print ("\n" + result);
	    result = "";
	    i = i * 2;
	}*/

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS SORTMETHODS
/*
Author: Swethan Sivasegaran
Date: November 26 2017
Purpose: To manipulate different sorting algorithems under the restrictions of INTEGER ARRAYS and their different situational efficiences
	 Sorting Algorithim used - BUBBLE/EXCHANGE, SELECTION, INSERTION, QUICKSORT, MERGESORT, SHAKER

DATA FIELDS
size (INT) - An INTEGER type data field that represents the size of the INTEGER [] (original + aClone)
original (INT []) - An INTEGER [] data field that uses the INTEGER type data field (size) to set up its INTEGER [] size and is used as a refrence INTEGER [] in order to keep its original content of RANDOM INTEGER elements
		    (from 0 to its INTEGER [] size) intact.
aClone (INT []) - An INTEGER [] data field that is an EXACT COPY of the INTEGER [] data field (original) and is used to be manipulated in various ascending order sorting algorithms while keeping a refrence to its
		  original set of INTEGER elements in the INTEGER [] data field (original).

METHODS
Constructor (with ONE PARAMETER) - Given an INTEGER type parameter value (size), editchecks for POSITIVE values and assigns the INTEGER type data field (size) to the given value. Based on the INTEGER type data field (size),
				   initializes the INTEGER [] type data field (original) to the given size and fills the INTEGER [] with random INTEGER values in the range 0 to INTEGER data field(size). In addition,
				   the constructor initializes the INTEGER [] type data field (aClone) which is an EXACT replica of the INTEGER [] type data field (original) by calling the RESET method which creates
				   a complete copy of the ORIGINAL INTEGER [] using the superclass OBJECT's method clone - see Method reset.
				   if INVALID parameters are given
				      --> size (INTEGER) data field defaulted to 0
				      --> original (INTEGER []) data field defaulted to an empty array
				      --> aClone(INTEGER []) data field defaulted to an empty array

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER type data field (size) to 0, the INTEGER [] type data field (original) to an empty array and the INTEGER [] type data field (aClone) to an empty array using
				   the Constructor (with ONE PARAMETER) in the SORTMETHODS CLASS - see Constructor (with ONE PARAMETER).

reset - Given NO PARAMETERS, creates a COMPLETE EXACT copy of the INTEGER [] type data field (original) using the superclass OBJECT's method clone and sets the true copy of the INTEGER [] type data field (original)
	to the INTEGER [] type data field (aClone).

toString - Given NO PARAMETERS, returns a STRING value that corresponds to a STRING representation of the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field
	   with each INTEGER element listed horizontally

sorted - Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field has its elements
	 sorted or not in ascending order.
	 - returns false if element are not sorted in ascending order
	 - returns true otherwise

bubble - Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	 ascending order via the BUBBLE/EXCHANGE method.

selection - Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original) sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	    ascending order via the SELECTION method of sorting.

insertion - Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	    ascending order via the INSERTION method of sorting.

quick -
mergeSort -

shaker - Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	 ascending order via the SHAKER method of sorting - a deviation from the BUBBLE/EXCHANGE SORT.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class SortMethods implements Cloneable
{
    //DATA FIELDS
    protected int[] original = null;
    protected int[] aClone = null;
    protected int size = 0;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: November 26 2017
    Purpose: Given an INTEGER type parameter value (size), editchecks for POSITIVE values and assigns the INTEGER type data field (size) to the given value. Based on the INTEGER type data field (size),
	     initializes the INTEGER [] type data field (original) to the given size and fills the INTEGER [] with random INTEGER values in the range 0 to INTEGER data field(size). In addition,
	     the constructor initializes the INTEGER [] type data field (aClone) which is an EXACT replica of the INTEGER [] type data field (original) by calling the RESET method which creates
	     a complete copy of the ORIGINAL INTEGER [] using the superclass OBJECT's method clone - see Method reset.
	     if INVALID parameters are given
		--> size (INTEGER) data field defaulted to 0
		--> original (INTEGER []) data field defaulted to an empty array
		--> aClone(INTEGER []) data field defaulted to an empty array
    Input: An INTEGER type parameter value (size)
    Output: None - sets the initial values for the INTEGER type data field (size) and the INTEGER ARRAY type data fields (original + aClone).
	    if INVALID parameters are given
		--> size (INTEGER) data field defaulted to 0
		--> original (INTEGER []) data field defaulted to an empty array
		--> aClone(INTEGER []) data field defaulted to an empty array
    */
    public SortMethods (int size)
    {
	if (size < 0)
	    this.size = 0;
	else
	    this.size = size;
	this.original = new int [this.size];
	for (int i = 0 ; i < this.size ; i++)
	{
	    this.original [i] = (int) ((Math.random () * this.size) + 1);
	}
	this.reset ();
    }


    // ======================================================================================================
    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: November 26 2017
    Purpose: Given NO PARAMETERS, sets the INTEGER type data field (size) to 0, the INTEGER [] type data field (original) to an empty array and the INTEGER [] type data field (aClone) to an empty array using
	     the Constructor (with ONE PARAMETER) in the SORTMETHODS CLASS - see Constructor (with ONE PARAMETER).
    Input: None
    Output: None - sets the INTEGER type data field (size) to 0, the INTEGER [] type data field (original) to an empty array and the INTEGER [] type data field (aClone) to an empty array.
    */
    public SortMethods ()
    {
	this (0);
    }


    // -------------------------------------------------------------------------------------------------------
    // reset

    /*
    Author: Swethan Sivasegaran
    Date: November 26 2017
    Purpose: Given NO PARAMETERS, creates a COMPLETE EXACT copy of the INTEGER [] type data field (original) using the superclass OBJECT's method clone and sets the true copy of the INTEGER [] type data field (original)
	     to the INTEGER [] type data field (aClone).
    Input: None
    Output: None - sets the INTEGER [] type data field (aClone) to an EXACT TRUE copy of the INTEGER [] type data field (original).
    */
    public void reset ()
    {
	this.aClone = (int[]) this.original.clone ();
    }


    // ======================================================================================================
    // toString

    /*
    Author: Swethan Sivasegaran
    Date: November 27 2017
    Purpose: Given NO PARAMETERS, returns a STRING value that corresponds to a STRING representation of the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field
	     with each INTEGER element listed horizontally
    Input: None
    Output: Returns a STRING value that corresponds to a STRING representation of the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field with each INTEGER element
	    listed horizontally.
    */
    public String toString ()
    {
	String list = "";
	for (int i = 0 ; i < this.size ; i++)
	{
	    list = list + this.aClone [i] + "|";
	}
	return list;
    }


    // -------------------------------------------------------------------------------------------------------
    // sorted

    /*
    Author: Swethan Sivasegaran
    Date: November 27 2017
    Purpose: Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field has its elements
	     sorted or not in ascending order.
	     - returns false if element are not sorted in ascending order
	     - returns true otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the INTEGER [] type data field (aClone) which is essentially a copy of the ORIGINAL INTEGER [] type data field has its elements
	    sorted or not in ascending order.
	    - returns false if element are not sorted in ascending order
	    - returns true otherwise
    */

    public boolean sorted ()
    {
	boolean sorted = true;
	for (int i = 1 ; i < this.size ; i++)
	{
	    if (this.aClone [i - 1] > this.aClone [i])
		sorted = false;
	}
	return sorted;
    }


    // ======================================================================================================
    // bubble

    /*
    Author: Swethan Sivasegaran
    Date: November 27 2017
    Purpose: Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	     ascending order via the BUBBLE/EXCHANGE method.
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the BUBBLE/EXCHANGE method of sorting.
    */
    public void bubble ()
    {
	int temp = 0;
	for (int a = 0 ; a < this.size ; a++)
	{
	    for (int i = 0 ; i < this.size - 1 ; i++)
	    {
		if (this.aClone [i] > this.aClone [i + 1])
		{
		    temp = this.aClone [i];
		    this.aClone [i] = this.aClone [i + 1];
		    this.aClone [i + 1] = temp;
		}
	    }
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // selection

    /*
    Author: Swethan Sivasegaran
    Date: November 27 2017
    Purpose: Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original) sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	     ascending order via the SELECTION method of sorting.
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the SELECTION method of sorting.
    */
    public void selection ()
    {
	int index = 0;
	int temp = 0;
	int max = 0;
	int maxIndex = 0;
	index = this.size;
	for (int a = 0 ; a < this.size ; a++)
	{
	    max = this.aClone [0] - 1;
	    for (int i = 0 ; i < index ; i++)
	    {
		if (this.aClone [i] > max)
		{
		    max = this.aClone [i];
		    maxIndex = i;
		}
	    }
	    temp = this.aClone [index - 1];
	    this.aClone [index - 1] = max;
	    this.aClone [maxIndex] = temp;
	    index = index - 1;
	    max = 0;
	}
    }


    // ======================================================================================================
    // insertion

    /*
    Author: Swethan Sivasegaran
    Date: November 28 2017
    Purpose: Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	     ascending order via the INSERTION method of sorting.
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the INSERTION method of sorting.
    */

    public void insertion ()
    {
	int temp = 0;
	int index = 0;
	for (int i = 0 ; i < this.aClone.length - 1 ; i++)
	{
	    index = i;
	    while (this.aClone [index + 1] < this.aClone [index] && index >= 0)
	    {
		temp = this.aClone [index];
		this.aClone [index] = this.aClone [index + 1];
		this.aClone [index + 1] = temp;
		if (index != 0)
		    index = index - 1;
	    }
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // quickSort

    /*
    Author: Swethan Sivasegaran
    Date: November 28 2017
    Purpose: Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	     ascending order via the QUICKSORT method of sorting.
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the QUICKSORT method of sorting.
    */
    public void quickSort (int startIndex, int endIndex)
    {
	int temp = 0;
	int pivot = this.aClone [startIndex];
	int rightIndex = startIndex;
	int leftIndex = endIndex;

	while (rightIndex <= leftIndex)
	{
	    while (this.aClone [leftIndex] > pivot)
		leftIndex--;

	    while (this.aClone [rightIndex] < pivot)
		rightIndex++;

	    if (rightIndex <= leftIndex)
	    {
		temp = this.aClone [rightIndex];
		this.aClone [rightIndex] = this.aClone [leftIndex];
		this.aClone [leftIndex] = temp;
		rightIndex++;
		leftIndex--;
	    }
	}

	if (startIndex < leftIndex)
	{
	    this.quickSort (startIndex, leftIndex);
	}
	if (rightIndex < endIndex)
	{
	    this.quickSort (rightIndex, endIndex);
	}
	/*
	    ORIGINAL IDEA
	    - pivot starts at firstindex and loop leftIndex ++ UNTIL  i get an index that is greater than pivot. then i switch places with the element and pivot
	    - now pivot is in the position of the greatest element and greatest element is in the position of pivot index.
	    - loop rightindex -- until I get an index that is less than pivot and switchplaces with the element in the
	    [do this command ONLY if leftIndex < rightIndex)
	*/
    }


    // ======================================================================================================
    // quick

    /*
    Author: Swethan Sivasegaran
    Date: November 28 2017
    Purpose:
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the QUICKSORT method of sorting.
    */

    public void quick ()
    {
	this.quickSort (0, this.size - 1);
    }


    //-------------------------------------------------------------------------------------------------------
    // comb

    /*
    Author: Swethan Sivasegaran
    Date: November 28 2017
    Purpose:
    Input:
    Output:
    */

    public void comb ()
    {
	int gap = 0;
	int temp = 0;
	int index = 0;
	gap = this.size - 1;
	while (gap >= 1)
	{
	    while (index + gap <= this.size - 1)
	    {
		if (this.aClone [index] > this.aClone [index + gap])
		{
		    temp = this.aClone [index];
		    this.aClone [index] = this.aClone [index + gap];
		    this.aClone [index + gap] = temp;
		}
		index = index + 1;
	    }
	    index = 0;
	    gap = (int)(gap / 1.3);
	}
    }


    // ======================================================================================================
    // shaker

    /*
    Author: Swethan Sivasegaran
    Date: November 28 2017
    Purpose: Based on the INTEGER [] type data field (aClone) which is essentially a copy of the INTEGER [] type data field (original), sorts the INTEGER elements within the INTEGER [] type data field (aClone) in
	     ascending order via the SHAKER method of sorting - a deviation from the BUBBLE/EXCHANGE SORT.
    Input: None
    Output: None - changes the INTEGER elements within the INTEGER [] type data field (aClone) such that the INTEGER elements are arranged in ascending order using the SHAKER method of sorting - a deviation from the
	    BUBBLE/EXCHANGE SORT.
    */
    public void shaker ()
    {
	int temp = 0;
	for (int a = 0 ; a < this.size / 2 ; a++)
	{
	    for (int i = 0 ; i < this.size - 1 ; i++)
	    {
		if (this.aClone [i] > this.aClone [i + 1])
		{
		    temp = this.aClone [i];
		    this.aClone [i] = this.aClone [i + 1];
		    this.aClone [i + 1] = temp;
		}
		if (this.aClone [this.size - i - 1] < this.aClone [this.size - i - 2])
		{
		    temp = this.aClone [this.size - i - 1];
		    this.aClone [this.size - i - 1] = this.aClone [this.size - i - 2];
		    this.aClone [this.size - i - 2] = temp;
		}
	    }
	}
    }


    // ======================================================================================================
}


//check for empty arrays
//fix dates
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
