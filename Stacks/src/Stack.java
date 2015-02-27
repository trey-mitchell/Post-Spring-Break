//nothing
public class Stack {

	private Node top;
	private int count;
	
	public Stack()
	{
		this.top = null;
		this.count = 0;
	}
	
	public boolean isEmpty()
	{
		return this.top == null;
	}
	
	public void display()
	{
		Node n = this.top;
		for(int i = 0; i < this.count; i++)
		{
			System.out.print(n.getPayload()+ " -> ");
			n = n.getNextNode();
		}
		System.out.println("null");
	}
	
	public void push(int payload)
	{
		Node n = new Node(payload);
		if(top == null)
		{
			this.top = n;
		}
		else
		{
		n.setNextNode(this.top);
		this.top = n;
		}
		this.count++;
	}
	
	public int pop() throws Exception
	{
		if(top == null)
		{
			throw new Exception("Cannot pop from an empty stack!");
		}
		else
		{
		int returnLoad = this.top.getPayload();
		this.top = this.top.getNextNode();
		this.count--;
		return returnLoad;
		}
	}
	
	public int peek() throws Exception
	{
		if(this.top == null)
		{
			throw new Exception("There's nothing in the Stack!");
		}
		else
		{
		return this.top.getPayload();
		}
	}
}
