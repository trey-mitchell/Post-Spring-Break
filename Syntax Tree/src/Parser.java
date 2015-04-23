
public class Parser {

	private String theStmt;
	private int pos;
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private void parse_stmt()
	{
		String varName = null;
		
		for(this.pos = 0; this.pos < this.theStmt.length(); pos++)
		{
			while(this.theStmt.charAt(this.pos) != '=')
			{
				varName = varName + theStmt.charAt(this.pos);
			}
			System.out.println("Variable Name: " + varName);
		}
		//print each time it reads something Like:
		//Read: VarName = a;
		//Reading: Math-expr
		System.out.println("Reading Math Expression...");
		//read a var name
		//read a math expression
		this.parse_math_expr();
	}
	
	private void parse_math_expr()
	{
		//Display
		String expr = null;
		String leftExpr = null;
		String rightExpr = null;
		
		for(int i = this.pos; i < theStmt.length(); i++)
		{
			expr += theStmt.charAt(i);
		}
		System.out.println("Expression: " + expr);
		//Reading Left:
		for(this.pos = this.pos; this.pos < theStmt.length(); this.pos++)
		{
			if(theStmt.charAt(this.pos) == '+')
				break;
			
			else if(theStmt.charAt(this.pos) == '-')
				break;
			else if(theStmt.charAt(this.pos) == '/')
				break;
			else if(theStmt.charAt(this.pos) == '*')
				break;
			else if(theStmt.charAt(this.pos) == '%')
				break;
			else
				leftExpr += theStmt.charAt(this.pos);
		}
		System.out.println("Reading Left:/n" + leftExpr);
		//Read op = *
		System.out.println("Reading Operator:/n" + theStmt.charAt(this.pos));
		//Reading Right
		for(this.pos += 1; this.pos < theStmt.length(); this.pos++)
		{
			rightExpr += theStmt.charAt(this.pos);
		}
		System.out.println("Reading Right:/n"+ rightExpr);
		//read left
		//read op
		//read right
	}
	
}
