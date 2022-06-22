package trycatchblock;

public class Try 
{
	public static void main(String args[])
	{
	 try
	 {
		 
		 int a= 4/0;
	 }
	 catch(ArithmeticException a)
	 {
		 System.out.println(a);
	 }

   }
}