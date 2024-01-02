import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		queue.offer(new int[] {start, 0});
		int res = -1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0] == end) {
				res = cur[1];
				break;
			}
			
			int temp = 1;
			int next = 0;
			while((next = (cur[0] - arr[cur[0]]*temp)) >= 1) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(new int[] {next, cur[1]+1});
				}
				temp++;
			}
			
			temp = 1;
			while((next = (cur[0] + arr[cur[0]]*temp)) <= N) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(new int[] {next, cur[1]+1});
				}
				temp++;
			}
		}
		
		sb.append(res);
		System.out.println(sb);
	}
	
}