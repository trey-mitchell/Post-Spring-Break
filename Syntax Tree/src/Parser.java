
public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalOpCharacters = "+-*/% ";
	private VarDefStatement varDefStmt;
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
		this.varDefStmt = new VarDefStatement(null, null);
	}
	
	
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private String getNextToken(char c)
	{
		while(pos < this.theStmt.length())
		{
			if(this.theStmt.charAt(pos) == c)
			{
				pos++;
				break;
			}
			pos++;
		}
		return "" + c;
	}
	
	private String getNextToken(String legalChars)
	{
		String token = "";
		while(pos < this.theStmt.length())
		{
			if(legalChars.indexOf(this.theStmt.charAt(pos)) != -1)
			{
				token += this.theStmt.charAt(pos);
			}
			else
			{
				//this means we are at the end of the token
				//We are always trimming leading and trailing spaces
				//move forward one
				break;
			}
			pos++;
		}
		return token.trim();
	}
	
	private void parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		//create the "master variable"
		VarExpression variable = new VarExpression(varName);
		this.varDefStmt.setVarExpr(variable);
		
		//burn past the =
		this.getNextToken('=');
		System.out.println("Burned: =");
			
		// Reading: Math-Expr
		this.parse_math_expr();
		
		//burn past the ;
		this.getNextToken(';');
		System.out.println("Burned ;");
	}
	
	
	private void parse_math_expr()
	{
		MathExpression ourExpression = new MathExpression(null, null, null);
		
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			ourExpression.setLeftOperand(this.parse_math_expr_deeper());
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			VarExpression leftEx = new VarExpression(varName);
			ourExpression.setLeftOperand(leftEx);
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		
		char[] arr = op.toCharArray();
		OpExpression opEx = new OpExpression(arr[0]);
		ourExpression.setOperator(opEx);
		
		varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			ourExpression.setRightOperand(this.parse_math_expr_deeper());
			this.getNextToken(')');
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			VarExpression leftEx = new VarExpression(varName);
			ourExpression.setLeftOperand(leftEx);
		}
	}	
	
	private Expression parse_math_expr_deeper()
	{
		MathExpression ourExpression = new MathExpression(null, null, null);
		
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			ourExpression.setLeftOperand(this.parse_math_expr_deeper());
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			VarExpression leftEx = new VarExpression(varName);
			ourExpression.setLeftOperand(leftEx);
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		
		char[] arr = op.toCharArray();
		OpExpression opEx = new OpExpression(arr[0]);
		ourExpression.setOperator(opEx);
		
		varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			this.parse_math_expr();
			this.getNextToken(')');
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			VarExpression leftEx = new VarExpression(varName);
			ourExpression.setLeftOperand(leftEx);
		}
		return ourExpression;
	}	
}