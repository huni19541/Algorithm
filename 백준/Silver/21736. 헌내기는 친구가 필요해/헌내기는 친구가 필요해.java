import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, curr, curc, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dr = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'I') {
					curr = i;
					curc = j;
				}
			}
		}
		
		visited[curr][curc] = true;
		find(curr, curc);

		if(cnt != 0) {
			sb.append(cnt);
		}
		else
			sb.append("TT");
		
		System.out.println(sb);
		
	}
	
	static void find(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'X' || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 'P') cnt++;
			visited[nr][nc] = true;
			find(nr, nc);
		}
	}

}