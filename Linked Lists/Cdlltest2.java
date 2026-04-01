// The "Cdlltest2" class.
import java.awt.*;
import hsa.Console;

public class Cdlltest2
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console (40,100);
	CircularDoublyLL test1 = new CircularDoublyLL ();
	boolean pass = false;
	int counter = 0;
	while (!pass)
	{
	    int userValue1 = 0;
	    int userValue2 = 0;
	    char yesOrNo = ' ';
	    String toDelete = " ";
	    c.println("Please enter a integer value you want to insert into the list: ");
	    userValue1 = c.readInt();
	    c.println("Please enter a key integer value you want to insert left of: ");
	    userValue2 = c.readInt();
	    test1.insertLeft(userValue1, userValue2);
	    c.println(test1.toStringLeft());
	    c.println(test1.toStringRight());
	    if (counter == 1)
	    {
		c.println("Do you want to delete a value? <Y/N>");
		toDelete = c.readString();
		if (toDelete.equals("y") || toDelete.equals("Y"))
		{ 
		    c.println("Please enter a integer value to delete: ");
		    test1.delete(c.readInt());
		    c.println(test1.toStringLeft());
		    c.println(test1.toStringRight());
		}
	    }
	    c.println("Do you want to continue? <Y/N> ");
	    yesOrNo = c.readChar();
	    if (yesOrNo == 'N' || yesOrNo == 'n')
	    {
		pass = true;
	    }
	    counter = 1;
	    c.clear();
	}
	// Place your program here.  'c' is the output console
    } // main method
} // Cdlltest2 class
/*
Author: Eric Su
Date: Dec 15, 2017
Purpose: To create a node class
 Data Element
    data: A integer, that holds a value
    next: A Node, a pointer to the next node
    prev: A Node, a pointer to the previous node
 Methods (None)
*/
class Node
{
    public int data;
    public Node next;
    public Node prev;
    
    public Node(int data)
    {
	this.data = data;
	this.next = null;
	this.prev = null;
    }
}
/*
Author: Eric Su
Date: Dec 15, 2017
Purpose: To create a circular doubly linked list
 Data Element
    header: A node that contains the size and points to itself unless specified
 Methods:
    numNodes: Returns the number of nodes  (the header's data value).
    insertLeft: Insert a Node to the left of a value if found, else insert left of the header.
    delete: Delete a node, given a value
    toStringRight: Return a string containing all the nodes from the right of the header.
    toStringLeft: Return a string containing all the nodes from the left of the header.
*/
class CircularDoublyLL
{
    protected Node header;

    public CircularDoublyLL(int size)
    {
	this.header = new Node(size);
	this.header.next = this.header;
	this.header.prev = this.header;
    }
    
    public CircularDoublyLL()
    {
	this (0);
    }
    /*
    Author: Eric Su
    Date: Dec 15, 2017
    Purpose: Returns the number of nodes
    Paramter: None
    Output: this.header.data
    */
    public int numNodes()
    {
	return this.header.data;
    }
    /*
    Author: Eric Su
    Date: Dec 16, 2017
    Purpose: Insert a Node to the left of a value if found, else insert left of the header.
    Paramter: int value, int key
    Output: None
    */
    public void insertLeft(int value, int key)
    {
	Node newNode = new Node (value);
	if (this.header.next == this.header)
	{
	    this.header.next = newNode;
	    newNode.prev = newNode;
	    newNode.next = newNode;
	}
	else
	{
	    Node tempNode = this.header.next;
	    while (tempNode.next != this.header.next && tempNode.data != key)
	    {
		tempNode = tempNode.next;
	    }
	    if (tempNode.data != key)
	    {
		tempNode.prev.next = newNode;
		newNode.prev = tempNode.prev;
		newNode.next = tempNode;
		tempNode.prev = newNode;
		this.header.next = newNode;
	    }
	    else
	    {
		tempNode.prev.next = newNode;
		newNode.prev = tempNode.prev;
		newNode.next = tempNode;
		tempNode.prev = newNode;
		if (this.header.next.data == key)
		{
		    this.header.next = newNode;
		}
	    }
	    
	}
	this.header.data++;
    }
    /*
    Author: Eric Su
    Date: Dec 17, 2017
    Purpose: Delete a node, given a value
    Paramter: int value
    Output: None
    */
    public void delete (int value)
    {
	if (this.header.next == this.header)
	{
	    this.header.next = this.header;
	}
	else
	{
	    Node tempNode = this.header.next;
	    while (tempNode.next != this.header.next && tempNode.data != value)
	    {
		tempNode = tempNode.next;
	    }
	    if (tempNode.data != value)
	    {
		tempNode.data = tempNode.data;
	    }
	    else if (tempNode.data == value)
	    {
		if (this.header.next.data == value)
		{
		    if(this.header.next.next == this.header.next)
		    {
			this.header.next = this.header;
		    }
		    else
		    {
			this.header.next = this.header.next.next;
			tempNode.prev.next = tempNode.next;
			tempNode.next.prev = tempNode.prev;
		    }
		}
		else
		{
		    tempNode.prev.next = tempNode.next;
		    tempNode.next.prev = tempNode.prev;
		}
		this.header.data --;
	    }
	}
    }
    /*
    Author: Eric Su
    Date: Dec 18, 2017
    Purpose: Return a string containing all the nodes from the right of the header.
    Paramter: None
    Output: result
    */
    public String toStringRight()
    {
	String result = "";
	result += "Circular Doubly Linked List (R) = ";
	if (this.header.next == this.header)
	{
	    result += "Header -> {Empty";
	}
	else if (this.header.data == 1)
	{
	    result += "Header -> {" + this.header.next.data + " <-> " ;
	}
	else
	{
	    Node temp = this.header.next;
	    result += "Header -> {";
	    result += (temp.data + " <-> ");
	    while (temp.next != this.header.next)
	    {
		temp = temp.next;
		result += temp.data + " <-> ";
	    }
	 }
	 result += "} | Size: " + this.header.data;
	 return result;
    }
    /*
    Author: Eric Su
    Date: Dec 18, 2017
    Purpose: Return a string containing all the nodes from the left of the header.
    Parameter: None
    Output: result
    */
    public String toStringLeft()
    {
	String result = "";
	result += "Circular Doubly Linked List (L) = ";
	if (this.header.next == this.header)
	{
	    result += "Header -> {Empty";
	}
	else if (this.header.data == 1)
	{
	    result += "Header -> {" + this.header.next.data + " <-> ";
	}
	else
	{
	    Node temp = this.header.next.prev;
	    result += "Header -> {" + this.header.next.data + " <-> ";
	    result += temp.data + " <-> ";
	    while (temp != this.header.next)
	    {
		temp = temp.prev;
		if (temp.next.prev != this.header.next)
		    result += temp.data + " <-> ";
	    }
	    
	 }
	 result += "} | Size: " + this.header.data;;
	 return result;
    }

}
