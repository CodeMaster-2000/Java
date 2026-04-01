// The "BigIntTest" class.
import java.awt.*;
import hsa.Console;

public class BigIntTest
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	// Place your program here.  'c' is the output console
    } // main method
} // BigIntTest class
class BigPositiveInt
{
    protected int size = 0;
    protected int[] intArray;
    protected char sign = ' ';
    public BigPositiveInt (int size, int digit)
    {
	int count = 0;
	while (count < size)
	{
	    this.intArray [count] = digit;
	    count = count + 1;
	}
	this.size = size;
    }


    public BigPositiveInt (int size)
    {
	this (size, 0);
    }


    /*Method get
    Gets a bigInt from the user.
    Parameters: Console object.
    Return Value: None
    ----------------------------------------------*/
    public void get (Console c)
    {
	String a;
	a = c.readString ();
	this.size = a.length ();

	for (int i = 0 ; i < a.length () ; i++)
	    this.addDigitBack (a.charAt (i) - '0');

	this.removeLeadingZeros ();
    }


    /*----------------------------------------------
    Method removeLeadingZeros
    Removes any excess zeros at the front of the array.
    Parameters: None
    Return Value: None
    ----------------------------------------------*/
    public void removeLeadingZeros ()
    {
	int[] old;
	while ((this.digits [this.size - 1] == 0) && (size > 1))
	    this.size--;

	old = this.digits;
	this.digits = new int [this.size];

	for (int a = 0 ; a < this.size ; a++)
	    this.digits [a] = old [a];
    }


    /*----------------------------------------------
    Method addDigitFront
    Adds a given integer to the front of the current
    BigInt.
    Parameters: Given integer.
    Return Value: None
    ----------------------------------------------*/
    public void addDigitFront (int added)
    {
	int[] oldDigit;
	oldDigit = this.digits;

	this.size++;
	this.digits = new int [this.size];

	for (int i = 1 ; i < this.size ; i++)
	    this.digits [i] = oldDigit [i - 1];
	this.digits [0] = added;
    }


    /*----------------------------------------------
    Method addDigitBack
    Adds a given integer to the back of the current
    BigInt.
    Parameters: Given integer.
    Return Value: None
    ----------------------------------------------*/
    public void addDigitBack (int added)
    {
	int[] oldDigit;
	oldDigit = this.digits;

	this.size++;
	this.digits = new int [this.size];

	for (int i = 0 ; i < this.size - 1 ; i++)
	    this.digits [i] = oldDigit [i];
	this.digits [this.size - 1] = added;
    }


    public String toString ()
    {
	int value = 0;
	int count = 0;
	while (count < this.size)
	{
	    value = value + this.intArray [count] * (Math.pow (10, count));
	}
	//wht if array is empty
	return "" + value;
    }


    public BigPositiveInt add (BigPositiveInt secondInteger)
    {
	int value = 0;
	int count = 0;
	int modifier = 10;
	BigPositiveInt newInteger;
	// More range than doubles
	value = Integer.parseInt (this.toString()) + Integer.parseInt(secondInteger.toString());
	while (value / modifier > 0)
	{
	    newInteger = new BigPositiveInt (count + 1);
	    newInteger [count] = (value % modifier) / (Math.pow(10,count));
	    modifier = modifier * 10;
	}

	return newInteger;
    }
    public BigPositiveInt add (int secondInteger)
    {
	int value = 0;
	int count = 0;
	int modifier = 10;
	BigPositiveInt newInteger;
	value = Integer.parseInt (this.toString) + secondInteger;
	while (value / modifier > 0)
	{
	    newInteger = new BigPositiveInt (count + 1);
	    newInteger [count] = value % modifier;
	    modifier = modifier * 10;
	}

	return newInteger;
    }
}
