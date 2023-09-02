import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] w = new int[N+1];
		int[] v = new int[N+1];
		int[] dp = new int[K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=K; j>=0; j--) {
					if(w[i] <= j) {
					    dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
					}
			}
		}
		
		
		
		sb.append(dp[K]);
		
		System.out.println(sb);
	}

}