import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int row = 0;
		int col = 0;
		
		int[][] map = new int[9][9];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) {
					max = map[i][j];
					row = i;
					col = j;
				}
			}
		}
		
		sb.append(max).append('\n').append(row+1).append(" ").append(col+1);
		
		System.out.println(sb);
	}
	
}