import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			sb.setLength(0);
			deque.clear();
			
			AC();
		}
	}
	
	static void AC() throws IOException {
		boolean reverse = false;
		
		String p = br.readLine();
		int pLen = p.length();
		int n = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		
		if(n != 0) {
			String[] sArr = temp.substring(1, temp.length()-1).split(",");
			
			for(String s : sArr) {
				deque.add(Integer.valueOf(s));
			}
		}
		
			
		for(int i=0; i<pLen; i++) {
			char c = p.charAt(i);
			
			if(c == 'R') {
				reverse = (reverse == true) ? false : true;
			} else if(c == 'D') {
				if(deque.size() == 0) {
					System.out.println("error");
					return;
				}
				
				if(!reverse) {
					deque.pollFirst();
					n--;
				} else {
					deque.pollLast();
					n--;
				}
			}
		}
		
		if(n == 0) {
			System.out.println("[]");
			return;
		}
	
		sb.append('[');
		if(!reverse) {
			sb.append(deque.pollFirst());
			while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollFirst());
			}
			
		} else {
			sb.append(deque.pollLast());
			while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollLast());
			}
		}
		sb.append(']');
		System.out.println(sb);
	}
}
