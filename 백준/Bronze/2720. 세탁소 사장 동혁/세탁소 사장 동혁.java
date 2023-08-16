import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] arr = {25, 10, 5, 1};
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int C = Integer.parseInt(br.readLine());
			int[] res = new int[4];
			
			for(int i=0; i<4; i++) {
				while(C >= arr[i]) {
					C -= arr[i];
					res[i]++;
				}
			}
			
			for(int i=0; i<4; i++) sb.append(res[i]).append(" ");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}