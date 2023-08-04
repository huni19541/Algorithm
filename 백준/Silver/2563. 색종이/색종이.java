import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		boolean[][] map = new boolean[101][101];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map[y+i][x+j] = true;
				}
			}
		}
		
		int area = 10000;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(!map[i][j]) area--;
			}
		}
		
		System.out.println(area);
	}
		
}