public class BinaryTree 
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int count;
	
	public BinaryTree()
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.count = 0;
	}
	
	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}

	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}
	}
	
	private void visitPreOrder()
	{
		System.out.println(this.payload);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}
	
	public void displayPreOrder()
	{
		System.out.println("**** Pre Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
	}
	
	private void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload);
	}
	
	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
		}
	}
	
	public void add(int value)
	{
		this.count++;
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree();	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree();
				}
				this.rightTree.add(value);
			}
		}
	}
	
	private boolean stepThrough(int searchValue)
	{
		if(this.payload == searchValue)
		{
			return true;
		}
		else if (searchValue < this.payload)
		{
			if(this.leftTree == null)
			{
				return false;
			}
			else
			{
				return leftTree.stepThrough(searchValue);
			}
		}
			else if(searchValue > this.payload)
			{
				if(this.rightTree == null)
				{
					return false;
				}
				else
				{
					return this.rightTree.search(searchValue);
				}
			}
			return false;		
	}
	
	public boolean search(int searchVal)
	{
		if(isEmpty)
		{
			return false;
		}
		else
		{
			return this.stepThrough(searchVal);
		}
	}
}