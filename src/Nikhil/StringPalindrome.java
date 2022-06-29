package demoprogramm;

public class StringPalindrome 
{
  public static void main(String args[])
  {
	  String s="coc";
	  String rev="";
	  for (int i=s.length()-1;i>=0;i--)
	  {
		 rev=rev + s.charAt(i);
	  }
	  if(s.equals(rev))
	  {
		  System.out.println("string is palindrome");
	  }
	  else
	  {
		  System.out.println("string is not palindrome");
	  }
	  
  }
}
