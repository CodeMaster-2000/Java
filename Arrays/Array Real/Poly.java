// The "Poly" class.
/*
Author: Swethan Sivasegaran
Date: October 12 2017
Purpose: To demonstrate the capabilties of applying the usage of Arrays in problems and in this case, we showcased the ability to manipulate
	 arrays and its index in conjunction with its individual parts (coefficient)
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS POLY
/*
Author: Swethan Sivasegaran
Date: October 12 2017
Purpose: To demonstrate the expansive abilities of manipulating Polynomial functions through the the creative use of Arrays and its index

DATA FIELDS - None

METHODS

main -  To demonstrate the functionality and capabilities of the POLYNOMIAL CLASS through methods with its input and outputs
	via Console.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class Poly
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: To demonstrate the functionality and capabilities of the POLYNOMIAL CLASS through methods with its input and outputs
	     via Console.
    Input: None - input recieved from the user for creating a Polynomial via Console
    Output: the individual outputs of each method in the POLYNOMIAL CLASS via Console
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();

	//Initialization
	int repeat = 0;
	double value = 0;

	//Process
	while (repeat == 0)
	{
	    c.clear ();
	    Polynomial polynomial = new Polynomial ();
	    c.setTextColor (Color.red);
	    c.println ("========POLYNOMIAL TESTING========");
	    c.setTextColor (Color.blue);
	    polynomial.get ();
	    c.setTextColor (Color.red);
	    c.print ("\nPolynomial Function");
	    c.setTextColor (Color.black);
	    c.print ("\n\nPolynomial: " + polynomial.toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter an x co-ordinate value for your polynomial function: ");
	    value = c.readDouble ();
	    c.setTextColor (Color.black);
	    c.print ("\nValue of function at x = " + value + ": " + polynomial.value (value));
	    c.setTextColor (Color.red);
	    c.print ("\n\nDerivative");
	    c.setTextColor (Color.black);
	    c.print ("\n\nDerivative: " + polynomial.derivative ().toString ());
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter an x co-ordinate value for the derivative of the function: ");
	    value = c.readDouble ();
	    c.setTextColor (Color.black);
	    c.print ("\nValue of derivative at x = " + value + ": " + polynomial.derivative ().value (value));
	    c.setTextColor (Color.blue);
	    c.print ("\nPlease enter a 0 (to restart program) or any other key(to end program): ");
	    repeat = c.readInt ();
	}
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
// CLASS POLYNOMIAL
/*
Author: Swethan Sivasegaran
Date: October 12 2017
Purpose: To demonstrate the manipulation of a POLYNOMIAL whose information are stored via data fields and Arrays and can be showcased to demonstrate
	 its functionality via its varius methods

DATA FIELDS

coefficient (DOUBLE ARRAY) - a DOUBLE ARRAY type data element representing all the COEFFICIENTS of each Polynomial term based on its unique degree which is respective to its
			     index (first index being the lowest degree and increasing degree by 1 at each consecutive index)
degree (INT) - an INTEGER type data element representing the DEGREE of the Polynomial which is the highest degree of all the polynomial terms within it

METHODS

Polynomial (Constructor with one INTEGER type parameter) -  Given an INTEGER type degree parameter value, intializes the INTEGER type DEGREE data element to the given value and
							    sets the DOUBLE ARRAY type data element (COEFFICIENT) to a size corresponding to the number of terms in a polynomial
							    with given degree
							    - each element corresponding to the coefficient of each term with unique degree is defaulted to 0 intially

Polynomial (Constructor with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER type degree data element to 0 and creates an EMPTY DOUBLE ARRAY type data element
					      (COEFFICIENT)

toString - Based on the DOUBLE ARRAY type COEFFICIENT data element, returns a STRING representation of the Polynomial with the coefficients
	   stored in the DOUBLE ARRAY type data element and its respective degree relating to its index.
	   - Considers to convert 0, 1, and - 1 to proper Polynomial form
	   - Considers positive and negative signs 
	   - Considers empty arrays

get -  Based on the INTEGER type degree and the DOUBLE type coefficient values inputted by the user via Console, sets the current INTEGER type degree data
       element to the inputted value in addition to setting the DOUBLE type coefficient values in the array respective to its index from lowest degree to highest.

value -  Given a DOUBLE type x co-ordinate value, returns a DOUBLE type value of the polynomial or rather the y co-ordinate based on the x value and the
	 DOUBLE type coefficients stored in the DOUBLE ARRAY type data element [COEFFICIENT] respective of its index.

derivative -  Based on the DOUBLE ARRAY type coefficient data element and the INTEGER type degree data element of the CURRENT POLYNOMIAL, returns a POLYNOMIAL type OBJECT
	      that would represent as the derivative of the CURRENT POLYNOMIAL

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class Polynomial
{

    // DATA FIELDS
    protected double[] coefficient;
    protected int degree;

    // Polynomial (Constructor with one INTEGER type parameter)

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: Given an INTEGER type degree parameter value, intializes the INTEGER type DEGREE data element to the given value and
	     sets the DOUBLE ARRAY type data element (COEFFICIENT) to a size corresponding to the number of terms in a polynomial
	     with given degree
	     - each element corresponding to the coefficient of each term with unique degree is defaulted to 0 intially
    Input: An INTEGER type parameter value representing the degree of the POLYNOMIAL OBJECT
    Output: None - initializes the INTEGER type degree data element to the INTEGER type degree parameter value and creates a DOUBLE ARRAY
	    type data element (COEFFICIENT) with array size representing the number of Polynomial terms of set degree
	    - defaulted value for all the coefficient of each unique degree term is 0
    */
    public Polynomial (int degree)
    {
	this.coefficient = new double [degree + 1];
	this.degree = degree;
    }
    // ======================================================================================================
    // Polynomial (Constructor with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: Given NO PARAMETERS, sets the INTEGER type degree data element to 0 and creates an EMPTY DOUBLE ARRAY type data element
	     (COEFFICIENT)
    Input: None
    Output: None - just sets the intial values for the degree data element to 0 and sets the DOUBLE ARRAY type data element COEFFICIENT
	    to an EMPTY ARRAY
    */
    public Polynomial ()
    {
	this (0);
    }
    // -------------------------------------------------------------------------------------------------------
    // toString

    /*
    Author: Swethan Sivasegaran
    Date: October 12 2017
    Purpose: Based on the DOUBLE ARRAY type COEFFICIENT data element, returns a STRING representation of the Polynomial with the coefficients
	     stored in the DOUBLE ARRAY type data element and its respective degree relating to its index.
	     - Considers to convert 0, 1, and - 1 to proper Polynomial form
	     - Considers positive and negative signs 
	     - Considers empty arrays
    Input: None - based on the coefficients stored in the DOUBLE ARRAY data element[COEFFICIENT]
    Output: A STRING representation of the Polynomial corresponding to its respective degree and coefficients stored in the DOUBLE ARRAY data element
	     - Considers to convert 0, 1, and - 1 to proper Polynomial form
	     - Considers positive and negative signs 
	     - Considers empty arrays
    */
    public String toString ()
    {
	//Initialization
	String polynomial = "";
	String coeff = "";
	//Process
	if (this.coefficient.length > 0)
	{
	    for (int i = this.coefficient.length - 1 ; i >= 0 ; i--)
	    {
		if (this.coefficient [i] != 1 && this.coefficient [i] != -1)
		{
		    if (i == this.coefficient.length - 1)
			coeff = this.coefficient[i] + "";
		    else
			coeff = Math.abs(this.coefficient [i]) + "";
		}
		else
		{
		    if (this.coefficient [i] == 1)
			coeff = "";
		    else
		    {
			if (i == this.coefficient.length -1)
			{
			    if (i == 0)
				coeff = this.coefficient[i] + "";
			    else
				coeff = " - ";
			}
			else
			    if (i == 0)
				coeff = Math.abs(this.coefficient[i]) + "";
			    else
				coeff = "";
		    }
		}
		if (this.coefficient [i] != 0)
		{
		    if (i == this.coefficient.length - 1)
		    {
			if (i == 0)
			    polynomial = polynomial + coeff;
			else if (i == 1)
			    polynomial = polynomial + coeff + "x";
			else
			    polynomial = polynomial + coeff + "x^" + i;
		    }
		    else
		    {
			if (this.coefficient [i] >= 0)
			{
			    if (i == 0)
				polynomial = polynomial + " + " + coeff;
			    else if (i == 1)
				polynomial = polynomial + " + " + coeff + "x";
			    else
				polynomial = polynomial + " + " + coeff + "x^" + i;
			}
			else
			{
			    if (i == 0)
				polynomial = polynomial + " - " + coeff;
			    else if (i == 1)
				polynomial = polynomial + " - " + coeff + "x";
			    else
				polynomial = polynomial + " - " + coeff + "x^" + i;
			}
		    }
		}
	    }
	}
	else
	    polynomial = polynomial + "0.0";
	return polynomial;
    }
    // ======================================================================================================
    // get

    /*
    Author: Swethan Sivasegaran
    Date: October 13 2017
    Purpose: Based on the INTEGER type degree and the DOUBLE type coefficient values inputted by the user via Console, sets the current INTEGER type degree data
	     element to the inputted value in addition to setting the DOUBLE type coefficient values in the array respective to its index from lowest degree to highest.
    Input: An INTEGER type degree value for the Polynomial and its respective DOUBLE type coefficient values for each Polynomial term in the array inputted via
	   Console by the user
    Output: None - sets the values for the INTEGER type degree and its DOUBLE type coefficients for its polynomial terms in the array
    */
    public void get ()
    {
	//Initialization
	Poly.c.print ("Please enter a valid INTEGER degree value for your polynomial: ");
	this.degree = Poly.c.readInt ();
	while (this.degree < 0)
	{
	    Poly.c.print ("\nYou have entered an INVALID degree value.");
	    Poly.c.print ("\nPlease re - enter an INTEGER degree value: ");
	    this.degree = Poly.c.readInt ();
	}
	this.coefficient = new double [this.degree + 1];
	Poly.c.print ("\n");
	//editcheck for valid values
	//Process - getting Elemental values
	for (int i = 0 ; i < this.coefficient.length ; i++)
	{
	    Poly.c.print ("Please enter a valid DOUBLE coefficient value for your polynomial ");
	    this.coefficient [i] = Poly.c.readDouble ();
	}
    }
    // -------------------------------------------------------------------------------------------------------
    // value

    /*
    Author: Swethan Sivasegaran
    Date: October 13 2017
    Purpose: Given a DOUBLE type x co-ordinate value, returns a DOUBLE type value of the polynomial or rather the y co-ordinate based on the x value and the
	     DOUBLE type coefficients stored in the DOUBLE ARRAY type data element [COEFFICIENT] respective of its index.
    Input: A DOUBLE type x co-ordinate value for the polynomial
    Output: A DOUBLE type y value or rather the value of the polynomial corresponding to the polynomial's coefficient terms and its x Value provided via parameter
    */
    public double value (double xValue)
    {
	//Initialization
	double value = 0;

	//Process
	for (int i = this.coefficient.length - 1 ; i >= 0 ; i--)
	{
	    value = value * xValue + this.coefficient [i];
	}
	return value;
    }
    // ======================================================================================================
    // derivative

    /*
    Author: Swethan Sivasegaran
    Date: October 13 2017
    Purpose: Based on the DOUBLE ARRAY type coefficient data element and the INTEGER type degree data element of the CURRENT POLYNOMIAL, returns a POLYNOMIAL type OBJECT
	     that would represent as the derivative of the CURRENT POLYNOMIAL
    Input: None - based on the CURRENT POLYNOMIAL information including its INTEGER type degree and DOUBLE ARRAY type coefficient data elements which contains the respective
	   coefficients of each unique polynomial term.
    Output: returns a POLYNOMIAL type OBJECT that would be the derivative of the CURRENT POLYNOMIAL based on the CURRENT POLYNOMIAL coefficients stored in the DOUBLE ARRAY type
	    coefficient data element and its respective degree according to index.
    */

    public Polynomial derivative ()
    {
	//Initialization
	Polynomial derivative = new Polynomial (this.degree - 1);

	//Process
	for (int i = derivative.coefficient.length - 1 ; i >= 0 ; i--)
	{
	    derivative.coefficient [i] = this.coefficient [i + 1] * (i + 1);
	}
	return derivative;
    }
    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
