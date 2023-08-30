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
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		int min = Integer.MAX_VALUE;
		do {
			int sum = 0;
			boolean check = true;
			for(int i=0; i<N-1; i++) {
				if(map[arr[i]][arr[i+1]] == 0) {
					check = false;
					break;
				}
				
				sum += map[arr[i]][arr[i+1]];
			}
			if(!check) continue;
			if(map[arr[N-1]][arr[0]] == 0) continue;
			
			sum += map[arr[N-1]][arr[0]];
			min = Math.min(min, sum);
			
		} while(np(arr));
		
		sb.append(min);
		
		System.out.println(sb);
	}

	
	static boolean np(int[] p) {
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
	
	static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
}