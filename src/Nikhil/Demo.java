package Nikhil;

///import java.awt.DisplayMode;

class Demo 
 {
	static int id;
	 String name;
	Demo(int id,String name )
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
		Demo d=new Demo(1,"kapil");
		Demo d1=new Demo(2,"rohan");
		d.disp();
		d1.disp();
	}
	{
	
	}
	
 }
