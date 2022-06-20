package Nikhil;

import java.util.HashMap;
import java.util.Map.Entry;

public class Map 
{
	public static void main(String args[])
	{
		HashMap <Integer,String> map= new HashMap <Integer,String>();
		map.put(1 ,  null);
		map.put(2 , "nikhil");
		map.put(3 , "sumit");
        for(Entry<Integer,String> m:map.entrySet())
		{
			System.out.println(m.getKey()+ "," +m.getValue());
		} 
	
	}
}

