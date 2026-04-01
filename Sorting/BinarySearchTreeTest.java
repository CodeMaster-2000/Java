// The "BinarySearchTreeTest" class.
// Author: Atputhan Srikanthanathan
// Date: Jan 17, 2018
// Input:    option, value
// Output:   tree and various answers to operations
// Purpose:  To demonstrate my knowledge of binary search trees
import hsa.*;
import java.util.*;

class BinarySearchTreeTest
{
    static Console c = new Console (45, 90);

    public static void main (String[] args)
    {
	BinarySearchTree test = new BinarySearchTree ();
	int option = 1;
	c.println ("Welcome to the Binary Tree Program and no this is not a tree simulator!!!");

	do
	{
	    c.println ("Here are some things you can do: ");
	    c.println ("1. Add to yourself (i.e. add to the binary search tree)");
	    c.println ("2. Find the level of where you stored a number (i.e. a value)");
	    c.println ("3. Find 'sibling' of a certain age (i.e. a value)");
	    c.println ("4. You can select this option to exit this 'tree growth simulator'.");
	    c.print ("Please select an option here: ");
	    option = c.readInt ();
	    c.clear ();
	    while (option < 1 || option > 4)
	    {
		c.print ("Please re-select a valid option: ");
		option = c.readInt ();
	    }

	    if (option == 1)
	    {
		c.print ("Please enter a value to add: ");
		int value = c.readInt ();
		while (value < 1)
		{
		    c.print ("Please re-enter a valid value: ");
		    value = c.readInt ();
		}
		test.add (value);
	    }
	    else if (option == 2)
	    {
		c.print ("Please enter a value to find: ");
		int value = c.readInt ();
		while (value < 1)
		{
		    c.print ("Please re-enter a valid value: ");
		    value = c.readInt ();
		}

		if (test.find (value) == null)
		    c.println ("Value not found in tree");
		else
		    c.println ("Level of the value: " + test.level (value));
	    }
	    else if (option == 3)
	    {
		c.print ("Please enter a value to find the sibling of: ");
		int value = c.readInt ();
		while (value < 1)
		{
		    c.print ("Please re-enter a valid value: ");
		    value = c.readInt ();
		}

		if (test.find (value) == null)
		    c.println ("Value not found in tree");
		else
		{
		    if (test.sibling (value) == null)
			c.println ("The value has no sibling");
		    else
			c.println ("The sibling of the value: " + test.sibling (value).data);
		}
	    }

	    c.println ();
	    c.println ("Tree: ");
	    test.printTree (c);
	    c.println ();
	    c.println ("=================ORDER OF NODES IN YOU========================");
	    c.println ("Pre-order of tree: " + test.preOrder ());
	    c.println ("In-order of tree: " + test.inOrder ());
	    c.println ("Post-order of tree: " + test.postOrder ());
	    c.println ("Breadth first order of tree: " + test.breadthFirstOrder ());
	    c.println ("================NUMERICAL VALUE INQUIRIES=====================");
	    c.println ("Height of tree: " + test.height ());
	    c.println ("Number of nodes: " + test.nodes ());
	    c.println ("=================BALANCED OR NO? THIS WILL HELP DECIDE====================");
	    c.println ("Is it perfectly balanced?: " + test.perfectlyBalanced ());
	    c.println ("Is it height balanced?: " + test.heightBalanced ());
	    c.println ();
	}
	while (option > 0 && option < 4);

	c.println ("Good-bye and hope you come back!");
    }
}
//****************************************************************
//Class Node
// Author: Atputhan Srikanthanathan
// Date: Jan 17, 2018
//Fields:   int data    -   the information held by the Node
//          Node right  -   the next node to the right of the tree
//          Node left   -   the next node to the left of the tree
//Methods: NONE
//****************************************************************
class Node
{
    public int data;
    public Node left;
    public Node right;

    public Node (int info)
    {
	this.data = info;
	this.left = null;
	this.right = null;
    }


    public Node ()
    {
	this (0);
    }
}
//****************************************************************
//Class QNode
// Author: Atputhan Srikanthanathan
// Date: Jan 17, 2018
//Fields:   Node data   -   the information held by the QNode
//          QNode next  -   the next node in the list
//Methods: NONE
//****************************************************************
class QNode
{
    public Node data;
    public QNode next;

    public QNode (Node info)
    {
	this.data = info;
	this.next = null;
    }


    public QNode ()
    {
	this (null);
    }
}
//****************************************************************
//Class Queue
// Author: Atputhan Srikanthanathan
// Date: Jan 17, 2018
//Fields:   QNode front -   the front of the queue
//          QNode back  -   the back of the queue
//Methods:  add     -   adds a given node to the Queue
//          remove  -   removes a node at the front and returns removed node
//          empty   -   returns true if queue is empty
//****************************************************************
class Queue
{
    public QNode front;
    public QNode back;

    public Queue ()
    {
	this.front = null;
	this.back = null;
    }

//****************************************************************
    //add
    // Author: Atputhan Srikanthanathan
    // Date: Jan 1, 2018
    //Purpose:      adds a node at the end of the queue
    //Parameters:   Node x   -   the node being added
    //Output:       None
    public void add (Node x)
    {
	if (this.isEmpty ())
	{
	    this.front = new QNode (x);
	    this.back = this.front;
	}
	else
	{
	    this.back.next = new QNode (x);
	    this.back = this.back.next;
	}
    }

//****************************************************************
    //remove
    // Author: Atputhan Srikanthanathan
    // Date: Jan 1, 2018
    //Purpose:      removes a node at the front of the queue
    //Parameters:   None
    //Output:       the node that was removed
    public Node remove ()
    {
	Node result;

	result = this.front.data;
	this.front = this.front.next;
	return result;
    }

//****************************************************************
    //isEmpty
    // Author: Atputhan Srikanthanathan
    // Date: Jan 1, 2018
    //Purpose:      returns true if array is empty
    //Parameters:   None
    //Output:       true or false
    public boolean isEmpty ()
    {
	boolean result = false;
	if (this.front == null)
	    result = true;
	return result;
    }
}
//***********************************************************************************
//Class BinarySearchTree
// Author: Atputhan Srikanthanathan
// Date: Jan 17, 2018
//Fields:   Node root           -   the root of the tree
//Methods:  add                 -   adds a leaf to the tree with given info
//          find                -   returns the node with the given information
//          printTree           -   prints the tree in a normal way
//          rprintTree          -   prints the tree in a normal way
//          preOrder            -   traverses the tree in pre Order
//          rpreOrder           -   calls its protected method with parameter of root
//          postOrder           -   traverses the tree in post Order
//          rpostOrder          -   calls its protected method with parameter of root
//          inOrder             -   traverses the tree in Order
//          rinOrder            -   calls its protected method with parameter of root
//          height              -   calculates the height of the tree
//          rheight             -   calls its protected method with parameter of root
//          nodes               -   calculates the number of nodes of the tree
//          rnodes              -   calls its protected method with parameter of root
//          perfectlyBalanced   -   checks if the tree is perfectly balanced
//          rperfectlyBalanced  -   calls its protected method with parameter of root
//          heightBalanced      -   checks if the tree is height balanced
//          rheightBalanced     -   calls its protected method with parameter of root
//          level               -   calculates the level of a given integer
//          sibling             -   finds the sibling of the given integer
//          breadthFirstOrder   -   traverses the tree in breadth Order
class BinarySearchTree
{
    protected Node root;

    public BinarySearchTree ()
    {
	this.root = null;
    }

//****************************************************************
    //add
    // Author: Don Smith
    // Date: Unknown
    //Purpose:      adds a leaf to the tree
    //Parameters:   int x   -   the info of the leaf being added
    //Output:       true or false
//****************************************************************   
     public boolean add (int info)
    {

	if (this.root == null)
	    this.root = new Node (info);
	else
	{
	    Node ptr = this.root;
	    while (ptr != null)
	    {
		if (info < ptr.data)
		    if (ptr.left != null)
			ptr = ptr.left;
		    else
		    {
			ptr.left = new Node (info);
			return true;
		    }
		else if (info > ptr.data)
		    if (ptr.right != null)
			ptr = ptr.right;
		    else
		    {
			ptr.right = new Node (info);
			return true;
		    }
		else if (info == ptr.data)
		{
		    return false;
		}
	    }
	}
	return true;
    }

//***************************************************************************
    // Author: Don Smith
    // Date: Unknown
    //find
    //Purpose:      finds the node with the given information
    //Parameters:   int x   -   the info of the node that is being looked for
    //Output:       returns the node with the given information
//***************************************************************************    
    public Node find (int x)
    {
	Node ptr;
	ptr = this.root;
	while (ptr != null && ptr.data != x)
	    if (x < ptr.data)
		ptr = ptr.left;
	    else
		ptr = ptr.right;
	return ptr;
    }


    /************************************************
    Method:printTree
    Purpose:Prints the tree in a normal way.
	(Can't handle super wide trees.)
	-  Developed by Jonathan Chan, May 1997
	-  Java version by Edmund Wong, Dec 2000
	-  Modified by Ian Halliday, June 2001
    Parameters: The Console
    Return Value: None
    *************************************************/
    public void printTree (Console c)
    {
	c.setCursor
	    (rprintTree (c, root, c.getRow ()), 1);
    }
    /************************************************
    Method: rprintTree
    Purpose: See above.
    Parameters: the console, the node being printed
		and the row to print on
    Return Value: The maximum row reached by
		  printing (allowing for useful
		  cursor placement)
    *************************************************/
    protected int rprintTree (Console c, Node n, int r)
    {
	int maxRow;
	if (n != null)
	{
	    maxRow = rprintTree (c, n.left, r + 2);
	    c.setCursor (r, c.getColumn ());
	    c.print (n.data, 3);
	    maxRow = Math.max (maxRow, rprintTree (c, n.right, r + 2));
	    return maxRow;
	}
	return r - 1;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       String
    public String preOrder ()
    {
	return rpreOrder (root);
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      traverses the tree in pre Order
    //Parameters:   Node n
    //Output:       String s
    protected String rpreOrder (Node n)
    {
	String s = "";

	if (n != null)
	{
	    s = s + n.data + " ";
	    s = s + rpreOrder (n.left);
	    s = s + rpreOrder (n.right);
	}

	return s;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       String
    public String inOrder ()
    {
	return rinOrder (root);
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      traverses the tree in Order
    //Parameters:   Node n
    //Output:       String s
    protected String rinOrder (Node n)
    {
	String s = "";

	if (n != null)
	{
	    s = s + rinOrder (n.left);
	    s = s + n.data + " ";
	    s = s + rinOrder (n.right);
	}

	return s;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       String
    public String postOrder ()
    {
	return rpostOrder (root);
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      traverses the tree in post Order
    //Parameters:   Node n
    //Output:       String s
    protected String rpostOrder (Node n)
    {
	String s = "";

	if (n != null)
	{
	    s = s + rpostOrder (n.left);
	    s = s + rpostOrder (n.right);
	    s = s + n.data + " ";
	}

	return s;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       int
    public int height ()
    {
	int height;

	if (root != null)
	    height = rheight (root);
	else
	    height = 0;

	return height;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calculates the height of the tree
    //Parameters:   Node n
    //Output:       int height
    protected int rheight (Node n)
    {
	int hLeft = 0;
	int hRight = 0;
	int height = 0;

	if (n.left != null)
	    hLeft = this.rheight (n.left);
	if (n.right != null)
	    hRight = this.rheight (n.right);

	if (hLeft > hRight)
	    height = hLeft + 1;
	else
	    height = hRight + 1;

	return height;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       int
    public int nodes ()
    {
	return rnodes (root);
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calculates the number of nodes of the tree
    //Parameters:   Node n
    //Output:       int nodes
    protected int rnodes (Node n)
    {
	int nodes = 0;

	if (n == null)
	    nodes = 0;
	else
	    nodes = 1 + this.rnodes (n.left) + this.rnodes (n.right);

	return nodes;
    }

//****************************************************************
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       boolean
    public boolean perfectlyBalanced ()
    {
	boolean isPerfectlyBalanced = false;

	if (root == null)
	    isPerfectlyBalanced = false;
	else
	    isPerfectlyBalanced = this.rperfectlyBalanced (root);

	return isPerfectlyBalanced;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calculates if the tree is node balanced recursively
    //Parameters:   Node n
    //Output:       boolean a
    public boolean rperfectlyBalanced (Node n)
    {
	boolean a = false;

	if (n == null)
	    a = true;
	else
	    a = this.rperfectlyBalanced (n.left) && this.rperfectlyBalanced (n.right) && (Math.abs (this.rnodes (n.left) - this.rnodes (n.right)) <= 1);

	return a;
    }

//****************************************************************//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calls its protected method with parameter of root
    //Parameters:   None
    //Output:       boolean
    public boolean heightBalanced ()
    {
	boolean isHeightBalanced = false;

	if (root == null)
	    isHeightBalanced = false;
	else if ((root.right == null && root.left == null) || (root.right == null && root.left != null) || (root.left == null && root.right != null))
	    isHeightBalanced = true;
	else
	    isHeightBalanced = this.rheightBalanced (root);

	return isHeightBalanced;
    }

//****************************************************************//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calculates if the tree is height balanced recursively
    //Parameters:   Node n
    //Output:       boolean a
    private boolean rheightBalanced (Node n)
    {
	boolean a = false;

	if (n == null)
	    a = true;
	else
	    a = this.rperfectlyBalanced (n.left) && this.rperfectlyBalanced (n.right) && (Math.abs (this.rheight (n.left) - this.rheight (n.right)) <= 1);

	return a;
    }
//****************************************************************//****************************************************************

    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      calculates the level of the tree (starts at 0)
    //Parameters:   int x
    //Output:       int count
    public int level (int x)
    {
	int count = 0;
	Node node = this.root;

	while (node != null && node.data != x)
	{
	    if (x < node.data)
		node = node.left;
	    else
		node = node.right;

	    count = count + 1;
	}

	return count;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      finds the siblings to the node with the given int
    //Parameters:   int x
    //Output:       Node node
    public Node sibling (int x)
    {
	Node node = this.root;

	if (this.root.data == x)
	    node = null;
	else
	{
	    while (node != null && node.left.data != x && node.right.data != x)
	    {
		if (x < node.data)
		    node = node.left;
		else
		    node = node.right;
	    }

	    if (node.left.data == x && node.left != null)
		node = node.right;
	    else if (node.right.data == x && node.right != null)
		node = node.left;
	    else
		node = null;
	}

	return node;
    }

//****************************************************************
    // Author: Atputhan Srikanthanathan
    // Date: Jan 17, 2018
    //Purpose:      traverses the tree in breadth order
    //Parameters:   None
    //Output:       String s
    public String breadthFirstOrder ()
    {
	Node x;
	String s = "";
	Queue queueB = new Queue ();

	if (this.root != null)
	{
	    queueB.add (this.root);

	    while (queueB.isEmpty () == false)
	    {
		x = queueB.remove ();
		s = s + x.data + " ";

		if (x.left != null)
		    queueB.add (x.left);
		if (x.right != null)
		    queueB.add (x.right);
	    }
	}

	return s;
    }
}
