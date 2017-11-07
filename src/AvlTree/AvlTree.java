package AvlTree;


public class AvlTree <T extends Comparable <T>> implements Tree<T> {
	
	
	private Node<T> root;

	@Override
	public void insert(T newData) {
		
			root=insertNode(newData,root);
			
		System.out.println(" Root node is " + root);
	}
	
	private Node<T> insertNode(T newData, Node<T> node) {
		System.out.println(" inserting " + newData);
		
		if(node==null)
			return new Node(newData);
		
		if(newData.compareTo(node.getData())<0) {
			
			node.setLeftNode(insertNode(newData,node.getLeftNode()));
				
			}else {
				node.setRightNode(insertNode(newData,node.getRightNode()));
				
			}
			
	
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
	//	System.out.println(" Height of the node " + node + " is " +node.getHeight());
		return settleViolation(newData,node);
	
	}

	

	private Node<T> settleViolation(T newData, Node<T> node) {
		int balance= getBalance(node);
		
		//Case- left-left
		if(balance>1 && newData.compareTo(node.getLeftNode().getData())<0) 
			return rightRotation(node);
		
		// Case- right-right
		else if(balance<-1 && newData.compareTo(node.getRightNode().getData())>0)
			return leftRotation(node);
		
		// Case Left right
		     else if(balance>1 && newData.compareTo(node.getLeftNode().getData())>0) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		    }  
		   //Case Right Left  
		     else if(balance<-1 && newData.compareTo(node.getRightNode().getData())<0) {
		    	 node.setRightNode(rightRotation(node.getRightNode()));
		    	 return leftRotation(node);
		     }
		        
		return node;
	}

	private Node<T> rightRotation(Node<T> node){
		System.out.println(" Rotating to thr right on node " + node);
		
		Node<T> tempLeftNode=node.getLeftNode();
		Node<T> t=tempLeftNode.getRightNode();
		
		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);
		
		node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode()))+1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()),height(tempLeftNode.getRightNode()))+1);
		
		
		return tempLeftNode;
	}
	
    private Node<T> leftRotation(Node<T> node){
    	System.out.println("Rotating to thr left on node " + node);
		
		Node<T> tempRightNode=node.getRightNode();
		Node<T> t=tempRightNode.getLeftNode();
		
		tempRightNode.setLeftNode(node);
		node.setRightNode(t);
		
		node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode()))+1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()),height(tempRightNode.getRightNode()))+1);
		
		return tempRightNode;
	}
	
	
	private int height(Node<T> node) {
		if(node==null)
			return -1;
		
		return node.getHeight();
	}
	
	private int getBalance(Node<T> node ) {
		if(node== null)
			return 0;
		
		int b=height(node.getLeftNode())-height(node.getRightNode());
		System.out.println(" Balance of node " + node + " is " + b);
		return b;
	}

	@Override
	public void traverse() {
		if(root == null) return;
		
		inOrderTraversal(root);
		
	}

	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftNode()!=null)
			inOrderTraversal(node.getLeftNode());
		
		System.out.print(node);
		
		if(node.getRightNode()!=null)
			inOrderTraversal(node.getRightNode());
		
	}

	@Override
	public void delete(T data) {
		root=deleteNode(data,root);
		
	}

	private Node<T> deleteNode(T data, Node<T> node){
		if(node==null)
			return node;
		
		if(data.compareTo(node.getData())<0) {
			
			node.setLeftNode(deleteNode(data,node.getLeftNode()));
		}
		else if(data.compareTo(node.getData())>0) {
			
			node.setRightNode(deleteNode(data,node.getRightNode()));
		   }
		
		   else {
			   // we have found the node to be deleted
			   if(node.getLeftNode()==null && node.getRightNode()==null) {
				   System.out.println(" Removing the leaf node ");
				   node=null;
				   
			   } else if(node.getLeftNode()==null) {
				    System.out.println(" Removing right node ");
				    
				    Node<T> tempNode = node.getRightNode();
				    node=null;
				    
				    return tempNode;
				    
			     }    else if(node.getRightNode()==null) {
			    	   System.out.println(" Removing the left node ");
			    	   
			    	   Node<T> tempNode = node.getLeftNode();
			    	   node=null;
			    	   
			    	   return tempNode;
			    	   
			     }        else {
			    	 
			    	    System.out.println(" removing node with two children ");
			    	    
			    	    Node<T> tempNode = getPredecessor(node.getLeftNode());
			    	    node.setData(tempNode.getData()); // swapping the node data with its predecessor
			    	    
			    	    node.setLeftNode(deleteNode(tempNode.getData(),node.getLeftNode()));
			     }
			   
			    }
		     if(node!=null) {
			node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode()))+1);
		     }
		return settleDeletion(node);
		     
	 }

	private Node<T> settleDeletion(Node<T> node) {
		if (node==null) return null;
		int balance= getBalance(node);
		
		//Case left-left
		if(balance>1 && getBalance(node.getLeftNode())>=0) {
			return rightRotation(node);
		
			//Case left-right
		} else if(balance>1 && getBalance(node.getLeftNode())<0) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
			
			// Case right-right
		} else if(balance<1 && getBalance(node.getRightNode())<0) {
			return leftRotation(node);
			
			//Case right-left
		}else if(balance<1 && getBalance(node.getRightNode())>=0) {
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}
		
		
		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightNode()!= null)
			getPredecessor(node.getRightNode());
		
		System.out.println(" Predecessor is " + node);
		return node;
	}

}
