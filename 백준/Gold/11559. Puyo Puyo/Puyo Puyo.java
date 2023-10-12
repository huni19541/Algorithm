import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		map = new char[12][6];
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		while(true) {
			boolean check = false;
			boolean[][] visited = new boolean[12][6];
			char[][] temp = new char[12][6];
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(map[i][j] != '.' && !visited[i][j]) {
						char curChar = map[i][j];
						Queue<int[]> queue = new ArrayDeque<>();
						queue.offer(new int[] {i, j});
						ArrayList<int[]> list = new ArrayList<>();
						list.add(new int[] {i, j});
						visited[i][j] = true;
						
						while(!queue.isEmpty()) {
							int[] cur = queue.poll();
							
							for(int k=0; k<4; k++) {
								int nr = cur[0] + dr[k];
								int nc = cur[1] + dc[k];
								
								if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc] || map[nr][nc] != curChar) continue;
								
								queue.offer(new int[] {nr, nc});
								list.add(new int[] {nr, nc});
								visited[nr][nc] = true;
							}	
						}
						
						if(list.size() >= 4) {
							if(!check) ans++;
							check = true;
							for(int[] arr : list) {
								temp[arr[0]][arr[1]] = '.';
							}
						}
					}
				}
			}
			
			if(!check) break;
			
			int[] idx = new int[6];
			for(int i=0; i<6; i++) {
				idx[i] = 11;
			}
			
			for(int j=0; j<6; j++) {
				for(int i=11; i>=0; i--) {
					if(temp[i][j] != '.' && i != idx[j]) {
						temp[idx[j]--][j] = temp[i][j];
						temp[i][j] = '.';
					} else if(temp[i][j] != '.' && i == idx[j]) {
						idx[j]--;
					}
				}
			}
			
			map = temp;
		}
		sb.append(ans);
		
		System.out.println(sb);
	}
	
}