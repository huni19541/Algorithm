import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
	
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=1; i*i<=N; i++) {
			dp[i*i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			int start = 1;
			while(start*start < i) {
				dp[i] = Math.min(dp[start*start] + dp[i-start*start], dp[i]);
				start++;
			}
		}
		sb.append(dp[N]);
		
		System.out.println(sb);
	}
	
}