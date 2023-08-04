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
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		String str;
		for(int i=0; i<N; i++) {
			str = br.readLine();
			
			if(str.startsWith("1")) {
				stack.push(Integer.parseInt(str.substring(2, str.length())));
			}
			else if(str.equals("2")) {
				if(!stack.isEmpty()) sb.append(stack.pop()).append('\n');
				else sb.append("-1").append('\n');
			}
			else if(str.equals("3")) {
				sb.append(stack.size()).append('\n');
			}
			else if(str.equals("4")) {
				if(stack.isEmpty()) sb.append(1).append('\n');
				else sb.append("0").append('\n');
			}
			else if(str.equals("5")) {
				if(!stack.isEmpty()) sb.append(stack.peek()).append('\n');
				else sb.append("-1").append('\n');
			}
		}
		
		
		
		System.out.println(sb);
	}
		
}