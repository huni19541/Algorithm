import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		long N = Long.parseLong(br.readLine());
		int k = 6;
		int period = 15*(int)Math.pow(10, k-1);

		N %= period;
		int[] dp = new int[(int)N+1];
		dp[1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
		}
		
		sb.append(dp[(int)N]);
		System.out.println(sb);
	}

}