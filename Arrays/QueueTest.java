/***************************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: familiarize with the ADT queue using arrays
Input: keyboard
Output: console
***************************************************/

// The "QueueTest" class.
import java.awt.*;
import hsa.Console;

/*****************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: utilize the queue implementations
Fields_
-none
Methods_
-main: executes the code
*****************************************/

public class QueueTest
{
    static Console c;           // The output console
    static Console d;
    
/*************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: executes the code
Parameters: none
Return: none
*************************/
    
    public static void main (String[] args)
    {
	c = new Console ();
	d = new Console ();
	
	Queue myQueue = null;
	int userChoice = -1;
	int count = 0;
	char again = 'y';
	
	while (again == 'y' || again == 'Y') {
	    while (userChoice < 1 || userChoice > 5) {
		c.clear ();
		c.println ("What queue implementation would you like to use?");
		c.println ("[1] Straight-Line Array\n[2] Circular Array\n[3] Shifted Array(1.0)\n[4] Shifted Array(2.0)\n[5] Linked-List ");
		userChoice = c.readInt ();
	    }
	    c.clear ();
	    if (userChoice == 1)
		myQueue = new Straight ();
	    else if (userChoice == 2)
		myQueue = new Circular ();
	    else if (userChoice == 3)
		myQueue = new Shift1 ();
	    else if (userChoice == 4)
		myQueue = new Shift2 ();
	    else if (userChoice == 5)
		myQueue = new Singly ();
		
	    userChoice = (myQueue.getAction (c));
	    while (userChoice != 4) {
		if (userChoice == 1){
		    count++;
		    myQueue.add (count, c);
		}
		else if (userChoice == 2)
		    myQueue.remove (c);
		else if (userChoice == 3)
		    myQueue.reset ();
		userChoice = (myQueue.getAction (c));
	    }
	    
	    c.println ("\n\nWould you like to try again with another queue?");
	    c.println ("Enter [Y] if yes, or any other character if you wish to exit");
	    again = c.getChar();
	    userChoice = -1;
	}
	// Place your program here.  'c' is the output console
    } // main method
} // QueueTest class

///////////////////////////////////////////////////////////////////////////////////////////////////

/******************************************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: the superclass of all queues
Fields_
-size: the physical size of the queue
-front: points to the item that would be removed next
-back: points to the position where the next item would be inserted
-queue: the current queue
Methods_
-constuctor: initializes all the fields
-getAction: asks the user to input data
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-reset: sets all fields to 0
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
******************************************************************/

abstract class Queue
{
    int size;
    int front;
    int back;
    int [] queue;
    String type;

/**********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: initializes all the fields
Parameters: none
Return: none
**********************************/
    
    public Queue ()
    {
	this.size = 10;
	this.front = 0;
	this.back = 0;
	this.queue = new int [10];
	this.type = "";
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: asks the user to input data
Parameters: c (Console)
Return: choice (Integer)
***********************************/
    
    public int getAction (Console c)
    {
	int choice = 0;
	
	while (choice < 1 || choice > 4) {
	    c.clear ();
	    c.println ("Now using " + this.type + " Implementation");
	    c.println ("What would you like to do?");
	    c.println ("[1] add\n[2] remove\n[3] reset\n[4] exit");
	    choice = c.readInt ();
	}
	return choice;
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer)
Return: none
*********************************************/

    public void add (int info)
    {
	this.queue [this.back] = info;
	this.back++;
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: none
Return: none
*******************************************/

    public void remove ()
    {
	this.front++;
    }

/****************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: sets all fields to 0
Parameters: none
Return: none
****************************/

    public void reset ()
    {
	this.front = 0;
	this.back = 0;
	this.queue = new int [10];
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    abstract public boolean isFull ();

/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    abstract public boolean isEmpty ();

/***************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the state of the queue
Parameters: c (Console)
Return: none
***************************************/

    abstract public void display (Console c);
}

///////////////////////////////////////////////////////////////////////////////////////////////////

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: 
Fields_
none
Methods_
-constuctor: calls super's constructor
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
*******************************************/

class Straight extends Queue
{

/*********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: calls super's constructor
Parameters: none
Return: none
*********************************/

    public Straight ()
    {
	super ();
	this.type = "Straight-Line Array";
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer), c (Console)
Return: none
*********************************************/

    public void add (int info, Console c)
    {
	if (!isFull ())
	    super.add (info);
	this.display (c);
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: c (Console)
Return: none
*******************************************/

    public void remove (Console c)
    {
	if (!isEmpty ())
	    super.remove ();
	this.display (c);
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    public boolean isFull ()
    {
	boolean full = false;
	if (this.back >= this.queue.length)
	    full = true;
	return full;
    }

/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }
    
/***********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the current state of the queue
Parameters: c (Console)
Return: none
***********************************************/

    public void display (Console c)
    {
	int x = 50;
	int y = 50;
	
	for (int i = this.front; i < this.queue.length; i++){
	    c.clear ();
	    if (i == this.front) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Front", x + 15, y + 15);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	    else if (i == this.back) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Back", x + 15, y + 35);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = 50;
	    }
	    else {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	}
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: 
Fields_
none
Methods_
-constuctor: initializes all the fields
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
*******************************************/

class Circular extends Queue
{

/*********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: calls super's constructor
Parameters: none
Return: none
*********************************/

    public Circular ()
    {
	super ();
	this.type = "Circular Array";
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer), c (Console)
Return: none
*********************************************/

    public void add (int info, Console c)
    {
	if (!isFull ())
	    super.add (info);
	else {
	    this.back = 0;
	    super.add (info);
	}
	this.display (c);
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: c (Console)
Return: none
*******************************************/

    public void remove (Console c)
    {
	if (!isEmpty ())
	    super.remove ();
	else if (this.front > this.queue.length)
	    this.front = 0;
	this.display (c);
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    public boolean isFull ()
    {
	boolean full = false;
	if (this.back + 1 == this.front || this.back == this.queue.length - 1 && this.front == 0)
	    full = true;
	return full;
    }

/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front + 1 == this.back || this.front == this.queue.length - 1 && this.back == 0)
	    empty = true;
	return empty;
    }
    
/***********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the current state of the queue
Parameters: c (Console)
Return: none
***********************************************/

    public void display (Console c)
    {
	int x = 50;
	int y = 50;
	
	for (int i = this.front; i + 1 < this.queue.length; i++){
	    c.clear ();
	    if (i == this.front) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Front", x + 15, y + 15);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	    else if (i == this.back) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Back", x + 15, y + 35);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = 50;
	    }
	    else {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	}
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

/************************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: 
Fields_
none
Methods_
-constuctor: initializes all the fields
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-shift: moves the items to the front of the queue
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
************************************************/

class Shift1 extends Queue
{

/*********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: calls super's constructor
Parameters: none
Return: none
*********************************/

    public Shift1 ()
    {
	super ();
	this.type = "Shifted Array(1.0)";
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer), c (Console)
Return: none
*********************************************/

    public void add (int info, Console c)
    {
	if (this.back == this.queue.length - 1)
	    this.shift ();
	if (!isFull ())
	    super.add (info);
	else
	    c.println ("The queue is full\nYou must remove an item first");
	this.display (c);
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: c (Console)
Return: none
*******************************************/

    public void remove (Console c)
    {
	if (!isEmpty ())
	    super.remove ();
	this.display (c);
    }

/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: moves items to the front of the queue
Parameters: none
Return: none
*********************************************/

    public void shift ()
    {
	for (int i = 0; i < this.back - this.front + 1; i++) //keep + 1 or remove it?
	    this.queue [i] = this.queue [i + this.front];
	this.back = this.back - this.front;
	this.front = 0;
    }
    
/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    public boolean isFull ()
    {
	boolean full = false;
	if (this.back == this.queue.length - 1)
	    full = true;
	return full;
    }

/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }
    
/***********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the current state of the queue
Parameters: c (Console)
Return: none
***********************************************/

    public void display (Console c)
    {
	int x = 50;
	int y = 50;
	
	for (int i = this.front; i + 1 < this.queue.length; i++){
	    c.clear ();
	    if (i == this.front) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Front", x + 15, y + 15);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	    else if (i == this.back) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Back", x + 15, y + 35);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = 50;
	    }
	    else {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	}
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: 
Fields_
none
Methods_
-constuctor: initializes all the fields
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
*******************************************/

class Shift2 extends Queue
{

/*********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: calls super's constructor
Parameters: none
Return: none
*********************************/

    public Shift2 ()
    {
	super ();
	this.type = "Shifted Array(2.0)";
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer), c (Console)
Return: none
*********************************************/

    public void add (int info, Console c)
    {
	if (!isFull ())
	    super.add (info);
	else
	    c.println ("The queue is full\nYou must remove an item first");
	this.display (c);
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: c (Console)
Return: none
*******************************************/

    public void remove (Console c)
    {
	for (int i = 0; i < this.back - 1; i++)
	    this.queue [i] = this.queue [i + 1];
	this.back--;
	this.display (c);
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    public boolean isFull ()
    {
	boolean full = false;
	if (this.back == this.queue.length - 1)
	    full = true;
	return full;
    }

/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.front == this.back)
	    empty = true;
	return empty;
    }
    
/***********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the current state of the queue
Parameters: c (Console)
Return: none
***********************************************/

    public void display (Console c)
    {
	int x = 50;
	int y = 50;
	
	for (int i = this.front; i + 1 < this.queue.length; i++){
	    c.clear ();
	    if (i == this.front) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Front", x + 15, y + 15);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	    else if (i == this.back) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Back", x + 15, y + 35);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = 50;
	    }
	    else {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString (this.queue [i] + "", x + 20, y + 20);
		x = x + 50;
	    }
	}
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: 
Fields_
-next: the item next to the current one
Methods_
-constuctor: initializes all the fields
-add: adds an item to the back of the queue
-remove: removes the first item of the queue
-isFull: checks if the queue is full
-isEmpty: checks if the queue is empty
-display: displays the state of the queue
*******************************************/

class Singly extends Queue
{
    Node list;
    
/*********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: calls super's constructor
Parameters: none
Return: none
*********************************/

    public Singly ()
    {
	super ();
	this.type = "Linked-List";
	this.list = null;
	this.size = 0;
    }
    
/*********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: adds an item to the back of the queue
Parameters: info (Integer), c (Console)
Return: none
*********************************************/

    public void add (int info, Console c)
    {
	if (this.list == null)
	    this.list = new Node (info);
	else {
	    Node temp = this.list;
	    while (temp.next != null)
		temp = temp.next;
	    temp.next = new Node (info);
	}
	this.size++;
	this.display (c);
    }

/*******************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: removes the first item of the queue
Parameters: c (Console)
Return: none
*******************************************/

    public void remove (Console c)
    {
	if (this.list != null) {
	    if (this.list.next == null)
		this.list = null;
	    else
		this.list = this.list.next;
	    this.size--;
	}
	this.display (c);
    }

/***********************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is full
Parameters: none
Return: full (Boolean)
***********************************/

    public boolean isFull ()
    {
	boolean full = false;
	if (this.list != null)
	    full = true;
	return full;
    }
    
/************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: checks if the queue is empty
Parameters: none
Return: empty (Boolean)
************************************/

    public boolean isEmpty ()
    {
	boolean empty = false;
	if (this.list == null)
	    empty = true;
	return empty;
    }
    
/***********************************************
Author: Michael Jiang
Date: 01/21/2018
Purpose: displays the current state of the queue
Parameters: c (Console)
Return: none
***********************************************/

    public void display (Console c)
    {
	int x = 50;
	int y = 50;
	
	Node temp = this.list;
	while (temp != null){
	    c.clear ();
	    if (temp == this.list) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Front", x + 15, y + 15);
		c.drawString (temp.data + "", x + 20, y + 20);
		x = x + 50;
	    }
	    else if (temp.next == null) {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString ("Back", x + 15, y + 35);
		c.drawString (temp.data + "", x + 20, y + 20);
		x = 50;
	    }
	    else {
		c.drawRect (x, y, x + 50, y + 50);
		c.drawString (temp.data + "", x + 20, y + 20);
		x = x + 50;
	    }
	    temp = temp.next;
	}
    }
}

/**********************************************
Author: Michael Jiang
Date: 01/07/2018
Purpose: contain the information of the node
Fields_
-data: holds the data of the Node
-next: points to the Node after this Node
Methods_
-constructor: initializes the value of the Node
**********************************************/

class Node
{
    int data;
    Node next;
    
/******************************************
Author: Michael Jiang
Date: 01/07/2018
Purpose: initializes the values of the Node
Parameters: info (Integer)
Return: none
******************************************/

    public Node (int info)
    {
	this.data = info;
	this.next = null;
    }
}
