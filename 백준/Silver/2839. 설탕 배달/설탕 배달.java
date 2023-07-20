import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int N;

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[] dp = new int[N + 1];

		// 초기값 설정
		for (int i = 1; i <= N; i++) {
			
			if (i - 5 <= 0)
			{
				if(i == 3)
					dp[i] = 1;
				
				else if (i == 5)
					dp[i] = 1;
				
				else
					dp[i] = -1;
				
				continue;
			}

			// 3킬로, 5킬로 둘 다 가능한 경우
			if (dp[i - 3] > 0 && dp[i - 5] > 0)
				dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);

			// 3킬로만 가능한 경우
			else if (dp[i - 3] > 0)
				dp[i] = dp[i - 3] + 1;

			// 5킬로만 가능한 경우
			else if (dp[i - 5] > 0)
				dp[i] = dp[i - 5] + 1;

			// 만들 수 없는 경우
			else
				dp[i] = -1;
		}

		int res = dp[N];
		System.out.println(res);

		sc.close();

	}

}
