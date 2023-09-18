import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] sharkPos;
	static int[] dr = {-1, 0, 0, 1}; // 상 좌 우 하
	static int[] dc = {0, -1, 1, 0};
	static int curSize = 2;
	static int eatCount = 0;
	static int ans = 0;
	static PriorityQueue<Info> pq;
	static Queue<Info> queue;
	static boolean[][] visited;
	
	static class Info {
		int row;
		int col;
		int dist;
		
		public Info(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
								
				if(map[i][j] == 9) {
					sharkPos = new int[] {i, j};
					map[i][j] = 0;
				} 
			}
		}
		
		while(true) {
			pq = new PriorityQueue<>((o1, o2) -> {
				return o1.dist==o2.dist ? 
						(o1.row==o2.row ? Integer.compare(o1.col, o2.col) : Integer.compare(o1.row, o2.row))
						: Integer.compare(o1.dist, o2.dist);
			});
			queue = new ArrayDeque<>();
			visited = new boolean[N][N];	
			queue.offer(new Info(sharkPos[0], sharkPos[1], 0));
			find();
			
			if(pq.isEmpty()) break;
			
			Info info = pq.poll();
			ans += info.dist;
			sharkPos[0] = info.row;
			sharkPos[1] = info.col;
			eatCount++;
			if(eatCount == curSize) {
				curSize++;
				eatCount = 0;
			}
			map[info.row][info.col] = 0;
		}
		
		sb.append(ans);
		
		System.out.println(sb);
	}
	
	private static void find() {
		
		int minDist = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			
			if(info.dist > minDist) break;
			
			if(map[info.row][info.col] != 0 && map[info.row][info.col] < curSize) {
				pq.offer(new Info(info.row, info.col, info.dist));
				minDist = info.dist;
			}
			
			for(int i=0; i<4; i++) {
				int nr = info.row + dr[i];
				int nc = info.col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > curSize || visited[nr][nc]) continue;

				visited[nr][nc] = true;
				queue.offer(new Info(nr, nc, info.dist+1));
				
			}
		}
		
	}

}