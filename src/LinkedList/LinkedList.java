package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {
     
	private Node<T> root;
	private int sizeOfList;
	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
		++sizeOfList;
		if(root == null) {
			this.root= new Node<>(data);
		}
		else
			insertDataAtBeginning(data);
		
	   }

	private void insertDataAtBeginning(T data) {
		// TODO Auto-generated method stub
		
		Node<T> newNode = new Node<>(data);
		newNode.setNextnode(root);
		this.root= newNode;
		
	}
	public void insertDataAtEnd(T data,Node<T> node) {
		if(node.getNextnode() != null ) {
			insertDataAtEnd(data, node.getNextnode());
		}
		else {
			Node<T> newNode = new Node<>(data);
			node.setNextnode(newNode);
		}
		
	}

	@Override
	public void remove(T data) {
		if(this.root == null) {
			return;
		}
	    if(this.root.getData().compareTo(data) == 0) {
	    	this.root= this.root.getNextnode();
	    }	else {
	    	remove(data,root,root.getNextnode());
	    }
		
	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
		while(actualNode != null) {
			if(actualNode.getData().compareTo(dataToRemove)== 0) {
				previousNode.setNextnode(actualNode.getNextnode());
				actualNode=null;
				return;
			}
			previousNode= actualNode;
			actualNode= actualNode.getNextnode();
		}
		
	}

	@Override
	public void traverseList() {
		if(this.root == null) return;
		 
		Node<T> actualNode= this.root;
		
		while(actualNode!= null) {
			System.out.print(actualNode + "->");
		
		actualNode = actualNode.getNextnode();
		}
	}

	@Override
	public int size() {
		
		return this.sizeOfList;
	}
	

}
