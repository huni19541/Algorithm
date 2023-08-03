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
	static int cnt = 0;
	static int zeroCnt = 0;
	static int day = 0;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		Queue<Info> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {;
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.add(new Info(j, i, 0));
				}
				else if(map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			day = day < cur.depth ? cur.depth : day;
			
			int curX = cur.x;
			int curY = cur.y;
			
			for(int i=0; i<4; i++) {
				int ny = curY + dy[i];
				int nx = curX + dx[i];
				
				if(ny >= 0 && ny <N && nx >= 0 && nx < M) {
					if(map[ny][nx] == 0 && !visit[ny][nx]) {
						visit[ny][nx] = true;
						queue.add(new Info(nx, ny, cur.depth+1));
						cnt++;
					}
				}
			}
		}
		
		if(cnt == zeroCnt)
			sb.append(day);
		else
			sb.append("-1");
		System.out.println(sb);
	}
	
}