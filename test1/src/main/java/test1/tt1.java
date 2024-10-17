package test1;

public class tt1 
{
	char[] a= {1,2,3};
	char[] b = {'a','b','c'};
	
	private void fn() {
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<b.length; j++)
			{
				System.out.println(b[i]+a[j]);
			}
		}

	}

}
