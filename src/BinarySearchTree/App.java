package BinarySearchTree;

public class App {
	public static void main(String[] args) {
		
		Tree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(10);
		bst.insert(100);
		bst.insert(1000);
		bst.insert(-1);
		bst.insert(5);
		
		System.out.println(bst.getMaxValue());
		System.out.println(bst.getMinValue());
		
		bst.traverse();
		System.out.println("");
		
		Tree<String> bst1 = new BinarySearchTree<String>();
		bst1.insert("Kevin");
		bst1.insert("Vincent");
		bst1.insert("Bob");
		bst1.insert("Adam");
		bst1.insert("Michael");
		bst1.insert("Charley");
		
		System.out.println(bst1.getMaxValue());
		System.out.println(bst1.getMinValue());
		
		bst1.traverse();
		System.out.println("");
		
		bst1.delete("Bob");
		bst1.traverse();
		bst1.delete("Kevin");
		bst1.traverse();
	}

}
