package exception;

public class ArryIndex 
{
  public static void main(String args[])
  {
	  try
	  {
		  int a[]= {34,75,83,88,22};
	      System.out.println(a[5]);
	  }
	  catch(ArrayIndexOutOfBoundsException a)
	  {
		  System.out.println(a);
	  }
	  
  }
	
	
}
