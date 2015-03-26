
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
		//left root right
		BinaryTree tempTree = this;
		Node finder = tempTree.root;
		Node subRoot = null;
		
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		while(tempTree.root != null)
		{
			if(finder.getLeftNode() != null)
			{
				while(finder.getLeftNode() != null)
				{
					subRoot = finder;
					finder = finder.getLeftNode();
				}
				System.out.println(finder.getPayload());
				finder = subRoot;
				subRoot.setLeftNode(null);
				System.out.println(subRoot.getPayload());
				if(finder.getRightNode() == null)
				{
					subRoot = finder.getRootNode();
					subRoot.setLeftNode(null); //this could be a source of error
					finder = subRoot;
				}
			}
			else if(finder.getRightNode() != null)
			{
				finder = finder.getRightNode();
				if()
			}
		}
	}
	
	public void displayPostOrder()
	{
		//left right root
		BinaryTree tempTree = this;
		Node finder = tempTree.root;
		System.out.println("*****Post Order*****");		
		if(tempTree.root == null)
		{
			System.out.println("Empty Tree");
		}
		while(tempTree.root != null)
		{
			while(finder.getLeftNode() != null)
			{
				finder = finder.getLeftNode();
			}
			if(finder.getRightNode() != null)
			{
				finder = finder.getRightNode();
				
			}
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		this.root.addNode(theNode);
	}
	
}