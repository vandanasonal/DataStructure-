package LinkedList;

public class Node <T>{
	private T data;
	private Node<T> nextnode;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextnode() {
		return nextnode;
	}

	public void setNextnode(Node<T> nextnode) {
		this.nextnode = nextnode;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
	
   
}
