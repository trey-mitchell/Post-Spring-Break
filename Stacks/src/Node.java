public class Node 
{
	private Node nextNode;
	private Node prevNode;
	private int payload;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
		this.prevNode = null;
	}
 
	public Node getPrevNode()
	{
		return this.prevNode;
	}
	
	public void setPrevNode(Node input)
	{
		this.prevNode = input;
	}
	
	public Node getNextNode() 
	{
		return this.nextNode;
	}
 
	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}
 
	public int getPayload() {
		return payload;
	}
}