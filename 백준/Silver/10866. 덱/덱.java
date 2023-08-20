import java.io.*;
import java.util.*;

public class Main {
	
	static class MyDeque{
		static LinkedList<Integer> list = new LinkedList<>();
		static int size = 0;
		
		static void push_front(int v) {
			list.addFirst(v);
			size++;
		}
		
		static void push_back(int v) {
			list.addLast(v);
			size++;
		}
		
		static int pop_front() {
			if(size == 0)
				return -1;
			size--;
			return list.removeFirst();
		}
		
		static int pop_back() {
			if(size == 0)
				return -1;
			size--;
			return list.removeLast();
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
			if(str.startsWith("push_front")) {
				MyDeque.push_front(Integer.parseInt(str.split(" ")[1]));
			}
			else if(str.startsWith("push_back")) {
				MyDeque.push_back(Integer.parseInt(str.split(" ")[1]));
			}
			else if(str.equals("pop_front")) {
				sb.append(MyDeque.pop_front()).append('\n');
			}
			else if(str.equals("pop_back")) {
				sb.append(MyDeque.pop_back()).append('\n');
			}
			else if(str.equals("size")) {
				sb.append(MyDeque.size()).append('\n');
			}
			else if(str.equals("empty")) {
				sb.append(MyDeque.empty()).append('\n');
			}
			else if(str.equals("front")) {
				sb.append(MyDeque.front()).append('\n');
			}
			else if(str.equals("back")) {
				sb.append(MyDeque.back()).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}