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
	
	static int[] arr = new int[9];
	static boolean[] check = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		find(0, 0, 0);
		
	}
	
	static void find(int idx, int cnt, int sum) {
		if(cnt == 7) {
			if(!(sum == 100))
				return;
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				if(check[i]) sb.append(arr[i]).append('\n');
			}
			
			System.out.println(sb);
			return;
		}
		
		for(int i=idx; i<9; i++) {
			if(!check[i]) {
				check[i] = true;
				find(i+1, cnt+1, sum+arr[i]);
				check[i] = false;
			}
		}
	}
}