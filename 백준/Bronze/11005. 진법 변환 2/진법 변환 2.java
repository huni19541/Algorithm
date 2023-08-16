import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		while(N > 0) {
			int num = N % B;
			
			if(num >= 10) {
				sb.append((char)(num+55));
			}
			else
				sb.append(num);
			
			N /= B;
		}
		sb.reverse();
		
		System.out.println(sb);
	}

}