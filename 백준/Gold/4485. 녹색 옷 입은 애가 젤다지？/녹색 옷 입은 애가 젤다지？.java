import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	static int[][] dist;
	
	static class Info {
		int r;
		int c;
		int w;
		
		public Info(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int problem = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra(0, 0);
			
			
			sb.append("Problem ").append(problem).append(": ").append(dist[N-1][N-1]).append('\n');
			problem++;
		}
		
		System.out.println(sb);
	}
	
	private static void dijkstra(int startR, int startC) {
		dist[startR][startC] = map[startR][startC];
		
		boolean[][] visited = new boolean[N][N];
		
		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
		pq.offer(new Info(startR, startC, dist[startR][startC]));
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(visited[cur.r][cur.c]) continue;
			visited[cur.r][cur.c] = true;
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]) {
					dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
					pq.offer(new Info(nr, nc, dist[nr][nc]));
				}
			}
		}
		
	}

}