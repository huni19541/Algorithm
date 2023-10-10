import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int airCleaner = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if(input == -1) {
					airCleaner = i;
				}
			}
		}
		
		for(int t=1; t<=T; t++) {
			int[][] temp = new int[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					temp[i][j] += map[i][j];
					
					if(map[i][j] >= 5) {
						int diffuseCnt = 0;
						for(int k=0; k<4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
							diffuseCnt++;
							temp[nr][nc] += map[i][j]/5;
						}
						temp[i][j] -= ((map[i][j]/5)*diffuseCnt);
					}
				}
			}
			
			// 위쪽 바람
			int curr = airCleaner-2;
			int curc = 0;
			int dir = 0;
			while(true) {
				int nr = curr + dr[dir];
				int nc = curc + dc[dir];
				
				if(nr < 0 || nr >= airCleaner || nc < 0 || nc >= C) {
					dir++;
					continue;
				}
				
				if(map[nr][nc] == -1) break;
				
				temp[curr][curc] = temp[nr][nc];
				curr = nr;
				curc = nc;
			}
			temp[airCleaner-1][1] = 0;
			
			// 아래쪽 바람
			curr = airCleaner+1;
			curc = 0;
			dir = 2;
			while(true) {
				int nr = curr + dr[dir];
				int nc = curc + dc[dir];
				
				if(nr < airCleaner || nr >= R || nc < 0 || nc >= C) {
					dir--;
					if(dir < 0) {
						dir += 4;
					}
					continue;
				}
				
				if(map[nr][nc] == -1) break;
				
				temp[curr][curc] = temp[nr][nc];
				curr = nr;
				curc = nc;
			}
			temp[airCleaner][1] = 0;
			
			map = temp;
		}
		
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		sb.append(sum);
		System.out.println(sb);
	}

}