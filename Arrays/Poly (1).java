// The "Poly" class.
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
public class Poly
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
	Polynomial poly = new Polynomial (5);
	poly.get ();
	c.print (poly.derivative ().toString ());

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
class Polynomial
{
    protected double[] coefficient;
    protected int degree;
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
    public Polynomial (int degree)
    {
	this.coefficient = new double [degree];
	this.degree = degree;
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
    public Polynomial ()
    {
	this (0);
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
	String polynomial = "";
	String monomial = "";
	String sign = "";
	for (int i = this.coefficient.length - 1; i >= 0 ; i--)
	{
	    if (i == this.coefficient.length - 1)
	    {
		if (i == 0)
		{
		    polynomial = polynomial + this.coefficient [i];
		}
		else if (i == 1)
		{
		    polynomial = polynomial + this.coefficient [i] + "x";
		}
		else
		{
		    polynomial = polynomial + this.coefficient [i] + "x^" + i;
		}
	    }
	    else
		if (this.coefficient [i] >= 0)
		{
		    if (i == 0)
		    {
			//if statments to change parts of a statement
			// more efficient way of spacing?
			polynomial = polynomial + " + " + this.coefficient [i];
		    }
		    else if (i == 1)
		    {
			polynomial = polynomial + " + " + this.coefficient [i] + "x";
		    }
		    else
		    {
			polynomial = polynomial + " + " + this.coefficient [i] + "x^" + i;
		    }
		}
		else
		{
		    if (i == 0)
		    {
			polynomial = polynomial + " - " + Math.abs (this.coefficient [i]);
		    }
		    else if (i == 1)
		    {
			polynomial = polynomial + " - " + Math.abs (this.coefficient [i]) + "x";
		    }
		    else
		    {
			polynomial = polynomial + " - " + Math.abs (this.coefficient [i]) + "x^" + i;
		    }
		}
		//if coefficient is 0 or degree 0 ;
	}
	return polynomial;
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
    public void get ()
    {
	Poly.c.print ("Please enter a valid INTEGER degree value for your polynomial: ");
	this.degree = Poly.c.readInt ();
	this.coefficient = new double [this.degree + 1];
	for (int i = 0 ; i < this.coefficient.length ; i++)
	{
	    Poly.c.print ("Please enter a valid DOUBLE coefficient value for your polynomial ");
	    this.coefficient [i] = Poly.c.readDouble ();
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
    public double value (double xValue)
    {
	double value = 0;
	for (int i = this.coefficient.length - 1 ; i >= 0 ; i--)
	{
	    value = value * xValue + this.coefficient [i];
	}
	return value;
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

    public Polynomial derivative ()
    {
	Polynomial derivative = new Polynomial (this.degree);
	for (int i = derivative.coefficient.length - 1 ; i >= 0 ; i--)
	{
	    derivative.coefficient [i] = this.coefficient [i+1] * (i + 1);
	}
	return derivative;
    }
    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
