import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		make();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					union(i, j);
				}
			}
		}
		
		boolean check = true;
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i == 0) {
				root = find(num);
				continue;
			}
			
			if(root != find(num)) {
				check = false;
				break;
			}
		}
		if(check) sb.append("YES");
		else sb.append("NO");
		
		System.out.println(sb);
		
	}

	static void make() {
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot= find(b);
		
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		
		return true;
	}
}