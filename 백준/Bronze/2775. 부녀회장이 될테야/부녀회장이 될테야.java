import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[K+1][N+1];
			for(int i=1; i<=N; i++)
				dp[0][i] = i;
			
			for(int i=1; i<=K; i++) {
				for(int j=1; j<=N; j++) {
					for(int k=1; k<=j; k++) {
						dp[i][j] += dp[i-1][k];
					}
				}
			}
			
			sb.append(dp[K][N]).append('\n');
		}
		
		
		System.out.println(sb);
	}

}