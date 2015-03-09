
public class Driver 
{

	public static void main(String[] args) throws Exception
	{
		Queue qq = new Queue();
		for(int i = 0; i < 100; i++)
		{
			qq.enqueue("Person"+ Integer.toString(i));
		}
		while(qq.getCount() != 0)
		{
			qq.displayFront();
			qq.dequeue();
		}
	}
}
