import java.io.*;
import java.util.*;

public class Main {

	static int N, ans;
	static int[] col;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		ans = 0;
	
		setQueen(1);
		sb.append(ans);
		System.out.println(sb);
	}

	// 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) { // row : 퀸을 놓으려는 행

		// 기저조건
		if(row>N) {
			ans++;
			return;
		}
		
		for(int c=1; c<=N; c++) { // 1열부터 N열까지 시도
			col[row] = c;
			
			// 가지치기
			if(!isAvailable(row)) continue;
			setQueen(row+1);
		}
		
	}
	
	private static boolean isAvailable(int row) { // row : 마지막으로 놓아진 퀸의 행
		for(int i=1; i<row; i++) {
			if(col[i] == col[row] || row-i == Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		return true;
	}
}