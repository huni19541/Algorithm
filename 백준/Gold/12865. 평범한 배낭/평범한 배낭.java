import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


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
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
					if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
					}
					
					else {
						dp[i][j] = dp[i-1][j];
					}
			}
		}
		
		
		
		sb.append(dp[N][K]);
		
		System.out.println(sb);
	}

}