import java.io.*;
import java.util.*;

public class test {
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static int N, M;
	static int map[][];
	static boolean[][] visited;
	static int maxArea = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 64C3 조합 -> next permutation 활용
		int[] flag = new int[N*M];
		for(int i=0; i<3; i++) {
			flag[N*M-1-i] = 1;
		}
		
		do {
			boolean check = true;
			
			// 뽑은 3개가 전부 0이 아니라면 다시 조합뽑기
			for(int i=0; i<N*M; i++) {
				if(flag[i] == 1) {
					if(map[i/M][i%M] == 1 || map[i/M][i%M] == 2) {
						check = false;
						break;
					}
				}
			}
			
			// 뽑은 3개가 전부 0인 경우
			if(check) {
				// 벽 세우기
				for(int i=0; i<N*M; i++) {
					if(flag[i] == 1) {
						map[i/M][i%M] = 1;
					}
				}
				
				visited = new boolean[N][M];
				maxArea = Math.max(maxArea, find());
				
				// 원상복구
				for(int i=0; i<N*M; i++) {
					if(flag[i] == 1) {
						map[i/M][i%M] = 0;
					}
				}
			}
			
		} while(np(flag));
		
		sb.append(maxArea);
		
		System.out.println(sb);
		
	}
	
	// maxArea 찾는 메소드
	private static int find() {
		// dfs탐색을 하면서 map의 저장내용을 변경해야 하므로 map을 복사한 temp 사용
		int[][] temp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		// 바이러스 확산 재귀 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2 && !visited[i][j]) {
					dfs(i, j, temp);
				}
			}
		}
		
		// 남아있는 안전영역 찾아서 리턴
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j] == 0) {
					sum++;
				}
			}
		}
		
		return sum;
	}
	
	// 일반적인 4방향 탐색 재귀 메소드
	private static void dfs(int curr, int curc, int[][] map) {
		map[curr][curc] = 2;
		
		for(int k=0; k<4; k++) {
			int nr = curr + dr[k];
			int nc = curc + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, map);
		}
	}
	
	private static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) j--;
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		return true;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
