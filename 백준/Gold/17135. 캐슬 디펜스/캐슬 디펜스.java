import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {0, -1, 0}; // 좌 상 우
	static int[] dc = {-1, 0, 1};
	static int N, M, D;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int totalEnemyCnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if(input == 1) {
					totalEnemyCnt++;
				}
			}
		}
		
		int[] flag = new int[M];
		for(int i=0; i<3; i++) {
			flag[M-1-i] = 1;
		}
		
		int res = 0;
		do {
			int enemyCnt = totalEnemyCnt;
			int cnt = 0;
			int[][] temp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			int[] archer = new int[3];
			int archerIdx = 0;
			for(int i=0; i<M; i++) {
				if(flag[i] == 1) {
					archer[archerIdx++] = i;
				}
			}

			ArrayList<int[]> enemies;
			while(enemyCnt > 0) {
				
				enemies = new ArrayList<>();
				
				for(int i=0; i<3; i++) {
					Queue<int[]> queue = new ArrayDeque<>();
					queue.offer(new int[] {N-1, archer[i], 1});
					
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						
						if(temp[cur[0]][cur[1]] == 1) {
							enemies.add(new int[] {cur[0], cur[1]});
							break;
						}
						
						if(cur[2] == D) continue;
						
						for(int j=0; j<3; j++) {
							int nr = cur[0] + dr[j];
							int nc = cur[1] + dc[j];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							
							queue.offer(new int[] {nr, nc, cur[2]+1});
						}
					}
				}
				
				for(int i=0; i<enemies.size(); i++) {
					int[] enemy = enemies.get(i);
					if(temp[enemy[0]][enemy[1]] == 1) {
						temp[enemy[0]][enemy[1]] = 0;
						cnt++;
						enemyCnt--;
					}
				}
				
				for(int i=0; i<M; i++) {
					if(temp[N-1][i] == 1) {
						enemyCnt--;
					}
				}
				for(int i=N-2; i>=0; i--) {
					for(int j=0; j<M; j++) {
						temp[i+1][j] = temp[i][j];
					}
				}
				for(int i=0; i<M; i++) {
					temp[0][i] = 0;
				}
			}
			
			res = Math.max(res, cnt);
			
		} while(np(flag));
		
		sb.append(res);
		
		System.out.println(sb);
		
	}
	
	private static boolean np(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = N-1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
	
}