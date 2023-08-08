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
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		int[] appendRow = new int[N+1];
		int[] appendCol = new int[M+1];
		
		int first, num, v;
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			if(first == 1) {
				appendRow[num] += v;
			}
			else if(first == 2) {
				appendCol[num] += v;
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] += appendRow[i];
				map[i][j] += appendCol[j];
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
				
		System.out.println(sb);
	}

}