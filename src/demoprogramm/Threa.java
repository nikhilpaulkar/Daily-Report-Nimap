package demoprogramm;

public class Threa extends Thread
{
  public void run()
  {
	  System.out.println("create a simple thread");
  }
  public static void main(String args[])
  {
	  Threa t= new Threa();
	  
	  t.start();
	 
  }
}
