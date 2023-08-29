import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] dist;
	
	static class Node{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Node>();
		}
		visited = new boolean[V+1];
		dist = new int[V+1];
		for(int i=1; i<=V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}
		
		dijkstra(start);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] != Integer.MAX_VALUE) {
				sb.append(dist[i]).append('\n');
			}
			else
				sb.append("INF\n");
		}
	
		System.out.println(sb);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.vertex]) continue;
			
			visited[cur.vertex] = true;
			for(Node next : list[cur.vertex]) {
				if(dist[next.vertex] > dist[cur.vertex] + next.weight) {
					dist[next.vertex] = dist[cur.vertex] + next.weight;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}
}