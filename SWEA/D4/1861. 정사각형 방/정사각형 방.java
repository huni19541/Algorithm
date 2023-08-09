import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	static int N;
	static int max;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			int roomNum = 0;
		
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cnt = 1;
					find(i, j);
					if(cnt > max) {
						roomNum = map[i][j];
						max = cnt;
					}
					else if(cnt == max) {
						roomNum = roomNum > map[i][j] ? map[i][j] : roomNum;
					}
				}
			}
			
			sb.append('#').append(tc).append(" ").append(roomNum).append(" ").append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void find(int col, int row) {
		int cur = map[col][row];
		
		for(int i=0; i<4; i++) {
			int nc = col + dc[i];
			int nr = row + dr[i];
			
			if(nc >= N || nc < 0 || nr >= N || nr < 0) continue;
			
			if(map[nc][nr] == (cur+1)) {
				cnt++;
				find(nc, nr);
				break;
			}
		}
	}

}