package staticvariable;

public class StatM 
{
	 static int id;
	  String name;
	 static void m1()
	 {
		 System.out.println("welcome");
	 }
	 
	 StatM(int id , String name)
		{
			this.id=id;
			this.name=name;
		}
	 void disp()
	 {
		 System.out.println(id+ "," +name);
	 }
	public static void main(String args[])
	{
	  StatM.m1();
      StatM s=new StatM(1,"janak");
      StatM s1=new StatM(2,"nikhil");
      s.disp();
      s1.disp(); 
    }
}
