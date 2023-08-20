import java.io.*;
import java.util.*;

public class Main {

	static int count = 15;
	static int[][] match = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, 
							{1, 2}, {1, 3}, {1, 4}, {1, 5}, 
							{2, 3}, {2, 4}, {2, 5}, 
							{3, 4}, {3, 5}, 
							{4, 5}};
	static int[][] record;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			boolean check = true;
			int winSum = 0, loseSum = 0;
			record = new int[6][3];

			for (int i = 0; i < 6; i++) {
				int winRec, drawRec, loseRec;

				winRec = Integer.parseInt(st.nextToken());
				drawRec = Integer.parseInt(st.nextToken());
				loseRec = Integer.parseInt(st.nextToken());
				winSum += winRec;
				loseSum += loseRec;
				record[i][0] = winRec;
				record[i][1] = drawRec;
				record[i][2] = loseRec;

				if ((winRec + drawRec + loseRec) != 5)
					check = false;
			}

			if (!check || (winSum != loseSum)) {
				sb.append("0 ");
				continue;
			}

			if (find(0, 0))
				sb.append("1 ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);
	}

	private static boolean find(int idx, int cnt) {
		if (cnt == count) {
			return true;
		}

		int teamA = match[idx][0];
		int teamB = match[idx][1];

		// A 승리 & B 패배
		if (record[teamA][0] > 0 && record[teamB][2] > 0) {
			record[teamA][0]--;
			record[teamB][2]--;
			if (find(idx + 1, cnt + 1))
				return true;
			record[teamA][0]++;
			record[teamB][2]++;
		}

		// A 무승부 & B 무승부
		if (record[teamA][1] > 0 && record[teamB][1] > 0) {
			record[teamA][1]--;
			record[teamB][1]--;
			if (find(idx + 1, cnt + 1))
				return true;
			record[teamA][1]++;
			record[teamB][1]++;
		}

		// A 패배 & B 승리
		if (record[teamA][2] > 0 && record[teamB][0] > 0) {
			record[teamA][2]--;
			record[teamB][0]--;
			if (find(idx + 1, cnt + 1))
				return true;
			record[teamA][2]++;
			record[teamB][0]++;
		}

		return false;
	}

}