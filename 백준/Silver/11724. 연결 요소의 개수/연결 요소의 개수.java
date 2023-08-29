import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		make();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		
		for(int i=1; i<=N; i++) {
			find(i);
		}
		
		HashSet<Integer> hashset = new HashSet<>();
		for(int i=1; i<=N; i++) {
			hashset.add(parent[i]);
		}
		
		sb.append(hashset.size());
		
		System.out.println(sb);
		

	
	}
	
	static void make() {
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		
		return true;
	}

}