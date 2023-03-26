package BinarySearchTree;

public class Main {
	public static void main(String[] args) {
			
			BinarySearchTree intTree = new BinarySearchTree();
			intTree.insert(30);
			intTree.insert(36);
			intTree.insert(26);
			intTree.insert(17);
			intTree.insert(43);
			intTree.insert(2);
			intTree.insert(63);
			intTree.insert(9);
			intTree.insert(45);
			
			intTree.traverseInOrder();
	
	//		System.out.println(intTree.get(42));
	//		System.out.println(intTree.get(22));
	//		System.out.println(intTree.get(17));
	//		
	//		System.out.println(intTree.min());
	//		System.out.println(intTree.max());
			
	//		intTree.delete(9);
	//        intTree.traverseInOrder();
	        System.out.println();
	        intTree.traversePostOrder();
	        
	        System.out.println();
	        intTree.traversePreOrder();
		}
}
