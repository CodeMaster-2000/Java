// The "Columnize" class.
/*
Author: Swethan Sivasegaran
Date: October 27 2017
Purpose: To show the capability of manipulating String files into different justification forms and extending further by outputing the text
	 in column formation via input and output files.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
//IMPORTS
import java.awt.*;
import hsa.*;
import java.util.*;

// CLASS COLUMNIZE
/*
Author: Swethan Sivasegaran
Date: October 27 2017
Purpose: To manipulate huge amounts of text into different formats (justifyFull and justifyLeft) in addition to reformating justified texts to 
	 columnized texts through the use of arrays, String manipulation and file manipulation.

DATA FIELDS - None

METHODS

main - To test each method of the COLUMNIZE class functionality and its potential editchecking via Console.

readFile - Given a STRING TEXT file name as a parameter, READS each word seperated by a space and returns a STRING array of all
	   the words in a TEXT file.

justifyLeft - Given a STRING file name, calls the method READFILE to create an array of words and returns a STRING array that has all the words
	      arranged in rows with each line being a length of atleast 35 characters or less as its elements.

justifyFull - Given a STRING file name, calls the method JUSTIFYLEFT to create a STRING line array containing the words in the given file
	      arranged in rows of atleast 35 characters or less and returns a NEW STRING line array with all the lines in the STRING line array
	      from JUSTIFYLEFT being EXACTLY 35 characters each by filling the spaces in between words with more spaces as its elements.

forgeColumn - Given a STRING TEXT file name, calls justifyFull method to create a STRING array of all the lines
	      in a textfile arranged in FULL JUSTIFICATION as its element and arranges each line so that the first line
	      of the first half and the first line of the second half are combined to make two columns seperated by a
	      space of 5 characters wide.

writeFile - Given a STRING input file name and a STRING output file name as parameters, creates a STRING array containing each line arranged so that
	    the TEXTFILE from the input file name is FULL JUSTIFIED into two columns by calling the method FORGECOLUMN. Outputs each altered line of the
	    TEXTFILE into the given STRING output file.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class Columnize
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 27 2017
    Purpose: To test each method of the COLUMNIZE class functionality and its potential editchecking via Console.
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs from each method of the COLUMNZIE class via Console
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();

	//Initialization
	int repeat = 0;
	String inFileName = "";
	String outFileName = "";
	String[] columnDoc = null;

	//Process
	while (repeat == 0)
	{
	    c.clear();
	    c.setTextColor(Color.red);
	    c.print ("Columnize Testing");
	    c.setTextColor(Color.blue);
	    c.print ("\n\nPlease enter a STRING TEXT input file (extension.txt): ");
	    inFileName = c.readString ();
	    c.print ("Please enter a STRING TEXT output file (extension .txt): ");
	    outFileName = c.readString ();
	    c.setTextColor(Color.black);
	    c.println ("\n\nAltered Text");
	    columnDoc = forgeColumn (inFileName);
	    for (int i = 0 ; i < columnDoc.length ; i++)
		c.println (columnDoc [i]);
	    writeFile (inFileName, outFileName);
	    c.setTextColor(Color.blue);
	    c.print ("\n\nPlease enter a 0 (to restart program) or any other key (to end program): ");
	    repeat = c.readInt ();
	}

    }


    // ======================================================================================================

    // readFile

    /*
    Author: Swethan Sivasegaran
    Date: October 27 2017
    Purpose: Given a STRING TEXT file name as a parameter, READS each word seperated by a space and returns a STRING array of all
	     the words in a TEXT file.
    Input: A STRING TEXT file  name parameter value
    Output: A STRING array of all the words in the TEXT file given via parameter.
    */
    public static String[] readFile (String inFileName)
    {
	//Initialization
	String text = "";
	String[] wordArray = null;
	TextInputFile inputFile = new TextInputFile (inFileName);

	//Process
	while (!inputFile.eof ())
	    text = text + inputFile.readString () + " ";
	if (text != "")
	    wordArray = text.split (" ");
	else
	    wordArray = new String [0];
	return wordArray;
    }


    // -------------------------------------------------------------------------------------------------------
    // justifyLeft

    /*
    Author: Swethan Sivasegaran
    Date: October 28 2017
    Purpose: Given a STRING file name, calls the method READFILE to create an array of words and returns a STRING array that has all the words
	     arranged in rows with each line being a length of atleast 35 characters or less as its elements.
    Input: A STRING file name
    Output: A STRING line array consisting of all the words in the STRING TEXT file given via parameter arranged in rows of atleast 35 characters
	    as its elements.
    */
    public static String[] justifyLeft (String inFileName)
    {
	//Initialization
	int count = 0;
	String line = "";
	String docLeft = "";
	String[] wordArray = null;
	String[] lineArray = null;

	//Process
	wordArray = readFile (inFileName);
	while (count < wordArray.length)
	{
	    if (line.length () == 0)
	    {
		line = line + wordArray [count];
		count = count + 1;
	    }
	    if (line.length () + wordArray [count].length () + 1 <= 35)
	    {
		line = line + " " + wordArray [count];
		count = count + 1;
	    }
	    else
	    {
		docLeft = docLeft + line + "\n";
		line = "";
	    }
	}
	if (line.length () >= 0)
	    docLeft = docLeft + line + "\n";

	lineArray = docLeft.split ("\n");
	return lineArray;
    }


    // ======================================================================================================
    // justifyFull

    /*
    Author: Swethan Sivasegaran
    Date: October 28 2017
    Purpose: Given a STRING file name, calls the method JUSTIFYLEFT to create a STRING line array containing the words in the given file
	     arranged in rows of atleast 35 characters or less and returns a NEW STRING line array with all the lines in the STRING line array
	     from JUSTIFYLEFT being EXACTLY 35 characters each by filling the spaces in between words with more spaces as its elements.
    Input: A STRING file name
    Output: A STRING line array containing all the words in the given TEXT file arranged in such a manner that each row is EXACTLY 35 characters
	    through the use of adding additional spaces in between as its elements
    */

    public static String[] justifyFull (String inFileName)
    {
	//Initialization
	int spaceIndex = 0;
	int offSet = 0;
	String line = "";
	String[] docFull = null;
	String[] docLeft = null;

	//Process
	docLeft = justifyLeft (inFileName);
	docFull = new String [docLeft.length];
	for (int i = 0 ; i < docLeft.length ; i++)
	{
	    line = docLeft [i];
	    while (line.length () < 35)
	    {
		spaceIndex = line.indexOf (" ", offSet);
		if (spaceIndex == -1)
		    offSet = 0;
		else
		{
		    offSet = spaceIndex + 2;
		    line = line.substring (0, spaceIndex) + " " + line.substring (spaceIndex);
		}
	    }
	    docFull [i] = line;
	}
	return docFull;
    }


    // -------------------------------------------------------------------------------------------------------
    // forgeColumn

    /*
    Author: Swethan Sivasegaran
    Date: October 29 2017
    Purpose: Given a STRING TEXT file name, calls justifyFull method to create a STRING array of all the lines
	     in a textfile arranged in FULL JUSTIFICATION as its element and arranges each line so that the first line
	     of the first half and the first line of the second half are combined to make two columns seperated by a
	     space of 5 characters wide.
    Input: A STRING TEXT file name
    Output: A STRING array with each element containing two lines of a FULL JUSTIFICATION from justifyFull method seperated by a space
	    5 characters wide to have the illusion of two columns of text.
    */
    public static String[] forgeColumn (String inFileName)
    {
	//Initialization
	int rowNumber = 0;
	String[] lineArray = null;
	String[] newDoc = null;

	//RowCheck
	lineArray = justifyFull (inFileName);
	if (lineArray.length % 2 == 0)
	    rowNumber = lineArray.length / 2;
	else
	    rowNumber = lineArray.length / 2 + 1;
	newDoc = new String [rowNumber];

	//Process
	for (int i = 0 ; i < newDoc.length ; i++)
	{
	    if (i + rowNumber < lineArray.length)
		newDoc [i] = lineArray [i] + "     " + lineArray [i + rowNumber];
	    else
		newDoc [i] = lineArray [i];
	}
	return newDoc;
    }


    // -------------------------------------------------------------------------------------------------------
    // writeFile

    /*
    Author: Swethan Sivasegaran
    Date: October 30 2017
    Purpose: Given a STRING input file name and a STRING output file name as parameters, creates a STRING array containing each line arranged so that
	     the TEXTFILE from the input file name is FULL JUSTIFIED into two columns by calling the method FORGECOLUMN. Outputs each altered line of the
	     TEXTFILE into the given STRING output file.
    Input: A STRING input file name and a STRING output file name
    Output: None - outputs each ALTERED line of the desired JUSTIFICATION form from the STRING TEXT INPUT file name to the STRING output file name given
	    via parameters.
    */
    public static void writeFile (String inFileName, String outFileName)
    {
	//Initialization
	String[] columnDoc = forgeColumn (inFileName);
	TextOutputFile writeFile = new TextOutputFile (outFileName);

	//Process
	for (int i = 0 ; i < columnDoc.length ; i++)
	{
	    writeFile.print (columnDoc [i]);
	}
	writeFile.close ();
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
