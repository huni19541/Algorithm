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
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(find(N));
		
		//System.out.println(sb);
	}
	
	static int find(int N) {
		boolean check = false;
		int res = 0;
		
		for(int i=1; i<=N; i++) {
			int num = i;
			int sum = num;
			
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum == N) {
				check = true;
				res = i;
				break;
			}
		}
		
		return res;
	}
		
}