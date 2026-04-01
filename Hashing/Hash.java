// The "Hash" class.
/*
Author: Swethan Sivasegaran
Date: December 13 2017
Purpose: To demonstrate the capability and understanding of the concept of HASHING and its use in storing data efficiently given the circumstances.
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.*;
import java.util.*;

// CLASS HASH
/*
Author: Swethan Sivasegaran
Date: December 13 2017
Purpose: To showcase the capability of manipulating records and storing data using a HASHING based system.

DATA FIELDS - None

METHODS

main - To test the functionality of each methods in the HASHDATABASE class
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class Hash
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: To test the functionality of each methods in the HASHDATABASE class
    Input: None - the inputs recieved from the user via Console
    Output: None - the outputs of each individual method in the HASHDATABASE class via Console
    */
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (40, 130);
	int id = 0;
	int size = 0;
	int repeat = 0;
	int methodType = 1;
	HashDataBase dataBase;
	while (repeat == 0)
	{
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.print ("Hashing DataBase Testing");
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a POSITIVE INTEGER value for size greater than 5: ");
	    size = c.readInt ();
	    dataBase = new HashDataBase (size, "videodb.csv.txt");
	    while (methodType < 5 && methodType > 0)
	    {
		c.setTextColor(Color.magenta);
		c.print("===========================================================================\n");
		c.setTextColor(Color.black);
		c.print ("Enter 1 to test method - add\nEnter 2 to test method - find\nEnter 3 to test method - peek\nEnter 4 to test method - delete\nAny other integer to exit \n\n");
		c.setTextColor(Color.blue);
		c.print ("Please enter an INTEGER value corresponding to the values above to test a method: ");
		methodType = c.readInt ();
		if (methodType == 1)
		{
		    dataBase.add(c);
		}
		else if(methodType == 2)
		{
		    c.print("Please enter a DBRecord ID (POSITIVE INTEGER) to search within the data base: ");
		    id = c.readInt();
		    dataBase.find(c,id);
		}
		else if (methodType == 3)
		{
		    dataBase.peek(c);
		}
		else if (methodType == 4)
		{
		    c.print("Please enter a DBRecord ID (POSITIVE INTEGER) to delete from the data base: ");
		    id = c.readInt();
		    dataBase.delete(c,id);
		}
		else
		    repeat = 1;
	    }

	}

    }
    // ======================================================================================================

}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

// CLASS DBRecord
/*
Author: Swethan Sivasegaran
Date: December 13 2017
Purpose: To serve as a CONTAINER class that holds information on various movies under the data elements of id, title, type, cost, distance and date and provide basic presentation of the information.

DATA FIELDS
id (INT) - An INTEGER value representing a movie or DBRecord's UNIQUE ID to be used as a marker or name tag in a numerical sense.
title (STRING) - A STRING value corresponding to the name of the movie or the DBRecord
type (STRING) - A STRING value corresponding to the genre of the movie or the DBRecord
cost(DOUBLE) - A DOUBLE value corresponding to the cost to purchase the movie or the DBRecord
dist (STRING) - A STRING value corresponding to the distance to travel to watch or purchase the movie.
date (STRING) - A STRING value corresponding to the the release date of the movie or DBRecord installation.

METHODS
Constructor (with SIX PARAMETERS) - Given an INTEGER parameter value (id),four STRING type parameter values (Title,Type, Distance, Date),and a DOUBLE parameter value (Cost), sets the INTEGER type data field (id) in addition to 
				    the four STRING type data fields (title, type, dist, and date) and the DOUBLE type data field (cost) to their respective values in the respective order of parameter input (id, title, type, cost,
				    dist, date).
				    - No editCheck since this is a container class that will never interact with the user
				    
Constructor (with NO PARAMETERS) - Given NO PARAMETERS, creates a default record and sets the INTEGER + DOUBLE type data fields (id and cost) to 0 in addition to initializing all the STRING type data fields (title, type, dist and date)
				   to "default".
				   
toString - Based on the INTEGER type data field (id), the STRING type data fields (title, type, dist, date) and the DOUBLE data field (cost), returns a STRING value that relays the CURRENT DBRecord information in the format of 
	   id --> title --> type --> cost --> dist --> date. The method also calls the method rightPad (see Method rightPad) to help with spacing of Strings. 
	   
rightPad - Given a STRING type parameter value (input) and an INTEGER type parameter value (spaces), adds a certain number of spaces after the given STRING parameter value (input) corresponding to the INTEGER type parameter
	   value (spaces) and returns the new STRING value.
	   - No editCheck since this is a container class that will never interact with the user

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class DBRecord
{
    //DATA FIELDS
    protected int id = 0;
    protected double cost = 0;
    protected String title = "";
    protected String type = "";
    protected String dist = "";
    protected String date = "";

    // Constructor (with SIX PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Given an INTEGER parameter value (id),four STRING type parameter values (Title,Type, Distance, Date),and a DOUBLE parameter value (Cost), sets the INTEGER type data field (id) in addition to 
	     the four STRING type data fields (title, type, dist, and date) and the DOUBLE type data field (cost) to their respective values in the respective order of parameter input (id, title, type, cost, dist, date).
	     - No editCheck since this is a container class that will never interact with the user
    Input: An INTEGER parameter value (id), two STRING parameter values (Title + Type), a DOUBLE parameter value (Cost) and two STRING parameter values (Distance and Date) in that respective order
    Output: None - initializes the INTEGER type data field (id),the four STRING type data fields (title, type, dist, and date) and the DOUBLE type data field (cost).
	    - No editCheck since this is a container class that will never interact with the user
    */
    public DBRecord (int id, String title, String type, double cost, String dist, String date)
    {
	this.id = id;
	this.title = title;
	this.type = type;
	this.cost = cost;
	this.dist = dist;
	this.date = date;
    }


    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Given NO PARAMETERS, creates a default record and sets the INTEGER + DOUBLE type data fields (id and cost) to 0 in addition to initializing all the STRING type data fields (title, type, dist and date) to "default".
    Input: None
    Output: None - initializes the INTEGER + DOUBLE type data fields (id and cost) to 0 and the STRING type data fields (title, type, dist and date) to "default" to make it known that it is a default record.
    */
    public DBRecord ()
    {
	this (0, "default", "default", 0, "default", "default");
    }


    // -------------------------------------------------------------------------------------------------------

    // toString

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Based on the INTEGER type data field (id), the STRING type data fields (title, type, dist, date) and the DOUBLE data field (cost), returns a STRING value that relays the CURRENT DBRecord information in the format of 
	     id --> title --> type --> cost --> dist --> date. The method also calls the method rightPad (see Method rightPad) to help with spacing of Strings. 
    Input: None
    Output: A STRING value that relays the CURRENT DBRecord information in the format of id --> title --> type --> cost --> dist --> date. 
    */
    public String toString ()
    {
	return (rightPad ("" + id, 8) + rightPad (title, 50) + rightPad (type, 10) + rightPad ("" + cost, 8) + rightPad (dist, 6) + rightPad (date, 12));
    }


    // ======================================================================================================

    // rightPad

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Given a STRING type parameter value (input) and an INTEGER type parameter value (spaces), adds a certain number of spaces after the given STRING parameter value (input) corresponding to the INTEGER type parameter
	     value (spaces) and returns the new STRING value.
	     - No editCheck since this is a container class that will never interact with the user
    Input: A STRING type parameter value (input) and an INTEGER type parameter value (spaces)
    Output: A NEW STRING value that is equal to the STRING type parameter value (input) + a certain number of spaces based on the INTEGER type parameter value (spaces)
	    - No editCheck since this is a container class that will never interact with the user 
    */
    public static String rightPad (String input, int spaces)
    {
	String pad = input;
	while (pad.length () < spaces)
	{
	    pad = pad + " ";
	}
	return pad;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

// CLASS HASHDATABASE
/*
Author: Swethan Sivasegaran
Date: December 13 2017
Purpose: To store DBRecords in an array that uses a HASHING based system and to give the complete potential of expanding and manipulating records within a dataBase while obtaining an 0(1) level 
	 efficiency in storing DBRecords into the database.

DATA FIELDS
logicalSize (INT) - An INTEGER value corresponding to the number of VALID DBRecord elements stored in the DBRecord [] type data field (dataBase)
physicalSize (INT) - An INTEGER value corresponding to the physical size or length of the DBRecord [] type datafield (dataBase) 
textInput (TEXTINPUTFILE) - An object or instance of the TEXTINPUTFILE class that contains the text information within a file which in itself contain various DBRecord information 
dataBase (DBRecord []) - A DBRecord [] type data field that contains all the DBRecords in a large dataBase that use a hash based system to pick or place DBRecords in order to ultimately achieve an O(1) algorithm for storing DBRecords.

METHODS
Constructor (with TWO PARAMETERS) - Given an INTEGER type parameter value (size) and a STRING type parameter value (fileName), sets the INTEGER type data field (logicalSize) to 0 and the TEXTINPUTFILE type data field to a new 
				    Instance of the TEXTINPUTFILE class with the VALID file name as a parameter. In addition, sets the INTEGER type data field (physicalSize) to the given INTEGER type parameter value(size) - editchecks
				    for values greater than 5 and input size values that are PRIME numbers using the method isPrime (see Method isPrime within the class). Initializes the DBrecord [] type data field (dataBase) to a new 
				    Instance of a DBRecord array with a size value corresponding to the set INTEGER type data field (physicalSize).
				    
Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER type data field (logicalSize) to 0, the INTEGER type data field (physicalSize) to 5, the TEXTINPUTFILE type data field to a new Instance of a TEXTINPUTFILE 
				   class with "videodb.csv.txt" as its parameter and the DBRecord [] type data field (dataBase) to a DBRecord [] with a physical size of 5 as its default values by calling the Constructor 
				   (with TWO PARAMETERS).
				   
isPrime - Given an INTEGER parameter value (num), returns a BOOLEAN value according to if the INTEGER parameter value (num) is a PRIME number or not.
	  - returns true if INTEGER parameter value (num) is a PRIME number
	  - returns false otherwise.
	  
isFull - Based on the INTEGER type data fields (logicalSize + physicalSize), returns a BOOLEAN value corresponding to whether the number of VALID records in the DBRecord[] type datafield (dataBase) occupy atleast 70 percent
	 of the entire dataBase storage space
	 - returns true if the number of records occupying the DBRecord [] type data field (dataBase) are 70 percent or higher of the total storage space in the dataBase (logicalSize/physicalSize > 0.7)
	 - returns false otherwise
	
hash - Given two INTEGER parameter values (id + counter), returns an INTEGER value residing between 0 and the INTEGER type data field (physicalSize) - 1 by using a mathematical algorithm/hash function that use modulus division
       on the INTEGER parameter value (id). In addition, the method also calls another method doubleHash (see Method doubleHash within class) to add onto the first INTEGER value from the hash function and uses the INTEGER 
       parameter value (counter) as a SCALAR multiplier to return a different INTEGER index value in case of collisions.
       
doubleHash - Given an INTEGER parameter value (id), returns an INTEGER value by using a secondary hash function with the help of modulus division that resides between 0 and the INTEGER type data field (physicalSize) - 2. To be used 
	     in case of collisions within the hash method.
	     
rehash - Based on the return value of the method isFull(see Method isFull), changes the value of the INTEGER type data field (physicalSize) by increasing it so that the physicalSize data field is 20 percent larger but still remains
	 a PRIME number - the return value is true. With the help of the hash method (see Method hash), the DBRecords from the DBRecord [] type datafield (dataBase) are rearranged into different locations with collision checks and 
	 the DBRecord [] type data field (dataBase) is set to a larger storage space dataBase with the same data.
	 - If return value is false, depending on the changes to the records in the dataBase prior (Ex. delete), the records may remain the same.
	 
peek - Given a CONSOLE type parameter value, prints the DBRecord information or NULL if there is no record and its respective Index location within the DBRecord [] type data field (dataBase)
       (See Method toString for the presentation of DBrecord information).
       
insert - Given a CONSOLE type parameter value and a DBRECORD type parameter value, inserts the DBRecord into the DBRecord [] type data field (dataBase) with the help of the hash method (see Method hash within class)
	 and checks for collisions. In addition, the number of collisions are printed into the Console.
	 
search - Given an INTEGER type parameter value (DBRecord id), returns an INTEGER value corresponding to the location of the DBRecord with the DBRecord id within the parameters using the hash method
	 (see Method hash within class) and collision checking.
	 - returns -1 if a DBRecord with the same DBRecord id was not found
	 
add - Given a CONSOLE type parameter value, reads a line of text from the TEXTINPUTFILE type data field (textInput) containing all the information for a DBRecord in the order of id, title, type, cost, dist, date.
      Using the insert method (see METHOD insert within the class), creates a new instance of a DBRecord and inserts it into the DBRecord [] type datafield (dataBase).
      - editChecks to see if there are any more lines of text to read from the file so that nothing will occur if a programmer attempts to add a DBRecord to the dataBase when there is nothing else to read from
      
find - Given a CONSOLE type parameter value and an INTEGER type parameter value (id), calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase)
       and prints onto the Console whether the record was found or not. If the record was found, the DBRecord information is printed as well.
       
delete - Given a CONSOLE type parameter value and an INTEGER type parameter value (id), calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase). If the record
	 is found, the location within the DBRecord [] type data field (dataBase) is deleted or now points to null and the INTEGER type data field (logicalSize) is decreased by 1. The method reHash (see Method rehash within class)
	 is called to reorganize the data to ensure any collisions at the location that pointed to null is shifted back to ensure direct access to any record and to idea of a O(1) algorithm.
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class HashDataBase
{
    //DATA FIELDS
    protected int logicalSize = 0;
    protected int physicalSize = 0;
    protected TextInputFile textInput;
    protected DBRecord[] dataBase;

    // Constructor (with TWO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Given an INTEGER type parameter value (size) and a STRING type parameter value (fileName), sets the INTEGER type data field (logicalSize) to 0 and the TEXTINPUTFILE type data field to a new Instance of the TEXTINPUTFILE 
	     class with the VALID file name as a parameter. In addition, sets the INTEGER type data field (physicalSize) to the given INTEGER type parameter value(size) - editchecks for values greater than 5 and input size values 
	     that are PRIME numbers using the method isPrime (see Method isPrime within the class). Initializes the DBrecord [] type data field (dataBase) to a new Instance of a DBRecord array with a size value corresponding to the 
	     set INTEGER type data field (physicalSize).
    Input: An INTEGER type parameter value (size) and a STRING type parameter value (fileName)
    Output: None - initializes the INTEGER type data field (logicalSize), the TEXTINPUTFILE type data field (textInput), the INTEGER type data field (physicalSize), and the DBRecord [] type data field (dataBase) to their respective 
	    values and editChecks the INTEGER type parameter value (size) for PRIME values and values that are greater than 5 with the help of the method isPrime(see Method isPrime within the class).
    */
    public HashDataBase (int size, String fileName)
    {
	while (this.isPrime (size) == false || size < 5)
	    size = size + 1;
	this.physicalSize = size;
	this.dataBase = new DBRecord [this.physicalSize];
	this.textInput = new TextInputFile (fileName);
	this.logicalSize = 0;
    }
    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: December 13 2017
    Purpose: Given NO PARAMETERS, sets the INTEGER type data field (logicalSize) to 0, the INTEGER type data field (physicalSize) to 5, the TEXTINPUTFILE type data field to a new Instance of a TEXTINPUTFILE class with "videodb.csv.txt" 
	     as its parameter and the DBRecord [] type data field (dataBase) to a DBRecord [] with a physical size of 5 as its default values by calling the Constructor (with TWO PARAMETERS).
    Input: None
    Output: None - initializes the INTEGER type data field (logicalSize) to 0,the INTEGER type data field (physicalSize) to 5, the TEXTINPUTFILE type data field to a new Instance of a TEXTINPUTFILE class with "videodb.csv.txt" 
	    as its parameter and the DBRecord [] type data field (dataBase) to a DBRecord [] with a physical size of 5 as its default values.
    */
    public HashDataBase ()
    {
	this (5, "videodb.csv.txt");
    }


    // -------------------------------------------------------------------------------------------------------

    // isPrime

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Given an INTEGER parameter value (num), returns a BOOLEAN value according to if the INTEGER parameter value (num) is a PRIME number or not.
	     - returns true if INTEGER parameter value (num) is a PRIME number
	     - returns false otherwise.
    Input: An INTEGER parameter value (num)
    Output: returns a BOOLEAN value according to if the INTEGER parameter value (num) is a PRIME number or not.
	    - returns true if INTEGER parameter value (num) is a PRIME number
	    - returns false otherwise.
    */
    public boolean isPrime (int num)
    {
	int divisor = 3;
	int quotient = -1;
	boolean prime = false;
	if (num == 2 || num == 3 || num == 5 || num == 7)
	    prime = true;
	else if (num < 2 || num % 2 == 0)
	    prime = false;
	else
	{
	    while (quotient != 0 && divisor <= Math.sqrt (num))
	    {
		quotient = num % divisor;
		if (quotient == 0)
		    prime = false;
		else
		{
		    quotient = num / divisor;
		    divisor = divisor + 2;
		    prime = true;
		}
	    }
	}
	return prime;
    }


    // ======================================================================================================

    // isFull

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Based on the INTEGER type data fields (logicalSize + physicalSize), returns a BOOLEAN value corresponding to whether the number of VALID records in the DBRecord[] type datafield (dataBase) occupy atleast 70 percent
	     of the entire dataBase storage space
	     - returns true if the number of records occupying the DBRecord [] type data field (dataBase) are 70 percent or higher of the total storage space in the dataBase (logicalSize/physicalSize > 0.7)
	     - returns false otherwise
    Input: None
    Output: A BOOLEAN value corresponding to whether the number of VALID records in the DBRecord[] type datafield (dataBase) occupy atleast 70 percent of the entire dataBase storage space
    */
    public boolean isFull ()
    {
	boolean full = false;
	if (((this.logicalSize / this.physicalSize) * 100) > 70)
	    full = true;
	return full;
    }


    // -------------------------------------------------------------------------------------------------------

    // hash

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Given two INTEGER parameter values (id + counter), returns an INTEGER value residing between 0 and the INTEGER type data field (physicalSize) - 1 by using a mathematical algorithm/hash function that use modulus division
	     on the INTEGER parameter value (id). In addition, the method also calls another method doubleHash (see Method doubleHash within class) to add onto the first INTEGER value from the hash function and uses the INTEGER 
	     parameter value (counter) as a SCALAR multiplier to return a different INTEGER index value in case of collisions.
    Input: TWO INTEGER parameter values (id + counter)
    Output: An INTEGER value residing between 0 and the INTEGER type data field (physicalSize) - 1 using a two mathematical algorithm/hash function that both use modulus division on the INTEGER parameter value (id) and a SCALAR 
	    multiplier (INTEGER parameter value [counter]).
    */
    public int hash (int id, int counter)
    {
	return (id % this.physicalSize + (counter * this.doubleHash (id))) % this.physicalSize;
    }


    // ======================================================================================================

    // doubleHash

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Given an INTEGER parameter value (id), returns an INTEGER value by using a secondary hash function with the help of modulus division that resides between 0 and the INTEGER type data field (physicalSize) - 2. To be used 
	     in case of collisions within the hash method.
    Input: An INTEGER parameter value (id)
    Output: An INTEGER value that reides between 0 and the INTEGER type data field (physicalSize) - 2 with the use of a unique secondary hash function.
    */
    public int doubleHash (int id)
    {
	return (this.physicalSize - 2) - (id % (this.physicalSize - 2));
    }


    // -------------------------------------------------------------------------------------------------------

    // rehash

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Based on the return value of the method isFull(see Method isFull), changes the value of the INTEGER type data field (physicalSize) by increasing it so that the physicalSize data field is 20 percent larger but still remains
	     a PRIME number - the return value is true. With the help of the hash method (see Method hash), the DBRecords from the DBRecord [] type datafield (dataBase) are rearranged into different locations with collision checks and 
	     the DBRecord [] type data field (dataBase) is set to a larger storage space dataBase with the same data.
	     - If return value is false, depending on the changes to the records in the dataBase prior (Ex. delete), the records may remain the same.
    Input: None
    Output: None - the physicalSize data field (INTEGER) is increased by 20 percent of its original value and possibly more to have the aspect of PRIME only if the return value of the method isFull(see Method isFull within class) is true.
	    Hence, the DBRecords within the DBRecord [] type datafield (dataBase) will have to rehash or hash all the records again into a larger storage space dataBase.If return value is false, depending on the changes to the records in 
	    the dataBase prior (Ex. delete), the records may remain the same.
    */
    public void rehash ()
    {
	int counter = 0;
	int hash = 0;
	if (this.isFull ())
	{
	    int size = (this.physicalSize * 12) / 10;
	    while (this.isPrime (size) == false)
		size = size + 1;
	    this.physicalSize = size;
	}
	DBRecord[] dataStorage = new DBRecord [this.physicalSize];
	for (int i = 0 ; i < this.dataBase.length ; i++)
	{
	    if (this.dataBase [i] != null)
	    {
		counter = 0;
		hash = this.hash (this.dataBase [i].id, 0);
		while (dataStorage [hash] != null)
		{
		    hash = this.hash (this.dataBase [i].id, counter);
		    counter = counter + 1;
		}
		dataStorage [hash] = this.dataBase [i];
	    }
	}
	this.dataBase = dataStorage;
    }


    // ======================================================================================================

    // peek

    /*
    Author: Swethan Sivasegaran
    Date: December 14 2017
    Purpose: Given a CONSOLE type parameter value, prints the DBRecord information or NULL if there is no record and its respective Index location within the DBRecord [] type data field (dataBase)
	     (See Method toString for the presentation of DBrecord information).
    Input: A CONSOLE type parameter value
    Output: None - prints the DBRecord information or NULL if there is no record and its respective Index location within the DBRecord [] type data field (dataBase).
    */
    public void peek (Console c)
    {
	for (int i = 0 ; i < this.physicalSize ; i++)
	{
	    c.print ("Index " + (i + 1) + ":");
	    if (this.dataBase [i] != null)
		c.println (this.dataBase [i].toString ());
	    else
		c.println ("Null");
	}
    }


    // -------------------------------------------------------------------------------------------------------

    // insert

    /*
    Author: Swethan Sivasegaran
    Date: December 15 2017
    Purpose: Given a CONSOLE type parameter value and a DBRECORD type parameter value, inserts the DBRecord into the DBRecord [] type data field (dataBase) with the help of the hash method (see Method hash within class)
	     and checks for collisions. In addition, the number of collisions are printed into the Console.
    Input: A CONSOLE type parameter value and a DBRECORD type parameter value
    Output: None - inserts the DBRecord into the DBRecord [] type data field (dataBase) with the help of the hash method (see Method hash within class) and checks for collisions. In addition, the number of collisions are 
	    printed into the Console.
    */
    public void insert (Console c, DBRecord record)
    {
	int hash = 0;
	int counter = 0;
	this.logicalSize = this.logicalSize + 1;
	this.rehash ();
	hash = this.hash (record.id, 0);
	while (this.dataBase [hash] != null)
	{
	    counter = counter + 1;
	    hash = this.hash (record.id, counter);
	}
	this.dataBase [hash] = record;
	c.println ("Collisions: " + counter);
    }


    // ======================================================================================================

    // search

    /*
    Author: Swethan Sivasegaran
    Date: December 15 2017
    Purpose: Given an INTEGER type parameter value (DBRecord id), returns an INTEGER value corresponding to the location of the DBRecord with the DBRecord id within the parameters using the hash method
	     (see Method hash within class) and collision checking.
	     - returns -1 if a DBRecord with the same DBRecord id was not found
    Input: An INTEGER type parameter value (DBRecord id)
    Output: An INTEGER value corresponding to the location of the DBRecord with the DBRecord id within the parameters using the hash method (see Method hash within class) and collision checking.
    */
    public int search (int id)
    {
	boolean stop = false;
	int index = 0;
	int counter = 0;
	index = this.hash (id, counter);
	while (this.dataBase [index] != null && stop == false)
	{
	    if (this.dataBase [index].id == id)
		stop = true;
	    else
	    {
		counter = counter + 1;
		index = this.hash (id, counter);
	    }
	}
	if (stop == false)
	    index = -1;
	return index;
    }


    // -------------------------------------------------------------------------------------------------------

    // add

    /*
    Author: Swethan Sivasegaran
    Date: December 15 2017
    Purpose: Given a CONSOLE type parameter value, reads a line of text from the TEXTINPUTFILE type data field (textInput) containing all the information for a DBRecord in the order of id, title, type, cost, dist, date.
	     Using the insert method (see METHOD insert within the class), creates a new instance of a DBRecord and inserts it into the DBRecord [] type datafield (dataBase).
	     - editChecks to see if there are any more lines of text to read from the file so that nothing will occur if a programmer attempts to add a DBRecord to the dataBase when there is nothing else to read from
    Input: A CONSOLE type parameter value
    Output: None - creates a new instance of a DBRecord from reading a line of text within the TEXTINPUTFILE type data field (textInput) and inserts it into the DBRecord [] type datafield (dataBase) using the insert Method
	    (see METHOD insert within the class)
	    - editChecks to see if there are any more lines of text to read from the file so that nothing will occur if a programmer attempts to add a DBRecord to the dataBase when there is nothing else to read from
    */
    public void add (Console c)
    {
	String dataBase = "";
	StringTokenizer info = null;
	DBRecord record = null;
	if (this.textInput != null)
	{
	    if (!this.textInput.eof ())
	    {
		dataBase = this.textInput.readLine ();
		info = new StringTokenizer (dataBase, ",");
		record = new DBRecord (Integer.parseInt (info.nextToken ()), info.nextToken (), info.nextToken (), Double.parseDouble (info.nextToken ()), info.nextToken (), info.nextToken ());
		this.insert (c, record);
	    }
	    else
	    {
		this.textInput.close ();
		this.textInput = null;
	    }
	}
    }


    // ======================================================================================================

    // find

    /*
    Author: Swethan Sivasegaran
    Date: December 15 2017
    Purpose: Given a CONSOLE type parameter value and an INTEGER type parameter value (id), calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase)
	     and prints onto the Console whether the record was found or not. If the record was found, the DBRecord information is printed as well.
    Input: A CONSOLE type parameter value and an INTEGER type parameter value
    Output: None - calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase) and prints onto the Console whether the record was found or not. If the 
	    record was found, the DBRecord information is printed as well.
    */
    public void find (Console c, int id)
    {
	int index = 0;
	index = this.search (id);
	if (index != -1)
	    c.println("Record " + id + ": " + this.dataBase [index].toString ());
	else
	    c.println("Record " + id + ": Not Found");
    }


    // -------------------------------------------------------------------------------------------------------
    // delete

    /*
    Author: Swethan Sivasegaran
    Date: December 15 2017
    Purpose: Given a CONSOLE type parameter value and an INTEGER type parameter value (id), calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase). If the record
	     is found, the location within the DBRecord [] type data field (dataBase) is deleted or now points to null and the INTEGER type data field (logicalSize) is decreased by 1. The method reHash (see Method rehash within class)
	     is called to reorganize the data to ensure any collisions at the location that pointed to null is shifted back to ensure direct access to any record and to idea of a O(1) algorithm.
    Input: A CONSOLE type parameter value and an INTEGER type parameter value.
    Output: None - calls the method search (see Method search within the class) to find the index within the DBRecord [] type data field (dataBase). If the record is found, the location within the DBRecord [] type data field (dataBase)
	    is deleted or now points to null and the INTEGER type data field (logicalSize) is decreased by 1. The DBRecord within the dataBase are rearranged with the method reHash (see Method rehash within class) to shift back all 
	    collisions at the index.
    */
    public void delete (Console c, int id)
    {
	int index = 0;
	index = this.search (id);
	if (index != -1)
	{
	    this.dataBase [index] = null;
	    this.logicalSize --;
	    this.rehash ();
	}
    }


    // ======================================================================================================
}


//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-


