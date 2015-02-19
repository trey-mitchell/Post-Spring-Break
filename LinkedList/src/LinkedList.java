public class LinkedList 
{
	private Node head;
	private int count;
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;
	}
	
	public int get(int index)
	{
		int count = this.count();
		if(index >= count || index < 0)
		{
			System.out.println("Illegal Index");
			return -1;
			//This will eventually need to return an excpeti0n.
		}
		else
		{
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}
	
	public int count()
	{
		return this.count;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + " -> ");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + " -> null");
		}
	}
	
	public void addAtIndex(int payload, int index)
	{
		if(index <= 0)
		{
			this.addFront(payload);
		}
		else if(index >= count)
		{
			this.addEnd(payload);
		}
		else
		{
			Node n = new Node(payload);
			Node prevTarget = null;
			Node fronTarget = this.head;
			
			for(int i = 0; i < index; i++)
			{
				prevTarget = fronTarget;
				fronTarget = fronTarget.getNextNode();
			}
			n.setNextNode(fronTarget);
			prevTarget.setNextNode(n);
			count++;
		}
	}
	
	public void addFront(int payload)
	{
		Node n = new Node(payload);
		if(head == null)
		{
			head = n;
		}
		else
		{
			n.setNextNode(head);
			head = n;
		}
		this.count++;
	}
	
	public void addEnd(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			//find the last node in the list
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			//currNode will point to the very last Node in the list
			currNode.setNextNode(n);
		}
		this.count++;
	}
	
	public int removeFront() throws Exception
	{
		if(head==null)
			{
			throw new Exception("The list is empty.");
			}
		Node curr = this.head;
		head=head.getNextNode();
		curr.setNextNode(null);
		count--;
		return curr.getPayload();
	}
	
	public int removeEnd() throws Exception
	{
		if(head==null)
		{
			throw new Exception("Cannot Remove End: Empty List");
		}
		else if(this.count==1)
		{
			return this.removeFront();
		}
		Node curr = this.head;
		for(int i = 1; i < count -1; i++)
		{
			curr = curr.getNextNode();
		}
		int payload = curr.getNextNode().getPayload();
		count--;
		curr.setNextNode(null);
		return payload;
	}
	
	public int removeAtIndex(int index) throws Exception
	{
		if(head==null)
		{
			throw new Exception("Cannot Remove from Index: Empty List");
		}	
		else if(this.count==1)
		{
			return this.removeFront();
		}
		else if(index >= count)
		{
			throw new Exception("Cannot Remove from Index: Index too Large");
		}
		else if(index < 0)
		{
			throw new Exception("Cannot Remove from Index: Index Must be Greater than Zero");
		}
		else
		{
			Node targetLead = null;
			Node target = this.head;
			for(int i = 0; i < index; i++)
			{
				targetLead = target;
				target = target.getNextNode();
			}
			int payload = target.getPayload();
			targetLead.setNextNode(target.getNextNode());
			target.setNextNode(null);
			this.count--;
			return payload;
		}
}
	}