import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] flag = new int[N];
		for(int i=N/2; i<N; i++)
			flag[i] = 1;
		
		int res = Integer.MAX_VALUE;
		do {
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(flag[i] == 1 && flag[j] == 1)
						sum1 += map[i][j];
					if(flag[i] == 0 && flag[j] == 0)
						sum2 += map[i][j];
				}
			}
			
			res = Math.min(res, Math.abs(sum1-sum2));
			
		} while(NP(flag));

		sb.append(res);
		System.out.println(sb);
	}
	
	private static boolean NP(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = N-1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
}