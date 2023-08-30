import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		char[] arr = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int col = arr.length;
		int row = arr2.length;
		
		int[][] map = new int[row+1][col+1];
		for(int i=0; i<col; i++) {
			map[0][i] = 0;
		}
		for(int i=0; i<row; i++) {
			map[i][0] = 0;
		}
		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				if(arr[j-1] == arr2[i-1]) {
					map[i][j] = map[i-1][j-1] + 1;
				}
				else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		sb.append(map[row][col]);
		
		System.out.println(sb);
	
	}

}