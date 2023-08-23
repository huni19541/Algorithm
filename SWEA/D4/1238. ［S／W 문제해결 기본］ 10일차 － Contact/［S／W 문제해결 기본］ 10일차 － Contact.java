import java.io.*;
import java.util.*;

public class Solution {
	
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			st =  new StringTokenizer(br.readLine());
			
			
			int op = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i*2<op; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from]);
			}
			
			Queue<int[]> queue = new ArrayDeque<>();
			ArrayList<int[]> list = new ArrayList<>();
			visited = new boolean[101];
			
			queue.offer(new int[] {start, 0});
			visited[start] = true;
			
			while(!queue.isEmpty()) {
				int curNum = queue.peek()[0];
				int depth = queue.peek()[1];
				
				list.add(queue.poll());
				
				for(Node temp = adjList[curNum]; temp != null; temp = temp.next) {
					if(!visited[temp.vertex]) {
						queue.offer(new int[] {temp.vertex, depth+1});
						visited[temp.vertex] = true;
					}
				}
			}
			
			Collections.sort(list, (o1, o2) -> o1[1]==o2[1] ? o2[0]-o1[0] : o2[1]-o1[1]);
			
			sb.append('#').append(tc).append(" ").append(list.get(0)[0]).append('\n');
		}
		
		System.out.println(sb);
	}

}