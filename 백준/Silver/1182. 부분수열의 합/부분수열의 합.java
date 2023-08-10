import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static boolean[] check;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		check = new boolean[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		for(int i=1; i<=N; i++) {
			find(0, 0, i);
		}
		sb.append(cnt);
		
		System.out.println(sb);
	}
	
	static void find(int idx, int selectCnt, int needCnt) {
		if(selectCnt == needCnt) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(check[i])
					sum += arr[i];
			}
			if(sum == S) cnt++;
			
			return;
		}
		
		for(int i=idx; i<N; i++) {
			
			if(!check[i]) {
				check[i] = true;
				find(i+1, selectCnt+1, needCnt);
				check[i] = false;
			}
		}
		
	}

}