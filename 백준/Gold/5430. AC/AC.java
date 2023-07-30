import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		outer:
		for(int i=0; i<T; i++) {
			boolean reverse = false;
			sb.setLength(0);
			
			Deque<Integer> deque = new ArrayDeque<>();
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
			
			
			for(int j=0; j<pLen; j++) {
				char c = p.charAt(j);
				
				if(c == 'R') {
					reverse = (reverse == true) ? false : true;
				} else if(c == 'D') {
					if(deque.size() == 0) {
						System.out.println("error");
						continue outer;
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
				continue;
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

}
