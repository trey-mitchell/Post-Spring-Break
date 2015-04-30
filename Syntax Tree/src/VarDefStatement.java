public class VarDefStatement 
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
		System.out.println("You have created the master statement");
	}
	
	public void setVarExpr(VarExpression varEx)
	{
		this.theVarExpr = varEx;
	}
	
	public void setMathExpr(MathExpression mathEx)
	{
		this.theMathExpr = mathEx;
	}
}