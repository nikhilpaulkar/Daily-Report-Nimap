package genericclassmethod;

public class DemoGeneric<a,b>
{
 public void disp(a var1,b  var2)
 {
	 System.out.println("name: "+var1+" , id: "+var2);
 }
 public static void main(String args[])
 {
	 DemoGeneric<String,Integer> obj=new DemoGeneric<String,Integer>();
	 obj.disp("pravin", 2);
 }
}
