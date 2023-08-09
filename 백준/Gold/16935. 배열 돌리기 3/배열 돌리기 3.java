import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[] dr = {1, 0, -1, 0}; // 우 하 좌 상
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			int operation = Integer.parseInt(st.nextToken());
			int rowCnt = map.length;
			int colCnt = map[0].length;
			switch(operation) {
			case 1:
				func1(rowCnt, colCnt);
				break;
			case 2:
				func2(rowCnt, colCnt);
				break;
			case 3:
				func3(rowCnt, colCnt);
				break;
			case 4:
				func4(rowCnt, colCnt);
				break;
			case 5:
				func5(rowCnt, colCnt);
				break;
			case 6:
				func6(rowCnt, colCnt);
				break;
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				sb.append(map[i][j]).append(" ");
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void func1(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				map[i][j] = temp[rowCnt-1-i][j];
	}
	
	static void func2(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				map[i][j] = temp[i][colCnt-1-j];
	}
	
	static void func3(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		
		int[][] temp2 = new int[colCnt][rowCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp2[j][rowCnt-1-i] = temp[i][j];
		map = temp2;
	}
	
	static void func4(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		
		int[][] temp2 = new int[colCnt][rowCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp2[colCnt-1-j][i] = temp[i][j];
		map = temp2;
	}
	
	static void func5(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		int nc = 0, nr = 0, dir = 0;
		for(int i=0; i<rowCnt; i++) {
			for(int j=0; j<colCnt; j++) {
				if(i < rowCnt/2) {
					if(j < colCnt/2) dir = 0;
					else dir = 1;
				}
				else {
					if(j < colCnt/2) dir = 3;
					else dir = 2;
				}
				
				nc = i + dc[dir]*(rowCnt/2);
				nr = j + dr[dir]*(colCnt/2);
				
				map[nc][nr] = temp[i][j];
			}
		}
	}
	
	static void func6(int rowCnt, int colCnt) {
		int[][] temp = new int[rowCnt][colCnt];
		for(int i=0; i<rowCnt; i++)
			for(int j=0; j<colCnt; j++)
				temp[i][j] = map[i][j];
		
		int nc = 0, nr = 0, dir = 0;
		for(int i=0; i<rowCnt; i++) {
			for(int j=0; j<colCnt; j++) {
				if(i < rowCnt/2) {
					if(j < colCnt/2) dir = 1;
					else dir = 2;
				}
				else {
					if(j < colCnt/2) dir = 0;
					else dir = 3;
				}
				
				nc = i + dc[dir]*(rowCnt/2);
				nr = j + dr[dir]*(colCnt/2);
				
				map[nc][nr] = temp[i][j];
			}
		}
		
		
		
	}

}