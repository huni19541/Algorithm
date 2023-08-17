import java.io.*;
import java.util.*;

public class Main {

	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dc = { -1, 0, 1 }; // 우상 우 우하

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visit = new boolean[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		for (int i = 1; i <= R; i++) {
			visit[i][1] = true;
			pipe(i, 1);
		}
		sb.append(cnt);

		System.out.println(cnt);
	}

	private static boolean pipe(int y, int x) {
		
		if(x == C) {
			cnt++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = x+1;
			int nc = y+dc[i];
			
			if(nr > C || nc <= 0 || nc > R || map[nc][nr] == 'x' || visit[nc][nr]) continue;
			
			visit[nc][nr] = true;
			
			if(pipe(nc, nr))
				return true;
		
		}
		
		return false;
	}

}