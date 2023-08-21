import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		Node adjList[] = new Node[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			
			arr[last]++;
			adjList[first] = new Node(last, adjList[first]);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			if(arr[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll().intValue();
			sb.append(cur).append(" ");
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				arr[temp.vertex]--;
				if(arr[temp.vertex] == 0)
					queue.offer(temp.vertex);
			}
		}
		
		if(N == 1 && M == 1)
			sb.append(1);
		
		System.out.println(sb);
	}

}