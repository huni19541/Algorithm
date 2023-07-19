import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		T = new int[N];
		P = new int[N];
		dp = new int[N+1];
		
		for(int i=0; i<N; i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		dp();
		System.out.println(dp[0]);
		
		
		sc.close();
	}

	static void dp()
	{
		int Next;
		
		for(int i=N-1; i>=0; i--)
		{
			Next = i+T[i];
			
			if(Next > N)
				dp[i] = dp[i+1];
			
			else
				dp[i] = Math.max(dp[i+1], P[i]+dp[Next]);
		}
		
	}
	
}