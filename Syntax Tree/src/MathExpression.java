
public class MathExpression extends Expression
{
	private Expression leftOperand;
	private Expression rightOperand;
	private OpExpression operator;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
	}


	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}

	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}

	public void setOperator(OpExpression operator) {
		this.operator = operator;
	}
	
	public Expression getLeftOperand() {
		return leftOperand;
	}


	public Expression getRightOperand() {
		return rightOperand;
	}


	public OpExpression getOperator() {
		return operator;
	}
	
	public String toString()
	{
		String left = "";
		String right = "";
		if(this.leftOperand != null)
			left = this.leftOperand.toString();
		else
			left = this.toString();
		if(this.rightOperand!=null)
			right = this.rightOperand.toString();
		else
			right = this.toString();
		
		return left + operator.getTheOp() + right;
		
	}
	
	
}