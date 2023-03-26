package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	static class Node {
        int key;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
	
	public static Node root;
	
	// insertion in level order
	public void insert(int data)
	{
		Node newNode = new Node(data);
		
		if (root == null)
		{
			root = newNode;
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    
	    Node temp;
	    // Do level order traversal until we find
        // an empty place.
	    while (!q.isEmpty())
	    {
	    	temp = q.peek();
	    	q.remove();
	    	
	    	if (temp.left == null)
	    	{
	    		temp.left = newNode;
	    		break;
	    	}
	    	else
	    	{
	    		q.add(temp.left);
	    	}
	    	
	    	if (temp.right == null)
	    	{
	    		temp.right = newNode;
	    		break;
	    	}
	    	else
	    	{
	    		q.add(temp.right);
	    	}
	    }
	    
	}
	
	// Function to delete deepest
    // element in binary tree
	public void deleteDeepest(Node deleteNode)
	{
		Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        Node temp;
        // Do level order traversal until last node
        while (!q.isEmpty())
        {	
        	temp = q.peek();
        	q.remove();
        	
        	if (temp == deleteNode)
        	{
        		temp = null;
        		return;
        	}
        	
        	if (temp.right != null)
        	{
        		if (temp.right == deleteNode)
        		{
        			temp.right = null;
        			return;
        		}
        		else
        		{
        			q.add(temp.right);
        		}
        	}
        	
        	if (temp.left != null)
        	{
        		if (temp.left == deleteNode)
        		{
        			temp.left = null;
        			return;
        		}
        		else
        		{
        			q.add(temp.left);
        		}
        	}
        }
	}
	
	// Function to delete given element
    // in binary tree
	public void delete(int key)
	{
		if (root == null)
            return;
 
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            }
            else
                return;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        
        Node temp = null;
        Node keyNode = null;
        
        
        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty())
        {
        	temp = q.peek();
        	q.remove();
        	
        	if (temp.key == key)
        	{
        		keyNode = temp;
        	}
        	if (temp.left != null)
        	{
        		q.add(temp.left);
        	}
        	if (temp.right != null)
        	{
        		q.add(temp.right);
        	}
        	
        }
        
        if (keyNode != null)
        {
        	int x = temp.key;
        	deleteDeepest(temp);
        	keyNode.key = x;
        }
	}
	
	// Inorder traversal of a binary tree
    static void inorder(Node temp)
    {
        if (temp == null)
            return;
 
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }
	
	
	// Driver code
    public static void main(String args[])
    {
    	
    	BinaryTree tree = new BinaryTree();
    	tree.insert(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
 
        System.out.print("Inorder traversal "
                         + "before deletion:");
        inorder(root);
 
        int key = 11;
        tree.delete(key);
 
        System.out.print("\nInorder traversal "
                         + "after deletion:");
        inorder(root);
    }
	
    /* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public int maxDepth(Node node)
    {
    	if (node == null)
    	{
    		return 0;
    	}
    	
    	else
    	{
    		/* compute the depth of each subtree */
    		int leftDepth = maxDepth(node.left);
    		int rightDepth = maxDepth(node.right);
    		
    		/* use the larger one */
    		if (leftDepth > rightDepth)
    		{
    			return leftDepth + 1;
    		}
    		else
    		{
    			return rightDepth + 1;
    		}
    	}
    	
    	/*
    	 * Time Complexity: O(N) 
		 * Auxiliary Space: O(N) due to recursive stack.
		 * */
    }
	
    /*Function to find the height(depth) of the tree*/
    public static int height(Node root)
    {
 
        // Initialising a variable to count the
        // height of tree
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        int height = 0;
        while (!q.isEmpty()) 
        {
            int size = q.size();
            
            for (int i = 0; i < size; i++) 
            {
                Node temp = q.poll();
                if (temp.left != null) 
                {
                    q.add(temp.left);
                }
                if (temp.right != null) 
                {
                    q.add(temp.right);
                }
            }
            
            height++;
        }
        
        return height;
        
        /*
         * Time Complexity: O(N)
		 * Auxiliary Space: O(N)
	     */
    }
	
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.key + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    // Wrappers over above recursive functions
    void printInorder() { printInorder(root); }
    
    
    
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 
        /* first print data of node */
        System.out.print(node.key + " ");
 
        /* then recur on left subtree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
    }
 
    // Wrappers over above recursive functions
    void printPreorder() { printPreorder(root); }
    
    
    
    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
  void printPostorder(Node node)
  {
      if (node == null)
          return;

      // first recur on left subtree
      printPostorder(node.left);

      // then recur on right subtree
      printPostorder(node.right);

      // now deal with the node
      System.out.print(node.key + " ");
  }

  // Wrappers over above recursive functions
  void printPostorder() { printPostorder(root); }
  
  
  
  /* function to print level order traversal of tree*/
  void printLevelOrder()
  {
      int h = height(root);
      int i;
      
      for (i = 1; i <= h; i++)
      {
    	  printCurrentLevel(root, i);
      }
  }
  void printCurrentLevel(Node root, int level)
  {
      if (root == null)
          return;
      
      if (level == 1)
          System.out.print(root.key + " ");
      
      else if (level > 1) {
          printCurrentLevel(root.left, level - 1);
          printCurrentLevel(root.right, level - 1);
      }
  }

	
}
