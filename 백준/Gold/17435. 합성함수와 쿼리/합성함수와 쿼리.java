import java.util.*;
import java.io.*;

public class Main {
	
	static int M, Q, H;
	static ArrayList<Integer>[] list;
	static int[][] parent;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		H = getHeight();
		
		list = new ArrayList[M+1];
		for(int i=1; i<=M; i++) {
			list[i] = new ArrayList<>();
		}
		parent = new int[M+1][H];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			int p = Integer.parseInt(st.nextToken());
			list[p].add(i);
			parent[i][0] = p;
		}
		
		fillParents();
		
		int Q = Integer.parseInt(br.readLine());
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			sb.append(find(n, x)).append('\n');
		}
		
		System.out.println(sb);
	}

	static int getHeight() {
		return (int)Math.ceil(Math.log(500000)/Math.log(2)) + 1;
	}
	
	static void fillParents() {
		for(int i=1; i<H; i++) {
			for(int j=1; j<=M; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	static int find(int n, int x) {
		if(n == 1)
			return parent[x][0];
		
		for(int i=H-1; i>=0; i--) {
			if(n >= (1 << i)) {
				x = parent[x][i];
				n -= (1 << i);
			}
		}
		
		return x;
	}
}