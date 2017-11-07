package BinarySearchTree;

public class BinarySearchTree <T extends Comparable<T>> implements Tree<T>{
	private Node<T> root;
	
	@Override
	public void insert(T newData) {
		if(root == null) {
			root= new Node<>(newData);
		}else {
			insertNode(newData,root);
		}
	}
	

	private void insertNode(T newData,Node<T> node) {
		if(newData.compareTo(node.getData())<0) {
			if(node.getLeftChild()!=null) {
				insertNode(newData,node.getLeftChild());
			}else {
				Node<T> newNode= new Node<>(newData);
				node.setLeftChild(newNode);
			}
		}else {
			if(newData.compareTo(node.getData())>0) {
				if(node.getRightChild()!=null) {
					insertNode(newData,node.getRightChild());
			}else {
				Node<T> newNode = new Node<>(newData);
				node.setRightChild(newNode);
				
			}
			}
		}
		
	}
	
	
	@Override
	public void delete(T data) {
		if(root != null)
			root=delete(root,data);
		
	}

	private Node<T> delete(Node<T> node, T data) {
		
		if(node== null) return node;
		
		if(data.compareTo(node.getData())<0)
			node.setLeftChild(delete(node.getLeftChild(),data));
		else if(data.compareTo(node.getData())>0)
			node.setRightChild(delete(node.getRightChild(),data));
		     else {
			//we have found the node to be removed
			  if(node.getLeftChild()==null && node.getRightChild()==null) {
				System.out.println(" Removing leaf node..");
				node=null;
			}  else {
			   if(node.getLeftChild()==null) {
				System.out.println("Removing Right child");
				Node<T> tempNode = node.getRightChild();
				node=null;
				return tempNode;
			} else if( node.getRightChild()==null) {
				System.out.println("Removing Left child ..");
				Node<T> tempNode = node.getLeftChild();
				node=null;
				return tempNode;
			}
			 else {
			
			System.out.println("Removing node with two children");
			Node<T> tempNode=getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
			}
			}
		}
		
		
		
		return node;
	}
	
	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightChild()!=null)
			return getPredecessor(node.getRightChild());
		System.out.println(" Predecessor is " + node);
		
		return node;
	}
	@Override
	public void traverse() {
	  if(root!= null) {
		  inOrderTraversal(root);
		  System.out.println(" ");
		  preOrderTraversal(root);
		  System.out.println(" ");
		  postOrderTraversal(root);
	  }
		
	}

	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftChild()!=null) 
			inOrderTraversal(node.getLeftChild());
			
		System.out.print( node+ "-> ");	
		
		if(node.getRightChild()!=null) 
			inOrderTraversal(node.getRightChild());
		
		
		
	}
	private void preOrderTraversal(Node<T> node) {
		
		System.out.print( node+ "-> ");	
		
		if(node.getLeftChild()!=null) 
			preOrderTraversal(node.getLeftChild());
		
		if(node.getRightChild()!=null) 
			preOrderTraversal(node.getRightChild());
		
		
	}
   private void postOrderTraversal(Node<T> node) {
		
		
		if(node.getLeftChild()!=null) 
			postOrderTraversal(node.getLeftChild());
		
		if(node.getRightChild()!=null) 
			postOrderTraversal(node.getRightChild());
		
		System.out.print( node+ "-> ");	
		
		
		
	}
   
   @Override
	public T getMinValue() {
		if(root== null) return null;
		else
		return getMin(root);
	}
	@Override
	public T getMaxValue() {
		if(root== null) return null;
		else
		return getMax(root);
	}

	private T getMin(Node<T> node) {
		if(node.getLeftChild()!=null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
		
	}

	
	private T getMax(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
		
	}
	
	

}
