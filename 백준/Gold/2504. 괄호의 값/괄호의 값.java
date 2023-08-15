import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		int idx = 0, sum = 0, temp = 1;
		boolean check = true;
		while(idx < str.length()) {
			char c = str.charAt(idx);
			
			if(c == '(') {
				stack.push(c);
				temp *= 2;
			}
			else if(c == '[') {
				stack.push(c);
				temp *= 3;
			}
			else if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					check = false;
					break;
				}
				if(str.charAt(idx-1) == '(')
					sum += temp;
				temp /= 2;
				stack.pop();
				
			}
			else if(c == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					check = false;
					break;
				}
				if(str.charAt(idx-1) == '[')
					sum += temp;
				temp /= 3;
				stack.pop();
			}
			
			idx++;
		}
		if(!stack.isEmpty()) check = false;
		
		if(check) sb.append(sum);
		else sb.append(0);
	
		System.out.println(sb);
	}

}