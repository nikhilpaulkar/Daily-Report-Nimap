package typecastining;

public class StringtoBoolean 
{

	public static void main(String[] args) 
	{
		String s="true";
		String v="false";
		boolean a=Boolean.parseBoolean(s);
		boolean d=Boolean.getBoolean(v);
		System.out.println(a);
		System.out.println(d);

	}

}
