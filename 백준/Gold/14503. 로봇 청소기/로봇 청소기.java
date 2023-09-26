import java.io.*;
import java.util.*;

public class Main {
	
	static int[] robot = new int[2];
	static int robotDir;
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		robot[0] = Integer.parseInt(st.nextToken());
		robot[1] = Integer.parseInt(st.nextToken());
		robotDir = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 		
		find(robot[0], robot[1], robotDir);
		
		sb.append(cnt);
		System.out.println(sb);
		
	}
	
	private static boolean find(int curr, int curc, int curDir) {
		
		if(map[curr][curc] == 0) {
			map[curr][curc] = -1;
			cnt++;
		}
		
		boolean check = false;
		
		for(int i=0; i<4; i++) {
			int nr = curr + dr[i];
			int nc = curc + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || map[nr][nc] == -1) continue;
			
			check = true;
			break;
		}
		
		if(!check) {
			int tempDir = curDir + 2;
			if(tempDir > 3) {
				tempDir -= 4;
			}
			
			int nr = curr + dr[tempDir];
			int nc = curc + dc[tempDir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1) return false;
			
			if(!find(nr, nc, curDir)) return false;
		}
		else {
			
			for(int i=0; i<4; i++) {
				curDir--;
				if(curDir < 0) {
					curDir += 4;
				}
				
				int nr = curr + dr[curDir];
				int nc = curc + dc[curDir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || map[nr][nc] == -1) continue;
				
				if(!find(nr, nc, curDir)) return false;
			}
		}
		return true;
	}
	 
}