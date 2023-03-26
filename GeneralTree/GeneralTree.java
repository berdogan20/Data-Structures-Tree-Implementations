package GeneralTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode<E>
{
	/*
	 * We can use either a container for all children
	 * or a pointer to first child and a pointer to its next sibling 
		e.g.
		TreeNode firstChild;
		TreeNode nextSibling;
	*/
	
	
	E value;
	List<TreeNode<E>> children;
	
	public TreeNode(E value)
	{
		this.value = value;
		this.children = new ArrayList<>();
	}
}


public class GeneralTree<E> {

	TreeNode<E> root;
	
	public GeneralTree()
	{
		root = null;
	}
	
	public void insert(E parentValue, E childValue)
	{
		// if the tree is empty
		if (root == null)
		{
			root = new TreeNode<E>(parentValue);
			root.children.add(new TreeNode<E>(childValue));
			return;
		}
		
		TreeNode<E> parentNode = findNode(root, parentValue);
		if (parentNode != null)
		{
			parentNode.children.add(new TreeNode<E>(childValue));
		}
		
	}

	private TreeNode<E> findNode(TreeNode<E> root, E value) {
		
		// base case 1
		if (root == null)
		{
			return null;
		}
		
		// base case 2
		if (root.value == value)
		{
			return root;
		}
		
		// recursive case
		for (TreeNode<E> child : root.children)
		{
			TreeNode<E> foundNode = findNode(child, value);
			if (foundNode != null)
			{
				return foundNode;
			}
		}
		return null;
	}
	
	public void printTree(TreeNode<E> root)
	{
		if (root == null)
		{
			return;
		}
		System.out.println(root.value);
		
		for(TreeNode<E> child : root.children)
		{
			printTree(child);
		}
	}
	
	public static void main(String[] args)
	{
		// pre Order Traversal
		 GeneralTree tree = new GeneralTree();
	        tree.insert(1, 2);
	        tree.insert(1, 3);
	        tree.insert(2, 4);
	        tree.insert(3, 5);
	        tree.insert(3, 6);
	    tree.printTree(tree.root); 
	}

}
