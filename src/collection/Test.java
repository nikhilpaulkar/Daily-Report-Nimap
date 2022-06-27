package collection;

//import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

public class Test 
{

	public static void main(String[] args) 
	{
		Hashtable <Integer,String> map=new Hashtable<Integer,String>();
				map.put(1,"vivek");
				map.put(2, "nck");
				map.put(3, "jkdk");
				
				for(Entry<Integer, String> m:map.entrySet())
				{  
					   System.out.println(m.getKey()+" "+m.getValue()); 
				}
  }

}
