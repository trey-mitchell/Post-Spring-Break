
public class VarEnvironment {
	
	private Variable[] theCollector;
	private int pos;
	private int countFilled;
	
	
	public VarEnvironment(int count)
	{
		theCollector = new Variable[count]; 
		this.pos = 0;
		this.countFilled = 0;
	}

	public void add(Variable v)
	{
		this.theCollector[pos] = v;
		pos++;
		countFilled++;
	}
	
	public int find(String identity)
	{
		String currVarName = null;
		/*for(Variable vars: this.theCollector)
		{
			if(identity.equals(vars.getVarName()))
			{
				return vars.getValue();
			}
		}*/
		
		/*for(Variable vars: this.theCollector)
		{
			System.out.print("**" + vars.getValue() + "**");
		}*/
		
		for(int i = 0; i < this.countFilled; i++)
		{
			currVarName = this.theCollector[i].getVarName();
			
			if(currVarName.equals(identity))
			{
				return theCollector[i].getValue();
			}
		}
		
		System.out.println("A variable was not defined, you broke it...");
		return 0; //should never get this far...
	}
}
