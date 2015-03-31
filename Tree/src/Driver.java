
public class Driver {

	public static void main(String[] args) throws Exception
	{
		BinaryTree tree = new BinaryTree();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(8);
		tree.add(9);
		tree.add(10);
		tree.add(11);
		System.out.println(tree.search());
	}
}
