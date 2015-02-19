
public class Driver {

	static public void main(String[] args) throws Exception
	{
		LinkedList ll = new LinkedList();
		ll.addFront(21);
		ll.addFront(22);
		ll.addFront(25);
		ll.addFront(24);
		ll.addFront(21);
		//ll.display();
		try
		{
			ll.removeAtIndex(-1);
		}
		catch(Exception e)
		{
			System.out.println("You did something wrong, try again with a different index.");
		}
		//ll.display();
	}
}
