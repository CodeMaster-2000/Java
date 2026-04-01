// The "Crypto" class.
import java.awt.*;
import hsa.*;

public class Crypto
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	Cryptography test = new Cryptography ("ics4u");
	c.print(test.decrypt("cInput.txt","cOutput.pln"));


	// Place your program here.  'c' is the output console
    } // main method
} // Crypto class
//HISTORY
//CHANGING INPUT TXT
class Cryptography
{
    protected String key = "";
    public Cryptography (String key)
    {
	this.key = key;
    }


    public String encryptLine (String line)
    {
	int keyIndex = 0;
	int lineIndex = 0;
	String codeLine = "";
	int value = 0;
	char letter = ' ';
	while (lineIndex < line.length ())
	{
	    if (keyIndex < this.key.length ())
	    {               
		value = (int) (line.charAt (lineIndex) + this.key.charAt (keyIndex) - 32);
		if (value > 126)
		//check if lower than 32
		    letter = (char) (value - 126 + 31);
		else
		    letter = (char) (value);
		codeLine = codeLine + letter;
		keyIndex = keyIndex + 1;
		lineIndex = lineIndex + 1;
	    }
	    else
		keyIndex = 0;
	}
	return codeLine;
    }


    public String encrypt (String inFileName, String outFileName)
    {
	String line = "";
	String codeMessage = "";
	TextInputFile textInput = new TextInputFile (inFileName);
	TextOutputFile textOutput = new TextOutputFile (outFileName);
	while (!textInput.eof ())
	{
	    line = encryptLine (textInput.readLine ());
	    codeMessage = codeMessage + line;
	    textOutput.println (line);
	}
	textInput.close ();
	textOutput.close ();
	return codeMessage;
    }
    
    public String decryptLine(String line)
    {
	int keyIndex = 0;
	int lineIndex = 0;
	String codeLine = "";
	int value = 0;
	char letter = ' ';
	while (lineIndex < line.length ())
	{
	    if (keyIndex < this.key.length ())
	    {               
		value = (int) (line.charAt (lineIndex) - this.key.charAt (keyIndex) + 32);
		if (value < 32 || value > 126)
		    letter = (char) (value + 126 - 31);
		else
		    letter = (char) (value);
		codeLine = codeLine + letter;
		keyIndex = keyIndex + 1;
		lineIndex = lineIndex + 1;
	    }
	    else
		keyIndex = 0;
	}
	return codeLine;
    }
    public String decrypt(String inFileName, String outFileName)
    {
	String line = "";
	String codeMessage = "";
	TextInputFile textInput = new TextInputFile (inFileName);
	TextOutputFile textOutput = new TextOutputFile (outFileName);
	while (!textInput.eof ())
	{
	    line = decryptLine (textInput.readLine ());
	    codeMessage = codeMessage + line;
	    textOutput.println (line);
	}
	textInput.close ();
	textOutput.close ();
	return codeMessage;
    }


    //check range of each letter in line and key
}
