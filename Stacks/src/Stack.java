
public class Stack {

	private Node top;
	private int count;
	
	public Stack()
	{
		this.top = null;
		this.count = 0;
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
	
	public int pull()
	{
		int returnLoad = this.top.getPayload();
		this.top = this.top.getNextNode();
		this.count--;
		return returnLoad;
	}
	
	public int peek()
	{
		return this.top.getPayload();
	}
}
