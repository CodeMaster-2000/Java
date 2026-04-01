// The "Crytpo" class.
import java.awt.*;
import hsa.*;
import java.io.*;
import java.util.*;

/*
Author: Eric Su
Date: Oct 29, 2017
Purpose: To write a program which will asks the user for a key and atext file name and then will encrypt it using the Vigenere 
	 cipher, save it to a second file and then finally decrypt the encrypted file back to plain txt in a third file. The 
	 file's name is given by the user
*/

public class Crytpo
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	String strIn;
	String fileName;
	String key; 
	c.println("Please enter your text file's name");
	fileName = new String(c.readString());
	if (fileName.indexOf(".") >= 0)
	    strIn = new String(fileName.substring(0, fileName.indexOf(".")));
	else
	    strIn = new String(fileName);
	c.println("Please enter your Key");
	key = new String(c.readString());
	VigenereCipher test1 = new VigenereCipher(key);
	test1.encrypt(strIn);
	test1.decrypt(strIn);
	// Place your program here.  'c' is the output console
    } // main method
} // Crytpo class 
/*
Author: Eric Su
Date: Oct 29, 2017
Purpose: To write a Vigenere class, with the key as the only field. This class will have an encrypt method that would take a
	 plain txt file name as a parameter, read that file, line by line, calling an encryptLine method to return the cipher
	 text, line by line and write this line to an output file with the same name except the extension is called ".cyp".
	 Vice versa for decrypt.
 Data Element:
    KEY: a final string(unchangeable), This is the key for the encryption and decryption.
 Methods:
    encrypt: A method that when run will call encryptLine to encrypt the whole text file.
    encryptLine: encrypts line by line.
    decrypt: A method that when run will call decryptLine to decrypt the while text file.
    decryptLine: decrypts line by line.
*/
class VigenereCipher
{
    private final String KEY;

    public VigenereCipher(String strKey)
    {
	this.KEY = new String(strKey);
    }
    public VigenereCipher()
    {
	this ("");
    }
    /*
    Author: Eric Su
    Date: Oct 31, 2017
    Purpose: Encrypt the file by calling encryptLine
    Paramter: String fileName
    Output: None
    */
    public void encrypt(String fileName)
    {
	TextInputFile input = new TextInputFile(fileName + ".txt");
	TextOutputFile output = new TextOutputFile(fileName + ".cyp.txt");
	while(!input.eof())
	    output.println(this.encryptLine(input.readLine()));
    }
    /*
    Author: Eric Su
    Date: Oct 31, 2017
    Purpose: to encrypt line by line
    Paramter: String input
    Output: result
    */
    private String encryptLine(String input)
    {
	int count = 0;
	int count2 = 0;
	int offset = 0;
	int total = 0;
	int original = 0;
	char ascii = ' ';
	String result = "";
	while (count < input.length())
	{
	    original = (int)input.charAt(count);
	    offset = (int)this.KEY.charAt(count2) - 32;
	    total = original + offset;
	    if (total > 126)
		total += (-126 + 31);
	    ascii = (char)total;
	    result += ascii;
	    count ++;
	    count2 ++;
	    if (count2 == this.KEY.length())
		count2 = 0;
		
       }
       return result;
    }
    /*
    Author: Eric Su
    Date: Oct 31, 2017
    Purpose: Decrypt the file by calling decrpytLine
    Paramter: String fileName
    Output: None
    */
    public void decrypt(String fileName)
    {
	TextInputFile input = new TextInputFile(fileName + ".cyp.txt");
	TextOutputFile output = new TextOutputFile(fileName + ".pln.txt");
	while (!input.eof())
	     output.println(this.decryptLine(input.readLine()));
	     
    }
    /*
    Author: Eric Su
    Date: Oct 31, 2017
    Purpose: to decrypt line by line
    Paramter: String input
    Output: result
    */
    private String decryptLine(String input)
    {
	int count = 0;
	int count2 = 0;
	int offset = 0;
	int total = 0;
	int original = 0;
	char ascii = ' ';
	String result = "";
	while (count < input.length())
	{
	    original = (int)input.charAt(count);
	    offset = (int)this.KEY.charAt(count2) - 32;
	    total = original - offset;
	    if (total < 32)
		total += (126 - 31);
	    ascii = (char)total;
	    result += ascii;
	    count ++;
	    count2++;
	    if (count2 == this.KEY.length())
		count2 = 0;
	}
	return result;
    }
}
