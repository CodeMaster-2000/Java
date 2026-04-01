// The "Columnize" class.
import java.awt.*;
import hsa.*;
import java.util.*;
public class Columnize
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	String inFileName = c.readLine ();
	String outFileName = c.readLine ();
	//c.print(justifyFull(inFileName));
	column(inFileName);
	writeFile(inFileName, outFileName, column(inFileName));
	// Place your program here.  'c' is the output console
    } // main method


    public static String[] readFile (String fileName)
    {
	int count = 0;
	String text = "";
	StringTokenizer file;
	String[] wordArray;
	TextInputFile inFileName = new TextInputFile (fileName);
	while (!inFileName.eof ())
	    text = text + inFileName.readString () + " ";
	file = new StringTokenizer (text);
	wordArray = new String [file.countTokens ()];
	while (file.hasMoreTokens ())
	{
	    wordArray [count] = file.nextToken ();
	    count = count + 1;
	}
	return wordArray;
    }


    public static String justifyLeft (String fileName)
    {
	int count = 0;
	String docLeft = "";
	String line = "";
	String[] wordArray = readFile (fileName);
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
	if (line.length() >= 0)
	    docLeft = docLeft + line + "\n";
	return docLeft;
    }


    public static String justifyFull (String fileName)
    {
	int startIndex = 0;
	int endIndex = 0;
	int spaceIndex = 0;
	int offSet = 0;
	String docLeft = "";
	String docFull = "";
	String line = "";
	docLeft = justifyLeft (fileName);

	endIndex = docLeft.indexOf ("\n", startIndex);
	while (endIndex != -1)
	{
	    line = docLeft.substring (startIndex, endIndex);
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
	    startIndex = endIndex + 1;
	    endIndex = docLeft.indexOf ("\n", startIndex);
	    docFull = docFull + line + "\n";
	}
	return docFull;
    }


    public static String[] createLines (String fileName)
    {
	int count = 0;
	int index = 0;
	int startIndex = 0;
	String docFull = justifyFull (fileName);
	while (index != -1)
	{
	    index = docFull.indexOf ("\n", startIndex);
	    startIndex = index + 1;
	    count = count + 1;
	}
	String[] lineArray = new String [count];
	index = 0;
	startIndex = 0;
	count = 0;
	while (count < lineArray.length-1)
	{
	    index = docFull.indexOf ("\n", startIndex);
	    lineArray [count] = docFull.substring(startIndex,index);
	    startIndex = index + 1;
	    count = count + 1;
	}
	return lineArray;
    }
    
    public static String [] column (String fileName)
    {
	int row = 0;
	String [] lineArray = createLines(fileName);
	String [] newDoc;
	if (lineArray.length%2 == 0)
	    row = lineArray.length/2 + 1;
	else
	    row = lineArray.length/2;
	newDoc = new String [row];
	for (int i = 0; i < newDoc.length; i++)
	{
	    if (i + row < lineArray.length)
		newDoc[i] = lineArray[i] + "    " + lineArray[i + row];
	    else
		newDoc[i] = lineArray[i];
	    c.println(newDoc[i]);
	}
	//convert to class format'
	//equal rows
	c.println("LINE ARRAY: " + lineArray.length);
	c.println("row: " + row);
	c.println("WHOLE column: " + newDoc.length);
	return newDoc;
    }
    public static void writeFile (String inFileName, String outFileName, String[] doc)
    {
	TextOutputFile writeFile = new TextOutputFile (outFileName);
	for (int i = 0; i < doc.length; i ++)
	{
	    writeFile.println(doc[i]);
	}
	writeFile.close ();
    }
} // Columnize class
