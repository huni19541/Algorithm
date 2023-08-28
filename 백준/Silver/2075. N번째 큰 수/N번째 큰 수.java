import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] idx;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		idx = new int[N];
		for(int i=0; i<N; i++) {
			idx[i] = N-1;
		}
		
		int maxNum = 0;
		for(int c=0; c<N; c++) {
			maxNum = Integer.MIN_VALUE;
			int col = 0;
			for(int i=0; i<N; i++) {
				if(map[idx[i]][i] > maxNum) {
					maxNum = map[idx[i]][i];
					col = i;
				}
			}
			idx[col]--;
		}
		
		sb.append(maxNum);
		
		System.out.println(sb);

	}

}