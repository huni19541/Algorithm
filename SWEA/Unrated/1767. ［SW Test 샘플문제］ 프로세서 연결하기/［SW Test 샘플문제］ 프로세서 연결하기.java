import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] map;
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {-1, 1, 0, 0};
	static ArrayList<Core> list;
	static int[] flag;
	static boolean[] visited;
	static int min;
	
	static class Core {
		int y;
		int x;
		
		public Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 1) {
						if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
						
						list.add(new Core(i, j));
					}
				}
			}
			
			o:
			for(int i=list.size(); i>=1; i--) {

				flag = new int[list.size()];
				for(int j=0; j<i; j++) {
					flag[list.size()-1-j] = 1;
				}
				
				do {
					find(i, 0, 0);
					
					if(min != Integer.MAX_VALUE)
						break o;
				} while(np(flag));
				
			}
			sb.append('#').append(tc).append(" ").append(min).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void find(int coreCnt, int lineCnt, int idx) {
		if(coreCnt == 0) {
			min = Math.min(lineCnt, min);
			return;
		}
		
		for(int c=idx; c<list.size(); c++) {
			if(flag[c] == 0) continue;

			int curc = list.get(c).y;
			int curr = list.get(c).x;
			
			for(int i=0; i<4; i++) {
				int nc = curc + dc[i];
				int nr = curr + dr[i];
				int cnt = 0;
				
				while(nc >= 0 && nc < N && nr >= 0 && nr < N && map[nc][nr] == 0) {
					map[nc][nr]--;
					cnt++;
					nc += dc[i];
					nr += dr[i];
				}
				
				if(nc == -1 || nc == N || nr == -1 || nr == N) {
					find(coreCnt-1, lineCnt+cnt, c+1);
				}
				
				nc = curc + dc[i];
				nr = curr + dr[i];
				
				while(cnt > 0) {
					map[nc][nr]++;
					nc += dc[i];
					nr += dr[i];
					
					cnt--;
				}
				
			}
		}
	}
	
	static boolean np(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		
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