import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		
		
		int N = Integer.parseInt(br.readLine());
		String comment;
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			comment = br.readLine();
			
			if(comment.startsWith("push")) {
				String[] temp;
				temp = comment.split(" ");
				stack.add(Integer.parseInt(temp[1]));
			}
			else if(comment.equals("top")) {
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek()).append('\n');
			}
			else if(comment.equals("size")) {
				sb.append(stack.size()).append('\n');
			}
			else if(comment.equals("empty")) {
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(comment.equals("pop")) {
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop()).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}