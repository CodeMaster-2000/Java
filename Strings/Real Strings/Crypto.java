// The "Crypto" class.
/*
Author: Swethan Sivasegaran
Date: October 31 2017
Purpose: To demonstrate the capability of manipulating large amounts of strings and the ability to change input and output data through different file types
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
//IMPORTS
import java.awt.*;
import hsa.*;

// CLASS Crypto
/*
Author: Swethan Sivasegaran
Date: October 31 2017
Purpose: To demonstrate and test the functionality of the CRYPTOGRAPHY class

DATA FIELDS - None

METHODS

main - To test each method of the CRYPTOGRAPHY class functionality and its potential editChecking via Console.

*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
public class Crypto
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: October 31 2017
    Purpose: To test each method of the CRYPTOGRAPHY class functionality and its potential editchecking via Console.
    Input: None - the inputs recieved from the user via CONSOLE
    Output: None - the output from each CRYPTOGRAPHY class method's via Console and its respective file location
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	
	//Initialization
	int repeat = 0;
	String inFileName = "";
	String outFileName = "";
	Cryptography codeMessage;
	
	//Process
	while (repeat == 0)
	{
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.print ("Cryptography Testing");
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a key for ciphering: ");
	    codeMessage = new Cryptography (c.readLine ());
	    c.print ("\nPlease enter an EXISTING valid input file name (extension .txt): ");
	    inFileName = c.readString ();
	    c.print ("\nPlease enter an EXISTING valid output file name(extension.cyp): ");
	    outFileName = c.readString ();
	    c.setTextColor (Color.black);
	    c.print ("Encryption: " + codeMessage.encrypt (inFileName, outFileName));
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter an EXISTING valid output filename(extension.pln): ");
	    c.setTextColor (Color.black);
	    inFileName = outFileName;
	    outFileName = c.readString();
	    c.print ("Decryption: " + codeMessage.decrypt (inFileName, outFileName));
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a 0 (to restart program) or any other key(to end program): ");
	    repeat = c.readInt ();
	}


    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

// CLASS Cryptography
/*
Author: Swethan Sivasegaran
Date: October 31 2017
Purpose: To manipulate STRING TEXT files of different extensions through the use of encryption and decryption solely based on VIGENERE CIPHERING which is offsetting
	 all character values of a text by a certain value ascertained by the characters in a COMMON key used in both encryption and decrption.
	 NOTE: VIGENERE ENCRYPTION will transmit text file from a .txt extension to a .cyp extenion and the VIGENERE DECRYPTION will transmit the .cyp extension containing
	       the encrypted file to a .pln extension.

DATA FIELDS

key (STRING) - is a STRING type data field used as the key for a VIGENERE CIPHERING ENCRYPTION meaning its ASCII CHARACTER values in the STRING are used as a coded
	       message's offset

METHODS

Cryptography (Constructor with ONE STRING parameter) - Given a STRING type parameter value, sets the STRING type data field (key) to the given value
						     - editChecks for ASCII CHARACTER values that are not in the range of 32 - 126 by calling the method rangeCheck()
						     - default value for the STRING type data field(key) is set to nothing ("")

encryptLine - Given a STRING type parameter value(line), reads each ASCII CHARACTER in the STRING and offsets the value of the
	      ASCII character by the value of the ASCII CHARACTER in the STRING type data field(key) as a DISTANCE from 32
	      (lowest possible printable ASCII CHARACTER value) in a consecutive fashion and ultimately returning a NEW STRING value
	      representing the offsetted STRING type parameter value - uses a VIGENERE CIPHER method of encryption
	      - loops the index back around of each ASCII CHARACTER value in the key (32-126) if the index surpasses its possibility in its
		consecutive offsetting fashion

encrypt - Given a STRING type inputFile name(.txt) and a STRING type outputFile name(.cyp), reads each LINE in the inputFile and
	  calls the ENCRYPTLINE method to encrypt the given line using the VIGENERE CIPHER METHOD (see ENCRYPTLINE method).
	  Returns the STRING type ENCRYPTED text file from the inputFile in both the CONSOLE and the outputFile given via parameter.
	  - editChecks for extension type in both files (input - .txt and output - .cyp) via editFileType method
	  - returns "INVALID ENTRY" if text file contains ASCII CHARACTEERS out of the range (32 - 126)

decryptLine -  Given a STRING type parameter value(line), reads each ASCII CHARACTER in the STRING and offsets each character
	       by the  value of the ASCII CHARACTER in the STRING type data field(key) + 32 since the offset in encryption was the difference from 32
	       as a way to include valid ASCII CHARACTERS. The purpose of the method is to decrypt the VIGENERE encrypted message by offsetting
	       opposite to a VIGENERE CIPHER alteration.
	       NOTE: DECRYPTION WILL NOT WORK FOR ENCRYPTION BASED ON OTHER ENCRYPTIONS ASIDE FROM VIGENERE CIPHER

	       - loops the index back around of each ASCII CHARACTER value in the key (32-126) if the index surpasses its possibility in its
		 consecutive offsetting fashion

decrypt -  Given a STRING type inputFile name(.cyp) and a STRING type outputFile name(.pln), reads each LINE in the inputFile and
	   calls the DECRYPTLINE method to decrypt the given line BASED inversing the offset from the VIGENERE ENCRYPTED message
	   (see DECRYPTLINE method). Returns the STRING type DECRYPTED text file from the inputFile in both the CONSOLE and the
	   outputFile given via parameter, essentially yielding the original message that was encrypted.
	   - editChecks for extension type in both files (input - .cyp and output - .txt) via editFileType method
	   - returns "INVALID ENTRY" if text file contains ASCII CHARACTEERS out of the range (32 - 126)

editFileType -  Given a STRING type output file name (outFileName) and a STRING type output file extension type (fileType),
		returns a new STRING output file name with its extension set to the STRING type output file extension name
		(fileType) given via parameters.
		NOTE: DOES NOT CHECK IF THE FILE EXISTS OR NOT

rangeCheck - Given a STRING type parameter value, returns a BOOLEAN value according to if all the ASCII CHARACTERS in the text
	     are within the range of 32 to 126 (printable characters).
	     - returns true if all the ASCII CHARACTERS are in the range of 32 - 126
	     - otherwise, returns false
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=
class Cryptography
{
    //DATA FIELDS
    protected String key = "";

    // Cryptography (Constructor with ONE STRING parameter)

    /*
    Author: Swethan Sivasegaran
    Date: October 31 2017
    Purpose: Given a STRING type parameter value, sets the STRING type data field (key) to the given value
	     - editChecks for ASCII CHARACTER values that are not in the range of 32 - 126 by calling the method rangeCheck()
	     - default value for the STRING type data field(key) is set to nothing ("")
    Input: A STRING type parameter value representing the Vigenere cipher key to encrypt and decrypt coded messages
    Output: None - sets initial values to the data elements
    */
    public Cryptography (String key)
    {
	//EditCheck + Initialization
	if (this.rangeCheck (key) == true)
	    this.key = key;
	else
	    this.key = " ";
    }


    // ======================================================================================================

    // encryptLine

    /*
    Author: Swethan Sivasegaran
    Date: October 31 2017
    Purpose: Given a STRING type parameter value(line), reads each ASCII CHARACTER in the STRING and offsets the value of the
	     ASCII character by the value of the ASCII CHARACTER in the STRING type data field(key) as a DISTANCE from 32
	     (lowest possible printable ASCII CHARACTER value) in a consecutive fashion and ultimately returning a NEW STRING value
	     representing the offsetted STRING type parameter value - uses a VIGENERE CIPHER method of encryption
	     - loops the index back around of each ASCII CHARACTER value in the key (32-126) if the index surpasses its possibility in its
	       consecutive offsetting fashion
    Input: A STRING type parameter value (line)
    Output: A STRING type value representing an encrypted version of the STRING type parameter value using VIGENERE CIPHER method of
	    encryption based on the STRING type data field (key).
    */
    public String encryptLine (String line)
    {
	//Initialization
	int keyIndex = 0;
	int lineIndex = 0;
	int value = 0;
	char letter = ' ';
	String codeLine = "";
	
	//Process
	while (lineIndex < line.length ())
	{
	    if (keyIndex < this.key.length ())
	    {
		value = (int) (line.charAt (lineIndex) + this.key.charAt (keyIndex) - 32);
		if (value > 126)
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


    // -------------------------------------------------------------------------------------------------------

    // encrypt

    /*
    Author: Swethan Sivasegaran
    Date: November 1 2017
    Purpose: Given a STRING type inputFile name(.txt) and a STRING type outputFile name(.cyp), reads each LINE in the inputFile and
	     calls the ENCRYPTLINE method to encrypt the given line using the VIGENERE CIPHER METHOD (see ENCRYPTLINE method).
	     Returns the STRING type ENCRYPTED text file from the inputFile in both the CONSOLE and the outputFile given via parameter.
	     - editChecks for extension type in both files (input - .txt and output - .cyp) via editFileType method
	     - returns "INVALID ENTRY" if text file contains ASCII CHARACTEERS out of the range (32 - 126)
    Input: A STRING type inputFile name(of extension.txt) and a STRING type outputFile name(of extension.cyp)
    Output: Returns a STRING type VIGENERE encrypted text file in both the console and the outputFile given via parameter
    */
    public String encrypt (String inFileName, String outFileName)
    {
	//Initialization + editCheck
	String codeMessage = "";
	TextInputFile textInput = new TextInputFile (this.editFileType (inFileName, ".txt"));
	TextOutputFile textOutput = new TextOutputFile (this.editFileType (outFileName, ".cyp"));
	
	//Process
	while (!textInput.eof ())
	{
	    codeMessage = codeMessage + encryptLine (textInput.readLine ()) + "\n";
	}
	if (rangeCheck(codeMessage) == false)
	    codeMessage = "INVALID ENTRY";
	textOutput.print(codeMessage);
	
	//Closing of File
	textInput.close ();
	textOutput.close ();
	return codeMessage;
    }


    // ======================================================================================================
    // decryptLine

    /*
    Author: Swethan Sivasegaran
    Date: November 1 2017
    Purpose: Given a STRING type parameter value(line), reads each ASCII CHARACTER in the STRING and offsets each character
	     by the  value of the ASCII CHARACTER in the STRING type data field(key) + 32 since the offset in encryption was the difference from 32
	     as a way to include valid ASCII CHARACTERS. The purpose of the method is to decrypt the VIGENERE encrypted message by offsetting
	     opposite to a VIGENERE CIPHER alteration.
	     NOTE: DECRYPTION WILL NOT WORK FOR ENCRYPTION BASED ON OTHER ENCRYPTIONS ASIDE FROM VIGENERE CIPHER

	     - loops the index back around of each ASCII CHARACTER value in the key (32-126) if the index surpasses its possibility in its
	       consecutive offsetting fashion
    Input: A STRING type parameter value (line)
    Output: A STRING type value representing the original STRING value that was encrypted via VIGENERE CIPHER, essentially being a DECRYPTED
	    STRING value of an ENCRYPTED VIGENERE STRING using the ORIGINAL KEY that was used to ENCRYPT it.
    */
    public String decryptLine (String line)
    {
	//Initialization
	int keyIndex = 0;
	int lineIndex = 0;
	int value = 0;
	char letter = ' ';
	String codeLine = "";
	
	//Process
	while (lineIndex < line.length ())
	{
	    if (keyIndex < this.key.length ())
	    {
		value = (int) (line.charAt (lineIndex) - this.key.charAt (keyIndex) + 32);
		if (value < 32)
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


    // -------------------------------------------------------------------------------------------------------
    // decrypt

    /*
    Author: Swethan Sivasegaran
    Date: November 2 2017
    Purpose: Given a STRING type inputFile name(.cyp) and a STRING type outputFile name(.pln), reads each LINE in the inputFile and
	     calls the DECRYPTLINE method to decrypt the given line BASED inversing the offset from the VIGENERE ENCRYPTED message
	     (see DECRYPTLINE method). Returns the STRING type DECRYPTED text file from the inputFile in both the CONSOLE and the
	     outputFile given via parameter, essentially yielding the original message that was encrypted.
	     - editChecks for extension type in both files (input - .cyp and output - .txt) via editFileType method
	     - returns "INVALID ENTRY" if text file contains ASCII CHARACTEERS out of the range (32 - 126)
    Input: A STRING type inputFile name(of extension.cyp) and a STRING type outputFile name(of extension.pln)
    Output: Returns a STRING type decrypted text file of a VIGENERE ENCRYPTED message in both the console and the outputFile given via parameter
	    (returning the original message).
    */
    public String decrypt (String inFileName, String outFileName)
    {
	//Initialization + editCheck
	String codeMessage = "";
	TextInputFile textInput = new TextInputFile (this.editFileType (inFileName, ".cyp"));
	TextOutputFile textOutput = new TextOutputFile (this.editFileType (outFileName, ".pln"));
	
	//Process
	while (!textInput.eof ())
	{
	    codeMessage = codeMessage + decryptLine (textInput.readLine ())+ "\n";
	}
	if (rangeCheck(codeMessage) == false)
	    codeMessage = "INVALID";
	textOutput.print(codeMessage);
	
	//Closing of File
	textInput.close ();
	textOutput.close ();
	return codeMessage;
    }


    // ======================================================================================================
    // editFileType

    /*
    Author: Swethan Sivasegaran
    Date: November 2 2017
    Purpose: Given a STRING type output file name (outFileName) and a STRING type output file extension type (fileType),
	     returns a new STRING output file name with its extension set to the STRING type output file extension name
	     (fileType) given via parameters.
	     NOTE: DOES NOT CHECK IF THE FILE EXISTS OR NOT
    Input: A STRING type output file name (outFileName) and a STRING type output file extension type (fileType)
    Output: A STRING type output file name with an extension according to the STRING extension type parameter value.
    */
    public String editFileType (String outFileName, String fileType)
    {
	//Initialization
	int index = 0;
	index = outFileName.lastIndexOf (".");
	
	//Process
	if (index != -1)
	    outFileName = outFileName.substring (0, index) + fileType;
	else
	    outFileName = outFileName + fileType;
	return outFileName;
    }

    // -------------------------------------------------------------------------------------------------------
    // rangeCheck

    /*
    Author: Swethan Sivasegaran
    Date: November 3 2017
    Purpose: Given a STRING type parameter value, returns a BOOLEAN value according to if all the ASCII CHARACTERS in the text
	     are within the range of 32 to 126 (printable characters).
	     - returns true if all the ASCII CHARACTERS are in the range of 32 - 126
	     - otherwise, returns false
    Input: A STRING type parameter value
    Output: A BOOLEAN value according to if the ASCII CHARACTERS in the STRING are within the range of 32 - 126
	    - returns true if all the ASCII CHARACTERS are in the range of 32 - 126
	    - otherwise, returns false
    */
    public boolean rangeCheck (String text)
    {
	//Initialization
	int index = 0;
	boolean range = true;
	
	//EditCheck + Process
	while (index < text.length () && range == true)
	{
	    if (text.charAt (index) < 32 && text.charAt (index) > 126)
		range = false;
	    index = index + 1;
	}
	return range;
    }
    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
