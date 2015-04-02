public class BinaryTree 
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int depth;
	private BinaryTree myRoot; 
	
	public BinaryTree()
	{
		this(0, null);
	}
	
	private BinaryTree(int depth, BinaryTree root)
	{
		this.isEmpty = false;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
		this.myRoot = root;
	}
	
	private int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}
	
	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			int currMaxLeftDepth = this.leftTree==null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree==null?0:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}
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
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
			this.depth = 0;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree(this.depth+1, this);	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1, this);
				}
				this.rightTree.add(value);
			}
		}
		if(!this.isBalanced())
		{
			this.balance();
		}
	}
	
	private void singleLeftRot()
	{
		if(this.rightTree.leftTree == null)
		{
			BinaryTree rootParent = this.myRoot;
			this.myRoot = this.rightTree;
			this.rightTree.leftTree = this;
			this.myRoot.myRoot = rootParent;
		}
		else
		{
			BinaryTree rootParent = this.myRoot;
			BinaryTree leftTemp = this.rightTree.leftTree;
			this.myRoot = this.rightTree;
			this.leftTree = leftTemp;
			this.rightTree.leftTree = this;
			this.myRoot.myRoot = rootParent;
		}
	}
	
	private void singleRightRot()
	{
		if(this.leftTree.rightTree == null)
		{
			BinaryTree rootParent = this.myRoot;
			this.myRoot = this.leftTree;
			this.leftTree.rightTree = this;
			this.myRoot.myRoot = rootParent;
		}
		else
		{
			BinaryTree rootParent = this.myRoot;
			BinaryTree rightTemp = this.leftTree.rightTree;
			this.myRoot = this.leftTree;
			this.rightTree = rightTemp;
			this.leftTree.rightTree = this;
			this.myRoot.myRoot = rootParent;
		}
	}
	
	private boolean leftHeavy()
	{
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			int currMaxLeftDepth = this.leftTree==null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree==null?0:this.rightTree.getMaxDepth();
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) >= 1;
		}
	}
	
	private void balance()
	{
		if(!this.leftHeavy())
			if(this.rightTree.leftHeavy())
			{
				//the right left rotation
				this.rightTree.singleLeftRot();
				this.singleRightRot();
			}
			else
			{
				//single left
				this.singleLeftRot();				
			}
		else if(this.leftHeavy())
		{
			if(!this.leftTree.leftHeavy())
			{
				this.leftTree.singleRightRot();
				this.singleLeftRot();
			}
			else
			{
				this.singleRightRot();
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