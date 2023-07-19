
public class Main {
    
	public static void main(String[] args) {
		
		selfNumber(10000);
	}
	
	static void selfNumber(int n)
	{
		
		for(int i=1; i<=n; i++)
		{
			boolean check = true;
			for(int j=1; j<i; j++)
			{
				if(d(j) == i)
				{
					check = false;
					break;
				}
			}
			if(check)
				System.out.println(i);
		}
	}
	
	static int d(int n)
	{
		int sum = n;
		
		while(n > 0)
		{
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
}
