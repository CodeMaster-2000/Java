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
	int size = 0;
	int digit = 0;
	BigPositiveInt integer;
	BigPositiveInt secondInteger;
	c.print("======BIG POSITIVE INT TESTING======");
	c.print("\n\nPlease enter an INTEGER size value: ");
	size = c.readInt();
	c.print("Please enter an INTEGER digit value: ");
	digit = c.readInt();
	integer = new BigPositiveInt(size, digit);
	c.println("\nBigInteger: " + integer.toString());
	c.println("\nUser Desired Value");
	integer.get();
	c.print("\nBigInteger: " + integer.toString());
	c.println("\nManipulating Numerical Values");
	c.println("Please enter a digit value to add to the front of the BigInteger: ");
	c.println("BigInteger (reformated): " + integer.addDigitBack(c.readInt()));
	c.println("Please enter a digit value to add to the end of the BigInteger: ");
	c.println("BigInteger (reformated): " + integer.addDigitFront(c.readInt()));
	c.println("Arithmetic Operations");
	integer.get();
	c.println("Please enter a POSITIVE integer: ");
	c.
	integer.get();
	secondInteger.get();
	c.println("Addition Result: " + integer.add(secondInteger).toString());
	


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
intArray (INT ARRAY) - an INTEGER ARRAY data element containing all the INDIVIDUAL DIGITS of a HUGE NUMBER stored in such a way that
		       the LAST DIGIT is the FIRST INDEX and the FIRST DIGIT is the LAST INDEX.
sign (CHAR) - a CHAR type data element representing the sign of a BIG NUMBER (used in methods that require arithmetic operations and get values)

METHODS

BigPositiveInt (Constructor with two INTEGER type parameters for size and digit) - Based on the given INTEGER type size parameter and the INTEGER type digit parameter, sets the INTEGER ARRAY type data element
										   to the SIZE of the given parameter value and intializes the values of each element in the INTEGER ARRAY to the INTEGER type digit 
										   value inputted via parameter.
										   
BigPositiveInt (Constructor with one INTEGER type parameter for size) - Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the size of the given SIZE parameter value and intialize
									all ELEMENTS of the array to a value of 0.
									
get -  Based on the STRING type input recieved from the user representing a BIG INTEGER, editchecks for valid NUMERICAL VALUES and sets the SIZE of the INTEGER
       ARRAY to the length of the string in addition to setting each DIGIT VALUE of the number to an ELEMENT in the INTEGER ARRAY data element
       - calls removeLeadingZeros to editcheck the inputted values and ignore unneccesary zeros infront of the number that don't add any value to it 
       
removeLeadingZeros -  Based on the INTEGER ARRAY type data element and the number of ZEROS infront of a NUMBER, sets the INTEGER ARRAY type data element
		      to a new INTEGER ARRAY that has deleted all the zeros that add no value to it (if present) and creates a NEW SIZE for the INTEGER ARRAY
		      
addDigitFront -  Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER 
		 ARRAY type data element to a new SIZE and adds the parameter DIGIT value to index 0 of the INTEGER ARRAY type data element 
		 (meaning a digit was added to the back of the number)
		 
addDigitBack -  Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER 
		ARRAY type data element to a new SIZE and adds the parameter DIGIT value to the last index of the INTEGER ARRAY type data element 
		(meaning a digit was added to the front of the number)
		
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
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class BigPositiveInt
{
    protected int size = 0;
    protected int[] intArray;
    protected char sign = '+';
    // BigPositiveInt (Constructor with two INTEGER type parameters for size and digit)

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Based on the given INTEGER type size parameter and the INTEGER type digit parameter, sets the INTEGER ARRAY type data element
	     to the SIZE of the given parameter value and intializes the values of each element in the INTEGER ARRAY to the INTEGER type digit 
	     value inputted via parameter.
    Input: An INTEGER type parameter value representing size of the INTEGER ARRAY data element and an INTEGER type parameter value for the value of each element 
	   in the INTEGER ARRAY data element.
    Output: None - sets the size and values for the INTEGER ARRAY data element respective to the given parameter values INTEGER size and INTEGER digit value.
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
    // BigPositiveInt (Constructor with one INTEGER type parameter for size)

    /*
    Author: Swethan Sivasegaran
    Date: October 14 2017
    Purpose: Given an INTEGER type size parameter value, sets the INTEGER ARRAY type data element to the size of the given SIZE parameter value and intialize
	     all ELEMENTS of the array to a value of 0.
    Input: An INTEGER type parameter value representing size of the INTEGER ARRAY type data element
    Output: None - sets the size of the INTEGER ARRAY type data element and intialize all elements in the array to 0.
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
	// if i = 0? instead of removeLeadingZeros
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
    // addDigitFront

    /*
    Author: Swethan Sivasegaran
    Date: October 15 2017
    Purpose: Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER 
	     ARRAY type data element to a new SIZE and adds the parameter DIGIT value to index 0 of the INTEGER ARRAY type data element 
	     (meaning a digit was added to the back of the number)
    Input: An INTEGER type parameter value representing a new DIGIT (0-9) - editchecked
    Output: None - sets the INTEGER ARRAY type data element to a NEW INTEGER ARRAY containing a NEW SIZE and the desired digit at index 0.
    */
    public void addDigitFront (int newDigit)
    {
	//editcheck for if it is a digit
	int[] newArray = new int [this.size + 1];
	newArray [0] = newDigit;
	for (int i = 1 ; i < newArray.length ; i++)
	{
	    newArray [i] = this.intArray [i - 1];
	}
	this.intArray = newArray;
    }


    // ======================================================================================================
    // addDigitBack

    /*
    Author: Swethan Sivasegaran
    Date: October 15 2017
    Purpose: Given an INTEGER type parameter value representing a DIGIT value (editchecked for range between 0 and 9), sets the INTEGER 
	     ARRAY type data element to a new SIZE and adds the parameter DIGIT value to the last index of the INTEGER ARRAY type data element 
	     (meaning a digit was added to the front of the number)
    Input: An INTEGER type parameter value representing a new DIGIT (0-9) - editchecked
    Output: None - sets the INTEGER ARRAY type data element to a NEW INTEGER ARRAY containing a NEW SIZE and the desired digit at the last index.
    */
    public void addDigitBack (int newDigit)
    {
	//editcheck for if it is a digit
	int[] newArray = new int [this.size + 1];
	newArray [this.size] = newDigit;
	for (int i = 0 ; i < newArray.length - 1 ; i++)
	{
	    newArray [i] = this.intArray [i];
	}
	this.intArray = newArray;

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
    */
    public String toString ()
    {
	String bigInteger = "";
	for (int i = this.intArray.length - 1 ; i >= 0 ; i--)
	{
	    bigInteger = bigInteger + this.intArray [i];
	}
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
	    else if (i <= count)
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
	    BigIntTest.c.println ("secondInteger: " + secondInteger);
	    secondInteger = secondInteger / 10;
	}
	newInteger.removeLeadingZeros ();
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
	int modifier = 10;
	int count = 0;
	int carry = 0;
	int value = 0;
	int temp = 0;
	boolean bigger = false;
	BigPositiveInt newInteger;
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
	//make sure im subtracting small from large - determines sign
	if (this.size < count + 1)
	    bigger = true;
	else if (this.size > count + 1)
	    bigger = false;
	else
	{
	    for (int i = this.intArray.length - 1 ; i >= 0 ; i--)
	    {
		modifier = modifier / 10;
		if (this.intArray [i] > secondInteger / modifier)
		    bigger = false;
		else if (this.intArray [i] < secondInteger / modifier)
		    bigger = true;
		else
		{
		    bigger = false;
		    secondInteger = secondInteger % modifier;
		    BigIntTest.c.println ("hello");
		}
		//bigger change in variable
	    }
	}
	BigIntTest.c.println ("bigger: " + bigger);
	secondInteger = temp;
	for (int i = 0 ; i < newInteger.intArray.length ; i++)
	{
	    if (bigger == false)
	    {
		if (this.intArray [i] < secondInteger % 10)
		{
		    value = ((this.intArray [i] + 10 - carry) - secondInteger % 10);
		    carry = 1;
		}
		else
		{
		    value = this.intArray [i] - carry - secondInteger % 10;
		    carry = 0;
		}
	    }
	    else
	    {
		if (i < this.intArray.length)
		{
		    if (secondInteger % 10 < this.intArray [i])
		    {
			value = ((secondInteger % 10 + 10 - carry) - this.intArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = secondInteger % 10 - carry - this.intArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = secondInteger % 10 - carry;
		    carry = 0;
		}

	    }
	    newInteger.intArray [i] = value;
	    BigIntTest.c.println ("newInteger: " + newInteger.intArray [i]);
	    secondInteger = secondInteger / 10;
	}
	newInteger.removeLeadingZeros ();
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
	int carry = 0;
	int value = 0;
	boolean bigger = false;
	BigPositiveInt newInteger;
	if (this.size <= secondInteger.size)
	    newInteger = new BigPositiveInt (secondInteger.size);
	else
	    newInteger = new BigPositiveInt (this.size);
	if (this.size < secondInteger.size)
	    bigger = true;
	else if (this.size > secondInteger.size)
	    bigger = false;
	else
	{
	    for (int i = this.intArray.length - 1 ; i >= 0 ; i--)
	    {
		if (this.intArray [i] > secondInteger.intArray [i])
		    bigger = false;
		else if (this.intArray [i] < secondInteger.intArray [i])
		    bigger = true;
		else
		    bigger = false;
	    }
	}
	BigIntTest.c.println ("bigger: " + bigger);
	for (int i = 0 ; i < newInteger.intArray.length ; i++)
	{
	    if (bigger == false)
	    {
		if (i < this.intArray.length && i < secondInteger.intArray.length)
		{
		    if (this.intArray [i] < secondInteger.intArray [i])
		    {
			value = ((this.intArray [i] + 10 - carry) - secondInteger.intArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = this.intArray [i] - carry - secondInteger.intArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = this.intArray[i] - carry;
		    carry = 0;
		}
	    }
	    else
	    {
		if (i < this.intArray.length)
		{
		    if (secondInteger.intArray [i] < this.intArray [i])
		    {
			value = ((secondInteger.intArray [i] + 10 - carry) - this.intArray [i]);
			carry = 1;
		    }
		    else
		    {
			value = secondInteger.intArray [i] - carry - this.intArray [i];
			carry = 0;
		    }
		}
		else
		{
		    value = secondInteger.intArray [i] - carry;
		    carry = 0;
		}

	    }
	    newInteger.intArray [i] = value;
	    BigIntTest.c.println ("newInteger: " + newInteger.intArray [i]);
	}
	newInteger.removeLeadingZeros ();
	if (bigger == false)
	    newInteger.sign = '+';
	else
	    newInteger.sign = '-';
	return newInteger;
    }
    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
//naming and testing  and main
//note refer to get and stuff
//sign data element comment
