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
	
	static int dp[] = new int[12];
	
	public static void main(String[] args) throws IOException {
		
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N;
		
		dp();
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]).append('\n');
		}
				
		System.out.println(sb);
	}
	
	static void dp() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=11; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
	}

}