import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] pattern = new char[][] {
		{'#', '#', '#', '#', '.', '#', '#', '.', '#', '#', '.', '#', '#', '#', '#'},
		{'.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.'},
		{'#', '#', '#', '.', '.', '#', '#', '#', '#', '#', '.', '.', '#', '#', '#'},
		{'#', '#', '#', '.', '.', '#', '#', '#', '#', '.', '.', '#', '#', '#', '#'},
		{'#', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#', '.', '.', '#'},
		{'#', '#', '#', '#', '.', '.', '#', '#', '#', '.', '.', '#', '#', '#', '#'},
		{'#', '#', '#', '#', '.', '.', '#', '#', '#', '#', '.', '#', '#', '#', '#'},
		{'#', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '#'},
		{'#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#', '#'},
		{'#', '#', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#', '#', '#', '#'}
	};
		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[5][N/5+2];
		
		String input = br.readLine();
		for(int i=0; i<5; i++) {
			for(int j=0; j<N/5+2; j++) {
				if(j == 0 || j == N/5+1) {
					map[i][j] = '.';
					continue;
				}
				
				map[i][j] = input.charAt((N/5)*i + (j-1));
			}
		}
		
		int idx = 0;
		
		while(idx < (N/5)) {
			
			boolean check = false;
			int append = 0;
			
			inner:
			for(int i=0; i<10; i++) {
				for(int r=0; r<5; r++) {
					for(int c=idx; c<idx+3; c++) {
						if(map[r][c] != pattern[i][(3*r)+(c-idx)]) {
							continue inner;
						}
					}
				}
				
				check = true;
				append = i;
				sb.append(i);
				break;
			}
			
			if(check && append != 1) idx += 3;
			else if(check && append == 1) idx += 2;
			else idx++;
		}
		
		System.out.println(sb);

	}

}