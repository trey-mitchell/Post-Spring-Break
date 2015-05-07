
public class MathExpression extends Expression
{
	private Expression leftOperand;
	private Expression rightOperand;
	private OpExpression operator;
	private VarEnvironment container;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
	}
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator, VarEnvironment container)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
		this.container = container;
	}
	
	public int doMath()
	{
		int theLeftNum;
		int theRightNum;
		if(this.leftOperand instanceof VarExpression)
		{
			theLeftNum = container.find(this.leftOperand.getVarName());;
		}
		else if(this.leftOperand instanceof LitExpression)
		{
			theLeftNum = ((LitExpression) this.leftOperand).getTheLiteral();
		} 
		else
		{
			theLeftNum = ((MathExpression)this.leftOperand).doMath();
		}
		
		if(this.rightOperand instanceof VarExpression)
		{
			theRightNum = container.find(this.rightOperand.getVarName());;
		}
		else if(this.rightOperand instanceof LitExpression)
		{
			theRightNum = ((LitExpression) this.rightOperand).getTheLiteral();
		} 
		else
		{
			theRightNum = ((MathExpression)this.rightOperand).doMath();
		}
		return this.operator.applyOperator(theLeftNum, theRightNum);
	}
	
	public String toString()
	{
		String result = "";
		if(this.leftOperand instanceof MathExpression)
		{
			result += "(" + this.leftOperand.toString() + ")";
		}
		else
		{
			result += this.leftOperand.toString();
		}
		result += this.operator.toString();
		if(this.rightOperand instanceof MathExpression)
		{
			result += "(" + this.rightOperand.toString() + ")";
		}
		else
		{
			result += this.rightOperand.toString();
		}
		return result;
	}
}