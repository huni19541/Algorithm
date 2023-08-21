import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || i==j) {
					dp[i][j] = 1;
					continue;
				}
				
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		
		int sum = 0;
		for(int i=0; i<=(N/2); i++) {
			sum += dp[N-i][i];
			sum %= 10007;
		}
		
		sb.append(sum);
		
		System.out.println(sb);
	}
	
}