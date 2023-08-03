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
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static int res = 0;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while((stack.isEmpty() || stack.peek() < num) && cnt <= N) {
				stack.add(cnt++);
				sb.append('+').append('\n');
			}
			
			if(stack.isEmpty() || (stack.peek() < num && cnt > N)) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
			while(stack.peek() >= num) {
				stack.pop();
				sb.append('-').append('\n');
				
				if(stack.isEmpty()) break;
			}
			
		}
		
		
	
		
		System.out.println(sb);
	}
	
}