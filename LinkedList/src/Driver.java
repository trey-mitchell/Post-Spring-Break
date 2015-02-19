
public class Driver {

	static public void main(String[] args) throws Exception
	{
		//this removes the 25.
		LinkedList ll = new LinkedList();
		ll.addFront(21);
		ll.addFront(22);
		ll.addFront(25);
		ll.addFront(24);
		ll.addFront(21);
		ll.display();
		ll.removeAtIndex(2);
		ll.display();
		//ll.display();
		//ll.removeAtIndex(5);
		//ll.display();
	}
}
