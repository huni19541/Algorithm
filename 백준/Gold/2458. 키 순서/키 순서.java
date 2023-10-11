import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] adjMatrix;
	static int[] arrShort, arrTall;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[501][501];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			adjMatrix[c][p] = 1;
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
			boolean[] visited = new boolean[N+1];
			
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				if(visited[cur]) continue;
				visited[cur] = true;
				
				arrShort[cur]++;
				arrTall[i]++;
				for(int j=1; j<=N; j++) {
					if(adjMatrix[cur][j] == 1 && !visited[j]) {
						queue.offer(j);
					}
				}
			}
		}
	}
}