import java.util.Scanner;

public class Main {

	final static int[] dc = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상 하 좌 우 좌상 우상 좌하 우하
	final static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상 하 좌 우 좌상 우상 좌하 우하

	static int W, H;
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			check = new boolean[H][W];

			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();

			int res = find(0, 0);
			System.out.println(res);
		}

	}

	static int find(int col, int row) {
		int cnt = 0;
		for (int i = col; i < H; i++) {
			for (int j = row; j < W; j++) {
				if (check[i][j] == true || map[i][j] == 0)
					continue;

				if (check[i][j] == false && map[i][j] == 1) {
					check[i][j] = true;
					iter(i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

	static void iter(int i, int j) {
		for (int k = 0; k < 8; k++) {
			int nc = i + dc[k];
			int nr = j + dr[k];

			if (nc >= 0 && nc < H && nr >= 0 && nr < W) {
				if (check[nc][nr] == false && map[nc][nr] == 1) {
					check[nc][nr] = true;
					iter(nc, nr);
				}
			}
		}
	}

}
