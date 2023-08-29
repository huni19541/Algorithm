import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] dist;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dist = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1; i<=N; i++) {
			dijkstra(i);
		}
		
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				sum += dist[i][j];
			}
			if(sum < min) {
				min = sum;
				minIdx = i;
			}
		}
		
		sb.append(minIdx);
		
		System.out.println(sb);
	
	}
	
	static void dijkstra(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[N+1];
		
		dist[start][start] = 0;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(int next : list[cur]) {
				if(dist[start][next] > dist[start][cur] + 1) {
					dist[start][next] = dist[start][cur] + 1;
					q.offer(next);
				}
			}
		}
	}

}