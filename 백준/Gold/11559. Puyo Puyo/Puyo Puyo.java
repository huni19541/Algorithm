import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		char[][] map = new char[12][6];
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 폭발이 일어나지 않을 때 까지 실행
		int ans = 0;
		while(true) {
			boolean check = false;
			boolean[][] visited = new boolean[12][6];
			
			// 4개 이상이 붙어 있는지 확인
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(map[i][j] != '.' && !visited[i][j]) {
						char curChar = map[i][j];
						
						// 4개 이상이 붙어있는지 확인하기 위한 bfs
						Queue<int[]> queue = new ArrayDeque<>();
						queue.offer(new int[] {i, j});
						
						// 터져야 할 뿌요들의 좌표를 저장할 list
						ArrayList<int[]> list = new ArrayList<>();
						list.add(new int[] {i, j});
						visited[i][j] = true;
						
						// bfs 탐색
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
						
						// 4개 이상이 붙어있는 경우 폭발
						if(list.size() >= 4) {
							if(!check) ans++;
							check = true;
							for(int[] arr : list) {
								map[arr[0]][arr[1]] = '.';
							}
						}
					}
				}
			}
			
			// 폭발이 일어나지 않을 경우 break
			if(!check) break;
			
			// 폭발 후 map 내리기
			int[] idx = new int[6];
			for(int i=0; i<6; i++) {
				idx[i] = 11;
			}
			
			for(int j=0; j<6; j++) {
				for(int i=11; i>=0; i--) {
					if(map[i][j] != '.' && i != idx[j]) {
						map[idx[j]--][j] = map[i][j];
						map[i][j] = '.';
					} else if(map[i][j] != '.' && i == idx[j]) {
						idx[j]--;
					}
				}
			}
		}
		sb.append(ans);
		
		System.out.println(sb);
	}
	
}
