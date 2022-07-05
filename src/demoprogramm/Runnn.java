package demoprogramm;

public class Runnn implements Runnable
{
	public void run()
	{
		System.out.println("running");
	}
	
	public static void main(String args[])
	{
		Runnn m=new Runnn();
		Thread t=new Thread(m);
		t.start();
		
	} 


}
   







