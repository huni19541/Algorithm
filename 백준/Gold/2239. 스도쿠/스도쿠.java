import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		} 
		
		find(0, 0, 0);

		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static boolean find(int curr, int curc, int cnt) {
		if(cnt == 81) {
			return true;
		}

		int nr = curr;
		int nc = curc + 1;
		if(nc >= 9) {
			nc = 0;
			nr++;
		}
		
		if(map[curr][curc] != 0) {
			if(find(nr, nc, cnt+1)) return true;
		}
		else {
			boolean[] width = new boolean[10];
			boolean[] height = new boolean[10];
			boolean[] area = new boolean[10];
			
			// 가로 확인
			for(int i=0; i<9; i++) {
				if(map[curr][i] != 0) {
					width[map[curr][i]] = true;
				}
			}
			
			// 세로 확인
			for(int i=0; i<9; i++) {
				if(map[i][curc] != 0) {
					height[map[i][curc]] = true;
				}
			}
			
			// 속한 영역 확인
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(map[(curr/3)*3+i][(curc/3)*3+j] != 0) {
						area[map[(curr/3)*3+i][(curc/3)*3+j]] = true;
					}
				}
			}
			
			for(int i=1; i<=9; i++) {
				if(!width[i] && !height[i] && !area[i]) {
					map[curr][curc] = i;
					if(find(nr, nc, cnt+1)) return true;
					map[curr][curc] = 0;
				}
			}
			
		}
		
		return false;
	}

}