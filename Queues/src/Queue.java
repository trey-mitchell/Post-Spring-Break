
public class Queue 
{
	private Person front;
	private Person back;
	private int count;
	
	public Queue()
	{
		this.front = null;
		this.back = null;
		this.count = 0;
	}
	
	public void enqueue(String input)
	{
		if(this.front == null)
		{
			Person temp = new Person(input);
			this.front = temp;
			this.back = temp;
		}
		else
		{
			Person temp = new Person(input);
			this.back.setNextPerson(temp);
			this.back = temp;
		}
		this.count++;
	}
	
	public int dequeue() throws Exception
	{
		if(this.count == 1)
		{
			int payloadToReturn = front.getWalletBalance();
			this.front = null;
			this.back = null;
			count --;
			return payloadToReturn;
		}
		else if(this.count == 0)
		{
			throw new Exception("The list is empty.");
		}
		else
		{
			int payloadToReturn = front.getWalletBalance();
			this.front = this.front.getNextPerson();
			this.count--;
			return payloadToReturn;
		}
	}
	
	public void display()
	{
		Person temp = this.front;
		for(int i = 0; i < this.count; i++)
		{
			System.out.println("My name is " + temp.getName() + " and I have $" + temp.getWalletBalance());
			temp = temp.getNextPerson();
		}
	}
	public int getCount() 
	{
		return count;
	}
	
	public void displayFront()
	{
		System.out.println("My name is " + this.front.getName() + " and I have $" + this.front.getWalletBalance() +".");
	}

	
}
