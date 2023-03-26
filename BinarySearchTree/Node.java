package BinarySearchTree;

public class Node {

	private int data;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int data)
	{
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
	public void insert(int value)
	{
		// Case 1: value = data
		if (value == data)
		{
			return;
		}
	
		// Case 1: value < data
		else if (value < data)
		{
			if (leftChild == null)
			{
				leftChild = new Node(value);
			}
			else
			{
				leftChild.insert(value);
			}
		}
		
		// Case 3: value > data
		else
		{
			if (rightChild == null)
			{
				rightChild = new Node(value);
			}
			else
			{
				rightChild.insert(value);
			}
		}
	}
	
	public Node get(int value)
	{
		// Case 1: value = data
		if (data == value)
		{
			return this;
		}
		
		// Case 2: value < data
		else if (value < data)
		{
			
			if (leftChild != null)
			{
				return leftChild.get(value);
			}
		}
		
		// Case 3: value > data
		else
		{
			if (rightChild != null)
			{
				return rightChild.get(value);
			}
		}
		
		// If data is not found
		return null;
	}
	
	public int min()
	{
		if (leftChild == null)
		{
			return data;
		}
		else
		{
			return leftChild.min();
		}
	}
	
	public int max()
	{
		if (rightChild == null)
		{
			return data;
		}
		else
		{
			return rightChild.max();
		}
	}
	
	/*
	 * *** Traversal ***
	 * Level - visit nodes on each level
	 * Pre-order - visit the root of every subtree first
	 * Post-order - visit the root of every subtree last
	 * In-order - visit left child, then root, then right child
	 * */
	
	public void traverseInOrder()
	{
		if (leftChild != null)
		{
			leftChild.traverseInOrder();
		}
		
		System.out.print(this.data + " -> ");
		
		if (rightChild != null)
		{
			rightChild.traverseInOrder();
		}
	}
	
	public void traversePreOrder()
	{
		System.out.print(data + " -> ");
		
		if (leftChild != null)
		{
			leftChild.traverseInOrder();
		}
				
		if (rightChild != null)
		{
			rightChild.traverseInOrder();
		}
	}
	
	public void traversePostOrder()
	{
		if (leftChild != null)
		{
			leftChild.traverseInOrder();
		}
				
		if (rightChild != null)
		{
			rightChild.traverseInOrder();
		}
		System.out.print(data + " -> ");
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	
}
