package TreeDataStructure;

import java.util.ArrayList;
import java.util.Objects;

/*
 *  Each node itself defines a tree
 *  We do not actually need an explicit tree class/interface!
 */

public class Node<E> {

	E element;
	Node<E> parent; // null if root
	ArrayList<Node<E>> children;
	
	public Node(E element)
	{
		this(element, null);
	}
	
	public Node(E element, Node<E> p)
	{
		this.element = element;
		this.parent = p;
		this.children = new ArrayList<>();
	}
	
	public Node<E> getParent()
	{
		return parent;
	}
	
	public ArrayList<Node<E>> getChildren()
	{
		return children;
	}
	
	public E getElement()
	{
		return element;
	}
	
	public void setElement(E element)
	{
		this.element = element;
	}
 	
	public boolean isRoot()
	{
		return parent == null;
	}
	
	public boolean isLeaf()
	{
		return children.isEmpty();
	}
	
	public int getDepth()
	{
		if (isRoot())
		{
			return 0;
		}
		
		return parent.getDepth() + 1;
	}
	
	public void addChild(E element)
	{
		Node<E> newElement = new Node<>(element);
		this.children.add(newElement);	
	}
	
	public E deleteChild(E element)
	{
		Node<E> newElement = new Node<>(element);
		if (this.children.contains(newElement))		// hashcode and equals method are required for element E
		{
			this.children.remove(newElement);
		}
		else
		{
			return null;
		}
		
		return element;
	}

	@Override
	public int hashCode() {
		return Objects.hash(children, element, parent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(children, other.children) && Objects.equals(element, other.element)
				&& Objects.equals(parent, other.parent);
	}
	
	public void visit()
	{
		System.out.print(this.element + " -> ");
	}
	
	public void preOrderTraversal()
	{
		/*
		 * A traversal visits the nodes of a tree in a systematic manner
		 * In a preorder traversal, a node is visited before its descendants
		 * Application: Print a structured document
		 */
		 
		this.visit();
		for (Node<E> n : this.children)
		{
			n.preOrderTraversal();
		}
	}
	
	public void postOrderTraversal()
	{
		/*
		 * In a postorder traversal, a node is visited after its descendants
		 * Application: compute space used by files in a directory and its subdirectories
		 */
		
		for (Node<E> n : this.children)
		{
			n.postOrderTraversal();
		}
		this.visit();
	}
	
	public static void main(String[] args)
	{
		Node<Integer> root = new Node<>(5);
		Node<Integer> child1 = new Node<>(1345);
		Node<Integer> child2 = new Node<>(4235);
		Node<Integer> child3 = new Node<>(35);
		
		root.children.add(child1);
		root.children.add(child2);
		root.children.add(child3);
		child1.addChild(42);
		child1.addChild(32);
		child1.addChild(22);
		child2.addChild(64);
		child2.addChild(49);
		child2.addChild(76);
		child3.addChild(5384);
		child3.addChild(5832);
		
		root.preOrderTraversal();
		System.out.println();
		root.postOrderTraversal();
		System.out.println();
		child1.preOrderTraversal();
		System.out.println();
		child1.postOrderTraversal();
		
		
		
		
		
		
	}
	
}












