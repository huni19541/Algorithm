import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] B = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			int[] flag = new int[N];
			for(int j=0; j<i; j++) {
				flag[N-1-j] = 1;
			}
			
			do {
				int sumS = 1;
				int sumB = 0;
				for(int j=0; j<N; j++) {
					if(flag[j] == 1) {
						sumS *= S[j];
						sumB += B[j];
					}
				}
				
				min = Math.min(min, Math.abs(sumS - sumB));
				
			} while(np(flag));
		}
		sb.append(min);
		System.out.println(min);
		
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