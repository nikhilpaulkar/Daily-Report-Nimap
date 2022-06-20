package Nikhil;

public class SecondLarArray 
{
	public static void main(String args[])
	{
		int a[]= {22,34,54,72,86};
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				int temp=0;
				if(a[i]==a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				
				}
			}
		}
		
   	  System.out.println(a[-2]);
	
	}

}
