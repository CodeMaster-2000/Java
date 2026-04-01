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
	writeFile(inFileName, outFileName,justifyFull(inFileName));
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
    public static String[] column(String fileName)
    {
	int count = 0;
	int index = 0;
	int startIndex = 0;
	String docFull = justifyFull(fileName);
	while (index != -1)
	{
	    index = docFull.indexOf("\n", startIndex);
	    startIndex = index + 1;
	    count = count + 1;
	}
	String [] lineArray = new String [count];
    }
    public static void writeFile (String inFileName, String outFileName, String doc)
    {
	TextOutputFile writeFile = new TextOutputFile (outFileName);
	writeFile.print (doc);
	writeFile.close ();
    }
} // Columnize class
