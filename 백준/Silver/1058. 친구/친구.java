import java.io.*;
import java.util.*;

public class Main {
	
	static int cnt, N;
	static char[][] adjMatrix;
	static boolean[] visited;
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			cnt = 0;
			visited = new boolean[N];
			visited[i] = true;
			find(i);
			MAX = Math.max(MAX, cnt);
		}
		
		sb.append(MAX);
		System.out.println(sb);
	
	}

	private static void find(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			if(i == start) continue;
			
			if(adjMatrix[start][i] == 'Y') {
				cnt++;
				visited[i] = true;
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i=0; i<N; i++) {
				if(visited[i] || adjMatrix[cur][i] == 'N') continue;
			
				visited[i] = true;
				cnt++;
			}
		}
	}
}