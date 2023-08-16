import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N + 1][M + 1];
		char[] board = { 'W', 'B', 'W' };

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= N - 7; i++) {
			for (int j = 1; j <= M - 7; j++) {
				
				for(int t=0; t<2; t++) {
					cnt = 0;
					for (int k = i; k < i + 8; k++) {
						for (int w = j; w < j + 8; w++) {
							if ((k % 2 == 1 && w % 2 == 1) || (k % 2 == 0 && w % 2 == 0)) {
								if (map[k][w] != board[t + 0])
									cnt++;
							} else if ((k % 2 == 1 && w % 2 == 0) || (k % 2 == 0 && w % 2 == 1)) {
								if (map[k][w] != board[t + 1])
									cnt++;
							}

						}
					}
					
					min = Math.min(min, cnt);
				}
				
			}

		}

		sb.append(min);

		System.out.println(sb);
	}

}