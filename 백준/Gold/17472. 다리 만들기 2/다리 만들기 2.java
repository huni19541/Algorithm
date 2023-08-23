import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {-1, 1, 0, 0};
	static int islandNum = 1;
	static int[][] islands;
	static int[] parents;
	
	static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					map[i][j] = islandNum;
					numbering(i, j);
					islandNum++;
				}
			}
		}
		
		islands = new int[islandNum][islandNum];
		for(int i=1; i<islandNum; i++) {
			for(int j=1; j<i; j++) {
				islands[i][j] = Integer.MAX_VALUE;
			}
		}
		findWeight();
		
		ArrayList<Edge> list = new ArrayList<>();
		for(int i=1; i<islandNum; i++) {
			for(int j=1; j<i; j++) {
				if(islands[i][j] == Integer.MAX_VALUE || islands[i][j] == 0) continue;
				
				list.add(new Edge(i, j, islands[i][j]));
			}
		}
		Collections.sort(list, (o1, o2) -> o1.weight-o2.weight);

		parents = new int[islandNum];
		make();
		
		int result = 0;
		int count = 0;
		for(Edge edge : list) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == (islandNum-2)) break;
			}
		}
		if(count == (islandNum-2))
			sb.append(result);
		else
			sb.append(-1);
		
		System.out.println(sb);
		
	}
	
	private static void numbering(int curc, int curr) {
		for(int i=0; i<4; i++) {
			int nc = curc + dc[i];
			int nr = curr + dr[i];
			
			if(nc < 0 || nc >= N || nr < 0 || nr >= M)
				continue;
			if(visited[nc][nr] || map[nc][nr] == 0) 
				continue;
			
			visited[nc][nr] = true;
			map[nc][nr] = islandNum;
			numbering(nc, nr);
		}
	}
	
	private static void findWeight() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(map[i][j] != 0) {
					int cur = map[i][j];
					
					for(int k=0; k<4; k++) {
						int cnt = 0;
						int nc = i + dc[k];
						int nr = j + dr[k];
						
						while(nc >= 0 && nc < N && nr >= 0 && nr < M && map[nc][nr] == 0) {
							cnt++;
							nc += dc[k];
							nr += dr[k];
						}
						if(nc < 0 || nc >= N || nr < 0 || nr >= M || cnt == 0 || cnt == 1) continue;
						
						int neighbor = map[nc][nr];
						islands[cur][neighbor] = Math.min(islands[cur][neighbor], cnt);
					}
				}
			}
		}
	}
	
	private static void make() {
		for(int i=0; i<islandNum; i++)
			parents[i] = i;
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}