import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int cnt = Integer.MAX_VALUE;
	static int wallCnt;
	static CCTV[] cctv = new CCTV[8];
	static int cctvIdx;
	static int[] dr = {1, 0, -1, 0, 1, 0}; // 우 하 좌 상
	static int[] dc = {0, 1, 0, -1, 0, 1};
	
	static class CCTV{
		int num;
		int i;
		int j;
		
		CCTV(int num, int i, int j){
			this.num = num;
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 6)
					wallCnt++;
				
				if(num != 0 && num != 6) {
					cctv[cctvIdx++] = new CCTV(num, i, j);
				}
			}
		}
		
		find(0);
		sb.append(cnt);
		
		System.out.println(sb);
	}

	private static void find(int cctvCnt) {
		
		if(cctvCnt == cctvIdx) {
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0)
						count++;
				}
			}
			cnt = Math.min(cnt, count);
			return;
		}
		
		int cur = cctv[cctvCnt].num;
		int curc = cctv[cctvCnt].i;
		int curr = cctv[cctvCnt].j;
		
		int nc = 0, nr = 0;
		if(cur == 1) {
			for(int i=0; i<4; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[i];
					nr += dr[i];
				}
				
				find(cctvCnt+1);
				
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
				}
			}
		}
		else if(cur == 2) {
			for(int i=0; i<2; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[2+i];
				nr = curr + dr[2+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[2+i];
					nr += dr[2+i];
				}
				
				find(cctvCnt+1);
				
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[2+i];
				nr = curr + dr[2+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[2+i];
					nr += dr[2+i];
				}
			}
		}
		else if(cur == 3) {
			for(int i=0; i<4; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[1+i];
				nr = curr + dr[1+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[1+i];
					nr += dr[1+i];
				}
				
				find(cctvCnt+1);
				
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[1+i];
				nr = curr + dr[1+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[1+i];
					nr += dr[1+i];
				}
			}
		}
		else if(cur == 4) {
			for(int i=0; i<4; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[1+i];
				nr = curr + dr[1+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[1+i];
					nr += dr[1+i];
				}
				nc = curc + dc[2+i];
				nr = curr + dr[2+i];
				
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[2+i];
					nr += dr[2+i];
				}
				
				find(cctvCnt+1);
				
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
				}
				
				nc = curc + dc[1+i];
				nr = curr + dr[1+i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[1+i];
					nr += dr[1+i];
				}
				nc = curc + dc[2+i];
				nr = curr + dr[2+i];
				
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[2+i];
					nr += dr[2+i];
				}
			}
		}
		else {
			for(int i=0; i<4; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]--;
					nc += dc[i];
					nr += dr[i];
				}
			}
			
			find(cctvCnt+1);
			
			for(int i=0; i<4; i++) {
				nc = curc + dc[i];
				nr = curr + dr[i];
				while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] != 6) {
					if(map[nc][nr] <= 0)
						map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
				}
			}
		}
	}
}