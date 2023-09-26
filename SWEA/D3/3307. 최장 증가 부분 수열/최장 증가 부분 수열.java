import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			int[] dp = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
		
				boolean check = false;
				for(int j=1; j<i; j++) {
					if(arr[i] > arr[j]) {
						check = true;
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				if(!check) {
					dp[i] = 1;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=1; i<=N; i++) {
				max = Math.max(max, dp[i]);
			}
			
			sb.append('#').append(tc).append(" ").append(max).append('\n');
		}
		
		System.out.println(sb);
	}

}