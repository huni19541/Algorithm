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
		int[] trees = new int[N];

		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			trees[i] = num;
			end = Math.max(end, num);
		}
		
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(trees[i] > mid) {
					sum += (trees[i] - mid);
				}
			}
			
			if(sum >= M) {
				answer = mid;
				start = mid+1;
			}
			else
				end = mid-1;
		}
		sb.append(answer);
		
		System.out.println(sb);
	}

}