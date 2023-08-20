import java.io.*;
import java.util.*;

public class Main {
	
	static class Info{
		int priority;
		int idx;
		
		Info(int priority, int idx){
			this.priority = priority;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Info> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int p = Integer.parseInt(st.nextToken());
				pq.offer(p);
				queue.offer(new Info(p, i));
			}
			
			int cnt = 0;
			while(true) {
				int maxPriority = pq.poll().intValue();
				Info cur = null;
				
				while(true) {
					cur = queue.poll();
					if(cur.priority == maxPriority) {
						cnt++;
						break;
					}
					else queue.offer(cur);
				}
				
				if(cur.idx == M) {
					sb.append(cnt).append('\n');
					break;
				}
			}
			
		}
		
		System.out.println(sb);
	}

}