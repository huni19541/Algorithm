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
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] cumulativeSum = new long[N+1];
		for(int i=1; i<=N; i++) {
			cumulativeSum[i] = cumulativeSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		long maxSum = -1;
		for(int i=M; i<=N; i++) {
			maxSum = Math.max((cumulativeSum[i] - cumulativeSum[i-M]), maxSum);
		}
		
		sb.append(maxSum);
		System.out.println(sb);
	}

}