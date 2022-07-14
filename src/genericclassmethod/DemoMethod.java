package genericclassmethod;

public class DemoMethod 
{
 public <t> void disp()
 {
	 System.out.println("hello everyone");
 }
 public static void main(String args[])
 {
	 DemoMethod obj=new DemoMethod();
	 obj.disp();
 }
}
