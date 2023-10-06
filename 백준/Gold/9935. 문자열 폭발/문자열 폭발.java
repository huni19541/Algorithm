import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		Stack<Character> body = new Stack<>();
		Stack<Integer> cnt = new Stack<>();
	
		for(int i=T.length-1; i>=0; i--) {
			char cur = T[i];
			body.push(cur);
			
			if(cnt.isEmpty() || cnt.peek() < 0) {
				if(cur == P[P.length-1]) {
					if(P.length-1 == 0) {
						body.pop();
						continue;
					}
					cnt.push(P.length-1);
				} else {
					if(!cnt.isEmpty() && cnt.peek() < 0)
						cnt.push(-1);
				}
			}
			else {
				
				if(cur == P[cnt.peek()-1]) {
					int prev = cnt.pop();
					
					if(prev == 1) {
						for(int j=0; j<P.length; j++) {
							body.pop();
						}
					} else {
						cnt.push(prev-1);
					}
				} else if(cur == P[P.length-1]) {
					cnt.push(P.length-1);
				} else {
					cnt.push(-1);
				}
			}
		}
		
		int size = body.size();
		if(size == 0) {
			sb.append("FRULA");
		} else {
			for(int i=0; i<size; i++) {
				sb.append(body.pop());
			}
		}
		
		System.out.println(sb);
		
	}
	
}