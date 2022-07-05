package demoprogramm;

public class Palindrome 
{
 public static void main(String args[])
 {
	 int r, temp,n=121,sum=0;
	 temp=n;
	 while (n>0)
	 {
		 r=n%10;
		 sum=(sum*10)+r;
		 n=n/10;
	 }
	 if(temp==sum)
	 {
		 System.out.println("number is palindrome");
	 }
	 else
	 {
		 System.out.println("number is not palindrome");
	 }
 }
}
