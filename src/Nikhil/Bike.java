package Nikhil;

class Bike extends Abc 
{
  void run()
 {
	 System.out.println(" running ");
 }
 public static void main(String args[])
 {
	 Abc ab= new Bike();
	 ab.run();
 }
}
