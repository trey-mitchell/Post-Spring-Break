public class VarDefStatement extends Object
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
	}
	
	public String toString()
	{
		//write this such that it rebuilds the String version
		//of the original statement.  You MAY NOT just use the
		//store string variable theStmt
		return theVarExpr.getVarName() + " = " + theMathExpr.toString();
	}
}