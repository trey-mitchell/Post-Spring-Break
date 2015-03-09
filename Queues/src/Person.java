import java.util.Random;

public class Person
{
	
	private String name;
	private int walletBalance;
	private static Random r = new Random();
	private Person nextPerson;
	
	public Person(String name)
	{
		this.name = name;
		this.walletBalance = Person.r.nextInt(10);
		this.nextPerson = null;
	}

	public void display()
	{
		System.out.println("Hi, my name is" 
				+ this.name + "and I have " + this.walletBalance + " dollars on me.");
	}

	public int getWalletBalance() 
	{
		return walletBalance;
	}

	public Person getNextPerson() 
	{
		return nextPerson;
	}

	public void setNextPerson(Person nextPerson) 
	{
		this.nextPerson = nextPerson;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
