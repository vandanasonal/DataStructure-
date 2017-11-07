package StackLinkedList;

public class App {
	public static void main(String[] args) {
		Stack<String> myStack = new Stack<>();
		
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		
		System.out.println(myStack.size());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}

}
