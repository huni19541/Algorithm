import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int N;

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[] dp = new int[N + 1];
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		
		if(N == 4)
			dp[4] = -1;
		
		if(N >= 5)
		{
			dp[4] = -1;
			dp[5] = 1;
		}

		for (int i = 6; i <= N; i++) {
			
			if (dp[i - 3] > 0 && dp[i - 5] > 0)
				dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
			
			else if(dp[i-3] > 0)
				dp[i] = dp[i-3] + 1;

			else if(dp[i-5] > 0)
				dp[i] = dp[i-5] + 1;
			
			else
				dp[i] = -1;
		}

		int res = dp[N];
		System.out.println(res);
		
		sc.close();

	}

}
