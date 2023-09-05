import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] dist;
	static boolean[] visited;
	static ArrayList<Node>[] list;
    
    static class Node {
        int vertex;
        int cost;
        
        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, 1));
			list[b].add(new Node(a, 1));
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
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
		}
		
		sb.append(minIdx);
		
		System.out.println(sb);
	
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		visited = new boolean[N+1];
		
		dist[start][start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.vertex;
            
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node next : list[now]) {
				if(dist[start][next.vertex] > dist[start][now] + 1) {
					dist[start][next.vertex] = dist[start][now] + 1;
					pq.offer(new Node(next.vertex, dist[start][next.vertex]));
				}
			}
		}
	}

}
