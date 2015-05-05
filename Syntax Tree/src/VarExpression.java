public class VarExpression extends Expression
{
	private String varName;
	private String type = "var";
	
	public VarExpression(String varName)
	{
		this.varName = varName;
	}
	
	public String getVarName()
	{
		return this.varName;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String toString()
	{
		return this.varName;
	}
}