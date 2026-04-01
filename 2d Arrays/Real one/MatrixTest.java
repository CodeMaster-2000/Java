// Author: Atputhan Srikanthanathan
// Date: Sunday, November 5th, 2017
// Purpose: This program will encrypt and decrypt a text file using a key and the Vigenere cipher.
// Parameters/input: via console
// Output: via console
// The "MatrixTest" class.
import java.awt.*;
import java.util.*;
import hsa.*;
import hsa.Console;
public class MatrixTest
{
    static Console c;
    public static void main (String[] args) throws CloneNotSupportedException
    {
	c = new Console ();
	{
	    c.setColor (Color.RED);
	    c.fillMapleLeaf (100, 340, 100, 100);

	}

	String filename = "";
	{
	    c.setTextColor (Color.MAGENTA);
	    c.println ("Welcome To The Colorful Matrix Field!");
	}

	{
	    c.setTextColor (Color.RED);
	    c.print ("Input filename for first matrix (''.txt file''): ");
	}
	filename = c.readString ();
	Matrix t = new Matrix ();
	t.getFromFile (filename);

	int row;
	int col;
	{
	    c.setTextColor (Color.BLUE);

	    c.print ("Input number of rows for second matrix: ");
	}
	row = c.readInt ();
	{
	    c.setTextColor (Color.BLACK);

	    c.print ("Input number of columns for second matrix: ");
	}
	col = c.readInt ();
	{
	    c.setTextColor (Color.MAGENTA);
	}
	Matrix s = new Matrix (row, col);
	s.get (c);
	c.clear ();

	int choice;
	do
	{
	    {
		c.fillMapleLeaf (130, 360, 90, 90); //changes colour when user inputs value from the options given.
	    }
	    {
		c.setTextColor (Color.BLUE);
		c.println ("Column Average - 1");
	    }
	    {
		c.println ("Add - 2");
		c.setTextColor (Color.GREEN);
	    }
	    {
		c.println ("Subtract - 3");
		c.setTextColor (Color.BLUE);
	    }
	    {
		c.println ("Minor - 4");
		c.setTextColor (Color.MAGENTA);
	    }
	    {
		c.println ("Determinant - 5");
		c.setTextColor (Color.ORANGE);
	    }
	    {
		c.println ("Transpose - 6");
		c.setTextColor (Color.BLACK);
	    }
	    {
		c.println ("Concatenate - 7");
		c.setTextColor (Color.GREEN);
	    }
	    {
		c.println ("Split - 8");
		c.setTextColor (Color.BLUE);
	    }
	    {
		c.println ("Exit - 0");
		c.setTextColor (Color.MAGENTA);
	    }
	    {
		c.print ("Enter choice: ");
		c.setTextColor (Color.ORANGE);
	    }
	    choice = c.readInt ();
	    c.println ();
	    c.clear ();
	    {
		c.setColor (Color.MAGENTA);
		c.drawString ("Matrix 1", 230, 235);
		t.print (c, 230, 250);
		c.drawString ("Matrix 2", 460, 235);
		s.print (c, 460, 250);
	    }
	    if (choice == 1)
	    {
		c.setColor (Color.BLUE);

		c.drawString ("Column Average", 0, 235);
		t.columnAverage ().print (c, 0, 250);
	    }
	    else if (choice == 2)
	    {
		c.setColor (Color.GREEN);
		c.drawString ("Addition", 0, 235);
		t.add (s).print (c, 0, 250);
	    }
	    else if (choice == 3)
	    {
		c.setColor (Color.BLUE);
		c.drawString ("Subtraction", 0, 235);
		t.subtract (s).print (c, 0, 250);
	    }
	    else if (choice == 4)
	    {

		int removerow;
		{
		    c.print ("Remove row: ");
		    c.setColor (Color.GREEN);
		}
		removerow = c.readInt ();
		int removecol;
		{
		    c.print ("Remove column: ");
		    c.setColor (Color.GREEN);
		}
		removecol = c.readInt ();
		c.clear ();
		{
		    c.setColor (Color.GREEN);
		    c.drawString ("Minor", 0, 235);
		    t.minor (removerow, removecol).print (c, 0, 250);
		}
	    }
	    else if (choice == 5)
	    {
		c.setColor (Color.ORANGE);
		c.drawString ("Determinant", 0, 235);
		c.drawString ("" + t.determinant (t.rows), 0, 250);
	    }
	    else if (choice == 6)
	    {
		c.setColor (Color.BLACK);
		c.drawString ("Transpose", 0, 235);
		t.transpose ().print (c, 0, 250);
	    }
	    else if (choice == 7)
	    {
		c.drawString ("Concatenate", 0, 235);
		t.concatenate (s).print (c, 0, 250);
	    }
	    else if (choice == 8)
	    {
		int givencol;
		c.print ("Split starting column: ");
		givencol = c.readInt ();
		c.clear ();
		c.drawString ("Split", 0, 235);
		t.split (givencol).print (c, 0, 250);
	    }
	}


	while (choice != 0)
	    ;
    }
}


/****************************************************************************************************
//Retrived From The Worksheet and Peer Conference From Mr.Smith
Author: Atputhan Srikanthanathan
Date: Tuesday November 7th, 2017
class Matrix
This program will display a matrix class which includes an 2-D array (element) and
an integer rows and cols.

Fields:
    element         the dynamic 2d array (doubles)
    rows            the number of rows
    cols            the number of columns

    newList         the temp 1-D array (String)
    size            the size of the temp array
Methods:
    cosntructors
    clonemethod     creates a clone of a 2d array
    get             gets the values of the matrix from the user
    print           prints the matix given a Console and starting screen row and column
    getFromFile     reads the rows and cols and then the elements from the file when passed a txt file
    columnAverage   returns a 1xcols Matrix of the averages of each column
    sameSize        checks if a given matrix is the same size as the current matrix
    square          checks if the current matrix is a square (rows = cols)
    add             returns the addition of the current matrix and a given matrix if both matrix are same size
    subtract        returns the subtraction of the current matrix and a given matrix if both matrix are same size
    minor           returns a minor of the current matrix
    determinant     returns the determinant of the current matrix (written |a|) if it is a square
    transpose       returns a Matrix which has its rows and columns exchanged
    concatenate     creates a new Matrix given another Matrix with the same number of rows. Does not have to have the same number of columns but MUST be the same number of rows!
		    but has to have the same number of rows.
    split           creates a new Matrix starting at a given column. Return a null matrix if the column number does not exist in the previously made matrix(Ensure That This Does Not Crash!)
    addWordBack     adds a string to the back of an array.

****************************************************************************************************/
class Matrix implements Cloneable
{
    //Data Fields
    protected double[] [] element;
    protected int rows;
    protected int cols;

    protected String[] newList;
    protected int size;

    //Constructors
    public Matrix ()
    {
	this.element = null;
    }


    public Matrix (int rows)
    {
	if (rows < 0)
	{
	    this.rows = 0;
	}
	else
	{
	    this.rows = rows;
	}
	this.element = new double [rows] [rows];
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.rows ; j++)
		this.element [i] [i] = 0;
    }


    public Matrix (int rows, int cols)
    {
	if (rows < 0 || cols < 0)
	{
	    this.rows = 0;
	    this.cols = 0;
	}
	else
	{
	    this.rows = rows;
	    this.cols = cols;
	}
	this.element = new double [this.rows] [this.cols];
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.cols ; j++)
		this.element [i] [j] = 0;
    }


    public Matrix (int rows, int cols, double num)
    {
	if (rows < 0 || cols < 0)
	{
	    this.rows = 0;
	    this.cols = 0;
	}
	else
	{
	    this.rows = rows;
	    this.cols = cols;
	}
	this.element = new double [this.rows] [this.cols];
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.cols ; j++)
		this.element [i] [j] = num;
    }


    //Methods
    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    clonemethod
    It creates a clone of a 2d array.
    Parameters: N/A
    Return Value: the clone of the 2d array
    ****************************************************************************************************/
    public Matrix clonemethod () throws CloneNotSupportedException
    {
	Matrix newObject = (Matrix) super.clone ();
	newObject.element = new double [this.rows] [];
	for (int i = 0 ; i < this.rows ; i++)
	    newObject.element [i] = (double[]) element [i].clone ();
	return newObject;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    get
    It gets the values of the matrix from the user.
    Parameters: Console c
    Return Value: N/A
    ****************************************************************************************************/
    public void get (Console c)
    {
	double value = 0;
	this.element = new double [this.rows] [this.cols];
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.cols ; j++)
	    {
		c.print ("Input number for [" + i + "][" + j + "]: ");
		value = c.readDouble ();
		this.element [i] [j] = value;
	    }
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    print
    It prints the matix given a Console and starting screen row and column.
    Parameters: Console c, starting row, starting column
    Return Value: N/A
    ****************************************************************************************************/
    public void print (Console c, int startrow, int startcol)
    {
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.cols ; j++)
	    {
		this.element [i] [j] = Math.round (this.element [i] [j] * 100.0) / 100.0;
		c.drawString (("" + this.element [i] [j]), startrow + (50 * j), startcol + (50 * i));
	    }
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Thursday November 9, 2017
    getFromFile
    It reads the rows and cols and then the elements from the file when passed a txt file.
    Parameters: file name
    Return Value: N/A
    ****************************************************************************************************/
    public void getFromFile (String filename)
    {
	String line = "";
	int count = 2;
	this.rows = 0;
	this.cols = 0;
	this.element = new double [this.rows] [this.cols];
	TextInputFile input = new TextInputFile (filename);
	while (!input.eof ())
	{
	    line = input.readLine ();
	    StringTokenizer t = new StringTokenizer (line);
	    while (t.hasMoreTokens ())
	    {
		addLineBack (t.nextToken ());
	    }
	}
	this.rows = Integer.parseInt (this.newList [0]);
	this.cols = Integer.parseInt (this.newList [1]);
	if (rows < 0 || cols < 0)
	{
	    this.rows = 0;
	    this.cols = 0;
	}
	else
	{
	    this.rows = rows;
	    this.cols = cols;
	}
	this.element = new double [this.rows] [this.cols];
	if (this.rows == this.cols || this.cols > this.rows)
	{
	    for (int i = 0 ; i < this.rows ; i++)
		for (int j = 0 ; j < this.cols ; j++)
		{
		    this.element [i] [j] = Double.parseDouble (this.newList [count]);
		    count++;
		}
	}
	else
	{
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    this.element [i] [j] = Double.parseDouble (this.newList [count]);
		    count++;
		}
		count += this.rows - this.cols;
	    }
	}
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Thursday November 9,2017
    columnAverage
    It returns a 1xcols Matrix of the averages of each column.
    Parameters: N/A
    Return Value: a 1xcols matrix of the column averages
    ****************************************************************************************************/
    public Matrix columnAverage ()
    {
	Matrix colsaverage = new Matrix (1, this.cols);
	double average = 0;
	for (int j = 0 ; j < this.cols ; j++)
	{
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		average += (this.element [i] [j]);
	    }
	    average /= this.cols;
	    colsaverage.element [0] [j] = average;
	    average = 0;
	}
	return colsaverage;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wedesday November 8, 2017
    sameSize
    It checks if a given matrix is the same size as the current matrix.
    Parameters: N/A
    Return Value: true or false
    ****************************************************************************************************/
    public boolean sameSize (Matrix given)
    {
	boolean isSame = false;
	if (this.rows == given.rows && this.cols == given.cols)
	{
	    isSame = true;
	}
	return isSame;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Tuesday November 7, 2017
    square
    It checks if the current matrix is a square (rows = cols).
    Parameters: N/A
    Return Value: true or false
    ****************************************************************************************************/
    public boolean square ()
    {
	boolean isSquare = false;
	if (this.rows == this.cols)
	{
	    isSquare = true;
	}
	return isSquare;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    add
    It returns the addition of the current matrix and a given matrix if both matrix are same size.
    Parameters: given matrix
    Return Value: true or false
    ****************************************************************************************************/
    public Matrix add (Matrix given)
    {
	Matrix addition = new Matrix ();
	if (sameSize (given) == true)
	{
	    addition = new Matrix (this.rows, this.cols);
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    addition.element [i] [j] = this.element [i] [j] + given.element [i] [j];
		}
	    }
	}
	return addition;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    subtract
    It returns the subtraction of the current matrix and a given matrix if both matrix are same size.
    Parameters: given matrix
    Return Value: true or false
    ****************************************************************************************************/
    public Matrix subtract (Matrix given)
    {
	Matrix subtraction = new Matrix ();
	if (sameSize (given) == true)
	{
	    subtraction = new Matrix (this.rows, this.cols);
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    subtraction.element [i] [j] = this.element [i] [j] - given.element [i] [j];
		}
	    }
	}
	return subtraction;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Wednesday November 8th, 2017
    minor
    It returns a minor of the current.
    Parameters: N/A
    Return Value: true or false
    ****************************************************************************************************/
    public Matrix minor (int removerow, int removecol)
    {
	int count = 0;
	this.size = 0;
	newList = new String [this.size];
	Matrix minorMatrix = new Matrix ();
	if (removerow <= this.rows && removecol <= this.cols)
	{
	    minorMatrix = new Matrix (this.rows - 1, this.cols - 1);
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    if (i != removerow - 1 && j != removecol - 1)
		    {
			addLineBack ("" + this.element [i] [j]);
		    }
		}
	    }
	    this.rows -= 1;
	    this.cols -= 1;
	    for (int i = 0 ; i < this.rows ; i++)
		for (int j = 0 ; j < this.cols ; j++)
		{
		    minorMatrix.element [i] [j] = Double.parseDouble (this.newList [count]);
		    count++;
		}
	}
	return minorMatrix;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Thursday November 9th, 2017
    determinant
    It returns the determinant of the current matrix (written |a|) if it is a square matrix.
    Parameters: size of matrix (the number of rows)
    Return Value: the determinant
    ****************************************************************************************************/
    public double determinant (int rows)
    {
	double det = 0;
	if (square () == true)
	{
	    if (rows == 1)
	    {
		det = this.element [0] [0];
	    }
	    else if (rows == 2)
	    {
		det = this.element [0] [0] * this.element [1] [1] - this.element [1] [0] * this.element [0] [1];
	    }
	    else
	    {
		det = 0;
		for (int j1 = 0 ; j1 < rows ; j1++)
		{
		    double[] [] m = new double [rows - 1] [];
		    for (int k = 0 ; k < (rows - 1) ; k++)
		    {
			m [k] = new double [rows - 1];
		    }
		    for (int i = 1 ; i < rows ; i++)
		    {
			int j2 = 0;
			for (int j = 0 ; j < rows ; j++)
			{
			    if (j == j1)
			    {
				m [i - 1] [j2] = this.element [i] [j];
				j2++;
			    }
			}
		    }
		    det += Math.pow (-1.0, 1.0 + j1 + 1.0) * this.element [0] [j1] * determinant (rows - 1);
		}
	    }
	}
	return det;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Friday November 10, 2017
    transpose
    It returns a Matrix which has its rows and columns exchanged (a nxm matrix becomes a mxn).
    Parameters: N/A
    Return Value: a Matrix with its rows and columns exchanged
    ****************************************************************************************************/
    public Matrix transpose ()
    {
	int count = 0;
	this.size = 0;
	newList = new String [this.size];
	Matrix transposed = new Matrix (this.cols, this.rows);
	for (int i = 0 ; i < this.rows ; i++)
	    for (int j = 0 ; j < this.cols ; j++)
		addLineBack ("" + this.element [i] [j]);

	for (int i = 0 ; i < this.cols ; i++)
	{
	    for (int j = 0 ; j < this.rows ; j++)
	    {
		transposed.element [i] [j] = Double.parseDouble (this.newList [count]);
		count++;
	    }
	}
	return transposed;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Saturday November 11, 2017
    concatenate
    It creates a new Matrix given another Matrix with the same number of rows. Can Have The Same Number Of Columns But Can Not Have The Same Number Of Rows
    Parameters: given Matrix
    Return Value: a concatenated Matrix
    ****************************************************************************************************/
    public Matrix concatenate (Matrix given)
    {
	int count = 0;
	this.size = 0;
	newList = new String [this.size];
	Matrix concatenated = new Matrix ();
	if (this.rows == given.rows)
	{
	    concatenated.rows = this.rows;
	    concatenated.cols = this.cols + given.cols;
	    concatenated = new Matrix (concatenated.rows, concatenated.cols);
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    addLineBack ("" + this.element [i] [j]);
		}
		for (int k = 0 ; k < given.cols ; k++)
		{
		    addLineBack ("" + given.element [i] [k]);
		}
	    }

	    for (int i = 0 ; i < concatenated.rows ; i++)
	    {
		for (int j = 0 ; j < concatenated.cols ; j++)
		{
		    concatenated.element [i] [j] = Double.parseDouble (this.newList [count]);
		    count++;
		}
	    }
	}
	return concatenated;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Saturday November 11, 2017
    split
    It creates a new Matrix starting at a given column.
    Parameters: given column
    Return Value: new Matrix starting at given column.
    ****************************************************************************************************/
    public Matrix split (int columnsplit)
    {
	int count = 0;
	this.size = 0;
	newList = new String [this.size];
	Matrix splited = new Matrix ();
	if (columnsplit < this.cols)
	{
	    splited.rows = this.rows;
	    splited.cols = this.cols - columnsplit;
	    splited = new Matrix (splited.rows, splited.cols);
	    for (int i = 0 ; i < this.rows ; i++)
	    {
		for (int j = 0 ; j < this.cols ; j++)
		{
		    if (j >= columnsplit)
		    {
			addLineBack ("" + this.element [i] [j]);
		    }
		}
	    }

	    for (int i = 0 ; i < splited.rows ; i++)
	    {
		for (int j = 0 ; j < splited.cols ; j++)
		{
		    splited.element [i] [j] = Double.parseDouble (this.newList [count]);
		    count++;
		}
	    }
	}
	return splited;
    }


    /****************************************************************************************************
    Author: Atputhan Srikanthanathan
    Date: Friday November 10, 2017
    addWordBack
    It adds a string to the array.
    Parameters: given string
    Return Value: an array of string with the given string at the end
    ****************************************************************************************************/
    public void addLineBack (String added)
    {
	String[] oldList;
	oldList = newList;

	size += 1;
	newList = new String [size];

	for (int count = 0 ; count < size - 1 ; count++)
	    newList [count] = oldList [count];
	newList [size - 1] = added;
    }
}
