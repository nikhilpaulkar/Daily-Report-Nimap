package Nikhil;

public class Constructor 
{
	int id;
	String name;
	
	Constructor(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	void display() 
	{
		System.out.println(id+ " " +name);
	}
	public static void main (String args[])
	{
		Constructor c1= new Constructor(1 , "nikhil");
		Constructor c2= new Constructor(2 , "avyaan");
		c1.display();
		c2.display();
		
		
	}
	

}
