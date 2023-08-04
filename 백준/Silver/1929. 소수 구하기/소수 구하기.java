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
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		for(int i=M; i<=N; i++) {
			boolean check = true;
			if(i == 1) check = false;
			
			for(int j=2; j*j<=i; j++) {
				if(i%j == 0) {
					check = false;
					break;
				}
			}
			
			if(check) sb.append(i).append('\n');
			
		}
		
		
		
		System.out.println(sb);
	}
}