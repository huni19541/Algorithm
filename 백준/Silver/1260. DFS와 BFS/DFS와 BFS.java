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

	
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean[][] nearby = new boolean[N+1][N+1];
		boolean[] dfsVisit = new boolean[N+1];
		boolean[] bfsVisit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken()); 
			int node2 = Integer.parseInt(st.nextToken());
			
			nearby[node1][node2] = true;
			nearby[node2][node1] = true;
		}
		
		
		
		Stack<Integer> stack = new Stack<>();
		DFS(N, V, nearby, dfsVisit, stack, sb);
		System.out.println(sb);
		BFS(N, V, nearby, bfsVisit);
	}
	
	static void DFS(int N, int V, boolean[][] nearby, boolean[] dfsVisit, Stack<Integer> stack, StringBuilder sb) {
		stack.add(V);
		dfsVisit[V] = true;
		while(!stack.isEmpty()) {
			stack.pop();
			sb.append(V).append(" ");
			for(int i=1; i<=N; i++) {
				if(nearby[V][i] == true && dfsVisit[i] == false) {
					DFS(N, i, nearby, dfsVisit, stack, sb);
				}
			}
		}
	}
	
	static void BFS(int N, int V, boolean[][] nearby, boolean[] bfsVisit) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		int cur = 0;
		queue.add(V);
		bfsVisit[V] = true;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			sb.append(cur).append(" ");
			for(int i=1; i<=N; i++) {
				if(nearby[cur][i] == true && bfsVisit[i] == false) {
					bfsVisit[i] = true;
					queue.add(i);
				}
			}
		}
		sb.append('\n');
		
		System.out.println(sb);
	}
	
}