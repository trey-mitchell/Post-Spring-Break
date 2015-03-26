
public class Node {

	private int payload;
	private Node leftNode;
	private Node rightNode;
	private Node rootNode;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.leftNode = null;
		this.rightNode = null;
		this.rootNode = null;
	}

	public Node getLeftNode() 
	{
		return leftNode;
	}

	public void setLeftNode(Node leftNode) 
	{
		this.leftNode = leftNode;
	}

	public Node getRightNode() 
	{
		return rightNode;
	}

	public void setRightNode(Node rightNode) 
	{
		this.rightNode = rightNode;
	}

	public int getPayload() 
	{
		return payload;
	}
	
	public void addNode(Node n)
	{
		if(n.getPayload() <= this.payload)
		{
			if(this.leftNode == null)
			{
				this.leftNode = n;
				n.rootNode = this;
			}
			else
			{
				this.leftNode.addNode(n);
				n.rootNode = this;
			}
		}
		else
		{
			if(this.rightNode == null)
			{
				this.rightNode = n;
				n.rootNode = this;
			}
			else
			{
				this.rightNode.addNode(n);
				n.rootNode = this;
			}
		}
	}

	public Node getRootNode() {
		return rootNode;
	}	
}