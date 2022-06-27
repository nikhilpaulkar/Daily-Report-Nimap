package exception;

public class Thrown 
{
 public static void main(String args[])
 {
	 int age=17;
	 if (age<18)
	 {
		 throw new ArithmeticException ("peson is not eligible");
	 }
	 else
	 {
		 System.out.println("person is eligible");
	 }
	 
 }
}
