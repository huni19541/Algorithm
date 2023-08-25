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
	
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static Node[] adjList;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i][0] = i;
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new Node[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			for(int j=0; j<c; j++) {
				int num = Integer.parseInt(st.nextToken());
				adjList[i] = new Node(num, adjList[i]);
			}
		}
		
		for(int i=1; i<N; i++) {
			int[] flag = new int[N+1];
			
			for(int j=0; j<i; j++) {
				flag[N-j] = 1;
			}
			
			do {
				visited = new boolean[N+1];
				
				for(int j=1; j<=N; j++) {
					if(flag[j] == 1) visited[j] = true;
				}
				
				if(check()) {
					int sumA = 0, sumB = 0;
					for(int j=1; j<=N; j++) {
						if(visited[j]) {
							sumA += arr[j][1];
						}
						else {
							sumB += arr[j][1];
						}
					}
					min = Math.min(min, Math.abs(sumA - sumB));
				}
				
			} while(np(flag));
		}
		
		
		if(min != Integer.MAX_VALUE)
			sb.append(min);
		else
			sb.append(-1);
		System.out.println(sb);
	}
	
//	static void iter(int start, int cnt) {
//		if(cnt == 0) {
//			if(!remainCheck()) return;
//			
//			int sum1 = 0, sum2 = 0;
//			for(int i=1; i<=N; i++) {
//				if(visited[i])
//					sum1 += arr[i][1];
//				else
//					sum2 += arr[i][1];
//			}
//			min = Math.min(min, Math.abs(sum1-sum2));
//			
//			return;
//		}
//		
//		for(Node temp = adjList[start]; temp != null; temp = temp.next) {
//			if(!visited[temp.vertex]) {
//				
//				visited[temp.vertex] = true;
//				iter(temp.vertex, cnt-1);
//				visited[temp.vertex] = false;
//			}
//		}
//	}
	
	static boolean check() {
		boolean[] trueCheck = Arrays.copyOf(visited, visited.length);
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(trueCheck[i]) {
				trueCheck[i] = false;
				queue.offer(i);
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(Node n = adjList[cur]; n != null; n = n.next) {
				if(trueCheck[n.vertex]) {
					trueCheck[n.vertex] = false;
					queue.offer(n.vertex);
				}
			}
		}
		
		boolean check = true;
		for(int i=1; i<=N; i++) {
			if(trueCheck[i]) {
				check = false;
				break;
			}
		}
		
		if(!check) return false;

		boolean[] falseCheck = Arrays.copyOf(visited, visited.length);
		
		Queue<Integer> queue2 = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(!falseCheck[i]) {
				falseCheck[i] = true;
				queue2.offer(i);
				break;
			}
		}
		
		while(!queue2.isEmpty()) {
			int cur = queue2.poll();
			
			for(Node n = adjList[cur]; n != null; n = n.next) {
				if(!falseCheck[n.vertex]) {
					falseCheck[n.vertex] = true;
					queue2.offer(n.vertex);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!falseCheck[i]) {
				check = false;
				break;
			}
		}
		
		if(check) return true;
		else return false;
		
	}
	
	static boolean np(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i > 1 && p[i-1] >= p[i]) i--;
		if(i == 1) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = N-1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

}