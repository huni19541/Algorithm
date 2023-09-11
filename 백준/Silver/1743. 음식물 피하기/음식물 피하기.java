import java.io.*;
import java.util.*;

public class Main {
	
	static int max = Integer.MIN_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N, M, K, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				
				cnt = 1;
				visited[i][j] = true;
				
				find(i, j);
				max = Math.max(max, cnt);
			}
		}
		
		sb.append(max);
		System.out.println(max);
		
	}
	
	private static void find(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <= 0 || nr > N || nc <= 0 || nc > M || visited[nr][nc] || map[nr][nc] == 0) continue;
			
			visited[nr][nc] = true;
			cnt++;
			find(nr, nc);
		}
	}

}