import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, sum;
	static int[][] map;
	static int MAX = Integer.MIN_VALUE;
	
	static int[][] deltaW = new int[][]{{-1, 0}, {-1, 1}, {0, 2}, {1, 1}, {1, 0}, {0, -1}};
	static int[][] deltaH = new int[][]{{-1, 0}, {0, 1}, {1, 1}, {2, 0}, {1, -1}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				find(i, j);
			}
		}
		sb.append(MAX);
		
		System.out.println(sb);
	}
	
	private static void find(int curr, int curc) {
		findW(curr, curc);
		findH(curr, curc);
	}

	private static void findW(int curr, int curc) {
		sum = 0;
		
		sum += map[curr][curc];
		if(curc + 1 >= M) return;
		sum += map[curr][curc+1];
		
		int[] arr = new int[6];
		for(int i=0; i<2; i++) {
			arr[6-1-i] = 1;
		}
		
		do {
			int subSum = 0;
			int nr = 0, nc = 0;
			boolean check = true;
			for(int i=0; i<6; i++) {
				if(arr[i] == 1) {
					nr = curr + deltaW[i][0];
					nc = curc + deltaW[i][1];
					
					if(nr >= N || nr < 0 || nc >= M || nc < 0) {
						check = false;
						break;
					}
					
					subSum += map[nr][nc];
				}
			}
			if(!check) continue;
			
			MAX = Math.max(MAX, sum+subSum);
			
		} while(np(arr));
		
	}
	
	private static void findH(int curr, int curc) {
		sum = 0;
		
		sum += map[curr][curc];
		
		if(curr + 1 >= N) return;
		sum += map[curr+1][curc];
		
		int[] arr = new int[6];
		for(int i=0; i<2; i++) {
			arr[6-1-i] = 1;
		}
		
		do {
			int subSum = 0;
			int nr = 0, nc = 0;
			boolean check = true;
			for(int i=0; i<6; i++) {
				if(arr[i] == 1) {
					nr = curr + deltaH[i][0];
					nc = curc + deltaH[i][1];
					
					if(nr >= N || nr < 0 || nc >= M || nc < 0) {
						check = false;
						break;
					}
					
					subSum += map[nr][nc];
				}
			}
			if(!check) continue;
			
			MAX = Math.max(MAX, sum+subSum);
			
		} while(np(arr));
	}
	
	private static boolean np(int[] p) {
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