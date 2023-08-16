import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int idx = 0, sum = 0, subSum = 0;
			while(idx < str.length()) {
				char c = str.charAt(idx);
				if(c == 'O') {
					subSum++;
					sum += subSum;
				}
				else {
					subSum = 0;
				}
				
				idx++;
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
	}

}