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
		
//		64          64
//		32          0 -> 32
//		16 16       0 -> 32
//		16 8        16 -> 24
//		16 4 4      20 -> 24
//		16 4 2 2    22 -> 24
//		16 4 2 1    22 -> 23
		
		int target = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		stack.push(64);
		int curSum = 64;
		
		while(curSum != target) {
			int shortest = stack.pop();
			curSum -= shortest;
			
			stack.push(shortest/2);
			curSum += shortest/2;
			
			if(curSum < target) {
				stack.push(shortest/2);
				curSum += shortest/2;
			}
			
		}
		
		sb.append(stack.size());
		
		System.out.println(sb);
	}

}