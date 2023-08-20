import java.io.*;
import java.util.*;

public class Main {
	
	static class MyQueue{
		static LinkedList<Integer> list = new LinkedList<>();
		static int size = 0;
		
		static void push(int v) {
			list.add(v);
			size++;
		}
		
		static int pop() {
			if(size == 0)
				return -1;
			size--;
			return list.removeFirst();
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
		
		static int front() {
			if(size == 0)
				return -1;
			return list.get(0);
		}
		
		static int back() {
			if(size == 0)
				return -1;
			return list.get(size-1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.startsWith("push")) {
				MyQueue.push(Integer.parseInt(str.split(" ")[1]));
			}
			
			else if(str.equals("pop")) {
				sb.append(MyQueue.pop()).append('\n');
			}
			else if(str.equals("size")) {
				sb.append(MyQueue.size()).append('\n');
			}
			else if(str.equals("empty")) {
				sb.append(MyQueue.empty()).append('\n');
			}
			else if(str.equals("front")) {
				sb.append(MyQueue.front()).append('\n');
			}
			else if(str.equals("back")) {
				sb.append(MyQueue.back()).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}