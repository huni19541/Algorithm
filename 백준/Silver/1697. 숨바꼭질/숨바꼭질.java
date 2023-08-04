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
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100001];
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {N, 0});
		visit[N] = true;
		
		int curPos, curDepth;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			curPos = cur[0];
			curDepth = cur[1];
			if(curPos == K) {
				sb.append(curDepth);
				break;
			}
			if(curPos > 0) {
				if(!visit[curPos-1]) {
					visit[curPos-1] = true;
					queue.offer(new int[] {curPos-1, curDepth+1});
				}
			}
			
			if(curPos < 100000) {
				if(!visit[curPos+1]) {
					visit[curPos+1] = true;
					queue.offer(new int[] {curPos+1, curDepth+1});
				}
			}
			
			if(curPos <= 50000) {
				if(!visit[curPos*2]) {
					visit[curPos*2] = true;
					queue.offer(new int[] {curPos*2, curDepth+1});
				}
			}
		}
		
		System.out.println(sb);
	}
		
}