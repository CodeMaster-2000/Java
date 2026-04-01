// The "BinaryTreeTest" class.
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To demonstrate an understanding of BINARY TREES and the many important features of it in practical applications
*/

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-

//IMPORTS
import java.awt.*;
import hsa.Console;

// CLASS BINARYSEARCHTREETEST
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To demonstrate the capability and understanding of the concept of BINARY TREES and its recursive like features

DATA FIELDS - None

METHODS

main - To test the functionality of the BINARY TREE class and each individual method
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
public class BinarySearchTreeTest
{
    // main

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: To test the functionality of the BINARY TREE class and each individual method
    Input: None - the inputs recieved from the user
    Output: None - the outputs from each individual method
    */
    static Console c;
    static Console result;

    public static void main (String[] args)
    {
	c = new Console (40, 100);
	result = new Console ();
	int repeat = 1;
	int value = 0;
	while (repeat == 1)
	{
	    c.clear ();
	    result.clear ();
	    BinaryTree tree = new BinaryTree ();
	    c.setTextColor (Color.red);
	    c.println ("Binary Tree Testing");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter a 1 (to add INTEGER values) or any other key to work with an EMPTY TREE: ");
	    repeat = c.readInt ();
	    while (repeat == 1)
	    {
		c.clear ();
		result.clear ();
		c.setTextColor (Color.red);
		c.println ("Binary Tree Testing");
		c.setTextColor (Color.blue);
		c.print ("\nPlease enter an INTEGER value to insert into the binary tree: ");
		tree.add (c.readInt ());
		result.setTextColor (Color.red);
		result.println ("Result");
		result.setTextColor (Color.blue);
		tree.printTree (result);
		c.print ("\n\nPlease enter a 1 (to continue increasing tree) or any other key to stop: ");
		repeat = c.readInt ();
	    }
	    c.clear ();
	    c.setTextColor (Color.red);
	    c.println ("Result");
	    c.setTextColor (Color.blue);
	    c.println ("The Number of Nodes: " + tree.nodes ());
	    c.println ("The Height of Tree: " + tree.height ());
	    c.println ("The Status of Height Balanced: " + tree.heightBalanced ());
	    c.println ("The Status of Perfectly Balanced: " + tree.perfectlyBalanced ());
	    c.println ("PreOrder: " + tree.preOrder ());
	    c.println ("InOrder: " + tree.inOrder ());
	    c.println ("PostOrder: " + tree.postOrder ());
	    c.println ("BreadthFirstOrder: " + tree.breadthFirstOrder ());
	    c.setTextColor (Color.red);
	    c.println ("\n\nFind Sibling + GetLevel Method Test");
	    c.setTextColor (Color.blue);
	    c.print ("Please enter an INTEGER value within binary tree: ");
	    value = c.readInt ();
	    if (tree.findSibling (value) != null)
		c.println ("The Sibling of " + value + ": " + tree.findSibling (value).data);
	    else
		c.println ("The Sibling of " + value + ": NOT FOUND");
	    c.println ("The Level of " + value + ": " + tree.getLevel (value));
	    c.setTextColor (Color.blue);
	    c.print ("\n\nPlease enter a 1 (to restart program) or any other key to end program: ");
	    repeat = c.readInt ();

	}
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS NODE
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To act as a CONTAINER LIKE class that are used in BINARY TREE like applications to help organize and manage data in an efficient manner that includes the advantages of both linked lists and arrays

DATA FIELDS

data (INT) - An INTEGER data field that holds the NODE's INTEGER information
left (NODE) - A NODE data field that represents a NODE pointer to another NODE that typically has a smaller INTEGER value than the CURRENT NODE in applications such as BINARY TREES
right(NODE) - A NODE data field that represents a NODE pointer to another NODE that typically has a larger INTEGER value than the CURRENT NODE in applications such as BINARY TREES

METHODS

Constructor (with ONE PARAMETER) - Given an INTEGER parameter value, sets the INTEGER data field (data) to the given value and sets both the NODE type data fields (left + right) to NULL.

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the INTEGER data field (data) to 0 and the NODE type data fields (left + right) to NULL

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Node
{
    //DATA FIELDS
    protected int data = 0;
    protected Node left;
    protected Node right;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given an INTEGER parameter value, sets the INTEGER data field (data) to the given value and sets both the NODE type data fields (left + right) to NULL.
    Input: An INTEGER parameter value
    Output: None - sets the INTEGER data field (data) to the given value and sets both the NODE type data fields (left + right) to NULL.
    */
    public Node (int data)
    {
	this.data = data;
	this.left = null;
	this.right = null;
    }


    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given NO PARAMETERS, sets the INTEGER data field (data) to 0 and the NODE type data fields (left + right) to NULL
    Input: None
    Output: None - sets the INTEGER data field (data) to 0 and the NODE type data fields (left + right) to NULL
    */
    public Node ()
    {
	this (0);
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS QNODE
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To act as a CONTAINER like class for LINKED LIST implementations of QUEUE in which many applications in concepts like BINARY TREES take advantage of in achieving certain functions

DATA FIELDS

info (NODE) - A NODE type data field that represents the CURRENT QNODE's NODE information to be used as temporary hold in LINKED LIST implementations of a QUEUE to achieve results in methods within BINARY TREES
next (QNODE) - A QNODE type data field that represents a pointer to another QNODE to be used in applications such as LINKED LIST implementations of a QUEUE to achieve results in methods within BINARY TREES

METHODS

Constructor (with ONE PARAMETER) - Given a NODE type parameter value, sets the NODE data field (info) to the given value and sets the QNODE type data field (next) to NULL

Constructor (with NO PARAMETERS) - Given NO PARAMETER values, sets the NODE data field (info) and the QNODE type data field (next) to NULL

*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class QNode
{
    //DATA FIELDS
    protected Node info;
    protected QNode next;

    // Constructor (with ONE PARAMETER)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given a NODE type parameter value, sets the NODE data field (info) to the given value and sets the QNODE type data field (next) to NULL
    Input: A NODE parameter value
    Output: None - sets the NODE data field (info) to the given value and sets the QNODE type data field (next) to NULL
    */
    public QNode (Node info)
    {
	this.info = info;
	this.next = null;
    }


    // ======================================================================================================

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given NO PARAMETER values, sets the NODE data field (info) and the QNODE type data field (next) to NULL
    Input: None
    Output: None - sets the NODE data field (info) and the QNODE type data field (next) to NULL
    */
    public QNode ()
    {
	this (null);
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS QUEUE
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To act as a BASIC LINKED LIST implementation of a QUEUE for the purpose of helping manage BINARY TREE applications in achieving certain functions such as breadthFirstOrder NOTATION

DATA FIELDS

front (QNODE) - A QNODE type data field that represents the FIRST QNODE or element within a LINKED LIST implementation of a QUEUE
back (QNODE) - A QNODE type data field that represents the LAST QNODE or element within a LINKED LIST implementation of a QUEUE

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the QNODE data fields (front + back) to NULL

add - Given a NODE parameter value, the method calls isEmpty to determine if the QUEUE is empty or not (see Method isEmpty) and adds another QNODE with the GIVEN NODE PARAMETER value onto the end of the QUEUE such that the
      QNODE data field (back) points to it (ONLY when the QUEUE is ONE QNODE long) or the QNODE data field (back)'s QNODE data field (next) points to the new QNODE created with the GIVEN NODE PARAMETER value.

remove - Based on the QNODE data field (front), deletes the FIRST QNODE from the QUEUE and returns the DELETED QNODE

isEmpty - Based on the QNODE type data field (front), returns a BOOLEAN value corresponding to whether the QUEUE is empty or not
	  - returns TRUE if the QNODE type data field (front) is NULL
	  - returns FALSE otherwise
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class Queue
{
    //DATA FIELDS
    protected QNode front;
    protected QNode back;

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given NO PARAMETERS, sets the QNODE data fields (front + back) to NULL
    Input: None
    Output: None - sets the QNODE data fields (front + back) to NULL
    */
    public Queue ()
    {
	this.front = null;
	this.back = null;
    }


    // ======================================================================================================

    // add

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given a NODE parameter value, the method calls isEmpty to determine if the QUEUE is empty or not (see Method isEmpty) and adds another QNODE with the GIVEN NODE PARAMETER value onto the end of the QUEUE such that the
	     QNODE data field (back) points to it (ONLY when the QUEUE is ONE QNODE long) or the QNODE data field (back)'s QNODE data field (next) points to the new QNODE created with the GIVEN NODE PARAMETER value.
    Input: A NODE parameter value
    Output: None - the method calls isEmpty to determine if the QUEUE is empty or not (see Method isEmpty) and adds another QNODE with the GIVEN NODE PARAMETER value onto the end of the QUEUE
    */
    public void add (Node node)
    {
	if (this.isEmpty ())
	{
	    this.front = new QNode (node);
	    this.back = this.front;
	}
	else
	{
	    this.back.next = new QNode (node);
	    this.back = this.back.next;
	}
    }


    // -------------------------------------------------------------------------------------------------------
    // remove

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Based on the QNODE data field (front), deletes the FIRST QNODE from the QUEUE and returns the DELETED QNODE
    Input: None
    Output: Returns the FIRST NODE from the QUEUE and deletes it from the QUEUE
    */

    public Node remove ()
    {
	Node ans;

	ans = this.front.info;
	this.front = this.front.next;
	return ans;
    }


    // ======================================================================================================

    // isEmpty()

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Based on the QNODE type data field (front), returns a BOOLEAN value corresponding to whether the QUEUE is empty or not
	     - returns TRUE if the QNODE type data field (front) is NULL
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value corresponding to whether the QUEUE is empty or not
	     - returns TRUE if the QNODE type data field (front) is NULL
	     - returns FALSE otherwise
    */
    public boolean isEmpty ()
    {
	boolean status = false;
	if (this.front == null)
	    status = true;
	return status;
    }


    // -------------------------------------------------------------------------------------------------------
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
// CLASS BINARYTREE
/*
Author: Swethan Sivasegaran
Date: July 2 2018
Purpose: To organize and manage data through the concept of NODES and BINARY TREES such that it demonstrates a thorough understanding of recursion and BINARY TREE applications. The Class should demonstrate many properties of a
	 BINARY TREE in all possible cases.

DATA FIELDS

root (NODE) - A NODE type data field that represents the FIRST NODE or rather the middle of the BINARY TREE in which ADDITIONAL NODES are added based on this NODE'S INTEGER information
list (QUEUE) - A QUEUE type data field that is used in methods such as breadthFirstOrder in which it helps organize NODES within a BINARY TREE in such QUEUE like manner for this situation.

METHODS

Constructor (with NO PARAMETERS) - Given NO PARAMETERS, sets the NODE type data field (root) to NULL and sets the QUEUE type data field (list) to a NEW INSTANCE of the QUEUE class initialized as an EMPTY QUEUE

add - Given an INTEGER parameter value, creates a NEW INSTANCE of the NODE class with an INTEGER data field value equal to the GIVEN PARAMETER value and adds the NODE to the BINARY TREE. In addition, the method returns a
      BOOLEAN value according to whether the NEW NODE was added to the BINARY TREE or not
      - returns TRUE if the NODE was not a DUPLICATE INTEGER within the BINARY TREE and was succesfully added
      - returns FALSE otherwise

printTree - Prints the tree in a normal way.
	    (Can't handle super wide trees.)
	    -  Developed by Jonathan Chan, May 1997
	    -  Java version by Edmund Wong, Dec 2000
	    -  Modified by Ian Halliday, June 2001

rPrintTree [PROTECTED RECURSIVE] - see above

rHeight[PROTECTED RECURSIVE] - Given a NODE parameter value, returns an INTEGER value that CORRESPONDS to the GIVEN NODE parameter value's height within a BINARY TREE. The Method achieves this in a RECURSIVE manner.

height - Given NO PARAMETERS, the method returns an INTEGER value that corresponds to the CURRENT BINARY TREE's height which is the longest pathway that a BINARY TREE branches from its root. The Method achieves this
	 by calling the PROTECTED RECURSIVE rHeight method (see Method rHeight WITHIN class).

rNodes [PROTECTED RECURISVE] - Given a NODE parameter value, the method returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that branch out from the GIVEN NODE parameter value. The method achieves this in
			       a RECURSIVE manner.

nodes - Given NO PARAMETERS, the method returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that the CURRENT BINARY TREE contains by calling the PROTECTED RECURSIVE method rNodes (see Method rNodes
	WITHIN class).

rHeightBalanced [PROTECTED RECURSIVE] - Given a NODE parameter value, returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are height balanced. This is achieved in a RECURSIVE manner.
					- returns TRUE if the CURRENT NODE's left and right subtree HEIGHTS are atleast the same or 1 value apart
					- returns FALSE otherwise

heightBalanced - Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is height balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rHeightBalanced (see Method
		 rHeightBalanced WITHIN class).
		 - returns TRUE if the CURRENT BINARY TREE is height balanced
		 - returns FALSE otherwise

rPerfectlyBalanced [PROTECTED RECURSIVE] - Given a NODE parameter value, returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are perfectly balanced or not. The method achieves this in
					   a RECURSIVE manner.
					   - returns TRUE if the CURRENT NODE's left and right subtree are perfectly balanced
					   - returns FALSE otherwise

perfectlyBalanced - Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is perfectly balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rPerfectlyBalanced
		    (see Method rPerfectlyBalanced WITHIN class)
		    - returns TRUE if the CURRENT BINARY TREE is perfectly balanced
		    - returns FALSE otherwise

getLevel - Given an INTEGER parameter value, returns an INTEGER value corresponding to the LEVEL to which the NODE containing the INTEGER value equal to the GIVEN PARAMETER value lies on
	    - returns -1 if the CURRENT BINARY TREE is empty or if the INTEGER value did not exist within the BINARY TREE

findSibling - Given an INTEGER parameter value, returns a NODE value that corresponds to the SIBLING of the NODE that contains the INTEGER value equal to the GIVEN PARAMETER value.
	      - returns NULL if the NODE containing the GIVEN INTEGER PARAMETER value has no sibling or if it was the ROOT
	      - returns NULL if there was no NODE that contained the GIVEN INTEGER PARAMETER value within the BINARY TREE
	      Note: SIBLINGS are NODES that have the same PARENT such that they are respectively both the PARENT's left and right subtree NODE values

breadthFirstOrder - Given NO PARAMETERS, returns a STRING value that contains all the INTEGER data information in all the NODES within the CURRENT BINARY TREE in a certain order such that the NODE's INTEGER values from LEFT to RIGHT on each
		    LEVEL (starting from LEVEL 0) are outputted.

rPreOrder [PROTECTED RECURSIVE] - Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree's INTEGER information IN PREORDER notation. The method achieves this in a
				  RECURSIVE manner.

preOrder - Given NO PARAMETERS, returns a STRING value that corresponds to the CURRENT BINARY TREE NODE's INTEGER information in PREORDER notation. This is achieved by calling the PROTECTED RECURISVE method rPreOrder
	   (see Method rPreOrder WITHIN class).

rInOrder [PROTECTED RECURSIVE] - Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in INORDER notation. The method achieves this in a RECURSIVE manner.

inOrder - Given NO PARAMETERS, returns a STRING value that corresponds to the CURRENT BINARY TREE's INTEGER information in INORDER notation. This is achieved by calling the PROTECTED RECURSIVE method rInOrder
	  (see Method rInOrder WITHIN class)

rPostOrder [PROTECTED RECURSIVE] - Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in POSTORDER notation. The method achieves this in a
				   RECURSIVE manner.

postOrder - Given NO PARAMETERS, returns a STRING value that corresponds the CURRENT BINARY TREE's INTEGER information in POSTORDER notation. This is achieved by callin the PROTECTED RECURSIVE method rPostOrder (see Method rPostOrder
	    WITHIN class)
*/
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
class BinaryTree
{
    //DATA FIELDS
    protected Node root;
    protected Queue list;

    // Constructor (with NO PARAMETERS)

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given NO PARAMETERS, sets the NODE type data field (root) to NULL and sets the QUEUE type data field (list) to a NEW INSTANCE of the QUEUE class initialized as an EMPTY QUEUE
    Input: None
    Output: None - sets the NODE type data field (root) to NULL and sets the QUEUE type data field (list) to a NEW INSTANCE of the QUEUE class initialized as an EMPTY QUEUE
    */
    public BinaryTree ()
    {
	this.root = null;
	this.list = new Queue ();
    }


    // ======================================================================================================

    // add

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given an INTEGER parameter value, creates a NEW INSTANCE of the NODE class with an INTEGER data field value equal to the GIVEN PARAMETER value and adds the NODE to the BINARY TREE. In addition, the method returns a
	     BOOLEAN value according to whether the NEW NODE was added to the BINARY TREE or not
	     - returns TRUE if the NODE was not a DUPLICATE INTEGER within the BINARY TREE and was succesfully added
	     - returns FALSE otherwise
    Input: An INTEGER parameter value
    Output: The Method creates a NEW INSTANCE of the NODE class with an INTEGER data field value equal to the GIVEN PARAMETER value and adds the NODE to the BINARY TREE. In addition, the method returns a
	    BOOLEAN value according to whether the NEW NODE was added to the BINARY TREE or not
	    - returns TRUE if the NODE was not a DUPLICATE INTEGER within the BINARY TREE and was succesfully added
	    - returns FALSE otherwise
    */
    public boolean add (int data)
    {
	boolean add = true;
	if (this.root == null)
	    this.root = new Node (data);
	else
	{
	    Node temp = this.root;
	    while (add == true && temp != null)
	    {
		if (data > temp.data)
		{
		    if (temp.right != null)
			temp = temp.right;
		    else
			temp.right = new Node (data);
		}
		else if (data < temp.data)
		{
		    if (temp.left != null)
			temp = temp.left;
		    else
			temp.left = new Node (data);
		}
		else
		    add = false;
	    }
	}
	return add;
    }


    // -------------------------------------------------------------------------------------------------------
    // rPrintTree [PROTECTED RECURSIVE]

    /*
    Method: rprintTree
    Purpose: See above.
    Parameters: the console, the node being printed
		and the row to print on
    Return Value: The maximum row reached by
		  printing (allowing for useful
		  cursor placement)
    */
    protected int rprintTree (Console c, Node n, int r)
    {
	int maxRow;
	if (n != null)
	{
	    maxRow = rprintTree (c, n.left, r + 2);
	    c.setCursor (r, c.getColumn ());
	    c.print (n.data, 20);
	    maxRow = Math.max (maxRow, rprintTree (c, n.right, r + 2));
	    return maxRow;
	}
	return r - 1;
    }


    // ======================================================================================================
    // printTree

    /*
    Method:printTree
    Purpose:Prints the tree in a normal way.
	(Can't handle super wide trees.)
	-  Developed by Jonathan Chan, May 1997
	-  Java version by Edmund Wong, Dec 2000
	-  Modified by Ian Halliday, June 2001
    Parameters: The Console
    Return Value: None
    */
    public void printTree (Console c)
    {
	c.setCursor
	    (rprintTree (c, this.root, c.getRow ()), 1);
    }


    // -------------------------------------------------------------------------------------------------------
    // rHeight [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July 2 2018
    Purpose: Given a NODE parameter value, returns an INTEGER value that CORRESPONDS to the GIVEN NODE parameter value's height within a BINARY TREE. The Method achieves this in a RECURSIVE manner.
    Input: A NODE parameter value
    Output: Returns an INTEGER value that CORRESPONDS to the GIVEN NODE parameter value's height within a BINARY TREE. The Method achieves this in a RECURSIVE manner.
    */

    protected int rHeight (Node node)
    {
	int height = 0;
	if (node != null)
	{
	    if (this.rHeight (node.left) > this.rHeight (node.right))
		height = this.rHeight (node.left) + 1;
	    else
		height = this.rHeight (node.right) + 1;
	}
	return height;
    }


    // ======================================================================================================
    // height

    /*
    Author: Swethan Sivasegaran
    Date: July4 2018
    Purpose: Given NO PARAMETERS, the method returns an INTEGER value that corresponds to the CURRENT BINARY TREE's height which is the longest pathway that a BINARY TREE branches from its root. The Method achieves this
	     by calling the PROTECTED RECURSIVE rHeight method (see Method rHeight WITHIN class).
    Input: None
    Output: Returns an INTEGER value that corresponds to the CURRENT BINARY TREE's height which is the longest pathway that a BINARY TREE branches from its root
    */

    public int height ()
    {
	return this.rHeight (this.root);
    }


    // -------------------------------------------------------------------------------------------------------

    // rNodes [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July4 2018
    Purpose: Given a NODE parameter value, the method returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that branch out from the GIVEN NODE parameter value. The method achieves this in a RECURSIVE manner.
    Input: A NODE parameter value
    Output: Returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that branch out from the GIVEN NODE parameter value. The method achieves this in a RECURSIVE manner.
    */
    protected int rNodes (Node node)
    {
	int nodes = 0;
	if (node != null)
	{
	    nodes = 1;
	    if (node.left != null)
		nodes = nodes + this.rNodes (node.left);
	    if (node.right != null)
		nodes = nodes + this.rNodes (node.right);
	}
	return nodes;
    }


    // ======================================================================================================

    // nodes

    /*
    Author: Swethan Sivasegaran
    Date: July4 2018
    Purpose: Given NO PARAMETERS, the method returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that the CURRENT BINARY TREE contains by calling the PROTECTED RECURSIVE method rNodes (see Method rNodes
	     WITHIN class).
    Input: None
    Output: Returns an INTEGER value that corresponds to the TOTAL NUMBER of nodes that the CURRENT BINARY TREE contains by calling the PROTECTED RECURSIVE method rNodes (see Method rNodes WITHIN class).
    */
    public int nodes ()
    {
	return this.rNodes (this.root);
    }


    // -------------------------------------------------------------------------------------------------------
    // rHeightBalanced [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given a NODE parameter value, returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are height balanced. This is achieved in a RECURSIVE manner.
	     - returns TRUE if the CURRENT NODE's left and right subtree HEIGHTS are atleast the same or 1 value apart
	     - returns FALSE otherwise
    Input: A NODE parameter value
    Output: Returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are height balanced. This is achieved in a RECURSIVE manner.
	    - returns TRUE if the CURRENT NODE's left and right subtree HEIGHTS are atleast the same or 1 value apart
	    - returns FALSE otherwise
    */

    public boolean rHeightBalanced (Node node)
    {
	boolean balance = true;
	if (node != null)
	{
	    if (Math.abs ((this.rHeight (node.left) - this.rHeight (node.right))) > 1)
		balance = false;
	    else
	    {
		if (this.rHeightBalanced (node.left) == false || this.rHeightBalanced (node.right) == false)
		    balance = false;
	    }
	}
	return balance;
    }


    // ======================================================================================================

    // heightBalanced

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is height balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rHeightBalanced (see Method
	     rHeightBalanced WITHIN class).
	     - returns TRUE if the CURRENT BINARY TREE is height balanced
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is height balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rHeightBalanced (see Method
	    rHeightBalanced WITHIN class).
	    - returns TRUE if the CURRENT BINARY TREE is height balanced
	    - returns FALSE otherwise
    */
    public boolean heightBalanced ()
    {
	return this.rHeightBalanced (this.root);
    }


    // -------------------------------------------------------------------------------------------------------

    // rPerfectlyBalanced [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given a NODE parameter value, returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are perfectly balanced or not. The method achieves this in a RECURSIVE manner.
	     - returns TRUE if the CURRENT NODE's left and right subtree are perfectly balanced
	     - returns FALSE otherwise
    Input: A NODE parameter value
    Output: Returns a BOOLEAN value that corresponds to whether the CURRENT NODE's left and right subtree are perfectly balanced or not. The method achieves this in a RECURSIVE manner.
	    - returns TRUE if the CURRENT NODE's left and right subtree are perfectly balanced
	    - returns FALSE otherwise
    */
    protected boolean rPerfectlyBalanced (Node node)
    {
	boolean balance = true;
	if (node != null)
	{
	    if (Math.abs ((this.rNodes (node.left) - this.rNodes (node.right))) > 1)
		balance = false;
	    else
	    {
		if (this.rPerfectlyBalanced (node.right) == false || this.rPerfectlyBalanced (node.left) == false)
		    balance = false;
	    }
	}
	return balance;
    }


    // ======================================================================================================
    // perfectlyBalanced

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is perfectly balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rPerfectlyBalanced
	     (see Method rPerfectlyBalanced WITHIN class)
	     - returns TRUE if the CURRENT BINARY TREE is perfectly balanced
	     - returns FALSE otherwise
    Input: None
    Output: Returns a BOOLEAN value that corresponds to whether the CURRENT BINARY TREE is perfectly balanced or not. The method achieves this by calling the PROTECTED RECURSIVE method rPerfectlyBalanced
	    (see Method rPerfectlyBalanced WITHIN class)
	    - returns TRUE if the CURRENT BINARY TREE is perfectly balanced
	    - returns FALSE otherwise
    */

    public boolean perfectlyBalanced ()
    {
	return this.rPerfectlyBalanced (this.root);
    }


    // -------------------------------------------------------------------------------------------------------
    // getLevel

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given an INTEGER parameter value, returns an INTEGER value corresponding to the LEVEL to which the NODE containing the INTEGER value equal to the GIVEN PARAMETER value lies on
	     - returns -1 if the CURRENT BINARY TREE is empty or if the INTEGER value did not exist within the BINARY TREE
    Input: An INTEGER parameter value
    Output: Returns an INTEGER value corresponding to the LEVEL to which the NODE containing the INTEGER value equal to the GIVEN PARAMETER value lies on
	     - returns -1 if the CURRENT BINARY TREE is empty or if the INTEGER value did not exist within the BINARY TREE
    */

    public int getLevel (int data)
    {
	int level = 0;
	Node temp = this.root;
	while (temp != null && temp.data != data)
	{
	    if (data > temp.data)
		temp = temp.right;
	    else
		temp = temp.left;
	    level++;
	}
	if (temp == null)
	    level = -1;
	return level;
    }


    // ======================================================================================================

    // findSibling

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given an INTEGER parameter value, returns a NODE value that corresponds to the SIBLING of the NODE that contains the INTEGER value equal to the GIVEN PARAMETER value.
	     - returns NULL if the NODE containing the GIVEN INTEGER PARAMETER value has no sibling or if it was the ROOT
	     - returns NULL if there was no NODE that contained the GIVEN INTEGER PARAMETER value within the BINARY TREE
	     Note: SIBLINGS are NODES that have the same PARENT such that they are respectively both the PARENT's left and right subtree NODE values
    Input: An INTEGER parameter value
    Output: Returns a NODE value that corresponds to the SIBLING of the NODE that contains the INTEGER value equal to the GIVEN PARAMETER value.
	    - returns NULL if the NODE containing the GIVEN INTEGER PARAMETER value has no sibling  or if it was the ROOT
	    - returns NULL if there was no NODE that contained the GIVEN INTEGER PARAMETER value within the BINARY TREE
	    Note: SIBLINGS are NODES that have the same PARENT such that they are respectively both the PARENT's left and right subtree NODE values
    */
    public Node findSibling (int data)
    {
	Node temp = this.root;
	Node sibling = null;
	while (temp != null && temp.data != data)
	{
	    sibling = temp;
	    if (data > temp.data)
		temp = temp.right;
	    else
		temp = temp.left;
	}
	if (temp == null)
	    sibling = null;
	else
	{
	    if (this.root.data == data)
		sibling = null;
	    else
	    {
		if (sibling.left.data == data)
		    sibling = sibling.right;
		else
		    sibling = sibling.left;
	    }
	}
	return sibling;
    }


    // -------------------------------------------------------------------------------------------------------

    // breadthFirstOrder

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a STRING value that contains all the INTEGER data information in all the NODES within the CURRENT BINARY TREE in a certain order such that the NODE's INTEGER values from LEFT to RIGHT on each
	     LEVEL (starting from LEVEL 0) are outputted.
    Input: None
    Output: Returns a STRING value that contains all the INTEGER data information in all the NODES within the CURRENT BINARY TREE in a certain order such that the NODE's INTEGER values from LEFT to RIGHT on each LEVEL (starting from
	    LEVEL 0 to the LAST LEVEL) are outputted.
    */
    public String breadthFirstOrder ()
    {
	String result = "";
	if (this.root != null)
	{
	    Node node;
	    this.list.add (this.root);
	    while (!this.list.isEmpty ())
	    {
		node = this.list.remove ();
		result = result + node.data + " ";
		if (node.left != null)
		    this.list.add (node.left);
		if (node.right != null)
		    this.list.add (node.right);
	    }
	}
	return result;
    }


    // ======================================================================================================
    // rPreOrder [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree's INTEGER information IN PREORDER notation. The method achieves this in a RECURSIVE manner.
    Input: A NODE parameter value
    Output: Returns a STRING value that corresponds to the CURRENT NODE's left and right subtree's INTEGER information IN PREORDER notation. The method achieves this in a RECURSIVE manner.
    */

    protected String rPreOrder (Node node)
    {
	String result = "";
	if (node != null)
	    result = result + node.data + " " + this.rPreOrder (node.left) + this.rPreOrder (node.right);
	return result;
    }


    // -------------------------------------------------------------------------------------------------------
    // preOrder

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a STRING value that corresponds to the CURRENT BINARY TREE NODE's INTEGER information in PREORDER notation. This is achieved by calling the PROTECTED RECURISVE method rPreOrder
	     (see Method rPreOrder WITHIN class).
    Input: None
    Output: Returns a STRING value that corresponds to the CURRENT BINARY TREE NODE's INTEGER information in PREORDER notation. This is achieved by calling the PROTECTED RECURISVE method rPreOrder
	    (see Method rPreOrder WITHIN class).
    */

    public String preOrder ()
    {
	return this.rPreOrder (this.root);
    }


    // ======================================================================================================

    // rInOrder [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in INORDER notation. The method achieves this in a RECURSIVE manner.
    Input: A NODE parameter value
    Output: Returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in INORDER notation. The method achieves this in a RECURSIVE manner.
    */
    protected String rInOrder (Node node)
    {
	String result = "";
	if (node != null)
	    result = result + this.rInOrder (node.left) + node.data + " " + this.rInOrder (node.right);
	return result;
    }


    // -------------------------------------------------------------------------------------------------------

    // inOrder

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a STRING value that corresponds to the CURRENT BINARY TREE's INTEGER information in INORDER notation. This is achieved by calling the PROTECTED RECURSIVE method rInOrder
	     (see Method rInOrder WITHIN class)
    Input: None
    Output: Returns a STRING value that corresponds to the CURRENT BINARY TREE's INTEGER information  in INORDER notation. This is achieved by calling the PROTECTED RECURSIVE method rInOrder (see Method rInOrder WITHIN class)
    */
    public String inOrder ()
    {
	return this.rInOrder (this.root);
    }


    // ======================================================================================================

    // rPostOrder [PROTECTED RECURSIVE]

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given a NODE parameter value, returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in POSTORDER notation. The method achieves this in a RECURSIVE manner.
    Input: A NODE parameter value
    Output: Returns a STRING value that corresponds to the CURRENT NODE's left and right subtree INTEGER information in POSTORDER notation. The method achieves this in a RECURSIVE manner.
    */
    protected String rPostOrder (Node node)
    {
	String result = "";
	if (node != null)
	    result = result + this.rPostOrder (node.left) + this.rPostOrder (node.right) + node.data + " ";
	return result;
    }


    // -------------------------------------------------------------------------------------------------------
    // postOrder

    /*
    Author: Swethan Sivasegaran
    Date: July5 2018
    Purpose: Given NO PARAMETERS, returns a STRING value that corresponds the CURRENT BINARY TREE's INTEGER information in POSTORDER notation. This is achieved by callin the PROTECTED RECURSIVE method rPostOrder (see Method rPostOrder
	     WITHIN class)
    Input: None
    Output: Returns a STRING value that corresponds the CURRENT BINARY TREE's INTEGER information in POSTORDER notation. This is achieved by callin the PROTECTED RECURSIVE method rPostOrder (see Method rPostOrder
	    WITHIN class)
    */
    public String postOrder ()
    {
	return this.rPostOrder (this.root);
    }


    // ======================================================================================================
}
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=-=-=-=-=-=-=-==-=-=-=-=-=--=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-
