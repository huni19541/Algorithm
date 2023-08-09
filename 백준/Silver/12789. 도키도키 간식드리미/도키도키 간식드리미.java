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
		st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		int min = 1;
		int qNum = 0, sNum = 0;
		while(!queue.isEmpty()) {
			
			if(!stack.isEmpty()) {
				sNum = stack.peek();
				if(sNum == min) {
					stack.pop();
					min++;
					continue;
				}
			}
			
			qNum = queue.poll();
			if(qNum == min) min++;
			else stack.push(qNum);
		}
		
		while(!stack.isEmpty()) {
			sNum = stack.peek();
			if(sNum == min) {
				stack.pop();
				min++;
			}
			else
				break;
		}
		
		if(stack.isEmpty())
			sb.append("Nice");
		else
			sb.append("Sad");
		
		System.out.println(sb);
	}

}