import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int maxAreaCnt;
	
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				max = Math.max(num, max);
				min = Math.min(num, min);
			}
		}
		
		for(int h=min-1; h<=max; h++) {
			cnt = 0;
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] || map[i][j] <= h) continue;
					visited[i][j] = true;
					find(i, j, h);
					cnt++;
				}
			}
			maxAreaCnt = Math.max(cnt, maxAreaCnt);
		}
		
		sb.append(maxAreaCnt);
		System.out.println(sb);
	}
	
	private static void find(int curc, int curr, int height) {
		for(int i=0; i<4; i++) {
			int nc = curc + dc[i];
			int nr = curr + dr[i];
			
			if(nc < 0 || nc >= N || nr < 0 || nr >= N || map[nc][nr] <= height || visited[nc][nr]) continue;
			
			visited[nc][nr] = true;
			find(nc, nr, height);
		}
	}
	
	
}