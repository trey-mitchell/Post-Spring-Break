public class OpExpression extends Expression 
{
	private char theOp;
	
	public OpExpression(char theOp)
	{
		this.theOp = theOp;
		System.out.println("New operator created");
	}
}
