import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int[] treeSize;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		treeSize = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		dfs(R, 0);
		
		for(int i=0; i<Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(treeSize[q]).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int vertex, int par) {
		treeSize[vertex] = 1;
		
		for(int next : list[vertex]) {
			if(next != par) {
				dfs(next, vertex);
				treeSize[vertex] += treeSize[next];
			}
		}
	}

}