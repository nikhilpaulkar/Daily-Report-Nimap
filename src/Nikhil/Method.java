package Nikhil;

public class Method {
	private static void m1(int a)
	{
		System.out.println(a);
	}
	private static void m1(int a, int b)
	{
		System.out.println(a+ "," +b);
	
	}
	
	public static void main(String args[])
	{
		m1(1);
		m1(3,6);
		
	}
}
