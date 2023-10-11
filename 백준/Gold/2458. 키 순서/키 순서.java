import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<Integer> adjList[];
	static int[] arrShort, arrTall;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			adjList[c].add(p);
		}
		
		arrShort = new int[N+1];
		arrTall = new int[N+1];
		find();
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int sum = (arrShort[i] + arrTall[i] - 1);
			if(sum == N) {
				ans++;
			}
		}
		
		sb.append(ans);
		System.out.println(sb);
	}
	
	private static void find() {
		for(int i=1; i<=N; i++) {
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			queue.offer(i);
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				if(visited[cur]) continue;
				visited[cur] = true;
				arrShort[cur]++;
				arrTall[i]++;
				
				for(int next : adjList[cur]) {
					if(!visited[next]) {
						queue.offer(next);
					}
				}
			}
		}
	}
}