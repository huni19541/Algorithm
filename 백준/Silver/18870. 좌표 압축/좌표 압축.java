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
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
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
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[0] - o2[0];
		});
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(new int[] {Integer.parseInt(st.nextToken()), i});
		}
		
		int cnt = 0;
		int[] before = {Integer.MIN_VALUE, 0};
		
		int[] res = new int[N];
		for(int i=0; i<N; i++) {
			int[] temp = pq.poll();
			if(before[0] < temp[0])
				res[temp[1]] = cnt++;
			else
				res[temp[1]] = res[before[1]];
			before = temp;
		}
		
		for(int i=0; i<N; i++)
			sb.append(res[i]).append(" ");
	
		System.out.println(sb);
	}

}