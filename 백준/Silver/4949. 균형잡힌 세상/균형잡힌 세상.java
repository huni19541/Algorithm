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
		
		String str;
		
		while(!(str=br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			char c;
			boolean check = true;
			int idx = 0;
			while(!((c = str.charAt(idx)) == '.')) {
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				
				if(c == ')') {
					if(stack.isEmpty()) {
						check = false;
						break;
					}
					
					if(stack.pop() != '(') {
						check = false;
						break;
					}
				}
				
				if(c == ']') {
					if(stack.isEmpty()) {
						check = false;
						break;
					}
					
					if(stack.pop() != '[') {
						check = false;
						break;
					}
				}
				
				idx++;
			}
			
			if(!stack.isEmpty()) check = false;
			
			if(check) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb);
	}

}