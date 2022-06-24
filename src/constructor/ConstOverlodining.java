package constructor;

public class ConstOverlodining
{
    int id;
    String name;
    String city;
    
    ConstOverlodining(int id, String name)
    {
    	this.id=id;
    	this.name=name;
    	
    }
    ConstOverlodining(int id, String name, String city)
    {
    	this.id=id;
    	this.name=name;
    	this.city=city;
    }
    
    void disp()
    {
    	System.out.println(id+ "," +name+"," +city);	
    }
    public static void main(String args[])
    {
    	ConstOverlodining co=new ConstOverlodining(1,"kapil");
    	ConstOverlodining c1=new ConstOverlodining(2,"ganesh" ,"latur");
    	co.disp();
    	c1.disp();
    }
}
