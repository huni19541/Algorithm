import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static class Info{
		int x;
		int y;
		int depth;
		
		Info(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dx = {1, 0, -1, 0}; // 우 하 좌 상
	static int min;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String[] strs = br.readLine().split("");
			for(int j=0; j<M; j++) {;
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(0, 0, 1));
		while(!(queue.peek().y == N-1 && queue.peek().x == M-1)) {
			Info cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny >= 0 && ny <N && nx >= 0 && nx < M) {
					if(map[ny][nx] == 1 && !visit[ny][nx]) {
						visit[ny][nx] = true;
						queue.add(new Info(nx, ny, cur.depth+1));
					}
				}
			}
		}
		
		sb.append(queue.peek().depth);
		System.out.println(sb);
	}
	
}