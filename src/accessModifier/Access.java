package accessModifier;

public class Access 
{
	private int a=5;
	private void m1()
	{
		System.out.println("hello");
	}
}
	
	class Test
	{
		public static void main(String args[])
		{
			Access a1=new Access();
			System.out.println(a1.a);
			a1.m1();
		}
	}
	
	


