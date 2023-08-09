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
		
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++)
			scores[i] = Integer.parseInt(br.readLine());
		
		dp[1] = scores[1];
		if(N >= 2)
			dp[2] = scores[2]+dp[1];
		
		for(int i=3; i<N; i++) {
			if(i == N-1) {
				dp[i] = dp[i-2]+scores[i];
				continue;
			}
			dp[i] = Math.max(dp[i-3]+scores[i-1]+scores[i], dp[i-2]+scores[i]);
		}
		
		if(N >= 2)
			dp[N] = Math.max(dp[N-2]+scores[N], dp[N-1]+scores[N]);
		
		sb.append(dp[N]);
		System.out.println(sb);
	}

}