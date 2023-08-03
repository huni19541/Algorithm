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

		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] connect = new boolean[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			connect[c1][c2] = true;
			connect[c2][c1] = true;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visit[1] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(cur == i) continue;
				
				if(!visit[i] && connect[cur][i] == true) {
					queue.add(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
	}
	
}