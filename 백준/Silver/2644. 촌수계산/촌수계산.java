import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H;
	static int[][] parent;
	static int[] depth;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		H = getTreeHeight();
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		parent = new int[N+1][H];
		depth = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[p].add(c);
			parent[c][0] = p;
		}
	
		// 루트 노드 찾기
		for(int i=1; i<=N; i++) {
			if(parent[i][0] == 0) {
				fillDepth(i, 1, 0);
			}
		}
		
		fillParents();
		
		sb.append(LCA(a, b));
		System.out.println(sb);
	}
	
	private static int getTreeHeight() {
		return (int)Math.ceil(Math.log(N)/Math.log(2)) + 1;
	}
	
	private static void fillDepth(int cur, int h, int par) {
		depth[cur] = h;
		
		for(int next : list[cur]) {
			if(next != par) {
				fillDepth(next, h+1, cur);
			}
		}
	}
	
	private static void fillParents() {
		for(int i=1; i<H; i++) {
			for(int j=1; j<=N; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	private static int LCA(int a, int b) {
		int resA = 0;
		int resB = 0;
		
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		// 높이 맞추기
		for(int i=H-1; i>=0; i--) {
			if(depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i];
				resB += (1 << i);
			}
		}

		// 높이를 맞췄는데 두 노드가 같은 경우 -> 공통 조상 바로 찾음
		if(a == b) {
			return resB;
		}
		
		// 최소 공통 조상 찾기
		for(int i=H-1; i>=0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				resA += (1 << i);
				b = parent[b][i];
				resB += (1 << i);
			}
		}
		
		boolean check = true;
		if(parent[a][0] == 0)
			check = false;

		if(check) {
			int res = resA + resB + 2;
			return res;
		}
		else
			return -1;
		
	}

}
