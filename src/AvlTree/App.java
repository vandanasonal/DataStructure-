package AvlTree;

public class App {
	public static void main(String[] args) {
		
		Tree<Integer> avl= new AvlTree<Integer>();
		
		avl.insert(10);
		avl.insert(15);
		avl.insert(5);
		avl.insert(14);
		//avl.insert(5);
		
		avl.delete(5);
		
		avl.traverse();

	}

}
