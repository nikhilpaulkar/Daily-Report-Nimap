package accessModifier;

public class Private 
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
			Private a1=new Private();
			System.out.println(a1.a);
			a1.m1();
		}
	}
	
	


