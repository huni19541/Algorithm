import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] map;
	static int[] inject;
	static int D, W, K;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			inject = new int[D];
//			Arrays.fill(inject, -1);
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			
			sb.append('#').append(tc).append(" ").append(min).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	
	private static void dfs(int idx, int cnt) {
		
		if(idx == D) {
			if(check()) {
				min = Math.min(min, cnt);
			}
			return;
		}
		
		if(cnt >= min) return;
		
		// 해당 열에 주입 X
		inject[idx] = -1;
		dfs(idx+1, cnt);
		
		// 해당 열에 0 주입
		inject[idx] = 0;
		dfs(idx+1, cnt+1);
		
		// 해당 열에 1 주입
		inject[idx] = 1;
		dfs(idx+1, cnt+1);
		
	}
	 
	
	private static boolean check() {
		boolean check = true;
		
		for(int i=0; i<W; i++) {
			int cnt = 0;
			int prev = 0;
			boolean temp = false;
			for(int j=0; j<D; j++) {
				if(j == 0) {
					cnt++;
					if(cnt >= K) {
						temp = true;
						break;
					}
					prev = (inject[j] == -1 ? map[j][i] : inject[j]);
				} else {
					int cur = (inject[j] == -1 ? map[j][i] : inject[j]);
					if(prev != cur) {
						prev = cur;
						cnt = 1;
					} else {
						cnt++;
						if(cnt >= K) {
							temp = true;
							break;
						}
					}
				}
			}
			
			if(!temp) {
				check = false;
				break;
			}
		}
		
		
		return check;
	}
}