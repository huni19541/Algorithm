import java.io.*;
import java.util.*;

public class Main {

	static int W, H;
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dc = { -1, 1, 0, 0, -1, -1, 1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0)
				break;

			cnt = 0;
			map = new int[H][W];
			visit = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						visit[i][j] = true;
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int i, int j) {
		
		for (int k = 0; k < 8; k++) {
			int nc = i + dc[k];
			int nr = j + dr[k];

			if (nc < 0 || nc >= H || nr < 0 || nr >= W || visit[nc][nr] || map[nc][nr] == 0)
				continue;

			visit[nc][nr] = true;
			dfs(nc, nr);
		}
	}

}