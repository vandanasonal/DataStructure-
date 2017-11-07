package LinkedList;

public class App {
	public static void main(String[] args) {
		
		List<Integer> list= new LinkedList<Integer>();
		list.insert(10);
		list.insert(5);
		list.insert(-2);
		list.insert(-1);
		System.out.println(list.size());
		
		list.remove(10);
		list.remove(5);
	//	System.out.println(list.size());
		
		list.traverseList();
		
		List<Person> list1= new LinkedList<Person>();
		list1.insert(new Person(10,"Adam"));
		list1.insert(new Person(15,"JOhn"));
		list1.insert(new Person(14,"Ron"));
		list1.insert(new Person(10,"Jimmy"));
		System.out.println(list.size());
		
		list1.traverseList();
	}

}
