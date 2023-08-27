import java.io.*;
import java.util.*;

public class Main {
	
	static int N, H;
	static ArrayList<Integer>[] list;
	static int[][] parent;
	static int[] depth;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			H = getTreeHeight();
			
			list = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			parent = new int[N+1][H];
			depth = new int[N+1];
			
			// 입력으로 부모노드와 자식노드의 정보가 들어옴 -> parent[x][0] 바로 초기화
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine());
				
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list[p].add(c);
				parent[c][0] = p;
			}
			
			// 루트 노드 번호 찾기
			int root = 0;
			for(int i=1; i<=N; i++) {
				if(parent[i][0] == 0) {
					root = i;
					break;
				}
			}
			
			// depth 채우기
			fillDepth(root, 1, 0);
			fillParents();			
			
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
	
	static void fillDepth(int cur, int h, int par) {
		depth[cur] = h;
		
		for(int next : list[cur]) {
			if(next != par) {
				depth[next] = h+1;
				fillDepth(next, h+1, cur);
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
		// 오른쪽 노드의 깊이가 더 깊게 전처리
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		// 높이 맞추기
		for(int i=H-1; i>=0; i--) {
			if(depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i];
			}
		}
		
		if(a == b) return a;
		
		// 공통 조상 찾기
		for(int i=H-1; i>=0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}

}