import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp1 = new long[N+1][N+1]; // →
		long[][] dp2 = new long[N+1][N+1]; // ↘
		long[][] dp3 = new long[N+1][N+1]; // ↓
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == 1 && j == 1) continue;
				
				if(i == 1 && j == 2) {
					dp1[i][j] = 1;
					continue;
				}
				
				if(map[i][j] == 1) {
					dp1[i][j] = 0;
					dp2[i][j] = 0;
					dp3[i][j] = 0;
					continue;
				}
				
				dp1[i][j] = dp1[i][j-1] + dp2[i][j-1];
				if(map[i-1][j] == 0 && map[i-1][j-1] == 0 && map[i][j-1] == 0) {
					dp2[i][j] += dp1[i-1][j-1] + dp2[i-1][j-1] + dp3[i-1][j-1];
				}
				dp3[i][j] = dp2[i-1][j] + dp3[i-1][j]; 
			}
		}
		
		sb.append(dp1[N][N] + dp2[N][N] + dp3[N][N]).append('\n');
		
		System.out.println(sb);
		
	}

}