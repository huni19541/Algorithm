import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	static int white, blue;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		DQ(N, 0, 0);
		
		sb.append(white).append('\n');
		sb.append(blue).append('\n');
		System.out.println(sb);
	}
	
	private static void DQ(int N, int startR, int startC) {
		if(N == 0) return;
		
		if(check(N, startR, startC, 0) || check(N, startR, startC, 1)) {
			return;
		}
		
		DQ(N/2, startR, startC);
		DQ(N/2, startR, startC+N/2);
		DQ(N/2, startR+N/2, startC);
		DQ(N/2, startR+N/2, startC+N/2);
		
	}
	
	private static boolean check(int N, int startR, int startC, int num) {
		for(int i=startR; i<startR+N; i++) {
			for(int j=startC; j<startC+N; j++) {
				if(map[i][j] != num) {
					return false;
				}
			}
		}
		
		if(num == 1) blue++;
		else white++;
		return true;
	}
}