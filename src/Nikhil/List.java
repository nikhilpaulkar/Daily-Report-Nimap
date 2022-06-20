package Nikhil;

import java.util.ArrayList;
import java.util.Iterator;

public class List 
{
	public static void main(String args[])
	{
		ArrayList <String> list =new ArrayList<String>();
		list.add("nikhil");
		list.add("avyan");
		list.add("null");
		list.add("nikhil");
		Iterator<String> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}
}
