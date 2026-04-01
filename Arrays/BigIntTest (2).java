// The "BigIntTest" class.
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
public class BigIntTest
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
	BigPositiveInt integer = new BigPositiveInt (2,4);
	c.println (integer.add(-5).toString ());


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
class BigPositiveInt
{
    protected int size = 0;
    protected int[] intArray;
    protected char sign = ' ';
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
    public BigPositiveInt (int size, int digit)
    {
	int count = 0;
	this.intArray = new int [size];
	while (count < size)
	{
	    this.intArray [count] = digit;
	    count = count + 1;
	}
	this.size = size;
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
    public BigPositiveInt (int size)
    {
	this (size, 0);
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
    public void get ()
    {
	String userInt = "";
	boolean digit = false;
	int count = 0;
	BigIntTest.c.print ("Please enter a POSITIVE INTEGER value of any size: ");
	userInt = BigIntTest.c.readString ();
	while (digit == false)
	{
	    for (int i = 0 ; i < userInt.length () ; i++)
	    {
		if (userInt.charAt (i) >= '0' && userInt.charAt (i) <= '9')
		    digit = true;
		else
		{
		    digit = false;
		    BigIntTest.c.println ("You have enter a NON INTEGER character.");
		    BigIntTest.c.println ("Please re - enter a POSITIVE INTEGER value of any size: ");
		    userInt = BigIntTest.c.readString ();
		    i = -1;
		}
	    }

	}
	this.intArray = new int [userInt.length ()];
	this.size = userInt.length ();
	for (int i = this.size - 1 ; i >= 0 ; i--)
	{
	    this.intArray [count] = userInt.charAt (i) - '0';
	    count = count + 1;
	}
	this.removeLeadingZeros ();
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
    public void removeLeadingZeros ()
    {
	while (this.intArray [this.size - 1] == 0 && this.size > 1)
	{
	    this.size = this.size - 1;
	}
	int[] newArray = new int [this.size];
	for (int i = 0 ; i < newArray.length ; i++)
	    newArray [i] = this.intArray [i];
	this.intArray = newArray;
	this.size = newArray.length;
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
    public void addDigitFront (int newDigit)
    {
	int[] newArray = new int [this.size + 1];
	newArray [0] = newDigit;
	for (int i = 1 ; i < newArray.length ; i++)
	{
	    newArray [i] = this.intArray [i - 1];
	}
	this.intArray = newArray;
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
    public void addDigitBack (int newDigit)
    {
	int[] newArray = new int [this.size + 1];
	newArray [this.size] = newDigit;
	for (int i = 0 ; i < newArray.length - 1 ; i++)
	{
	    newArray [i] = this.intArray [i];
	}
	this.intArray = newArray;

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
    public String toString ()
    {
	String bigInteger = "";
	for (int i = this.intArray.length - 1 ; i >= 0 ; i--)
	{
	    bigInteger = bigInteger + this.intArray [i];
	}
	return bigInteger;
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
    public BigPositiveInt add (int secondInteger)
    {
	int value = 0;
	int carry = 0;
	int modifier = 10;
	int count = 0;
	BigPositiveInt newInteger;
	while (secondInteger / modifier > 0)
	{
	    modifier = modifier * 10;
	    count = count + 1;
	}
	if (this.size <= count)
	    newInteger = new BigPositiveInt (count + 1);
	else
	    newInteger = new BigPositiveInt (this.intArray.length + 1);
	BigIntTest.c.println ("size: " + newInteger.intArray.length);
	for (int i = 0 ; i < newInteger.intArray.length ; i++)
	{
	    if (i < this.intArray.length)
	    {
		value = (this.intArray [i] + secondInteger % 10 + carry);
		newInteger.intArray [i] = value % 10;
	    }
	    else if (i < count)
	    {
		value = (secondInteger % 10 + carry);
		newInteger.intArray [i] = value % 10;
	    }
	    else
	    {
		value = carry;
		newInteger.intArray [i] = value;
	    }
	    if (value / 10 > 0)
		carry = 1;
	    else
		carry = 0;
	    secondInteger = secondInteger / 10;
	    BigIntTest.c.println (newInteger.intArray [i]);
	}
	newInteger.removeLeadingZeros ();
	return newInteger;
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
    public BigPositiveInt add (BigPositiveInt secondInteger)
    {
	int value = 0;
	int carry = 0;
	int divisor = 10;
	BigPositiveInt newInteger;
	if (this.size <= secondInteger.size)
	    newInteger = new BigPositiveInt (secondInteger.size + 1);
	else
	    newInteger = new BigPositiveInt (this.size + 1);
	for (int i = 0 ; i < newInteger.intArray.length ; i++)
	{
	    if (i < this.intArray.length && i < secondInteger.intArray.length)
	    {
		value = this.intArray [i] + secondInteger.intArray [i] + carry;
		newInteger.intArray [i] = value % 10;
	    }
	    else if (i < secondInteger.size)
	    {
		value = secondInteger.intArray [i] + carry;
		newInteger.intArray [i] = value % 10;
	    }
	    else if (i < this.size)
	    {
		value = this.intArray [i] + carry;
		newInteger.intArray [i] = value % 10;
	    }
	    else
	    {
		value = carry;
		newInteger.intArray [i] = value;
	    }
	    if (value / 10 > 0)
		carry = 1;
	    else
		carry = 0;
	}
	newInteger.removeLeadingZeros ();
	return newInteger;
    }


    // ======================================================================================================
    public BigPositiveInt sub (int secondInteger)
    {
	int modifier = 0;
	int count = 0;
	int carry = 0;
	int value = 0;
	int size = 0;
	int large = 0;
	int small = 0;
	boolean equal = true;
	BigPositiveInt newInteger;
	while (secondInteger / modifier > 0)
	{
	    modifier = modifier * 10;
	    count = count + 1;
	}
	if (this.size <= count)
	{
	    newInteger = new BigPositiveInt(count);
	    size = this.size;
	}
	else
	{
	    newInteger = new BigPositiveInt(this.size);
	    size = count;
	}
	if (this.size > count)
	{
	    equal = false;
	    large = this.size;
	    small = count;
	}
	else if (this.size < count)
	{
	    large = count;
	    small = this.size;
	    equal = false;
	}
	else
	while (size >= 0 && equal == true)
	{
		if (this.intArray[size-1] < secondInteger/10)
		    equal = false;
		else if (this.intArray[size - 1] > secondInteger/10)
		    equal = false;
		else
		    {
			size = size - 1;
			equal = true;
		    }
	}
	for (int i = 0; i < newInteger.intArray.length; i ++)
	{
	    if (this.intArray[i] < secondInteger%10)
	    {
		value = ((this.intArray[i] + 10 - carry) - secondInteger%10);
		carry = 1;   
	    }
	    else
	    {
		value = this.intArray[i] - carry - secondInteger%10;
		carry = 0;
	    }
	    newInteger.intArray[i] = value;
	}
	return newInteger;
	    
    }
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
