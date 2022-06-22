package Nikhil;

public class Stat 
{
   static int id;
     String name;

Stat(int id, String name)
{
	this.id=id;
    this.name=name;	
}

StatM s=new StatM(1,"janak"); void disp()
{
	System.out.println(id+ "," +name);
}
public static void main(String args[])
{
	Stat s= new Stat (1,"nikhil");
	Stat s1= new Stat(2,"ganesh");
	s.disp();
	s1.disp();
}
}

	