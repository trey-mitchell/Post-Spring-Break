
public class BinaryTree {
	
	private Node root;
	
	public BinaryTree()
	{
		this.root = null;
	}
	
	public Node findLeft()
	{
		Node temp = this.root;
		
		while(temp.getLeftNode() != null)
		{
			temp = temp.getLeftNode();
		}
		return temp;
	}
	
	public void displayInOrder()
	{
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.root.visitInOrder();
		}
		
	}
	
	public void displayPreOrder()
	{
		System.out.println("*****Pre Order*****");		
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.root.visitInOrder();
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		this.root.addNode(theNode);
	}
	
}