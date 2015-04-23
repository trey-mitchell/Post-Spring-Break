
public class Pilot {
	
	static public void main(String[] args)
	{
		Parser p = new Parser("     a =     (a *   b) - c;");
		Parser p2 = new Parser("     a =  b - c;");
		
		p.parse();
		p2.parse();
	}
	
}

