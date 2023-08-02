import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] arr;
	static int arrIdx = 0;
	static boolean[] check;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		check = new boolean[N+1];
		find(1, 0);
		
		System.out.println(sb);
	}
	
	public static void find(int idx, int cnt) {
		if(cnt == M) {
			for(int i=0; i<arrIdx; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			check[i] = true;
			arr[arrIdx++] = i;
			find(i+1, cnt+1);
			check[i] = false;
			arrIdx--;
		}
	}

}