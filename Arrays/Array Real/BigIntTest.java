// The "BigIntTest" class.
/*
Author: Swethan Sivasegaran
Date: October 14 2017
Purpose: To demonstrate the capabilitiy of manipulating Arrays by expanding the range and potential of a NUMBER by storing its digits in
	 an INTEGER ARRAY
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS BIGINTTEST
/*
Author: Swethan Sivasegaran
Date: October 14 2017
Purpose: To test the Functionality of the methods in BigPositiveInt CLASS and its manipulation of digits

DATA FIELDS - None

METHODS

main - To demonstrate the functionality and testing of the methods in BigPositiveInt CLASS via Console
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class BigIntTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: To demonstrate the functionality and testing of the methods in BigPositiveInt CLASS via Console
    Input: None - based on the input recieved from the user  via Console
    Output: The outputs of all the methods in the BigPositiveINt CLASS
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();

	//Initialization
	int size = 0;
	int digit = 0;
	int repeat = 0;

	//Process
	while (repeat == 0)
	{
	    c.clear ();
	    BigPositiveInt integer;
	    BigPositiveInt secondInteger;
	    c.setTextColor (Color.red);
	    c.print ("======BIG POSITIVE INT TESTING======");
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a POSITIVE INTEGER size value: ");
	    size = c.readInt ();
	    c.print ("Please enter a POSITIVE INTEGER digit value: ");
	    digit = c.readInt ();
	    integer = new BigPositiveInt (size, digit);
	    c.print ("\n\nPlease enter a POSITIVE INTEGER size value: ");
	    size = c.readInt ();
	    c.print ("Please enter a POSITIVE INTEGER digit value: ");
	    digit = c.readInt ();
	    secondInteger = new BigPositiveInt (size, digit);
	    c.setTextColor (Color.black);
	    c.println ("\nBigInteger: " + integer.toString ());
	    c.setTextColor (Color.black);
	    c.println ("\nBigInteger: " + secondInteger.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\nUser Desired Value\n");
	    c.setTextColor (Color.blue);
	    integer.get ();
	    c.setTextColor (Color.black);
	    c.println ("BigInteger: " + integer.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nManipulating Numerical Values\n");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a POSITIVE digit value to add to the front of the BigInteger: ");
	    integer.addDigitBack (c.readString ());
	    c.setTextColor (Color.black);
	    c.println ("BigInteger (reformated): " + integer.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a POSITIVE digit value to add to the end of the BigInteger: ");
	    integer.addDigitFront (c.readString ());
	    c.setTextColor (Color.black);
	    c.println ("BigInteger (reformated): " + integer.toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nAddition\n");
	    c.setTextColor (Color.blue);
	    integer.get ();
	    c.print ("Please enter a POSITIVE integer: ");
	    c.setTextColor (Color.black);
	    c.println ("Addition Result: " + integer.add (c.readInt ()).toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nAddition Overload\n");
	    c.setTextColor (Color.blue);
	    integer.get ();
	    secondInteger.get ();
	    c.setTextColor (Color.black);
	    c.println ("Addition Result(overload): " +
		    integer.add (secondInteger).toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nSubtraction\n");
	    c.setTextColor (Color.blue);
	    integer.get ();
	    c.print ("Please enter a POSITIVE integer: ");
	    c.setTextColor (Color.black);
	    c.println ("Subtraction Result: " + integer.sub (c.readInt ()).toString ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nSubtraction Overload\n");
	    c.setTextColor (Color.blue);
	    integer.get ();
	    secondInteger.get ();
	    c.setTextColor (Color.black);
	    c.println ("Subtraction Result(overload): " + integer.sub (secondInteger).toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter a 0 (to restart program) or any other key(to end program): ");
	    repeat = c.readInt ();
	}

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS BIGPOSITIVEINT
/*
Author: Swethan Sivasegaran
Date: October 14 2017
Purpose: To showcase all the capabilities and expansive design of creating a NUMBER that can exceed NUMERICAL RESTRICTIONS imposed on JAVA PRIMITIVE variables
	 and perform extra operations in addition to it (Ex. Subtract or Add)

DATA FIELDS

size (INT) - an INTEGER type data element representing the NUMBER of DIGITS the BIG NUMBER has or rather the size of the INTEGER ARRAY data element
digitArray (INT ARRAY) - an INTEGER ARRAY data element containing all the INDIVIDUAL DIGITS of a HUGE NUMBER stored in such a way that
		       the LAST DIGIT is the FIRST INDEX and the FIRST DIGIT is the LAST INDEX.
sign (CHAR) - a CHAR type data element representing the sign of a BIG NUMBER (used in methods that require arithmetic operations and get values)

METHODS

BigPositiveInt (Constructor with two INTEGER type parameters for size and digit) - Based on the given INTEGER type size parameter and the INTEGER type digit parameter, sets the INTEGER ARRAY type data element
										   to the SIZE of the given parameter value and intializes the values of each element in the INTEGER ARRAY to the INTEGER type digit
										   value inputted via parameter.
										   - default size value is 0 and default digit value is 0

BigPositiveInt (Constructor with one INTEGER type parameter for size) - Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the size of the given SIZE parameter value and intialize
									all ELEMENTS of the array to a value of 0.
									- default size value is 0

get -  Based on the STRING type input recieved from the user representing a BIG INTEGER, editchecks for valid NUMERICAL VALUES and sets the SIZE of the INTEGER
       ARRAY to the length of the string in addition to setting each DIGIT VALUE of the number to an ELEMENT in the INTEGER ARRAY data element
       - calls removeLeadingZeros to editcheck the inputted values and ignore unneccesary zeros infront of the number that don't add any value to it

removeLeadingZeros -  Based on the INTEGER ARRAY type data element and the number of ZEROS infront of a NUMBER, sets the INTEGER ARRAY type data element
		      to a new INTEGER ARRAY that has deleted all the zeros that add no value to it (if present) and creates a NEW SIZE for the INTEGER ARRAY

addDigitFront -  Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER
		 ARRAY type data element to a new SIZE and adds the parameter DIGIT value to index 0 of the INTEGER ARRAY type data element
		 (meaning a digit was added to the back of the number)
		 - default adds a 0 if invalid digit is entered

addDigitBack -  Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER
		ARRAY type data element to a new SIZE and adds the parameter DIGIT value to the last index of the INTEGER ARRAY type data element
		(meaning a digit was added to the front of the number)
		- default adds a 0 if invalid digit is entered

toString -  Based on the INTEGER ARRAY type data element, returns a STRING type representation of number according to all the DIGIT values
	    broken down into each respective element position resulting in a BIG NUMBER capable of exceeding
	    primitive ranges.
	    - in addition to the ELEMENT values, incorporates the NEGATIVE sign into the STRING type representation
	      corresponding to the CHAR type sign data element (NO + SIGN b/c it is understood a number is positive without it)

add (INTEGER type parameter value) -  Given a POSITIVE INTEGER type parameter value, ADDS the current BIGPOSITIVEINT to the POSITIVE INTEGER type parameter value and returns
				      a new BIGPOSITIVEINT type OBJECT with a new respective SIZE and new DIGIT values as its elements according to the result
				      of the addition - assumes the INTEGER given is POSITIVE (editchecked)

add (BIGPOSITIVEINT OBJECT parameter value - overloaded) -  Given a BIGPOSITIVEINT type OBJECT via parameters, returns a new BIGPOSITIVEINT type OBJECT with a NEW SIZE and
							    the DIGIT values as its elements from the result of the addition of the CURRENT BIGPOSITIVEINT and the BIGPOSITIVEINT
							    type OBJECT via parameter

sub (INTEGER type parameter value) -  Given a POSITIVE INTEGER type parameter value, SUBTRACTS the current BIGPOSITIVEINT from the POSITIVE INTEGER type parameter value and returns
				      a new BIGPOSITIVEINT type OBJECT with a new respective SIZE and new DIGIT values as its elements according to the result
				      of the subtraction - assumes the INTEGER given is POSITIVE (editchecked)
				      - alters the CHAR type sign data element respective to if the result was negative or not

sub(BIGPOSITIVEINT OBJECT parameter value - overloaded) - Given a BIGPOSITIVEINT type OBJECT via parameters, returns a new BIGPOSITIVEINT type OBJECT with a NEW SIZE and
							  the DIGIT values as its elements from the result of the subtraction of the BIGPOSITIVEINT type OBJECT via parameter
							  subtracted from the CURRENT BIGPOSITIVEINT.
							  - alters the CHAR type sign data element respective to if the result was negative or not
							  
typeCheck - Given a STRING variable representing a single digit, returns a BOOLEAN variable depicting if the STRING entered was
	    a SINGLE digit value (INTEGER range from 0 - 9)

Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class BigPositiveInt
{
    //DATA FIELDS
    protected int size = 0;
    protected int[] digitArray;
    protected char sign = '+';

    // BigPositiveInt (Constructor with two INTEGER type parameters for size and digit)

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Based on the given INTEGER type size parameter and the INTEGER type digit parameter, sets the INTEGER ARRAY type data element
	     to the SIZE of the given parameter value and intializes the values of each element in the INTEGER ARRAY to the INTEGER type digit
	     value inputted via parameter.
	     - default size value is 0 and default digit value is 0
    Input: An INTEGER type parameter value representing size of the INTEGER ARRAY data element and an INTEGER type parameter value for the value of each element
	   in the INTEGER ARRAY data element.
    Output: None - sets the size and values for the INTEGER ARRAY data element respective to the given parameter values INTEGER size and INTEGER digit value.
	    - default size value is 0 and default digit value is 0
    */
    public BigPositiveInt (int size, int digit)
    {
	//Initialization
	int count = 0;
	if (size >= 0)
	    this.digitArray = new int [size];
	else
	    this.digitArray = new int [0];
	if (digit > 9 || digit < 0)
	    digit = 0;
	this.size = this.digitArray.length;

	//Process
	while (count < this.size)
	{
	    this.digitArray [count] = digit;
	    count = count + 1;
	}
    }


    // ======================================================================================================
    // BigPositiveInt (Constructor with one INTEGER type parameter for size)

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the size of the given SIZE parameter value and intialize
	     all ELEMENTS of the array to a value of 0.
	     - default size value is 0
    Input: An INTEGER type parameter value representing size of the INTEGER ARRAY type data element
    Output: None - sets the size of the INTEGER ARRAY type data element and intialize all elements in the array to 0.
	    - default size value is 0
    */
    public BigPositiveInt (int size)
    {
	this (size, 0);
    }


    // -------------------------------------------------------------------------------------------------------
    // get

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Based on the STRING type input recieved from the user representing a BIG INTEGER, editchecks for valid NUMERICAL VALUES and sets the SIZE of the INTEGER
	     ARRAY to the length of the string in addition to setting each DIGIT VALUE of the number to an ELEMENT in the INTEGER ARRAY data element
	     - calls removeLeadingZeros to editcheck the inputted values and ignore unneccesary zeros infront of the number that don't add any value to it
    Input: Through the Console, recieves a STRING type input from the user which is translated back into an INTEGER value (editchecks for NUMERICAL values)
    Output: None - sets the SIZE and ELEMENTS of the INTEGER ARRAY type data element respective of the length of the STRING inputted and (if editchecked),
	    sets each DIGIT value of the number entered as an ELEMENT of the INTEGER ARRAY type data element

    Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
    */
    public void get ()
    {
	// Initialization
	int count = 0;
	boolean digit = false;
	String userInt = "";
	BigIntTest.c.print ("Please enter a POSITIVE INTEGER size value: ");
	userInt = BigIntTest.c.readString ();

	//EditChecking
	while (digit == false)
	{
	    for (int i = 0 ; i < userInt.length () ; i++)
	    {
		if (userInt.charAt (i) >= '0' && userInt.charAt (i) <= '9')
		    digit = true;
		else
		{
		    digit = false;
		    BigIntTest.c.println ("You have entered a NON INTEGER character.");
		    BigIntTest.c.print ("Please re - enter a POSITIVE INTEGER value of any size: ");
		    userInt = BigIntTest.c.readString ();
		    i = -1;
		}
	    }
	}

	//Initializing Values
	this.digitArray = new int [userInt.length ()];
	this.size = userInt.length ();
	this.sign = '+';

	//Process
	for (int i = this.size - 1 ; i >= 0 ; i--)
	{
	    this.digitArray [count] = userInt.charAt (i) - '0';
	    count = count + 1;
	}
	this.removeLeadingZeros ();
    }


    // ======================================================================================================
    // removeLeadingZeros

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Based on the INTEGER ARRAY type data element and the number of ZEROS infront of a NUMBER, sets the INTEGER ARRAY type data element
	     to a new INTEGER ARRAY that has deleted all the zeros that add no value to it (if present) and creates a NEW SIZE for the INTEGER ARRAY
    Input: None - based on the INTEGER ARRAY type data element
    Output: None - creates a new INTEGER ARRAY with the same DIGITS as the INTEGER ARRAY type data element but without LEADING ZEROS and sets the
	    INTEGER ARRAY type data element to the new array with its respective SIZE.
    Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
    */
    public void removeLeadingZeros ()
    {
	//Process
	while (this.digitArray [this.size - 1] == 0 && this.size > 1)
	{
	    this.size = this.size - 1;
	}
	int[] newArray = new int [this.size];

	for (int i = 0 ; i < newArray.length ; i++)
	    newArray [i] = this.digitArray [i];
	this.digitArray = newArray;
	this.size = newArray.length;
    }


    // -------------------------------------------------------------------------------------------------------
    // addDigitFront

    /*
    Author: Swethan Sivasegaran
    Date: October 15 2017
    Purpose: Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER
	     ARRAY type data element to a new SIZE and adds the parameter DIGIT value to index 0 of the INTEGER ARRAY type data element
	     (meaning a digit was added to the back of the number)
	     - default adds a 0 if invalid digit is entered
    Input: An INTEGER type parameter value representing a new DIGIT (0-9) - editchecked
    Output: None - sets the INTEGER ARRAY type data element to a NEW INTEGER ARRAY containing a NEW SIZE and the desired digit at index 0.
	    - default adds a 0 if invalid digit is entered

    Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
    */
    public void addDigitFront (String userDigit)
    {
	//Initialization
	int newDigit = 0;
	
	//EditChecking
	if (typeCheck (userDigit) == false)
	    newDigit = 0;
	else
	{
	    //Process
	    newDigit = userDigit.charAt (0) - '0';
	    int[] newArray = new int [this.size + 1];
	    newArray [0] = newDigit;
	    for (int i = 1 ; i < newArray.length ; i++)
	    {
		newArray [i] = this.digitArray [i - 1];
	    }
	    this.digitArray = newArray;
	    this.size = newArray.length;
	}
    }


    // ======================================================================================================
    // addDigitBack

    /*
    Author: Swethan Sivasegaran
    Date: October 15 2017
    Purpose: Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER
	     ARRAY type data element to a new SIZE and adds the parameter DIGIT value to the last index of the INTEGER ARRAY type data element
	     (meaning a digit was added to the front of the number)
	     - default adds a 0 if invalid digit is entered
    Input: An INTEGER type parameter value representing a new DIGIT (0-9) - editchecked
    Output: None - sets the INTEGER ARRAY type data element to a NEW INTEGER ARRAY containing a NEW SIZE and the desired digit at the last index.
	    - default adds a 0 if invalid digit is entered

    Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
    */
    public void addDigitBack (String userDigit)
    {
	//Initialization
	int newDigit = 0;
	
	//EditChecking
	if (typeCheck (userDigit) == false)
	    newDigit = 0;
	else
	{
	    //Process
	    newDigit = userDigit.charAt(0) - '0';
	    int[] newArray = new int [this.size + 1];
	    newArray [this.size] = newDigit;
	    for (int i = 0 ; i < newArray.length - 1 ; i++)
	    {
		newArray [i] = this.digitArray [i];
	    }
	    this.digitArray = newArray;
	    this.removeLeadingZeros ();
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // toString

    /*
    Author: Swethan Sivasegaran
    Date: October 17 2017
    Purpose: Based on the INTEGER ARRAY type data element, returns a STRING type representation of number according to all the DIGIT values
	     broken down into each respective element position resulting in a BIG NUMBER capable of exceeding
	     primitive ranges.
	     - in addition to the ELEMENT values, incorporates the NEGATIVE sign into the STRING type representation
	       corresponding to the CHAR type sign data element (NO + SIGN b/c it is understood a number is positive without it)
    Input: None - based on the INTEGER ARRAY type data element
    Output: A STRING type representation of a number based on all the DIGIT values in a INTEGER ARRAY type data element and the CHAR type sign data element
	    resulting in a BIG NUMBER capable of exceeding primitive ranges imposed on java.

    Note: DIGITS ARE RECORDED WITHIN AN ARRAY IN A FASHION SUCH THAT THE FIRST INDEX IS THE LAST DIGIT AND THE LAST INDEX IS THE FIRST DIGIT
    */
    public String toString ()
    {
	//Initialization
	String bigInteger = "";

	//Process
	for (int i = this.digitArray.length - 1 ; i >= 0 ; i--)
	{
	    bigInteger = bigInteger + this.digitArray [i];
	}

	//EditChecking Signs
	if (this.sign == '-')
	    bigInteger = "-" + bigInteger;
	return bigInteger;
    }


    // ======================================================================================================
    // add (INTEGER type parameter value)

    /*
    Author: Swethan Sivasegaran
    Date: October 17 2017
    Purpose: Given a POSITIVE INTEGER type parameter value, ADDS the current BIGPOSITIVEINT to the POSITIVE INTEGER type parameter value and returns
	     a new BIGPOSITIVEINT type OBJECT with a new respective SIZE and new DIGIT values as its elements according to the result
	     of the addition - assumes the INTEGER given is POSITIVE (editchecked)
    Input: A POSITIVE INTEGER type parameter value
    Output: A BIGPOSITIVEINT type OBJECT containing the DIGIT values from the addition of the current BIGPOSITIVEINT and the POSITIVE INTEGER type parameter value
    */
    public BigPositiveInt add (int secondInteger)
    {
	//editcheck for positive integer values

	//Initialization
	int count = 0;
	int modifier = 10;
	int value = 0;
	int carry = 0;
	BigPositiveInt newInteger;

	//Setting Sizes
	while (secondInteger / modifier > 0)
	{
	    modifier = modifier * 10;
	    count = count + 1;
	}
	if (this.size <= count)
	    newInteger = new BigPositiveInt (count + 1);
	else
	    newInteger = new BigPositiveInt (this.digitArray.length + 1);

	//Process
	for (int i = 0 ; i < newInteger.digitArray.length ; i++)
	{
	    if (i < this.digitArray.length)
	    {
		value = (this.digitArray [i] + secondInteger % 10 + carry);
		newInteger.digitArray [i] = value % 10;
	    }
	    else if (i <= count)
	    {
		value = (secondInteger % 10 + carry);
		newInteger.digitArray [i] = value % 10;
	    }
	    else
	    {
		value = carry;
		newInteger.digitArray [i] = value;
	    }
	    if (value / 10 > 0)
		carry = 1;
	    else
		carry = 0;
	    secondInteger = secondInteger / 10;
	}
	newInteger.removeLeadingZeros ();
	newInteger.sign = '+';
	return newInteger;
    }


    // -------------------------------------------------------------------------------------------------------
    // add (BIGPOSITIVEINT OBJECT parameter value - overloaded)

    /*
    Author: Swethan Sivasegaran
    Date: October 18 2017
    Purpose: Given a BIGPOSITIVEINT type OBJECT via parameters, returns a new BIGPOSITIVEINT type OBJECT with a NEW SIZE and
	     the DIGIT values as its elements from the result of the addition of the CURRENT BIGPOSITIVEINT and the BIGPOSITIVEINT
	     type OBJECT via parameter
    Input: A BIGPOSITIVEINT type OBJECT
    Output: A NEW BIGPOSITIVEINT type OBJECT containing a NEW SIZE and NEW DIGIT VALUES as its elements from the result of the CURRENT
	    BIGPOSITIVEINT adding on to the BIGPOSITIVEINT type OBJECT recieved via parameter.
    */
    public BigPositiveInt add (BigPositiveInt secondInteger)
    {
	//Initialization
	int value = 0;
	int carry = 0;
	int divisor = 10;
	BigPositiveInt newInteger;

	//Setting Sizes
	if (this.size <= secondInteger.size)
	    newInteger = new BigPositiveInt (secondInteger.size + 1);
	else
	    newInteger = new BigPositiveInt (this.size + 1);

	//Process
	for (int i = 0 ; i < newInteger.digitArray.length ; i++)
	{
	    if (i < this.digitArray.length && i < secondInteger.digitArray.length)
	    {
		value = this.digitArray [i] + secondInteger.digitArray [i] + carry;
		newInteger.digitArray [i] = value % 10;
	    }
	    else if (i < secondInteger.size)
	    {
		value = secondInteger.digitArray [i] + carry;
		newInteger.digitArray [i] = value % 10;
	    }
	    else if (i < this.size)
	    {
		value = this.digitArray [i] + carry;
		newInteger.digitArray [i] = value % 10;
	    }
	    else
	    {
		value = carry;
		newInteger.digitArray [i] = value;
	    }
	    if (value / 10 > 0)
		carry = 1;
	    else
		carry = 0;
	}
	newInteger.removeLeadingZeros ();
	newInteger.sign = '+';
	return newInteger;
    }


    // ======================================================================================================
    // sub (INTEGER type parameter value)

    /*
    Author: Swethan Sivasegaran
    Date: October 19 2017
    Purpose: Given a POSITIVE INTEGER type parameter value, SUBTRACTS the current BIGPOSITIVEINT from the POSITIVE INTEGER type parameter value and returns
	     a new BIGPOSITIVEINT type OBJECT with a new respective SIZE and new DIGIT values as its elements according to the result
	     of the subtraction - assumes the INTEGER given is POSITIVE (editchecked)
	     - alters the CHAR type sign data element respective to if the result was negative or not
    Input: A POSITIVE INTEGER type parameter value
    Output: A BIGPOSITIVEINT type OBJECT containing the DIGIT values from the subtraction of the current BIGPOSITIVEINT from the POSITIVE INTEGER type parameter value
    Note: explain process and check for negative integer values
    */
    public BigPositiveInt sub (int secondInteger)
    {
	//Initialization
	int count = 0;
	int modifier = 10;
	int carry = 0;
	int value = 0;
	int temp = 0;
	boolean bigger = false;
	BigPositiveInt newInteger;

	//Setting sizes
	while (secondInteger / modifier > 0)
	{
	    modifier = modifier * 10;
	    count = count + 1;
	}
	if (this.size <= count)
	    newInteger = new BigPositiveInt (count + 1);
	else
	    newInteger = new BigPositiveInt (this.size);
	temp = secondInteger;

	//Comparing Numerical Values
	if (this.size < count + 1)
	    bigger = true;
	else if (this.size > count + 1)
	    bigger = false;
	else
	{
	    for (int i = this.digitArray.length - 1; i >= 0 ; i--)
	    {
		modifier = modifier / 10;
		if (this.digitArray [i] > secondInteger / modifier)
		    bigger = false;
		else if (this.digitArray [i] < secondInteger / modifier)
		    bigger = true;
		else
		    secondInteger = secondInteger % modifier;
		//bigger change in variable
	    }
	}

	//Process
	secondInteger = temp;
	for (int i = 0 ; i < newInteger.digitArray.length ; i++)
	{
	    if (bigger == false)
	    {
		if (this.digitArray [i] < secondInteger % 10)
		{
		    value = ((this.digitArray [i] + 10 - carry) - secondInteger % 10);
		    carry = 1;
		}
		else
		{
		    value = this.digitArray [i] - carry - secondInteger % 10;
		    carry = 0;
		}
	    }
	    else
	    {
		if (i < this.digitArray.length)
		{
		    if (secondInteger % 10 < this.digitArray [i])
		    {
			value = ((secondInteger % 10 + 10 - carry) - this.digitArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = secondInteger % 10 - carry - this.digitArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = secondInteger % 10 - carry;
		    carry = 0;
		}

	    }
	    newInteger.digitArray [i] = value;
	    secondInteger = secondInteger / 10;
	}
	newInteger.removeLeadingZeros ();

	//Setting Sign
	if (bigger == false)
	    newInteger.sign = '+';
	else
	    newInteger.sign = '-';
	return newInteger;
    }


    // -------------------------------------------------------------------------------------------------------
    // sub(BIGPOSITIVEINT OBJECT parameter value - overloaded)

    /*
    Author: Swethan Sivasegaran
    Date: October 20 2017
    Purpose: Given a BIGPOSITIVEINT type OBJECT via parameters, returns a new BIGPOSITIVEINT type OBJECT with a NEW SIZE and
	     the DIGIT values as its elements from the result of the subtraction of the BIGPOSITIVEINT type OBJECT via parameter
	     subtracted from the CURRENT BIGPOSITIVEINT.
	     - alters the CHAR type sign data element respective to if the result was negative or not
    Input: A BIGPOSITIVEINT type OBJECT
    Output: A NEW BIGPOSITIVEINT type OBJECT containing a NEW SIZE and NEW DIGIT VALUES as its elements from the result of the
	    BIGPOSITIVEINT type OBJECT recieved via parameter subtracted from the CURRENT BIGPOSITIVEINT.
    */
    public BigPositiveInt sub (BigPositiveInt secondInteger)
    {
	//Initialization
	int carry = 0;
	int value = 0;
	boolean bigger = false;
	BigPositiveInt newInteger;

	//Setting Size
	if (this.size <= secondInteger.size)
	    newInteger = new BigPositiveInt (secondInteger.size);
	else
	    newInteger = new BigPositiveInt (this.size);

	//Comparing Numerical Values
	if (this.size < secondInteger.size)
	    bigger = true;
	else if (this.size > secondInteger.size)
	    bigger = false;
	else
	{
	    for (int i = this.digitArray.length - 1 ; i >= 0 ; i--)
	    {
		if (this.digitArray [i] > secondInteger.digitArray [i])
		    bigger = false;
		else if (this.digitArray [i] < secondInteger.digitArray [i])
		    bigger = true;
	    }
	}

	//Process
	for (int i = 0 ; i < newInteger.digitArray.length ; i++)
	{
	    if (bigger == false)
	    {
		if (i < this.digitArray.length && i < secondInteger.digitArray.length)
		{
		    if (this.digitArray [i] < secondInteger.digitArray [i])
		    {
			value = ((this.digitArray [i] + 10 - carry) - secondInteger.digitArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = this.digitArray [i] - carry - secondInteger.digitArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = this.digitArray [i] - carry;
		    carry = 0;
		}
	    }
	    else
	    {
		if (i < this.digitArray.length)
		{
		    if (secondInteger.digitArray [i] < this.digitArray [i])
		    {
			value = ((secondInteger.digitArray [i] + 10 - carry) - this.digitArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = secondInteger.digitArray [i] - carry - this.digitArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = secondInteger.digitArray [i] - carry;
		    carry = 0;
		}

	    }
	    newInteger.digitArray [i] = value;
	}
	newInteger.removeLeadingZeros ();

	//Changing Signs
	if (bigger == false)
	    newInteger.sign = '+';
	else
	    newInteger.sign = '-';
	return newInteger;
    }


    // ======================================================================================================
    // typeCheck

    /*
    Author: Swethan Sivasegaran
    Date: October 20 2017
    Purpose: Given a STRING variable representing a single digit, returns a BOOLEAN variable depicting if the STRING entered was
	     a SINGLE digit value (INTEGER range from 0 - 9)
    Input: A STRING variable representing a single digit
    Output: A BOOLEAN variable depicting if the STRING entered was a SINGLE digit value (INTEGER range from 0 - 9)
    */
    public boolean typeCheck (String userInt)
    {
	//Initialization
	boolean digit = false;
	
	//EditChecking
	if (userInt.length() > 1)
	    digit = false;
	else
	{
	    if (userInt.charAt (0) <= '0' || userInt.charAt (0) >= '9')
		digit = false;
	    else
		digit = true;
	}
	return digit;
    }
    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
//testing
