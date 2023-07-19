
public class Main {
    
	public static void main(String[] args) {
		selfNumber(10000);
	}

	// n까지 셀프넘버 구하는 함수
	static void selfNumber(int n)
	{
		for(int i=1; i<=n; i++)
		{
			boolean check = true;
			for(int j=1; j<i; j++)
			{
				// 생성자가 있다면, break;
				if(d(j) == i)
				{
					check = false;
					break;
				}
			}
			// 생성자가 없다면 print
			if(check)
				System.out.println(i);
		}
	}

	// 생성자 구하는 함수
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
