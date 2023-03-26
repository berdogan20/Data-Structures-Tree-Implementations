package BinarySearchTree;

/*
 * Root: The root of a tree is the topmost node of the tree that has no parent node. 
 * There is only one root node in every tree.
 * 
 * Parent Node:  The node which is a predecessor of a node is called the parent node of that node.
 * 
 * Child Node: The node which is the immediate successor of a node is called the child node of that node.
 * 
 * Sibling: Children of the same parent node are called siblings.
 * 
 * Edge: Edge acts as a link between the parent node and the child node.
 * 
 * Leaf: A node that has no child is known as the leaf node. 
 * It is the last node of the tree. There can be multiple leaf nodes in a tree.
 * 
 * Subtree: The subtree of a node is the tree considering that particular node as the root node.
 * 
 * Depth: The depth of the node is the distance from the root node to that particular node.
 * 
 * Height: The height of the node is the distance from that node to the deepest node of that subtree.
 * 
 * Height of tree: The Height of the tree is the maximum height of any node. 
 * This is the same as the height of the root node.
 * 
 * Level: A level is the number of parent nodes corresponding to a given node of the tree.
 * 
 * Degree of node:  The degree of a node is the number of its children.
 * */



// For the sake of simplicity, 
// I will implement a binary search tree which stores integers
// instead of a generic type of tree.
public class BinarySearchTree {

	Node root;
	
	public BinarySearchTree()
	{
		root = null;	
	}
	
	public void insert(int value)
	{
		if (root == null)
		{
			root = new Node(value);
		}
		else
		{
			root.insert(value);
		}
	}
	
	public int min()
	{
		if (root == null)
		{
			return Integer.MIN_VALUE;
		}
		
		return root.min();
	}
	
	public int max()
	{
		if (root == null)
		{
			return Integer.MAX_VALUE;
		}
		
		return root.max();
	}
	
	public void traverseInOrder()
	{
		if (root != null)
		{
			root.traverseInOrder();
		}
		System.out.println();
	}
	
	public void traversePreOrder()
	{
		if (root != null)
		{
			root.traversePreOrder();
		}
		System.out.println();
	}
	
	public void traversePostOrder()
	{
		if (root != null)
		{
			root.traversePostOrder();
		}
		System.out.println();
	}

	public void delete(int value)
	{
		/*
		 * 1. Node is a leaf 
		 * 2. Node has one child
		 * 3. Node has two children
		 * */
		
		root = delete(root, value);
		
	}
	
	private Node delete(Node subtreeRoot, int value)
	{
		if (subtreeRoot == null)
		{
			return subtreeRoot;
		}
		
		if (value < subtreeRoot.getData())
		{
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		}
		
		else if (value > subtreeRoot.getData())
		{
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		}
		
		else
		{
			// cases 1 and 2: 
			if (subtreeRoot.getLeftChild() == null)
			{
				return subtreeRoot.getRightChild();
			}
			else if (subtreeRoot.getRightChild() == null)
			{
				return subtreeRoot.getLeftChild();
			}
			
			// case 3:
			
			// Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
		}
		
		return subtreeRoot;
	}
	
	
}
