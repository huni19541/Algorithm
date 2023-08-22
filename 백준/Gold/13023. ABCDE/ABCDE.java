import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static boolean[] visited;
	static int N, M;
	static Node[] adjList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		adjList = new Node[N];
		
		for(int f=0; f<M; f++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}
		
		boolean check = false;
		for(int i=0; i<M; i++) {
			visited[i] = true;
			if(dfs(i, 0)) {
				check = true;
				break;
			}
			visited[i] = false;
		}
		if(check) sb.append(1);
		else sb.append(0);
		
		System.out.println(sb);
	}
	
	static boolean dfs(int number, int cnt) {
		if(cnt == 4) {
			return true;
		}
		
		for(Node temp=adjList[number]; temp!=null; temp = temp.next) {
			if(!visited[temp.vertex]) {
				visited[temp.vertex] = true;
				if(dfs(temp.vertex, cnt+1))
					return true;
				visited[temp.vertex] = false;
			}
		}
		
		return false;
	}
	

}