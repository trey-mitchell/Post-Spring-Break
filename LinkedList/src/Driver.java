
public class Driver {

	static public void main(String[] args) throws Exception
	{
		//Still working?
		LinkedList ll = new LinkedList();
		ll.addFront(21);
		ll.addFront(22);
		ll.addFront(23);
		ll.addFront(24);
		ll.addFront(25);
		ll.addFront(26);
		ll.display();
		ll.removeAtIndex(2);
		ll.display();
		
	}
}
