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
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static class MyStack{
		static LinkedList<Integer> nums = new LinkedList<>();
		static int size = 0;
		
		static void push(int n) {
			nums.add(0, n);
			size++;
		}
		
		static int pop() {
			if(size == 0) {
				return -1;
			}
			else {
				size--;
				return nums.pollFirst();
			}
		}
		
		static int size() {
			return size;
		}
		
		static int empty() {
			if(size == 0)
				return 1;
			else
				return 0;
		}
		
		static int top() {
			if(size == 0)
				return -1;
			else
				return nums.get(0);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.startsWith("push")) {
				String[] strs = str.split(" ");
				MyStack.push(Integer.parseInt(strs[1]));
				continue;
			}
			if(str.equals("pop")) {
				sb.append(MyStack.pop());
			}
			else if(str.equals("top")) {
				sb.append(MyStack.top());
			}
			else if(str.equals("size")) {
				sb.append(MyStack.size());
			}
			else if(str.equals("empty")) {
				sb.append(MyStack.empty());
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
