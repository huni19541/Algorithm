import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static int[] drHorse = {1, 2, -1, 2, 1, -2, -1, -2}; // 우하 하우 우상 하좌 좌하 상우 좌상 상좌
	static int[] dcHorse = {2, 1, 2, -1, -2, 1, -2, -1};
	
	static int W, H, K;
	static int[][] map;
	static boolean[][][] visited;
	static int res = Integer.MAX_VALUE;
	
	static class monkey {
		int r;
		int c;
		int cnt;
		int remainK;
		
		public monkey(int r, int c, int cnt, int remainK) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.remainK = remainK;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find();
		if(res != Integer.MAX_VALUE) {
			sb.append(res);
		} else {
			sb.append(-1);
		}
		
		System.out.println(sb);
		
	}
	
	private static void find() {
		
		Queue<monkey> queue = new ArrayDeque<>();
		queue.offer(new monkey(0, 0, 0, K));
		
		while(!queue.isEmpty()) {
			monkey cur = queue.poll();
			
			if(cur.r == H-1 && cur.c == W-1) {
				res = cur.cnt;
				break;
			}
			
			int nr = 0, nc = 0;
			if(cur.remainK > 0) {
				for(int i=0; i<8; i++) {
					nr = cur.r + drHorse[i];
					nc = cur.c + dcHorse[i];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[nr][nc][K-cur.remainK+1]) continue;
					visited[nr][nc][K-cur.remainK+1] = true;
					queue.offer(new monkey(nr, nc, cur.cnt+1, cur.remainK-1));
				}
			}
			
			for(int i=0; i<4; i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[nr][nc][K-cur.remainK]) continue;
				
				visited[nr][nc][K-cur.remainK] = true;
				queue.offer(new monkey(nr, nc, cur.cnt+1, cur.remainK));
			}
		}
	}
	
}