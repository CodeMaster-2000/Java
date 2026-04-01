// The "Matrix" class.
/*
Author: Swethan Sivasegaran
Date: November 9 2017
Purpose: To demonstrate the capability of manipulating 2D Arrays and cloning through its application in the concept of Matrices
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.*;
import java.util.*;

// CLASS Matrix
/*
Author: Swethan Sivasegaran
Date: November 9 2017
Purpose: To showcase the potential of the Matrices class and its use of 2D Array manipulation + cloning

DATA FIELDS - None

METHODS

main - To demonstrate the functionality of the Matrices class and its potential for Maintenance in regards to its longevity
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class Matrix implements Cloneable
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: November 9 2017
    Purpose: To demonstrate the functionality of the Matrices class and its potential for Maintenance in regards to its longevity
    Input: None - the inputs from the User via Console
    Output: None - the outputs produced from each Method via Console
    */
    static Console c;

    public static void main (String[] args) throws CloneNotSupportedException
    {

    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS Matrices
/*
Author: Swethan Sivasegaran
Date: November 9 2017
Purpose: To show the capability of manipulating Matrices with the concept of 2D Arrays and cloning

DATA FIELDS

row (INT) - An INTEGER type data element representing the Array length of pointers to a DOUBLE ARRAY and acts as the rows of a Matrix
column(INT) - An INTEGER type data element representing the Array length of DOUBLE values and act as the columns of a Matrix
matrix(DOUBLE ARRAY) - A DOUBLE 2D array data element using both the INTEGER data elements (row + column) to simulate a Matrix with properties of
		       rows and columns in respect to that and it will contain DOUBLE values that are part of the Matrix.

METHODS

Constructor (with TWO PARAMETERS) - Given two INTEGER row and column parameter values, editchecks for INVALID values (defaulted to 0) and sets the INTEGER
				    type data fields (row + column) to the given para meter value. Based on the two INTEGER type data fields, initializes the DOUBLE
				    type two dimensional array to the two array lengths respectively with each element value intialized with value 0
				    
Constructor (with NO PARAMTERS) - Given NO PARAMETER values, initializes the INTEGER type (row + column) data field values to 0 and creates an empty DOUBLE 2D
				  array based on the INTEGER data fields respectively.
				  
clone - Based on the current Matrices object data fields and methods, calls the super class OBJECT method clone and creates a
	complete copy of the current matrix in a different location in RAM including all its data elements and methods. Returns
	an abstract OBJECT copy of the current matrix data information and NEEDS TO BE CASTED AS AN OBJECT OF MATRICES.
	
get - Given a CONSOLE parameter value, interacts with the user to intialize the INTEGER type data fields (row + column) and the
      2D array DOUBLE type values within the set size of the two dimensional array provided by the INTEGER type data fields.
      
print - Given a CONSOLE type parameter value and two INTEGER type co-ordinate value (xValue + yValue), creates
	a LOCAL string variable and prints the current DOUBLE 2D array in matrix format based on the x and y
	co-ordinate value provided via parameter.
	
getFromFile - Given a TEXTINPUTFILE type parameter value of a matrix file, reads the first row to initialize the INTEGER type
	      data fields (row + column) and then reads each row and column after the first to provide the newly created DOUBLE
	      2D array DOUBLE values.
	      Note: The method does not editcheck the matrix file for valid DOUBLE values or if the first row provides the same
		    values as the actual row and column values below it.
	      Note: The method only works for a matrix file that is in the format of the first row being two values that represent
		    the INTEGER type data field values (row + column) in that order and the following values being the DOUBLE 2D
		    array values themselves.
		    
columnAverage - Based on the CURRENT Matrix values, returns a new MATRIX with the same number of rows as the current matrix but with
		one column that contains element values of each row equal to the average of the element values of its respective row
		(pointer to array of DOUBLE values)in the CURRENT Matrix.
		
sameSize - Given a MATRICES type parameter value, returns a BOOLEAN value according to whether the CURRENT Matrix size
	   and the give MATRICES parameter value size are the same, essentially being equal in both the INTEGER type
	   data fields (row + column)
	   - returns TRUE if Matrices are the same size
	   - otherwise FALSE
	   
square - Based on the CURRENT Matrix, returns a BOOLEAN value according to whether the CURRENT Matrix
	 is a square matrix, essentially having equal amount of rows and columns.
	 - returns TRUE if CURRENT Matrix is a square Matrix
	 - otherwise FALSE
	 
add - Given a MATRICES type parameter value, adds the elements in the CURRENT Matrix to the elements in the MATRICES parameter
      value's Matrix of the same position ONLY if the Matrices are both the same size (see Method sameSize). Returns
      a new Matrix of the same size as the other two Matrices but with new element values based on the addition of the
      element values of the same position with the CURRENT Matrix and the parameter value Matrix.
      - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
	
sub - Given a MATRICES type parameter value, subtracts the elements in the MATRICES type parameter value's Matrix from the elements
      in the CURRENT Matrix of the same position ONLY if the Matrices are both the same size (see Method sameSize). Returns
      a new Matrix of the same size as the other two Matrices but with new element values based on the subtraction of the
      element values of the same position with the CURRENT Matrix and the parameter value Matrix.
      - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
	
minor - Given an INTEGER type row and column parameter value, returns a NEW MATRICES type object containing a new Matrix that is the exact same
	as the CURRENT Matrix (see Method clone) but the element values within the given row and column via parameter are deleted.
	- returns a MATRICES type object containing a data fields and methods exact same as the CURRENT Matrices (see Method clone) if invalid
	  INTEGER (row + column) parameter values are entered.
	  
transpose - Based on the CURRENT Matrix, returns a new MATRICES type object containing a new Matrix that is the transpose of the CURRENT MATRIX meaning
	    that its rows are the columns of the CURRENT Matrix making its columns the rows of the CURRENT Matrix.
	    
determinant - Based on the CURRENT Matrix, returns a DOUBLE type value which represents the DETERMINANT of the CURRENT Matrix.

substitute - Given an INTEGER type column value + a MATRICES type object with Matrix (rowx1), returns a new MATRICES type object containing a Matrix that has the
	     exact same elements as the CURRENT Matrix (see Method clone), but is substituted with the MATRICES type parameter value Matrix in the given column number
	     provided via parameter ONLY if the given MATRICES type parameter value has a Matrix with only 1 row, the column number is within range of the CURRENT Matrix
	     and the MATRICES type parameter value's Matrix column number is equal to the CURRENT Matrix row number.
	     - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type value's column number and the CURRENT Matrix row number are
	       not equal, if the column number is not within range of the CURRENT Matrix, or if the MATRICES type parameter value's Matrix row number is not 1.
	       
split - Given an INTEGER type column value, returns a MATRICES type object containing a Matrix that is a section of the CURRENT Matrix
	starting from the given column and going from the right (inclusive) for each row.
	- returns a MATRICES type object that is an EXACT copy of the CURRENT Matrix ONLY if an INVALID column number is entered
	
concatenate - Given a MATRICES type parameter value, returns a MATRICES type object combining the elements of the CURRENT Matrix and the MATRICES
	      parameter value Matrix ONLY if they contain the same number of rows by adding the elements of the MATRICES parameter value Matrix
	      onto the end of the CURRENT Matrix.
	      - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type parameter value and the CURRENT Matrix
		do not contain the same number of rows.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Matrices
{
    //DATA FIELDS
    protected int row = 0;
    protected int column = 0;
    protected double[] [] matrix = null;
    
    // Constructor (with TWO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: November 9 2017
    Purpose: Given two INTEGER row and column parameter values, editchecks for INVALID values (defaulted to 0) and sets the INTEGER
	     type data fields (row + column) to the given para meter value. Based on the two INTEGER type data fields, initializes the DOUBLE
	     type two dimensional array to the two array lengths respectively with each element value intialized with value 0
    Input: An INTEGER type row value and an INTEGER type column value
    Output: None - initializes the INTEGER type row and column value + the DOUBLE type 2D array to a set size of values of 0.
    */
    public Matrices (int row, int column)
    {
	if (row < 0)
	    this.row = 0;
	else
	    this.row = row;
	if (column < 0)
	    this.column = 0;
	else
	    this.column = column;
	this.matrix = new double [this.row] [this.column];
    }


    // ======================================================================================================
    // Constructor (with NO PARAMTERS)

    /*
    Author: Swethan Sivasegaran
    Date: November 9 2017
    Purpose: Given NO PARAMETER values, initializes the INTEGER type (row + column) data field values to 0 and creates an empty DOUBLE 2D
	     array based on the INTEGER data fields respectively.
    Input: None
    Output: None - initializes the INTEGER type data fields + the DOUBLE 2D array data field values
    */

    public Matrices ()
    {
	this.row = 0;
	this.column = 0;
	this.matrix = new double [this.row] [this.column];
    }


    // -------------------------------------------------------------------------------------------------------
    // clone

    /*
    Author: Swethan Sivasegaran
    Date: November 9 2017
    Purpose: Based on the current Matrices object data fields and methods, calls the super class OBJECT method clone and creates a
	     complete copy of the current matrix in a different location in RAM including all its data elements and methods. Returns
	     an abstract OBJECT copy of the current matrix data information and NEEDS TO BE CASTED AS AN OBJECT OF MATRICES.
    Input: None
    Output: An abstract OBJECT copy of the current matrix data information in a different location in RAM and NEEDS TO BE CASTED AS AN
	    OBJECT OF MATRICES TO USE THE CLONE.
    */
    public Object clone () throws CloneNotSupportedException
    {
	Matrices newMatrix = (Matrices) super.clone ();
	newMatrix.matrix = new double [newMatrix.row] [newMatrix.column];
	for (int i = 0 ; i < newMatrix.matrix.length ; i++)
	{
	    newMatrix.matrix [i] = (double[]) this.matrix [i].clone ();
	}
	return newMatrix;
    }


    // ======================================================================================================
    // get

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a CONSOLE parameter value, interacts with the user to intialize the INTEGER type data fields (row + column) and the
	     2D array DOUBLE type values within the set size of the two dimensional array provided by the INTEGER type data fields.
    Input: A CONSOLE parameter value
    Output: None - initializes the INTEGER type data fields (row + column) and the DOUBLE 2D array size + its DOUBLE type element values.
    */
    public void get (Console c)
    {
	c.print ("Please enter an INTEGER row number: ");
	this.row = c.readInt ();
	c.print ("Please enter an INTEGER column number: ");
	this.column = c.readInt ();
	c.print ("\n\n");
	this.matrix = new double [this.row] [this.column];
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = 0 ; a < this.column ; a++)
	    {
		c.println ("Please enter a DOUBLE value in the Matrix: ");
		this.matrix [i] [a] = c.readDouble ();
	    }
	}
    }


    // -------------------------------------------------------------------------------------------------------

    // print

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a CONSOLE type parameter value and two INTEGER type co-ordinate value (xValue + yValue), creates
	     a LOCAL string variable and prints the current DOUBLE 2D array in matrix format based on the x and y
	     co-ordinate value provided via parameter.
    Input: A CONSOLE type parameter value and two INTEGER type co-ordinate value (x and y)
    Output: None - prints the current DOUBLE 2D array in matrix format on the given CONSOLE starting from the INTEGER x and y
	    co-ordinate values provided via parameter.
    */
    public void print (Console c, int xValue, int yValue)
    {
	String matrix = "";
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = 0 ; a < this.column ; a++)
	    {
		matrix = matrix + this.matrix [i] [a] + " ";
	    }
	    c.drawString (matrix, xValue, yValue);
	    yValue = yValue + 20;
	    matrix = "";
	}
    }


    // ======================================================================================================

    // getFromFile

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a TEXTINPUTFILE type parameter value of a matrix file, reads the first row to initialize the INTEGER type
	     data fields (row + column) and then reads each row and column after the first to provide the newly created DOUBLE
	     2D array DOUBLE values.
	     Note: The method does not editcheck the matrix file for valid DOUBLE values or if the first row provides the same
		   values as the actual row and column values below it.
	     Note: The method only works for a matrix file that is in the format of the first row being two values that represent
		   the INTEGER type data field values (row + column) in that order and the following values being the DOUBLE 2D
		   array values themselves.
    Input: A TEXTINPUTFILE type parameter value containing a matrix file
    Output: None - intializes the INTEGER type data fields (row + column) and the DOUBLE 2D array data fields DOUBLE type values and size
	    all based on the data provided by the TEXTINPUTFILE of a matrix file.
    */
    public void getFromFile (TextInputFile inFile)
    {
	String matrix = "";
	StringTokenizer column;
	String[] row;
	while (!inFile.eof ())
	{
	    matrix = matrix + inFile.readLine () + "\n";
	}
	row = matrix.split ("\n");
	column = new StringTokenizer (row [0]);
	this.row = Integer.parseInt (column.nextToken ());
	this.column = Integer.parseInt (column.nextToken ());
	this.matrix = new double [this.row] [this.column];
	for (int i = 0 ; i < this.row ; i++)
	{
	    column = new StringTokenizer (row [i + 1], " ");
	    for (int a = 0 ; a < this.column ; a++)
	    {
		this.matrix [i] [a] = Double.parseDouble (column.nextToken ());
	    }
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // columnAverage

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Based on the CURRENT Matrix values, returns a new MATRIX with the same number of rows as the current matrix but with
	     one column that contains element values of each row equal to the average of the element values of its respective row
	     (pointer to array of DOUBLE values)in the CURRENT Matrix.
    Input: None
    Output: Returns a new MATRICES type object with same number of rows but with one column that contains the element values for each row representing
	    the average of the element values of its respective row (pointer to array of DOUBLE values) in the CURRENT Matrix.
    */
    public Matrices columnAverage ()
    {
	double average = 0;
	Matrices newMatrix = new Matrices (this.row, 1);
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = this.column - 1 ; a >= 0 ; a--)
	    {
		average = average + this.matrix [i] [a];
	    }
	    average = average / this.column;
	    newMatrix.matrix [i] [0] = average;
	    average = 0;
	}
	return newMatrix;
    }


    // ======================================================================================================
    // sameSize

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a MATRICES type parameter value, returns a BOOLEAN value according to whether the CURRENT Matrix size
	     and the give MATRICES parameter value size are the same, essentially being equal in both the INTEGER type
	     data fields (row + column)
	     - returns TRUE if Matrices are the same size
	     - otherwise FALSE
    Input: A MATRICES type value
    Output: A BOOLEAN value according to whether the Matrix of the parameter value and the CURRENT Matrix have equal INTEGER type
	    data fields (row + column) meaning they are the same size matrix.
	    - returns TRUE if Matrices are the same size
	    - otherwise FALSE
    */

    public boolean sameSize (Matrices secondMatrix)
    {
	boolean size = false;
	if (this.row == secondMatrix.row && this.column == secondMatrix.column)
	    size = true;
	return size;
    }


    // -------------------------------------------------------------------------------------------------------
    // square

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Based on the CURRENT Matrix, returns a BOOLEAN value according to whether the CURRENT Matrix
	     is a square matrix, essentially having equal amount of rows and columns.
	     - returns TRUE if CURRENT Matrix is a square Matrix
	     - otherwise FALSE
    Input: None
    Output: A BOOLEAN type value according to whether the CURRENT Matrix is a square matrix (INTEGER type row data field
	    is equal to the INTEGER type column data field).
	    - returns TRUE if CURRENT Matrix is a square Matrix
	    - otherwise FALSE
    */

    public boolean square ()
    {
	boolean square = false;
	if (this.row == this.column)
	    square = true;
	return square;
    }


    // ======================================================================================================
    // add

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a MATRICES type parameter value, adds the elements in the CURRENT Matrix to the elements in the MATRICES parameter
	     value's Matrix of the same position ONLY if the Matrices are both the same size (see Method sameSize). Returns
	     a new Matrix of the same size as the other two Matrices but with new element values based on the addition of the
	     element values of the same position with the CURRENT Matrix and the parameter value Matrix.
	     - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	       defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
    Input: A MATRICES type parameter value
    Output: Returns a new MATRICES type object containing new element values corresponding to the addition of the element values of same
	    position within the CURRENT Matrix and the given parameter value Matrix only if they are the same size (see Method sameSize).
	    - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	      defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
    */

    public Matrices add (Matrices secondMatrix)
    {
	Matrices newMatrix = new Matrices (this.row, this.column);
	if (sameSize (secondMatrix) == true)
	{
	    for (int i = 0 ; i < this.row ; i++)
	    {
		for (int a = 0 ; a < this.column ; a++)
		{
		    newMatrix.matrix [i] [a] = this.matrix [i] [a] + secondMatrix.matrix [i] [a];
		}
	    }
	}
	return newMatrix;
    }


    // -------------------------------------------------------------------------------------------------------
    // sub

    /*
    Author: Swethan Sivasegaran
    Date: November 10 2017
    Purpose: Given a MATRICES type parameter value, subtracts the elements in the MATRICES type parameter value's Matrix from the elements
	     in the CURRENT Matrix of the same position ONLY if the Matrices are both the same size (see Method sameSize). Returns
	     a new Matrix of the same size as the other two Matrices but with new element values based on the subtraction of the
	     element values of the same position with the CURRENT Matrix and the parameter value Matrix.
	     - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	       defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
    Input: A MATRICES type parameter value
    Output: Returns a new MATRICES type object containing new element values corresponding to the subtraction of the element values of same
	    position within the given parameter value Matrix from the CURRENT Matrix only if they are the same size (see Method sameSize).
	    - returns the a MATRICES type object containing an Matrix with same size as CURRENT Matrix but with all element values
	      defaulted to 0 if the MATRICES type parameter value is not the same size as the CURRENT Matrix.
    */

    public Matrices sub (Matrices secondMatrix)
    {
	Matrices newMatrix = new Matrices (this.row, this.column);
	if (sameSize (secondMatrix) == true)
	{
	    for (int i = 0 ; i < this.row ; i++)
	    {
		for (int a = 0 ; a < this.column ; a++)
		{
		    newMatrix.matrix [i] [a] = this.matrix [i] [a] - secondMatrix.matrix [i] [a];
		}
	    }
	}
	return newMatrix;
    }


    // ======================================================================================================
    // minor

    /*
    Author: Swethan Sivasegaran
    Date: November 11 2017
    Purpose: Given an INTEGER type row and column parameter value, returns a NEW MATRICES type object containing a new Matrix that is the exact same
	     as the CURRENT Matrix (see Method clone) but the element values within the given row and column via parameter are deleted.
	     - returns a MATRICES type object containing a data fields and methods exact same as the CURRENT Matrices (see Method clone) if invalid
	       INTEGER (row + column) parameter values are entered.
    Input: An INTEGER row value and an INTEGER column value
    Output: A MATRICES type object containing a new Matrix exact same as the CURRENT Matrix (see Method clone) but the element values within the given
	    row and column via parameter are deleted.
	    - returns a MATRICES type object containing a data fields and methods exact same as the CURRENT Matrices (see Method clone) if invalid
	      INTEGER (row + column) parameter values are entered.
    */

    public Matrices minor (int row, int column) throws CloneNotSupportedException
    {
	int rowIndex = 0;
	int colIndex = 0;
	Matrices newMatrix;
	if (row < this.row && row >= 0 && column < this.column && column >= 0)
	{
	    newMatrix = new Matrices (this.row - 1, this.column - 1);
	    for (int i = 0 ; i < this.row ; i++)
	    {
		if (i != row)
		{
		    for (int a = 0 ; a < this.column ; a++)
		    {
			if (a != column)
			{
			    newMatrix.matrix [rowIndex] [colIndex] = this.matrix [i] [a];
			    colIndex = colIndex + 1;
			}
		    }
		    colIndex = 0;
		    rowIndex = rowIndex + 1;
		}
	    }
	}
	else
	    newMatrix = (Matrices) this.clone ();
	return newMatrix;
    }


    // -------------------------------------------------------------------------------------------------------
    // transpose

    /*
    Author: Swethan Sivasegaran
    Date: November 11 2017
    Purpose: Based on the CURRENT Matrix, returns a new MATRICES type object containing a new Matrix that is the transpose of the CURRENT MATRIX meaning
	     that its rows are the columns of the CURRENT Matrix making its columns the rows of the CURRENT Matrix.
    Input: None
    Output: A MATRICES type object containing a new Matrix which is the transpose of the CURRENT Matrix meaning that its rows are the columns of the
	    CURRENT Matrix making its columns the rows of the CURRENT Matrix.
    */
    public Matrices transpose ()
    {
	Matrices newMatrix = new Matrices (this.column, this.row);
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = 0 ; a < this.column ; a++)
	    {
		newMatrix.matrix [a] [i] = this.matrix [i] [a];
	    }
	}
	return newMatrix;
    }


    // ======================================================================================================
    // determinant

    /*
    Author: Swethan Sivasegaran
    Date: November 11 2017
    Purpose: Based on the CURRENT Matrix, returns a DOUBLE type value which represents the DETERMINANT of the CURRENT Matrix.
    Input: None
    Output: A DOUBLE type value representing the DETERMINANT of the CURRENT Matrix
    */

    public double determinant () throws CloneNotSupportedException
    {
	int sign = 1;
	double determinant = 0;
	double value = 0;
	if (this.square () == true)
	{
	    for (int i = 0 ; i < this.column ; i++)
	    {
		if (this.column > 2)
		    determinant = this.matrix [0] [i] * this.minor (0, i).determinant ();
		else if (this.column == 2)
		    value = this.matrix [0] [0] * this.matrix [1] [1] - this.matrix [0] [1] * this.matrix [1] [0];
		else
		    value = this.matrix [0] [0];
		value = value + determinant * sign;
		sign = sign * -1;
	    }
	}
	return value;
    }


    // -------------------------------------------------------------------------------------------------------
    // substitute

    /*
    Author: Swethan Sivasegaran
    Date: November 14 2017
    Purpose: Given an INTEGER type column value + a MATRICES type object with Matrix (rowx1), returns a new MATRICES type object containing a Matrix that has the
	     exact same elements as the CURRENT Matrix (see Method clone), but is substituted with the MATRICES type parameter value Matrix in the given column number
	     provided via parameter ONLY if the given MATRICES type parameter value has a Matrix with only 1 row, the column number is within range of the CURRENT Matrix
	     and the MATRICES type parameter value's Matrix column number is equal to the CURRENT Matrix row number.
	     - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type value's column number and the CURRENT Matrix row number are
	       not equal, if the column number is not within range of the CURRENT Matrix, or if the MATRICES type parameter value's Matrix row number is not 1.
    Input: An INTEGER type column value + MATRICES type value
    Output: A MATRICES type object containing a Matrix that has the exact same elements as the CURRENT Matrix (see Method clone), but is substituted with the MATRICEStype
	    parameter value Matrix in the given column number provided via parameter. The given MATRICES type parameter value must have a Matrix (with only 1 row).
	    - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type value's column number and the CURRENT Matrix row number are
	      not equal, if the column number is not within range of the CURRENT Matrix, or if the MATRICES type parameter value's Matrix row number is not 1.
    */
    public Matrices substitute (int column, Matrices secondMatrix) throws CloneNotSupportedException
    {
	int index = 0;
	Matrices newMatrix = (Matrices) this.clone ();
	if (secondMatrix.row == 1 && secondMatrix.column == this.row && column >= 0 && column < this.column)
	{
	    for (int i = 0 ; i < newMatrix.row ; i++)
	    {
		for (int a = 0 ; a < newMatrix.row ; i++)
		{
		    if (a == column)
		    {
			newMatrix.matrix [i] [a] = secondMatrix.matrix [0] [index];
			index = index + 1;
		    }
		}
	    }
	}
	return newMatrix;
    }


    // ======================================================================================================
    // split

    /*
    Author: Swethan Sivasegaran
    Date: November 14 2017
    Purpose: Given an INTEGER type column value, returns a MATRICES type object containing a Matrix that is a section of the CURRENT Matrix
	     starting from the given column and going from the right (inclusive) for each row.
	     - returns a MATRICES type object that is an EXACT copy of the CURRENT Matrix ONLY if an INVALID column number is entered
    Input: An INTEGER type column value
    Output: A MATRICES type object containing a Matrix that is a section of the CURRENT Matrix starting from the given column via parameter
	    and including all columns from the right for each row (inclusive).
	    - returns a MATRICES type object that is an EXACT copy of the CURRENT Matrix ONLY if an INVALID column number is entered
    */
    public Matrices split (int column)throws CloneNotSupportedException
    {
	Matrices newMatrix;
	if (column >= 0 && column < this.column)
	{
	    newMatrix = new Matrices (this.row, this.column - column);
	    for (int i = 0 ; i < this.row ; i++)
	    {
		for (int a = column ; a < newMatrix.column ; a++)
		{
		    newMatrix.matrix [i] [a] = this.matrix [i] [a];
		}
	    }
	}
	else
	    newMatrix = (Matrices)this.clone();
	return newMatrix;
    }


    // -------------------------------------------------------------------------------------------------------
    // Concatenate

    /*
    Author: Swethan Sivasegaran
    Date: November 14 2017
    Purpose: Given a MATRICES type parameter value, returns a MATRICES type object combining the elements of the CURRENT Matrix and the MATRICES
	     parameter value Matrix ONLY if they contain the same number of rows by adding the elements of the MATRICES parameter value Matrix
	     onto the end of the CURRENT Matrix.
	     - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type parameter value and the CURRENT Matrix
	       do not contain the same number of rows.
    Input: A MATRICES type value
    Output: A MATRICES type object that contains the elements of the CURRENT Matrix and the MATRICES parameter value Matrix ONLY
	    if they contain the same number of rows by adding the elements of the MATRICES parameter value Matrix onto the end of the CURRENT
	    Matrix.
	    - returns a MATRICES type object that has an EXACT copy of the CURRENT MATRIX if the MATRICES type parameter value and the CURRENT Matrix
	      do not contain the same number of rows.
    */
    public Matrices concatenate (Matrices secondMatrix) throws CloneNotSupportedException
    {
	Matrices newMatrix;
	if (this.row == secondMatrix.row)
	{
	    newMatrix = new Matrices (this.row, this.column + secondMatrix.column);
	    for (int i = 0 ; i < newMatrix.row ; i++)
	    {
		for (int a = 0 ; a < newMatrix.column ; a++)
		{
		    if (a < this.column)
			newMatrix.matrix [i] [a] = this.matrix [i] [a];
		    else
			newMatrix.matrix [i] [a] = secondMatrix.matrix [i] [a - this.column];
		}
	    }
	}
	else
	    newMatrix = (Matrices) this.clone ();
	return newMatrix;
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
//testing
//main
//polishing
//1   1 position check - creating matrix, split, minor, substitute
