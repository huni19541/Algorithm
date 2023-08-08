import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int N, M;
	static int[] dc = {0, 1, 0, -1}; // 좌 하 우 상
	static int[] dr = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] temp = new int[N][M];
		for(int i=0; i<R; i++) {
			rotate(0, 0, N, M, 1, temp);
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					map[y][x] = temp[y][x];
				}
			}
		}
		
		for(int[] arr : temp) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
	static void rotate(int startX, int startY, int N, int M, int dir, int[][] temp) {
		if(M <= 0 || N <= 0) return;
		
		int curY = startY, curX = startX;
		int nc = curY + dc[dir], nr = curX + dr[dir];
		
		while(!(nc == startY && nr == startX)) {
			
			nc = curY + dc[dir];
			nr = curX + dr[dir];
			
			if(nc >= startY+N || nr >= startX+M || nc < startY || nr < startX) {
//				if(N == 1 && M == 1) {
//					temp[curY][curX] = map[curY][curX];
//					return;
//				}
//				else if(N == 1) {
//					for(int i=0; i<M-1; i++) {
//						temp[curY][curX+i] = map[curY][curX+i+1];
//					}
//					temp[curY][curX+M-1] = map[curY][curX];
//					return;
//				}
//				else if(M == 1) {
//					temp[startY][startX] = map[curY][curX];
//					return;
//				}
				dir++;
				if(dir >= 4) dir -= 4;
				nc = curY + dc[dir];
				nr = curX + dr[dir];
			}
			
			temp[nc][nr] = map[curY][curX];
			curX = nr;
			curY = nc;
		}
		
		rotate(startX+1, startY+1, N-2, M-2, 1, temp);
		
	}

}