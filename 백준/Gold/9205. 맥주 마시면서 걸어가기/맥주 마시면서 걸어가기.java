import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			visited = new boolean[n+2];
			adjList = new ArrayList[n+2];
			for(int i=0; i<n+2; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			arr = new int[n+2][2];
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i == j) continue;
					
					if(dist(arr[i][0], arr[i][1], arr[j][0], arr[j][1])) {
						adjList[i].add(j);
					}
				}
			}
			
			visited[0] = true;
			if(find(0)) sb.append("happy\n");
			else sb.append("sad\n");
			
		}
		
		System.out.println(sb);
	}
	
	private static boolean find(int cur) {
		if(cur == n+1) {
			return true;
		}
		
		for(int i=0; i<adjList[cur].size(); i++) {
			if(!visited[adjList[cur].get(i)]) {
				visited[adjList[cur].get(i)] = true;
				if(find(adjList[cur].get(i))) return true;
			}
		}
		
		return false;
	}
	
	private static boolean dist(int x1, int y1, int x2, int y2) {
		
		int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
		
		if(dist <= 1000) return true;
		else return false;
	}
	

}