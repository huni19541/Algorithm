import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		
		int T = Integer.parseInt(br.readLine());

		Stack<Character> stack = new Stack<>();
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			if(check(stack, str))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		
		
		System.out.println(sb);
	}
	
	static boolean check(Stack<Character> stack, String str) {
		stack.clear();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.add(c);
			}
			else {
				if(stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		
		if(!stack.isEmpty()) return false;
		else return true;
	}
	
}