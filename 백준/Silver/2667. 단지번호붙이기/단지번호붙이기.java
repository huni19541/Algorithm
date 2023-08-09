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
	
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {-1, 1, 0, 0};
	static int cnt;
	static int complexCnt = 0;
	public static void main(String[] args) throws IOException {
		
		
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		String[] strs;
		for(int i=0; i<N; i++) {
			strs = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		ArrayList<Integer> cntList = new ArrayList<>();
		int number = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					complexCnt++;
					cnt = 1;
					find(i, j, number);
					number++;
					cntList.add(cnt);
				}
			}
		}
		
		Collections.sort(cntList);
		sb.append(complexCnt).append('\n');
		for(int i : cntList)
			sb.append(i).append('\n');
		
		System.out.println(sb);
	}
	
	static void find(int y, int x, int number) {
		for(int i=0; i<4; i++) {
			int nc = y + dc[i];
			int nr = x + dr[i];
			
			if(nc < 0 || nc >= N || nr < 0 || nr >= N) continue;
			
			if(!visit[nc][nr] && map[nc][nr] == 1) {
				visit[nc][nr] = true;
				cnt++;
				map[nc][nr] = number;
				find(nc, nr, number);
			}
			
			
		}
	}

}