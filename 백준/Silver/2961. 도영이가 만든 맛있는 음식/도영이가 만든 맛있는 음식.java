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
	
	static boolean[] check;
	static int[] sourness;
	static int[] bitter;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		sourness = new int[N];
		bitter = new int[N];
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			sourness[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			find(0, i);
		}
		
		sb.append(min);
		System.out.println(sb);
		
	}
	
	static void find(int idx, int cnt) {
		if(cnt == 0) {
			int sourSum = 1, bitSum = 0;
			
			for(int i=0; i<N; i++) {
				if(check[i]) {
					sourSum *= sourness[i];
					bitSum += bitter[i];
				}
			}
			min = min > Math.abs(sourSum - bitSum) ? Math.abs(sourSum - bitSum) : min;
		}
		
		for(int i=idx; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				find(i+1, cnt-1);
				check[i] = false;
			}
		}
		
	}
	
	
	
}