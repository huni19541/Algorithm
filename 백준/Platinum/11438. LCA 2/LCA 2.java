import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H;
	static ArrayList<Integer>[] list;
	static int[][] parent;
	static int[] depth;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		H = getTreeHeight();
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		parent = new int[N+1][H];
		depth = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		findParent(1, 1, 0);
		fillParents();
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(LCA(a, b)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int getTreeHeight() {
		return (int)Math.ceil(Math.log(N)/Math.log(2)) + 1;
	}
	
	static void findParent(int cur, int h, int par) {
		depth[cur] = h;
		for(int nxt : list[cur]) {
			if(nxt != par) {
				parent[nxt][0] = cur;
				findParent(nxt, h+1, cur);
			}
		}
	}
	
	static void fillParents() {
		for(int i=1; i<H; i++) {
			for(int j=1; j<=N; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	static int LCA(int a, int b) {
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i=H-1; i>=0; i--) {
			if(depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i];
			}
		}
		
		if(a == b) return a;
		
		for(int i=H-1; i>=0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}
	
	

}