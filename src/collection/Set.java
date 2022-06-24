package collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Set 
{
	public static void main(String args[])
	{
		LinkedHashSet<String> set= new LinkedHashSet<String> ();
		set.add("nikhil");
		set.add("avyan");
		set.add(null);
		set.add("nikhil");
		set.add(null);
		Iterator<String> itr = set. iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}

}



