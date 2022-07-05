package demoprogramm;

public class Swapping 
{
 public static void main(String args[])
 {
	int  a=9,b=6;
	System.out.println("before swap a=" +a);
	System.out.println("before swap b=" +b);
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("after swap a=" +a);
	System.out.println("after swap b=" +b);
 }
}
