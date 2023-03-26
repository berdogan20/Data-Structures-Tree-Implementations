package BinaryTree;

public class Introduction {
	
	/*
	 * A Binary tree is represented by a pointer to the topmost node (commonly known as the “root”) of the tree. 
	 * If the tree is empty, then the value of the root is NULL. 
	 * 
	 * Each node of a Binary Tree contains the following parts:
	 * 	1. Data
	 * 	2. Pointer to the left child.
	 *  3. Pointer to the right child.
	 * Basic operations on Binary Tree:
	 * 	inserting an element
	 *  removing an element
	 *  searching for an element
	 *  traversing the tree
	 * Auxiliary Operations on Binary Tree
	 * 	Finding the height of the tree
	 *  Find the level of a node of the tree
	 *  Finding the size of the entire tree.
	 * */
	
	
	/*
	 * Why to use Tree Data Structure? 
	 * 1. One reason to use trees might be because you want to 
	 * store information that naturally forms a hierarchy. 
	 * For example, the file system on a computer: 
	 * 
	 * 2. Trees (with some ordering e.g., BST) provide moderate access/search 
	 * (quicker than Linked List and slower than arrays). 
	 * 
	 * 3. Trees provide moderate insertion/deletion 
	 * (quicker than Arrays and slower than Unordered Linked Lists). 
	 * 
	 * 4. Like Linked Lists and unlike Arrays, Trees don’t have an upper limit 
	 * on the number of nodes as nodes are linked using pointers.
	 * 
	 * Binary Tree Traversals:
	 * 1. Depth-First Search (DFS) Algorithms
	 * 	Preorder Traversal (current-left-right)
	 *  Inorder Traversal (left-current-right)
	 *  Postorder Traversal (left-right-current)
	 * 2. Breadth-First Search (BFS) Algorithms
	 * 	Level Order Traversal:  Visit nodes level-by-level 
	 *  and left-to-right fashion at the same level. 
	 *  Here, the traversal is level-wise.
	 * 
					 		  1
					  		 /  \
					        2    3
					       /\	 /\
					      4  5  6  7
	 *     
	 *     Pre-order Traversal of the above tree: 1-2-4-5-3-6-7
	 *     In-order Traversal of the above tree: 4-2-5-1-6-3-7
	 *     Post-order Traversal of the above tree: 4-5-2-6-7-3-1
	 *     Level-order Traversal of the above tree: 1-2-3-4-5-6-7
	 * */
	
	public static void main(String[] args)
    {
		BinaryTreeExample tree = new BinaryTreeExample();
        // create root
        
        tree.root = new NodeExample(1);
        /* following is the tree after above statement
		           1
		          / \
		        null null 
        */
  
        tree.root.left = new NodeExample(2);
        tree.root.right = new NodeExample(3);
        /* 2 and 3 become left and right children of 1
		          1
		         / \
		        2   3
		       / \ / \
  		null null null null 
  		*/
        
        tree.root.left.left = new NodeExample(4);
        /* 4 becomes left child of 2
			        1
			       / \
			      2   3
			     / \ / \
			  4 null null null
			    / \
			  null null
        */
    }
	
}

//Class containing left and right child
//of current node and key value
class NodeExample {
	 
	int key;
	NodeExample left, right;
	
	public NodeExample(int item)
	{
		key = item;	   
		left = right = null;
	}
}

class BinaryTreeExample
{
	
	/*
	 * Time Complexity: O(h), h is height of tree.
	 * Auxiliary Space: O(h), h is height of tree.
	*/
	NodeExample root;
	
	public void addNode(int data)
	{
		NodeExample newNode = new NodeExample(data);
		
		if (root == null)
		{
			root = newNode;
		}
		else
		{
			NodeExample currentNode = root;
			NodeExample parent;
			
			while (true)
			{
				parent = currentNode;
				
				if (data < parent.key)
				{
					currentNode = currentNode.left;
					if (currentNode == null)
					{
						parent.left = newNode;
						return;
					}
				}
				else
				{
					currentNode = currentNode.right;
					if (currentNode == null)
					{
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
}














