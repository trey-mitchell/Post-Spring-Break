public class Pilot 
{
	public static void main(String[] args)
	{		
		Parser p = new Parser("     apple =     (a *   b) - c;");
		p.parse();
	}
}

