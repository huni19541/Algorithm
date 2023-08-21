import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] arr = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] dp;
			if(N <= 10)
				dp = new long[11];
			else
				dp = new long[N+1];
			for(int i=0; i<11; i++) {
				dp[i] = arr[i];
			}
			
			for(int i=11; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			sb.append(dp[N]).append('\n');
			
		}
		
		System.out.println(sb);
	}

}