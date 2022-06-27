package exception;

public class MultipleExce 
{
 public static void main(String args[])
 {
	 try
	 {
		 int d=45/0;
		 String s=null;
	 }
	 catch(ArithmeticException d)
	 {
		 System.out.println(d);
	 }
	 catch(NullPointerException s)
	 {
		 System.out.println(s);
	 }
	 catch(Exception e)
	 {
		 System.out.println("parent exception ");
	 }
	 
     System.out.println("rest of code");
   }
}
