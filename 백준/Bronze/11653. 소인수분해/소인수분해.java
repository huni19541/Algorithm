import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		while(N != 1) {
			for(int i=2; i<=N; i++) {
				if(N % i == 0) {
					sb.append(i).append('\n');
					N /= i;
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}