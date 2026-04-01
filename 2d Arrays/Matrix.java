// The "Matrix" class.
/*
Author: Swethan Sivasegaran
Date: 
Purpose: 
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.*;
import java.util.*;

// CLASS Matrix
/*
Author: Swethan Sivasegaran
Date: 
Purpose: 

DATA FIELDS - None

METHODS

main - 
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class Matrix implements Cloneable
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    static Console c;          

    public static void main (String[] args)throws CloneNotSupportedException
    {
	c = new Console ();
	Matrices test = new Matrices ();
	test.get(c);
	Font bruh = new Font ("Arial", Font.BOLD, 12);
	c.setFont(bruh);
	c.print("Determinant: " + test.determinant());
	
    } 
    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS Matrices
/*
Author: Swethan Sivasegaran
Date: 
Purpose: 

DATA FIELDS

matrix(DOUBLE ARRAY) - 
row (INT) - 
column(INT) - 

METHODS

Constructor (with TWO PARAMETERS) - 
Constructor (with NO PARAMTERS) - 
clone - 
get - 
print - 
getFromFile - 
columnAverage - 
sameSize - 
square - 
add - 
sub - 
minor - 
transpose - 
determinant - 
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Matrices
{
    protected double[] [] matrix = null;
    protected int row = 0;
    protected int column = 0;
    // Constructor (with TWO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
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
    Date: 
    Purpose:
    Input: 
    Output: 
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
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public Object clone() throws CloneNotSupportedException
    {
	Matrices newMatrix = (Matrices) super.clone();
	newMatrix.matrix = new double [newMatrix.row][newMatrix.column];
	for (int i = 0; i < newMatrix.matrix.length; i ++)
	{
	    newMatrix.matrix[i] = (double[])this.matrix[i].clone();
	}
	return newMatrix;
    }
    // ======================================================================================================
    // get

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */    
    public void get (Console c)
    {
	c.println ("Please enter an INTEGER row number: ");
	this.row = c.readInt ();
	c.println ("Please enter an INTEGER column number: ");
	this.column = c.readInt ();
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
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public void print (Console c, int xValue, int yValue)
    {
	String matrix = "";
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = 0 ; a < this.column ; a++)
	    {
		matrix = matrix + this.matrix [i][a] + " ";
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
    Date:
    Purpose:
    Input: 
    Output: 
    */
    public void getFromFile(TextInputFile inFile)
    {
	String matrix = "";
	StringTokenizer column;
	String [] row;
	while (inFile.eof())
	{
	    matrix = matrix + inFile.readLine();
	}
	row = matrix.split("\n");
	this.row = row.length;
	this.matrix = new double [this.row][];
	for (int i = 0; i < this.row; i++)
	{
	    column = new StringTokenizer (row[i]);
	    this.column = column.countTokens();
	    this.matrix[i] = new double [this.column];
	    for (int a = 0; a < this.column; a ++)
	    {
		this.matrix[i][a] = Double.parseDouble(column.nextToken());
	    }
	}
	
    }
    // -------------------------------------------------------------------------------------------------------
    // columnAverage

    /*
    Author: Swethan Sivasegaran
    Date:
    Purpose: 
    Input: 
    Output: 
    */
    public Matrices columnAverage ()
    {
	double average = 0;
	Matrices newMatrix = new Matrices (this.row,1);
	for (int i = 0 ; i < this.row ; i++)
	{
	    for (int a = this.column- 1; a >= 0 ; a--)
	    {
		average = average + this.matrix [i][a];
	    }
	    average = average / this.column;
	    newMatrix.matrix [i][0] = average;
	    average = 0;
	}
	return newMatrix;
    }
    // ======================================================================================================
    // sameSize

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output:
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
    Date: 
    Purpose: 
    Input: 
    Output: 
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
    Date: 
    Purpose: 
    Input: 
    Output: 
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
    Date: 
    Purpose: 
    Input: 
    Output: 
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
    Date: 
    Purpose: 
    Input: 
    Output: 
    */

    public Matrices minor (int row, int column)throws CloneNotSupportedException
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
			newMatrix.matrix [rowIndex][colIndex] = this.matrix [i] [a];
			colIndex = colIndex + 1;
		    }
		}
		colIndex = 0;
		rowIndex = rowIndex + 1;
	    }
	}
	}
	else
	    newMatrix = (Matrices)this.clone();
	return newMatrix;
    }
    // -------------------------------------------------------------------------------------------------------
    // transpose

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public Matrices transpose()
    {
	Matrices newMatrix = new Matrices(this.column, this.row);
	for (int i = 0; i < this.row; i ++)
	{
	    for (int a = 0; a < this.column; a++)
	    {
		newMatrix.matrix[a][i] = this.matrix[i][a];
	    }
	}
	return newMatrix;
    }
    // ======================================================================================================
    // determinant

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    
    public double determinant()throws CloneNotSupportedException
    {
	int sign = 1;
	double determinant = 0;
	double value = 0;
	if (this.square() == true)
	{
	    for (int i = 0; i < this.row; i++)
	    {
		if (this.row > 2)
		    determinant = this.matrix[0][i] * this.minor(0,i).determinant();
		else if (this.row == 2)
		    value = this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
		else
		    value = this.matrix[0][0];
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
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public Matrices substitute (int column, Matrices secondMatrix)throws CloneNotSupportedException
    {
	//only if the given column and current column are equal
	int index = 0;
	Matrices newMatrix = (Matrices)this.clone();
	for (int i = 0; i < newMatrix.row; i++)
	{
	    for (int a = 0; a < newMatrix.row; i++)
	    {
		if (a == column)
		{
		    newMatrix.matrix [i][a] = secondMatrix.matrix[0][index];
		    index = index + 1;
		}
	    }
	}
	return newMatrix;
    }
    // ======================================================================================================
    // split

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public Matrices split(int column)
    {
	Matrices newMatrix = new Matrices (this.row, this.column - column);
	for (int i = 0; i < this.row; i++)
	{
	    for (int a = column; a < newMatrix.column; a++)
	    {
		newMatrix.matrix[i][a] = this.matrix[i][a];
	    }
	}
	return newMatrix;
    }
    // -------------------------------------------------------------------------------------------------------
    // Concatenate

    /*
    Author: Swethan Sivasegaran
    Date: 
    Purpose: 
    Input: 
    Output: 
    */
    public Matrices concatenate(Matrices secondMatrix)
    {
	Matrices newMatrix = new Matrices (this.row, this.column + secondMatrix.column);
	for (int i = 0; i < newMatrix.row; i++)
	{
	    for (int a = 0; a < newMatrix.column; a ++)
	    {
		if (a < this.column)
		    newMatrix.matrix[i][a] = this.matrix[i][a];
		else
		    newMatrix.matrix[i][a] = secondMatrix.matrix[i][a - this.column];
	    }
	}
	return newMatrix;
    }
    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
//editcheck
//testing
//polishing
