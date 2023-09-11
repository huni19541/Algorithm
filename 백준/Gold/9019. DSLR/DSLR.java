import java.io.*;
import java.util.*;

public class Main {

	static class oper {
		int value;
		String str;
		
		public oper(int value, String str) {
			this.value = value;
			this.str = str;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int source = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			Queue<oper> queue = new ArrayDeque<>();
			queue.offer(new oper(D(source), "D"));
			queue.offer(new oper(S(source), "S"));
			queue.offer(new oper(L(source), "L"));
			queue.offer(new oper(R(source), "R"));
			
			while(!queue.isEmpty()) {
				oper cur = queue.poll();
				int v = cur.value;
				
				if(v == target) {
					sb.append(cur.str).append('\n');
					break;
				}
				
				if(visited[v]) continue;
				
				visited[v] = true;
				
				queue.offer(new oper(D(v), cur.str+"D"));
				queue.offer(new oper(S(v), cur.str+"S"));
				queue.offer(new oper(L(v), cur.str+"L"));
				queue.offer(new oper(R(v), cur.str+"R"));
			}
			
		}
		
		System.out.println(sb);

	}

	
	private static int D(int n) {
		return n*2 > 9999 ? (n*2)%10000 : n*2;
	}
	
	private static int S(int n) {
		return n == 0 ? 9999 : n-1;
	}
	
	private static int L(int n) {
		
		int temp = n % 1000;
		int append = n / 1000;
		
		return temp * 10 + append;
	}
	
	private static int R(int n) {
		
		int temp = n / 10;
		int append = n % 10;
		
		return temp + append*1000;
	}
}