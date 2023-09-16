import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int idx = 0;
		int curSize = 0;
		int ans = 0;
		while(idx < S.length()) {
			if(S.charAt(idx) == 'O') {
				curSize = 0;
				idx++;
				continue;
			}
			
			else if(idx < S.length()-1 && S.charAt(idx) == 'I' && S.charAt(idx+1) == 'I') {
				if(curSize == N) {
					ans++;
				}
				curSize = 0;
				idx++;
				continue;
			}
			else if(idx == S.length()-1 && S.charAt(idx) == 'I' && curSize == N) {
				ans++;
				break;
			}
			
			if(curSize == N) {
				ans++;
			}
			
			curSize++;
			if(curSize > N) {
				curSize = N;
			}
			
			idx += 2;
		}
		
		sb.append(ans);
		System.out.println(sb);
	}

}