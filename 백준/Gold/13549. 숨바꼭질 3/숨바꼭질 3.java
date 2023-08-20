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
	
	static class Info{
		int pos;
		int depth;
		int telpoCnt;
		
		Info(int pos, int depth, int telpoCnt){
			this.pos = pos;
			this.depth = depth;
			this.telpoCnt = telpoCnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// BFS로 풀이
		boolean[] visit = new boolean[100001];
		Queue<Info> queue = new LinkedList<>();
		
		queue.offer(new Info(N, 0, 0));
		visit[N] = true;
		
		int curPos, curDepth, curTelpoCnt;
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			curPos = cur.pos;
			curDepth = cur.depth;
			curTelpoCnt = cur.telpoCnt;
			
			if(curPos == K) {
				sb.append(curDepth-curTelpoCnt);
				break;
			}

			1 -> 2 의 경우 때문에 *2를 먼저 queue에 offer
			if(curPos <= 50000) {
				if(!visit[curPos*2]) {
					visit[curPos*2] = true;
					queue.offer(new Info(curPos*2, curDepth+1, curTelpoCnt+1));
				}
			}
			
			if(curPos > 0) {
				if(!visit[curPos-1]) {
					visit[curPos-1] = true;
					queue.offer(new Info(curPos-1, curDepth+1, curTelpoCnt));
				}
			}
			
			if(curPos < 100000) {
				if(!visit[curPos+1]) {
					visit[curPos+1] = true;
					queue.offer(new Info(curPos+1, curDepth+1, curTelpoCnt));
				}
			}
			
			
		}
		
		System.out.println(sb);
	}
		
}
