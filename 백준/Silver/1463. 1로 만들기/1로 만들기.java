import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static int res = 0;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[T+1];
		
		for(int i=1; i<=T; i++) {
			if(i == 1) {
				dp[i] = 0;
				continue;
			}
			else if(i == 2) {
				dp[i] = 1;
				continue;
			}
			else if(i == 3) {
				dp[i] = 1;
				continue;
			}
			
			if(i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i-1]+1, Math.min(dp[i/2]+1, dp[i/3]+1));
			}
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);
			}
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
			}
			else {
				dp[i] = dp[i-1]+1;
			}
		}
		
		sb.append(dp[T]);
		
		System.out.println(sb);
		
	}
	
}